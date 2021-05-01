/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import model.User;

/**
 *
 * @author THARUSHI
 */
public class RequestHandler {
    
    // Adds an attribute to the current request
    public static void addAttribute(HttpServletRequest req, String key, Object val){
        req.getSession().setAttribute(key, val);
    }
    
    /* Returns the required attribute and removes it from the current session.
    Use this when processing the required object gets completed after this request. 
    */
    public static Object retrieveAttribute(HttpServletRequest req, String key) {
        Object val = req.getSession().getAttribute(key);
        req.getSession().removeAttribute(key);
        return val;
    }
    
    /* Returns the required attribute without removing it from the current session.
    Use this when the required attribute needs to be forwarded in following requests. 
    */
    public static Object fetchAttribute(HttpServletRequest req, String key) {
        Object val = req.getSession().getAttribute(key);
        return val;
    }
    
    /*
    Return the currently logged in user. 
    Need to cast if child class capabilities are required.
    */
    public static User getCurrentUser(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        return user;
    }
    
}
