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
    @Override
    public List<Post> getPosts(){
        return postDB.getPosts();
    }
    
    @Autowired
    PostDB postDB;
    
    @Override
    public void addPost(List<String> images, Map<String, String[]> param){
        String comment = param.get("comment")[0];
        if(postDB==null) postDB = new PostDB();
        String postId = postDB.getPosts().size()==0 ? "1" : String.valueOf(Integer.parseInt(postDB.getPosts().get(postDB.getPosts().size()-1).getPostId())+1);
        Post post = new Post("dipen", images, comment, postId, new ArrayList<>());
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
        String postId = parentPost.getChildrenPost().size()==0 ? "1" : String.valueOf(Integer.parseInt(parentPost.getChildrenPost().get(parentPost.getChildrenPost().size()-1).getPostId())+1);
        Post childPost = new Post("", new ArrayList<>(), comment, postId, new ArrayList<>());
        postDB.addChildPost(parentPost, childPost);        
    }

    @Override
    public void removeChildrenPost(String parentPostId, String childPostId) {
        Post parentPost = postDB.getPostFromId(parentPostId);
        Post childPost = postDB.getChildPostFromParentAndId(parentPost, childPostId);
        postDB.removeChildPost(parentPost, childPost);
    }

    @Override
    public void removePost(String postId) {
        Post post = postDB.getPostFromId(postId);
        postDB.removePost(post);
    }
    
    
}
