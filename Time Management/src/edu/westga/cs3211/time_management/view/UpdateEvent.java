package edu.westga.cs3211.time_management.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
	private TextField nameTextField;

	@FXML
	private DatePicker startTimeDatePicker;

	@FXML
	private DatePicker endTimeDatePicker;

	@FXML
	private ComboBox<?> visibilityComboBox;

	@FXML
	private TextField locationTextField;

	@FXML
	private TextField descriptionTextField;

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
		assert nameTextField != null : "fx:id=\"nameTextField\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert startTimeDatePicker != null : "fx:id=\"startTimeDatePicker\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert endTimeDatePicker != null : "fx:id=\"endTimeDatePicker\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert visibilityComboBox != null : "fx:id=\"visibilityComboBox\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert locationTextField != null : "fx:id=\"locationTextField\" was not injected: check your FXML file 'UpdateEvent.fxml'.";
		assert descriptionTextField != null : "fx:id=\"descriptionTextField\" was not injected: check your FXML file 'UpdateEvent.fxml'.";

	}
}
