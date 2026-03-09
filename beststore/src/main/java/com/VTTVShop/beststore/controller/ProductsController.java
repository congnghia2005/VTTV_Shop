package com.VTTVShop.beststore.controller;

import com.VTTVShop.beststore.models.Product;
import com.VTTVShop.beststore.models.ProductDto;
import com.VTTVShop.beststore.Repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.*;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductRepository repo;
    @GetMapping({"","/"})
    public String showProducList(Model model){
        List<Product> products = repo.findAll();
        model.addAttribute("products", products);
        return "products/index";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        ProductDto productDto = new ProductDto();
        model.addAttribute("productDto", productDto);
        return "products/create";
    }

    @PostMapping("/create")
    public String createProduct(
            @Valid @ModelAttribute ProductDto productDto,
            BindingResult result
            ){
        if (productDto.getImageFile().isEmpty()){
            result.addError(new FieldError("productDto","imageFile", "Nhập ảnh của sản phẩm"));
        }
        if(result.hasErrors()){
            return "products/create";
        }

        MultipartFile image = productDto.getImageFile();
        Date createAt = new Date();
        String storageFileName = createAt.getTime() + "_" + image.getOriginalFilename();

        try{
            String uploadDir = "public/images/";
            Path uploadPath = Paths.get(uploadDir);

            if(!Files.exists(uploadPath)){
                Files.createDirectories(uploadPath);
            }

            try (InputStream inputStream = image.getInputStream()){
                Files.copy(inputStream,Paths.get(uploadDir + storageFileName), StandardCopyOption.REPLACE_EXISTING);
            }
        }catch (Exception ex){
            System.out.println("Lỗi lưu ảnh: "+ ex.getMessage());
        }

        Product product = new Product();
        product.setName(productDto.getName());
        product.setBrand(productDto.getBrand());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setQuantity(productDto.getQuantity());
        product.setSizes(productDto.getSizes());
        product.setColors(productDto.getColors());
        product.setImage(storageFileName);

        repo.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit")
    public String showEditPage(
            Model model,
            @RequestParam int id
    ) {
        try {
            Product product = repo.findById(id).get();
            model.addAttribute("product",product);

            ProductDto productDto = new ProductDto();
            productDto.setName(productDto.getName());
            productDto.setBrand(productDto.getBrand());
            productDto.setPrice(productDto.getPrice());
            productDto.setDescription(productDto.getDescription());
            productDto.setQuantity(productDto.getQuantity());
            productDto.setSizes(productDto.getSizes());
            productDto.setColors(productDto.getColors());

            model.addAttribute("productDto",productDto);
        }catch (Exception ex){
            System.out.println("Lỗi cập nhật: "+ ex.getMessage());
            return "redirect:/products";
        }
        return "products/edit";
    }

    @PostMapping("/edit")
    public String updateProduct(
            Model model,
            @RequestParam int id,
            @Valid @ModelAttribute ProductDto productDto,
            BindingResult result
            ){
        try{
            Product product = repo.findById(id).get();
            model.addAttribute("product",product);

            if(result.hasErrors()){
                return "products/edit";
            }

            if(!productDto.getImageFile().isEmpty()){
                String uploadDir = "public/images/";
                Path oldloadPath = Paths.get(uploadDir);

                try{
                    Files.delete(oldloadPath);
                } catch (Exception ex){
                    System.out.println("Lỗi cập nhật: "+ ex.getMessage());
                }

                MultipartFile image = productDto.getImageFile();
                Date createAt = new Date();
                String storageFileName = createAt.getTime() + "_" + image.getOriginalFilename();

                try (InputStream inputStream = image.getInputStream()){
                    Files.copy(inputStream,Paths.get(uploadDir + storageFileName), StandardCopyOption.REPLACE_EXISTING);
                }
                product.setImage(storageFileName);

            }
            product.setName(productDto.getName());
            product.setBrand(productDto.getBrand());
            product.setPrice(productDto.getPrice());
            product.setDescription(productDto.getDescription());
            product.setQuantity(productDto.getQuantity());
            product.setSizes(productDto.getSizes());
            product.setColors(productDto.getColors());

            repo.save(product);
        }catch (Exception ex){
        System.out.println("Lỗi cập nhật: "+ ex.getMessage());
    }

        return "redirect:/products";
    }

    @GetMapping("/delete")
    public String deleteProduct(
            @RequestParam int id
    ){
        try{
            Product product = repo.findById(id).get();

            Path imagePath = Paths.get("public/images/" + product.getImage());
            try{
                Files.delete(imagePath);
            }catch (Exception ex) {
                System.out.println("Lỗi xóa: " + ex.getMessage());
            }
            repo.delete(product);

        }catch (Exception ex) {
            System.out.println("Lỗi xóa: " + ex.getMessage());
        }
        return "redirect:/products";
    }



}
