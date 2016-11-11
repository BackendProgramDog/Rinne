package com.rinne.protocol;

/**
 * 协议参数类
 * 
 * @author Hiroomi -> backend@program.dog
 * @date 2016年11月10日 下午4:43:57
 */
public class MoeParam {

	/**
	 * 参数类型
	 */
	private String type;

	/**
	 * 参数属性名
	 */
	private String attr;

	/**
	 * 参数描述
	 */
	private String desc;

	public MoeParam() {
		super();
	}

	public MoeParam(String type, String attr, String desc) {
		super();
		this.type = type;
		this.attr = attr;
		this.desc = desc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAttr() {
		return attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "MoeParam [type=" + type + ", attr=" + attr + ", desc=" + desc + "]";
	}

}
