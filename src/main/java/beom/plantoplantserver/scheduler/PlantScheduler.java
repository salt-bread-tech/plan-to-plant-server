package beom.plantoplantserver.scheduler;

import beom.plantoplantserver.model.entity.Calendar;
import beom.plantoplantserver.model.entity.Plant;
import beom.plantoplantserver.model.entity.PlantReward;
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
import java.util.List;

@Component
@RequiredArgsConstructor
public class PlantScheduler {

    private final CalendarRepo calendarRepo;
    private final PlantRepo plantRepo;
    private final PlantRewardRepo plantRewardRepo;

    // @Scheduled(cron = "0 0 6 * * *")
    @Scheduled(cron = "0 * * * * *")
    public void acquirePlants() {
        List<Plant> plants = plantRepo.findAll();
        RandomPlantManager plantManager = new RandomPlantManager(plants);   // 식물 랜덤 생성 객체
        List<PlantReward> plantRewards = new ArrayList<>(); // saveAll 을 위한 객체

        // 어제 완료된 일 전체 가져오기
        LocalDate now = LocalDate.now();
        LocalDate targetDay = now.minusDays(1);
        List<Calendar> userCalendarResponseList = calendarRepo.findByDateAndToDoCompletedIsTrue(targetDay);

        printStart();

        for (Calendar c : userCalendarResponseList) {
            String userId = c.getUser().getId();
            // count 를 어케 누적시키지
        }

        System.out.println(plantManager.getRandomPlant().getName());
    }

    private void printStart() {  // 스레드 시작 시간 출력
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 a h시 m분");
        String nowString = now.format(dateTimeFormatter);
        System.out.println(nowString + "  스케줄 시작");
    }

}
