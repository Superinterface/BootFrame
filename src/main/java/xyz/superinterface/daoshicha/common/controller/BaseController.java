package xyz.superinterface.daoshicha.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.superinterface.daoshicha.common.service.BaseCreateHTMLServiceimpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/api")
public class BaseController {

    @Autowired
    BaseCreateHTMLServiceimpl baseCreateHTMLServiceimpl;

    @GetMapping(value = "/getHtml")
    public void getHtml(HttpServletRequest request, HttpServletResponse response, String name){
        try{
            baseCreateHTMLServiceimpl.getData(name, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/test")
    public void test(HttpServletRequest request, HttpServletResponse response, String name){
        try{
            baseCreateHTMLServiceimpl.createFile(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
