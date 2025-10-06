package club.nullbyte3.facade;

public class Main {
    public static void main(String[] args) {
        ApiFacade apiFacade = new ApiFacade();

        try {
            String jokeUrl = "https://api.chucknorris.io/jokes/random";
            String joke = apiFacade.getAttributeValueFromJson(jokeUrl, "value");
            System.out.println(joke);
        } catch (Exception e) {
            throw new RuntimeException("error fetching1: " + e.getMessage());
        }

        try {
            String ratesUrl = "https://api.fxratesapi.com/latest";
            String date = apiFacade.getAttributeValueFromJson(ratesUrl, "date");
            System.out.println("fx rate date: " + date);
        } catch (Exception e) {
            throw new RuntimeException("error fetching2: " + e.getMessage());
        }

        try {
            String jokeUrl = "https://api.chucknorris.io/jokes/random";
            apiFacade.getAttributeValueFromJson(jokeUrl, "non_existent_attribute");
        } catch (Exception e) {
            System.err.println("Non-existent attribute example: " + e.getClass().getName());
        }
    }
}
