/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author THARUSHI
 */
public class RequestHandler {
    
    public static void addAttribute(HttpServletRequest req, String key, Object val){
        req.getSession().setAttribute(key, val);
    }
    
    public static Object retrieveAttribute(HttpServletRequest req, String key) {
        Object val = req.getSession().getAttribute(key);
        req.getSession().removeAttribute(key);
        return val;
    }
    
}
