package com.st.Car;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.springstore.car.service.CarService;
import com.st.springstore.common.vo.CarGoodsVo;
import com.st.springstore.common.vo.PageObject;
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
	@Test
	public void test4CarService() {
		double selectCarMoney = carService.SelectCarMoney(1, 1);
		System.out.println(selectCarMoney);
	}
	@Test
	public void test5CarService() {
		PageObject<CarGoodsVo> PageObjects = carService.findPageObjects(1, 2);
		System.out.println(PageObjects.getPageCount());
		System.out.println(PageObjects.getPageCurrent());
		System.out.println(PageObjects.getPageSize());
		System.out.println(PageObjects.getRecords());
		System.out.println(PageObjects.getRowCount());		
	}

}
