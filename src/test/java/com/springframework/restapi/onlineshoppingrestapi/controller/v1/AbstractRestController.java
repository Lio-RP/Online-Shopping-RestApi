package com.springframework.restapi.onlineshoppingrestapi.controller.v1;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractRestController {

    public static String asJSONString(final Object object){
        try {
            return new ObjectMapper().writeValueAsString(object);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
