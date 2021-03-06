package edu.westga.cs3211.time_management.model;

import java.time.LocalDate;

/**
 * Store basic information for an event.
 * 
 * @author Lucas Carlson, Carson Bedrosian, Nolan Williams, Kevin Flynn,
 *         Jonathan Corley, Tristen Rivera, Tyler Scott, Dexter Tarver, Jonathan
 *         Nicholl
 */
public class Event {

	private String name;
	private LocalDate startTime;
	private LocalDate endTime;
	private String location;
	private String description;
	private Visibility visibility;

	/**
	 * Creates a new Event
	 * 
	 * @precondition EventDataValidator.checkName(name) &&
	 *               EventDataValidator.checkStartTime(start) &&
	 *               EventDataValidator.checkEndTime(start, end) && location != null
	 *               && description != null && visibility != null
	 * @postcondition getName() == name && getStartTime() == startTime &&
	 *                getEndTime() == endTime && getLocation() == location &&
	 *                getDescription() == description && getVisibility() ==
	 *                visibility
	 * 
	 * @param name        name of the event
	 * @param start       start time for the event
	 * @param end         end time for the event
	 * @param location    location for the event
	 * @param description description of the event
	 * @param visibility  visibility of the event
	 */
	public Event(String name, LocalDate start, LocalDate end, String location, String description,
			Visibility visibility) {
		if (!EventDataValidator.checkName(name)) {
			throw new IllegalArgumentException("Invalid name");
		}
		if (!EventDataValidator.checkStartTime(start)) {
			throw new IllegalArgumentException("Invalid start time");
		}
		if (!EventDataValidator.checkEndTime(start, end)) {
			throw new IllegalArgumentException("Invalid end time");
		}
		if (location == null) {
			throw new IllegalArgumentException("Invalid location");
		}
		if (description == null) {
			throw new IllegalArgumentException("Invalid description");
		}
		if (visibility == null) {
			throw new IllegalArgumentException("Invalid visibility");
		}
		this.name = name;
		this.startTime = start;
		this.endTime = end;
		this.location = location;
		this.description = description;
		this.visibility = visibility;
	}

	/**
	 * return the name of the event
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name of the event
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * return the start time of the event
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the start time of the event
	 */
	public LocalDate getStartTime() {
		return this.startTime;
	}

	/**
	 * return the end time of the event
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the end time of the event
	 */
	public LocalDate getEndTime() {
		return this.endTime;
	}

	/**
	 * return the location of the event
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the location of the event
	 */
	public String getLocation() {
		return this.location;
	}

	/**
	 * return the description of the event
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the description of the event
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * return the visibility of the event
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the visibility of the event
	 */
	public Visibility getVisibility() {
		return this.visibility;
	}

	/**
	 * Convert the Event to a String representation.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return String representation of the Event
	 */
	@Override
	public String toString() {
		return this.name + "(" + this.startTime + "," + this.endTime + ")";
	}

	/**
	 * Generate a multi-line full string representation of the event.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return Multi-line full string representation
	 */
	public String toStringFull() {
		String fullEventDetails = "";
		fullEventDetails += "Name: " + this.name + System.lineSeparator();
		fullEventDetails += "Start time: " + this.startTime + System.lineSeparator();
		fullEventDetails += "End time: " + this.endTime + System.lineSeparator();
		fullEventDetails += "Location: " + this.location + System.lineSeparator();
		fullEventDetails += "Description: " + this.description + System.lineSeparator();
		fullEventDetails += "Visibility: " + this.visibility + System.lineSeparator();

		return fullEventDetails;
	}

}
