package cn.tr.baiducloud.entity;

import java.math.BigDecimal;

public class File {
	
    private Integer id;
    

    private String title;

    private String content;
    
    /**
     * 额外属性
     */
    private BigDecimal score; // 相似度
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", title=" + title + ", score=" + score + "]";
	}
    
}