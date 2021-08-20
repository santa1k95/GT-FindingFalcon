package com.gt.utils;

import com.gt.helpers.Constants;
import com.gt.helpers.TimeSlots;

import java.util.List;

public class DTower extends Room{
    String name= Constants.D_TOWER_NAME;
    Integer capacity=7;

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
        return "DTower{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", ts=" + ts +
                '}';
    }


}
