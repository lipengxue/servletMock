package filters;

import pojo.MockContent;
import service.MockService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "MockFilter",urlPatterns = "/*")
public class MockFilter implements Filter {
    private MockService mockService = new MockService();

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (req ==null||req instanceof HttpServletRequest
        ||resp==null||resp instanceof HttpServletResponse){
            throw new IllegalStateException("仅支持http协议");
        }

        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;

//        httpServletResponse.sendRedirect();
        //  项目自身资源交由tomcat处理
        chain.doFilter(req, resp);
        //访问不存在项目中的路径，返回404
        //如果资源不存在，服务器状态置为404，他通过过滤器在mockdata库中进行一次筛选，
        // 如果筛选到了，返回mock数据的返回值，并且要将状态改为200，如果依然没有，返回null
        //
        String key = httpServletRequest.getRequestURI().concat("-")
                .concat(httpServletRequest.getMethod().toUpperCase());
        MockContent mockContent = mockService.getMockData(key);
        if (mockContent!=null) {
            //404
            httpServletResponse.setStatus(200);
            httpServletResponse.setContentType(mockContent.getResponseContent().getContentType());
            httpServletResponse.getWriter().print(mockContent.getResponseContent().getText());
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
