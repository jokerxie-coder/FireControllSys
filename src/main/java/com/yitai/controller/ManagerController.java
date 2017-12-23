package com.yitai.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yitai.model.Manager;
import com.yitai.service.ManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	@Resource
	private ManagerService managerService;
	
	//获取消防设备的详细信息
	@RequestMapping("/login")
	public String login(HttpServletRequest request,HttpServletResponse response,Manager manager){
		
		//更改服务器发送数据的编码格式为UTF-8,通知客户端响应内容为html类型,编码格式为UTF-8
		response.setContentType("text/html;charset=UTF-8");
		//PrintWriter out;
		//System.out.println(manager);
		try {
			//out = response.getWriter();
			//如果manager为null,说明前台提交的form为null,
			//即前台未输入用户名和密码
			if(manager==null){
				//out.write("");
				request.getSession().setAttribute("loginMsg","请输入用户名和密码！");
				response.sendRedirect("/FireControllSys/manager/login.jsp");  
			}else if(!manager.getmUserName().isEmpty()||!manager.getmPassWord().isEmpty()){
				
				Manager object=managerService.findByUserName(manager.getmUserName());
				//System.out.println(object);
				//如果查询得到的用户为null,则说明用户不存在
				if(object==null){
//					out.write("The user is not exist");
//					out.flush();
//					out.close();
					request.getSession().setAttribute("loginMsg","用户名不存在！");
					response.sendRedirect("/FireControllSys/manager/login.jsp");  
				}else if(!manager.getmPassWord().equals(object.getmPassWord())){
						
//						out.write("The passWord is false");
//						out.flush();
//						out.close();
						request.getSession().setAttribute("loginMsg","密码错误！");
						response.sendRedirect("/FireControllSys/manager/login.jsp");  
					}
				
			}else{
//				out.write("The userName or passWord is Null");
//				out.flush();
//				out.close();
				request.getSession().setAttribute("loginMsg","用户名或密码不能为空！");
				response.sendRedirect("/FireControllSys/manager/login.jsp");  
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	
		//登陆成功,跳转至火情上报页面
		return "/fire/fireInfo";
	}
}
