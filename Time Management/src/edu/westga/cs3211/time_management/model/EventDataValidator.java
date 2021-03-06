package edu.westga.cs3211.time_management.model;

import java.time.LocalDate;

/**
 * Validate Event information.
 * 
 * 100% code coverage could not be reached because the class has only static methods.
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
	 * 
	 * @param startTime the starting time of the event
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true if the start time is before the current time, false otherwise.
	 */
	public static boolean checkStartTime(LocalDate startTime) {
		return !(startTime == null || startTime.isBefore(LocalDate.now()));
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
	 * 		   false if endTime is before startTime
	 */
	public static boolean checkEndTime(LocalDate startTime, LocalDate endTime) {
		return !(startTime == null || endTime == null) && !endTime.isBefore(startTime);
	}

}
