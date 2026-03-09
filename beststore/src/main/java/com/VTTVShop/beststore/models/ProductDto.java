package com.VTTVShop.beststore.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public class ProductDto {

    @NotEmpty(message = "Tên sản phẩm không được để trống")
    private String name;

    @NotEmpty(message = "Thương hiệu không được để trống")
    private String brand;

    @Min(value = 0, message = "Giá tiền phải lớn hơn 0")
    private Double price;

    @Size(min = 10, message = "Mô tả phải có ít nhất 10 ký tự")
    @Size(max = 2000, message = "Mô tả không được quá 2000 ký tự")
    private String description;

    // QUAN TRỌNG: Đây là biến để hứng file ảnh từ Form
    private MultipartFile imageFile;

    @Min(value = 0, message = "Số lượng phải lớn hơn hoặc bằng 0")
    private Integer quantity;

    @NotEmpty(message = "Vui lòng nhập kích cỡ (VD: 39,40,41)")
    private String sizes;

    @NotEmpty(message = "Vui lòng nhập màu sắc (VD: Trắng,Đen)")
    private String colors;

    // --- GETTER & SETTER ---
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public MultipartFile getImageFile() { return imageFile; }
    public void setImageFile(MultipartFile imageFile) { this.imageFile = imageFile; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getSizes() { return sizes; }
    public void setSizes(String sizes) { this.sizes = sizes; }

    public String getColors() { return colors; }
    public void setColors(String colors) { this.colors = colors; }
}