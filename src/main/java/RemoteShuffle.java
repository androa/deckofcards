import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Key;

import java.io.IOException;

public class RemoteShuffle implements Shuffle {
  private String endpoint;

  static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
  static final JsonFactory JSON_FACTORY = new JacksonFactory();

  public static class RemoteCard extends GenericJson {
    @Key private String suit;
    @Key private String value;

    public String getSuite() {
      return suit;
    }

    public String getValue() {
      return value;
    }
  }

  public RemoteShuffle(String endpoint) {
    this.endpoint = endpoint;
  }

  public Deck shuffle (Deck deck) {
    RemoteCard[] cards = this.loadDataFromNetwork();

    for (RemoteCard card : cards) {
      deck.addCard(new Card(card.getSuite(), card.getValue()));
    }

    return deck;
  }

  private RemoteCard[] loadDataFromNetwork() {
    RemoteCard[] cards = null;

    try {
      HttpRequestFactory requestFactory = this.getHttpRequestFactory();
      GenericUrl url = new GenericUrl(this.endpoint);
      HttpRequest request = requestFactory.buildGetRequest(url);
      request.setParser(new JsonObjectParser(JSON_FACTORY));
      cards = request.execute().parseAs(RemoteCard[].class);
    } catch (IOException e) {
      System.out.println("Sorry, couldn't shuffle the deck for you, but you can have it back");
    }

    return cards;
  }

  private HttpRequestFactory getHttpRequestFactory() {
    return HTTP_TRANSPORT.createRequestFactory();
  }
}
