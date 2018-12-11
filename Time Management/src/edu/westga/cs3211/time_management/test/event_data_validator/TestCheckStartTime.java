package edu.westga.cs3211.time_management.test.event_data_validator;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.EventDataValidator;

class TestCheckStartTime {

	@Test
	void testNullStartTime() {
		boolean result = EventDataValidator.checkStartTime(null);
		
		assertFalse(result);
	}
	
	@Test
	void testStartTimeBeforeCurrentTime() {
		LocalDate timeBeforeNow = LocalDate.now().minusDays(1);
		
		boolean result = EventDataValidator.checkStartTime(timeBeforeNow);
		
		assertFalse(result);
	}

	@Test
	void testStartTimeAtCurrentTime() {
		LocalDate currentTime = LocalDate.now();
		
		boolean result = EventDataValidator.checkStartTime(currentTime);
		
		assertTrue(result);
	}
	
	@Test
	void testStartTimeAfterCurrentTime() {
		LocalDate timeAfterNow = LocalDate.now().plusDays(1);
		
		boolean result = EventDataValidator.checkStartTime(timeAfterNow);
		
		assertTrue(result);
	}
	
}
