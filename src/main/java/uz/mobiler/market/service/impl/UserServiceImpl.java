package uz.mobiler.market.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uz.mobiler.market.dto.UserForm;
import uz.mobiler.market.entity.User;
import uz.mobiler.market.repository.UserRepository;
import uz.mobiler.market.service.UserService;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final BCryptPasswordEncoder encoder;

    @Override
    public User add(UserForm form) {
        return repository.save(User.builder()
               .username(form.getUsername())
               .fullName(form.getFullName())
               .password(encoder.encode(form.getPassword()))
               .build());
    }
}
