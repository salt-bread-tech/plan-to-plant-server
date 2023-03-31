package beom.plantoplantserver.service;

import beom.plantoplantserver.model.dto.request.RegisterRequest;
import beom.plantoplantserver.model.entity.User;
import beom.plantoplantserver.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public String register(RegisterRequest request) {   // 회원 가입
        String result = "";

        if (!isDuplicated(request.getId())) {
            userRepo.save(User.builder()
                            .id(request.getId())
                            .password(request.getPassword())
                            .nickname(request.getNickname())
                            .build());

            System.out.println("회원 가입 성공");
            result = "1";
        }
        else {
            System.out.println("회원 가입 실패: 아이디 중복");
            result = "2";
        }

        return result;
    }

    private boolean isDuplicated(String id) {   // 아이디 중복 검사
        boolean result = false;
        List<User> userList = userRepo.findAll();

        for (User u : userList) {
            if (u.getId().equals(id)) result = true;
        }

        return result;
    }
}
