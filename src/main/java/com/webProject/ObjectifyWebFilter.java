package com.webProject;

import javax.servlet.annotation.WebFilter;
import com.googlecode.objectify.ObjectifyFilter;
import com.googlecode.objectify.ObjectifyService;

@WebFilter(urlPatterns = {"/*"})
public class ObjectifyWebFilter extends ObjectifyFilter {

    // ObjectifyService.init();
    // ObjectifyService.register(Car.class);

}