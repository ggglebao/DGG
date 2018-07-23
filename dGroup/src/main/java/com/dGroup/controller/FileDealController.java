package com.dGroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dGroup.entity.FileEntity;
import com.dGroup.service.FileDealService;


@Controller
@RequestMapping(value = "/fileDeal")
public class FileDealController {

	@Autowired
	FileDealService fileDealService;
	
	@ResponseBody
	@RequestMapping(value = "/getList")
	public List<FileEntity> getList(String basePath) {
		return fileDealService.getForlderList(basePath);
	}
	@ResponseBody
	@RequestMapping(value = "/add")
	public Integer addForlder(String basePath, String forlderPath) {
		return fileDealService.addForlder(basePath, forlderPath);
	}
	@ResponseBody
	@RequestMapping(value = "/delete")
	public Integer delete( String folderPath) {
		return fileDealService.deleteForlder(folderPath);
	}
	@ResponseBody
	@RequestMapping(value = "/edit")
	public Integer edit( String forlderPth, String newName ) {
		return fileDealService.editForlder(forlderPth, newName);
	}
}
