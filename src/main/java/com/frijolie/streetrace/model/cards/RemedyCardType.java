package com.frijolie.streetrace.model.cards;

/**
 * RemedyCardType is an enumeration of all possible values for a RemedyCard.
 * <p>
 * These cards are played in a players BattlePile. When the top card in a player's BattlePile is a
 * HazardCard, play is stopped until that player can play a RemedyCard to reverse the hazard. A
 * player may have a SafetyCard which prevents certain types of HazardCards from being played on
 * their BattlePile so these types of cards may lose their usefulness in the game.
 *
 * @author Frijolie
 * @version 0.1
 * @see HazardCard
 * @see RemedyCard
 * @since 0.1
 */
public enum RemedyCardType implements CardType {

  /**
   * This card reverses an ACCIDENT HazardCard.
   */
  REPAIR(0,"Repair"),
  /**
   * This card reverses an OUT_OF_GAS HazardCard.
   */
  GASOLINE(0,"Gasoline"),
  /**
   * This card reverses a FLAT_TIRE HazardCard.
   */
  SPARE_TIRE(0,"Spare Tire"),
  /**
   * This card reverses a STOP HazardCard.
   */
  ROLL(0,"Roll");

  /**
   * The point value of the constant.
   */
  private final int value;

  /**
   * A string representation of the constant.
   */
  private final String name;

  /**
   * Constructor.
   *
   * @param value of the constant
   */
  RemedyCardType(int value, String name) {
    this.value = value;
    this.name = name;
  }

  @Override
  public int getValue() {
    return value;
  }

  @Override
  public String getName() {
    return name;
  }

}