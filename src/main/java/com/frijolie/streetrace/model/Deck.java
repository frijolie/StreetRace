package com.frijolie.streetrace.model;

import com.frijolie.streetrace.model.cards.Card;
import com.frijolie.streetrace.model.cards.DistanceCard;
import com.frijolie.streetrace.model.cards.DistanceCardType;
import com.frijolie.streetrace.model.cards.HazardCard;
import com.frijolie.streetrace.model.cards.HazardCardType;
import com.frijolie.streetrace.model.cards.RemedyCard;
import com.frijolie.streetrace.model.cards.RemedyCardType;
import com.frijolie.streetrace.model.cards.SafetyCard;
import com.frijolie.streetrace.model.cards.SafetyCardType;
import com.frijolie.streetrace.model.cards.SpeedCard;
import com.frijolie.streetrace.model.cards.SpeedCardType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Deck is a concrete class used to represent all possible cards in StreetRace.
 * <p>
 * A Deck contains all permutations of the cards used in StreetRace. The deck is used to deal cards
 * to each player in the game. It has a few utility methods to populate and clear the deck. Upon
 * instantiation a Deck is created with all the necessary cards necessary in the game. The Deck is
 * then shuffled.
 * <p>
 * A full deck consists of:
 * <table border="1">
 * <thead>
 * <tr><th>CardType</th><th>Card Name</th><th>Count</th></tr>
 * </thead>
 * <tbody>
 * <tr><td rowspan="5">Distance</td><td>MILES_25</td><td>10</td></tr>
 * <tr><td>MILES_50</td><td>10</td></tr>
 * <tr><td>MILES_75</td><td>10</td></tr>
 * <tr><td>MILES_100</td><td>12</td></tr>
 * <tr><td>MILES_200</td><td>4</td></tr>
 * <tr><td rowspan="4">Hazard</td><td>ACCIDENT</td><td>3</td></tr>
 * <tr><td>OUT OF GAS</td><td>3</td></tr>
 * <tr><td>FLAT TIRE</td><td>3</td></tr>
 * <tr><td>STOP</td><td>5</td></tr>
 * <tr><td rowspan="4">Remedy</td><td>REPAIR</td><td>6</td></tr>
 * <tr><td>GASOLINE</td><td>6</td></tr>
 * <tr><td>SPARE TIRE</td><td>6</td></tr>
 * <tr><td>ROLL</td><td>14</td></tr>
 * <tr><td rowspan="2">Speed</td><td>SPEED LIMIT</td><td>4</td></tr>
 * <tr><td>END LIMIT</td><td>6</td></tr>
 * <tr><td rowspan="4">Safety</td><td>DRIVING ACE</td><td>1</td></tr>
 * <tr><td>RIGHT_OF_WAY</td><td>1</td></tr>
 * <tr><td>EXTRA TANK</td><td>1</td></tr>
 * <tr><td>PUNCTURE PROOF</td><td>1</td></tr>
 * </tbody>
 * </table>
 *
 * @author Frijolie
 * @version 0.1
 * @since 0.1
 */
public class Deck {

  /**
   * A List to contain all of the cards in StreetRace.
   */
  private final List<Card> deck;

  /**
   * Constructor. Instantiates all cards in a standard deck of StreetRace cards. Shuffles the deck.
   */
  Deck() {
    deck = new ArrayList<>();
    populate();
    shuffle();
  }

  /**
   * Populates the deck with all the proper number of cards for the game.
   */
  private void populate() {
    IntStream.range(0, 14).forEach(i -> deck.add(new RemedyCard(RemedyCardType.ROLL)));
    IntStream.range(0, 12).forEach(i -> deck.add(new DistanceCard(DistanceCardType.MILES_100)));
    IntStream.range(0, 10).forEach(i -> deck.add(new DistanceCard(DistanceCardType.MILES_25)));
    IntStream.range(0, 10).forEach(i -> deck.add(new DistanceCard(DistanceCardType.MILES_50)));
    IntStream.range(0, 10).forEach(i -> deck.add(new DistanceCard(DistanceCardType.MILES_75)));
    IntStream.range(0, 6).forEach(i -> deck.add(new RemedyCard(RemedyCardType.REPAIR)));
    IntStream.range(0, 6).forEach(i -> deck.add(new RemedyCard(RemedyCardType.GASOLINE)));
    IntStream.range(0, 6).forEach(i -> deck.add(new RemedyCard(RemedyCardType.SPARE_TIRE)));
    IntStream.range(0, 6).forEach(i -> deck.add(new SpeedCard(SpeedCardType.END_LIMIT)));
    IntStream.range(0, 5).forEach(i -> deck.add(new HazardCard(HazardCardType.STOP)));
    IntStream.range(0, 4).forEach(i -> deck.add(new SpeedCard(SpeedCardType.SPEED_LIMIT)));
    IntStream.range(0, 4).forEach(i -> deck.add(new DistanceCard(DistanceCardType.MILES_200)));
    IntStream.range(0, 3).forEach(i -> deck.add(new HazardCard(HazardCardType.ACCIDENT)));
    IntStream.range(0, 3).forEach(i -> deck.add(new HazardCard(HazardCardType.OUT_OF_GAS)));
    IntStream.range(0, 3).forEach(i -> deck.add(new HazardCard(HazardCardType.FLAT_TIRE)));
    deck.add(new SafetyCard(SafetyCardType.DRIVING_ACE));
    deck.add(new SafetyCard(SafetyCardType.EXTRA_TANK));
    deck.add(new SafetyCard(SafetyCardType.PUNCTURE_PROOF));
    deck.add(new SafetyCard(SafetyCardType.RIGHT_OF_WAY));
  }

  /**
   * Clears the deck, repopulates the deck with all of the necessary cards, then shuffles the deck
   */
  final void reset() {
    deck.clear();
    populate();
    shuffle();
  }

  /**
   * Shuffles the deck.
   */
  private void shuffle() {
    Collections.shuffle(deck);
  }

  /**
   * Returns a List which contains all of the cards in the deck.
   *
   * @return a List which contains all the cards in the game.
   */
  final List<Card> getCards() {
    return new ArrayList<>(deck);
  }

}