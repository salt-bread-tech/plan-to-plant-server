package beom.plantoplantserver.controller;


import beom.plantoplantserver.model.entity.Calendar;
import beom.plantoplantserver.service.CalendarService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
    final CalendarService calenderService;

    public CalendarController(CalendarService calenderService) {
        this.calenderService = calenderService;
    }

    @PostMapping("get-to-do-for-now-month")
    public List<Calendar> getToDoForNowMonth() {
        return calenderService.getToDoForNowMonth();
    }

    @PostMapping("get-to-do-for-month")
    public List<Calendar> getToDoForMonth(@RequestParam("year") int year,
                                          @RequestParam("month") int month){
        return calenderService.getToDoForMonth(year, month);
    }
}
