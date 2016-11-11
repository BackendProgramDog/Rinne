package com.rinne.creater;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.rinne.protocol.MoeProtocol;
import com.rinne.protocol.MoeProtocols;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * @Desc 代码模板生成工具
 * @Author Hiroomi -> backend@program.dog
 * @Date 2016年11月11日 下午6:27:38
 */
public class FreemarkerUtil {

	// 创建Freemaker的Configuration
	private final static Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
	static {
		// 设定去哪里读取相应的ftl模板文件
		try {
			cfg.setDirectoryForTemplateLoading(new File(CreaterConst.TEMPLATE));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Set the preferred charset template files are stored in. UTF-8
		// is
		// a good choice in most applications:
		cfg.setDefaultEncoding("UTF-8");
		// Sets how errors will appear.
		// During web page *development*
		// TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	}

	/**
	 * @Desc 根据模板文件名获取模板对象方法
	 * @Author Hiroomi -> backend@program.dog
	 * @Date 2016年11月11日 下午6:32:58
	 * @param name
	 *            模板文件名
	 * @return 模板对象
	 */
	public Template getTemplate(String name) {
		try {
			// 在模板文件目录中找到名称为name的文件
			Template temp = cfg.getTemplate(name);
			return temp;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @Desc 生成协议相关的各种代码
	 * @Author Hiroomi -> backend@program.dog
	 * @Date 2016年11月11日 下午7:22:48
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static void createProtocol() throws IOException, TemplateException {
		FreemarkerUtil util = new FreemarkerUtil();

		// Map<String, String> model = new HashMap<String, String>();

		Xml2ProtocolUtils x2p = new Xml2ProtocolUtils();

		List<MoeProtocols> protocolses = x2p.readXMLContent();

		for (MoeProtocols protocols : protocolses) {

			for (MoeProtocol protocol : protocols.getProtocols()) {

				// String outDirPath = CreaterConst.PROTOCOL + "/" +
				// protocol.getPackageName() + "/";
				File outDir = null;

				// 生成Request
				String outRequestDirPath = CreaterConst.OUT_TARGET_DIR + "/" + getPackagePath(protocol.getPackageName())
						+ "/";
				outDir = new File(outRequestDirPath);
				mkParentDir(outDir);
				Template requestTemplate = util.getTemplate(CreaterConst.REQUEST + CreaterConst._TEMPLATE);
				FileWriter outRequest = new FileWriter(
						outRequestDirPath + CreaterConst.PROTOCOL_START + protocol.getNo() + CreaterConst.REQUEST_END);
				requestTemplate.process(protocol, outRequest);

				// 生成Response
				String outResponseDirPath = CreaterConst.OUT_TARGET_DIR + "/"
						+ getPackagePath(protocol.getPackageName()) + "/";
				outDir = new File(outResponseDirPath);
				mkParentDir(outDir);
				Template responseTemplate = util.getTemplate(CreaterConst.RESPONSE + CreaterConst._TEMPLATE);
				FileWriter outResponse = new FileWriter(outResponseDirPath + CreaterConst.PROTOCOL_START
						+ protocol.getNo() + CreaterConst.RESPONSE_END);
				responseTemplate.process(protocol, outResponse);

				// 生成Protocol
				String outProtocolDirPath = CreaterConst.OUT_TARGET_DIR + "/"
						+ getPackagePath(protocol.getPackageName()) + "/";
				outDir = new File(outProtocolDirPath);
				mkParentDir(outDir);
				Template protocolTemplate = util.getTemplate(CreaterConst.OUT_TARGET_DIR + CreaterConst._TEMPLATE);
				FileWriter outProtocol = new FileWriter(outProtocolDirPath + CreaterConst.PROTOCOL_START
						+ protocol.getNo() + CreaterConst.PROTOCOL_END);
				protocolTemplate.process(protocol, outProtocol);

			}
		}
	}

	/**
	 * @Desc 如果父目录不存在，自动创建所有需要的父目录
	 * @Author Hiroomi -> backend@program.dog
	 * @Date 2016年11月11日 下午7:23:16
	 * @param outDir
	 */
	private static void mkParentDir(File outDir) {
		if (!outDir.exists()) {
			// mkdirs是创建多级目录,而mkdir是创建单级目录;
			outDir.mkdirs();
		}
	}

	/**
	 * @Desc 通过包名获取生成文件的目标目录名称
	 * @Author Hiroomi -> backend@program.dog
	 * @Date 2016年11月11日 下午7:24:04
	 * @param packageName
	 * @return
	 */
	private static String getPackagePath(String packageName) {
		return packageName != null ? packageName.replace(".", "/") + "/" : "";
	}
}