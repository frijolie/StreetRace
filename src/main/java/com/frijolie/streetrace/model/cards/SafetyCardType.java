package com.frijolie.streetrace.model.cards;

/**
 * SafetyCardType is an enumeration of all possible values of a SafetyCard.
 * <p>
 * A SafetyCard is of type SafetyCardType and can only be played in a players SafetyPile.
 * SafetyCards are highly sought after because they have the highest point values, a special
 * strategy, and will prevent certain HazardCards from being played in a players BattlePile. If a
 * player possesses a SafetyCard in their hand, not already played on the Tableau, when an opponent
 * plays a HazardCard for which the SafetyCard prevents, the player can declare a coup-fourré. This
 * awards the player an additional 300 points and the player can immediately take another turn.
 *
 * @author Frijolie
 * @version 0.1
 * @see SafetyCard
 * @see HazardCard
 * @since 0.1
 */
public enum SafetyCardType implements CardType {

  /**
   * This will prevent a player from receiving an ACCIDENT HazardCard
   */
  DRIVING_ACE(100,"Driving Ace"),
  /**
   * This will prevent a player from receiving an OUT_OF_GAS HazardCard.
   */
  EXTRA_TANK(100,"Extra Tank"),
  /**
   * This will prevent a player from receiving a FLAT_TIRE HazardCard.
   */
  PUNCTURE_PROOF(100,"Puncture Proof"),
  /**
   * This will prevent a player from receiving a STOP HazardCard or a SPEED_LIMIT SpeedCard.
   */
  RIGHT_OF_WAY(100,"Right of Way");

  /**
   * The point value of the constant.
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
  SafetyCardType(int value, String name) {
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