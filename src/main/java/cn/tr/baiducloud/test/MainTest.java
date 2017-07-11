package cn.tr.baiducloud.test;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.nlp.ESimnetType;

/**
 * 百度云开发者中心Java SDK测试类
 * 
 * @author taorun
 * @date 2017年7月3日 下午2:18:35
 *
 */

public class MainTest {
	
	// 设置APPID/AK/SK
    public static final String APP_ID = "9734157";
    public static final String API_KEY = "vdLxlToop4l7k224C62tdiWZ";
    public static final String SECRET_KEY = "gNiV6C8nSQzz86RcvUXbWxzd2RLjSN2g";

    public static void main(String[] args) {
    	
    	MainTest mainTest = new MainTest();
    	
        // 初始化一个NLPClient
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);
        
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000); // 建立连接的超时时间
        client.setSocketTimeoutInMillis(60000);	   // 通过打开的连接传输数据的超时时间
        
        /** 以下均为测试 */
//        mainTest.wordSimEmbedding(client); // 词义相似度
//        mainTest.sentimentClassify(client); // 情感倾向分析
//        mainTest.dnnlmCn(client); // 中文DNN语言模型
//        mainTest.simnet(client); // 短文本相似度
        mainTest.NLPCommentTag(client); // 评论观点抽取
        
        
        // test1: 获取短文本相似度结果
//        double score = ((JSONObject) client.simnet("1号文件", "机密Z") // 获得response
//        		.get("output")) // 获得output
//        		.getDouble("score"); // 获得score，即相似度
//	    System.out.println("短文本相似度为: " + score);
	    
    }
    
    public void wordSimEmbedding(AipNlp client) {
    	// 获取词义相似度结果
    	JSONObject response = client.wordSimEmbedding("百度", "谷歌");
    	System.out.println(response.toString());
    }

    public void sentimentClassify(AipNlp client) {
    	// 获取情感倾向分析结果
    	JSONObject response = client.sentimentClassify("百度是一家伟大的公司");
    	System.out.println(response.toString());
    }
    
    public void dnnlmCn(AipNlp client) {
    	// 获取中文DNN语言模型结果
    	JSONObject response = client.dnnlmCn("百度是个搜索公司");
    	System.out.println(response.toString());
    }
    
    public void simnet(AipNlp client) {
        // 获取短文本相似度结果
        JSONObject response = client.simnet("百度是个搜索公司", "谷歌是个搜索公司");
        System.out.println(response.toString());
        // 选择CNN算法
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("model", "CNN");
        JSONObject response1 = client.simnet("百度是个搜索公司", "谷歌是个搜索公司");
        System.out.println(response1.toString());
    }
    
    public void NLPCommentTag(AipNlp client) {
    	/**
    	 * ESimnetType可选属性:
    	 * HOTEL, KTV, BEAUTY, FOOD, TRAVEL, HEALTH, EDU, BUSINESS, HOUSE, CAR, LIFE, SHOPPING，_3C
    	 */
        // 获取美食评论情感属性
        JSONObject response_food = client.commentTag("这家餐馆味道不错", ESimnetType.FOOD);
        System.out.println(response_food.toString());
        // 获取酒店评论情感属性
        JSONObject response_hotel = client.commentTag("喜来登酒店不错", ESimnetType.HOTEL);
        System.out.println(response_hotel.toString());
    }
    
}
