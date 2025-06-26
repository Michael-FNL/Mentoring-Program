package api.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class Specification {
    private static Specification spec;

    private Specification() {
    }

    public static Specification getSpec() {
        if (spec == null) {
            spec = new Specification();
        }
        return spec;
    }

    public static RequestSpecBuilder requestBuilder() {
        return new RequestSpecBuilder()
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON);
    }

//    public static RequestSpecification authenticationSpec(final String email) {
//        return requestBuilder()
//                .setBaseUri(String.format(EmailConfiguration.getProperties("host"), email.split("@", 2)))
//                .build();
//    }
}
