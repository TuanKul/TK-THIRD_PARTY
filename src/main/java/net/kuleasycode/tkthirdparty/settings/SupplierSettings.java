package net.kuleasycode.tkthirdparty.settings;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix ="third-party")
public class SupplierSettings {

	private Map<String, SupplierDetailsSetting> partnerList;
}
