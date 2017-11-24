package sqlgen;



import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import sqlgen.util.PropertyColumn;






public class SqlCreaterUpdateNotIf  {

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
		sb.append("\t\tupdate "+tabName+" \t\n");
		sb.append("\t\tset \t\n");
		
		for(int i=0;i<strs.length;i++){
			if(!strs[i].toLowerCase().equals("id")){
				if(i==strs.length-1)
					sb.append("\t\t"+strs[i]+"=#{"+PropertyColumn.column2Property(strs[i].toLowerCase())+"}\t\n");
				else{
					sb.append("\t\t"+strs[i]+"=#{"+PropertyColumn.column2Property(strs[i].toLowerCase())+"},\t\n");
				}
			}
		}
		sb.append("\t\twhere \t\n");
		sb.append("\t\tID=#{id} \t\n");
		
		return sb.toString();
	}
	
	public String create(Connection conn,String tabName,int type) throws SQLException, IOException, ClassNotFoundException{
		
		
		
		StringBuffer sb=new StringBuffer();
		
		ResultSet rs=conn.createStatement().executeQuery(" select * from "+tabName+" where 1=2");
		
		ResultSetMetaData rsmd=rs.getMetaData();
		
		
		String[] strs=new String[rsmd.getColumnCount()];
		for(int i=1;i<rsmd.getColumnCount()+1;i++){
			strs[i-1]=rsmd.getColumnName(i);
		}
		
		
		
		sb.append("\t\n");
		sb.append("\t\tupdate "+tabName+" \t\n");
		sb.append("\t\tset \t\n");
		sb.append("\t\t<trim prefix=\"\" suffix=\"\" suffixOverrides=\",\" >\n");
		
		
		for(int i=0;i<strs.length;i++){
			if(!strs[i].toLowerCase().equals("id")){				
				sb.append("\t\t\t<if test=\" "+PropertyColumn.column2Property(strs[i].toLowerCase())+"!=null \">\t\n");
				sb.append("\t\t\t\t"+strs[i]+"=#{"+PropertyColumn.column2Property(strs[i].toLowerCase())+"},\t\n\t\t\t</if>\t\n");
			}
		}
		sb.append("\t\t</trim>\t\n");
		sb.append("\t\twhere \t\n");
		sb.append("\t\tID=#{id} \t\n");
		
		return sb.toString();
	}
	
	public String createBatch(Connection conn,String tabName) throws SQLException, IOException, ClassNotFoundException{
		
		
		
		StringBuffer sb=new StringBuffer();
		
		ResultSet rs=conn.createStatement().executeQuery(" select * from "+tabName+" where 1=2");
		
		ResultSetMetaData rsmd=rs.getMetaData();
		
		
		String[] strs=new String[rsmd.getColumnCount()];
		for(int i=1;i<rsmd.getColumnCount()+1;i++){
			strs[i-1]=rsmd.getColumnName(i);
		}
		
		
		
		sb.append("\t\n");
		sb.append("\t\tupdate "+tabName+" \t\n");
		sb.append("\t\tset \t\n");
		
		for(int i=0;i<strs.length;i++){
			if(!strs[i].toLowerCase().equals("id")){
				if(i==strs.length-1)
					sb.append("\t\t"+strs[i]+"=#{"+PropertyColumn.column2Property(strs[i].toLowerCase())+"}\t\n");
				else{
					sb.append("\t\t"+strs[i]+"=#{"+PropertyColumn.column2Property(strs[i].toLowerCase())+"},\t\n");
				}
			}
		}
		sb.append("\t\twhere \t\n");
		sb.append("\t\tID in \t\n");
		sb.append("\t\t<foreach collection=\"entitys\" index=\"index\" item=\"item\"  open=\"(\" separator=\",\" close=\")\" >\n");
		sb.append("\t\t\t\t#{item}\t\n");
		sb.append("\t\t</foreach>\n");

		return sb.toString();
	}
	
	public String createBatchWithIf(Connection conn,String tabName,int type) throws SQLException, IOException, ClassNotFoundException{
		
		
		
		StringBuffer sb=new StringBuffer();
		
		ResultSet rs=conn.createStatement().executeQuery(" select * from "+tabName+" where 1=2");
		
		ResultSetMetaData rsmd=rs.getMetaData();
		
		
		String[] strs=new String[rsmd.getColumnCount()];
		for(int i=1;i<rsmd.getColumnCount()+1;i++){
			strs[i-1]=rsmd.getColumnName(i);
		}
		
		
		
		sb.append("\t\n");
		sb.append("\t\tupdate "+tabName+" \t\n");
		sb.append("\t\tset \t\n");
		sb.append("\t\t<trim prefix=\"\" suffix=\"\" suffixOverrides=\",\" >\n");
		
		
		for(int i=0;i<strs.length;i++){
			if(!strs[i].toLowerCase().equals("id")){				
				sb.append("\t\t\t<if test=\" "+PropertyColumn.column2Property(strs[i].toLowerCase())+"!=null \">\t\n");
				sb.append("\t\t\t\t"+strs[i]+"=#{"+PropertyColumn.column2Property(strs[i].toLowerCase())+"},\t\n\t\t\t</if>\t\n");
			}
		}
		sb.append("\t\t</trim>\t\n");
		sb.append("\t\twhere \t\n");
		sb.append("\t\tID in \t\n");
		sb.append("\t\t<foreach collection=\"entitys\" index=\"index\" item=\"item\"  open=\"(\" separator=\",\" close=\")\" >\n");
		sb.append("\t\t\t\t#{item}\t\n");
		sb.append("\t\t</foreach>\n");

		return sb.toString();
	}
	
}
