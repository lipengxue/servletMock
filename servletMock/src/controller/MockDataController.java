package controller;

import pojo.MockContent;
import pojo.RequestContent;
import pojo.ResponseContent;
import service.MockService;
import utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MockDataController", urlPatterns = "/mock/data")
public class MockDataController extends HttpServlet {

    private final MockService mockService = new MockService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getParameter("uri");
        String method = request.getParameter("method");
        String text = request.getParameter("text");
        String contentType = request.getParameter("content-type");


        //业务逻辑
        if (request.getRequestURI().lastIndexOf("add") > 0) {
            //添加方法
            if (StringUtils.areNull(uri, method, text)) {
                response.getWriter().print("uir,method,text不能为空");
            }
            RequestContent requestContent = new RequestContent()
                    .setMethod(method).setUri(uri);
            ResponseContent responseContent = new ResponseContent()
                    .setContentType(contentType).setText(text);
            MockContent mockContent = new MockContent()
                    .setRequestContent(requestContent).setResponseContent(responseContent);
            mockService.addMockData(mockContent);

        } else if (request.getRequestURI().lastIndexOf("modify") > 0) {
            //修改方法
            if (StringUtils.areNull(uri, method, text)) {
                response.getWriter().print("uir,method,text不能为空");
            }
            RequestContent requestContent = new RequestContent()
                    .setMethod(method).setUri(uri);
            ResponseContent responseContent = new ResponseContent()
                    .setContentType(contentType).setText(text);
            MockContent mockContent = new MockContent()
                    .setRequestContent(requestContent).setResponseContent(responseContent);
            mockService.addMockData(mockContent);


        } else if (request.getRequestURI().lastIndexOf("delete") > 0) {
            //删除方法
            if (StringUtils.areNull(uri, method)) {
                response.getWriter().print("uir,method不能为空");
            }
            RequestContent requestContent = new RequestContent()
                    .setMethod(method).setUri(uri);

            MockContent mockContent = new MockContent()
                    .setRequestContent(requestContent);
            mockService.deleteMockData(mockContent);

        } else {
            //获取方法
            mockService.getAllMockData();
        }
        response.getWriter().print("操作成功");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
