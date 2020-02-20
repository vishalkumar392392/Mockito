package com.mockito.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import javax.annotation.security.RunAs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mockito.model.Student;
import com.mockito.service.Service;
import com.mockito.service.imp.ServiceImpl;

import ch.qos.logback.core.status.Status;

public class MockTesting {
	

	private MockMvc mvc;
	@Autowired
	private WebApplicationContext context;
	
	@BeforeEach
	private void setUp() {
		
		mvc= MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Test
	public void mockTesting1() {
		
		
		Service service = mock(Service.class);
		
		when(service.retrieveNames("spring")).thenReturn(Arrays.asList("spring is nice framework",
                "react","spring boot","spring security"));
		
		ServiceImpl serviceImpl = new ServiceImpl(service);
		
        assertEquals(3, serviceImpl.retrieveSelectedNames("spring").size());
		
	}
	
	@Test
	public void test1() {
		
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenReturn("iam vishal").thenReturn("iam prabhas fan");
		
		assertEquals("iam vishal", listMock.get(anyInt()));
		assertEquals("iam prabhas fan", listMock.get(anyInt()));
		
	}
	
	@Test
	public void whenDerivedExceptionThrown_thenAssertionSucceds() {
	    Exception exception = assertThrows(RuntimeException.class, () -> {
	        Integer.parseInt("1a");
	    });
	 
	    String expectedMessage = "For input string";
	    String actualMessage = exception.getMessage();
	     System.out.println(exception);
	     System.out.println(exception.getMessage());

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void testUsingMockMvc() throws Exception {
		
		ObjectMapper om = new ObjectMapper();
		
		mvc.perform(MockMvcRequestBuilders.post("/addStudent").
				        content(om.writeValueAsString(new Student("vishal","palla@gmail.com","8143486643")))
				       .contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(MockMvcResultMatchers.status().isOk());
				       
		
	}

}
