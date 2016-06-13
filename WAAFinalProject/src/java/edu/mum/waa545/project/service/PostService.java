/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa545.project.service;

import edu.mum.waa545.project.db.PostDB;
import edu.mum.waa545.project.model.Post;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author dipen
 */
@Service
public class PostService {
    public List<Post> getPosts(){
        return PostDB.getAllPost();
    }
}
