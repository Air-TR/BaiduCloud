package cn.tr.baiducloud.util;

import java.util.UUID;

public class Test {
	
	public static void main(String[] args) {
		String id = getUUID();
		System.out.println(id);
	}
	
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-","");
	}

}
