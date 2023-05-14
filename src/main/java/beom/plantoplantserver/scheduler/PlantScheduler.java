package beom.plantoplantserver.scheduler;

import beom.plantoplantserver.model.entity.Calendar;
import beom.plantoplantserver.model.entity.Plant;
import beom.plantoplantserver.model.entity.PlantReward;
import beom.plantoplantserver.model.entity.User;
import beom.plantoplantserver.repository.CalendarRepo;
import beom.plantoplantserver.repository.PlantRepo;
import beom.plantoplantserver.repository.PlantRewardRepo;
import beom.plantoplantserver.repository.UserRepo;
import beom.plantoplantserver.util.RandomPlantManager;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PlantScheduler {

    private final CalendarRepo calendarRepo;
    private final PlantRepo plantRepo;
    private final PlantRewardRepo plantRewardRepo;
    private final UserRepo userRepo;

    // @Scheduled(cron = "0 */1 * * * *") // 테스트 용
    @Scheduled(cron = "0 0 6 * * *")
    public void acquirePlants() {   // 식물 지급
        List<Plant> plants = plantRepo.findAll();
        RandomPlantManager plantManager = new RandomPlantManager(plants);   // 식물 랜덤 생성 객체
        List<PlantReward> plantRewards = new ArrayList<>(); // saveAll 을 위한 객체
        HashMap<String, Integer> plantCount = new HashMap<>(); // 식물 id, 갯수

        // 어제 완료된 일 전체 가져오기
        LocalDate now = LocalDate.now();
        LocalDate targetDay = now.minusDays(1);
        List<Calendar> userCalendarResponseList = calendarRepo.findByDateAndToDoCompletedIsTrue(targetDay);

        printStart();

        // 유저 별 획득해야 하는 식물 수
        for (Calendar c : calendarList) {
            int count = 0;
            String userId = c.getUser().getId();

            if (plantCount.containsKey(userId)) {
                count = plantCount.get(userId);
            }

            plantCount.put(userId, count+1);
        }

        // 유저 별로 식물 지급하기
        if (plantCount.size() == 0) {
            System.out.println("지급할 식물이 없습니다.");
        }
        else {
            for (String uid : plantCount.keySet()) {
                System.out.println(uid + "에게 " + plantCount.get(uid) + "개의 식물 지급 필요");
            }
            System.out.println("식물 지급 시작");

            // 식물 개수만큼 지급
            for (String uid : plantCount.keySet()) {
                // 식물 id 별 개수 배열
                int[] randomPlants = plantManager.getRandomPlants(plantCount.get(uid));
                Optional<User> u = userRepo.findById(uid);
                User user = u.get();

                // 획득한 식물 출력
                System.out.println("새로 생성한 식물: ");
                for (int i = 0; i < randomPlants.length; i++) {
                    if (randomPlants[i] > 0) {
                        System.out.print(plants.get(i).getName() + " " + randomPlants[i] + "개, ");
                    }
                }

                // DB 저장을 위한 배열에 넣기
                for (int i = 0; i < randomPlants.length; i++) {
                    if (randomPlants[i] > 0) {
                        plantRewards.add(PlantReward.builder()
                                .date(targetDay)
                                .user(user)
                                .plant(plants.get(i))
                                .count(randomPlants[i])
                                .isGot(false)
                                .build());
                    }
                }

                System.out.println("생성 완료");
            }
        }
        plantRewardRepo.saveAll(plantRewards);
    }

    private void printStart() {  // 스레드 시작 시간 출력
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 a h시 m분");
        String nowString = now.format(dateTimeFormatter);
        System.out.println(nowString + "  스케줄 시작");
    }
}
