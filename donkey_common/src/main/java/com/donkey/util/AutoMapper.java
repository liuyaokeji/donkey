package com.donkey.util;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 代码生成器
 * @author liu'yao
 */
public class AutoMapper {

    public static void main(String[] args) {
        //创建AutoGenerator，mp中对象生成器
        AutoGenerator ag = new AutoGenerator();
        //设置全局配置
        GlobalConfig gc = new GlobalConfig();
        //设置代码生成位置
        String path = System.getProperty("user.dir");
        System.out.println(path);

        gc.setOutputDir(path+"/donkey_core/src/main/java/");
        //设置生成的类的名称
        gc.setMapperName("%sMapper");//所有Dao类都是以Mapper结尾的
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        //设置作者
        gc.setAuthor("liu'yao");
        //设置主键配置
        gc.setIdType(IdType.AUTO);
        ag.setGlobalConfig(gc);

        //设置数据源FataSource
        DataSourceConfig ds = new DataSourceConfig();
        // 注意：填入application.yml文件中的配置即可
        ds.setUrl("jdbc:mysql://39.105.8.236:3000/donkey_dev?useUnicode=true&charaterEncoding=utf-8&SSL=true&serverTimezone=Asia/Shanghai");
        ds.setDriverName("com.mysql.cj.jdbc.Driver");
        ds.setUsername("donkey");
        ds.setPassword("123");
        ag.setDataSource(ds);

        //设置package信息
        PackageConfig pc = new PackageConfig();
        //设置模块名称，相当于包名，在包的下面有mapper，service，controller
        pc.setModuleName("donkey");
        //设置父包名称
        pc.setParent("com");
        ag.setPackageInfo(pc);

        //设置策略
        StrategyConfig sc = new StrategyConfig();
        // 配置数据表与实体类名之间映射的策略
        sc.setNaming(NamingStrategy.underline_to_camel);
        // 配置数据表的字段与实体类的属性名之间映射的策略
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        // 配置 lombok 模式
        sc.setEntityLombokModel(true);
        // 配置 rest 风格的控制器（@RestController）
        sc.setRestControllerStyle(true);
        // 配置驼峰转连字符
        sc.setControllerMappingHyphenStyle(true);
        ag.setStrategy(sc);

        //执行代码生成
        ag.execute();

    }
}
