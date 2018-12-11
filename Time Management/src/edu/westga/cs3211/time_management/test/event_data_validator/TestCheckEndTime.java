package edu.westga.cs3211.time_management.test.event_data_validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.EventDataValidator;

class TestCheckEndTime {

	@Test
	void testValidEndtime() {
		LocalDate startTime = LocalDate.of(2011, 2, 3);
		LocalDate endTime = startTime.plusDays(1);
		
		boolean result = EventDataValidator.checkEndTime(startTime, endTime);
		
		assertTrue(result);
	}
	
	
	@Test
	void testInvalidEndtimeEarlierThanStartTime() {
		LocalDate startTime = LocalDate.of(2011, 2, 3);
		LocalDate endTime = startTime.minusDays(1);
		
		boolean result = EventDataValidator.checkEndTime(startTime, endTime);
		
		assertFalse(result);
	}
	
	@Test
	void testErrorNullStart() {
		LocalDate endTime = LocalDate.of(2011, 2, 3);
		
		assertFalse(EventDataValidator.checkEndTime(null, endTime));
	}
	
	@Test
	void testErrorNullEnd() {
		LocalDate startTime = LocalDate.of(2011, 2, 3);
		
		boolean result = EventDataValidator.checkEndTime(startTime, null);
		
		assertFalse(result);
	}
	
	

}
