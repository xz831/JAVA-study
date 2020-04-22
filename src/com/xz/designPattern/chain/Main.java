package com.xz.designPattern.chain;


import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.xz.designPattern.chain
 * @ClassName: Main
 * @Author: xz
 * @Date: 2020/4/22 19:52
 * @Version: 1.0
 */
public class Main {

    public static void main(String[] args) {
        Request request = new Request();
        Response response = new Response();
        FilterChain filterChain = new FilterChain();
        filterChain.add(new Filter1());
        filterChain.add(new Filter2());
        filterChain.doFilter(request, response);
        System.out.println(request.request);
        System.out.println(response.response);
    }
}

class Request {
    String request = "";
}

class Response {
    String response = "";
}

abstract class AbstractFilter {
    abstract void doFilter(Request request, Response response, FilterChain chain);
}

class FilterChain {
    List<AbstractFilter> filters = new ArrayList<>();
    int index = 0;

    public void add(AbstractFilter f) {
        filters.add(f);
    }

    public void doFilter(Request request, Response response) {
        if (index == filters.size()) {
            return;
        }
        filters.get(index++).doFilter(request, response, this);
    }
}

class Filter1 extends AbstractFilter {

    @Override
    void doFilter(Request request, Response response, FilterChain chain) {
        request.request += "a ";
        chain.doFilter(request, response);
        response.response += "b ";
    }
}

class Filter2 extends AbstractFilter {

    @Override
    void doFilter(Request request, Response response, FilterChain chain) {
        request.request += "c ";
        chain.doFilter(request, response);
        response.response += "d ";
    }
}
