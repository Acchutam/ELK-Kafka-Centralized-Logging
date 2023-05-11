package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {


    private static ProductService service= new ProductService();

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    static {
        service.init();
    }

    @GetMapping("api/product")
    public List<Product> getAll(){
        logger.info("Request sent to getAll....... Getting all records");
        return service.getAll();
    }

    @GetMapping("api/product/{id}")
    public Optional<Product> getById(@PathVariable int id){
        logger.info("Request sent to getById....Getting Product with id:"+id);
        return service.findById(id);
    }

    @PostMapping("api/product")
    public Product save(@RequestBody Product product){
        logger.info("Request sent to save ... Saving current product in records");
        return service.create(product);
    }

    @DeleteMapping("api/product")
    public String delete(@RequestBody Product product){
        logger.info("Deleteing record of product"+product);
        return service.remove(product);
    }


}
