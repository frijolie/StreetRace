package com.frijolie.streetrace.model;

import com.frijolie.streetrace.model.cards.BattleCard;
import com.frijolie.streetrace.model.cards.Card;
import com.frijolie.streetrace.model.cards.CardType;
import com.frijolie.streetrace.model.cards.DistanceCard;
import com.frijolie.streetrace.model.cards.DistanceCardType;
import com.frijolie.streetrace.model.cards.HazardCard;
import com.frijolie.streetrace.model.cards.HazardCardType;
import com.frijolie.streetrace.model.cards.RemedyCard;
import com.frijolie.streetrace.model.cards.RemedyCardType;
import com.frijolie.streetrace.model.cards.SafetyCard;
import com.frijolie.streetrace.model.cards.SafetyCardType;
import com.frijolie.streetrace.model.cards.SpeedCard;
import com.frijolie.streetrace.model.cards.SpeedCardType;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * StreetRaceGame is the model class used to moderate the StreetRace game.
 * <p>
 * This class knows about the players, the cards in the players hand, game conditions, and where a
 * card is on a player Tableau. This class implements StreetRaceGameRules as there are constants
 * that are used during game play.
 *
 * @author Frijolie
 * @version 0.1
 * @see Player
 * @see Hand
 * @see Tableau
 * @see Deck
 * @see CardLocation
 * @since 0.1
 */
public class StreetRaceGame implements StreetRaceGameRules {

  /**
   * A reference to the (human) player in the game.
   */
  private final Player player;
  /**
   * A reference to the computer player in the game.
   */
  private final Player computer;
  /**
   * The Tableau for the (human) player.
   */
  private final Tableau playerTableau;
  /**
   * The Tableau for the computer player
   */
  private final Tableau computerTableau;
  /**
   * A list of cards that contains all the cards the players did not wish to play
   */
  private final LinkedList<Card> discardPile;
  /**
   * A list of cards from where the cards are dealt or drawn
   */
  private final LinkedList<Card> drawPile;
  /**
   * A reference to the deck which contains all possible cards
   */
  private final Deck deck;
  /**
   * A List of all cards in the players Hand
   */
  private final Hand playerHand;
  /**
   * A List of all cards in the computers Hand
   */
  private final Hand computerHand;
  /**
   * A list of all the cards in the player Hand
   */
  private final List<Card> playerCards;
  /**
   * A List of all the cards in the computer Hand
   */
  private final List<Card> computerCards;
  /**
   * A Map which contains all places a specific card can be placed during a single turn
   */
  private Map<Card, CardLocation> moves;
  /**
   * The total number of miles the player has traveled.
   */
  private int playerTotalMiles = 0;
  /**
   * The total number of miles the computer has traveled.
   */
  private int computerTotalMiles = 0;
  /**
   * A marking of the location of the card on the Tableau.
   */
  private CardLocation location;

  /**
   * Constructor.
   */
  public StreetRaceGame() {
    moves = new HashMap<>();
    player = new Player();
    computer = new Player("Computer");
    playerTableau = player.getTableau();
    computerTableau = computer.getTableau();
    playerHand = player.getHand();
    computerHand = computer.getHand();
    playerCards = playerHand.getCards();
    computerCards = computerHand.getCards();
    player.setOpponentsTableau(computerTableau);
    computer.setOpponentsTableau(playerTableau);
    discardPile = new LinkedList<>();
    deck = new Deck();
    drawPile = new LinkedList<>();
  }

  /**
   * Gets all cards from the deck. Adds them to the drawPile. Deals the cards.
   */
  public final void startGame() {
    drawPile.addAll(deck.getCards());
    dealCards();
  }

  /**
   * Deals seven cards to the player and computer Hand.
   */
  private void dealCards() {
    for (int i = 0; i < 7; i++) {
      playerHand.addCard(drawPile.removeFirst());
      computerHand.addCard(drawPile.removeFirst());
    }
  }

  /**
   * Resets all game conditions. Used to play another game.
   */
  final void reset() {
    moves.clear();
    discardPile.clear();
    computerTableau.clear();
    playerTableau.clear();
    drawPile.clear();
    deck.reset();
    playerCards.clear();
    computerCards.clear();
  }

  /**
   * Adds a card to the discardPile.
   *
   * @param card to discard
   * @throws NullPointerException if the param is null
   */
  final void addToDiscardPile(Card card) {
    discardPile.add(Objects.requireNonNull(card, "You cannot discard a null card."));
  }

  /**
   * Returns true if the drawPile is empty
   *
   * @return {@code true} if the drawPile is empty
   */
  final boolean drawPileEmpty() {
    return drawPile.isEmpty();
  }

  /**
   * Calculates possible moves based on a player and specific card.
   * @param player to be evaluated
   * @param card to be evaluated
   * @throws NullPointerException when player param is null
   * @throws NullPointerException when card param is null
   */
  private void calculatePossibleMoves(Player player, Card card) {
    Objects.requireNonNull(player,
        "You cannot pass a null player param to calculatePossibleMoves.");
    Objects.requireNonNull(card,
        "You cannot pass a null card param to calculatePossibleMoves.");
    if (card instanceof DistanceCard) {
      calculateValidDistanceCardMoves(player, card);
    } else if (card instanceof SpeedCard) {
      calculateValidSpeedCardMoves(player, card);
    } else if (card instanceof SafetyCard) {
      // TODO add SafetyCard moves, they can always be played.
    } else if (card instanceof BattleCard) {
      calculateValidBattleCardMoves(player, card);
    }
  }

  /**
   * Determines all possible moves based on the Player and Card params. Populates a Map with
   * potential moves. Intention is to pass a player and a DistanceCard to be checked.
   *
   * @param player to be evaluated
   * @param card to be evaluated
   * @throws NullPointerException if the player param is null
   * @throws NullPointerException if the card param is null
   */
  private void calculateValidDistanceCardMoves(Player player, Card card) {
    Objects.requireNonNull(player,
        "The player param in checkValidDistanceCardMoves must not be null.");
    Objects.requireNonNull(card,
        "The card param in checkValidDistanceCardMoves must not be null.");
    CardType type = card.getType();
    var isHumanPlayer = player.getName().equals("Player");
    // Roll on top of player BattlePile
    if (player.getTableau().isRolling()) {
      // will playing this card be less than or equal to the MILE_LIMIT?
      if (player.getTableau().getTotalMiles() + type.getValue() <= MILE_LIMIT) {
        // does the player have a SPEED LIMIT?
        if (player.getTableau().hasSpeedLimit()) {
          // player has speed limit, can only play miles_25 and miles_50 cards
          if (type == DistanceCardType.MILES_25 || type == DistanceCardType.MILES_50) {
            if (isHumanPlayer) {
              // is human player, can only play distance cards on PlayerDistancePile
              moves.put(card, CardLocation.PLAYER_DISTANCE_PILE);
            } else {
              // is computer player, can only play distance cards on ComputerDistancePile
              moves.put(card, CardLocation.COMPUTER_DISTANCE_PILE);
            }
          }
        } else {
          // does not have speed limit, will not exceed MILE LIMIT, can play any distance card
          if (isHumanPlayer) {
            moves.put(card, CardLocation.PLAYER_DISTANCE_PILE);
          } else {
            moves.put(card, CardLocation.COMPUTER_DISTANCE_PILE);
          }
        }
      }
    }
  }

  /**
   * Determines all possible moves based on the Player and Card params. Populates a Map with
   * potential moves. Intention is to pass a player and a SpeedCard to be checked.
   *
   * @param player the player who is attempting to play a card
   * @param card the card being checked
   * @throws NullPointerException if the player param is null
   * @throws NullPointerException if the card param is null
   */
  private void calculateValidSpeedCardMoves(Player player, Card card) {
    Objects.requireNonNull(player,
        "The player param in checkValidSpeedCardMoves must not be null.");
    Objects.requireNonNull(card,
        "The card param in checkValidSpeedCardMoves must not be null.");

    CardType type = card.getType();
    var isHumanPlayer = player.getName().equals("Player");

    if (type == SpeedCardType.SPEED_LIMIT) {
      if (player.getOpponentTableau().getSpeedPileTopCard().getType() == SpeedCardType.END_LIMIT ||
          player.getOpponentTableau().speedPileIsEmpty()) {
        if (isHumanPlayer) {
          moves.put(card, CardLocation.COMPUTER_SPEED_PILE);
        } else {
          moves.put(card, CardLocation.PLAYER_SPEED_PILE);
        }
      }
    } else if (type == SpeedCardType.END_LIMIT) {
      if (player.getTableau().getSpeedPileTopCard().getType() == SpeedCardType.SPEED_LIMIT) {
        if (isHumanPlayer) {
          moves.put(card, CardLocation.PLAYER_SPEED_PILE);
        } else {
          moves.put(card, CardLocation.COMPUTER_SPEED_PILE);
        }
      }
    }
  }

  /**
   * Determines all possible moves based on the Player and Card params. Populates a Map with
   * potential moves. Intention is to pass a player and a Hazard or RemedyCard to be checked.
   *
   * @param player the player who is attempting to play a card
   * @param card the card being checked
   * @throws NullPointerException if the player param is null
   * @throws NullPointerException if the card param is null
   */
  private void calculateValidBattleCardMoves(Player player, Card card) {
    Objects.requireNonNull(player,
        "The player param in checkValidSpeedCardMoves must not be null.");
    Objects.requireNonNull(card,
        "The card param in checkValidSpeedCardMoves must not be null.");

    CardType type = card.getType();
    var isHumanPlayer = player.getName().equals("Player");

    if (card instanceof HazardCard) {
      if (!player.getOpponentTableau().battlePileIsEmpty()) {
        if (type == HazardCardType.ACCIDENT) {
          if (!player.getOpponentTableau().safetyPileContains(SafetyCardType.DRIVING_ACE)) {
            if (isHumanPlayer) {
              moves.put(card, CardLocation.COMPUTER_BATTLE_PILE);
            } else {
              moves.put(card, CardLocation.PLAYER_BATTLE_PILE);
            }
          }
        } else if (type == HazardCardType.FLAT_TIRE) {
          if (!player.getOpponentTableau().safetyPileContains(SafetyCardType.PUNCTURE_PROOF)) {
            if (isHumanPlayer) {
              moves.put(card, CardLocation.COMPUTER_BATTLE_PILE);
            } else {
              moves.put(card, CardLocation.PLAYER_BATTLE_PILE);
            }
          }
        } else if (type == HazardCardType.OUT_OF_GAS) {
          if (!player.getOpponentTableau().safetyPileContains(SafetyCardType.EXTRA_TANK)) {
            if (isHumanPlayer) {
              moves.put(card, CardLocation.COMPUTER_BATTLE_PILE);
            } else {
              moves.put(card, CardLocation.PLAYER_BATTLE_PILE);
            }
          }
        } else if (card.getType() == HazardCardType.STOP) {
          if (!player.getOpponentTableau().safetyPileContains(SafetyCardType.RIGHT_OF_WAY)) {
            if (isHumanPlayer) {
              moves.put(card, CardLocation.COMPUTER_BATTLE_PILE);
            } else {
              moves.put(card, CardLocation.PLAYER_BATTLE_PILE);
            }
          }
        }
      }
    } else if (card instanceof RemedyCard) {
      if (!player.getTableau().battlePileIsEmpty()) {
        if (type == RemedyCardType.GASOLINE) {
          if (player.getTableau().getBattlePileTopCard().getType() == HazardCardType.OUT_OF_GAS) {
            if (isHumanPlayer) {
              moves.put(card, CardLocation.PLAYER_BATTLE_PILE);
            } else {
              moves.put(card, CardLocation.COMPUTER_BATTLE_PILE);
            }
          }
        } else if (type == RemedyCardType.REPAIR) {
          if (player.getTableau().getBattlePileTopCard().getType() == HazardCardType.ACCIDENT) {
            if (isHumanPlayer) {
              moves.put(card, CardLocation.PLAYER_BATTLE_PILE);
            } else {
              moves.put(card, CardLocation.COMPUTER_BATTLE_PILE);
            }
          }
        } else if (type == RemedyCardType.ROLL) {
          if (player.getTableau().getBattlePileTopCard() instanceof RemedyCard ||
              player.getTableau().getBattlePileTopCard().getType() == HazardCardType.STOP ||
              player.getTableau().battlePileIsEmpty()) {
            if (isHumanPlayer) {
              moves.put(card, CardLocation.PLAYER_BATTLE_PILE);
            } else {
              moves.put(card, CardLocation.COMPUTER_BATTLE_PILE);
            }
          }
        } else if (type == RemedyCardType.SPARE_TIRE) {
          if (player.getTableau().getBattlePileTopCard().getType() == HazardCardType.FLAT_TIRE) {
            if (isHumanPlayer) {
              moves.put(card, CardLocation.PLAYER_BATTLE_PILE);
            } else {
              moves.put(card, CardLocation.COMPUTER_BATTLE_PILE);
            }
          }
        }
      }
    }
  }

  /**
   * Returns {@code true} if the card the player is attempting to play at the specified CardLocation
   * is valid. This method does not care about business rules, only cares about the player and
   * CardType at the destination.
   *
   * @param player whom is attempting to make the move
   * @param card which is moving
   * @param destination of where the card would like to move
   * @return {@code true} if the player can play this card at that location
   * @throws NullPointerException if the player param is null
   * @throws NullPointerException if the card param is null
   * @throws NullPointerException if the destination param is null
   */
  final boolean canMoveHere(Player player, Card card, CardLocation destination) {
    Objects.requireNonNull(card,
        "You must pass a non null card reference in CanMoveHere.");
    Objects.requireNonNull(destination,
        "You must pass a non null destination in canMoveHere");
    Objects.requireNonNull(player,
        "You must pass a non null player in canMoveHere");

    if (player == computer) {
      if (card instanceof DistanceCard) {
        return destination == CardLocation.COMPUTER_DISTANCE_PILE;
      } else if (card instanceof SpeedCard) {
        if (card.getType() == SpeedCardType.END_LIMIT) {
          // end limit cards are played on your speed pile
          return destination == CardLocation.COMPUTER_SPEED_PILE;
        } else if (card.getType() == SpeedCardType.SPEED_LIMIT) {
          // speed limit cards are played on your opponents speed pile
          return destination == CardLocation.PLAYER_SPEED_PILE;
        }
      } else if (card instanceof RemedyCard) {
        // remedy cards are played on your tableau
        return destination == CardLocation.COMPUTER_BATTLE_PILE;
      } else if (card instanceof HazardCard) {
        // hazard cards are played on your opponents tableau
        return destination == CardLocation.PLAYER_BATTLE_PILE;
      } else if (card instanceof SafetyCard) {
        return destination == CardLocation.COMPUTER_SAFETY_PILE;
      } else if (destination == CardLocation.DRAW_PILE) {
        return false;
      } else if (destination == CardLocation.DISCARD_PILE) {
        return true;
      } else if (destination == CardLocation.COMPUTER_HAND) {
        return false;
      }
    } else if (player == this.player) {
      if (card instanceof DistanceCard) {
        return destination == CardLocation.PLAYER_DISTANCE_PILE;
      } else if (card instanceof SpeedCard) {
        if (card.getType() == SpeedCardType.END_LIMIT) {
          // end limit cards are played on your speed pile
          return destination == CardLocation.PLAYER_SPEED_PILE;
        } else if (card.getType() == SpeedCardType.SPEED_LIMIT) {
          // speed limit cards are played on your opponents speed pile
          return destination == CardLocation.COMPUTER_SPEED_PILE;
        }
      } else if (card instanceof RemedyCard) {
        // remedy cards are played on your tableau
        return destination == CardLocation.PLAYER_BATTLE_PILE;
      } else if (card instanceof HazardCard) {
        // hazard cards are played on your opponents tableau
        return destination == CardLocation.COMPUTER_BATTLE_PILE;
      } else if (card instanceof SafetyCard) {
        return destination == CardLocation.COMPUTER_SAFETY_PILE;
      } else if (destination == CardLocation.DRAW_PILE) {
        return false;
      } else if (destination == CardLocation.DISCARD_PILE) {
        return true;
      } else if (destination == CardLocation.PLAYER_HAND) {
        return false;
      }
    }
    // don't know how this could ever be reached...
    // the IDE is complaining so here it is...
    System.err.println("Player must be equal to neither \'computer\' or \'player\'");
    return false;
  }

  /**
   * Returns a Map with all possible moves for a given card and player.
   *
   * @return a Map which contains all possible moves for a turn.
   */
  private Map<Card, CardLocation> getMoves() {
    return new HashMap<>(moves);
  }

  /**
   * Returns the sum of all miles traveled by the Player.
   *
   * @return an int value of the sum of the distance traveled by the player
   */
  final int getPlayerTotalMiles() {
    return playerTotalMiles;
  }

  /**
   * Returns the sum of all miles traveled by the Computer.
   *
   * @return an int value of the sum of the distance traveled by the computer.
   */
  final int getComputerTotalMiles() {
    return computerTotalMiles;
  }

  /**
   * Returns a reference to the Player player object.
   *
   * @return a reference to the player player object.
   */
  public final Player getPlayer() {
    return player;
  }

  /**
   * Returns a reference to the Computer player object.
   *
   * @return a reference to the computer player object.
   */
  public final Player getComputer() {
    return computer;
  }

  /**
   * Returns a reference to the player tableau object.
   *
   * @return a reference to the player tableau object.
   */
  final Tableau getPlayerTableau() {
    return playerTableau;
  }

  /**
   * Returns a reference to the computer tableau object.
   *
   * @return a reference to the computer tableau object.
   */
  final Tableau getComputerTableau() {
    return computerTableau;
  }

  /**
   * Returns an UnmodifiableList containing all cards in the DrawPile. Used for Unit Tests.
   *
   * @return an UnmodifiableList of cards in the DrawPile
   */
  final List<Card> getDrawPile() {
    return Collections.unmodifiableList(drawPile);
  }

  /**
   * Returns an UnmodifiableList of all cards in the DiscardPile. Used for Unit Tests.
   *
   * @return an UnmodifiableList of cards in the DiscardPile.
   */
  final List<Card> getDiscardPile() {
    return Collections.unmodifiableList(discardPile);
  }

  /**
   * Returns a reference to the Deck object.
   *
   * @return a Deck reference.
   */
  final Deck getDeck() {
    return deck;
  }

  /**
   * Returns a reference to the player's Hand object.
   *
   * @return reference to the player Hand object.
   */
  final Hand getPlayerHand() {
    return playerHand;
  }

  /**
   * Returns a reference to the computer's Hand object
   *
   * @return the computer Hand object reference.
   */
  final Hand getComputerHand() {
    return computerHand;
  }

}