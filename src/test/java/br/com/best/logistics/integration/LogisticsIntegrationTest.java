/**
 * 
 */
package br.com.best.logistics.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.best.logistics.LogisticsApplication;


/**
 * @author Denis soares moreira
 * 
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { LogisticsApplication.class })
@IntegrationTest("server.port:0") 
public class LogisticsIntegrationTest {

	private MockMvc mockMvc;
	
	@Autowired
	protected WebApplicationContext context;
	
	@Before
    public void setUp() throws Exception {
		 mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void findAllRoutesMaps() throws Exception {
	
		mockMvc.perform(get("/logistics/findAllRoutesMaps"))
		   .andExpect(status().isOk())
		   .andExpect(content().contentType("application/json; charset=utf-8"));
		
	}
	
	@Test
	public void saveRouteMap() throws Exception{
		mockMvc.perform(get("/logistics/saveRouteMap"))
		   .andExpect(status().isMethodNotAllowed());
	}

	@Test
	public void calculateLowerCostRoute() throws Exception{
		mockMvc.perform(get("/logistics/calculateLowerCostRoute"))
		   .andExpect(status().isMethodNotAllowed());
	}
	
}