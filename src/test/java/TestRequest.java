
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;


public class TestRequest {

    @Test
    public void getListOfFlights() {

        // base uri
        RestAssured.baseURI = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices";

        Response response;
        String[] placeIds = new String[2];
        String[] localeExamples = new String[] { "/autosuggest/v1.0/DE/EUR/en-GB/?query=Frankfurt", "/autosuggest/v1.0/DE/EUR/en-GB/?query=London"};
        for(int i=0; i<localeExamples.length; i++)
        {
            System.out.println(localeExamples[i]);

            RequestSpecification httpRequest = RestAssured.given().header("x-rapidapi-key","a659416d69mshb0d9eaba28daa28p1ea282jsn96bf7025223c");

            response = httpRequest.request(Method.GET, localeExamples[i]);

            if(response.getStatusCode() == 200)
            {
                String responseBody = response.getBody().asString();
                System.out.println("Response: " + responseBody);
                JsonPath jsonPath = response.jsonPath();
                String placeid = jsonPath.get("Places[0].PlaceId");
                System.out.println(placeid);
                placeIds[i] = placeid;
            }

            if(response.getStatusCode() == 400)
            {
                System.out.println("You have placed Invalid Values, please try again.(BrowsePlaces)");

            }
        }
        String getqoutes = "/browsedates/v1.0/DE/EUR/en-GB/"+ placeIds[0] +"/"+ placeIds[1] +"/2020-07-20/2020-07-29";
        System.out.println(getqoutes);

        RequestSpecification httpRequest = RestAssured.given().header("x-rapidapi-key","a659416d69mshb0d9eaba28daa28p1ea282jsn96bf7025223c");

        response = httpRequest.request(Method.GET, getqoutes);

        if(response.getStatusCode() == 200){

        String responseBody = response.getBody().asString();
        System.out.println("Response: " + responseBody);
        JsonPath jsonPath = response.jsonPath();
        Double MinPrice = jsonPath.getDouble("Quotes[0].MinPrice");
        System.out.println(MinPrice);
        }

        if(response.getStatusCode() == 400)
        {
            System.out.println("You have placed Invalid Values, please try again.(BrowseDates)");

        }
    }
}
