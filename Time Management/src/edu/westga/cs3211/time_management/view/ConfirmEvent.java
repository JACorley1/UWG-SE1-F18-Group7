package edu.westga.cs3211.time_management.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Codebehind for the ConfirmEvent Scene.
 * 
 * @author Jonathan Corley, Daniel Jeselnik
 */
public class ConfirmEvent {

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
	private Button confirmButton;

	@FXML
	private Label nameConfirmationLabel;

	@FXML
	private Label startTimeConfirmationLabel;

	@FXML
	private Label endTimeConfirmationLabel;

	@FXML
	private Label visibilityConfirmationLabel;

	@FXML
	private Label locationConfirmationLabel;

	@FXML
	private Label descriptionConfirmationLabel;

	@FXML
	void initialize() {
		assert this.nameLabel != null : "fx:id=\"nameLabel\" was not injected: check your FXML file 'ConfirmEvent.fxml'.";
		assert this.startTimeLabel != null : "fx:id=\"startTimeLabel\" was not injected: check your FXML file 'ConfirmEvent.fxml'.";
		assert this.endTimeLabel != null : "fx:id=\"endTimeLabel\" was not injected: check your FXML file 'ConfirmEvent.fxml'.";
		assert this.visibilityLabel != null : "fx:id=\"visibilityLabel\" was not injected: check your FXML file 'ConfirmEvent.fxml'.";
		assert this.locationLabel != null : "fx:id=\"locationLabel\" was not injected: check your FXML file 'ConfirmEvent.fxml'.";
		assert this.descriptionLabel != null : "fx:id=\"descriptionLabel\" was not injected: check your FXML file 'ConfirmEvent.fxml'.";
		assert this.cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'ConfirmEvent.fxml'.";
		assert this.confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file 'ConfirmEvent.fxml'.";
		assert this.nameConfirmationLabel != null : "fx:id=\"nameConfirmationLabel\" was not injected: check your FXML file 'ConfirmEvent.fxml'.";
		assert this.startTimeConfirmationLabel != null : "fx:id=\"startTimeConfirmationLabel\" was not injected: check your FXML file 'ConfirmEvent.fxml'.";
		assert this.endTimeConfirmationLabel != null : "fx:id=\"endTimeConfirmationLabel\" was not injected: check your FXML file 'ConfirmEvent.fxml'.";
		assert this.visibilityConfirmationLabel != null : "fx:id=\"visibilityConfirmationLabel\" was not injected: check your FXML file 'ConfirmEvent.fxml'.";
		assert this.locationConfirmationLabel != null : "fx:id=\"locationConfirmationLabel\" was not injected: check your FXML file 'ConfirmEvent.fxml'.";
		assert this.descriptionConfirmationLabel != null : "fx:id=\"descriptionConfirmationLabel\" was not injected: check your FXML file 'ConfirmEvent.fxml'.";

	}
}
