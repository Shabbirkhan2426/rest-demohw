import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;



public class RestAssuredDemo {


    JsonPath  jsonpath = null;


    @Test
    public void restTest(){

        RestAssured.baseURI = "https://www.transparency.treasury.gov/";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.get("/services/api/fiscal_service/v1/debt/tror/data_act_compliance");
        int responseCode =  response.statusCode();

        System.out.println("Status Code : " + responseCode);

        jsonpath = response.getBody().jsonPath();

        String  repcalyear = jsonpath.getString("reporting_calendar_year");
        System.out.println(repcalyear);

        Assert.assertEquals(responseCode,200);
        Assert.assertEquals(repcalyear,"reporting_calendar_year");
        System.out.println("Assertion pass successfully");


    }
}
