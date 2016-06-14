/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa545.project.controller;

import edu.mum.waa545.project.serviceimpl.PostServiceImpl;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dipen
 */
@Controller()
public class UploadController {

    @RequestMapping(value = "uploader.spring", method = RequestMethod.POST)
    public ModelAndView upload(HttpServletRequest request, @RequestParam CommonsMultipartFile[] uploadedFiles) throws IOException {
        List<String> images = new ArrayList<>();
        for (CommonsMultipartFile uploadFile : uploadedFiles) {
            String fullPath = request.getServletContext().getRealPath("redirect.jsp");
            fullPath = fullPath.substring(0, fullPath.length() - 12) + "/uploadedFolder/";
            if (uploadFile.getOriginalFilename() != null && !uploadFile.getOriginalFilename().isEmpty()) {
                uploadFile.transferTo(new File(fullPath + uploadFile.getOriginalFilename()));
            }
            images.add("uploadedFolder/" + uploadFile.getOriginalFilename());
        }
        postService.addPost(images, request.getParameterMap());
        request.setAttribute("posts", postService.getPosts());
        return new ModelAndView("home");
    }

    @RequestMapping(value = "upload.spring", method = RequestMethod.GET)
    public ModelAndView getPage(String upload) {
        return new ModelAndView("home");
    }

    @Autowired
    PostServiceImpl postService;

    @RequestMapping(value = "home.spring", method = RequestMethod.GET)
    public ModelAndView getHomePage(HttpServletRequest request) {
        request.setAttribute("posts", postService.getPosts());
        System.out.println("Posts::::: " + postService.getPosts());
        return new ModelAndView("home");
    }

    @RequestMapping(value = "addChildren.spring", method = RequestMethod.POST)
    public ModelAndView addChildrenPost(HttpServletRequest request) {
        String parentPostId = request.getParameter("parentPostId");
        String childComment = request.getParameter("childComment");
        postService.addChildrenPost(parentPostId, childComment);
        request.setAttribute("posts", postService.getPosts());
        return new ModelAndView("home");
    }

    @RequestMapping(value = "removeChildren.spring", method = RequestMethod.POST)
    public ModelAndView removeChildrenPost(HttpServletRequest request) {
        String parentPostId = request.getParameter("parentPostId");
        String childPostId = request.getParameter("childPostId");
        postService.removeChildrenPost(parentPostId, childPostId);
        request.setAttribute("posts", postService.getPosts());
        return new ModelAndView("home");
    }

    @RequestMapping(value = "removePost.spring", method = RequestMethod.POST)
    public ModelAndView removePost(HttpServletRequest request) {
        String postId = request.getParameter("postId");
        postService.removePost(postId);
        request.setAttribute("posts", postService.getPosts());
        return new ModelAndView("home");
    }
}
