package beom.plantoplantserver.controller;


import beom.plantoplantserver.model.dto.request.CalendarRequest;
import beom.plantoplantserver.model.dto.response.UserCalendarResponse;
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
    public List<UserCalendarResponse> getToDoForNowMonth(@RequestParam("user_id") String user_id){
        return calenderService.getToDoForNowMonth(user_id);
    }

    @PostMapping("months")
    public List<UserCalendarResponse> getToDoForMonth(@RequestBody CalendarRequest request){
        return calenderService.getToDoForMonth(request);
    }
}
