package beom.plantoplantserver.service;

import beom.plantoplantserver.model.dto.request.FirstLoginTodayRequest;
import beom.plantoplantserver.model.dto.request.LoginRequest;
import beom.plantoplantserver.model.dto.request.RegisterRequest;
import beom.plantoplantserver.model.entity.PlantReward;
import beom.plantoplantserver.model.entity.User;
import beom.plantoplantserver.repository.PlantRewardRepo;
import beom.plantoplantserver.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final PlantRewardRepo getPlantRepo;

    @Override
    public String register(RegisterRequest request) {   // 회원 가입
        String result;

        if (!isExistingId(request.getId())) {
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

    @Override
    public String login(LoginRequest request) { // 로그인
        String result;
        String id = request.getId();
        String password = request.getPassword();

        if (!isExistingId(id)) {
            System.out.println("아이디가 존재하지 않음");
            result = "3";
        }
        else if (!isValidPassword(id, password)) {
            System.out.println("비밀번호가 올바르지 않음");
            result = "2";
        }
        else {
            System.out.println("로그인 성공");
            result = "1";
        }

        return result;
    }

    @Override
    public String isFirstLoginToday(FirstLoginTodayRequest request) {   // 오늘 첫 로그인인지
        String userId = request.getId();
        String result;

        if (!haveToGetReward(userId)) {
            result = "0";
            System.out.println("어제의 보상을 받지 않았습니다.");
        }
        else {
            result = "1";
            System.out.println("어제의 보상을 받았습니다.");
        }

        return result;
    }

    private boolean isExistingId(String id) {   // 존재하는 id 인지 검사 (중복 여부)  true: 존재함  false: 존재하지 않음
        boolean result = false;
        Optional<User> user = userRepo.findById(id);

        if (user.isPresent()) result = true;

        return result;
    }

    private boolean isValidPassword(String id, String password) { // 유효한 비밀번호인지 검사
        boolean result = false;
        Optional<User> user = userRepo.findById(id);

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            result = true;
        }

        return result;
    }

    private boolean haveToGetReward(String id) {    // 보상 받지 않은 목록이 있는지 확인
        boolean result = true;
        List<PlantReward> plantReward = getPlantRepo.findByUserIdAndIsGotTrue(id);

        if (plantReward.size() == 0) result = false;

        return result;
    }

}
