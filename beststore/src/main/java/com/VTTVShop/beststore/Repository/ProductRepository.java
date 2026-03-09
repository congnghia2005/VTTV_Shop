package com.VTTVShop.beststore.Repository;

import com.VTTVShop.beststore.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
