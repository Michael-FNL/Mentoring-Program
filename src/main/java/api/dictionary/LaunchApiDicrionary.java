package api.dictionary;

import api.model.dtos.LaunchAnalyzeRequestDto;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.LoggingUtil;

public class LaunchApiDicrionary {
    private static final String BASE_ENDPOINT = "/api/v1/{projectName}/launch";
    private static final String LAUNCH_BY_ID_ENDPOINT = BASE_ENDPOINT + "/{launchId}";
    private static final String ANALYZE_ENDPOINT = BASE_ENDPOINT + "/analyze";

    private final RequestSpecification requestSpecification;

    public LaunchApiDicrionary(final RequestSpecification specification) {
        this.requestSpecification = specification;
    }

    public Response getAllLaunches(final String projectName) {
        LoggingUtil.log("Sending GET request to: " + BASE_ENDPOINT + " with projectName: " + projectName);

        Response response = requestSpecification
                .pathParam("projectName", projectName)
                .when()
                .get(BASE_ENDPOINT);

        LoggingUtil.log("Response: " + response.asString());
        return response;
    }

        public Response deleteLaunches(final String projectName, final int launchId) {
        LoggingUtil.log("Sending DELETE request to: " + BASE_ENDPOINT + " with projectName: "
                + projectName + " and launchId: " + launchId);

        Response response = requestSpecification
                .pathParam("projectName", projectName)
                .pathParam("launchId", launchId)
                .when()
                .delete(LAUNCH_BY_ID_ENDPOINT);

        LoggingUtil.log("Response: " + response.asString());
        return response;
    }

    public Response analyzeLaunch(final String projectName, final LaunchAnalyzeRequestDto requestDto) {
        LoggingUtil.log("Sending POST request to: " + BASE_ENDPOINT + " with projectName: "
                + projectName + " and body: " + requestDto);

        Response response = requestSpecification
                .pathParam("projectName", projectName)
                .body(requestDto)
                .when()
                .post(ANALYZE_ENDPOINT);

        LoggingUtil.log("Response: " + response.asString());
        return response;
    }

    public Response updateDashboard(final String projectName, final LaunchAnalyzeRequestDto launchDto) {
        LoggingUtil.log("Sending PUT request to: " + LAUNCH_BY_ID_ENDPOINT + " with projectName: "
                + projectName + " and body: " + launchDto);
        Response response = requestSpecification
                .pathParam("projectName", projectName)
                .body(launchDto)
                .when()
                .put(LAUNCH_BY_ID_ENDPOINT);
        LoggingUtil.log("Response: " + response.asString());
        return response;
    }

}
