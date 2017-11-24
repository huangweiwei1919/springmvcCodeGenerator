package com.earlyzen.crm.psauser.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * @Description: psauser测试
 * @author: chenxiaomin
 * @date: 2017-03-17 10:02:57
 */
@ApiModel(value="psaUser", description="psauser测试")
public class PsaUser {
		
    @ApiModelProperty(value="主键")
	private String id;	

    @ApiModelProperty(value="用户名")
	private String userName;	

    @ApiModelProperty(value="生日")
	private Date birthday;	

 	public void setId(String id){	
 		this.id=id;	
 	}	
 
 	public String getId(){	
 		return this.id;	
 	}	
 
 	public void setUserName(String userName){	
 		this.userName=userName;	
 	}	
 
 	public String getUserName(){	
 		return this.userName;	
 	}	
 
 	public void setBirthday(Date birthday){	
 		this.birthday=birthday;	
 	}	
 
 	public Date getBirthday(){	
 		return this.birthday;	
 	}	
 

}

