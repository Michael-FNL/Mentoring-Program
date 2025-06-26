package api.request;

import io.restassured.specification.RequestSpecification;

public class Request {
    protected final RequestSpecification specification;

    public Request(RequestSpecification specification) {
        this.specification = specification;
    }
}
