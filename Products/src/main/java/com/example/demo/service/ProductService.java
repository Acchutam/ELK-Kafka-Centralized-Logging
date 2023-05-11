package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
 ArrayList<Product> products = new ArrayList<>();


        public List<Product> init () {
        products.add(new Product(1, "Smart-Tv", 20, 30000));
        products.add(new Product(2, "Smart-Watch", 25, 35000));
        products.add(new Product(3, "Smart-Fridge", 30, 40000));
        products.add(new Product(4, "Smart-Phone", 50, 45000));

        return products;
    }

 public List<Product> getAll(){
     return products;
 }

 public Optional<Product> findById(int id){
     return products
             .stream()
             .filter(product -> product.getId()==id)
             .findFirst();
 }

 public Product create(Product product){
        products.add(product);
        return product;
 }

 public String remove(Product product){
            products.remove(product);
            return "Product removed successfully";
 }


}
