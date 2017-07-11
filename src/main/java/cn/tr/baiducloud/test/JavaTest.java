package cn.tr.baiducloud.test;

import java.util.Arrays;
import java.util.List;

/**
 * java方法测试类
 * 
 * @author taorun
 * @date 2017年6月28日
 *
 */

public class JavaTest {
	
	public static void main(String[] args) {
		
		String string = "1,2,3,4,5";
		String[] arr = string.split(",");
		List<String> list = Arrays.asList(arr);
		for (String s : list) {
			System.out.println(Integer.parseInt(s) > 3);
		}
		System.out.println(list);
		
	}

}
