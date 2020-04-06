package com.laptrinhjavaweb.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfig {
	
	@Bean
    public AuditorAware<String> auditorProvider() { //auditoraware : là nó lấy thông tin dang nhập vào
        return new AuditorAwareImpl();
    }
	//khi đã vô quá trình này rồi thì phải dang80 nhập mới được vào 
    public static class AuditorAwareImpl implements AuditorAware<String> {
        @Override
        public Optional<String> getCurrentAuditor() { //Optional kiểm tra coi có tồn tai giá trị hay không
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();//authentication là 1 obj đươc chứa trong security context
           //authentication là cái flag để kiểm tra nếu nó khác null
            if (authentication == null || !authentication.isAuthenticated()) { //authenticated : đã dang nhập rồi
                return Optional.of("admin");
            }
            return Optional.of(authentication.getName());
        }
    }
}
