package com.earlyzen.enuc.socail.share.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;


/**
 * @Description: 分享图片
 * @author: hww
 * @date: 2017-04-11 11:43:26
 */
@ApiModel(value="socialSharePhoto", description="分享图片")
public class SocialSharePhoto {
		
    @ApiModelProperty(value="主键")
	private String id;	

    @ApiModelProperty(value="分享ID")
	private String shareId;	

    @ApiModelProperty(value="图片文件ID")
	private String picFileId;	

    @ApiModelProperty(value="图片顺序")
	private Integer recordSort;	

    @ApiModelProperty(value="原图地址")
	private String picPath;	

    @ApiModelProperty(value="压缩地址")
	private String picCompressPath;	

    @ApiModelProperty(value="图片宽度")
	private Integer picWidth;	

    @ApiModelProperty(value="图片高度")
	private Integer picHeight;	

    @ApiModelProperty(value="压缩图片宽度")
	private Integer picCompressWidth;	

    @ApiModelProperty(value="压缩图片高度")
	private Integer picCompressHeight;	

 	public void setId(String id){	
 		this.id=id;	
 	}	
 
 	public String getId(){	
 		return this.id;	
 	}	
 
 	public void setShareId(String shareId){	
 		this.shareId=shareId;	
 	}	
 
 	public String getShareId(){	
 		return this.shareId;	
 	}	
 
 	public void setPicFileId(String picFileId){	
 		this.picFileId=picFileId;	
 	}	
 
 	public String getPicFileId(){	
 		return this.picFileId;	
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
 
 	public void setPicCompressPath(String picCompressPath){	
 		this.picCompressPath=picCompressPath;	
 	}	
 
 	public String getPicCompressPath(){	
 		return this.picCompressPath;	
 	}	
 
 	public void setPicWidth(Integer picWidth){	
 		this.picWidth=picWidth;	
 	}	
 
 	public Integer getPicWidth(){	
 		return this.picWidth;	
 	}	
 
 	public void setPicHeight(Integer picHeight){	
 		this.picHeight=picHeight;	
 	}	
 
 	public Integer getPicHeight(){	
 		return this.picHeight;	
 	}	
 
 	public void setPicCompressWidth(Integer picCompressWidth){	
 		this.picCompressWidth=picCompressWidth;	
 	}	
 
 	public Integer getPicCompressWidth(){	
 		return this.picCompressWidth;	
 	}	
 
 	public void setPicCompressHeight(Integer picCompressHeight){	
 		this.picCompressHeight=picCompressHeight;	
 	}	
 
 	public Integer getPicCompressHeight(){	
 		return this.picCompressHeight;	
 	}	
 

}

