package com.springframework.restapi.onlineshoppingrestapi.services;

import com.springframework.restapi.onlineshoppingrestapi.api.v1.mapper.CategoryMapper;
import com.springframework.restapi.onlineshoppingrestapi.api.v1.mapper.ProductMapper;
import com.springframework.restapi.onlineshoppingrestapi.api.v1.model.CategoryDTO;
import com.springframework.restapi.onlineshoppingrestapi.api.v1.model.ProductDTO;
import com.springframework.restapi.onlineshoppingrestapi.domain.Category;
import com.springframework.restapi.onlineshoppingrestapi.domain.Product;
import com.springframework.restapi.onlineshoppingrestapi.repositories.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CategoryServiceTest {

    @Mock
    CategoryRepository categoryRepository;

    CategoryService categoryService;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);

        categoryService = new CategoryServiceImpl(categoryRepository,
                CategoryMapper.INSTANCE,
                ProductMapper.INSTANCE);
    }

    @Test
    public void getAllCategories() {

        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("product1 name");

        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("product2 name");

        Category category1 = new Category();
        category1.setId(1L);
        category1.setDescription("Category Description.");
        category1.getProducts().add(product1);
        category1.getProducts().add(product2);

        Category category2 = new Category();
        category2.setId(2L);
        category2.setDescription("Category Description.");
        category2.getProducts().add(product1);
        category2.getProducts().add(product2);

        List<Category> categories = Arrays.asList(category1, category2);

        when(categoryRepository.findAll()).thenReturn(categories);

        List<CategoryDTO> categoryDTOList = categoryService.getAllCategories();

        assertNotNull(categoryDTOList);
        assertEquals(2, categoryDTOList.size());
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    public void getCategoryById() {

        //Given
        Category category1 = new Category();
        category1.setId(1L);
        category1.setDescription("Category Description.");

        when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(category1));

        //when
        CategoryDTO categoryDTO = categoryService.getCategoryById(category1.getId());

        //then
        assertNotNull(categoryDTO);
        assertEquals(category1.getDescription(), categoryDTO.getDescription());
        verify(categoryRepository, times(1)).findById(anyLong());

    }

    @Test
    public void getProductsByCategory() {

        //Given
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("product1 name");

        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("product2 name");

        Category category1 = new Category();
        category1.setId(1L);
        category1.setDescription("Category Description.");
        category1.getProducts().add(product1);
        category1.getProducts().add(product2);

        when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(category1));

        //when
        List<ProductDTO> products = categoryService.getProductsByCategory(category1.getId());

        //then
        assertNotNull(products);
        assertEquals(2, products.size());
        verify(categoryRepository, times(1)).findById(anyLong());
    }

    @Test
    public void createProductByCategory() {

        //Given
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Iphone");
        product1.setBrand("Apple");
        product1.setDescription("This is iphone 11 pro max");

        ProductDTO newProduct = new ProductDTO();
        newProduct.setName("samsung");
        newProduct.setBrand("samsung");
        newProduct.setDescription("this is a samsung Galaxy s8");

        Category category1 = new Category();
        category1.setId(1L);
        category1.setDescription("Category Description.");
        category1.getProducts().add(product1);

        when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(category1));
        when(categoryRepository.save(any())).thenReturn(category1);

        //when
        ProductDTO productDTO = categoryService.createProductByCategory(category1.getId(), newProduct);

        //then
        assertNotNull(productDTO);
        assertEquals(2, category1.getProducts().size());
        assertEquals(newProduct.getName(), productDTO.getName());
        assertEquals(newProduct.getBrand(), productDTO.getBrand());
        assertEquals(newProduct.getDescription(), productDTO.getDescription());
        verify(categoryRepository, times(1)).save(any());
        verify(categoryRepository, times(1)).findById(anyLong());
    }

    @Test
    public void create() {

        Category category = new Category();
        category.setId(1L);
        category.setDescription("Category Description.");

        CategoryDTO dto = new CategoryDTO();
        dto.setDescription("Category Description.");

        when(categoryRepository.save(any())).thenReturn(category);

        CategoryDTO categoryDTO = categoryService.create(dto);

        assertNotNull(categoryDTO);
        assertEquals(dto.getDescription(), categoryDTO.getDescription());
        verify(categoryRepository, times(1)).save(any());
    }

    @Test
    public void update() {

        Category category = new Category();
        category.setId(1L);
        category.setDescription("Category Description.");

        CategoryDTO dto = new CategoryDTO();
        dto.setDescription("Category Description.");

        when(categoryRepository.save(any())).thenReturn(category);

        CategoryDTO categoryDTO = categoryService.update(category.getId(), dto);

        assertNotNull(categoryDTO);
        assertEquals(dto.getDescription(), categoryDTO.getDescription());
        verify(categoryRepository, times(1)).save(any());
    }

    @Test
    public void patch() {

        Category category = new Category();
        category.setId(1L);
        category.setDescription("Category Description.");

        CategoryDTO dto = new CategoryDTO();
        dto.setDescription("Category Description Updated.");

        when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(category));
        when(categoryRepository.save(any())).thenReturn(category);

        CategoryDTO categoryDTO = categoryService.patch(category.getId(), dto);

        assertNotNull(categoryDTO);
        assertEquals(dto.getDescription(), categoryDTO.getDescription());
        assertEquals(dto.getDescription(), categoryDTO.getDescription());
        verify(categoryRepository, times(1)).save(any());
    }

    @Test
    public void deleteById() {
        Long id = 1l;

        categoryService.deleteById(id);

        verify(categoryRepository, times(1)).deleteById(anyLong());
    }
}