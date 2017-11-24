package sqlgen;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sqlgen.util.PropertyColumn;

public class SqlCreaterInsertBatch {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public String create(Connection conn, String tabName) throws SQLException,
			IOException, ClassNotFoundException {

		StringBuffer sb = new StringBuffer();

		ResultSet rs = conn.createStatement().executeQuery(
				" select * from " + tabName + " where 1=2");

		ResultSetMetaData rsmd = rs.getMetaData();

		String[] strs = new String[rsmd.getColumnCount()];
		for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {
			strs[i - 1] = rsmd.getColumnName(i);
		}

		sb.append("\t\n");
		sb.append("\t\tinsert into " + tabName + " \t\n");
		sb.append("\t\t(\t\n");

		for (int i = 0; i < strs.length; i++) {
			if (!strs[i].toLowerCase().equals("id")) {
				if (i == strs.length - 1)
					sb.append("\t\t" + strs[i] + "\t\n");
				else {
					sb.append("\t\t" + strs[i] + ",\t\n");
				}
			}
		}
		sb.append("\t\t)\t\n");
		sb.append("\t\tvalues\t\n");

		sb.append("\t\t<foreach collection=\"entitys\" index=\"index\" item=\"item\" separator=\",\" >\n");
		sb.append("\t\t(\t\n");
		for (int i = 0; i < strs.length; i++) {
			if (!strs[i].toLowerCase().equals("id")) {
				if (i == strs.length - 1)
					sb.append("\t\t\t#{item."
							+ PropertyColumn.column2Property(strs[i]
									.toLowerCase()) + "}\t\n");
				else {
					sb.append("\t\t\t#{item."
							+ PropertyColumn.column2Property(strs[i]
									.toLowerCase()) + "},\t\n");
				}
			}
		}
		sb.append("\t\t)\t\n");
		sb.append("\t\t</foreach>\n");

		return sb.toString();
	}

	public String createWithIf(Connection conn, String tabName)
			throws SQLException, IOException, ClassNotFoundException {

		StringBuffer sb = new StringBuffer();

		ResultSet rs = conn.createStatement().executeQuery(
				" select * from " + tabName + " where 1=2");

		ResultSetMetaData rsmd = rs.getMetaData();

		String[] strs = new String[rsmd.getColumnCount()];
		for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {
			strs[i - 1] = rsmd.getColumnName(i);
		}

		sb.append("\t\n");
		sb.append("\t\tinsert into " + tabName + " \t\n");
		sb.append("\t\t<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" >\n");

		for (int i = 0; i < strs.length; i++) {
			if (!strs[i].toLowerCase().equals("id")) {
				
				sb.append("\t\t\t<if test=\" "+PropertyColumn.column2Property(strs[i].toLowerCase())+"!=null \">\t\n");
				sb.append("\t\t\t\t" + strs[i] + ",\t\n\t\t\t</if>\t\n");			}
		}
		sb.append("\t\t</trim>\t\n");
		sb.append("\t\tvalues\t\n");

		
		sb.append("\t\t<foreach collection=\"entitys\" index=\"index\" item=\"item\"  separator=\",\"  >\n");
		sb.append("\t\t<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" >\n");
		for (int i = 0; i < strs.length; i++) {
			if (!strs[i].toLowerCase().equals("id")) {
				sb.append("\t\t\t<if test=\" "+PropertyColumn.column2Property(strs[i].toLowerCase())+"!=null \">\t\n");
				sb.append("\t\t\t#{item." + PropertyColumn.column2Property(strs[i]
									.toLowerCase()) + "},\t\n\t\t\t</if>\t\n");
			}
		}
		sb.append("\t\t</trim>\t\n");
		sb.append("\t\t</foreach>\n");

		return sb.toString();
		
	}

}
