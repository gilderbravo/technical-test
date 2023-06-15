package technical.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class TestApplicationTests {

	@Autowired
    private MockMvc mockMvc;

	@Test
	void contextLoads() {

	}
	@Test
    public void testGetEndpoint1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices?start_date=2020-06-14 10:00:00&product_id=35455&brand_id=1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.PRICE").value("35.5"));
    }
	@Test
    public void testGetEndpoint2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices?start_date=2020-06-14 16:00:00&product_id=35455&brand_id=1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.PRICE").value("25.45"));
    }
	@Test
    public void testGetEndpoint3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices?start_date=2020-06-14 21:00:00&product_id=35455&brand_id=1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.PRICE").value("35.5"));
    }
	@Test
    public void testGetEndpoint4() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices?start_date=2020-06-15 10:00:00&product_id=35455&brand_id=1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.PRICE").value("30.5"));
    }
	@Test
    public void testGetEndpoint5() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices?start_date=2020-06-16 21:00:00&product_id=35455&brand_id=1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.PRICE").value("38.95"));
    }
}
