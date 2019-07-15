package com.czp.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传
 * @author Administrator
 *
 */
public interface ImageService {

	Map uploadImage(MultipartFile uploadFile);
}
