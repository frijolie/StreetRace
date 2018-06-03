package com.frijolie.streetrace.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.frijolie.streetrace.model.cards.BattleCard;
import com.frijolie.streetrace.model.cards.Card;
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
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StreetRaceGameTest {

  StreetRaceGame game;

  Player player;

  Player computer;

  Hand playerHand;

  Hand computerHand;

  Tableau playerTableau;

  Tableau computerTableau;

  Deck deck;

  List<Card> drawPile;

  List<Card> discardPile;

  List<Card> playerSpeedPile;

  List<Card> computerSpeedPile;

  @BeforeEach
  public void setUp() {
    game = new StreetRaceGame();
    player = game.getPlayer();
    computer = game.getComputer();
    playerHand = game.getPlayerHand();
    computerHand = game.getComputerHand();
    playerTableau = game.getPlayerTableau();
    computerTableau = game.getComputerTableau();
    deck = game.getDeck();
    discardPile = game.getDiscardPile();
    drawPile = game.getDrawPile();
    playerSpeedPile = playerTableau.getSpeedPile();
    computerSpeedPile = computerTableau.getSpeedPile();
    //game.startGame();
  }

  @AfterEach
  public void tearDown() {
    game.reset();
    playerHand = null;
    computerHand = null;
    playerTableau.clear();
    computerTableau.clear();
    playerTableau = null;
    computerTableau = null;
    player = null;
    computer = null;
    deck = null;
    drawPile = null;
    discardPile = null;
  }

  @Test
  public void getInstance_ShouldNotBeNull() {
    assertNotNull(game, "game.getInstance() should not be null");
  }

  @Test
  public void constructor_PlayerHandShouldNotBeNull() {
    assertNotNull(playerHand, "playerHand should not be null");
  }

  @Test
  public void constructor_ComputerHandShouldNotBeNull() {
    assertNotNull(computerHand, "computerHand should not be null");
  }

  @Test
  public void constructor_DeckShouldNotBeNull() {
    assertNotNull(deck, "deck should not be null");
  }

  @Test
  public void constructor_PlayerTableauShouldNotBeNull() {
    assertNotNull(playerTableau, "playerTableau should not be null");
  }

  @Test
  public void constructor_ComputerTableauShouldNotBeNull() {
    assertNotNull(computerTableau, "computerTableau should not be null");
  }

  @Test
  public void constructor_DiscardPileShouldNotBeNull() {
    assertNotNull(discardPile, "discardPile should not be null");
  }

  @Test
  public void constructor_DrawPileNotNull() {
    assertNotNull(drawPile, "drawPile should not be null");
  }

  @Test
  public void startGame_DrawPileShouldContain106Cards() {
    game.startGame();
    assertEquals(92, drawPile.size(),
        "After creation and deal the drawPile should contain 92 cards. Instead it has: "
            + drawPile.size());
  }

  @Test
  public void constructor_PlayerOpponentTableauShouldNotBeNull() {
    assertNotNull(player.getOpponentTableau(),
        "Player opponent Tableau should not be null.");
  }

  @Test
  public void constructor_ComputerOpponentTableauShouldNotBeNull() {
    assertNotNull(computer.getOpponentTableau(),
        "Computer opponent Tableau should not be null.");
  }

  @Test
  public void constructor_PlayerOpponentTableauShouldEqualComputerTableau() {
    assertSame(player.getOpponentTableau(), computerTableau,
        "The player opponentTableau should equal computerTableau.");
  }

  @Test
  public void constructor_ComputerOpponentTableauEqualsPlayerTableau() {
    assertSame(computer.getOpponentTableau(), playerTableau,
        "The computer opponentTableau should equal playerTableau.");
  }

  @Test
  public void startGame_AfterStartingGameDeckShouldNotBeEmpty() {
    assertFalse(deck.getCards().isEmpty(),
        "When the game starts, the deck should not be empty");
  }

  @Test
  public void startGame_AfterDealingPlayerHandShouldNotBeEmpty() {
    game.startGame();
    assertFalse(playerHand.getCards().isEmpty(),
        "After dealing cards the players hand should not be empty.");
  }

  @Test
  public void startGame_AfterDealingComputerHandShouldNotBeEmpty() {
    game.startGame();
    assertFalse(computerHand.getCards().isEmpty(),
        "After dealing cards the computers hand should not be empty.");
  }

  @Test
  public void startGame_AfterDealingPlayerHandShouldContainSevenCards() {
    game.startGame();
    assertEquals(7, playerHand.getCards().size(),
        "After dealing the player should have seven cards in hand. Instead the player has "
            + playerHand.getCards().size());
  }

  @Test
  public void startGame_AfterDealingComputerHandShouldContainSevenCards() {
    game.startGame();
    assertEquals(7, computerHand.getCards().size(),
        "After dealing the computer should have 7 cards in hand. Instead the Computer has "
            + computerHand.getCards().size());
  }

  @Test
  public void startGame_AfterDealingDrawPileShouldNotBeEmpty() {
    game.startGame();
    assertFalse(game.drawPileEmpty(), "After dealing the drawPile should not be empty.");
  }

  @Test
  public void speedPileTopCard_SpeedPileTopCardSpeedLimit_isSame() {
    SpeedCard speedLimit = new SpeedCard(SpeedCardType.END_LIMIT);
    playerTableau.addToSpeedPile(speedLimit);
    assertSame(speedLimit, playerTableau.getSpeedPileTopCard(),
        "After adding a SPEED LIMIT card to the speedPile, it should be the top card.");
  }

  @Test
  public void battlePileTopCard_BattlePileTopCardStop_isSame() {
    BattleCard stop = new HazardCard(HazardCardType.STOP);
    playerTableau.addToBattlePile(stop);
    assertSame(playerTableau.getBattlePileTopCard(), stop,
        "After adding a STOP card to the battlePile, it should be the top card.");
  }

  @Test
  public void battlePileTopCard_BattlePileTopCardStop_notSame() {
    BattleCard stop = new HazardCard(HazardCardType.STOP);
    BattleCard outOfGas = new HazardCard(HazardCardType.OUT_OF_GAS);
    playerTableau.addToBattlePile(outOfGas);
    playerTableau.addToBattlePile(stop);
    assertNotSame(playerTableau.getBattlePileTopCard(), outOfGas,
        "The last card added was a STOP card, STOP should be the top card.");
  }

  @Test
  public void canMoveHere_ComputerDistanceCardCanMoveToComputerDistancePile_ShouldBeTrue() {
    DistanceCard miles25 = new DistanceCard(DistanceCardType.MILES_25);
    assertTrue(game.canMoveHere(computer, miles25, CardLocation.COMPUTER_DISTANCE_PILE),
        "Computer should be able to play a MILES_25 in COMPUTER_DISTANCE_PILE");
  }

  @Test
  public void canMoveHere_ComputerSpeedCardCanMoveToComputerSpeedPile_ShouldBeTrue() {
    SpeedCard endLimit = new SpeedCard(SpeedCardType.END_LIMIT);
    assertTrue(game.canMoveHere(computer, endLimit, CardLocation.COMPUTER_SPEED_PILE),
        "Computer should be able to play an END_LIMIT to the COMPUTER_SPEED_PILE");
  }

  @Test
  public void canMoveHere_ComputerSpeedLimitCardCanMoveToPlayerSpeedPile_ShouldBeTrue() {
    SpeedCard speedLimit = new SpeedCard(SpeedCardType.SPEED_LIMIT);
    assertTrue(game.canMoveHere(computer, speedLimit, CardLocation.PLAYER_SPEED_PILE));
  }

  @Test
  public void canMoveHere_ComputerRemedyCardCanMoveToComputerBattlePile_ShouldBeTrue() {
    RemedyCard repair = new RemedyCard(RemedyCardType.REPAIR);
    assertTrue(game.canMoveHere(computer, repair, CardLocation.COMPUTER_BATTLE_PILE));
  }

  @Test
  public void canMoveHere_ComputerHazardCardCanMoveToPlayerBattlePile_ShouldBeTrue() {
    HazardCard accident = new HazardCard(HazardCardType.ACCIDENT);
    assertTrue(game.canMoveHere(computer, accident, CardLocation.PLAYER_BATTLE_PILE));
  }

  @Test
  public void canMoveHere_ComputerHazardCardCanMoveToComputerBattlePile_ShouldBeFalse() {
    HazardCard accident = new HazardCard(HazardCardType.ACCIDENT);
    assertFalse(game.canMoveHere(computer, accident, CardLocation.COMPUTER_BATTLE_PILE));
  }

  @Test
  public void canMoveHere_ComputerSafetyCardCanMoveToComputerSafetyPile_ShouldBeTrue() {
    SafetyCard punctureProof = new SafetyCard(SafetyCardType.PUNCTURE_PROOF);
    assertTrue(game.canMoveHere(computer, punctureProof, CardLocation.COMPUTER_SAFETY_PILE));
  }

  @Test
  public void canMoveHere_ComputerAnyCardCanMoveToDrawPile_ShouldBeFalse() {
    SafetyCard punctureProof = new SafetyCard(SafetyCardType.PUNCTURE_PROOF);
    assertFalse(game.canMoveHere(computer, punctureProof, CardLocation.DRAW_PILE));
  }
}