package beom.plantoplantserver.scheduler;

import beom.plantoplantserver.model.dto.request.PlantRequest;
import beom.plantoplantserver.model.entity.Calendar;
import beom.plantoplantserver.model.entity.Plant;
import beom.plantoplantserver.model.entity.PlantReward;
import beom.plantoplantserver.model.entity.User;
import beom.plantoplantserver.repository.CalendarRepo;
import beom.plantoplantserver.repository.PlantRepo;
import beom.plantoplantserver.repository.PlantRewardRepo;
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

@Component
@RequiredArgsConstructor
public class PlantScheduler {

    private final CalendarRepo calendarRepo;
    private final PlantRepo plantRepo;
    private final PlantRewardRepo plantRewardRepo;

    // @Scheduled(cron = "0 0 6 * * *")
    @Scheduled(cron = "0 * * * * *")
    public void acquirePlants() {   // 식물 지급
        List<Plant> plants = plantRepo.findAll();
        RandomPlantManager plantManager = new RandomPlantManager(plants);   // 식물 랜덤 생성 객체
        List<PlantReward> plantRewards = new ArrayList<>(); // saveAll 을 위한 객체
        HashMap<String, Integer> plantCount = new HashMap<>(); // 식물 id, 갯수

        // 어제 완료된 일 전체 가져오기
        LocalDate now = LocalDate.now();
        LocalDate targetDay = now.minusDays(1);
        List<Calendar> calendarList = calendarRepo.findByDateAndToDoCompletedIsTrue(targetDay);

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

        // 식물 개수만큼 지급
        for (Calendar c : calendarList) {
            Plant reward = plantManager.getRandomPlant();
            LocalDate localDate = c.getDate();
            String userId = c.getUser().getId();
            PlantReward plantReward = new PlantReward();
            int plantId = reward.getId();
            int count = 1;

            System.out.println("새로 생성한 식물: " + reward.getName());


            plantRewards.add(plantReward);
            System.out.println("생성 완료");
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
