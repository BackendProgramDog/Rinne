package cat.dessertshop.server.creater;

import java.io.IOException;

import org.junit.Test;

import com.rinne.creater.FreemarkerUtil;

import freemarker.template.TemplateException;

/**
 * 模板工具类测试类
 * 
 * @author Hiroomi -> backend@program.dog
 * @date 2016年11月11日 下午4:41:44
 */
public class FreemarkerUtilTest extends FreemarkerUtil {

	@Test
	public void test() throws IOException, TemplateException {

		FreemarkerUtil.createProtocol();

	}

}
