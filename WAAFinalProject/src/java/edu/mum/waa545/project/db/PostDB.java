/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa545.project.db;

import edu.mum.waa545.project.model.Post;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dipen
 */
@Repository
//@Scope(value="application")
public class PostDB {
    private List<Post> posts = new ArrayList<>();
    public static List<Post> getAllPost(){
        List<Post> posts = new ArrayList<>();
        List<Post> childPost = new ArrayList<>();
        List<String> pics = new ArrayList<>();
        pics.add("uploadedFolder/aceinst.png");
        pics.add("uploadedFolder/fee payment.jpg");
        pics.add("uploadedFolder/green-background-design-backgrounds-28569.jpg");
        pics.add("uploadedFolder/green-background-images-6.jpg");
        pics.add("uploadedFolder/mainpage.jpg");
        pics.add("uploadedFolder/Wallpaper-HD-Audi-free.jpg");
        posts.add(new Post("dipen", pics, "This is a comment.", "1", childPost));
        
        return posts;        
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public PostDB() {
    }    
    
    public void addPost(Post post){
        System.out.println("POsts: "+this.posts);
        System.out.println("Post: "+post);
        this.posts.add(post);
    }
}
