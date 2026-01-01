package com.inventorymanagementsytem.demo.services.interfaces;


import com.inventorymanagementsytem.demo.dtos.requests.AddProductRequest;
import com.inventorymanagementsytem.demo.dtos.requests.DeleteProductRequest;
import com.inventorymanagementsytem.demo.dtos.requests.UpdateProductRequest;
import com.inventorymanagementsytem.demo.dtos.requests.ViewSingleProductRequest;
import com.inventorymanagementsytem.demo.dtos.responses.*;

import java.util.List;

public interface ProductAdminService {

    AddProductResponse addProduct(AddProductRequest addProductRequest);
    UpdateProductResponse updateProduct(UpdateProductRequest updateProductRequest);
    List<ViewAllProductResponse> viewAllProducts ();
    ViewSingleProductResponse viewSingleProduct(ViewSingleProductRequest request);
    void deleteAProduct(DeleteProductRequest deleteProductRequest);
}
