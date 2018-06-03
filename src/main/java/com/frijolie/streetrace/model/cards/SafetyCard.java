package com.frijolie.streetrace.model.cards;

import java.util.Objects;

/**
 * SafetyCard is a concrete class used to represent a card of type SafetyCardType.
 * <p>
 * A SafetyCard can only be played in the players SafetyPile. When a player has played a SafetyCard
 * this prevents certain types of HazardCards from being played in their BattlePile. There are only
 * four SafetyCards in the game so they are rare and have a high point value. SafetyCards also have
 * certain behavior and strategy. If a player has a SafetyCard in their hand, not on the Tableau,
 * and the opponent plays the HazardCard, which the SafetyCard in their possession prevents, the
 * player can declare a coup-fourré and play the SafetyCard. This disregards the Hazard and earns
 * the player 300 additional points.
 * <p>
 * Valid SafetyCards are:
 * <ul>
 * <li>PUNCTURE_PROOF</li>
 * <li>EXTRA_TANK</li>
 * <li>DRIVING_ACE</li>
 * <li>RIGHT_OF_WAY</li>
 * </ul>
 *
 * @author Frijolie
 * @version 0.1
 * @see SafetyCardType
 * @since 0.1
 */
public class SafetyCard implements Card {

  /**
   * The type of card
   */
  private final SafetyCardType type;

  /**
   * Constructor.
   *
   * @param type of SafetyCard
   */
  public SafetyCard(SafetyCardType type) {
    this.type = Objects.requireNonNull(type, "SafetyCardType cannot be null");
  }

  @Override
  public CardType getType() {
    return type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    SafetyCard that = (SafetyCard) o;

    return getType() == that.getType();
  }

  @Override
  public int hashCode() {
    return getType().hashCode();
  }
}