package cn.tr.baiducloud.util;

import java.util.Comparator;

import cn.tr.baiducloud.entity.File;

/**
 * 
 * 对象比较类
 * 简介: 根据两个对象的指定属性对两个对象比较大小.
 * 
 * @author taorun
 * @date 2017年6月7日 下午10:25:23
 *
 */

public class ComparatorFile implements Comparator<Object> {

	/**
	 * 根据对象的 score 属性比较大小
	 */
	public int compare(Object o1, Object o2) {
		File file1 = (File) o1;
		File file2 = (File) o2;
		return file2.getScore().compareTo(file1.getScore());
	}

}
