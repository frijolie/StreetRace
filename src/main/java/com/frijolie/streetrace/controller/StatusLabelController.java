package com.frijolie.streetrace.controller;

import com.frijolie.streetrace.model.StreetRaceGame;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * StatusLabelController is the controller class for the status label at the bottom of the window
 *
 * @author Frijolie
 * @version 0.1
 * @since 0.1
 */
public class StatusLabelController implements Initializable {

  private StreetRaceGame game;

  public void injectModel(StreetRaceGame game) {
    this.game = Objects.requireNonNull(game, "You must pass a non-null reference to the model.");
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }

}