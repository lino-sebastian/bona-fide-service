package com.post.meridiem;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.post.meridiem.model.Product;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.File;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class BonaFideServiceApplication {
    public static List<Product> productList;

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        productList =
                mapper.readValue(new File("src/main/resources/product.json"), new TypeReference<List<Product>>() {
                });
        SpringApplication.run(BonaFideServiceApplication.class, args);
    }

    @Bean
    @Profile("default")
    public ApplicationRunner dataInitializer(MongoTemplate template) {
        return (args) -> {
            template.insertAll(productList);
        };
    }

}
