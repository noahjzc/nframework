package com.noah.nframework.core;

import com.noah.nframework.core.bean.Data;
import com.noah.nframework.core.bean.Handler;
import com.noah.nframework.core.bean.Param;
import com.noah.nframework.core.helper.BeanHelper;
import com.noah.nframework.core.helper.ControllerHelper;
import com.noah.nframework.core.helper.ServletHelper;
import com.noah.nframework.core.util.CodecUtil;
import com.noah.nframework.core.util.JsonUtil;
import com.noah.nframework.core.util.ReflectionUtil;
import com.noah.nframework.core.util.StreamUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Noah.Ji
 * @date: 2020/5/20 13:38
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        HelperLoader.init();
//        ServletContext servletContext =config.getServletContext();
//        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
//        defaultServlet.addMapping()
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletHelper.init(req, resp);
        try {
            String requestMethod = req.getMethod().toLowerCase();
            String requestPath = req.getPathInfo();
            Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
            if (handler != null) {
                Class<?> controllerClass = handler.getControllerClass();
                Object controllerBean = BeanHelper.getBean(controllerClass);
                Map<String, Object> paramMap = new HashMap<>();
                Enumeration<String> paramNames = req.getParameterNames();
                while (paramNames.hasMoreElements()) {
                    String paramName = paramNames.nextElement();
                    String paramValue = req.getParameter(paramName);
                    paramMap.put(paramName, paramValue);
                }
                String body = CodecUtil.decodeURL(StreamUtil.getString(req.getInputStream()));
                if (StringUtils.isNotEmpty(body)) {
                    String[] params = StringUtils.split(body, "&");
                    if (ArrayUtils.isNotEmpty(params)) {
                        for (String param : params) {
                            String[] array = StringUtils.split(param, "=");
                            if (ArrayUtils.isNotEmpty(array) && array.length == 2) {
                                paramMap.put(array[0], array[1]);
                            }
                        }
                    }
                }
                Param param = new Param(paramMap);
                Method actionMethod = handler.getActionMethod();
                Object result = ReflectionUtil.invokeMethod(controllerBean, actionMethod, param);
                if (result instanceof Data) {
                    Data data = (Data) result;
                    Object model = data.getModel();
                    if (model != null) {
                        resp.setContentType("application/json");
                        resp.setCharacterEncoding("UTF-8");
                        PrintWriter writer = resp.getWriter();
                        String json = JsonUtil.toJson(model);
                        writer.write(json);
                        writer.flush();
                        writer.close();
                    }
                }
            }
        } finally {
            ServletHelper.destroy();
        }

    }
}
