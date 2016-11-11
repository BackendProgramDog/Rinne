package com.catstudio.moegirlcafe.cmd.com.test.protocol.test2;

import java.util.ArrayList;

import com.catstudio.moegirlcafe.cmd.Request;
import com.catstudio.moegirlcafe.statics.ProtocalNo;

/**
 * 其他玩家信息-请求
 * 
 * @author Hiroomi -> backend@program.dog
 * @Date 2016-11-11 19:32:09
 *
 */
public class X10101Request extends Request {

	/** 测试用输入参数1 */
	public String testRequestParam1;
	
	/** 测试用输入参数2 */
	public Integer testRequestParam2;
	
	public X10101Request() {
	}

	public X10101Request(
	int msgId
	,String testRequestParam1
	,Integer testRequestParam2
	) {
		this.msgType = ProtocalNo.X10101;
		this.msgId = msgId;
		this.testRequestParam1 = testRequestParam1;
		this.testRequestParam2 = testRequestParam2;
	}

}