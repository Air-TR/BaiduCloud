package cn.tr.baiducloud.util;

/**
 * 自动生成唯一id
 * 
 * @author taorun
 * @date 2017年6月28日
 *
 */

public class UUID {
	
	public static void main(String[] args) {
		String id = getUUID();
		System.out.println(id);
	}
	
	public static String getUUID() {
		return java.util.UUID.randomUUID().toString().replace("-","");
	}

}
