package beom.plantoplantserver.service;

import beom.plantoplantserver.model.entity.Calendar;

import java.util.List;

public interface CalendarService {
    List<Calendar> getToDoForMonth(int year, int month);
    List<Calendar> getToDoForNowMonth();
}
