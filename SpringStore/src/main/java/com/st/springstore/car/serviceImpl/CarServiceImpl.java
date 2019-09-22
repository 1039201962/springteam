package com.st.springstore.car.serviceImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.st.springstore.car.dao.CarDao;
import com.st.springstore.car.pojo.Car;
import com.st.springstore.car.service.CarService;
import com.st.springstore.common.exception.ServiceException;
import com.st.springstore.common.vo.CarGoodsVo;
import com.st.springstore.common.vo.PageObject;
import com.st.springstore.goods.dao.GoodsDao;
import com.st.springstore.goods.pojo.Goods;

@Service
public class CarServiceImpl implements CarService{
    @Autowired
    private CarDao carDao;
    @Autowired
    private GoodsDao goodsDao;
//	/**添加到cookie中 */
//	@Override
//	public void addCookie(Integer userId, Integer num) {
//		
//		
//	}
    /**添加到购物车*/
	@Override
	public int addCar(Integer userId, Integer goodsId, Integer num) {
		if(goodsId==null)
			throw new ServiceException("请选择商品");
		if(num==null)
			throw new ServiceException("请选择商品数量");
		Car car1 = carDao.findById(userId,goodsId);		
		if(car1==null) {
			Car car2 = new Car();
			car2.setGoodsId(goodsId);
			car2.setUserId(userId);
			car2.setNum(num);
			car2.setCreatedTime(new Date());
			int rows = carDao.addCar(car2);
			
			return rows;
		}
		int rows = carDao.updateCar(userId,goodsId,num);
		return rows;
				
	}
	/**根据用户id查询购物车中的商品信息*/
	@Override
	public List<CarGoodsVo> SelectCar(Integer userId) {
		if(userId==null)
			throw new ServiceException("请先登录");
		List<CarGoodsVo> carlist = new ArrayList<CarGoodsVo>();
		List<Car> list = carDao.findByUserId(userId);
		CarGoodsVo carGoods = new CarGoodsVo();
		for (Car car : list) {			
			Goods goods = goodsDao.findGoodsById(car.getGoodsId());
			if(goods==null)
				throw new ServiceException("商品不存在");
			carGoods.setGoodsId(car.getGoodsId());
			int num = car.getNum();
			carGoods.setNum(num);
			carGoods.setDescript(goods.getDescript());
			carGoods.setMain_img(goods.getMain_img());
			double price = goods.getPrice();
			carGoods.setPrice(price);
			carGoods.setTotal(num*price);
			carlist.add(carGoods);
		}
			return carlist;
}
	/**分页查询*/
	@Override
	public PageObject<CarGoodsVo> findPageObjects(Integer userId, Integer pageCurrent) {
		        //1.验证当前页码值是否合法
				if(pageCurrent==null||pageCurrent<1)
				throw new ServiceException("当前页码值不正确");
				//2.基于用户名查询总记录数并进行校验
				int rowCount=carDao.getRowCount(userId);
				if(rowCount==0)
				throw new ServiceException("购物车没有添加商品");
				//3.查询当前页记录
				List<CarGoodsVo> records = new ArrayList<CarGoodsVo>();
				Integer pageSize=5;
				Integer startIndex=(pageCurrent-1)*pageSize;
				List<Car> list=
						carDao.findPageObjects(userId,
						startIndex, pageSize);
				
				for (Car car : list) {	
					CarGoodsVo carGoods = new CarGoodsVo();
					Goods goods = goodsDao.findGoodsById(car.getGoodsId());
					System.out.println(car.getGoodsId());
					if(goods==null)
						throw new ServiceException("商品不存在");
					System.out.println(car.getGoodsId());
					carGoods.setGoodsId(car.getGoodsId());
					int num = car.getNum();
					carGoods.setNum(num);
					carGoods.setDescript(goods.getDescript());
					carGoods.setMain_img(goods.getMain_img());
					double price = goods.getPrice();
					carGoods.setPrice(price);
					carGoods.setTotal(num*price);
					records.add(carGoods);
				}
				//4.封装查询结果并返回
				return new PageObject<CarGoodsVo>(
				rowCount, records,pageCurrent, pageSize);
	}
	/**查询用户选中的商品总金额*/
	@Override
	public double SelectCarMoney(Integer userId, Integer...goodsIds) {		
		if(goodsIds==null||goodsIds.length==0)
			throw new ServiceException("请选择商品");
		double totalMoney=0;
		List<Car> list = carDao.findByGoodsId(userId,goodsIds);
		for (Car car : list) {
			int num = car.getNum();
			Goods goods = goodsDao.findGoodsById(car.getGoodsId());
			double price = goods.getPrice();
			totalMoney=totalMoney+num*price;
		}
		return totalMoney;
	}
	/**修改购物车对应的商品*/
	@Override
	public int updateCar(Integer userId, Integer goodsId,Integer num) {
		if(userId==null)
			throw new ServiceException("请您先登录");
		if(goodsId==null)
			throw new ServiceException("未选中商品");
		Car car = carDao.findById(userId, goodsId);
		if(car==null)
			throw new ServiceException("商品不存在");
		int rows = carDao.updateCar(userId, goodsId, num);
		return rows;
	}
	/**删除购物车中对应的商品*/
	@Override
	public int delectCar(Integer userId, Integer...goodsIds) {
		if(userId==null)
			throw new ServiceException("请您先登录");
		if(goodsIds==null||goodsIds.length<=0)
			throw new ServiceException("未选中商品");
		int rows = carDao.delectCarByGoodsId(userId,goodsIds);	
		return rows;
	}
	
}
