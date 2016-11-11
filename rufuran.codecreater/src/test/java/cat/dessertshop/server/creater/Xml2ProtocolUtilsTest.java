package cat.dessertshop.server.creater;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.rinne.creater.Xml2ProtocolUtils;
import com.rinne.protocol.MoeProtocols;

/**
 * XML解析工具类测试类
 * 
 * @author Hiroomi -> backend@program.dog
 * @date 2016年11月10日 下午5:33:23
 */
public class Xml2ProtocolUtilsTest {

	@Test
	public void readXMLContent() {
		List<MoeProtocols> protocols = new Xml2ProtocolUtils().readXMLContent();
		if (protocols == null) {
			fail("协议对象为空！");
		} else {
			System.out.println(protocols);
		}
	}

}
