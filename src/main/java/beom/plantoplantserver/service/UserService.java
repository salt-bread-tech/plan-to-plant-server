package beom.plantoplantserver.service;

import beom.plantoplantserver.model.dto.request.FirstLoginTodayRequest;
import beom.plantoplantserver.model.dto.request.LoginRequest;
import beom.plantoplantserver.model.dto.request.RegisterRequest;

public interface UserService {

    String register(RegisterRequest request);

    String login(LoginRequest request);

    String isFirstLoginToday(FirstLoginTodayRequest request);
}
