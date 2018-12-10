package edu.westga.cs3211.time_management.model;

import java.time.LocalDateTime;

/**
 * Validate Event information.
 * 
 * @author Dylan Knox, Kyle Riggs, Cody Graham, Tyler Wingfield, Jeremiah
 *         Liscum, Joseph Fuller, Jonathan Corley, Tristen Rivera, Tyler Scott,
 *         Dexter Tarver, Daniel Jeselnik, Dylan McCleskey, Justin Smith,
 *         Jonathan Nicholl
 */
public class EventDataValidator {
	
	/**
	 * Checks if the even name is valid
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param name the name of the event
	 * @return true if the name is valid
	 */
	public static boolean checkName(String name) {
		return !(name == null || name.length() >= 60 || name.isEmpty());
	}
	
	/**
	 * Checks the start time, determining if it is before the current system time.
	 * This is used when displaying user warning when creating events startng in the past.
	 * 
	 * @param startTime the starting time of the event
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true if the start time is before the current time, false otherwise.
	 */
	public static boolean checkStartTime(LocalDateTime startTime) {
		return !(startTime == null || startTime.isBefore(LocalDateTime.now()));
	}
	
	/**
	 * Checks that the start time is valid.
	 * 
	 * @param startTime the start time
	 * @param endTime the end time
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true  if endTime is a valid time after startTime
	 * 		   false if endTime is not valid or is not after startTime
	 */
	public static boolean checkEndTime(LocalDateTime startTime, LocalDateTime endTime) {
		return !(startTime == null || endTime == null) && endTime.isAfter(startTime);
	}

}
