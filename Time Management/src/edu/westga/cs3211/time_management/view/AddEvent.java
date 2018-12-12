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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Codebehind for the AddEvent Scene.
 * 
 * @author Jonathan Corley, Jonathan Nicholl
 */
public class AddEvent {

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
	private Button addEventButton;

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

	private Calendar calendar;

	private void displayErrorMessage(String errorMessage) {
		Alert alert = new Alert(AlertType.ERROR, errorMessage);
		alert.showAndWait();
	}

	@FXML
	void cancel(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	@FXML
	void addEvent(ActionEvent event) {
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

		Event newEvent = new Event(name, startTime, endTime, location, description, visibility);

		List<Event> conflictingEvents = this.calendar.declareConflicts(newEvent);

		String eventText = newEvent.toStringFull();
		String conflictText = "";
		for (Event currEvent : conflictingEvents) {
			conflictText += currEvent.toString() + System.lineSeparator();
		}
		String eventSummaryAndConflictText = "NEW EVENT DETAILS" + System.lineSeparator() + eventText
				+ System.lineSeparator() + "CONFLICTING EVENTS" + conflictText;
		Alert alert = new Alert(AlertType.CONFIRMATION, eventSummaryAndConflictText);
		alert.setTitle("Create New Event?");

		Optional<ButtonType> result = alert.showAndWait();

		if (result.isPresent() && result.get() == ButtonType.OK) {
			this.calendar.addEvent(newEvent);
			((Node) event.getSource()).getScene().getWindow().hide();
		}
	}

	@FXML
	void initialize() {
		assert this.nameLabel != null : "fx:id=\"nameLabel\" was not injected: check your FXML file 'AddEvent.fxml'.";
		assert this.startTimeLabel != null : "fx:id=\"startTimeLabel\" was not injected: check your FXML file 'AddEvent.fxml'.";
		assert this.endTimeLabel != null : "fx:id=\"endTimeLabel\" was not injected: check your FXML file 'AddEvent.fxml'.";
		assert this.visibilityLabel != null : "fx:id=\"visibilityLabel\" was not injected: check your FXML file 'AddEvent.fxml'.";
		assert this.locationLabel != null : "fx:id=\"locationLabel\" was not injected: check your FXML file 'AddEvent.fxml'.";
		assert this.descriptionLabel != null : "fx:id=\"descriptionLabel\" was not injected: check your FXML file 'AddEvent.fxml'.";
		assert this.cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'AddEvent.fxml'.";
		assert this.addEventButton != null : "fx:id=\"addEventButton\" was not injected: check your FXML file 'AddEvent.fxml'.";
		assert this.nameText != null : "fx:id=\"nameText\" was not injected: check your FXML file 'AddEvent.fxml'.";
		assert this.startTimeDate != null : "fx:id=\"startTimeDate\" was not injected: check your FXML file 'AddEvent.fxml'.";
		assert this.endTimeDate != null : "fx:id=\"endTimeDate\" was not injected: check your FXML file 'AddEvent.fxml'.";
		assert this.visibilityList != null : "fx:id=\"visibilityList\" was not injected: check your FXML file 'AddEvent.fxml'.";
		assert this.locationText != null : "fx:id=\"locationText\" was not injected: check your FXML file 'AddEvent.fxml'.";
		assert this.descriptionText != null : "fx:id=\"descriptionText\" was not injected: check your FXML file 'AddEvent.fxml'.";

		this.visibilityList.setItems(FXCollections.observableArrayList());
		this.visibilityList.getItems().add(Visibility.PUBLIC);
		this.visibilityList.getItems().add(Visibility.PRIVATE);
		this.visibilityList.getItems().add(Visibility.FRIENDS_ONLY);
		this.visibilityList.setValue(Visibility.PUBLIC);
		this.startTimeDate.setValue(LocalDate.now());
		this.endTimeDate.setValue(LocalDate.now());
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
