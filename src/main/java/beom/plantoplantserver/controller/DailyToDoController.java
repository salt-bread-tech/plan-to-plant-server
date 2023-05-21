package beom.plantoplantserver.controller;

import beom.plantoplantserver.model.dto.request.AddToDoRequest;
import beom.plantoplantserver.model.dto.request.DeleteToDoRequest;
import beom.plantoplantserver.model.dto.request.UpdateToDoRequest;
import beom.plantoplantserver.model.dto.response.UserCalendarResponse;
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

    @GetMapping("/all")
    public List<UserCalendarResponse> getToDoAll(@RequestParam("user_id") String user_id){
        return dailyToDoService.getAllToDo(user_id);
    }

    @PostMapping("/add")
    public String addToDo(@RequestBody AddToDoRequest request) {
        return dailyToDoService.addToDo(request);
    }

    @PostMapping("/delete")
    public String deleteToDo(@RequestBody DeleteToDoRequest request) {
        return dailyToDoService.deleteToDo(request);
    }

    @PostMapping("/update")
    public String updateToDo(@RequestBody UpdateToDoRequest request) {
        return dailyToDoService.updateToDo(request);
    }
}
