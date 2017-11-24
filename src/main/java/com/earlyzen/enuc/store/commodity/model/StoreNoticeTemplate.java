package com.earlyzen.enuc.store.commodity.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * @Description: 商品须知模板
 * @author: hww
 * @date: 2017-04-10 20:05:18
 */
@ApiModel(value="storeNoticeTemplate", description="商品须知模板")
public class StoreNoticeTemplate {
		
    @ApiModelProperty(value="主键")
	private String id;	

    @ApiModelProperty(value="标题")
	private String name;	

    @ApiModelProperty(value="内容")
	private String notice;	

    @ApiModelProperty(value="模板录入状态(1:正常，2：删除，3：停用)")
	private Integer recordState;	

    @ApiModelProperty(value="录入人ID")
	private String createId;	

    @ApiModelProperty(value="录入时间")
	private Date createTime;	

    @ApiModelProperty(value="操作人ID")
	private String deleteId;	

    @ApiModelProperty(value="操作时间")
	private Date deleteTime;	

 	public void setId(String id){	
 		this.id=id;	
 	}	
 
 	public String getId(){	
 		return this.id;	
 	}	
 
 	public void setName(String name){	
 		this.name=name;	
 	}	
 
 	public String getName(){	
 		return this.name;	
 	}	
 
 	public void setNotice(String notice){	
 		this.notice=notice;	
 	}	
 
 	public String getNotice(){	
 		return this.notice;	
 	}	
 
 	public void setRecordState(Integer recordState){	
 		this.recordState=recordState;	
 	}	
 
 	public Integer getRecordState(){	
 		return this.recordState;	
 	}	
 
 	public void setCreateId(String createId){	
 		this.createId=createId;	
 	}	
 
 	public String getCreateId(){	
 		return this.createId;	
 	}	
 
 	public void setCreateTime(Date createTime){	
 		this.createTime=createTime;	
 	}	
 
 	public Date getCreateTime(){	
 		return this.createTime;	
 	}	
 
 	public void setDeleteId(String deleteId){	
 		this.deleteId=deleteId;	
 	}	
 
 	public String getDeleteId(){	
 		return this.deleteId;	
 	}	
 
 	public void setDeleteTime(Date deleteTime){	
 		this.deleteTime=deleteTime;	
 	}	
 
 	public Date getDeleteTime(){	
 		return this.deleteTime;	
 	}	
 

}

