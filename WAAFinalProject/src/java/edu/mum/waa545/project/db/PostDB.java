/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa545.project.db;

import edu.mum.waa545.project.model.Post;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dipen
 */
@Repository
//@Scope(value="application")
public class PostDB {
    private List<Post> posts = new ArrayList<>();

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public PostDB() {
    }    
    
    public void addPost(Post post){
        this.posts.add(post);
    }
    
    public void addChildPost(Post parentPost, Post childPost){
        parentPost.getChildrenPost().add(childPost);
        posts.set(posts.indexOf(parentPost), parentPost);
    }
}
