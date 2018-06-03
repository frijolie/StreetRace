package com.frijolie.streetrace.model.cards;

/**
 * HazardCardType is an enumeration of all possible values for a HazardCard.
 * <p>
 * These cards will be played on an opponents BattlePile. When a HazardCard is on top of a players
 * BattlePile, this will stop play until the player is able to play the corresponding RemedyCard to
 * reverse the hazard. An opponent may have a SafetyCard which will prevent certain types of hazards
 * from being played on the player.
 *
 * @author Frijolie
 * @version 0.1
 * @see HazardCard
 * @see RemedyCard
 * @since 0.1
 */
public enum HazardCardType implements CardType {

  /**
   * This symbolizes that the player has been in an accident. Play is stopped until a REPAIR has
   * been played. The SafetyCard DRIVING_ACE prevents a player from receiving an ACCIDENT card.
   */
  ACCIDENT(0,"ACCIDENT"),
  /**
   * This symbolizes that the player has run out of gas. Play is stopped until a GASOLINE card has
   * been played. The SafetyCard EXTRA_TANK prevents a player from receiving an OUT_OF_GAS card.
   */
  OUT_OF_GAS(0,"OUT_OF_GAS"),
  /**
   * This symbolizes that the player has received a flat tire. Play is stopped until a SPARE_TIRE
   * card has been played. The SafetyCard PUNCTURE_PROOF prevents a player from receiving a
   * FLAT_TIRE card.
   */
  FLAT_TIRE(0,"FLAT_TIRE"),
  /**
   * This symbolizes that the player has reached a stop sign. Play is stopped until a ROLL card has
   * been played. The SafetyCard RIGHT_OF_WAY prevents a player from receiving a STOP card.
   */
  STOP(0,"STOP");

  /**
   * The point value of the constant
   */
  private final int value;

  /**
   * A String representation of the constant.
   */
  private final String name;

  /**
   * Constructor.
   *
   * @param value of the constant
   */
  HazardCardType(int value, String name) {
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