package com.homedo.as.utils;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wanglonghao on 2017/3/31.
 */
public class CodeGenerator
{
        public static void main(String[] args) {
            AutoGenerator mpg = new AutoGenerator();

            // 全局配置
            GlobalConfig gc = new GlobalConfig();
            gc.setOutputDir("D://generate_as_0402");
            gc.setFileOverride(true);
            gc.setActiveRecord(false);
            gc.setEnableCache(false);// XML 二级缓存
            gc.setBaseResultMap(false);// XML ResultMap
            gc.setBaseColumnList(false);// XML columList
            gc.setAuthor("quyang");
            // 自定义文件命名，注意 %s 会自动填充表实体属性！
             gc.setMapperName("%sMapper");
             gc.setXmlName("%sMapper");
             gc.setServiceName("%sDao");
             gc.setServiceImplName("%sDaoImpl");
             //gc.setControllerName("%sAction");
             mpg.setGlobalConfig(gc);

            // 数据源配置
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setDbType(DbType.MYSQL);
            dsc.setTypeConvert(new MySqlTypeConvert(){
                // 自定义数据库表字段类型转换【可选】
                @Override
                public DbColumnType processTypeConvert(String fieldType) {
                    System.out.println("转换类型：" + fieldType);
                    return super.processTypeConvert(fieldType);
                }
            });
            dsc.setDriverName("com.mysql.jdbc.Driver");
            dsc.setUsername("admin");
            dsc.setPassword("Hello@123$");
            dsc.setUrl("jdbc:mysql://172.16.220.159:3306/lottery?autoReconnect=true&characterEncoding=UTF-8");
            mpg.setDataSource(dsc);

            // 策略配置
            StrategyConfig strategy = new StrategyConfig();
            // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
            //strategy.setTablePrefix(new String[] { "tlog_", "tsys_" });// 此处可以修改为您的表前缀
            strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
            //strategy.setInclude(new String[] { "user_task" }); // 需要生成的表

            strategy.setInclude(new String[] {"user_info","sx_info"});

//            strategy.setExclude(new String[] { "gd_category","provider_contract","provider_info","provider_level",
//                    "provider_qualification", "provider_sku","provider_sku_quotation_trace","qualification_items",
//                    "sku_info","user_task" });



            // strategy.setExclude(new String[]{"test"}); // 排除生成的表
            // 自定义实体父类
            // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
            // 自定义实体，公共字段
            // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
            // 自定义 mapper 父类
            // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
            // 自定义 service 父类
            // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
            // 自定义 service 实现类父类
            // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
            // 自定义 controller 父类
            // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
            // 【实体】是否生成字段常量（默认 false）
            // public static final String ID = "test_id";
            strategy.setEntityColumnConstant(false);
            // 【实体】是否为构建者模型（默认 false）
            // public User setName(String name) {this.name = name; return this;}
            // strategy.setEntityBuliderModel(true);
            mpg.setStrategy(strategy);

            // 包配置
            PackageConfig pc = new PackageConfig();
            pc.setParent("com.homedo.as");
            pc.setEntity("entity");
            pc.setMapper("mapper");
            pc.setService("dao");
            pc.setServiceImpl("dao.impl");
            pc.setXml("mapper.xml");
            mpg.setPackageInfo(pc);

            // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
            InjectionConfig cfg = new InjectionConfig() {
                @Override
                public void initMap() {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("abc", this.getConfig().getGlobalConfig().getAuthor() );
                    this.setMap(map);
                }
            };
            /*// 自定义 xxList.jsp 生成
            List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
            focList.add(new FileOutConfig("/template/list.jsp.vm") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输入文件名称
                    return "D://my_" + tableInfo.getEntityName() + ".jsp";
                }
            });
            cfg.setFileOutConfigList(focList);*/
            mpg.setCfg(cfg);

            // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/template 下面内容修改，
            // 放置自己项目的 src/main/resources/template 目录下, 默认名称一下可以不配置，也可以自定义模板名称
            // TemplateConfig tc = new TemplateConfig();
            // tc.setController("...");
            // tc.setEntity("...");
            // tc.setMapper("...");
            // tc.setXml("...");
            // tc.setService("...");
            // tc.setServiceImpl("...");
            // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
            // mpg.setTemplate(tc);

            // 执行生成
            mpg.execute();

            // 打印注入设置
            System.err.println(mpg.getCfg().getMap().get("abc"));
        }


}
