package com.earlyzen.enuc.socail.attention.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;


/**
 * @Description: 用户分享信息总览
 * @author: hww
 * @date: 2017-04-06 11:58:35
 */
@ApiModel(value="socialShareUser", description="用户分享信息总览")
public class SocialShareUser {
		
    @ApiModelProperty(value="主键")
	private String id;	

    @ApiModelProperty(value="用户ID")
	private String createId;	

    @ApiModelProperty(value="分享数")
	private Integer shareNum;	

    @ApiModelProperty(value="分享被赞数")
	private Integer beGoogNum;	

    @ApiModelProperty(value="粉丝数")
	private Integer fansNum;	

    @ApiModelProperty(value="关注数")
	private Integer attentionNum;	

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
 
 	public void setShareNum(Integer shareNum){	
 		this.shareNum=shareNum;	
 	}	
 
 	public Integer getShareNum(){	
 		return this.shareNum;	
 	}	
 
 	public void setBeGoogNum(Integer beGoogNum){	
 		this.beGoogNum=beGoogNum;	
 	}	
 
 	public Integer getBeGoogNum(){	
 		return this.beGoogNum;	
 	}	
 
 	public void setFansNum(Integer fansNum){	
 		this.fansNum=fansNum;	
 	}	
 
 	public Integer getFansNum(){	
 		return this.fansNum;	
 	}	
 
 	public void setAttentionNum(Integer attentionNum){	
 		this.attentionNum=attentionNum;	
 	}	
 
 	public Integer getAttentionNum(){	
 		return this.attentionNum;	
 	}	
 

}

