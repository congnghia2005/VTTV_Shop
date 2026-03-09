package com.VTTVShop.beststore.services;

import com.VTTVShop.beststore.Repository.UserRepository;
import com.VTTVShop.beststore.models.User;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UseServicer {
    private Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder(
            16,       // saltLength
            32,       // hashLength
            1,        // parallelism
            65536,    // memory (KB)
            3         // iterations
    );

    private UserRepository userRepository;

    public UseServicer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User register(User user) {
        // Mã hóa mật khẩu
        String hashedPassword = passwordEncoder.encode(user.getMk());
        user.setMk(hashedPassword);

        // Lưu user vào DB (giả sử dùng JPA)
        return userRepository.save(user);
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
