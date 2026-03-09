package com.VTTVShop.beststore.services;


import com.VTTVShop.beststore.Repository.ProductRepository;
import com.VTTVShop.beststore.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public Product save(Product p) {
        return repo.save(p);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}

