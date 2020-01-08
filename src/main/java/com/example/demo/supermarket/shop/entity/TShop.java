package com.example.demo.supermarket.shop.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author youkehai
 * @since 2019-12-26
 */
public class TShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableField(exist=false)
    private String typeName;
    @TableField(exist=false)
    private String srmName;
    /**
     * id
     */
    @NotNull
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 商品名称
     */
    @TableField("name")
    private String name;

    /**
     * 编号
     */
    @TableField("code")
    private String code;

    /**
     * 编号
     */
    @TableField("type_id")
    private String typeId;

    /**
     * 单位
     */
    @TableField("unit")
    private String unit;

    /**
     * 供应商ID
     */
    @TableField("srm_id")
    private String srmId;

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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getSrmId() {
        return srmId;
    }

    public void setSrmId(String srmId) {
        this.srmId = srmId;
    }
    public String getCreateId() {
        return createId;
    }

    public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getSrmName() {
		return srmName;
	}

	public void setSrmName(String srmName) {
		this.srmName = srmName;
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
        return "TShop{" +
        "id=" + id +
        ", name=" + name +
        ", code=" + code +
        ", typeId=" + typeId +
        ", unit=" + unit +
        ", srmId=" + srmId +
        ", createId=" + createId +
        ", createName=" + createName +
        ", createDate=" + createDate +
        "}";
    }
}
