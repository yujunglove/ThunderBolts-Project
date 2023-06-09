package com.greedy.thunderbolts.model.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MainPageDTO {
		
		private int productCode;
	    private String productName;
	    private String productNameKr;
	    private Date productEntryDate;
	    private int categoriesCode;
	    private int productCount;
	    private BrandDTO brandNo;
		private List<ProductOptionDTO> productOption;
	    private List<AttachmentFileDTO> attachmentFile;

}
