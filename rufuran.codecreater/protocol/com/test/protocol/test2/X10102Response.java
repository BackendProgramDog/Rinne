package com.catstudio.moegirlcafe.cmd.com.test.protocol.test2;

import java.util.ArrayList;

import com.catstudio.moegirlcafe.cmd.Response;
import com.catstudio.moegirlcafe.statics.ProtocalNo;

/**
 * 其他玩家信息-请求
 * 
 * @author Hiroomi -> backend@program.dog
 * @Date 2016-11-11 19:32:09
 * 
 */
public class X10102Response extends Response {

	/** 测试用输出参数1 */
	public String testResponseParam1;
	
	/** 测试用输出参数2 */
	public Integer testResponseParam2;
	
	/** 测试用输出参数3 */
	public Integer testResponseParam3;
	
	public X10102Response() {
	}

	public X10102Response(
	int msgId
	,String testResponseParam1
	,Integer testResponseParam2
	,Integer testResponseParam3
	) {
		this.msgType = ProtocalNo.X10102;
		this.msgId = msgId;
		this.testResponseParam1 = testResponseParam1;
		this.testResponseParam2 = testResponseParam2;
		this.testResponseParam3 = testResponseParam3;
	}

}