package com.bw.forwardfinalsample.model.bean;

import java.util.List;

/**
 * 坑点
 * 1、价格必须改成double
 * 2、商品图片，在这个接口中必须分割
 */
public class OrderformBean {

    /**
     * orderList : [{"detailList":[{"commentStatus":1,"commodityCount":3,"commodityId":5,"commodityName":"双头两用修容笔","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/5.jpg","commodityPrice":39,"orderDetailId":12128},{"commentStatus":1,"commodityCount":5,"commodityId":19,"commodityName":"环球 时尚拼色街拍百搭小白鞋 韩版原宿ulzzang板鞋 女休闲鞋","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/1.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/2.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/3.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/4.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/5.jpg","commodityPrice":78,"orderDetailId":12129}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020011020011329427822","orderStatus":3,"orderTime":1578657673000,"payAmount":507,"payMethod":1,"userId":27822},{"detailList":[{"commentStatus":2,"commodityCount":3,"commodityId":5,"commodityName":"双头两用修容笔","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/5.jpg","commodityPrice":39,"orderDetailId":12126},{"commentStatus":1,"commodityCount":5,"commodityId":19,"commodityName":"环球 时尚拼色街拍百搭小白鞋 韩版原宿ulzzang板鞋 女休闲鞋","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/1.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/2.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/3.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/4.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/5.jpg","commodityPrice":78,"orderDetailId":12127}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020011019524099427822","orderStatus":3,"orderTime":1578657161000,"payAmount":507,"payMethod":1,"userId":27822}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    //订单集合
    private List<OrderListBean> orderList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderListBean> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderListBean> orderList) {
        this.orderList = orderList;
    }

    /**
     * 订单bean类
     */
    public static class OrderListBean {
        /**
         * detailList : [{"commentStatus":1,"commodityCount":3,"commodityId":5,"commodityName":"双头两用修容笔","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/5.jpg","commodityPrice":39,"orderDetailId":12128},{"commentStatus":1,"commodityCount":5,"commodityId":19,"commodityName":"环球 时尚拼色街拍百搭小白鞋 韩版原宿ulzzang板鞋 女休闲鞋","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/1.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/2.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/3.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/4.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/5.jpg","commodityPrice":78,"orderDetailId":12129}]
         * expressCompName : 京东快递
         * expressSn : 1001
         * orderId : 2020011020011329427822
         * orderStatus : 3
         * orderTime : 1578657673000
         * payAmount : 507
         * payMethod : 1
         * userId : 27822
         */

        private String expressCompName;
        private String expressSn;
        private String orderId;
        //订单状态
        private int orderStatus;
        private long orderTime;
        private int payAmount;
        private int payMethod;
        private int userId;
        //商品集合
        private List<DetailListBean> detailList;

        public String getExpressCompName() {
            return expressCompName;
        }

        public void setExpressCompName(String expressCompName) {
            this.expressCompName = expressCompName;
        }

        public String getExpressSn() {
            return expressSn;
        }

        public void setExpressSn(String expressSn) {
            this.expressSn = expressSn;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
        }

        public long getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(long orderTime) {
            this.orderTime = orderTime;
        }

        public int getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(int payAmount) {
            this.payAmount = payAmount;
        }

        public int getPayMethod() {
            return payMethod;
        }

        public void setPayMethod(int payMethod) {
            this.payMethod = payMethod;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public List<DetailListBean> getDetailList() {
            return detailList;
        }

        public void setDetailList(List<DetailListBean> detailList) {
            this.detailList = detailList;
        }

        //商品bean类
        public static class DetailListBean {
            /**
             * commentStatus : 1
             * commodityCount : 3
             * commodityId : 5
             * commodityName : 双头两用修容笔
             * commodityPic : http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/5.jpg
             * commodityPrice : 39
             * orderDetailId : 12128
             */

            private int commentStatus;
            private int commodityCount;
            private int commodityId;
            private String commodityName;
            //商品的图片，是多个图片地址用 逗号串在一起的，需要分割
            private String commodityPic;

            //商品价格要编程 double
            private int commodityPrice;
            private int orderDetailId;

            public int getCommentStatus() {
                return commentStatus;
            }

            public void setCommentStatus(int commentStatus) {
                this.commentStatus = commentStatus;
            }

            public int getCommodityCount() {
                return commodityCount;
            }

            public void setCommodityCount(int commodityCount) {
                this.commodityCount = commodityCount;
            }

            public int getCommodityId() {
                return commodityId;
            }

            public void setCommodityId(int commodityId) {
                this.commodityId = commodityId;
            }

            public String getCommodityName() {
                return commodityName;
            }

            public void setCommodityName(String commodityName) {
                this.commodityName = commodityName;
            }

            public String getCommodityPic() {
                return commodityPic;
            }

            public void setCommodityPic(String commodityPic) {
                this.commodityPic = commodityPic;
            }

            public int getCommodityPrice() {
                return commodityPrice;
            }

            public void setCommodityPrice(int commodityPrice) {
                this.commodityPrice = commodityPrice;
            }

            public int getOrderDetailId() {
                return orderDetailId;
            }

            public void setOrderDetailId(int orderDetailId) {
                this.orderDetailId = orderDetailId;
            }
        }
    }
}
