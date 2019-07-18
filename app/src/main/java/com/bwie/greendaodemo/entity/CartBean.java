package com.bwie.greendaodemo.entity;

import java.util.List;

public class CartBean extends BaseResponse{
    public String categoryName;
    public List<ShoppingCartListBean> shoppingCartList;

    public class ShoppingCartListBean {
        public String commodityId;
        public String commodityName;
        public String count;
        public String pic;
        public String price;
    }

}
