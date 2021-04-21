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

@Service("shoppeService")
@Slf4j
public class ShoppeService implements ThirdPartyService{

	@Override
	public ProductResponse findAllProduct() {
		// TODO Auto-generated method stub
		try {
			log.info("shoppe");
			ProductResponse response = new ProductResponse();
			List<ProductDetailsResponse> listProductDetail = new ArrayList<>();
			
			for (int i = 0; i < 10; i++) {
				ProductDetailsResponse detail = new ProductDetailsResponse();
				detail.setId(UUID.randomUUID().toString());
				detail.setProductName("Shoppe_" + i);
				detail.setCurrentPrice(Double.valueOf(i));
				detail.setDiscountRate(Double.valueOf(i));
				detail.setRate(Double.valueOf(i));
				listProductDetail.add(detail);
			}
			response = new ProductResponse(HttpStatusCode._200.getCode(), HttpStatusCode._200.getValue(), listProductDetail);
			return response;
		} catch (Exception e) {
			log.error("[EXCEPTION]", e.toString(), e);
			throw new InternalServerErrorException(HttpStatusCode._500.getCode(), HttpStatusCode._500.getValue());
		}
	}

	public static void main(String[] args) {
		List<String> a = new ArrayList<>(10);
		a.add("1");
		a.stream().forEach(e-> System.out.println(e + "1"));
	}
}
