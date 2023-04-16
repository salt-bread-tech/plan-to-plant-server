package beom.plantoplantserver.controller;


import beom.plantoplantserver.model.dto.request.CalendarRequest;
import beom.plantoplantserver.model.entity.Calendar;
import beom.plantoplantserver.service.CalendarService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
    final CalendarService calenderService;

    public CalendarController(CalendarService calenderService) {
        this.calenderService = calenderService;
    }


    @GetMapping("dates")
    public List<Calendar> getToDoForNowMonth(){
        return calenderService.getToDoForNowMonth();
    }

    @PostMapping("months")
    public List<Calendar> getToDoForMonth(@RequestBody CalendarRequest request){
        return calenderService.getToDoForMonth(request);
    }
}
