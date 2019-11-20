package com.nowcoder.community.controller;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.Page;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Song Weiwei
 * @date 2019-11-18
 * 首页
 */

@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;  //查到的userId只是一个id

    @Autowired
    private UserService userService;    //通过id把详细数据查询到

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    //可以返回ModelAndView,也可以返回视图的名字
    public String getIndexPage(Model model, Page page) {
        //  方法调用之前，SpringMVC会自动实例化Model和Page，并将Page注入Model.
        //  所以，在thtmeleaf中可以直接访问Page对象中的数据
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> list = discussPostService.findDiscussPosts(0,page.getOffset(),page.getLimit());
        List<Map<String, Object>> discussPosts = new ArrayList<>(); //能够封装帖子post和用户User对象
        if(list != null) {
            for (DiscussPost post: list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);  //装入帖子
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);  //装入user
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts", discussPosts);
        //返回模板的路径，resource->templates->index.html
        return "/index";

    }

}
