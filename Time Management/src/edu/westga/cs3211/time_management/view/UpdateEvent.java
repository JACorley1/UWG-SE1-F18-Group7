package edu.westga.cs3211.time_management.view;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import edu.westga.cs3211.time_management.model.Calendar;
import edu.westga.cs3211.time_management.model.Event;
import edu.westga.cs3211.time_management.model.EventDataValidator;
import edu.westga.cs3211.time_management.model.Visibility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

/**
 * Codebehind for the UpdateEvent Scene.
 * 
 * @author Jonathan Corley, Daniel Jeselnik
 */

public class UpdateEvent {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label nameLabel;

	@FXML
	private Label startTimeLabel;

	@FXML
	private Label endTimeLabel;

	@FXML
	private Label visibilityLabel;

	@FXML
	private Label locationLabel;

	@FXML
	private Label descriptionLabel;

	@FXML
	private Button cancelButton;

	@FXML
	private Button updateEventButton;

	@FXML
	public TextField nameText;

	@FXML
	public DatePicker startTimeDate;

	@FXML
	public DatePicker endTimeDate;

	@FXML
	public ComboBox<Visibility> visibilityList;

	@FXML
	public TextField locationText;

	@FXML
	public TextField descriptionText;
	
	public Event eventToUpdate;

	private Calendar calendar;

	@FXML
	void initialize() {
		assert nameLabel != null : "fx:id=\"nameLabel\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert startTimeLabel != null : "fx:id=\"startTimeLabel\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert endTimeLabel != null : "fx:id=\"endTimeLabel\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert visibilityLabel != null : "fx:id=\"visibilityLabel\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert locationLabel != null : "fx:id=\"locationLabel\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert descriptionLabel != null : "fx:id=\"descriptionLabel\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert updateEventButton != null : "fx:id=\"updateEventButton\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert nameText != null : "fx:id=\"nameTextField\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert startTimeDate != null : "fx:id=\"startTimeDatePicker\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert endTimeDate != null : "fx:id=\"endTimeDatePicker\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert visibilityList != null : "fx:id=\"visibilityComboBox\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert locationText != null : "fx:id=\"locationTextField\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert descriptionText != null : "fx:id=\"descriptionTextField\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
	}

	private void displayErrorMessage(String errorMessage) {
		Alert alert = new Alert(AlertType.ERROR, errorMessage);
		alert.showAndWait();
	}

	@FXML
	void cancel(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	@FXML
	void updateEvent(ActionEvent event) {
		String errorText = "";
		String name = this.nameText.getText();
		if (!EventDataValidator.checkName(name)) {
			errorText += "Name is invalid" + System.lineSeparator();
		}
		LocalDate startTime = this.startTimeDate.getValue();
		LocalDate endTime = this.endTimeDate.getValue();
		if (!EventDataValidator.checkStartTime(startTime)) {
			errorText += "Start time is invalid" + System.lineSeparator();
		} else if (!EventDataValidator.checkEndTime(startTime, endTime)) {
			errorText += "End time is invalid" + System.lineSeparator();
		}
		if (!errorText.isEmpty()) {
			this.displayErrorMessage(errorText);
			return;
		}

		String location = this.locationText.getText();
		if (location == null) {
			location = "";
		}
		String description = this.descriptionText.getText();
		if (description == null) {
			description = "";
		}
		Visibility visibility = this.visibilityList.getValue();

		Event updatedEvent = new Event(name, startTime, endTime, location, description, visibility);

		List<Event> conflictingEvents = this.calendar.declareConflicts(updatedEvent);

		String eventText = updatedEvent.toStringFull();
		String conflictText = "";
		for (Event currEvent : conflictingEvents) {
			conflictText += currEvent.toString() + System.lineSeparator();
		}
		String eventSummaryAndConflictText = "UPDATE EVENT DETAILS" + System.lineSeparator() + eventText
				+ System.lineSeparator() + "CONFLICTING EVENTS" + conflictText;
		Alert alert = new Alert(AlertType.CONFIRMATION, eventSummaryAndConflictText);
		alert.setTitle("Create New Event?");

		Optional<ButtonType> result = alert.showAndWait();

		if (result.isPresent() && result.get() == ButtonType.OK) {
			this.calendar.removeEvent(eventToUpdate);
			this.calendar.addEvent(updatedEvent);
			((Node) event.getSource()).getScene().getWindow().hide();
		}
	}

	/**
	 * Sets the calendar.
	 * 
	 * @precondition calendar != null
	 * @postcondition this.calendar == calendar
	 * 
	 * @param calendar the calendar to set
	 */
	public void setCalendar(Calendar calendar) {
		if (calendar == null) {
			throw new IllegalArgumentException("Calendar provided was null");
		}
		this.calendar = calendar;
	}

}
