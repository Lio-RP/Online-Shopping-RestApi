package com.springframework.restapi.onlineshoppingrestapi.controller.v1;

import com.springframework.restapi.onlineshoppingrestapi.api.v1.model.CategoryDTO;
import com.springframework.restapi.onlineshoppingrestapi.api.v1.model.ProductDTO;
import com.springframework.restapi.onlineshoppingrestapi.domain.Product;
import com.springframework.restapi.onlineshoppingrestapi.services.CategoryService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static com.springframework.restapi.onlineshoppingrestapi.controller.v1.AbstractRestController.asJSONString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CategoryControllerTest {

    @InjectMocks
    CategoryController controller;

    @Mock
    CategoryService categoryService;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getAllCategories() throws Exception {

        List<CategoryDTO> categoryDTOList = Arrays.asList(new CategoryDTO(), new CategoryDTO());

        when(categoryService.getAllCategories()).thenReturn(categoryDTOList);

        mockMvc.perform(get("/api/v1/categories")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categories", hasSize(2)));
    }

    @Test
    public void getCategoryById() throws Exception {
        CategoryDTO dto = new CategoryDTO();
        dto.setDescription("Category Description.");

        when(categoryService.getCategoryById(anyLong())).thenReturn(dto);

        mockMvc.perform(get("/api/v1/categories/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description", equalTo("Category Description.")));
    }

    @Test
    public void getProductsByCategory() throws Exception {

        ProductDTO productDTO1 = new ProductDTO();
        productDTO1.setName("Iphone");


        ProductDTO productDTO2 = new ProductDTO();
        productDTO2.setName("Samsung");

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setDescription("Category Description.");
        categoryDTO.getProducts().add(productDTO1);
        categoryDTO.getProducts().add(productDTO2);

        when(categoryService.getProductsByCategory(anyLong())).thenReturn(categoryDTO.getProducts());

        mockMvc.perform(get("/api/v1/categories/1/products")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.products", hasSize(2)));
    }

    @Test
    public void createProductsByCategory() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Iphone");

        when(categoryService.createProductByCategory(anyLong(), any())).thenReturn(productDTO);

        mockMvc.perform(post("/api/v1/categories/1/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJSONString(productDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", equalTo("Iphone")));
    }

    @Test
    public void createNewCategory() throws Exception {

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setDescription("Category Description.");

        when(categoryService.create(any())).thenReturn(categoryDTO);

        mockMvc.perform(post("/api/v1/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJSONString(categoryDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.description", equalTo("Category Description.")));
    }

    @Test
    public void updateCategory() throws Exception {

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setDescription("Category Description.");

        when(categoryService.update(anyLong(), any())).thenReturn(categoryDTO);

        mockMvc.perform(put("/api/v1/categories/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJSONString(categoryDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description", equalTo("Category Description.")));
    }

    @Test
    public void patchCategory() throws Exception {

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setDescription("Category Description.");

        when(categoryService.patch(anyLong(), any())).thenReturn(categoryDTO);

        mockMvc.perform(patch("/api/v1/categories/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJSONString(categoryDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description", equalTo("Category Description.")));
    }

    @Test
    public void deleteCategoryById() throws Exception {

        mockMvc.perform(delete("/api/v1/categories/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(categoryService, times(1)).deleteById(anyLong());
    }
}