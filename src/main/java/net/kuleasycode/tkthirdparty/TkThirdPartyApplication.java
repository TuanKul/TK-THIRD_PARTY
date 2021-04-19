package net.kuleasycode.tkthirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)//enable phan quyen token nao co scope nao goi API
@ComponentScan(value = "net.kuleasycode")//scan tất cả các component service respository
@EnableJpaRepositories(value = "net.kuleasycode", repositoryImplementationPostfix = "CustomImpl")// enable cho JPA với ý định tự custom query theo ý mình hoặc với độ phức tạp cao
@EntityScan(basePackages = "net.kuleasycode")// tìm tất cả các entity
@EnableAsync// làm việc vs synchonyed
@EnableScheduling// thiết lập schedule chạy theo thời gian
//@EnableWebSecurity//custom config role nào được quyền vào url này
@EnableResourceServer
public class TkThirdPartyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TkThirdPartyApplication.class, args);
	}

}
