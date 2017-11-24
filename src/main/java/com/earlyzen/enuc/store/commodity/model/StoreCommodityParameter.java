package com.earlyzen.enuc.store.commodity.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * @Description: 商品参数
 * @author: hww
 * @date: 2017-04-08 15:20:12
 */
@ApiModel(value="storeCommodityParameter", description="商品参数")
public class StoreCommodityParameter {
		
    @ApiModelProperty(value="主键")
	private String id;	

    @ApiModelProperty(value="商品id")
	private String commodityId;	

    @ApiModelProperty(value="规格标题")
	private String name;	

    @ApiModelProperty(value="规格内容")
	private String content;	

    @ApiModelProperty(value="顺序号")
	private Integer recordSort;	

    @ApiModelProperty(value="录入人ID")
	private String createId;	

    @ApiModelProperty(value="录入时间")
	private Date createTime;	

    @ApiModelProperty(value="删除人")
	private String deleteId;	

    @ApiModelProperty(value="删除时间")
	private Date deleteTime;	

    @ApiModelProperty(value="记录状态")
	private Integer recordState;	

 	public void setId(String id){	
 		this.id=id;	
 	}	
 
 	public String getId(){	
 		return this.id;	
 	}	
 
 	public void setCommodityId(String commodityId){	
 		this.commodityId=commodityId;	
 	}	
 
 	public String getCommodityId(){	
 		return this.commodityId;	
 	}	
 
 	public void setName(String name){	
 		this.name=name;	
 	}	
 
 	public String getName(){	
 		return this.name;	
 	}	
 
 	public void setContent(String content){	
 		this.content=content;	
 	}	
 
 	public String getContent(){	
 		return this.content;	
 	}	
 
 	public void setRecordSort(Integer recordSort){	
 		this.recordSort=recordSort;	
 	}	
 
 	public Integer getRecordSort(){	
 		return this.recordSort;	
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
 
 	public void setRecordState(Integer recordState){	
 		this.recordState=recordState;	
 	}	
 
 	public Integer getRecordState(){	
 		return this.recordState;	
 	}	
 

}

