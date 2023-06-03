package beom.plantoplantserver.service;

import beom.plantoplantserver.model.dto.request.AddToDoRequest;
import beom.plantoplantserver.model.dto.request.DeleteToDoRequest;
import beom.plantoplantserver.model.dto.request.UpdateToDoRequest;
import beom.plantoplantserver.model.dto.response.UserCalendarResponse;
import beom.plantoplantserver.model.entity.Calendar;
import beom.plantoplantserver.model.entity.User;
import beom.plantoplantserver.repository.CalendarRepo;
import beom.plantoplantserver.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DailyToDoServiceImpl implements DailyToDoService{

    private final CalendarRepo calendarRepo;
    private final UserRepo userRepo;

    @Override
    public List<UserCalendarResponse> getAllToDo(String user_id) {
        List<UserCalendarResponse> userCalendarResponses = calendarRepo.findByUserId(user_id);
        List<UserCalendarResponse> res = new ArrayList<>();
        for (UserCalendarResponse u : userCalendarResponses){
            res.add(UserCalendarResponse.builder()
                    .id(u.getId())
                    .date(u.getDate())
                    .toDo(u.getToDo())
                    .toDoCompleted(u.getToDoCompleted())
                    .build());
        }
        return res;
    }

    @Override
    public String addToDo(AddToDoRequest request) {
        Optional<User> optionalUser = userRepo.findById(request.getId());
        String result = "";

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            calendarRepo.save(Calendar.builder()
                    .user(user)
                    .date(request.getDate())
                    .toDo(request.getToDo())
                    .toDoVisibilityCalendar(request.getToDoVisibilityCalendar())
                    .toDoCompleted(false).build());
            result = "1";
        }
        else {
            result = "2";
        }

        return result;
    }

    @Override
    public String deleteToDo(DeleteToDoRequest request) {
        String result = "";

        calendarRepo.deleteById(request.getToDoId());
        result = "1";

        return result;
    }

    @Override
    public String updateToDo(UpdateToDoRequest request) {
        Optional<User> optionalUser = userRepo.findById(request.getUserId());
        String result = "";

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            calendarRepo.save(Calendar.builder()
                    .id(request.getToDoId())
                    .user(user)
                    .date(request.getDate())
                    .toDo(request.getToDo())
                    .toDoVisibilityCalendar(request.getToDoVisibilityCalendar())
                    .toDoCompleted(request.getToDoCompleted()).build());
            result = "1";
        }
        else {
            result = "2";
        }

        return result;
    }
}
