package edu.westga.cs3211.time_management.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import edu.westga.cs3211.time_management.Main;
import edu.westga.cs3211.time_management.model.Calendar;
import edu.westga.cs3211.time_management.model.Event;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Codebehind for the MainWindow Scene.
 * 
 * @author Jonathan Corley
 */
public class MainWindow {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ListView<Event> eventList;

	@FXML
	private TextArea eventDetailsText;

	@FXML
	private Button updateEventButton;

	@FXML
	private Button addEventButton;

	private Calendar calendar;

	@FXML
	void addEvent(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/AddEvent.fxml"));
		loader.load();
		Parent parent = loader.getRoot();
		Scene scene = new Scene(parent);
		Stage addEventStage = new Stage();
		addEventStage.setTitle("Add New Event");
		addEventStage.setScene(scene);
		addEventStage.initModality(Modality.APPLICATION_MODAL);
		AddEvent addEventDialog = loader.getController();
		addEventDialog.setCalendar(this.calendar);
		addEventStage.showAndWait();

		this.eventList.setItems(FXCollections.observableArrayList(this.calendar.getEvents()));
	}
	
	@FXML
	void updateEvent(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/UpdateEvent.fxml"));
		loader.load();
		Parent parent = loader.getRoot();
		Scene scene = new Scene(parent);
		Stage updateEventStage = new Stage();
		updateEventStage.setTitle("Update Event");
		updateEventStage.setScene(scene);
		updateEventStage.initModality(Modality.APPLICATION_MODAL);
		UpdateEvent updateEventDialog = loader.getController();
		updateEventDialog.setCalendar(this.calendar);
		Event selectedEvent = this.eventList.getSelectionModel().getSelectedItem();
		if (selectedEvent != null) {
			updateEventDialog.setEventToUpdate(selectedEvent);
			updateEventDialog.getNameText().setText(selectedEvent.getName());
			updateEventDialog.getStartTimeDate().setValue(selectedEvent.getStartTime());
			updateEventDialog.getEndTimeDate().setValue(selectedEvent.getEndTime());
			updateEventDialog.getVisibilityList().setValue(selectedEvent.getVisibility());
			updateEventDialog.getLocationText().setText(selectedEvent.getLocation());
			updateEventDialog.getDescriptionText().setText(selectedEvent.getDescription());
			updateEventStage.showAndWait();
		}
		

		this.eventList.setItems(FXCollections.observableArrayList(this.calendar.getEvents()));
	}

	@FXML
	void selectEvent(MouseEvent event) {
		Event eventSelected = this.eventList.getSelectionModel().getSelectedItem();
		if (eventSelected != null) {
			this.eventDetailsText.setText(eventSelected.toStringFull());
		}
	}

	@FXML
	void initialize() {
		assert this.eventList != null : "fx:id=\"eventList\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.eventDetailsText != null : "fx:id=\"eventDetailsText\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.updateEventButton != null : "fx:id=\"updateEventButton\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.addEventButton != null : "fx:id=\"addEventButton\" was not injected: check your FXML file 'MainWindow.fxml'.";

		this.calendar = new Calendar();
		this.eventList.setItems(FXCollections.observableArrayList(this.calendar.getEvents()));
	}
}
