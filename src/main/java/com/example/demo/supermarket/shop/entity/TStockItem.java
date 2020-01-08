package com.example.demo.supermarket.shop.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 库存表
 * </p>
 *
 * @author youkehai
 * @since 2019-12-26
 */
public class TStockItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 单据编号
     */
    @TableField("bill_code")
    private String billCode;

    /**
     * 出入库类型(out出库in入库)
     */
    @TableField("out_or_in")
    private String outOrIn;

    /**
     * 仓库id
     */
    @TableField("warehouse_id")
    private String warehouseId;

    /**
     * 仓库名称
     */
    @TableField("warehouse_NAME")
    private String warehouseName;

    /**
     * 货品编号
     */
    @TableField("good_code")
    private String goodCode;

    /**
     * 数量(正负)
     */
    @TableField("num")
    private BigDecimal num;

    /**
     * 单价
     */
    @TableField("unit_price")
    private BigDecimal unitPrice;

    /**
     * 金额
     */
    @TableField("total_price")
    private BigDecimal totalPrice;

    /**
     * 创建时间
     */
    @TableField("create_date")
    private LocalDateTime createDate;

    /**
     * 备注
     */
    @TableField("remarks")
    private String remarks;

    /**
     * 经办人ID
     */
    @TableField("borker_id")
    private String borkerId;

    /**
     * 经办人名称
     */
    @TableField("borker_name")
    private String borkerName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }
    public String getOutOrIn() {
        return outOrIn;
    }

    public void setOutOrIn(String outOrIn) {
        this.outOrIn = outOrIn;
    }
    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }
    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }
    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }
    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getBorkerId() {
        return borkerId;
    }

    public void setBorkerId(String borkerId) {
        this.borkerId = borkerId;
    }
    public String getBorkerName() {
        return borkerName;
    }

    public void setBorkerName(String borkerName) {
        this.borkerName = borkerName;
    }

    @Override
    public String toString() {
        return "TStockItem{" +
        "id=" + id +
        ", billCode=" + billCode +
        ", outOrIn=" + outOrIn +
        ", warehouseId=" + warehouseId +
        ", warehouseName=" + warehouseName +
        ", goodCode=" + goodCode +
        ", num=" + num +
        ", unitPrice=" + unitPrice +
        ", totalPrice=" + totalPrice +
        ", createDate=" + createDate +
        ", remarks=" + remarks +
        ", borkerId=" + borkerId +
        ", borkerName=" + borkerName +
        "}";
    }
}
