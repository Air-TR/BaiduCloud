package cn.tr.baiducloud.util;

import java.util.Comparator;

import cn.tr.baiducloud.entity.File;

/**
 * 
 * File对象比较类
 * 简介: 根据文件的相似度属性对文件对象比较大小.
 * 
 * @author taorun
 * @date 2017年6月7日 下午10:25:23
 *
 */

public class ComparatorFile implements Comparator<Object> {

	public int compare(Object o1, Object o2) {
		File file1 = (File) o1;
		File file2 = (File) o2;
		return file2.getScore().compareTo(file1.getScore());
	}

}
