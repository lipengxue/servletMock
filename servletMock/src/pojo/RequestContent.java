package pojo;

public class RequestContent {

    private String uri;
    private String method;

    public String getUri() {
        return uri;
    }

    public RequestContent setUri(String uri) {
        this.uri = uri;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public RequestContent setMethod(String method) {
        this.method = method;
        return this;
    }

    @Override
    public String toString() {
        return "RequestContent{" +
                "uri='" + uri + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
