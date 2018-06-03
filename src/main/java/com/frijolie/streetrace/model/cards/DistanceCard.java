package com.frijolie.streetrace.model.cards;

import java.util.Objects;

/**
 * DistanceCard is a concrete class used to represent cards that are of DistanceCardType.
 * <p>
 * DistanceCards represent mileage a player has traveled along the racetrack in the game of
 * StreetRace. The game ends once the Mile Limit has been reached. DistanceCards can only be placed
 * in the player's Distance Pile. DistanceCards can only be played when the top card of the
 * BattlePile is a ROLL card. Only two MILES_200 cards can be played in the Distance Pile per
 * player.
 * <p>
 * Valid values for a DistanceCard are:
 * <ol>
 * <li>MILES_25</li>
 * <li>MILES_50</li>
 * <li>MILES_75</li>
 * <li>MILES_100</li>
 * <li>MILES_200</li>
 * </ol>
 *
 * @author Frijolie
 * @version 0.1
 * @see CardType
 * @see DistanceCardType
 * @since 0.1
 */
public class DistanceCard implements Card {

  /**
   * The CardType of a DistanceCard
   */
  private final DistanceCardType type;

  /**
   * Constructor.
   *
   * @param type the CardType of this DistanceCard.
   * @throws NullPointerException if the type is null
   */
  public DistanceCard(DistanceCardType type) {
    this.type = Objects.requireNonNull(type,
        "You must pass a non-null type reference to instantiate a DistanceCard.");
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

    DistanceCard that = (DistanceCard) o;

    return getType() == that.getType();
  }

  @Override
  public int hashCode() {
    return getType() != null ? getType().hashCode() : 0;
  }

}