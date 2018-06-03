package com.frijolie.streetrace.model.cards;

/**
 * SpeedCardType is an enumeration of all possible values of a SpeedCard.
 * <p>
 * SpeedCards are of type SpeedCardType and may only be played in a players SpeedPile. When a player
 * has a SPEED_LIMIT card on top of their SpeedPile they may only play a MILES_25 or MILES_50
 * SpeedCard in their SpeedPile. This continues until the player is able to play an END_LIMIT card
 * to reverse the SPEED_LIMIT. A RIGHT_OF_WAY SafetyCard will prevent a player from receiving a
 * SPEED_LIMIT card.
 *
 * @author Frijolie
 * @version 0.1
 * @see SpeedCard
 * @see SafetyCard
 * @since 0.1
 */
public enum SpeedCardType implements CardType {

  /**
   * This card prevents a player from playing cards other than MILES_25 or MILES_50.
   */
  SPEED_LIMIT(0,"Speed Limit"),
  /**
   * This card will reverse a SPEED_LIMIT card.
   */
  END_LIMIT(0,"End Limit");

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
   * @param value of the constant.
   */
  SpeedCardType(int value,String name) {
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