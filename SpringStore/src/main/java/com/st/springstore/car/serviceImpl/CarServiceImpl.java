package com.st.springstore.car.serviceImpl;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.springstore.car.dao.CarDao;
import com.st.springstore.car.pojo.Car;
import com.st.springstore.car.service.CarService;

@Service
public class CarServiceImpl implements CarService{
    @Autowired
    private CarDao carDao;
	/**添加到cookie中 */
	@Override
	public void addCookie(Integer userId, Integer num) {
		
		
	}
    /**添加到购物车*/
	@Override
	public int addCar(Integer userId, Integer goodsId, Integer num) {
		Car car1 = carDao.findById(userId,goodsId);		
		if(car1==null) {
			Car car2 = new Car();
			car2.setGoodsId(goodsId);
			car2.setUserId(userId);
			car2.setNum(num);
			car2.setCreateTime(new Date());
			int rows = carDao.addCar(car2);
			
			return rows;
		}
		int rows = carDao.updateCar(userId,goodsId,num);
		return rows;
				
	}

}
