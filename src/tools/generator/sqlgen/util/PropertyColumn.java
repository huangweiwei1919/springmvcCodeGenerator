package sqlgen.util;



public  class PropertyColumn {
	
	public static String property2Column(String str){
		String newStr="";
		char tmp;
		for(int i=0;i<str.length();i++){
			tmp=str.charAt(i);
			if(Character.isUpperCase(tmp)){
//				System.out.println(tmp);
				newStr+="_";
				newStr+=((tmp+"").toLowerCase());
			}else{
				newStr+=tmp;
			}
		}
//		System.out.println(newStr);
		return newStr;
	}
	
	
	public static String column2Property(String str){
		String newStr="";
		char tmp;
		for(int i=0;i<str.length();i++){
			tmp=str.charAt(i);
			if("_".equals(tmp+"")&&i!=str.length()-1){
				tmp=str.charAt(i+1);
				newStr+=(tmp+"").toUpperCase();
				i++;
			}else{
				newStr+=tmp;
			}
		}
		
		return newStr;
	}

	
	public static  void main(String args[]){
//		System.out.println(column2Property("sfsf_sys_user_dff_id"));
//		System.out.println("__________________________");
		System.out.println(property2Column("departJobId"));
	}
}
