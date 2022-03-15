package uz.mobiler.market.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
public class JpaAuditingConfig implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
        var username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return Optional.of(username);
    }
}
