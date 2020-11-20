package util;

import java.io.IOException;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.threadlocal.LocalRequestContextHolder;

public class ContentFilter extends CharacterEncodingFilter {



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //request.setCharacterEncoding("gb2312");
        HttpServletRequest req = (HttpServletRequest) request;
        LocalRequestContextHolder.setLocalRequestContext(req,response );
        //filterChain.doFilter(request, response);

        super.doFilterInternal(request, response, filterChain);
    }

    // Process the request/response pair
    // Clean up resources
    public void destroy() {
    }
}
