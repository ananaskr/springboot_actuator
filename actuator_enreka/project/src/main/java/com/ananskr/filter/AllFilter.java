package com.ananskr.filter;


import com.ananskr.auth.User;
import com.ananskr.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URL;


@Component
public class AllFilter implements Filter {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter (ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException,ServletException{
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse res = (HttpServletResponse)servletResponse;
        StringBuffer path = req.getRequestURL();
        URL url = new URL(path.toString());
        HttpSession session = req.getSession();
        String rpath = url.getPath();

       if(rpath.equals("/admin")){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
           User user = userRepository.findUserByUsername(username);
           if(user.getUsername().equals("")){
               res.sendRedirect("/username_error");
           }else{
               if(user.getPassword().equals(password)){
                   try{
                       MessageDigest md = MessageDigest.getInstance("MD5");
                       byte[] results = md.digest(password.getBytes());
                       String result = new String(results);
                       session.setAttribute("token",result);
                       res.sendRedirect("/admin/index");
                   }catch (Exception ex){
                       res.sendRedirect("/error");
                   }
               }else{
                   res.sendRedirect("/passwd_error");
               }
           }
        }

        if(rpath.startsWith("/monitor")){
            User admin = userRepository.findUserByUsername("admin");
            try{
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] results = md.digest(admin.getPassword().getBytes());
                String result = new String(results);
                if(!session.getAttribute("token").equals(result)){
                    res.sendRedirect("/unauthorize");
                }
            }catch (Exception e){
                res.sendRedirect("/unauthorize");
            }
        }

        if (rpath.equals("/dump") || rpath.equals("/trace") || rpath.equals("/logfile") || rpath.equals("/shutdown") || rpath.equals("/mappings") || rpath.equals("/env") || rpath.equals("/restart")) {
            User admin = userRepository.findUserByUsername("admin");
            try{
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] results = md.digest(admin.getPassword().getBytes());
                String result = new String(results);
                if(!session.getAttribute("token").equals(result)){
                    res.sendRedirect("/unauthorize");
                }
            }catch (Exception e){
                res.sendRedirect("/unauthorize");
            }
        }
            filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy(){
    }
}
