package net.kuleasycode.tkthirdparty.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailsResponse {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("product_name")
	private String productName;
	
	@JsonProperty("current_price")
	private Double currentPrice;
	
	@JsonProperty("discount_rate")
	private Double discountRate;
	
	@JsonProperty("rate")
	private Double rate;
	
	@JsonProperty("image_name")
	private String imageName;
	
	@JsonProperty("created_date")
	private String createdDate;
}
