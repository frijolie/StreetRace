package com.frijolie.streetrace.controller;

import com.frijolie.streetrace.model.StreetRaceGame;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

/**
 * MenuController is the controller class for the Menu in the application
 *
 * @author Frijolie
 * @version 0.1
 * @since 0.1
 */
public class MenuController implements Initializable {

  @FXML
  private Menu fileMenu;

  @FXML
  private MenuItem newGameMenuItem;

  @FXML
  private MenuItem exitMenuItem;

  @FXML
  private Menu editMenu;

  @FXML
  private MenuItem preferencesMenuItem;

  @FXML
  private Menu helpMenu;

  @FXML
  private MenuItem rulesMenuItem;

  @FXML
  private MenuItem aboutMenuItem;

  @FXML
  private BorderPane mainBorderPane;

  private StreetRaceGame game;

  public void injectModel(StreetRaceGame game) {
    this.game = Objects.requireNonNull(game, "You cannot pass a null game reference.");
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    setMenuItemIcons();
  }

  public void setMenuItemIcons() {
    ImageView newGameMenuIcon = new ImageView(new Image("images/newgame.png"));
    newGameMenuIcon.setFitHeight(20);
    newGameMenuIcon.setFitWidth(20);
    newGameMenuItem.setGraphic(newGameMenuIcon);

    ImageView exitMenuIcon = new ImageView(new Image("images/exit.png"));
    exitMenuIcon.setFitHeight(20);
    exitMenuIcon.setFitWidth(20);
    exitMenuItem.setGraphic(exitMenuIcon);

    ImageView prefMenuIcon = new ImageView(new Image("images/preferences.png"));
    prefMenuIcon.setFitHeight(20);
    prefMenuIcon.setFitWidth(20);
    preferencesMenuItem.setGraphic(prefMenuIcon);

    ImageView rulesMenuIcon = new ImageView(new Image("images/rules.png"));
    rulesMenuIcon.setFitHeight(20);
    rulesMenuIcon.setFitWidth(20);
    rulesMenuItem.setGraphic(rulesMenuIcon);

    ImageView aboutMenuIcon = new ImageView(new Image("images/about.png"));
    aboutMenuIcon.setFitHeight(20);
    aboutMenuIcon.setFitWidth(20);
    aboutMenuItem.setGraphic(aboutMenuIcon);

  }

  @FXML
  public void handleExit() {
    Platform.exit();
  }

}
