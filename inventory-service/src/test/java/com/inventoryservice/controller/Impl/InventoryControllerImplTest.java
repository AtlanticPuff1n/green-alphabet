package com.inventoryservice.controller.Impl;

import com.inventoryservice.service.InventoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {InventoryControllerImpl.class})
@ExtendWith(SpringExtension.class)
class InventoryControllerImplTest {
    @Autowired
    private InventoryControllerImpl inventoryControllerImpl;

    @MockBean
    private InventoryService inventoryService;

    @Test
    void testIsInStock() throws Exception {
        when(this.inventoryService.isProductInStock((String) any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/inventory/{SKU}", "SKU");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(this.inventoryControllerImpl)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    @Test
    void testIsInStock2() throws Exception {
        when(this.inventoryService.isProductInStock((String) any())).thenReturn(true);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/inventory/{SKU}", "SKU");
        getResult.characterEncoding("Encoding");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(this.inventoryControllerImpl)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }
}

