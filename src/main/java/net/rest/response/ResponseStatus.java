package net.rest.response;

import javax.ws.rs.core.Response;

/**
 * All possible responses for the application that could be returned as response.
 */
public enum ResponseStatus implements ResponseStatusType {

    INTERNAL_ERROR(Response.Status.INTERNAL_SERVER_ERROR), 
    METHOD_NOT_ALLOWED(Response.Status.METHOD_NOT_ALLOWED), 
    BAD_REQUEST(Response.Status.BAD_REQUEST), 
    UNAUTHORIZED(Response.Status.UNAUTHORIZED), 
    NOT_FOUND(Response.Status.NOT_FOUND), 
    UNSUPPORTED_MEDIA_TYPE(Response.Status.UNSUPPORTED_MEDIA_TYPE),
    OK(Response.Status.OK),
    CREATED(Response.Status.CREATED);

    ResponseStatus(Response.Status httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
        this.message = null;
    }

    ResponseStatus(Response.Status httpStatusCode, String message) {
        this.httpStatusCode = httpStatusCode;
        this.message = message;
    }

    @Override
    public Response.Status getHttpStatusCode() {
        return this.httpStatusCode;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public static ResponseStatus fromHttpStatusCode(final int httpStatusCode) {
        for (ResponseStatus s : ResponseStatus.values()) {
            if (s.httpStatusCode.getStatusCode() == httpStatusCode) {
                return s;
            }
        }
        return INTERNAL_ERROR;
    }

    private Response.Status httpStatusCode;
    private String message;
}