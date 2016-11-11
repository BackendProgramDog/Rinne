package com.rinne.protocol;

import java.util.ArrayList;
import java.util.List;

/**
 * 协议参数集
 * 
 * @author Hiroomi -> backend@program.dog
 * @date 2016年11月10日 下午4:40:40
 */
public class MoeParams {
	/**
	 * 参数列表，参数顺序不分先后
	 */
	private List<MoeParam> params = new ArrayList<MoeParam>();

	public List<MoeParam> getParams() {
		return params;
	}

	public void setParams(List<MoeParam> params) {
		this.params = params;
	}

	/**
	 * @Desc 将参数对象添加至参数集中
	 * @Author Hiroomi -> backend@program.dog
	 * @Date 2016年11月10日 下午5:29:25
	 * @param param
	 *            参数对象
	 */
	public void add(MoeParam param) {
		params.add(param);
	}

	@Override
	public String toString() {
		return "MoeParams [params=" + params + "]";
	}

}
