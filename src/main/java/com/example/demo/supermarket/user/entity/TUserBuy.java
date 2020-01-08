package com.example.demo.supermarket.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 用户下单记录表
 * </p>
 *
 * @author youkehai
 * @since 2019-12-26
 */
@TableName("t_user_buy")
public class TUserBuy implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private String userId;

    /**
     * 下单商品ID
     */
    @TableField("good_code")
    private String goodCode;

    /**
     * 下单数量
     */
    @TableField("num")
    private String num;

    /**
     * 下单总金额
     */
    @TableField("total_price")
    private String totalPrice;

    /**
     * 创建人ID
     */
    @TableField("create_id")
    private String createId;

    /**
     * 创建人名称
     */
    @TableField("create_name")
    private String createName;

    /**
     * 创建时间
     */
    @TableField("create_date")
    private LocalDateTime createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }
    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "TUserBuy{" +
        "id=" + id +
        ", userId=" + userId +
        ", goodCode=" + goodCode +
        ", num=" + num +
        ", totalPrice=" + totalPrice +
        ", createId=" + createId +
        ", createName=" + createName +
        ", createDate=" + createDate +
        "}";
    }
}
