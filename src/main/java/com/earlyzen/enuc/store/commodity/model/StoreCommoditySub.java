package com.earlyzen.enuc.store.commodity.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * @Description: 商品子类
 * @author: hww
 * @date: 2017-04-08 11:15:43
 */
@ApiModel(value="storeCommoditySub", description="商品子类")
public class StoreCommoditySub {
		
    @ApiModelProperty(value="主键")
	private String id;	

    @ApiModelProperty(value="商品ID")
	private String commodityId;	

    @ApiModelProperty(value="名称")
	private String name;	

    @ApiModelProperty(value="价格")
	private Double price;	

    @ApiModelProperty(value="顺序号")
	private Integer recordSort;	

    @ApiModelProperty(value="商品子类录入状态(1:正常，2：删除，3：停用)")
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
 
 	public void setPrice(Double price){	
 		this.price=price;	
 	}	
 
 	public Double getPrice(){	
 		return this.price;	
 	}	
 
 	public void setRecordSort(Integer recordSort){	
 		this.recordSort=recordSort;	
 	}	
 
 	public Integer getRecordSort(){	
 		return this.recordSort;	
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

