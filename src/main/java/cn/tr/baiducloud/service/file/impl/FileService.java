package cn.tr.baiducloud.service.file.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tr.baiducloud.dao.file.FileDao;
import cn.tr.baiducloud.entity.File;
import cn.tr.baiducloud.service.file.IFileService;

@Service
public class FileService implements IFileService {

	@Autowired
	private FileDao fileDao;
	
	public List<File> selectList() {
		List<File> files = fileDao.selectList();
		return files;
	}

}
