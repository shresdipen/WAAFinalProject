/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa545.project.db;

import edu.mum.waa545.project.model.Post;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dipen
 */

public class PostDB {
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
}
