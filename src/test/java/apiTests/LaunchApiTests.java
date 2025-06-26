package apiTests;

import api.model.dtos.LaunchAnalyzeRequestDto;
import api.model.dtos.LaunchResponse;
import api.model.mapper.LaunchMapper;
import baseTest.BaseApiTest;
import dto.LaunchTableHeaders;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.RandomData;

import java.util.List;

public class LaunchApiTests extends BaseApiTest {

    private static final String PROJECT_NAME = "superadmin_personal";

    @Test
    public void userIsAbleToGetAllLaunchesByFilterViaGetRequest() {
        Response response = launchApi.getAllLaunches(PROJECT_NAME);
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void userIsAbleToRemoveLaunchesByIdViaDeleteRequest() {
        Response response = launchApi.deleteLaunches(PROJECT_NAME, RandomData.getRandomInteger());
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void userIsAbleToStartLauncheAnalysisViaPostRequest() {
        var dto = LaunchAnalyzeRequestDto.builder()
                .launchId(RandomData.getRandomInteger())
                .analyzerMode("LAUNCH_NAME")
                .analyzerTypeName("autoAnalyzer")
                .analyzeItemsMode(List.of(LaunchTableHeaders.TO_INVESTIGATE.toString()))
                .build();

        Response response = launchApi.analyzeLaunch(PROJECT_NAME, dto);
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void userIsAbleToCompareLauncheViaGetRequest() {
        Response response = launchApi.getAllLaunches(PROJECT_NAME);
        response.then().assertThat().statusCode(HttpStatus.SC_OK);

        LaunchMapper mapper = new LaunchMapper();
        LaunchResponse launchResponse = mapper.fromJson(response.asString());

        Assert.assertNotEquals(launchResponse.getContent().get(0).getId(), launchResponse.getContent()
                .get(launchResponse.getContent().size() - 1).getId(), "Launches id are the same");
    }
}
