package com.st.springsys.sysgoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.st.springstore.common.exception.ServiceException;
import com.st.springstore.common.vo.PageObject;
import com.st.springsys.sysgoods.dao.SysGoodsDao;
import com.st.springsys.sysgoods.pojo.SysGoods;
import com.st.springsys.sysgoods.service.SysGoodsService;
@Service
public class SysGoodsServiceImpl implements SysGoodsService {
	@Autowired
	private SysGoodsDao sysGoodsDao;

	/**查看上架商品*/
	@Override
	public PageObject<SysGoods> findOnline(int onSale,Integer pageCurrent) {
		int pageSize = 10;//每页显示10条数据
		int pageIndex = (pageCurrent == null)?0:(pageCurrent-1)*10;
		List<SysGoods> sysGoods = sysGoodsDao.findOnline(onSale,pageIndex, pageSize);
		//上架商品总数
		int rowCount = sysGoodsDao.getOnlineRows(onSale);
		if(sysGoods==null || sysGoods.size() == 0 || rowCount == 0)
			throw new ServiceException("快上啊，就等你了");
		return new PageObject<>(rowCount, sysGoods, pageCurrent, pageSize);
	}

	/**商品模糊查询 排序 分页*/
	@Override
	public PageObject<SysGoods> findSysGoods(String title, Integer categoryId, String orderBy, Integer isDesc,
			Integer pageCurrent) {
		//判断参数
		if(!StringUtils.isEmpty(title) && categoryId != null)
			throw new IllegalArgumentException("非法的参数");
		int pageSize = 10;//每页显示10条数据
		int pageIndex = (pageCurrent == null)?0:(pageCurrent-1)*10;
		List<SysGoods> records = sysGoodsDao.findSysGoods(title,categoryId,orderBy, isDesc, pageIndex, pageSize);
		//查询总条数
		int rowCount = sysGoodsDao.getSysGoodsRows(title);
		if(records == null || records.size() == 0 || rowCount == 0)
			throw new ServiceException("服务器维护中...");
		return new PageObject<>(rowCount, records, pageCurrent, pageSize);
	}

	/**根据商品id查询商品*/
	@Override
	public SysGoods findSysGoodById(Integer id) {
		if(id == null)
			throw new IllegalArgumentException("非法的参数");
		SysGoods sysGoods = sysGoodsDao.findSysGoodsById(id);
		if(sysGoods == null) {
			//前端如果校验到此数据,可以跳转其他
			throw new ServiceException("哦豁,宝贝不见了");
		}
		return sysGoods;	
	}

}
