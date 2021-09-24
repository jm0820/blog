package com.blog.entity;
import java.io.Serializable;

public class BlogType implements Serializable {
  private static final long seriaVersionUID = 1L;

  /**主键*/
  private Integer id;
  /**类型名称*/
  private String typeName;
  /**序号*/
  private Integer orderNo;
  /**该类型下博客数量*/
  private Integer blog;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }


  public Integer getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(int orderNo) {
    this.orderNo = orderNo;
  }


  public Integer getBlog() {
    return blog;
  }

  public void setBlog(Integer blog) {
    this.blog = blog;
  }
}
