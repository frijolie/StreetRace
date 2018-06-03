package com.frijolie.streetrace.model;

import java.util.Objects;

/**
 * Player is a concrete class used to represent a player in the game of StreetRace.
 * <p>
 * Each player will have a Hand to hold their cards, will play their cards on a Tableau, and will
 * need a reference to the opponents Tableau to play a HazardCard. They will also maintain a value
 * of distance to keep track of the mileage they have traveled. Once the MILE_LIMIT has been
 * reached, the game will be over.
 *
 * @author Frijolie
 * @version 0.1
 * @see com.frijolie.streetrace.model.cards.HazardCard
 * @see Hand
 * @see Tableau
 * @since 0.1
 */
public class Player {

  /**
   * Reference to the players Hand
   */
  private final Hand hand;

  /**
   * Name of the player.
   */
  private final String name;

  /**
   * Reference to the players Tableau
   */
  private final Tableau tableau;

  /**
   * Reference to the player opponents Tableau
   */
  private Tableau opponentTableau;

  /**
   * Constructor. Sets the player name as "Player"
   */
  public Player() {
    this("Player");
  }

  /**
   * Overloaded Constructor. Instantiates a Hand and Tableau Object.
   */
  public Player(String name) {
    hand = new Hand();
    tableau = new Tableau();
    this.name = name;
  }

  /**
   * Returns a reference to the Player Hand.
   *
   * @return a reference to the Player Hand.
   */
  public final Hand getHand() {
    return hand;
  }

  /**
   * Returns a reference to the player opponents Tableau
   *
   * @return a reference to the player opponents Tableau
   * @see Tableau
   */
  final Tableau getOpponentTableau() {
    return opponentTableau;
  }

  /**
   * Sets the reference to the player opponents Tableau
   *
   * @param tableau to set
   * @throws NullPointerException is the param is null
   */
  final void setOpponentsTableau(Tableau tableau) {
    opponentTableau = Objects.requireNonNull(tableau);
  }

  /**
   * Returns a reference to the player Tableau
   *
   * @return a reference to the player Tableau
   */
  final Tableau getTableau() {
    return tableau;
  }

  /**
   * Returns the player's name
   *
   * @return the player name
   */
  final String getName() {
    return name;
  }

}