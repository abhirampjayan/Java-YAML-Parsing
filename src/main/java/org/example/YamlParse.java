package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.io.File;

public class YamlParse {
    public static void main(String[] args)  {
        ObjectMapper mapper ;
        mapper= new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        try {
            Order order = mapper.readValue(new File("src/main/resources/orderInput.yaml"),Order.class);
            System.out.println(order.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//d