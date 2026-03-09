package com.VTTVShop.beststore.controllerApi;


import com.VTTVShop.beststore.Repository.ProductRepository;
import com.VTTVShop.beststore.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*") // Cho phép Angular gọi API
public class ProductApiController {

    @Autowired
    private ProductRepository repo;

    // Lấy tất cả sản phẩm
    @GetMapping
    public List<Product> getAll() {
        return repo.findAll();
    }

    // Lấy theo ID
    @GetMapping("/{id}")
    public Product getById(@PathVariable Integer id) {
        return repo.findById(id).orElse(null);
    }

    // Thêm sản phẩm (không có upload file)
    @PostMapping
    public Product create(@RequestBody Product product) {
        return repo.save(product);
    }

    // Cập nhật sản phẩm
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        return repo.save(product);
    }

    // Xóa
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}
