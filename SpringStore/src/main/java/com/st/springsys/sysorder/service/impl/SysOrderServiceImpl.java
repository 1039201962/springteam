package com.st.springsys.sysorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.springstore.common.exception.ServiceException;
import com.st.springsys.common.vo.PageObject;
import com.st.springsys.sysorder.dao.SysOrderDao;
import com.st.springsys.sysorder.pojo.SysOrder;
import com.st.springsys.sysorder.service.SysOrderService;


@Service
public class SysOrderServiceImpl implements SysOrderService{
	@Autowired
	private SysOrderDao sysOrderDao;
     
	/**根据id删除订单*/
	@Override
	public int deleteSysOrder(Integer... orderIds) {
		int rows = sysOrderDao.deleteSysOrder(orderIds);
		return rows;
	}		
	
	/**查询订单*/
	@Override
	public SysOrder findOrderByName(String name) {
		if(name == null)
			throw new ServiceException("请再确定一下哟");
		SysOrder sysOrder = sysOrderDao.findOrderByName(name);
		return sysOrder;
	}

	/**最新订单*/
	@Override
	public List<SysOrder> findNewOrder() {
		List<SysOrder> newOrder = sysOrderDao.findNewOrder();
		if(newOrder == null) 
			throw new ServiceException("亲，再多等一会哟");
		return newOrder;
	}     

	/**分页数据*/
	@Override
	public PageObject<SysOrder> findPageObjects(
			String name,Integer pageCurrent) {
		//1.对参数进行校验
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("当前页码值无效");
		//2.查询总记录数并进行校验
		int rowCount=sysOrderDao.getRowCount(name);
		if(rowCount==0)
			throw new ServiceException("没有找到对应记录");
		//3.查询当前页记录
		int pageSize=3;
		int pageIndex=(pageCurrent-1)*pageSize;
		List<SysOrder> records=
				sysOrderDao.findPageObjects(name,
						pageIndex, pageSize);
		//4.对查询结果进行封装并返回
		return new PageObject<>(pageCurrent, pageSize, rowCount, records);
	}








}
