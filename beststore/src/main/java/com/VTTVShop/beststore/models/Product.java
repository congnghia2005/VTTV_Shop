package com.VTTVShop.beststore.models;

import jakarta.persistence.*;

@Entity
@Table(name = "sanpham")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDSP") // Khớp cột IDSP
    private Long id;

    @Column(name = "TenSP", nullable = false)
    private String name;

    @Column(name = "Gia")
    private Double price;

    @Column(name = "Anh")
    private String image;

    @Column(name = "ThuongHieu")
    private String brand;

    @Column(name = "MoTa", columnDefinition = "NVARCHAR(MAX)")
    private String description;

    @Column(name = "SoLuong")
    private Integer quantity;

    @Column(name = "KichCo")
    private String sizes;

    @Column(name = "MauSac")
    private String colors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }
}
