package com.example.demo.supermarket.order.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 出库详情表
 * </p>
 *
 * @author youkehai
 * @since 2019-12-26
 */
@TableName("t_outound_order_item")
public class TOutoundOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 出库单ID
     */
    @TableField("order_id")
    private String orderId;

    /**
     * 商品编号
     */
    @TableField("good_code")
    private String goodCode;

    /**
     * 单价
     */
    @TableField("unit_price")
    private BigDecimal unitPrice;

    /**
     * 数量
     */
    @TableField("num")
    private BigDecimal num;

    /**
     * 总金额
     */
    @TableField("total_price")
    private BigDecimal totalPrice;

    /**
     * 状态(0正常)
     */
    @TableField("status")
    private String status;

    /**
     * 备注
     */
    @TableField("remarks")
    private String remarks;

    /**
     * 对应之前导入的数据详情ID
     */
    @TableField("item_id")
    private String itemId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "TOutoundOrderItem{" +
        "id=" + id +
        ", orderId=" + orderId +
        ", goodCode=" + goodCode +
        ", unitPrice=" + unitPrice +
        ", num=" + num +
        ", totalPrice=" + totalPrice +
        ", status=" + status +
        ", remarks=" + remarks +
        ", itemId=" + itemId +
        "}";
    }
}
