package com.st.springstore.user.reaml;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.springstore.user.dao.UserDao;
import com.st.springstore.user.pojo.User;
@Service
public class ShiroUserRealm extends AuthorizingRealm {
	@Autowired
	private UserDao userDao;
	
	/**
	 * 设置凭证匹配器
	 */
	@Override
	public void setCredentialsMatcher(
			CredentialsMatcher credentialsMatcher) {
		//构建凭证匹配对象
		HashedCredentialsMatcher hcMatcher = 
				new HashedCredentialsMatcher();
		//设置加密算法
		hcMatcher.setHashAlgorithmName("MD5");
		//设置加密次数
		hcMatcher.setHashIterations(1);
		
		super.setCredentialsMatcher(hcMatcher);
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		
		
		return null;
	}
	/**
	 * 认证数据的获取及封装
	 * 系统底层会将认证数据传递认证管理器，
	 * 由认证管理器完成认证操作。
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		//1.获取用户名(用户页面输入)
		UsernamePasswordToken utoken=
			(UsernamePasswordToken)token;
		String username = utoken.getUsername();
		//2.基于用户名查询用户信息
		User fuser = userDao.findUserByUserName(username);
		//3.判定用户是否存在
		if (fuser == null) {
			throw new UnknownAccountException("用户不存在！");
		}
		//4.封装用户信息
		ByteSource credentialsSalt = 
				ByteSource.Util.bytes(fuser.getSalt());
		SimpleAuthenticationInfo info = 
				new SimpleAuthenticationInfo(fuser,
								fuser.getPassword(), 
								credentialsSalt, 
								getName());
		//5.返回封装结果
		return info;
	}

}
