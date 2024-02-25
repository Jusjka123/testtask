package steps;

import Api.DeckOfCardsApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DeckOfCards {
    private String deckId;

    @Given("User creates a deck")
    public void user_creates_a_deck() {
        deckId = DeckOfCardsApi.getShuffleCards();
    }

    @When("User draws {int} cards")
    public void user_draws_cards(Integer cardsCount) {
        DeckOfCardsApi.getDrawCards(deckId, cardsCount);
    }

    @Then("Remaining cards left {int}")
    public void remaining_cards_left(Integer remainingCards) {
        DeckOfCardsApi.getResponse().then().body("remaining", is(remainingCards));
    }

    @Given("User creates a deck containing cards")
    public void user_creates_a_deck_containing_cards(List<String> data) {
        deckId = DeckOfCardsApi.getPartialDeck(String.join(",", data));
    }

    @Then("Drawn cards are {string}")
    public void drawn_cards_are(String cards) {
        ArrayList<String> listOfCards = DeckOfCardsApi.getResponse().jsonPath().get("cards.value");
        for(String card: listOfCards) {
            assertThat("Incorrect card", card, is(cards));
        };
    }
}
