package com.grts.action;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grts.service.IUserService;

@Controller
@RequestMapping("/")
public class LoginAction {

	@Resource
	private IUserService userService;

	@RequestMapping("/login")
	public String login(String username, String password, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
	/*	UserBean user = userService.login(username, password);
		String code = request.getParameter("code");
		String rand = (String) session.getAttribute("rand");
		if (!WebUtils.isEmpty(code) && code.equals(rand) && user != null) {
			session.setAttribute("LOGIN_USER", user);
			return "/home.jsp";
		} else if (user == null) {
			request.setAttribute("msg", "用户名或密码错误");
			return "/login.jsp";
		} else {
			request.setAttribute("msg", "验证码错误");
			return "/login.jsp";
		}*/
		// shiro在认证过程中出现错误后将异常类路径通过request返回
				String exceptionClassName = (String) request
						.getAttribute("shiroLoginFailure");
				if(exceptionClassName!=null){
					if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
						/*throw new AuthenticationException("账号不存在");*/
						request.setAttribute("msg", "账号不存在");
					} else if (IncorrectCredentialsException.class.getName().equals(
							exceptionClassName)) {
						/*throw new AuthenticationException("用户名/密码错误");*/
						request.setAttribute("msg", "密码错误");
					} else if("randomCodeError".equals(exceptionClassName)){
						/*throw new AuthenticationException("验证码错误");*/
						request.setAttribute("msg", "验证码错误");
					} else{
					//	throw new Exception();//最终在异常处理器生成未知错误
					}
				}
				return "/login.jsp";

	}

	@RequestMapping("/logout")
	public String exit(HttpSession session) {
		session.invalidate();
		return "/login.jsp";
	}
}
