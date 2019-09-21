package com.st.springsys.sysmenu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.st.springsys.sysmenu.entity.SysMenu;
import com.st.springsys.sysmenu.vo.Node;

/*
 * 将对象持久化到数据库
 */
@Mapper
public interface SysMenuDao {
	//添加
	int insertObject(SysMenu entity);
	//修改
	int updateObject(SysMenu entity);
	//树状图：菜单编辑页面上级菜单呈现
	@Select("select id,name,parent_id,permission from menus")
	List<Node> findZtreeMenuNodes();
	//删除
	@Delete("delete from menus where id=#{id}")
	int deleteObject(Integer id);

	/*
	 * 统计子菜单数,>0则不允许删除
	 */
	@Select("select count(*) from menus where parent_id = #{id}")
	int getChildCount(int id);

	/*
	 * 查询所有菜单以及上一级菜单的信息
	 * 
	 * @Return所有菜单
	 */
	@Select("select c.id,c.name,c.parent_id,c.permission " + " from menus c left join menus p" + " on c.parent_id=p.id")
	List<Map<String, Object>> findObjects();

}
