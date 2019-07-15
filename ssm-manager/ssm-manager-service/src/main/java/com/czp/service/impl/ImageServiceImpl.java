package com.czp.service.impl;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.czp.service.ImageService;

@Component
public class ImageServiceImpl implements ImageService{
	
	@Value("${savePath}")
	private String savePath;// = "F:/ssm_images/";
	@Value("${askPath}")
	private String askPath;// = "http://127.0.0.1:80/";
	public Map uploadImage(MultipartFile uploadFile) {
		// 取原始文件名
		String fileOldName = uploadFile.getOriginalFilename();
		// 生成一个新文件名
		String fileNewName = ""+new Date().getTime();
		fileNewName  = fileNewName + fileOldName.substring(fileOldName.lastIndexOf("."));
		// 上传图片
		String imgRealPath = savePath + fileNewName;
		Map result = new HashMap();
	    try {
	    	//保存图片-将multipartFile对象装入image文件中
	        File imageFile=new File(imgRealPath);
	        uploadFile.transferTo(imageFile);
	        result.put("error", 0);
	        result.put("url", askPath+fileNewName);
//	        result.put("message", "文件上传成功");
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	result.put("error", 1);
	        result.put("message", "文件上传失败");
	    }
	    
		return result;
	}

}
