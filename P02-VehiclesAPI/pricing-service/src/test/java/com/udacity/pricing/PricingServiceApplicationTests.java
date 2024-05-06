package com.udacity.pricing;

import com.udacity.pricing.service.PricingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Random;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class PricingServiceApplicationTests {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private PricingService pricingService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getPrice() throws Exception {
		Random rand = new Random();
		int vehicleId =rand.nextInt(20) + 1;
		mvc.perform(get("/services/price?vehicleId=" + vehicleId))
						.andExpect(status().isOk());
	}
}
