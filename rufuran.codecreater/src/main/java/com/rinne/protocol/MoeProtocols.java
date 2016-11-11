package com.rinne.protocol;

import java.util.ArrayList;
import java.util.List;

/**
 * 协议集
 * 
 * @author Hiroomi -> backend@program.dog
 * @date 2016年11月10日 下午4:37:57
 */
public class MoeProtocols {
	/**
	 * 协议名称
	 */
	private String packageName;

	/**
	 * 协议描述
	 */
	private String desc;

	/**
	 * 协议列表
	 */
	List<MoeProtocol> protocols = new ArrayList<>();

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<MoeProtocol> getProtocols() {
		return protocols;
	}

	public void setProtocols(List<MoeProtocol> protocols) {
		this.protocols = protocols;
	}

	@Override
	public String toString() {
		return "MoeProtocols [packageName=" + packageName + ", desc=" + desc + ", protocols=" + protocols + "]";
	}

	public void add(MoeProtocol protocol) {
		getProtocols().add(protocol);
	}

}
