package com.grts.realm;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.grts.pojo.MenuBean;
import com.grts.pojo.RoleBean;
import com.grts.pojo.UserBean;
import com.grts.service.IMenuService;
import com.grts.service.IRoleService;
import com.grts.service.IUserService;

public class CustomRealm extends AuthorizingRealm {

	@Resource
	private IUserService userService;
	@Resource
	private IRoleService roleService;
	@Resource
	private IMenuService menuService;
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		UserBean user = userService.selectByUsername(username);
		List<Integer> list = userService.queryRoleidByUserid(user.getUserid());
		for (Integer rid : list) {
			RoleBean role = roleService.selectByPrimaryKey(rid);
			info.addRole(role.getRolename());
			List<Integer> menulist = roleService.queryMidByRoleid(rid);
			for (Integer mid : menulist) {
				MenuBean menu = menuService.selectByPrimaryKey(mid);
				info.addStringPermission(menu.getSecurityname());
			}
		}
		/*info.addRole("role1");
		info.addRole("role2");
		info.addStringPermission("USER_QUERY");
		info.addStringPermission("USER_CREATE");*/
		return info;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		UserBean user = userService.selectByUsername(username);
		if (user==null) {
			return null;
		}
		String password = user.getPassword();
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, "baidu");
		return info;
	}

}
