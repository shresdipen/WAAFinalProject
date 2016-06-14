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
        if(postDB==null) postDB = new PostDB();
        
        Post post = new Post("dipen", images, comment, ""+postDB.getPosts().size(), new ArrayList<>());
        postDB.addPost(post);
        System.out.println("Posts: "+postDB.getPosts());
    }

    @Override
    public void addChildrenPost(String parentPostId, String comment) {
        Post parentPost = new Post();
        for(Post post : postDB.getPosts()){
            if(post.getPostId().equals(parentPostId)){
                parentPost = post;
                break;
            }
        }
        Post childPost = new Post("", new ArrayList<>(), comment, "" + parentPost.getChildrenPost().size(), new ArrayList<>());
        postDB.addChildPost(parentPost, childPost);        
    }
}
