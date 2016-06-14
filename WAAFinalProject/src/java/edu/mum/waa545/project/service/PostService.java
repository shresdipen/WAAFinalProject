/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa545.project.service;

import edu.mum.waa545.project.model.Post;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dipen
 */
public interface PostService {
 
    public List<Post> getPosts();
    
    public void addPost(List<String> images, Map<String, String[]> param);
    
    public void addChildrenPost(String parentPostId, String comment);
}
