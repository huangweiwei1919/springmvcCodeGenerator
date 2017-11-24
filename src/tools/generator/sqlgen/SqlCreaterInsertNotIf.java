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






public class SqlCreaterInsertNotIf {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	

	
	
	
	public String create(Connection conn,String tabName,String tablePrimaryKeyType) throws SQLException, IOException, ClassNotFoundException{
		
		StringBuffer sb=new StringBuffer();
		
		ResultSet rs=conn.createStatement().executeQuery(" select * from "+tabName+" where 1=2");
		
		ResultSetMetaData rsmd=rs.getMetaData();
		
		
		String[] strs=new String[rsmd.getColumnCount()];
		for(int i=1;i<rsmd.getColumnCount()+1;i++){
			strs[i-1]=rsmd.getColumnName(i);
		}
		
		boolean isContainsZID = false;
		if(Arrays.asList(strs).contains("ZID")){
			isContainsZID = true;
		}
		
		sb.append("insert into "+tabName+" ");
		sb.append("\n\t\t(\n");
		
		boolean changgeFlag=false;
		for(int i=0;i<strs.length;i++){
			if(!isContainsZID){
				if(strs[i].toLowerCase().equals("id") && tablePrimaryKeyType.equals("Integer")) continue;
			}
			if(strs[i].toLowerCase().equals("zid")) continue;
			changgeFlag=true;
			sb.append("\t\t\t"+strs[i]+",\n");
		}
		
		if(changgeFlag){

			sb.delete(sb.length()-2, sb.length());
			sb.append("\n");
		}
		changgeFlag=false;
		
		sb.append("\t\t)\t\n");
		sb.append("\t\tvalues\t\n");
		sb.append("\t\t(\t\n");
		
		
		for(int i=0;i<strs.length;i++){
			if(!isContainsZID){
				if(strs[i].toLowerCase().equals("id") && tablePrimaryKeyType.equals("Integer")) continue;
			}
			if(strs[i].toLowerCase().equals("zid")) continue;
			changgeFlag=true;
			sb.append("\t\t\t#{"+PropertyColumn.column2Property(strs[i].toLowerCase())+"},\n");
		}
		
		if(changgeFlag){
			sb.delete(sb.length()-2, sb.length());
			sb.append("\n");
		}
		changgeFlag=false;
		
		sb.append("\t\t)\t");
		
		return sb.toString();
	}
	
}
