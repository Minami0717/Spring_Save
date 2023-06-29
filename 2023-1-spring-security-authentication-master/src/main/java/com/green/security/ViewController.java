package com.green.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/view")
public class ViewController {
    @GetMapping
    public void getView(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html;charset=utf-8");
        res.setCharacterEncoding("utf-8");
        PrintWriter pw = res.getWriter();
        pw.print("<html>");
        pw.print("<h1>hello</h1>");
        pw.print("<h1>안녕</h1>");
        pw.print("</html>");
    }
}
