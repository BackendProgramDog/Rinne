package com.rinne.creater;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.rinne.protocol.MoeParam;
import com.rinne.protocol.MoeParams;
import com.rinne.protocol.MoeProtocol;
import com.rinne.protocol.MoeProtocols;

/**
 * XML解析工具类
 * 
 * @author Hiroomi -> backend@program.dog
 * @date 2016年11月10日 下午4:17:37
 */
public class Xml2ProtocolUtils {
	/**
	 * @Desc XML转化成协议类工具方法
	 * @Author Hiroomi -> backend@program.dog
	 * @Date 2016年11月10日 下午5:04:19
	 * @return 协议集合
	 */
	public List<MoeProtocols> readXMLContent() {

		List<MoeProtocols> protocolses = new ArrayList<MoeProtocols>();

		SAXBuilder builder = new SAXBuilder();

		try {
			File protocolDir = new File(CreaterConst.DOCUMENT);

			if (protocolDir.exists() && protocolDir.isDirectory()) {

				String[] documentNames = protocolDir.list();

				for (String documentName : documentNames) {
					MoeProtocols protocols = new MoeProtocols();

					Document doc = builder.build(new File(CreaterConst.DOCUMENT + "/" + documentName));

					Element rootEl = doc.getRootElement();

					// 读取协议包名
					protocols.setPackageName(rootEl.getAttributeValue("package"));

					// 读取协议集描述
					protocols.setDesc(rootEl.getAttributeValue("desc"));

					// 获得所有协议
					List<Element> list = rootEl.getChildren();
					// List<Element> list = rootEl.getChildren("disk");
					for (Element el : list) {
						// 循环协议体

						MoeProtocol protocol = new MoeProtocol();

						// 获取协议号文本值
						String no = el.getChildText("no");
						protocol.setNo(readHex(no));
						// 获取name文本值
						String name = el.getChildText("name");
						protocol.setName(name);

						// 获取name文本值
						String desc = el.getChildText("desc");
						protocol.setDesc(desc);

						// 放入协议包名
						String packageName = protocols.getPackageName();
						protocol.setPackageName(packageName);

						// 获取子元素capacity文本值
						Element requestElement = el.getChild("request");
						MoeParams request = readParams(requestElement);
						protocol.setRequest(request);

						// 获取子元素reponse
						Element responseElement = el.getChild("response");
						MoeParams response = readParams(responseElement);
						protocol.setResponse(response);

						protocols.add(protocol);
					}

					protocolses.add(protocols);
				}
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return protocolses;
	}

	/**
	 * @Desc 将16进制字符串转换成Integer
	 * @Author Hiroomi -> backend@program.dog
	 * @Date 2016年11月10日 下午5:41:07
	 * @param no
	 *            16进制字符串
	 * @return 十进制整型对象
	 */
	private String readHex(String no) {
		String result = no;

		if (result.startsWith("0x0")) {
			result = result.replace("0x0", "");
		} else if (result.startsWith("0x")) {
			result = result.replace("0x", "");
		}

		return result;
	}

	/**
	 * @Desc 读取协议中的参数集
	 * @Author Hiroomi -> backend@program.dog
	 * @Date 2016年11月10日 下午5:19:08
	 * @param element
	 *            包含参数集的XML节点对象
	 * @return 参数集对象
	 */
	private MoeParams readParams(Element element) {
		MoeParams result = null;
		if (element != null) {
			result = new MoeParams();
			List<Element> list = element.getChildren();
			for (Element el : list) {
				// 循环参数集
				if (el != null) {
					String type = el.getAttributeValue("type");
					String attr = el.getAttributeValue("attr");
					String desc = el.getAttributeValue("desc");

					MoeParam param = new MoeParam(type, attr, desc);

					result.add(param);
				}
			}
		}
		return result;
	}

}
