package com.projectx.utils;

public enum WebResponseCode {

    // 200 OK
    SUCCESS_OK(200, "OK"),

    // 201 Created
    CREATED(201, "Created"),

    // 204 No Content
    NO_CONTENT(204, "No Content"),

    // 400 Bad Request
    BAD_REQUEST(400, "Bad Request"),

    // 401 Unauthorized
    UNAUTHORIZED(401, "Unauthorized"),

    // 403 Forbidden
    FORBIDDEN(403, "Forbidden"),

    // 404 Not Found
    NOT_FOUND(404, "Not Found"),

    // 409 Conflict
    CONFLICT(409, "Conflict"),

    // 500 Internal Server Error
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    // 503 Service Unavailable
    SERVICE_UNAVAILABLE(503, "Service Unavailable");

    private final int code;
    private final String message;

    WebResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return code + " " + message;
    }
}

