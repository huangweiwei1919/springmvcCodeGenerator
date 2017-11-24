package com.earlyzen.enuc.store.subject.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * @Description: 商品专题内容
 * @author: hww
 * @date: 2017-04-10 21:06:43
 */
@ApiModel(value="storeSubjectContent", description="商品专题内容")
public class StoreSubjectContent {
		
    @ApiModelProperty(value="主键")
	private String id;	

    @ApiModelProperty(value="商品专题ID")
	private String subjectId;	

    @ApiModelProperty(value="类型，1 文本，2 商品")
	private Integer type;	

    @ApiModelProperty(value="顺序号")
	private Integer recordSort;	

    @ApiModelProperty(value="内容")
	private String content;	

    @ApiModelProperty(value="录入人ID")
	private String createId;	

    @ApiModelProperty(value="录入时间")
	private Date createTime;	

    @ApiModelProperty(value="园区ID")
	private String parkId;	

 	public void setId(String id){	
 		this.id=id;	
 	}	
 
 	public String getId(){	
 		return this.id;	
 	}	
 
 	public void setSubjectId(String subjectId){	
 		this.subjectId=subjectId;	
 	}	
 
 	public String getSubjectId(){	
 		return this.subjectId;	
 	}	
 
 	public void setType(Integer type){	
 		this.type=type;	
 	}	
 
 	public Integer getType(){	
 		return this.type;	
 	}	
 
 	public void setRecordSort(Integer recordSort){	
 		this.recordSort=recordSort;	
 	}	
 
 	public Integer getRecordSort(){	
 		return this.recordSort;	
 	}	
 
 	public void setContent(String content){	
 		this.content=content;	
 	}	
 
 	public String getContent(){	
 		return this.content;	
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
 
 	public void setParkId(String parkId){	
 		this.parkId=parkId;	
 	}	
 
 	public String getParkId(){	
 		return this.parkId;	
 	}	
 

}

