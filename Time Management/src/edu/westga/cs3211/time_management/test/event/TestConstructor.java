package edu.westga.cs3211.time_management.test.event;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.Event;
import edu.westga.cs3211.time_management.model.Visibility;

class TestConstructor {

	@Test
	void testInvalidName() {	
		LocalDate start = LocalDate.now().plusDays(1);
		LocalDate end = start.plusDays(1);
		
		assertThrows(
						IllegalArgumentException.class, 
						()->{
							new Event(null, start, end, "", "", Visibility.PUBLIC);
						}
					);
	}

	@Test
	void testInvalidStartTime() {		
		LocalDate start = LocalDate.now().plusDays(1);
		LocalDate end = start.plusDays(1);
			
		assertThrows(
						IllegalArgumentException.class, 
						()->{
							new Event("Bob", null, end, "", "", Visibility.PUBLIC);
						}
					);
	}

	@Test
	void testInvalidEndTime() {		
		LocalDate start = LocalDate.now().plusDays(1);
			
		assertThrows(
						IllegalArgumentException.class, 
						()->{
							new Event("Bob", start, null, "", "", Visibility.PUBLIC);
						}
					);
	}

	@Test
	void testNullLocation() {		
		LocalDate start = LocalDate.now().plusDays(1);
		LocalDate end = start.plusDays(1);
			
		assertThrows(
						IllegalArgumentException.class, 
						()->{
							new Event("Bob", start, end, null, "", Visibility.PUBLIC);
						}
					);
	}

	@Test
	void testNullDescription() {		
		LocalDate start = LocalDate.now().plusDays(1);
		LocalDate end = start.plusDays(1);
			
		assertThrows(
						IllegalArgumentException.class, 
						()->{
							new Event("Bob", start, end, "", null, Visibility.PUBLIC);
						}
					);
	}

	@Test
	void testNullVisibility() {		
		LocalDate start = LocalDate.now().plusDays(1);
		LocalDate end = start.plusDays(1);
			
		assertThrows(
						IllegalArgumentException.class, 
						()->{
							new Event("Bob", start, end, "", "", null);
						}
					);
	}

	@Test
	void testValidEvent() {			
		LocalDate start = LocalDate.now().plusDays(1);
		LocalDate end = start.plusDays(1);
		
		Event result = new Event("Bob", start, end, "location", "description", Visibility.PUBLIC);
		
		assertEquals("Bob", result.getName(), "checking name");
		assertEquals(start, result.getStartTime(), "checking start time");
		assertEquals(end, result.getEndTime(), "checking end time");
		assertEquals("location", result.getLocation(), "checking location");
		assertEquals("description", result.getDescription(), "checking description");
		assertEquals(Visibility.PUBLIC, result.getVisibility(), "checking visibility");
	}

}
