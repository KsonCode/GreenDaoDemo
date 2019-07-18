package com.bwie.greendaodemo.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;

@Entity
public class ShoppingCartListBean {
    @Id(autoincrement = true)
    private Long id;
    private Long categoryId;
    @Unique
    public String commodityId;
    public String commodityName;
    public String count;
    public String pic;
    public String price;
    @Generated(hash = 960252615)
    public ShoppingCartListBean(Long id, Long categoryId, String commodityId,
            String commodityName, String count, String pic, String price) {
        this.id = id;
        this.categoryId = categoryId;
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.count = count;
        this.pic = pic;
        this.price = price;
    }
    @Generated(hash = 248192423)
    public ShoppingCartListBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCommodityId() {
        return this.commodityId;
    }
    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }
    public String getCommodityName() {
        return this.commodityName;
    }
    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }
    public String getCount() {
        return this.count;
    }
    public void setCount(String count) {
        this.count = count;
    }
    public String getPic() {
        return this.pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
    public String getPrice() {
        return this.price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public Long getCategoryId() {
        return this.categoryId;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
