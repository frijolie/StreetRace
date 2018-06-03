<img src="http://www.clipartlord.com/wp-content/uploads/2013/08/race-car2.png" height="50" width="150">

# Street Race

Street Race is a card game which simulates a race between two players along the city streets. Street Race is implemented in Java 8 SE and is modeled after the the French card game Mille Bornes (pronounced MEEL BORN).

## History
Mille Bornes means "a thousand kilometer-stones" (milestones) in French. Along many roadways in Europe, especially in France, there are small cement markers which provide useful information to travelers. These *bornes kilometriques* display the number of the current route as well as the distance to the next town.

## Objective
You and your opponent are in a race to reach the finish line. Once the race begins you have to obey the laws on the road. You may only proceed when the light is green. You must stop when the light is red. You must obey the speed limit signs. If you receive a flat tire, you must replace it with a spare. If you run out of gas, you must fill your tank with gasoline. If you are in an accident, you must repair your car. Stop your opponent from winning the race by placing hazards on their path while defending against hazards of your own. The first player to reach the milestone limit, wins the game!

## Rules of the Road
To begin your turn you draw a card. Then you must either play a card in a pile or, if nothing can be played, discard a card. Play then moves to your opponent. Distance, or mileage, cards can only be played as long as you have a green light, or Roll card, in your Battle Pile. If you have a Roll card and a Speed Limit, you cannot go further than 50 miles on your turn. This is until an End Limit card is played to override the Speed Limit. If your opponent has played any Hazard card (i.e. Accident, Out of Gas, Flat Tire, or Stop) on your Battle Pile, you cannot proceed until the corresponding Remedy card (i.e. Repair, Gasoline, Spare Tire, or Roll) has been played. For example, if you receive an Accident card you must first play a Repair card to remedy the accident status. Then, you must play a Roll card  to restart your engine and resume the race. The Roll card is your green light to begin playing additional Distance cards. Play goes back and forth until a player has reached the agreed upon mile limitation at the start of the race. To win successfully, you must exactly match the mile limitation in Distance cards without going over the limit.

## The Tableau
The Tableau is our playing field. All piles of cards are displayed for all to see face-up on the Tableau. When a card is played, it is placed in a pile. Under most circumstances, only the top card is displayed in the pile, with the exception of the distance cards. Here's an example of a Tableau.

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/11/MB-tableau1.svg/250px-MB-tableau1.svg.png">

## The Piles
### Safety Pile
The Safety Pile is displayed along the top of the Tableau. It can only contain the following cards: Right of Way, Extra Tank, Driving Ace, and Puncture Proof. These safety cards prevent a specific type of hazard from being played on your tableau. They also can be played as a Remedy card to resolve the specific hazard type that they defend against. Whenever a safety card is played, you immediately draw another card and take another turn. Each safety card is displayed distinctly on the Tableau.

If you possess the safety card when the opponent plays the Hazard for which the safety prevents, you can immediately play the card and score 300 bonus points. This is called a *coup-fourré* (pronounced COO-FOR-RAY). 

### Distance Pile
The Distance Pile is displayed below the Safety Pile on the left-hand side of the Tableau. It can only contain the following cards: 25 Miles, 50 Miles, 75 Miles, 100 Miles, and 200 Miles. Each distance card is grouped and stacked when displayed on the tableau. The distance cards are summed and the total is displayed.

Note: Each player may only play two 200 Miles cards per game. Also, a 200 Miles Distance Card may be played in place of a Roll card to begin or resume the race.

### Battle Pile
The Battle Pile is where all of the action occurs. The battle pile is displayed on the right-hand side of the Tableau. Hazard and Remedy cards are placed here and only the top card is displayed. Valid cards in the Battle Pile are: Accident, Flat Tire, Out of Gas, Stop, Repair, Spare Tire, Gasoline, and Roll. You may only play a distance card if the top card in your battle pile is a Roll.

### Speed Pile
The Speed Pile determines how far you may travel during a turn. Speed Limit and End Limit cards are placed in the Speed Pile on the Tableau. The Speed Pile is below the Battle Pile on the right-hand side of the Tableau. Only the top card of the speed pile is ever visible. If a Speed Limit card is on top, you may only play a 25 or 50 Miles card until an End Limit card has been played. However, a Speed Limit card can be played on your opponent even if they do not have a green light.

## Scoring
At the end of the game, score for both players is tallied. Sore is determined as follows:
<table>
<tr><th colspan="2">Scoring</th></tr>
<tr><td>Milestones</td><td>1pt/mile</td></tr>
<tr><td>Safeties</td><td>100 pts</td></tr>
<tr><td>Coup-fourrés</td><td>300 pts</td></tr>
<tr><td>Trip Completed (win)</td><td>400 pts</td></tr>
<tr><td>Delayed Action (win after draw pile is empty)</td><td>300 pts</td></tr>
<tr><td>Safe Trip (No 200 Miles were played)</td><td>300 pts</td></tr>
<tr><td>Shut Out (Opponent has 0 miles)</td><td>500 pts</td></tr>
<tr><td>All four safety cards are played</td><td>300 pts</td></tr>
</table>
