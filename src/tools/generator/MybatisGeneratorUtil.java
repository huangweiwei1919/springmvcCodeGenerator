
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import sqlgen.SqlCreaterEntity;
import sqlgen.SqlCreaterInsert;
import sqlgen.SqlCreaterInsertBatch;
import sqlgen.SqlCreaterInsertNotIf;
import sqlgen.SqlCreaterSelect;
import sqlgen.SqlCreaterUpdate;
import sqlgen.util.ConnectionGen;

import com.earlyzen.core.util.FileUtil;
import com.earlyzen.core.util.NewIOUtil;

public class MybatisGeneratorUtil {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {

		String targetProject = "src/main/java";
		String targetProjectTest = "src/tools/java";
		String projectPath = "";
		String description = "";
		String pack = "";
		String tableName = "";
		String tablePrimaryKeyType = "";
		String domainObjectName = "";
		String firstLowerDomainObjectName = "";
		String mapperXmlFlag = "";
		String mapperJavaFlag = "";
		String entityFlag = "";
		String testFlag = "";
		String createMode = "1";
		String serviceFlag = "";
		String controllerFlag = "";
		String author = System.getProperty("user.name");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		
		SqlCreaterInsert sqlCreaterInsert = new SqlCreaterInsert();
		SqlCreaterInsertNotIf sqlCreaterInsertNotIf = new SqlCreaterInsertNotIf();
		SqlCreaterSelect sqlCreaterSelect = new SqlCreaterSelect();
		SqlCreaterUpdate sqlCreaterUpdate = new SqlCreaterUpdate();
		SqlCreaterEntity sqlCreaterEntity = new SqlCreaterEntity();
		SqlCreaterInsertBatch sqlCreaterInsertBatch = new SqlCreaterInsertBatch();

		Map<String, String> replaceMap = new HashMap<String, String>();

		System.out.println("------------------start generator ...");

		String path = (MybatisGeneratorUtil.class.getResource("mybatisGenConfig.xml").getFile().replaceAll("%20", " "));

		File genConfigFile = new File(path);
		projectPath = genConfigFile.getParentFile().getParentFile().getParentFile().getAbsolutePath().replaceAll("%20",
				" ");

		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(genConfigFile);
		Element root = document.getRootElement();

		for (Iterator<Element> i = (Iterator<Element>) root.elementIterator(); i.hasNext();) {
			Element el = (Element) i.next();
			if ("description".equals(el.getName())) {
				description = el.getTextTrim();
				System.out.println(" set description value is " + el.getTextTrim());
			}else if ("pack".equals(el.getName())) {
				pack = el.getTextTrim();
				System.out.println(" set pack value is " + el.getTextTrim());
			}else if ("tableName".equals(el.getName())) {
				tableName = el.getTextTrim();
				System.out.println(" set tableName value is " + el.getTextTrim());
			}else if ("tablePrimaryKeyType".equals(el.getName())) {
				tablePrimaryKeyType = el.getTextTrim();
				System.out.println(" set tablePrimaryKeyType value is " + el.getTextTrim());
			}else if ("domainObjectName".equals(el.getName())) {
				domainObjectName = el.getTextTrim();
				String firstLetter = domainObjectName.substring(0,1);
				firstLowerDomainObjectName = domainObjectName.replaceFirst(firstLetter, firstLetter.toLowerCase());
				System.out.println(" set domainObjectName value is " + el.getTextTrim());
			}else if ("mapperXmlFlag".equals(el.getName())) {
				mapperXmlFlag = el.getTextTrim();
				System.out.println(" set mapperXmlFlag value is " + el.getTextTrim());
			}else if ("mapperJavaFlag".equals(el.getName())) {
				mapperJavaFlag = el.getTextTrim();
				System.out.println(" set mapperJavaFlag value is " + el.getTextTrim());
			}else if ("entityFlag".equals(el.getName())) {
				entityFlag = el.getTextTrim();
				System.out.println(" set entityFlag value is " + el.getTextTrim());
			}else if ("testFlag".equals(el.getName())) {
				testFlag = el.getTextTrim();
				System.out.println(" set testFlag value is " + el.getTextTrim());
			}else if ("serviceFlag".equals(el.getName())) {
				serviceFlag = el.getTextTrim();
				System.out.println(" set serviceFlag value is " + el.getTextTrim());
			}else if ("controllerFlag".equals(el.getName())) {
				controllerFlag = el.getTextTrim();
				System.out.println(" set controllerFlag value is " + el.getTextTrim());
			}else if ("createMode".equals(el.getName())) {
//				try {
//					createMode = Integer.parseInt(el.getTextTrim()) + "";
//				} catch (Exception e) {
//					createMode = "0";
//				}
//
//				if (createMode.equals("0") || createMode.equals("1")) {
//					
//				}else {
//					createMode = "0";
//				}
//				System.out.println(" set createMode value is " + createMode);
			}
		}

		// 创建代码文件夹
		String srcBase = targetProject + "/" + pack.replace(".", "/");
		File f = new File(projectPath + "/" + srcBase);
		if (!f.exists()) {
			f.mkdirs();
		}

		OutputStream os = null;
		StringBuffer sb = new StringBuffer();
		String outContent = null;
		File folder = null;
		File createFile = null;
		Connection conn = ConnectionGen.getConection();

		// 定义需要替换的变量
		replaceMap.put("description", description);
		replaceMap.put("initUpdate", "修改参数");
		replaceMap.put("tableName", tableName);
		replaceMap.put("domainObjectName", domainObjectName);
		replaceMap.put("tablePrimaryKeyType", tablePrimaryKeyType);
		replaceMap.put("firstLowerDomainObjectName", firstLowerDomainObjectName);
		replaceMap.put("requestMappingName", domainObjectName.toLowerCase());
		replaceMap.put("author", author);
		replaceMap.put("date", date);
		replaceMap.put("srcPack", pack);

		replaceMap.put("insert", sqlCreaterInsertNotIf.create(conn, tableName,tablePrimaryKeyType));
		if(tablePrimaryKeyType.equals("Integer")){
			replaceMap.put("splitMethod", "splitStringIds");
			String insertStr = replaceMap.get("insert");
			if(insertStr.contains("#{id},")){
				replaceMap.put("autoGeneratedKeys", "useGeneratedKeys=\"true\" keyProperty=\"zid\"");
			}else{
				replaceMap.put("autoGeneratedKeys", "useGeneratedKeys=\"true\" keyProperty=\"id\"");
			}
		}else if(tablePrimaryKeyType.equals("String")){
			replaceMap.put("splitMethod", "splitStringIdsStr");
			replaceMap.put("autoGeneratedKeys", "");
		}
		
		replaceMap.put("insertWithIf", sqlCreaterInsert.create(conn, tableName,tablePrimaryKeyType));
		replaceMap.put("insertBatch", sqlCreaterInsertBatch.create(conn, tableName));
		replaceMap.put("insertBatchWithIf", sqlCreaterInsertBatch.createWithIf(conn, tableName));

		replaceMap.put("update", sqlCreaterUpdate.create(conn, tableName));
		replaceMap.put("updateWithIf", sqlCreaterUpdate.create(conn, tableName, 0));
		replaceMap.put("updateBatch", sqlCreaterUpdate.createBatch(conn, tableName));
		replaceMap.put("updateBatchWithIf", sqlCreaterUpdate.createBatchWithIf(conn, tableName, 0));

		replaceMap.put("find", sqlCreaterSelect.create(conn, tableName));
		replaceMap.put("delete", "delete from " + tableName + " ");
		replaceMap.put("count_*", "SELECT COUNT(*) from " + tableName + " _tbl");

		replaceMap.put("entityProperty", sqlCreaterEntity.create(conn, tableName));

		// -------生成 src 下 entity
		if ("1".equals(entityFlag)) {
			folder = new File(projectPath + "/" + srcBase + "/model");
			if (!folder.exists()) {
				folder.mkdirs();
			}
			createFile = new File(projectPath + "/" + srcBase + "/model/" + domainObjectName + ".java");
			if (!createFile.exists()) {
				createFile.delete();
			}
			sb = new StringBuffer();
			sb = NewIOUtil.readeFile(projectPath + "/codetemplete/model/Entity.java", "UTF-8");

			outContent = sb.toString();

			outContent = executeReplace(outContent, replaceMap);

			os = new FileOutputStream(createFile);
			FileUtil.writeFile(projectPath + "/" + srcBase + "/model/" + domainObjectName + ".java", outContent);
		}
		// -------生成 src 下 entity end

		// -------生成 src 下 mapper xml
		if ("1".equals(mapperXmlFlag)) {
			folder = new File(projectPath + "/" + srcBase + "/dao/mapper");
			if (!folder.exists()) {
				folder.mkdirs();
			}
			createFile = new File(projectPath + "/" + srcBase + "/dao/mapper/" + domainObjectName + "Mapper.xml");
			if (!createFile.exists()) {
				createFile.delete();
			}
			sb = new StringBuffer();

			if (createMode.equals("0"))
				sb = NewIOUtil.readeFile(projectPath + "/codetemplete/dao/mapper/mapperSimple.xml", "UTF-8");

			if (createMode.equals("1"))
				sb = NewIOUtil.readeFile(projectPath + "/codetemplete/dao/mapper/mapper.xml", "UTF-8");

			outContent = sb.toString();

			outContent = executeReplace(outContent, replaceMap);

			os = new FileOutputStream(createFile);
			FileUtil.writeFile(projectPath + "/" + srcBase + "/dao/mapper/" + domainObjectName + "Mapper.xml",
					outContent);
		}
		// -------生成 src 下mapper xml end

		// -------生成 src 下 mapper java
		if ("1".equals(mapperJavaFlag)) {
			folder = new File(projectPath + "/" + srcBase + "/dao/mapper");
			if (!folder.exists()) {
				folder.mkdirs();
			}
			createFile = new File(projectPath + "/" + srcBase + "/dao/mapper/" + domainObjectName + "Mapper.java");
			if (!createFile.exists()) {
				createFile.delete();
			}
			sb = new StringBuffer();
			sb = NewIOUtil.readeFile(projectPath + "/codetemplete/dao/mapper/mapper.java", "UTF-8");

			outContent = sb.toString();

			outContent = executeReplace(outContent, replaceMap);

			os = new FileOutputStream(createFile);
			FileUtil.writeFile(projectPath + "/" + srcBase + "/dao/mapper/" + domainObjectName + "Mapper.java",
					outContent);
		}
		// -------生成 src 下mapper xml end

		// -------生成 src 下 service java
		if ("1".equals(serviceFlag)) {
			folder = new File(projectPath + "/" + srcBase + "/service");
			if (!folder.exists()) {
				folder.mkdirs();
			}
			createFile = new File(projectPath + "/" + srcBase + "/service/I" + domainObjectName + "Service.java");
			if (!createFile.exists()) {
				createFile.delete();
			}
			sb = new StringBuffer();
			sb = NewIOUtil.readeFile(projectPath + "/codetemplete/service/IService.java", "UTF-8");

			outContent = sb.toString();

			outContent = executeReplace(outContent, replaceMap);

			os = new FileOutputStream(createFile);
			FileUtil.writeFile(projectPath + "/" + srcBase + "/service/I" + domainObjectName + "Service.java",
					outContent);
			
			// -------生成 src 下 service impl java
			folder = new File(projectPath + "/" + srcBase + "/service/impl");
			if (!folder.exists()) {
				folder.mkdirs();
			}
			createFile = new File(
					projectPath + "/" + srcBase + "/service/impl/" + domainObjectName + "ServiceImpl.java");
			if (!createFile.exists()) {
				createFile.delete();
			}
			sb = new StringBuffer();
			sb = NewIOUtil.readeFile(projectPath + "/codetemplete/service/impl/ServiceImpl.java", "UTF-8");

			outContent = sb.toString();

			outContent = executeReplace(outContent, replaceMap);

			os = new FileOutputStream(createFile);
			FileUtil.writeFile(projectPath + "/" + srcBase + "/service/impl/" + domainObjectName + "ServiceImpl.java",
					outContent);

		}
		
		// -------生成 src 下 controller java start
		if ("1".equals(controllerFlag)) {
			folder = new File(projectPath + "/" + srcBase + "/controller");
			if (!folder.exists()) {
				folder.mkdirs();
			}
			createFile = new File(projectPath + "/" + srcBase + "/controller/" + domainObjectName + "Controller.java");
			if (!createFile.exists()) {
				createFile.delete();
			}
			sb = new StringBuffer();
			sb = NewIOUtil.readeFile(projectPath + "/codetemplete/controller/Controller.java", "UTF-8");

			outContent = sb.toString();
			outContent = executeReplace(outContent, replaceMap);
			os = new FileOutputStream(createFile);
			FileUtil.writeFile(projectPath + "/" + srcBase + "/controller/" + domainObjectName + "Controller.java",
					outContent);
		}
		// -------生成 src 下 controller end

		// -------生成 test src 下 xxtest java start
		if ("1".equals(testFlag)) {
			// 创建测代码文件夹
			String srcTestBase = targetProjectTest + "/" + pack.replace(".", "/");
			f = new File(projectPath + "/" + srcTestBase);
			if (!f.exists()) {
				f.mkdirs();
			}

			folder = new File(projectPath + "/" + srcTestBase + "/");
			if (!folder.exists()) {
				folder.mkdirs();
			}
			
			createFile = new File(projectPath + "/" + srcTestBase + "/" + domainObjectName + "Test.java");
			if (!createFile.exists()) {
				createFile.delete();
			}
			sb = new StringBuffer();
			sb = NewIOUtil.readeFile(projectPath + "/codetemplete/test/Test.java", "UTF-8");

			outContent = sb.toString();

			outContent = executeReplace(outContent, replaceMap);

			os = new FileOutputStream(createFile);
			FileUtil.writeFile(projectPath + "/" + srcTestBase + "/" + domainObjectName + "Test.java", outContent);
		}
		// -------生成 test src 下 xxtest java end

		if (os != null)
			os.close();
		conn.close();
		System.out.println("------------------end generator!");
	}

	private static String executeReplace(String outContent, Map<String, String> replaceMap) {
		for (String str : replaceMap.keySet()) {
			outContent = outContent.replace("##{" + str + "}##", replaceMap.get(str));
			if(str.equals("entityProperty")){
				if(outContent.contains("private Date")){
					outContent = outContent.replace("##{importDate}##", "import java.util.Date;");
				}else{
					outContent = outContent.replace("##{importDate}##", "");
				}
			}
		}
		
		return outContent;
	}

	public static String getFirstLower(String str) {
		return str.subSequence(0, 1).toString().toLowerCase() + str.subSequence(1, str.length());
	}

	public static String getFirstUpper(String str) {
		return str.subSequence(0, 1).toString().toUpperCase() + str.subSequence(1, str.length());
	}

}