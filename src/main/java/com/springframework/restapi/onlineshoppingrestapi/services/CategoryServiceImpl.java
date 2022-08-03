package com.springframework.restapi.onlineshoppingrestapi.services;

import com.springframework.restapi.onlineshoppingrestapi.api.v1.mapper.CategoryMapper;
import com.springframework.restapi.onlineshoppingrestapi.api.v1.mapper.ProductMapper;
import com.springframework.restapi.onlineshoppingrestapi.api.v1.model.CategoryDTO;
import com.springframework.restapi.onlineshoppingrestapi.api.v1.model.ProductDTO;
import com.springframework.restapi.onlineshoppingrestapi.domain.Category;
import com.springframework.restapi.onlineshoppingrestapi.domain.Product;
import com.springframework.restapi.onlineshoppingrestapi.repositories.CategoryRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final ProductMapper productMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               CategoryMapper categoryMapper,
                               ProductMapper productMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.productMapper = productMapper;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {

        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::categoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .stream()
                .map(categoryMapper::categoryToCategoryDTO)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<ProductDTO> getProductsByCategory(Long categoryId) {

        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);

        if(!categoryOptional.isPresent()){
            throw new RuntimeException("category does not exist.");
        }
        Category category = categoryOptional.get();

        return category.getProducts()
                .stream()
                .map(productMapper::productToProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO createProductByCategory(Long categoryId, ProductDTO productDTO) {

        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);

        if(!categoryOptional.isPresent()){
            throw new RuntimeException("Category Not Found.");
        }
        Category category = categoryOptional.get();
        Product product = productMapper.productDTOToProduct(productDTO);
        category.getProducts().add(product);
        Category savedCategory = categoryRepository.save(category);

        return savedCategory.getProducts()
                .stream()
                .filter(prod -> prod.getBrand().equals(product.getBrand()))
                .filter(prod -> prod.getDescription().equals(product.getDescription()))
                .filter(prod -> prod.getName().equals(product.getName()))
                .map(productMapper::productToProductDTO)
                .findFirst()
                .orElse(null);
    }

    @Override
    public CategoryDTO create(CategoryDTO categoryDTO) {

        Category category = categoryMapper.categoryDTOToCategory(categoryDTO);

        return saveAndReturnDTO(category);

    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO categoryDTO) {

        Category category = categoryMapper.categoryDTOToCategory(categoryDTO);
        category.setId(id);

        return saveAndReturnDTO(category);
    }

    public CategoryDTO saveAndReturnDTO(Category category){

        Category savedCategory = categoryRepository.save(category);

        CategoryDTO returnedDTO = categoryMapper.categoryToCategoryDTO(savedCategory);

        return returnedDTO;
    }

    @Override
    public CategoryDTO patch(Long id, CategoryDTO categoryDTO) {

        return categoryRepository.findById(id)
                .stream()
                .map(category -> {
                    if(categoryDTO.getDescription() != null){
                        category.setDescription(categoryDTO.getDescription());
                    }
                    return saveAndReturnDTO(category);
                })
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
