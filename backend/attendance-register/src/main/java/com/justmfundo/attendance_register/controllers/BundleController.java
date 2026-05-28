package com.justmfundo.attendance_register.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.justmfundo.attendance_register.models.ClassBundleType;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class BundleController {
  
  @PostMapping("new-bundle")
  public String createNewBundle(@RequestBody ClassBundleType classBundle) {
      //create and save new bundle
      
      return "New Class Bundle Created Successfully";
  }
  
}
