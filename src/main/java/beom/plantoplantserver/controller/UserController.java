package beom.plantoplantserver.controller;

import beom.plantoplantserver.model.dto.request.FirstLoginTodayRequest;
import beom.plantoplantserver.model.dto.request.LoginRequest;
import beom.plantoplantserver.model.dto.request.RegisterRequest;
import beom.plantoplantserver.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }

    @PostMapping("/daily-login-checking")
    public String isFirstLoginToday(@RequestBody FirstLoginTodayRequest request) {
        return userService.isFirstLoginToday(request);
    }

    @GetMapping("/info")
    public  String getUserName(@RequestParam("user_id") String userId) {
        return userService.getNickname(userId);
    }

}
