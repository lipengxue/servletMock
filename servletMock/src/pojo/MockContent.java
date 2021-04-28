package pojo;

public class MockContent {
    private RequestContent requestContent;
    private ResponseContent responseContent;

    public RequestContent getRequestContent() {
        return requestContent;
    }

    public MockContent setRequestContent(RequestContent requestContent) {
        this.requestContent = requestContent;
        return this;
    }

    public ResponseContent getResponseContent() {
        return responseContent;
    }

    public MockContent setResponseContent(ResponseContent responseContent) {
        this.responseContent = responseContent;
        return this;
    }

    @Override
    public String toString() {
        return "MockContent{" +
                "requestContent=" + requestContent +
                ", responseContent=" + responseContent +
                '}';
    }
}
