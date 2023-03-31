package beom.plantoplantserver.service;

import beom.plantoplantserver.model.dto.request.RegisterRequest;

public interface UserService {

    public String register(RegisterRequest request);

}
