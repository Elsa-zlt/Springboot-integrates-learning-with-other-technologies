package top.Elsa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/19--12:57
 * @Description
 */
@Controller
public class User1Controller {
    @RequestMapping(value = "/users1", method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody User user) {
        System.out.println("user1 save...");
        return "{'module':'user1 save'}";
    }

    @RequestMapping(value = "/users1/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable Integer id) {
        System.out.println("user1 delete..." + id);
        return "{'module':'user1 delete'}";
    }

    @RequestMapping(value = "/users1", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody User user) {
        System.out.println("user1 update..." + user);
        return "{'module':'user1 update'}";
    }

    @RequestMapping(value = "/users1/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getById(@PathVariable Integer id) {
        System.out.println("user1 getById..." + id);
        return "{'module':'user1 getById'}";
    }

    @RequestMapping(value = "/users1", method = RequestMethod.GET)
    @ResponseBody
    public String getAll() {
        System.out.println("user1 getAll...");
        return "{'module':'user1 getAll'}";
    }
}
