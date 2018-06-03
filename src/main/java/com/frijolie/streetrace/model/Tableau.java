package com.frijolie.streetrace.model;

import com.frijolie.streetrace.model.cards.BattleCard;
import com.frijolie.streetrace.model.cards.Card;
import com.frijolie.streetrace.model.cards.CardType;
import com.frijolie.streetrace.model.cards.DistanceCard;
import com.frijolie.streetrace.model.cards.DistanceCardType;
import com.frijolie.streetrace.model.cards.HazardCard;
import com.frijolie.streetrace.model.cards.RemedyCard;
import com.frijolie.streetrace.model.cards.RemedyCardType;
import com.frijolie.streetrace.model.cards.SafetyCard;
import com.frijolie.streetrace.model.cards.SafetyCardType;
import com.frijolie.streetrace.model.cards.SpeedCard;
import com.frijolie.streetrace.model.cards.SpeedCardType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Tableau is a concrete class used to represent the game board in StreetRace
 * <p>
 * Each player has their own tableau. Every tableau contains cards that are played from a players
 * Hand. A tableau has a DistancePile, SafetyPile, DistancePile, and BattlePile. Each of these piles
 * only accept certain types of cards. For example, the DistancePile will only accept DistanceCards
 * and the SafetyPile only accepts SafetyCards. The BattlePile, however, accepts HazardCards as well
 * as RemedyCards.
 * <p>
 * Most cards are played on each players own tableau. The HazardCards, however, are played on their
 * opponents tableau. HazardCards are played offensively and prevent an opponent from proceeding
 * until they are able to play the respective remedy for the hazard. All piles, except the
 * SafetyPile allow for duplicate elements. For the SpeedPile and BattlePile only the top card is
 * important.
 * <p>
 * Each DistanceCard has a value. This value represents the distance the racer (player) has traveled
 * along the racetrack. Once the pre-determined MILE_LIMIT has been reached, the game is over.
 * Therefore each player must keep track of their totalMiles so a winner can be determined.
 *
 * @author Frijolie
 * @version 0.1
 * @see Player
 * @see Card
 * @see CardType
 * @see SafetyCard
 * @see DistanceCard
 * @see BattleCard
 * @see HazardCard
 * @see RemedyCard
 * @since 0.1
 */
public class Tableau {

  /**
   * A collection of DistanceCards. Only cards of type DistanceCardType are allowed.
   */
  private final List<DistanceCard> distancePile;

  /**
   * A collection of SafetyCards. Only cards of type SafetyCardType are allowed.
   */
  private final Set<SafetyCard> safetyPile;

  /**
   * A collection of SpeedCards. Only cards of type SpeedCardType are allowed.
   */
  private final LinkedList<Card> speedPile;

  /**
   * A collection of BattleCards. Only cards of types HazardCardType and RemedyCardType are
   * allowed.
   */
  private final LinkedList<BattleCard> battlePile;

  /**
   * The cumulative sum of all DistanceCard values
   */
  private IntegerProperty totalMiles;

  /**
   * Constructor.
   */
  public Tableau() {
    distancePile = new ArrayList<>();
    safetyPile = new HashSet<>();
    speedPile = new LinkedList<>();
    battlePile = new LinkedList<>();
    totalMiles = new SimpleIntegerProperty(0);
  }

  /**
   * Calculates the cumulative value of all DistanceCards in the DistancePile. Also sets the value
   *
   * @see #setTotalMiles(int)
   */
  private void calculateTotalMiles() {
    setTotalMiles(distancePile.stream().mapToInt(x -> x.getType().getValue()).sum());
  }

  /**
   * Returns the int value of totalMiles
   *
   * @return the value of totalMiles
   */
  final int getTotalMiles() {
    return totalMiles.get();
  }

  /**
   * Sets the IntegerProperty value of totalMiles
   *
   * @param value to be set
   */
  private void setTotalMiles(int value) {
    totalMiles.set(value);
  }

  /**
   * Returns the IntegerProperty of totalMiles
   *
   * @return the IntegerProperty of totalMiles
   */
  final IntegerProperty totalMilesProperty() {
    return totalMiles;
  }

  /**
   * Allows a DistanceCard to be added to the DistancePile. Ensures no more than 2 MILES_200 cards
   * can be added. Order of insertion does not matter. Cards will also not be removed once inserted.
   * Duplicates are allowed. Therefore, a List is an appropriate collection.
   *
   * @param card to be added to the DistancePile
   * @return {@code true} if the card was successfully added to the DistancePile
   * @throws NullPointerException if the param is null
   */
  final boolean addToDistancePile(DistanceCard card) {
    // should only contain MILES_25, MILES_50, MILES_75, MILES_100, and MILES_200 cards
    card = Objects.requireNonNull(card,
        "You cannot add a null value card to the Distance Pile");
    if (card.getType() == DistanceCardType.MILES_200) {
      if (getPlayed200s() < 2) {
        distancePile.add(card);
        calculateTotalMiles();
        return true;
      } else {
        // TODO better error handing if attempting to add 3 or more MILES_200 cards to DistancePile.
        System.err.println("You cannot play 2 or more 200 Miles cards in the Distance Pile.");
        return false;
      }
    } else {
      distancePile.add(card);
      calculateTotalMiles();
      return true;
    }
  }

  /**
   * Allows a SafetyCard to be added to the SafetyPile. Order of insertion is not important. Cards
   * will not be removed. There can only be one type of each SafetyCardType on the tableau.
   * Therefore, a Set is the most appropriate collection for the SafetyPile.
   *
   * @param card to be inserted into the SafetyPile
   * @return {@code true} if the card was successfully added to the SafetyPile
   * @throws NullPointerException if the param is null
   */
  final boolean addToSafetyPile(SafetyCard card) {
    // should only contain DRIVING_ACE, EXTRA_TANK, PUNCTURE_PROOF, and RIGHT_OF_WAY cards
    return safetyPile.add(Objects.requireNonNull(card,
        "You can\'t add a null card to the Safety Pile"));
  }

  /**
   * Allows a SpeedCard to be added to the SpeedPile. SpeedCards are of SpeedCardType. Cards will
   * always be inserted at the front of the list. Therefore, the order of insertion does matter.
   * Always need to know what card is on top. Cards will not be removed once inserted. Duplicate
   * cards are allowed to be inserted into the SpeedPile. Therefore, a Queue is the most appropriate
   * collection for the SpeedPile.
   *
   * @param card the SpeedCard to be added to the SpeedPile
   * @return {@code} true if the SpeedCard was successfully added to the SpeedPile.
   * @throws NullPointerException if the param is null
   */
  final boolean addToSpeedPile(SpeedCard card) {
    // should only contain SPEED_LIMT and END_LIMIT cards
    return speedPile.offerFirst(Objects.requireNonNull(card,
        "You cannot add a null value card to the Speed Pile"));
  }

  /**
   * Allows a BattleCard to be added to the BattlePile. A BattleCard is of types HazardCardType or
   * RemedyCardType. Cards are always inserted at the front of the List. Therefore, insertion order
   * is important. The game will always need to know what card is on top. Cards will not be removed.
   * Duplicate cards are allowed. Therefore, a LinkedList (Queue) is the most appropriate collection
   * for the BattlePile.
   *
   * @param card to be added to the BattlePile.
   * @return {@code true} if the BattleCard was successfully added to the BattlePile.
   * @throws NullPointerException if the param is null
   */
  final boolean addToBattlePile(BattleCard card) {
    // only ACCIDENT, OUT_OF_GAS, FLAT_TIRE, STOP, REPAIR, GASOLINE, SPARE_TIRE, and ROLL cards
    return battlePile.offerFirst(Objects.requireNonNull(card,
        "You can\'t add a null value card to the Battle Pile"));
  }

  /**
   * A Player isRolling if the top card in their BattlePile is a RemedyCardType.ROLL.
   *
   * @return {@code true} if BattlePile top card is a ROLL
   */
  final boolean isRolling() {
    if (battlePile.isEmpty()) {
      return false;
    } else {
      return getBattlePileTopCard().getType() == RemedyCardType.ROLL;
    }
  }

  /**
   * A Player hasHazard if the top card in their BattlePile is any card of type HazardCardType
   *
   * @return {@code true} if the BattlePile top card is of HazardCardType
   */
  final boolean hasHazard() {
    if (battlePile.isEmpty()) {
      return false;
    }
    Card topCard = getBattlePileTopCard();
    return topCard instanceof HazardCard;
  }

  /**
   * A player hasSpeedLimit if the top card in the SpeedPile is a SpeedCardType.SPEED_LIMIT
   *
   * @return {@code true} if the top card in the SpeedPile is a SPEED_LIMIT
   */
  final boolean hasSpeedLimit() {
    if (speedPile.isEmpty()) {
      return false;
    }
    return getSpeedPileTopCard().getType() == SpeedCardType.SPEED_LIMIT;
  }

  /**
   * Will return true if the SafetyPile contains the specified SafetyCard param
   *
   * @param type the type of card to check if it exists in the SafetyPile
   * @return {@code true} if the card exists in the SafetyPile
   * @throws NullPointerException if the param is null
   */
  final boolean safetyPileContains(SafetyCardType type) {
    Objects.requireNonNull(type,
        "You must pass a non null SafetyCardType to the safetyPileContains method");
    return safetyPile.stream().anyMatch(x -> x.getType().equals(type));
  }

  /**
   * Returns an ObservableList of cards in the DistancePile
   *
   * @return an ObservableList of cards in the DistancePile
   */
  final ObservableList<DistanceCard> getDistancePile() {
    return FXCollections.observableArrayList(distancePile);
  }

  /**
   * Returns an ObservableList of cards in the SafetyPile
   *
   * @return an ObservableList of cards in the SafetyPile
   */
  final ObservableList<SafetyCard> getSafetyPile() {
    return FXCollections.observableArrayList(safetyPile);
  }

  /**
   * Returns an ObservableList of cards in the SpeedPile
   *
   * @return an ObservableList of cards in the SpeedPile
   */
  final ObservableList<Card> getSpeedPile() {
    return FXCollections.observableArrayList(speedPile);
  }

  /**
   * Returns an ObservableList of cards in the BattlePile
   *
   * @return an ObservableList of cards in the BattlePile
   */
  final ObservableList<BattleCard> getBattlePile() {
    return FXCollections.observableArrayList(battlePile);
  }

  /**
   * Returns the count of all MILES_200 cards in the DistancePile
   *
   * @return the number of MILES_200 cards in the DistancePile
   */
  final int getPlayed200s() {
    return (int) distancePile.stream()
        .filter(x -> x.getType() == DistanceCardType.MILES_200)
        .count();
  }

  /**
   * Retrieves but does not remove the top card on the BattlePile
   *
   * @return the card on top of the BattlePile or {@code null} if it is empty
   */
  final Card getBattlePileTopCard() {
    return battlePile.peek();
  }

  /**
   * Retrieves but does not remove the top card in the SpeedPile
   *
   * @return the top card of the SpeedPile or {@code null} if it is empty
   */
  final Card getSpeedPileTopCard() {
    return speedPile.peek();
  }

  /**
   * Clears the BattlePile, SafetyPile, SpeedPile, and DistancePile. Sets totalMiles to 0. Used to
   * start a new game.
   */
  final void clear() {
    distancePile.clear();
    safetyPile.clear();
    speedPile.clear();
    battlePile.clear();
    setTotalMiles(0);
  }

  /**
   * Returns {@code true} if the speedPile is empty.
   * @return {@code true} if the speedPile is empty.
   */
  final boolean speedPileIsEmpty() {
    return speedPile.isEmpty();
  }

  /**
   * Returns true if the battlePile is empty.
   * @return {@code true} if the battlePile is empty.
   */
  final boolean battlePileIsEmpty() {
    return battlePile.isEmpty();
  }

}