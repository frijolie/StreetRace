package com.frijolie.streetrace.controller;

import com.frijolie.streetrace.model.StreetRaceGame;
import com.frijolie.streetrace.model.cards.Card;
import com.frijolie.streetrace.model.cards.HazardCardType;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * TableauController is the controller class for the Main scene in the game.
 *
 * @author Frijolie
 * @version 0.1
 * @since 0.1
 */
public class TableauController implements Initializable {

  /**
   * A reference to the game model object.
   */
  private StreetRaceGame game;

  /**
   * A reference to the cards in the player's hand.
   */
  private ObservableList<Card> playerHand;

  /**
   * A reference to the cards in the computers hand.
   */
  private ObservableList<Card> computerHand;

  @FXML
  private HBox playerHandHBox;

  /**
   * Holds an ImageView for each card in the game. ImageView is accessed by the name of CardType
   */
  private Map<String, ImageView> cardImages;

  /**
   * Constructor
   */
  public TableauController() {
    populateCardImages();
  }

  private void displayPlayerHand() {
    playerHand = game.getPlayer().getHand().getCards();
    for (Card card : playerHand) {
      playerHandHBox.getChildren().add(getCardImageView(card));
    }
  }

  private void addListeners() {
    playerHand = game.getPlayer().getHand().getCards();
    //playerHand.addListener((ListChangeListener<Card>) c -> displayPlayerHand());
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
  }

  /**
   * Populates a Map with a String key and an ImageView value.
   */
  private void populateCardImages() {
    cardImages = new HashMap<>();
    cardImages.put("ACCIDENT", new ImageView(new Image("/images/cards/ACCIDENT.png")));
    cardImages.put("DRIVING_ACE", new ImageView(new Image("/images/cards/DRIVING_ACE.png")));
    cardImages.put("END_LIMIT", new ImageView(new Image("/images/cards/END_LIMIT.png")));
    cardImages.put("EXTRA_TANK", new ImageView(new Image("/images/cards/EXTRA_TANK.png")));
    cardImages.put("FLAT_TIRE", new ImageView(new Image("/images/cards/FLAT_TIRE.png")));
    cardImages.put("GASOLINE", new ImageView(new Image("/images/cards/GASOLINE.png")));
    cardImages.put("MILES_100", new ImageView(new Image("/images/cards/MILES_100.png")));
    cardImages.put("MILES_200", new ImageView(new Image("/images/cards/MILES_200.png")));
    cardImages.put("MILES_75", new ImageView(new Image("/images/cards/MILES_75.png")));
    cardImages.put("MILES_50", new ImageView(new Image("/images/cards/MILES_50.png")));
    cardImages.put("MILES_25", new ImageView(new Image("/images/cards/MILES_25.png")));
    cardImages.put("OUT_OF_GAS", new ImageView(new Image("/images/cards/OUT_OF_GAS.png")));
    cardImages.put("PUNCTURE_PROOF", new ImageView(new Image("/images/cards/PUNCTURE_PROOF.png")));
    cardImages.put("REPAIR", new ImageView(new Image("/images/cards/REPAIR.png")));
    cardImages.put("RIGHT_OF_WAY", new ImageView(new Image("/images/cards/RIGHT_OF_WAY.png")));
    cardImages.put("ROLL", new ImageView(new Image("/images/cards/ROLL.png")));
    cardImages.put("SPARE_TIRE", new ImageView(new Image("/images/cards/SPARE_TIRE.png")));
    cardImages.put("SPEED_LIMIT", new ImageView(new Image("/images/cards/SPEED_LIMIT.png")));
    cardImages.put("STOP", new ImageView(new Image("/images/cards/STOP.png")));
  }

  /**
   * Injects the model dependency into the controller.
   * @param game model to inject.
   */
  public void injectModel(StreetRaceGame game) {
    this.game = Objects.requireNonNull(game,
        "You cannot pass a null game reference to injectModel in TableauController.java");
    addListeners();
  }

  /**
   * Returns the value, which is an ImageView, of the card param
   * @param card the card for which image you wish to retrieve
   * @return an ImageView of the card you asked for
   */
  ImageView getCardImageView(Card card) {
    Objects.requireNonNull(card, "You must pass a non null card param in getCardImageView.");
    return cardImages.get(card.getType().getName());
  }
}