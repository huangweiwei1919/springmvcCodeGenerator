package com.earlyzen.enuc.store.commodity.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * @Description: 商品分类
 * @author: hww
 * @date: 2017-04-08 11:26:11
 */
@ApiModel(value="storeCommodityType", description="商品分类")
public class StoreCommodityType {
		
    @ApiModelProperty(value="主键")
	private String id;	

    @ApiModelProperty(value="分类名称")
	private String name;	

    @ApiModelProperty(value="顺序号")
	private Integer recordSort;	

    @ApiModelProperty(value="分类图片地址")
	private String picPath;	

    @ApiModelProperty(value="录入人")
	private String createId;	

    @ApiModelProperty(value="录入时间")
	private Date createTime;	

    @ApiModelProperty(value="删除人")
	private String deleteId;	

    @ApiModelProperty(value="删除时间")
	private Date deleteTime;	

    @ApiModelProperty(value="录入状态 :  1:正常，2：删除，3：停用")
	private Integer recordState;	

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
 
 	public void setRecordSort(Integer recordSort){	
 		this.recordSort=recordSort;	
 	}	
 
 	public Integer getRecordSort(){	
 		return this.recordSort;	
 	}	
 
 	public void setPicPath(String picPath){	
 		this.picPath=picPath;	
 	}	
 
 	public String getPicPath(){	
 		return this.picPath;	
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

