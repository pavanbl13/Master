package com.SpringRest.service;

import static org.junit.Assert.fail;

import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.SpringRest.AppConfig;
import com.SpringRest.config.AppInitializer;
import com.SpringRest.config.RestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class,RestConfig.class,AppInitializer.class})
@TestPropertySource(locations = {
		   "classpath:SpringRest.properties"})
public class TestSpringRestService {
	
	private SpringRestService service;
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Autowired
    protected Environment env;
	

	@Before
	public void setUp() throws Exception {
//		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//		service = (SpringRestService) context.getBean("SpringRestService");
//		service = new SpringRestService();
		/*prop.setFilePath(env.getProperty("filePath"));
		prop.setFileData(new StringBuffer(env.getProperty("fileData")));*/
		/*this.mockMvc.perform(post("/search")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());*/
		
	}
	@Test
	public final void testGetCount() {
//		service.getCount();
		service.getTopCounts(10);
		fail("Not yet implemented"); // TODO
	}

}
