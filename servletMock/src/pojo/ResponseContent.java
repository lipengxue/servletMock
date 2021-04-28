package pojo;

import utils.StringUtils;

public class ResponseContent {
    private String text;
    private String contentType;

    public String getText() {
        return text;
    }

    public String getContentType() {
        return contentType;
    }

    public ResponseContent setText(String text) {
        this.text = text;
        return this;
    }

    public ResponseContent setContentType(String contentType) {
        if (StringUtils.idNull(contentType)){
            contentType = "text/html;charset=utf-8";
        }
        this.contentType = contentType;
        return this;
    }
}
