package com.ayash7.online_nurse_appointment_system.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ayash7.online_nurse_appointment_system.DTO.CustomerRegistrationDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

@SpringBootTest
@WithMockUser(username = "ronaldo7", password = "madrid7", authorities = "CUSTOMER")
public class CustomerControllerTests {
    
    @BeforeEach
    void setup() {
        
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(SecurityMockMvcConfigurers.springSecurity()).build();
        
    }
    
    @Test
    void customerControllerRegisterReturnHttpStatusCreated() throws Exception {
        
        CustomerRegistrationDTO customerRegistrationDTO = CustomerRegistrationDTO.builder().customerUsername("ronaldo7").customerPassword("madrid7").customerName("Cristiano Ronaldo").customerAddress("Portugal").customerContact("777-777777").build();
        
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/customer/register").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(customerRegistrationDTO))).andExpect(MockMvcResultMatchers.status().isCreated()).andReturn();
        
        Integer customerID = JsonPath.read(result.getResponse().getContentAsString(), "$.customerID");
        
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/customer/delete/" + customerID));
        
    }
    
    @Test
    void customerControllerDeleteReturnHttpStatusOk() throws Exception {
        
        CustomerRegistrationDTO customerRegistrationDTO = CustomerRegistrationDTO.builder().customerUsername("ronaldo7").customerPassword("madrid7").customerName("Cristiano Ronaldo").customerAddress("Portugal").customerContact("777-777777").build();
        
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/customer/register").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(customerRegistrationDTO))).andReturn();
        
        Integer customerID = JsonPath.read(result.getResponse().getContentAsString(), "$.customerID");
        
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/customer/delete/" + customerID)).andExpect(MockMvcResultMatchers.status().isOk());
        
    }
    
    private MockMvc mockMvc;
    
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    @Autowired
    private ObjectMapper objectMapper;
    
}