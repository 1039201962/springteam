package com.st.Car;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.springstore.car.service.CarService;
import com.st.springstore.common.vo.CarGoodsVo;
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
	@Test
	public void test1CarService() {
		List<CarGoodsVo> list = carService.SelectCar(1);
		for (CarGoodsVo carGoodsVo : list) {
			System.out.println(carGoodsVo);
		}
		
	}
	@Test
	public void test2CarService() {
		carService.updateCar(1, 1, 6);
		
	}
	@Test
	public void test3CarService() {
		carService.delectCar(1,1);
		
	}

}
