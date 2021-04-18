package net.kuleasycode.tkthirdparty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.kuleasycode.tkthirdparty.common.Constant;
import net.kuleasycode.tkthirdparty.common.HttpStatusCode;
import net.kuleasycode.tkthirdparty.response.ProductResponse;
import net.kuleasycode.tkthirdparty.service.ThirdPartyService;
import net.kuleasycode.tkthirdparty.settings.SupplierDetailsSetting;
import net.kuleasycode.tkthirdparty.settings.SupplierSettings;

@RestController
@Slf4j
public class ThirdPartyController {
	
	@Autowired
	private SupplierSettings supplierSettings;
	
	@Autowired
	private ThirdPartyService tikiService;
	
	@Autowired
	private ThirdPartyService lazadaSerivce;
	
	@Autowired
	private ThirdPartyService shoppeService;

	@GetMapping(value = "/v1/{supplier}/get-all")
	@PreAuthorize("#oauth2.hasScope('third_party_get_all')")
	public ResponseEntity<ProductResponse> getAllProduct(@PathVariable("supplier") String supplier) {
		try {
			SupplierDetailsSetting detailsSetting = supplierSettings.getPartnerList().get(supplier);
			if (StringUtils.isEmpty(detailsSetting)) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ProductResponse(HttpStatusCode._404.getCode(), HttpStatusCode._404.getValue()));
			}
			
			ProductResponse response = new ProductResponse();
			if (Constant.TIKI.equals(supplier)) {
				response = tikiService.findAllProduct();
			} else if (Constant.LAZADA.equals(supplier)) {
				response = lazadaSerivce.findAllProduct();
			} else if (Constant.SHOPPE.equals(supplier)) {
				response = shoppeService.findAllProduct();
			}
			
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			log.info("[EXCEPTION]--" + supplier, e.toString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ProductResponse(HttpStatusCode._500.getCode(), HttpStatusCode._500.getValue()));
		}
	}
}