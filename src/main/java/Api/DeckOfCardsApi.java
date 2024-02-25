package Api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.get;

public class DeckOfCardsApi {
    private static String baseUrl = "https://deckofcardsapi.com/api/";

    private static Response response;

    public static String getShuffleCards() {
        response = get(baseUrl + "deck/new/shuffle/?deck_count=1");
        return response.jsonPath().get("deck_id");
    }

    public static void getDrawCards(String deckId, Integer cardCount) {
        response = get(baseUrl + "deck/" + deckId + "/draw/?count=" + cardCount);
    }

    public static String getPartialDeck(String cards) {
        response = get(baseUrl + "deck/new/shuffle/?cards=" + cards);
        return response.jsonPath().get("deck_id");
    }

    public static Response getResponse() {
        return response;
    }
}
