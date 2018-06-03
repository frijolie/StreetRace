package com.frijolie.streetrace.model;

/**
 * CardLocation is an enumeration which contains all the possible locations a card can be in game.
 * <p>
 *
 * @author Frijolie
 * @version 0.1
 * @since 0.1
 */
public enum CardLocation {
  /**
   * The card is in the player Hand.
   */
  PLAYER_HAND,
  /**
   * The card is in the players distance pile in the player tableau.
   */
  PLAYER_DISTANCE_PILE,
  /**
   * The card is in the players speed pile in the player tableau.
   */
  PLAYER_SPEED_PILE,
  /**
   * The card is in the players safety pile in the player tableau.
   */
  PLAYER_SAFETY_PILE,
  /**
   * The card is in the players battle pile in the player tableau.
   */
  PLAYER_BATTLE_PILE,
  /**
   * The card is in the computer Hand.
   */
  COMPUTER_HAND,
  /**
   * The card is in the computers distance pile in the computer tableau.
   */
  COMPUTER_DISTANCE_PILE,
  /**
   * The card is in the computers speed pile in the computer tableau.
   */
  COMPUTER_SPEED_PILE,
  /**
   * The card is in the computers safety pile in the computer tableau.
   */
  COMPUTER_SAFETY_PILE,
  /**
   * The card is in the computers battle pile in the computer tableau.
   */
  COMPUTER_BATTLE_PILE,
  /**
   * The card is in the draw pile and has not yet been dealt.
   */
  DRAW_PILE,
  /**
   * The card is in the discard pile and was discarded by a player.
   */
  DISCARD_PILE,
  /**
   * The card is in an unknown location. Intention was to use this as a fall through.
   */
  UNKNOWN
}