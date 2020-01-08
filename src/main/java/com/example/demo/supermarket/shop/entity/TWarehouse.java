package com.example.demo.supermarket.shop.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * <p>
 * 仓库表
 * </p>
 *
 * @author youkehai
 * @since 2019-12-26
 */
public class TWarehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 名称
     */
    @TableField("name")
    private String name;
    
    /**
     * 地址
     */
    @TableField("address")
    private String address;

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
    public String getCreateId() {
        return createId;
    }

    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
        return "TWarehouse{" +
        "id=" + id +
        ", name=" + name +
        ", createId=" + createId +
        ", createName=" + createName +
        ", createDate=" + createDate +
        "}";
    }
}
