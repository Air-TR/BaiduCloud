package cn.tr.baiducloud.test.threadtest;

import java.math.BigDecimal;

import org.json.JSONObject;

import com.baidu.aip.nlp.AipNlp;

import cn.tr.baiducloud.entity.File;

public class FileThread implements Runnable {
	
	private AipNlp client;
	
	private String text;
	
	private File file;
	
	public FileThread(AipNlp client, String text, File file) {
		this.client = client;
		this.text = text;
		this.file = file;
	}

	public void run() {
		BigDecimal score = ((JSONObject) client.simnet(text, file.getTitle()).get("output")).getBigDecimal("score");
		file.setScore(score);
		System.out.println(file);
	}

}
