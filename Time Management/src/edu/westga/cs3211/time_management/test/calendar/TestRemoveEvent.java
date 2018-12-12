package edu.westga.cs3211.time_management.test.calendar;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.Calendar;
import edu.westga.cs3211.time_management.model.Event;
import edu.westga.cs3211.time_management.model.Visibility;

class TestRemoveEvent {

	@Test
	void testRemoveEvent() {
		Calendar calendar = new Calendar();
		LocalDate start = LocalDate.now().plusDays(1);
		LocalDate end = start.plusDays(1);
		Event event = new Event("Name", start, end, "school", "homework", Visibility.PUBLIC);
		calendar.addEvent(event);
		
		assertTrue(calendar.removeEvent(event));
	}

	@Test
	void testRemoveNonexistentEvent() {
		Calendar calendar = new Calendar();
		LocalDate start = LocalDate.now().plusDays(1);
		LocalDate end = start.plusDays(1);
		Event event = new Event("Name", start, end, "school", "homework", Visibility.PUBLIC);
		
		assertFalse(calendar.removeEvent(event));
	}
	
	@Test
	void testRemoveNull() {
		Calendar calendar = new Calendar();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			calendar.removeEvent(null);
		});
	}
}
