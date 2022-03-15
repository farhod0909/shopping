package uz.mobiler.market.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.mobiler.market.dto.CustomUserDetails;
import uz.mobiler.market.entity.User;
import uz.mobiler.market.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameAndDeletedFalse(username).orElseThrow(()->new RuntimeException("User not found"));
        return new CustomUserDetails(user);
    }
}
