package net.kuleasycode.tkthirdparty.service.impl;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.kuleasycode.tkthirdparty.response.ProductResponse;
import net.kuleasycode.tkthirdparty.service.ThirdPartyService;

@Service("lazadaSerivce")
@Slf4j
public class LazadaService implements ThirdPartyService{

	@Override
	public ProductResponse findAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}
}
