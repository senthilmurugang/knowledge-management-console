package com.webProject;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Car {
    @Id Long id;
    @Index String license;
    int color;
    Car(String license, int color){
        this.license = license;
        this.color = color;
    }
}