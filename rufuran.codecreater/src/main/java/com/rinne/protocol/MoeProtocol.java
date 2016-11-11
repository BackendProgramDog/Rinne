package com.rinne.protocol;

/**
 * 协议体
 * 
 * @author Hiroomi -> backend@program.dog
 * @date 2016年11月10日 下午4:37:57
 */
public class MoeProtocol {
	/**
	 * 协议号
	 */
	private String no;

	/**
	 * 协议名称
	 */
	private String name;

	/**
	 * 协议描述
	 */
	private String desc;

	/**
	 * 协议入参
	 */
	private MoeParams request;

	/**
	 * 协议出参
	 */
	private MoeParams response;

	/**
	 * 协议包名
	 */
	private String packageName;

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public MoeParams getRequest() {
		return request;
	}

	public void setRequest(MoeParams request) {
		this.request = request;
	}

	public MoeParams getResponse() {
		return response;
	}

	public void setResponse(MoeParams response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "MoeProtocol [no=" + no + ", name=" + name + ", desc=" + desc + ", request=" + request + ", response="
				+ response + "]";
	}

}
