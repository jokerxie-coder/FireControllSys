package com.yitai.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yitai.model.Facility;
import com.yitai.service.FacilityService;

@Controller
@RequestMapping("/facility")
public class FacilityController  {

	//使用注解注入facilityService对象
	@Resource
	private FacilityService facilityService;

	/**
	 * 根据设备Id查询设备的基本信息
	 * 将facility对象以json格式返回给前端
	 * @param response
	 * @param fId
	 * @return
	 */
	@RequestMapping(value="/search")
	public @ResponseBody Facility getFacilityInfo(HttpServletRequest request,HttpServletResponse response,@RequestParam Integer fId){
		
		//更改服务器发送数据的编码格式为UTF-8,通知客户端响应内容为html类型,编码格式为UTF-8
		response.setContentType("text/html;charset=UTF-8");
		Facility facility=null;
		try {
			//PrintWriter out=response.getWriter();
			if(fId==null){
//				out.write("请输入产品编号！");
//				out.flush();
//				out.close();
				request.getSession().setAttribute("facilityMsg","请输入产品编号！");
				response.sendRedirect("/FireControllSys/facility/findFacility.jsp"); 
			}else{
				facility=facilityService.findOne(fId);
				if(facility==null){
					request.getSession().setAttribute("facilityMsg","该产品不存在！");
					response.sendRedirect("/FireControllSys/facility/findFacility.jsp"); 
				}
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	    //System.out.println(fId+"查询中。。。。");
		//System.out.println(facility);
		return facility;
	}
	
	/**
	 * 根据设备的Id修改设备的基本信息
	 * @param response
	 * @param facility
	 */
	//修改消防设备的详细信息
	@RequestMapping("/update")
	public @ResponseBody String updateFacilityInfo(HttpServletRequest request,HttpServletResponse response,Facility facility){
		
		//String date=request.getParameter("fProDate")
		
		//System.out.println(facility);
		
		//更改服务器发送数据的编码格式为UTF-8,通知客户端响应内容为html类型,编码格式为UTF-8
		response.setContentType("text/html;charset=UTF-8");
		
		try{
			if(facility==null){
				request.getSession().setAttribute("facilityMsg","请填写产品信息！");
				response.sendRedirect("/FireControllSys/facility/findFacility.jsp"); 
			}else if(!facility.getfName().isEmpty()||facility.getfId()!=null
					||!facility.getfModelNumber().isEmpty()||facility.getfProDate()!=null
					||facility.getfExpTime()!=null){
				request.getSession().setAttribute("facilityMsg","请填写完整产品信息！");
				response.sendRedirect("/FireControllSys/facility/findFacility.jsp"); 
			}else{
				facilityService.update(facility);
				
			}
			
		}catch (Exception e){
			
			e.printStackTrace();
			return "修改失败！";
		}
		
		return "修改成功！";	
	
	}
		
	
	
	/**
	 * 下载文件
	 * @param response
	 */
	@RequestMapping(value="/image")
	public void getFacilityImage(HttpServletResponse response,@RequestParam String fImageUrl){
		
		//String path="F:/light.png";
		
		//PrintWriter out=response.getWriter();
		//更改服务器发送数据的编码格式为UTF-8,通知客户端响应内容为html类型,编码格式为UTF-8
	    response.setContentType("text/html;charset=UTF-8");
	    OutputStream out;
		try {
			out = response.getOutputStream();
			
			if(fImageUrl.isEmpty()){
				
				//将字符串转换字节数组输出
				out.write("文件路径不能为空！".getBytes());
				out.flush();
				out.close();
				return;
				//return;
				
			}else{
				
				//根据文件路径获取文件对象
				File imageFile=new File(fImageUrl.trim());
				if(!imageFile.exists()){
					out.write("该文件不存在！".getBytes());
					return;
				}else{
					//获取文件名
					String name=imageFile.getName();
					
					InputStream in;
					in = new FileInputStream(fImageUrl.trim());
					
					 //设置响应头，对文件进行url编码
				    name = URLEncoder.encode(name, "UTF-8");
				    response.setHeader("Content-Disposition", "attachment;filename="+name);   
				    response.setContentLength(in.available());
				    
				    //第三步：老套路，开始copy
				    byte[] b = new byte[1024];
				    int len = 0;
				    while((len = in.read(b))!=-1){
				      out.write(b, 0, len);
				    }
				    out.flush();
				    out.close();
				    in.close();
					//Facility facility=facilityService.findOne(fId);
				
					//System.out.println(fId+"查询中。。。。");
					
					//return facility;
				
				}
				
			}
			
			
		} catch (Exception e) {
			
			//out.write("下载文件失败".getBytes());
			e.printStackTrace();
		}
	   
	}
}
