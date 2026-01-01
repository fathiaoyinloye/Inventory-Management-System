package com.inventorymanagementsytem.demo.services.implementations;

import com.inventorymanagementsytem.demo.data.models.Product;
import com.inventorymanagementsytem.demo.data.repositories.ProductRepository;
import com.inventorymanagementsytem.demo.dtos.requests.AddProductRequest;
import com.inventorymanagementsytem.demo.dtos.requests.DeleteProductRequest;
import com.inventorymanagementsytem.demo.dtos.requests.UpdateProductRequest;
import com.inventorymanagementsytem.demo.dtos.requests.ViewSingleProductRequest;
import com.inventorymanagementsytem.demo.dtos.responses.*;
import com.inventorymanagementsytem.demo.exceptions.*;
import com.inventorymanagementsytem.demo.services.interfaces.ProductAdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ProductAdminServiceImpl implements ProductAdminService {
    private final ProductRepository productRepository;

    @Override
    public AddProductResponse addProduct(AddProductRequest addProductRequest) {
       validateAllAddProduct(addProductRequest);
       Product product = Product.builder().name(addProductRequest.getName()).description(addProductRequest.getDescription()).quantity(addProductRequest.getQuantity()).build();
       product.setProductId();
       productRepository.save(product);
        return new AddProductResponse(product.getName(), product.getPrice(), product.getQuantity(),product.getProductId(), createDate());
    }

    @Override
    public UpdateProductResponse updateProduct(UpdateProductRequest updateProductRequest) {
        return null;
    }

    @Override
    public List<ViewAllProductResponse> viewAllProducts() {
        if(productRepository.count() == 0) throw new NoProductException();
        List<Product> products = productRepository.findAll();
        List<ViewAllProductResponse> responses = new ArrayList<>();
        for (Product product : products){
            ViewAllProductResponse response = ViewAllProductResponse.builder().productId(product.getProductId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .description(product.getDescription())
                    .quantity(product.getQuantity()).time(product.getTime()).build();
                    responses.add(response);
        }
        return responses;
    }

    @Override
    public ViewSingleProductResponse viewSingleProduct(ViewSingleProductRequest request) {
        Product product = validateProduct(request.getName());
        ViewSingleProductResponse response = ViewSingleProductResponse.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .quantity(product.getQuantity()).time(product.getTime()).build();
        return response;
    }


    @Override
    public void deleteAProduct(DeleteProductRequest deleteProductRequest) {
        Product product = validateProduct(deleteProductRequest.getName());
        productRepository.delete(product);

    }

    private Product validateProduct(String name){
        Product product = productRepository.findProductByName(name);
        if(product == null) throw new ProductDoesNotExistException();
        return product;
    }



    private void validatePrice(BigDecimal price){
        if (price.compareTo(BigDecimal.ONE) < 0) throw new PriceCannotBeLessThanOneException();
    }

    private void validateInput(String name){if(name.isEmpty() || name.charAt(0) == ' ') throw new EmptyInputException();}

    private void validateQuantity(int quantity){if(quantity < 1 ) throw new QuantityLessThanOneException();}


    private String createDate(){
        LocalDateTime dateTime =  LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("E, MM-yyyy HH:mm");
       return dateTime.format(format);
    }
    private void validateAllAddProduct(AddProductRequest addProductRequest){
        if (productRepository.findProductByName(addProductRequest.getName()) != null) throw new ProductAlreadyExistException();
        validatePrice(addProductRequest.getPrice());
        validateInput(addProductRequest.getName());
        validateInput(addProductRequest.getDescription());
        validateQuantity(addProductRequest.getQuantity());
    }

}


