package com.example.demo.supermarket.shop.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * <p>
 * 供应商表
 * </p>
 *
 * @author youkehai
 * @since 2019-12-26
 */
public class TSrmInfo implements Serializable {

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
     * 联系人
     */
    @TableField("person")
    private String person;
    /**
     * 联系号码
     */
    @TableField("phone")
    private String phone;

    /**
     * 合作状态(0正常1取消合作)
     */
    @TableField("status")
    private String status;

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
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
        return "TSrmInfo{" +
        "id=" + id +
        ", name=" + name +
        ", status=" + status +
        ", createId=" + createId +
        ", createName=" + createName +
        ", createDate=" + createDate +
        "}";
    }
}
