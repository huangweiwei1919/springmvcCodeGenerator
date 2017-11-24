package com.earlyzen.enuc.store.subject.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * @Description: 商品专题商品
 * @author: hww
 * @date: 2017-04-10 21:05:47
 */
@ApiModel(value="storeSubjectCommodity", description="商品专题商品")
public class StoreSubjectCommodity {
		
    @ApiModelProperty(value="主键")
	private String id;	

    @ApiModelProperty(value="商品专题内容ID")
	private String subjectContentId;	

    @ApiModelProperty(value="商品ID")
	private String commodityId;	

    @ApiModelProperty(value="顺序号")
	private Integer recordSort;	

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
 
 	public void setSubjectContentId(String subjectContentId){	
 		this.subjectContentId=subjectContentId;	
 	}	
 
 	public String getSubjectContentId(){	
 		return this.subjectContentId;	
 	}	
 
 	public void setCommodityId(String commodityId){	
 		this.commodityId=commodityId;	
 	}	
 
 	public String getCommodityId(){	
 		return this.commodityId;	
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
 
 	public void setParkId(String parkId){	
 		this.parkId=parkId;	
 	}	
 
 	public String getParkId(){	
 		return this.parkId;	
 	}	
 

}

