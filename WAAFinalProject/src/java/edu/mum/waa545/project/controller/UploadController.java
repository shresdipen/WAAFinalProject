/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa545.project.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dipen
 */
@Controller()
public class UploadController {
    
    @RequestMapping(value = "uploader.spring", method = RequestMethod.POST)
    public ModelAndView upload(@RequestParam("uploadedFiles")MultipartFile uploadedFile){
        System.out.println("up"+uploadedFile);
        
        return  new ModelAndView("index");
    }
    
    @RequestMapping(value = "upload.spring", method = RequestMethod.GET)
    public ModelAndView getPage(String upload){
        
        return new ModelAndView("uploadimages");
    }
}
