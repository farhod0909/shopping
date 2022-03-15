package uz.mobiler.market.service;

import uz.mobiler.market.dto.UserForm;
import uz.mobiler.market.entity.User;

public interface UserService {
    User add(UserForm form);
}
