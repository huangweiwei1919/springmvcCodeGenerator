package sqlgen;



import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import sqlgen.util.PropertyColumn;





public class SqlCreaterSelect  {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	

	
	
	public String create(Connection conn,String tabName) throws SQLException, IOException, ClassNotFoundException{
		
		StringBuffer sb=new StringBuffer();
		
		ResultSet rs=conn.createStatement().executeQuery(" select * from "+tabName+" where 1=2");
		
		ResultSetMetaData rsmd=rs.getMetaData();
		
		
		String[] strs=new String[rsmd.getColumnCount()];
		for(int i=1;i<rsmd.getColumnCount()+1;i++){
			strs[i-1]=rsmd.getColumnName(i);
		}
		
		sb.append("select  \t\n");
		
		
		for(int i=0;i<strs.length;i++){
			if(i==strs.length-1)
				sb.append("\t\t_tbl."+strs[i]+" "+PropertyColumn.column2Property(strs[i].toLowerCase())+"\t\n");
			else
				sb.append("\t\t_tbl."+strs[i]+" "+PropertyColumn.column2Property(strs[i].toLowerCase())+",\t\n");
		}
		
		sb.append("\t\tfrom "+tabName+" _tbl"+"\t");
		
		return sb.toString();
	}
	
}
