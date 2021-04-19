package net.kuleasycode.tkthirdparty.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.kuleasycode.tkthirdparty.common.HttpStatusCode;
import net.kuleasycode.tkthirdparty.exception.InternalServerErrorException;
import net.kuleasycode.tkthirdparty.response.ProductDetailsResponse;
import net.kuleasycode.tkthirdparty.response.ProductResponse;
import net.kuleasycode.tkthirdparty.service.ThirdPartyService;

@Service("tikiService")
@Slf4j
public class TikiService implements ThirdPartyService{

	@Override
	public ProductResponse findAllProduct() {
		try {
			log.info("tiki");
			ProductResponse response = new ProductResponse();
			List<ProductDetailsResponse> listProductDetail = new ArrayList<>();
			for(int i = 0; i< 10;i++) {
				ProductDetailsResponse detail = new ProductDetailsResponse();
				detail.setId(UUID.randomUUID().toString());
				detail.setProductName("Tiki_" + i);
				detail.setCurrentPrice("Price_" + i);
				detail.setDiscountRate("Discount_Rate_" + i);
				detail.setRate("Rate_" + i);
				listProductDetail.add(detail);
			}
			response = new ProductResponse(HttpStatusCode._200.getCode(), HttpStatusCode._200.getValue(), listProductDetail);
			return response;
		} catch (Exception e) {
			log.error("[EXCEPTION]", e.toString(), e);
			throw new InternalServerErrorException(HttpStatusCode._500.getCode(), HttpStatusCode._500.getValue());
		}
	}

}
