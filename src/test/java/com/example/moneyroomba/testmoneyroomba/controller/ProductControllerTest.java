package com.example.moneyroomba.testmoneyroomba.controller;

import com.example.moneyroomba.testmoneyroomba.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class ProductControllerTest {

    @Test
    void getById() throws Exception{
        assertEquals(5, 5);
    }



    
}