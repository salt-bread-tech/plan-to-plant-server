package beom.plantoplantserver.service;

import beom.plantoplantserver.model.dto.request.AddToDoRequest;
import beom.plantoplantserver.model.dto.request.DeleteToDoRequest;
import beom.plantoplantserver.model.dto.response.UserCalendarResponse;

import java.util.List;

public interface DailyToDoService {
    List<UserCalendarResponse> getAllToDo(String user_id);
    String addToDo(AddToDoRequest request);

    String deleteToDo(DeleteToDoRequest request);
}
