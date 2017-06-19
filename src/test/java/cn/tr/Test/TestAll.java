//package cn.tr.Test;
//
//import org.json.JSONObject;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runners.Parameterized.Parameter;
//
//import com.baidu.aip.nlp.AipNlp;
//
//import cn.tr.baiducloud.AipNlpClient;
//
//public class TestAll {
//	
//	@Before
//    public void before() {
//        AipNlpClient client = new AipNlpClient();
//    }
//
//	@Test
//	public void simnet(AipNlp client) {
//
//	    // 获取两个文本的相似度
//	    JSONObject response = client.simnet("百度是个搜索公司", "谷歌是个搜索公司");
//	    System.out.println(response.toString());
//
//	}
//
//}
