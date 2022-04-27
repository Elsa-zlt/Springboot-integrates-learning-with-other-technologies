package top.Elsa;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.Elsa.mapper.BookMapper;
import top.Elsa.pojo.Book;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class ElasticsearchApplicationTests {
//    @Autowired
//    private ElasticsearchRestTemplate esTemplate;
    @Autowired
    private BookMapper bookMapper;
    private RestHighLevelClient client;
    // json转换工具
    private static ObjectMapper objectMapper;

    @Test
    public void testConnect() throws IOException {
        HttpHost host = HttpHost.create("http://localhost:9200");
        RestClientBuilder builder = RestClient.builder(host);
        client = new RestHighLevelClient(builder);

        client.close();
    }

    @Test
    // 创建索引
    public void testCreateIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("books");
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    @Test
    // 使用IK分词器创建索引
    public void testCreateIndexByIK() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("books");
        // 设置请求参数
        String jsonParam = "{\n" +
                "    \"mappings\": {\n" +
                "        \"properties\": {\n" +
                "            \"id\": {\n" +
                "                \"type\": \"keyword\"\n" +
                "            },\n" +
                "            \"name\": {\n" +
                "                \"type\": \"text\",\n" +
                "                \"analyzer\": \"ik_max_word\",\n" +
                "                \"copy_to\": \"all\"\n" +
                "            },\n" +
                "            \"type\": {\n" +
                "                \"type\": \"keyword\"\n" +
                "            },\n" +
                "            \"description\": {\n" +
                "                \"type\": \"text\",\n" +
                "                \"analyzer\": \"ik_max_word\",\n" +
                "                \"copy_to\": \"all\"\n" +
                "            },\n" +
                "            \"all\": {\n" +
                "                \"type\": \"text\",\n" +
                "                \"analyzer\": \"ik_max_word\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        request.source(jsonParam, XContentType.JSON);
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    @Test
    public void testCreateDoc() throws Exception {
        Book book = bookMapper.selectById(1);

        IndexRequest request = new IndexRequest("books").id(book.getId() + "");
        String jsonParams = objectMapper.writeValueAsString(book);
        request.source(jsonParams, XContentType.JSON);
        client.index(request, RequestOptions.DEFAULT);
    }

    @Test
    // 将mysql数据库tbl_book表中的数据都存到es中
    public void testCreateDocAllFromMySQL() throws Exception {
        List<Book> books = bookMapper.selectList(null);
        // 批处理请求，相当于一个request容器，可以把单个请求加进来
        BulkRequest requests = new BulkRequest();
        for (Book book : books) {
            IndexRequest request = new IndexRequest("books").id(book.getId() + "");
            String jsonParams = objectMapper.writeValueAsString(book);
            request.source(jsonParams, XContentType.JSON);
            requests.add(request);
        }
        client.bulk(requests, RequestOptions.DEFAULT);
    }

    @Test
    // 按ID查询
    public void testGet() throws IOException {
        GetRequest request = new GetRequest("books", "1");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        System.out.println("book:" + response.getSourceAsString());
    }

    @Test
    public void testSearch() throws IOException {
        SearchRequest request = new SearchRequest("books");

        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.termQuery("all", "spring"));
        request.source(builder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
    }

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        HttpHost host = HttpHost.create("http://localhost:9200");
        RestClientBuilder builder = RestClient.builder(host);
        client = new RestHighLevelClient(builder);
    }

    @AfterEach
    void tearDown() throws IOException {
        client.close();
    }
}
