package cn.tr.baiducloud.test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONObject;

import com.baidu.aip.nlp.AipNlp;

import cn.tr.baiducloud.entity.File;
import cn.tr.baiducloud.util.ComparatorFile;
import cn.tr.baiducloud.util.DBUtil;

/**
 * 
 * 短文本相似度测试类
 * 简介：根据搜索框输入的文本，匹配数据库记录，筛选出相似度大于规定值的记录，按要求排序输出。
 * 
 * 注：百度相关API暂不支持并发（免费前提下），经测试最多支持5个线程同时访问，否则调用接口失败。
 * 
 * @author taorun
 * @date 2017年6月7日 下午10:16:15
 * 
 */

public class TextSimilarity {
	
	public static void main(String[] args) {
		
		AipNlp client = new AipNlp(ALLTest.APP_ID, ALLTest.API_KEY, ALLTest.SECRET_KEY);
		
		String text = "金轮开发手册"; // 搜索框输入的文本
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from file where id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			List<File> list = new ArrayList<File>(); // 数据库所有文件集合
			while (rs.next()) {
				File file = new File();
				file.setId(rs.getInt("id"));
				file.setTitle(rs.getString("title"));
				list.add(file);
			}
			for (File file : list) {
				// 创建多线程调用短文本相似度API(百度API不支持免费并发调用, 目前测试新建超过5个线程必然报错)
//				new Thread(new FileThread(client, text, file)).start();
				
				// 获得相似度
				BigDecimal score = ((JSONObject) client.simnet(text, file.getTitle()).get("output")).getBigDecimal("score");
				file.setScore(score);
				System.out.println(file);
			}
			System.out.println("=================================================");
			System.out.println("输入信息: " + text + "\n相似文件（相似度降序排列）:");
			List<File> files = new ArrayList<File>(); // 相似文件集合
			for (File file : list) {
				if (file.getScore().compareTo(new BigDecimal(0.6)) == 1) { // 相似度大于0.6, 加入相似集合
					files.add(file);
				}
			}
			
			// files集合根据相似度属性排序
			ComparatorFile comparator = new ComparatorFile();
			Collections.sort(files, comparator);
			for (File file : files) {
				System.out.println(file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	
	/**
	 * 百度技术文档
	 * @param client
	 */
	public void simnet(AipNlp client) {
	    // 获取两个文本的相似度
	    JSONObject response = client.simnet("百度是个搜索公司", "谷歌是个搜索公司");
	    System.out.println(response.toString());
	}

}
