package com.st.Car;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.springstore.car.service.CarService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {
	@Autowired
    private CarService carService;
	@Test
	public void testCarService() {
		int rows = carService.addCar(1, 3, 3);
		System.out.println(rows);
		
	}

}
