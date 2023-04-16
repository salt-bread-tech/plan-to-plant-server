package beom.plantoplantserver.controller;

import beom.plantoplantserver.model.dto.request.CalendarRequest;
import beom.plantoplantserver.model.entity.Calendar;
import beom.plantoplantserver.service.DailyToDoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class DailyToDoController {
    final DailyToDoService dailyToDoService;

    public DailyToDoController(DailyToDoService dailyToDoService){
        this.dailyToDoService = dailyToDoService;
    }

    @GetMapping("/today")
    public List<Calendar> getToDoForToday(){
        return dailyToDoService.getToDoForToday();
    }

    @PostMapping("/optional-dates")
    public List<Calendar> getToDoForDate(@RequestBody CalendarRequest request){
        return dailyToDoService.getToDoForDate(request);
    }
}
