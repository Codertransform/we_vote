package com.thinkgem.jeesite.modules.style.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 模板Entity
 * @author hww
 * @version 2019-03-24
 */
public class Style extends DataEntity<Style> {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 模板名称
	 */
	private String name;
	/**
	 * 参考图
	 */
	private String image;
	/**
	 * 平台id
	 */
	private Office office;
	
	public Style() {
		super();
	}

	public Style(String id){
		super(id);
	}

	@Length(min=1, max=64, message="模板名称长度必须介于 1 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
}