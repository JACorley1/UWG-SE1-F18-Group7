package edu.westga.cs3211.time_management.test.calendar;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.Calendar;
import edu.westga.cs3211.time_management.model.Event;
import edu.westga.cs3211.time_management.model.Visibility;

public class TestAddEvent {

	@Test
	public void testAddNullEvent() {
		Calendar myCalendar = new  Calendar();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myCalendar.addEvent(null);
		});
		
	}
	
	@Test
	public void testAddOneEvent() {
		Calendar myCalendar = new  Calendar();
		LocalDate start = LocalDate.now().plusDays(1);
		LocalDate end = start.plusDays(1);
		Event myEvent = new Event("Name", start, end, "school", "homework", Visibility.PUBLIC);
		
		myCalendar.addEvent(myEvent);
		
		assertEquals(1, myCalendar.getEvents().size());
		
	}

}
