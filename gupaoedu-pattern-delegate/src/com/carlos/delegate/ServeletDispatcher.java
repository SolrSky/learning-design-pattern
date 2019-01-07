package com.carlos.delegate;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Solrsky
 * @date 2019/1/7
 */
public class ServeletDispatcher {

    private List<Handler> handlerMapping = new ArrayList<>();





    class Handler{
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public void setController(Object controller) {
            this.controller = controller;
        }

        public Method getMethod() {
            return method;
        }

        public void setMethod(Method method) {
            this.method = method;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
