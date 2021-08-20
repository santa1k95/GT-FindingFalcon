package com.gt.utils;

import com.gt.helpers.Constants;
import com.gt.helpers.TimeSlots;

import java.util.List;

public class CCave extends Room{
    String name= Constants.C_CAVE_NAME;
    Integer capacity=3;



    public Integer getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CCave{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", ts=" + ts +
                '}';
    }
}
