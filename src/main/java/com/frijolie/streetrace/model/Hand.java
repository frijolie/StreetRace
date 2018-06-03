package com.frijolie.streetrace.model;

import com.frijolie.streetrace.model.cards.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Hand is a concrete class used to represent all cards in a players Hand.
 * <p>
 * A Hand is a collection of cards used by a player in the course of a game. Cards are drawn from
 * the drawPile and added to the hand. A player may also remove (play) a card from their Hand into
 * one of the piles on the Tableau (SpeedPile, DistancePile, BattlePile, SafetyPile, and
 * DiscardPile).
 *
 * @author Frijolie
 * @version 0.1
 * @since 0.1
 */
public class Hand {

  /**
   * An ObservableList which contains all cards in the current Hand. Order is not important
   * therefore a list is appropriate.
   */
  private ObservableList<Card> hand;

  /**
   * Constructor.
   */
  Hand() {
    hand = FXCollections.observableList(new ArrayList<>());
  }

  /**
   * Allows a card to be added to the Hand.
   *
   * @param card to be added to the hand
   * @return {@code true} if the card was successfully added to the Hand
   * @throws NullPointerException if the param is null
   */
  final boolean addCard(Card card) {
    Objects.requireNonNull(card, "You cannot add a null card to the hand");
    return hand.add(card);
  }

  /**
   * Allows a card to be removed from the Hand.
   *
   * @param card to be removed from the Hand
   * @return {@code true} if the card was successfully removed from the Hand.
   * @throws NullPointerException if the param is null
   */
  final boolean removeCard(Card card) {
    Objects.requireNonNull(card, "You cannot remove a null card from the hand");
    if (hand.contains(card)) {
      return hand.remove(card);
    } else {
      // TODO handle removeCard if it doesn't exist
      return false;
    }
  }

  /**
   * Returns an ObservableList which contains all cards in the Hand.
   *
   * @return an ObservableList of cards
   */
  public final ObservableList<Card> getCards() {
    return hand;
  }

}