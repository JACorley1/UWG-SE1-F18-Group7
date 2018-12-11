package edu.westga.cs3211.time_management.test.event;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.Event;
import edu.westga.cs3211.time_management.model.Visibility;

class TestToStringFull {

	@Test
	void test() {
		LocalDate start = LocalDate.now().plusDays(1);
		LocalDate end = start.plusDays(1);
		Event event = new Event("Bob", start, end, "location", "description", Visibility.PUBLIC);
		
		String result = event.toStringFull();

		String expectedString = "";
		expectedString += "Name: Bob" + System.lineSeparator();
		expectedString += "Start time: " + start + System.lineSeparator();
		expectedString += "End time: " + end + System.lineSeparator();
		expectedString += "Location: location" + System.lineSeparator();
		expectedString += "Description: description" + System.lineSeparator();
		expectedString += "Visibility: Public" + System.lineSeparator();
		
		assertEquals(expectedString, result);
	}

}
