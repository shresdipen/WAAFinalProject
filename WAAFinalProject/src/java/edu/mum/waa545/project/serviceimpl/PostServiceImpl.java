/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa545.project.serviceimpl;

import edu.mum.waa545.project.db.PostDB;
import edu.mum.waa545.project.model.Post;
import edu.mum.waa545.project.service.PostService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dipen
 */

@Service
public class PostServiceImpl implements PostService{
    public List<Post> getPosts(){
        return postDB.getPosts();
    }
    
    @Autowired
    PostDB postDB;
    
    public void addPost(List<String> images, Map<String, String[]> param){
        String comment = param.get("comment")[0];
        System.out.println("Comment: "+comment);
        Post post = new Post("", images, comment, "", new ArrayList<>());
        System.out.println("PostDB: "+postDB);
        if(postDB==null) postDB = new PostDB();
        postDB.addPost(post);
        System.out.println("Posts: "+postDB.getPosts());
    }
}
