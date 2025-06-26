package baseTest;

import api.dictionary.LaunchApiDicrionary;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import util.Config;
import util.DriverCreator;
import util.ListenerRP;
import util.LoggingUtil;

@Listeners(ListenerRP.class)
public class BaseApiTest extends BaseTest {
    private static final String BASE_URL = Config.getProperties("api_host");
    private static final String AUTH_TOKEN = "/uat/sso/oauth/token";

    protected RequestSpecification requestSpecification;
    protected LaunchApiDicrionary launchApi;
    private String accessToken;

    protected String getAuthToken() {
        return AUTH_TOKEN;
    }

    @BeforeMethod
    public void setUp() {
        accessToken = getAccessToken();
        System.out.println("Access Token: " + accessToken);
        RestAssured.baseURI = BASE_URL;
        requestSpecification = RestAssured.given()
                .header("Authorization", "Bearer " + accessToken)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json");
        launchApi = new LaunchApiDicrionary(requestSpecification);
    }

    public String getAccessToken() {
        Response response = RestAssured.given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Authorization", "Basic dWk6dWltYW4=")
                .formParam("grant_type", "password")
                .formParam("username", "superadmin")
                .formParam("password", "erebus")
                .when()
                .post(AUTH_TOKEN);

        if (response.statusCode() != 200) {
            LoggingUtil.log("Failed to get access token");
        }

        return response.jsonPath().getString("access_token");
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        DriverCreator.quitBrowser();
        LoggingUtil.log("Thread resources closed");
    }
}
