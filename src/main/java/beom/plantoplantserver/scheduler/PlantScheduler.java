package beom.plantoplantserver.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PlantScheduler {

    @Scheduled(cron = "0 0 6 * * *")
    public void acquirePlants() {

    }

}
