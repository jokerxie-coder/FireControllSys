package com.yitai.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.yitai.model.FireInfo;
import com.yitai.service.FireInfoService;

@Controller
@RequestMapping("/fireInfo")
public class FireController {

	@Resource
	private FireInfoService fireInfoService;
	
	/**
	 * 处理前台的火情上报请求
	 * 插入火情信息
	 * @param fireInfo
	 * @param request
	 * @param response
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("/insert")
	public @ResponseBody String insertFireInfo(FireInfo fireInfo, HttpServletRequest request,HttpServletResponse response) {
		//System.out.println(request.getParameter("filePath"));
		
		//更改服务器发送数据的编码格式为UTF-8,通知客户端响应内容为html类型,编码格式为UTF-8
		response.setContentType("text/html;charset=UTF-8");
		try{
			if(fireInfo==null){
				request.getSession().setAttribute("fireInfoMsg","请填写火情信息！");
				response.sendRedirect("/FireControllSys/fire/fireInfo.jsp");

			
			}else if(fireInfo.getFrRank()!=null||fireInfo.getFrDate()!=null
					||!fireInfo.getFrLocation().isEmpty()||!fireInfo.getFrDescr().isEmpty()){
				request.getSession().setAttribute("fireInfoMsg","请填写完整火情信息！");
				response.sendRedirect("/FireControllSys/fire/fireInfo.jsp");
			}else{
			
				//使用springmvc提供的方法来处理文件
				//初始化解析器
				CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
				
				//判断request中是否有multipartResolver类型数据，有就表示有文件类型
				if(multipartResolver.isMultipart(request)){
					
					MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
					
					//获得文件名，这里是迭代器封装
					Iterator<String> iter = multiRequest.getFileNames();
					while(iter.hasNext()){
						//这是前台name字段的名字，比如这里是filename
						String filename = (String) iter.next();
						
						//根据name字段来获得MultipartFile
						MultipartFile file = multiRequest.getFile(filename);
						
						//如果file不为空，就表示是一个MultipartFile文件
						//这里可不判断，因为上面已经判断了有文件类型
						if(file != null){
							
						    //获取字符串格式 yyyy-MM-dd HH:mm:ss
						    //并以 此字符串作为文件名称的一部分
						    Date currentTime = new Date();
						    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						    String fileName = formatter.format(currentTime);
				
							//文件的存储路径
							String path ="F:/Upload/fireInfo/火情"+fileName+".jpg";
							
							fireInfo.setFrImageUrl(path);
							
							//服务端本地文件
							File localFile = new File(path);
							
							//若path所在文件不存在，则该方法会自动创建文件
							localFile.mkdirs();
							
							//Springmvc 提供的写文件方法
							//将前台上传的文件写入后台本地文件中
							//即将客户端上传的文件复制到服务器端
							file.transferTo(localFile);
							
						}
					}
					
				}
				fireInfoService.insert(fireInfo);
			}
		}catch (Exception e){
			e.printStackTrace();
			
			return "火情上报失败！";
		}
		
		//fireInfo.setFrUrgent(0);
		//System.out.println(fireInfo);
	
		return "火情上报成功！";
		
	}

	
	}

