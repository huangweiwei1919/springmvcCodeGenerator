/*
 * 文件名：SqlCreaterWhere.java	 
 * 时     间：下午2:17:36
 * 作     者：hww      
 */
package sqlgen;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sqlgen.util.PropertyColumn;

/** 
 * @ClassName: SqlCreaterWhere 
 * @描述: (这里用一句话描述这个类的作用) 
 * @author hww
 * @date 2017年3月28日 下午2:17:36 
 */
public class SqlCreaterWhereCondition {

private final Logger logger = LoggerFactory.getLogger(this.getClass());


public String create(Connection conn,String tabName) throws SQLException, IOException, ClassNotFoundException{
	
	
	
	StringBuffer sb=new StringBuffer();
	
	ResultSet rs=conn.createStatement().executeQuery(" select * from "+tabName+" where 1=2");
	
	ResultSetMetaData rsmd=rs.getMetaData();
	
	
	String[] strs=new String[rsmd.getColumnCount()];
	for(int i=1;i<rsmd.getColumnCount()+1;i++){
		strs[i-1]=rsmd.getColumnName(i);
	}
	
	
	
	sb.append("\t\n");
	
	
	
	for(int i=0;i<strs.length;i++){
		if(!strs[i].toLowerCase().equals("id")){				
			sb.append("\t\t\t<if test=\" "+PropertyColumn.column2Property(strs[i].toLowerCase())+"!=null \">\t\n");
			sb.append("\t\t\t\t and "+ strs[i]+"=#{"+PropertyColumn.column2Property(strs[i].toLowerCase())+"}  \t\n\t\t\t</if>\t\n");
		}
	}
	
	
	
	return sb.toString();
}

}
