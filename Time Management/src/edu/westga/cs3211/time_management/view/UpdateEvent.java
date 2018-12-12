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
import javafx.collections.FXCollections;
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
	private TextField nameText;

	@FXML
	private DatePicker startTimeDate;

	@FXML
	private DatePicker endTimeDate;

	@FXML
	private ComboBox<Visibility> visibilityList;

	@FXML
	private TextField locationText;

	@FXML
	private TextField descriptionText;

	private Event eventToUpdate;

	private Calendar calendar;

	@FXML
	void initialize() {
		assert this.nameLabel != null : "fx:id=\"nameLabel\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert this.startTimeLabel != null : "fx:id=\"startTimeLabel\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert this.endTimeLabel != null : "fx:id=\"endTimeLabel\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert this.visibilityLabel != null : "fx:id=\"visibilityLabel\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert this.locationLabel != null : "fx:id=\"locationLabel\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert this.descriptionLabel != null : "fx:id=\"descriptionLabel\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert this.cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert this.updateEventButton != null : "fx:id=\"updateEventButton\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert this.nameText != null : "fx:id=\"nameTextField\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert this.startTimeDate != null : "fx:id=\"startTimeDatePicker\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert this.endTimeDate != null : "fx:id=\"endTimeDatePicker\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert this.visibilityList != null : "fx:id=\"visibilityComboBox\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert this.locationText != null : "fx:id=\"locationTextField\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert this.descriptionText != null : "fx:id=\"descriptionTextField\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
	
		this.visibilityList.setItems(FXCollections.observableArrayList());
		this.visibilityList.getItems().add(Visibility.PUBLIC);
		this.visibilityList.getItems().add(Visibility.PRIVATE);
		this.visibilityList.getItems().add(Visibility.FRIENDS_ONLY);
		this.visibilityList.setValue(Visibility.PUBLIC);
		this.startTimeDate.setValue(LocalDate.now());
		this.endTimeDate.setValue(LocalDate.now());
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
		String name = this.nameText.getText();
		LocalDate startTime = this.startTimeDate.getValue();
		LocalDate endTime = this.endTimeDate.getValue();
		String errorText = "";
		errorText = this.validateData(name, startTime, endTime, errorText);
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
		this.calendar.removeEvent(this.eventToUpdate);
		List<Event> conflictingEvents = this.calendar.declareConflicts(updatedEvent);
		String eventText = updatedEvent.toStringFull();
		String conflictText = this.checkConflicts(conflictingEvents);
		String eventSummaryAndConflictText = "UPDATE EVENT DETAILS" + System.lineSeparator() + eventText + System.lineSeparator() + "CONFLICTING EVENTS" + conflictText;
		Alert alert = new Alert(AlertType.CONFIRMATION, eventSummaryAndConflictText);
		alert.setTitle("Create New Event?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.isPresent() && result.get() == ButtonType.OK) {
			this.calendar.addEvent(updatedEvent);
			((Node) event.getSource()).getScene().getWindow().hide();
		}
	}

	private String checkConflicts(List<Event> conflictingEvents) {
		String conflictText = "";
		for (Event currEvent : conflictingEvents) {
			conflictText += currEvent.toString() + System.lineSeparator();
		}
		return conflictText;
	}

	private String validateData(String name, LocalDate startTime, LocalDate endTime, String errorText) {
		if (!EventDataValidator.checkName(name)) {
			errorText += "Name is invalid" + System.lineSeparator();
		}
		if (!EventDataValidator.checkStartTime(startTime)) {
			errorText += "Start time is invalid" + System.lineSeparator();
		} else if (!EventDataValidator.checkEndTime(startTime, endTime)) {
			errorText += "End time is invalid" + System.lineSeparator();
		}
		return errorText;
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

	/**
	 * Gets name text.
	 * @return name text
	 */
	public TextField getNameText() {
		return this.nameText;
	}

	/**
	 * gets start time date
	 * @return start time date
	 */
	public DatePicker getStartTimeDate() {
		return this.startTimeDate;
	}

	/**
	 * gets end time date
	 * @return end time date
	 */
	public DatePicker getEndTimeDate() {
		return this.endTimeDate;
	}

	/**
	 * gets visibility list
	 * @return visibility list
	 */
	public ComboBox<Visibility> getVisibilityList() {
		return this.visibilityList;
	}

	/**
	 * gets location text
	 * @return location text
	 */
	public TextField getLocationText() {
		return this.locationText;
	}

	/**
	 * gets description text
	 * @return description text
	 */
	public TextField getDescriptionText() {
		return this.descriptionText;
	}

	/**
	 * sets event to update
	 * 
	 * @param eventToUpdate the event to update
	 */
	public void setEventToUpdate(Event eventToUpdate) {
		this.eventToUpdate = eventToUpdate;
	}
}
