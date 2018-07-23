package com.dGroup.service.Impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dGroup.entity.FileEntity;
import com.dGroup.service.FileDealService;
@Service
public class FileDealServiceImpl implements FileDealService {
	public static void main(String[] args) {
		File file = new File("E:/英雄时刻/新建文件夹 (2)");
		Integer result = 0;
        if (file.exists()) {
        	boolean detele = file.delete();
        	if(detele)result = 1;else {
        		result = 0;
			}
        } else {
        	result = 0;
        }
	}
	public List<FileEntity> getForlderList(String basePath) {
		// TODO Auto-generated method stub
		List<FileEntity> fileEntities = new ArrayList<FileEntity>();
		 File file = new File(basePath);
	        if (file.exists()) {
	            File[] files = file.listFiles();
	            if (null == files || files.length == 0) {
//	            	log.error("文件夹是空的!");
	            	return null;
	            } else {
	                for (File file2 : files) {
	                    if (file2.isDirectory()) {
	                    	FileEntity fileEntity = new FileEntity();
	                    	BasicFileAttributes bAttributes = null;
	                    	try {
	                    	    bAttributes = Files.readAttributes(file2.toPath(), 
	                    	        BasicFileAttributes.class);
	                    	} catch (IOException e) {
	                    	    e.printStackTrace();
//	                    	    log.error("时间转换错误");
	                    	}
	                    	String changeTime = bAttributes.lastModifiedTime().toString();
	                    	fileEntity.setCreateTime(changeTime);
	                    	fileEntity.setFileName(file2.getName());
	                    	fileEntity.setPath(file2.getAbsolutePath());
	                    	fileEntity.setSize(file2.length());
	                    	fileEntities.add(fileEntity);
	                    } 
	                }
	            }
	        } else {
//	        	log.error("文件不存在!");
	        	return null;
	        }
	        if(fileEntities.size() == 0) {
	    		return null;
	        } else {
	    		return fileEntities;
	        }
	}

	public Integer deleteForlder(String folderPath) {
		// TODO Auto-generated method stub
		File file = new File(folderPath);
		Integer result = 0;
        if (file.exists()) {
        	boolean detele = file.delete();
        	if(detele)result = 1;else {
        		result = 0;
			}
        } else {
        	result = 0;
        }
		return result;
	}

	public Integer addForlder(String basePath, String forlderPath) {
		// TODO Auto-generated method stub
		Integer result = 0;
		File file = new File(basePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		forlderPath = basePath+'/' +forlderPath;
		File forlder = new File(forlderPath);
		boolean b = forlder.mkdirs();
		if(b){
			result = 1;
		} else {
			result = 0;
		}
		return result;
	}

	public Integer editForlder(String forlderPth, String newName) {
		// TODO Auto-generated method stub
		Integer reuslt = 0;
		File file=new File(forlderPth);  
		if(file.exists())
		{
			boolean b = file.renameTo(new File(file.getParent()+File.separator+ newName));
			if (b) {
				reuslt =1;
			} else {
				reuslt =0;
			}
		}
		return reuslt;
	}

}
