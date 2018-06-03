package com.frijolie.streetrace.model.cards;

import java.util.Objects;

/**
 * RemedyCard is a concrete class used to represent a card of type RemedyCardType.
 * <p>
 * RemedyCard is of type RemedyCardType and can only be placed in the players BattlePile on the
 * {@link com.frijolie.streetrace.model.Tableau}. A RemedyCard reverses the current hazard that has
 * been placed in a players BattlePile. Play is stopped until the hazard can be remedied.
 * <p>
 * Valid RemedyCards are:
 * <ul>
 * <li>SPARE_TIRE</li>
 * <li>GASOLINE</li>
 * <li>ROLL</li>
 * <li>REPAIR</li>
 * </ul>
 *
 * @author Frijolie
 * @version 0.1
 * @see CardType
 * @see RemedyCardType
 * @since 0.1
 */
public class RemedyCard extends BattleCard implements Card {

  /**
   * The CardType of a RemedyCard
   */
  private final RemedyCardType type;

  /**
   * Constructor.
   *
   * @param type of a RemedyCard
   */
  public RemedyCard(RemedyCardType type) {
    this.type = Objects.requireNonNull(type,
        "You must pass a non-null type reference to instantiate a RemedyCard.");
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

    RemedyCard that = (RemedyCard) o;

    return getType() == that.getType();
  }

  @Override
  public int hashCode() {
    return getType().hashCode();
  }
}