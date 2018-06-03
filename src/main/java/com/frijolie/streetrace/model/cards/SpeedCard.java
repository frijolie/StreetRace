package com.frijolie.streetrace.model.cards;

import java.util.Objects;

/**
 * SpeedCard is a concrete class used to represent cards of type SpeedCardType.
 * <p>
 * A SpeedCard can only be played in a players SpeedPile. When a SPEED_LIMIT HazardCard is on top of
 * a players SpeedPile, the player may only play MILES_25 and MILES_50 DistanceCards in their
 * DistancePile. Play is not stopped. Play continues until a player is able to play an END_LIMIT
 * SpeedCard to reverse the SPEED_LIMIT. A RIGHT_OF_WAY SafetyCard will prevent an END_LIMIT from
 * being played in a players SpeedPile.
 *
 * @author Frijolie
 * @version 0.1
 * @see SpeedCardType
 * @see SafetyCard
 * @since 0.1
 */
public class SpeedCard implements Card {

  /**
   * The type of SpeedCard
   */
  private final SpeedCardType type;

  /**
   * Constructor.
   *
   * @param type of SpeedCard
   */
  public SpeedCard(SpeedCardType type) {
    this.type = Objects.requireNonNull(type,
        "You must pass a non-null type reference to instantiate a SpeedCard.");
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

    SpeedCard speedCard = (SpeedCard) o;

    return getType() == speedCard.getType();
  }

  @Override
  public int hashCode() {
    return getType().hashCode();
  }

}