package com.earlyzen.enuc.socail.attention.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * @Description: 用户关注
 * @author: hww
 * @date: 2017-04-06 11:59:21
 */
@ApiModel(value="socialAttentionUser", description="用户关注")
public class SocialAttentionUser {
		
    @ApiModelProperty(value="主键")
	private String id;	

    @ApiModelProperty(value="创建人ID")
	private String createId;	

    @ApiModelProperty(value="给关注人ID")
	private String beAttentionId;	

    @ApiModelProperty(value="创建时间")
	private Date createTime;	

 	public void setId(String id){	
 		this.id=id;	
 	}	
 
 	public String getId(){	
 		return this.id;	
 	}	
 
 	public void setCreateId(String createId){	
 		this.createId=createId;	
 	}	
 
 	public String getCreateId(){	
 		return this.createId;	
 	}	
 
 	public void setBeAttentionId(String beAttentionId){	
 		this.beAttentionId=beAttentionId;	
 	}	
 
 	public String getBeAttentionId(){	
 		return this.beAttentionId;	
 	}	
 
 	public void setCreateTime(Date createTime){	
 		this.createTime=createTime;	
 	}	
 
 	public Date getCreateTime(){	
 		return this.createTime;	
 	}	
 

}

