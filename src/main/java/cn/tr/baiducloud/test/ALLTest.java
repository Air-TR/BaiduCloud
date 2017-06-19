package cn.tr.baiducloud.test;

import org.json.JSONObject;

import com.baidu.aip.nlp.AipNlp;

public class ALLTest {
	
	// 设置APPID/AK/SK
    public static final String APP_ID = "9734157";
    public static final String API_KEY = "vdLxlToop4l7k224C62tdiWZ";
    public static final String SECRET_KEY = "gNiV6C8nSQzz86RcvUXbWxzd2RLjSN2g";

    public static void main(String[] args) {
        // 初始化一个NLPClient
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000); // 建立连接的超时时间
        client.setSocketTimeoutInMillis(60000);	   // 通过打开的连接传输数据的超时时间
        
        /** 以下均为测试 */
        
        // test1: 短文本相似度
        double score = ((JSONObject) client.simnet("1号文件", "机密Z") // 获得response
        		.get("output")) // 获得output
        		.getDouble("score"); // 获得score，即相似度
	    System.out.println("短文本相似度为: " + score);
        
    }

}
