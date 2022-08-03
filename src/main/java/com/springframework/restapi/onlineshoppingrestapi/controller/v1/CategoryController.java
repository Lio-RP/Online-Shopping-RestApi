package com.springframework.restapi.onlineshoppingrestapi.controller.v1;

import com.springframework.restapi.onlineshoppingrestapi.api.v1.model.CategoryDTO;
import com.springframework.restapi.onlineshoppingrestapi.api.v1.model.CategoryDTOList;
import com.springframework.restapi.onlineshoppingrestapi.api.v1.model.ProductDTO;
import com.springframework.restapi.onlineshoppingrestapi.api.v1.model.ProductDTOList;
import com.springframework.restapi.onlineshoppingrestapi.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Category Controller")
@RequestMapping("/api/v1/categories")
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(summary = "List all the categories")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTOList getAllCategories(){
        return new CategoryDTOList(categoryService.getAllCategories());
    }

    @Operation(summary = "get a category by id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @Operation(summary = "List all Products of a category")
    @GetMapping("/{id}/products")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTOList getProductsByCategory(@PathVariable Long id){
        return new ProductDTOList(categoryService.getProductsByCategory(id));
    }

    @Operation(summary = "get product of a category by id")
    @PostMapping("/{id}/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO createProductsByCategory(@PathVariable Long id,
                                               @RequestBody ProductDTO productDTO){
        
        return categoryService.createProductByCategory(id, productDTO);
    }

    @Operation(summary = "create new category")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO createNewCategory(@RequestBody CategoryDTO categoryDTO){

        return categoryService.create(categoryDTO);
    }

    @Operation(summary = "update existing category")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO updateCategory(@PathVariable Long id,
                                      @RequestBody CategoryDTO categoryDTO){
        return categoryService.update(id, categoryDTO);
    }

    @Operation(summary = "patch existing category")
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO patchCategory(@PathVariable Long id,
                                     @RequestBody CategoryDTO categoryDTO){
        return categoryService.patch(id, categoryDTO);
    }

    @Operation(summary = "delete category by id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategoryById(@PathVariable Long id){
        categoryService.deleteById(id);
    }
}
