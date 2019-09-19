package com.st.springstore.goods.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.st.springstore.common.exception.ServiceException;
import com.st.springstore.common.vo.PageObject;
import com.st.springstore.goods.dao.GoodsDao;
import com.st.springstore.goods.pojo.Goods;
import com.st.springstore.goods.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private GoodsDao goodsDao;
	/**
	 * 热销产品查询
	 */
	@Override
	public List<Goods> fingHotGoods() {
		List<Goods> hotGoods = goodsDao.findHotGoods();
		if(hotGoods == null || hotGoods.size() == 0)
			throw new ServiceException("服务器维护中...");
		return hotGoods;
	}
	/**
	 * 商品模糊查询 排序 分页
	 */
	@Override
	public PageObject<Goods> findGoods(String title,Integer categoryId,String orderBy, Integer isDesc, Integer pageCurrent) {
		//判断参数
		if(!StringUtils.isEmpty(title) && categoryId != null)
			throw new IllegalArgumentException("非法的参数");
		int pageSize = 10;//每页显示10条数据
		int pageIndex = (pageCurrent == null)?0:(pageCurrent-1)*10;
		List<Goods> records = goodsDao.findGoods(title,categoryId,orderBy, isDesc, pageIndex, pageSize);
		//查询总条数
		int rowCount = goodsDao.getGoodsRows(title);
		if(records == null || records.size() == 0 || rowCount == 0)
			throw new ServiceException("服务器维护中...");
		return new PageObject<>(rowCount, records, pageCurrent, pageSize);
	}
	/**
	 * 根据商品id查询商品
	 */
	@Override
	public Goods findGoodById(Integer id) {
		if(id == null)
			throw new IllegalArgumentException("非法的参数");
		Goods goods = goodsDao.findGoodsById(id);
		if(goods == null) {
			throw new ServiceException("哦豁,宝贝不见了");//前端如果校验到此数据,可以跳转其他
		}
		return goods;
	}

}
