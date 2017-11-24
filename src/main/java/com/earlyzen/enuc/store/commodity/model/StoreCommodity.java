package com.earlyzen.enuc.store.commodity.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * @Description: 商品
 * @author: hww
 * @date: 2017-04-08 11:08:25
 */
@ApiModel(value="storeCommodity", description="商品")
public class StoreCommodity {
		
    @ApiModelProperty(value="主键")
	private String id;	

    @ApiModelProperty(value="商品所属分类")
	private String commodityTypeId;	

    @ApiModelProperty(value="名称")
	private String name;	

    @ApiModelProperty(value="1:正常，2删除，3停用")
	private Integer recordState;	

    @ApiModelProperty(value="是否推荐（1：是，2 ：否）")
	private Integer recommendState;	

    @ApiModelProperty(value="简介")
	private String notes;	

    @ApiModelProperty(value="最低价")
	private Double minPrice;	

    @ApiModelProperty(value="最高价格")
	private Double maxPrice;	

    @ApiModelProperty(value="服务费")
	private Double serviceCharge;	

    @ApiModelProperty(value="详情")
	private String details;	

    @ApiModelProperty(value="须知内容")
	private String notice;	

    @ApiModelProperty(value="商品须知模板ID")
	private String noticeTemplateId;	

    @ApiModelProperty(value="录入人ID")
	private String createId;	

    @ApiModelProperty(value="录入时间")
	private Date createTime;	

    @ApiModelProperty(value="操作人ID")
	private String deleteId;	

    @ApiModelProperty(value="操作时间")
	private Date deleteTime;	

    @ApiModelProperty(value="园区ID")
	private String parkId;	

 	public void setId(String id){	
 		this.id=id;	
 	}	
 
 	public String getId(){	
 		return this.id;	
 	}	
 
 	public void setCommodityTypeId(String commodityTypeId){	
 		this.commodityTypeId=commodityTypeId;	
 	}	
 
 	public String getCommodityTypeId(){	
 		return this.commodityTypeId;	
 	}	
 
 	public void setName(String name){	
 		this.name=name;	
 	}	
 
 	public String getName(){	
 		return this.name;	
 	}	
 
 	public void setRecordState(Integer recordState){	
 		this.recordState=recordState;	
 	}	
 
 	public Integer getRecordState(){	
 		return this.recordState;	
 	}	
 
 	public void setRecommendState(Integer recommendState){	
 		this.recommendState=recommendState;	
 	}	
 
 	public Integer getRecommendState(){	
 		return this.recommendState;	
 	}	
 
 	public void setNotes(String notes){	
 		this.notes=notes;	
 	}	
 
 	public String getNotes(){	
 		return this.notes;	
 	}	
 
 	public void setMinPrice(Double minPrice){	
 		this.minPrice=minPrice;	
 	}	
 
 	public Double getMinPrice(){	
 		return this.minPrice;	
 	}	
 
 	public void setMaxPrice(Double maxPrice){	
 		this.maxPrice=maxPrice;	
 	}	
 
 	public Double getMaxPrice(){	
 		return this.maxPrice;	
 	}	
 
 	public void setServiceCharge(Double serviceCharge){	
 		this.serviceCharge=serviceCharge;	
 	}	
 
 	public Double getServiceCharge(){	
 		return this.serviceCharge;	
 	}	
 
 	public void setDetails(String details){	
 		this.details=details;	
 	}	
 
 	public String getDetails(){	
 		return this.details;	
 	}	
 
 	public void setNotice(String notice){	
 		this.notice=notice;	
 	}	
 
 	public String getNotice(){	
 		return this.notice;	
 	}	
 
 	public void setNoticeTemplateId(String noticeTemplateId){	
 		this.noticeTemplateId=noticeTemplateId;	
 	}	
 
 	public String getNoticeTemplateId(){	
 		return this.noticeTemplateId;	
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
 
 	public void setParkId(String parkId){	
 		this.parkId=parkId;	
 	}	
 
 	public String getParkId(){	
 		return this.parkId;	
 	}	
 

}

