package com.czp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.czp.common.utils.JsonUtils;
import com.czp.service.ImageService;

@Controller
public class ImageUploadController {

	@Autowired
	private ImageService imageService;
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String imageUpload(MultipartFile uploadFile) {
		System.out.println("上传文件...");
		Map map = imageService.uploadImage(uploadFile);
		System.out.println("上传结果："+JsonUtils.objectToJson(map));
		return JsonUtils.objectToJson(map);
	}
	
}
