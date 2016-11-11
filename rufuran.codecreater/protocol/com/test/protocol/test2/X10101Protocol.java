package com.catstudio.moegirlcafe.cmd.com.test.protocol.test2;

import com.catstudio.dessertshop.protocol.utils.MoeProtocol;
import com.catstudio.moegirlcafe.cmd.MoeProtocolResult;
import com.catstudio.moegirlcafe.cmd.com.test.protocol.test2.X10101Request;
import com.catstudio.moegirlcafe.cmd.com.test.protocol.test2.X10101Response;

/** 
 * 测试用协议1 - 测试用协议描述1
 *
 * @Author Hiroomi -> backend@program.dog
 * @Date 2016-11-11 19:32:09
 *
 */
public class X10101Protocol extends MoeProtocol {

	private X10101Request msg;
	private X10101Response result;
	
	@Override
	public void exec() throws Exception {
		// 设置测量耗时起点(默认注释)
		// long start = System.currentTimeMillis();

		// TODO 插入service
		MoeProtocolResult<X10101Response> moeResult = null;
		// moeResult = service.getUserInfos(gameData, msg.userId, msg.userIds,
		// 		msg.maxResult, msg.containsOnlineStatus, msg.msgId, result);

		result = moeResult.getResult();
		
		// 打印耗时(默认注释)
		// System.out.println(result + " ---- " + "耗时" + (System.currentTimeMillis() - start) + "ms");
	}

}