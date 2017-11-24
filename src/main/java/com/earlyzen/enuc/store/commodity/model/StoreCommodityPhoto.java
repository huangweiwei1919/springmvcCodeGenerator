package com.earlyzen.enuc.store.commodity.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * @Description: 商品照片
 * @author: hww
 * @date: 2017-04-08 11:13:53
 */
@ApiModel(value="storeCommodityPhoto", description="商品照片")
public class StoreCommodityPhoto {
		
    @ApiModelProperty(value="主键")
	private String id;	

    @ApiModelProperty(value="商品ID")
	private String commodityId;	

    @ApiModelProperty(value="图片地址")
	private String imageUrl;	

    @ApiModelProperty(value="顺序号")
	private Integer recordSort;	

    @ApiModelProperty(value="录入人ID")
	private String createId;	

    @ApiModelProperty(value="录入时间")
	private Date createTime;	

    @ApiModelProperty(value="模板录入状态(1:正常，2：删除，3：停用)")
	private Integer recordState;	

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
 
 	public void setImageUrl(String imageUrl){	
 		this.imageUrl=imageUrl;	
 	}	
 
 	public String getImageUrl(){	
 		return this.imageUrl;	
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
 
 	public void setRecordState(Integer recordState){	
 		this.recordState=recordState;	
 	}	
 
 	public Integer getRecordState(){	
 		return this.recordState;	
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

