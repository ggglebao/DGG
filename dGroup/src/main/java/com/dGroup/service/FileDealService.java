package com.dGroup.service;

import java.util.List;

import com.dGroup.entity.FileEntity;

public interface FileDealService {
	// 只获取一层目录
    public List<FileEntity> getForlderList(String basePath);
    public Integer deleteForlder(String folderPath);
    public Integer addForlder(String basePath, String forlderPath);
    public Integer editForlder(String forlderPth , String  newName);
}
