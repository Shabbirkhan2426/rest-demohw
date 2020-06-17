import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;



public class RestAssuredDemo1 {

    JsonPath jsonpath = null;

    @Test
    public void RestTest(){

        RestAssured.baseURI = "https://www.transparency.treasury.gov/";
        RequestSpecification requestSpecification = RestAssured.given();

        Response response  = requestSpecification.get("/services/api/fiscal_service/v1/accounting/od/fip_rates_prices?limit =1");

        int responseCode = response.statusCode();

        System.out.println("Status Code : " + responseCode);

        jsonpath = response.getBody().jsonPath();

        String  depart = jsonpath.getString("reporting_calendar_year");
        System.out.println(depart);

        Assert.assertEquals(responseCode,200);

        Assert.assertEquals(depart,"reporting_calendar_year");
        System.out.println("Assertion pass successfully");

                // tanmoy@piit.us
                // 570 951 9352

    }
}
