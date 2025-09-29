package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.Response;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Response register(RegisterRequest request) {
        // 检查用户名是否已存在
        if (userRepository.existsByUsername(request.getUsername())) {
            return new Response("用户名已存在", false, null);
        }

        // 创建新用户 (实际项目中应加密密码)
        User user = new User(request.getUsername(), request.getPassword());
        userRepository.save(user);

        return new Response("注册成功", true, user);
    }

    public Response login(LoginRequest request) {
        // 查找用户
        return userRepository.findByUsername(request.getUsername())
                .filter(user -> user.getPassword().equals(request.getPassword()))
                .map(user -> new Response("登录成功", true, user))
                .orElse(new Response("用户名或密码错误", false, null));
    }
}
