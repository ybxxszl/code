package com.wjy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GeneratorDisplay {

	public static void main(String[] args) throws Exception {

		try {
			GeneratorDisplay generatorSqlmap = new GeneratorDisplay();
			generatorSqlmap.generator();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("操作成功");

	}

	public void generator() throws Exception {

		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);

	}

}
