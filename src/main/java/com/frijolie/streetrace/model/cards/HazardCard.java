package com.frijolie.streetrace.model.cards;

import java.util.Objects;

/**
 * HazardCard is a concrete class used to model cards that enact a hazard on an opponent.
 * <p>
 * HazardCard is of a {@link HazardCardType} and can only be placed in an opponents BattlePile on
 * the {@link com.frijolie.streetrace.model.Tableau}. If the top card of a player's BattlePile is a
 * HazardCard, play is stopped until they are able to play the corresponding {@link RemedyCard} to
 * reverse the hazard.
 * <p>
 * Valid HazardCards are:
 * <ul>
 * <li>Accident</li>
 * <li>Out of Gas</li>
 * <li>Flat Tire</li>
 * <li>Stop</li>
 * </ul>
 *
 * @author Frijolie
 * @version 0.1
 * @see HazardCardType
 * @see RemedyCard
 * @see com.frijolie.streetrace.model.Tableau
 * @since 0.1
 */
public class HazardCard extends BattleCard implements Card {

  /**
   * The type for a HazardCard
   */
  private final HazardCardType type;

  /**
   * Constructor.
   *
   * @param type of Card must be HazardCardType
   */
  public HazardCard(HazardCardType type) {
    this.type = Objects.requireNonNull(type,
        "You must pass a non-null type reference to instantiate a HazardCard.");
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

    HazardCard that = (HazardCard) o;

    return getType() == that.getType();
  }

  @Override
  public int hashCode() {
    return getType().hashCode();
  }
}