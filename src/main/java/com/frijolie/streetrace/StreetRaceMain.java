package com.frijolie.streetrace;

import com.frijolie.streetrace.controller.MenuController;
import com.frijolie.streetrace.controller.TableauController;
import com.frijolie.streetrace.controller.StatusLabelController;
import com.frijolie.streetrace.model.StreetRaceGame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * StreetRaceMain is the class which launches and loads the GUI classes.
 *
 * @author Frijolie
 * @version 0.1
 * @since 0.1
 */
public class StreetRaceMain extends Application {

  private final String TITLE = "StreetRace";
  private final String VERSION = "0.1";

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {

    BorderPane root = new BorderPane();

    FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("/fxml/MainMenu.fxml"));
    root.setTop(menuLoader.load());
    MenuController menuController = menuLoader.getController();

    FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/fxml/MainWindow.fxml"));
    root.setCenter(mainLoader.load());
    TableauController tableauController = mainLoader.getController();

    FXMLLoader statusLoader = new FXMLLoader(getClass().getResource("/fxml/StatusLabel.fxml"));
    root.setBottom(statusLoader.load());
    StatusLabelController statusLabelController = statusLoader.getController();

    Scene scene = new Scene(root);

    stage.setTitle(TITLE + " v " + VERSION);
    stage.setResizable(false);
    stage.getIcons().add(new Image("/images/checkered-flag.png"));
    stage.setScene(scene);
    stage.show();

    StreetRaceGame game = new StreetRaceGame();

    menuController.injectModel(game);
    tableauController.injectModel(game);
    statusLabelController.injectModel(game);

    game.startGame();
  }

}