package cn.tr.baiducloud.dao.file;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.tr.baiducloud.entity.File;

@Repository
public interface FileDao {
	
	List<File> selectList();
	
//  int deleteById(Integer id);

//  int insert(File record);

//  File selectById(Integer id);

//  int updateById(File record);
	
}