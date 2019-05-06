package com.thinkgem.jeesite.modules.git.entity;

import com.thinkgem.jeesite.modules.gitcategory.entity.GitCategory;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 礼物Entity
 *
 * @author hww
 * @version 2019-03-19
 */
public class Git extends DataEntity<Git> {

    private static final long serialVersionUID = 1L;
    /**
     * 图标
     */
    private String icon;
    /**
     * 票数
     */
    private Integer ticket;

    /**
     * 礼物名称
     */
    private String name;

    /**
     * 价格
     */
    private Integer price;
    /**
     * 礼物图标类别
     */
    private GitCategory gitCategory;

    public Git() {
        super();
    }

    public Git(String id) {
        super(id);
    }

    @Length(min = 1, max = 1024, message = "图标长度必须介于 1 和 1024 之间")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @NotNull(message = "票数不能为空")
    public Integer getTicket() {
        return ticket;
    }

    public void setTicket(Integer ticket) {
        this.ticket = ticket;
    }

    @Length(min = 1, max = 64, message = "礼物名称长度必须介于 1 和 64 之间")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "价格不能为空")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @JsonBackReference
    @NotNull(message = "礼物图标类别不能为空")

    public GitCategory getGitCategory() {
        return gitCategory;
    }

    public void setGitCategory(GitCategory gitCategory) {
        this.gitCategory = gitCategory;
    }

}