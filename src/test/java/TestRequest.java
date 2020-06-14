import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.runner.Request;

public class TestRequest {
    @Test
    public void getListOfFlights()
    {
        // base uri
        RestAssured.baseURI = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/reference/v1.0/countries";

        // request object - initialisation
        RequestSpecification httpRequest = RestAssured.given().header("x-rapidapi-key","a659416d69mshb0d9eaba28daa28p1ea282jsn96bf7025223c");


        // resonse object
        //Response response = httpRequest.request(Method.GET, "/fr-FR");
//        Response res = RestAssured.given()
//                .header("x-rapidapi-key","a659416d69mshb0d9eaba28daa28p1ea282jsn96bf7025223c")
//                .when()
//                .get ("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/reference/v1.0/countries/en-US").then().
//                        extract().response();


        // print response
        Response response;
        String[] localeExamples = new String[] { "en-GB", "en-US", "fr-FR" };
        for(int i=0; i<localeExamples.length; i++)
        {
            response = httpRequest.request(Method.GET, localeExamples[i]);

            if(response.getStatusCode() == 200)
            {
                String responseBody = response.getBody().asString();
                System.out.println("Request: " + httpRequest);
                System.out.println("Response: " + responseBody);
            }

            if(response.getStatusCode() == 400)
            {
                response = httpRequest.request(Method.GET, "en-GB");
                String responseBody = response.getBody().asString();
                System.out.println("Response: " + responseBody);
                //
            }
        }

    }
}
