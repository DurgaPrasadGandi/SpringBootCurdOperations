
package com.boot.ws.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)

@AutoConfigureMockMvc

@TestPropertySource("classpath:application.properties")

public class TestSpringBootCurdOperationsController {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testSave() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/save")
				.contentType(MediaType.APPLICATION_JSON).content("{\"empName\":\"surya\"," + "     \"empSal\":27.7}");
		MvcResult resp = mvc.perform(request).andReturn();
		MockHttpServletResponse result = resp.getResponse();
		assertEquals(200, result.getStatus());
		if (!result.getContentAsString().contains("saved")) {
			fail("data is not saved");
		}
	}
	@Test
	public void getAllEmployes() throws Exception {
		MockHttpServletRequestBuilder request=
				MockMvcRequestBuilders.get("/all");
		MvcResult result=mvc.perform(request).andReturn();
		MockHttpServletResponse resp=result.getResponse();
		assertEquals(200,resp.getStatus());
		assertNotNull(resp.getContentAsString());
		
				
				
		
	}

}
