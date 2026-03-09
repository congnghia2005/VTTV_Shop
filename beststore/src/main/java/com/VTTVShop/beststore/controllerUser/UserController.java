package com.VTTVShop.beststore.controllerUser;

import com.VTTVShop.beststore.models.User;
import com.VTTVShop.beststore.services.UseServicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UseServicer userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }
}
