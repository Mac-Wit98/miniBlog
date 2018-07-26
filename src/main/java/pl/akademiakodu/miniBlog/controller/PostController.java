package pl.akademiakodu.miniBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akademiakodu.miniBlog.dao.CommentDao;
import pl.akademiakodu.miniBlog.dao.PostDao;
import pl.akademiakodu.miniBlog.model.Comment;
import pl.akademiakodu.miniBlog.model.Post;
@Controller
public class PostController {

    @Autowired
    private PostDao postDao;
    @Autowired
    private CommentDao commentDao;


    @GetMapping("/posts/add")
    public String addPost(){
        return "posts/add";
    }

    @PostMapping("/posts/add")
    public String createPost(@ModelAttribute Post post, ModelMap modelMap){
        postDao.save(post);
        return "redirect:/posts/add";
    }
    @GetMapping("/posts/all")
    public String all(ModelMap modelMap){
        modelMap.put("posts", postDao.findAll());
        return "posts/all";
    }
    @GetMapping("/posts/{id}")
    public String show(@PathVariable Integer id, ModelMap modelMap){
        modelMap.put("post", postDao.findById(id).get());
        return "posts/show";

    }
    @PostMapping("/posts/addComment")
    public String addComment(@ModelAttribute Comment comment){
        commentDao.save(comment);
        return "success";
    }

}
