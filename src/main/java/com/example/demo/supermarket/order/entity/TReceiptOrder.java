package com.example.demo.supermarket.order.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 入库表
 * </p>
 *
 * @author youkehai
 * @since 2019-12-26
 */
public class TReceiptOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 编号
     */
    @TableField("code")
    private String code;

    /**
     * 出库总数量
     */
    @TableField("num")
    private String num;

    /**
     * 仓库ID
     */
    @TableField("warehouse_id")
    private String warehouseId;

    /**
     * 仓库名称
     */
    @TableField("warehouse_name")
    private String warehouseName;

    /**
     * 入库日期
     */
    @TableField("receipt_date")
    private LocalDateTime receiptDate;

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

    /**
     * 出库金额
     */
    @TableField("receipt_price")
    private BigDecimal receiptPrice;

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
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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
    public LocalDateTime getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(LocalDateTime receiptDate) {
        this.receiptDate = receiptDate;
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
    public BigDecimal getReceiptPrice() {
        return receiptPrice;
    }

    public void setReceiptPrice(BigDecimal receiptPrice) {
        this.receiptPrice = receiptPrice;
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
        return "TReceiptOrder{" +
        "id=" + id +
        ", code=" + code +
        ", num=" + num +
        ", warehouseId=" + warehouseId +
        ", warehouseName=" + warehouseName +
        ", receiptDate=" + receiptDate +
        ", borkerId=" + borkerId +
        ", borkerName=" + borkerName +
        ", receiptPrice=" + receiptPrice +
        ", createId=" + createId +
        ", createName=" + createName +
        ", createDate=" + createDate +
        "}";
    }
}
