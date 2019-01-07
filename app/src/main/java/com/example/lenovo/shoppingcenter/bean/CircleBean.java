package com.example.lenovo.shoppingcenter.bean;

import java.util.List;

/**
 * date:2019.1.3
 * author:赵颖冰(lenovo)
 * function:
 */
public class CircleBean {
    /**
     * result : [{"commodityId":99,"content":"刘鹏发测试圈子","createTime":1544228824000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":6,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-07/0274520181207182704.jpg","nickName":"sg_803fH","userId":24,"whetherGreat":2},{"commodityId":99,"content":"刘鹏发测试圈子","createTime":1544228683000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":5,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-07/0463920181207182443.jpg","nickName":"sg_803fH","userId":24,"whetherGreat":2},{"commodityId":99,"content":"刘鹏发测试圈子","createTime":1544228683000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":5,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-07/0463920181207182443.jpg","nickName":"sg_803fH","userId":24,"whetherGreat":2},{"commodityId":99,"content":"刘鹏发测试圈子","createTime":1544228587000,"greatNum":1,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":4,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-07/7152320181207182307.jpg","nickName":"sg_803fH","userId":24,"whetherGreat":2},{"commodityId":99,"content":"刘鹏发测试圈子","createTime":1544228587000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":4,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-07/7152320181207182307.jpg","nickName":"sg_803fH","userId":24,"whetherGreat":2}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commodityId : 99
         * content : 刘鹏发测试圈子
         * createTime : 1544228824000
         * greatNum : 0
         * headPic : http://172.17.8.100/images/small/default/user.jpg
         * id : 6
         * image : http://172.17.8.100/images/small/circle_pic/2018-12-07/0274520181207182704.jpg
         * nickName : sg_803fH
         * userId : 24
         * whetherGreat : 2
         */

        private int commodityId;
        private String content;
        private long createTime;
        private int greatNum;
        private String headPic;
        private int id;
        private String image;
        private String nickName;
        private int userId;
        private int whetherGreat;

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getWhetherGreat() {
            return whetherGreat;
        }

        public void setWhetherGreat(int whetherGreat) {
            this.whetherGreat = whetherGreat;
        }
    }
}
