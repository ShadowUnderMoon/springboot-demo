package com.example.demo;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class HelloController {
    
    @GetMapping("/hello")
    public String sayHello() throws InterruptedException {
//        Thread.sleep(100000); // 10秒
        return "Hello World";
    }

    @GetMapping("/echo")
    public String echoMessage(@RequestParam String message) {
        return "You said: " + message;
    }

    @GetMapping("/delay")
    public String delayResponse() throws InterruptedException {
        // 模拟长时间处理，超过8秒
        Thread.sleep(100000); // 10秒
        return "This request was delayed";
    }

    @GetMapping("/trigger-rst")
    public void triggerRst(HttpServletResponse response) throws IOException {
        // 模拟业务逻辑
        response.getWriter().write("Sending RST");

        // 强制关闭连接，可能导致操作系统发送RST报文
        response.flushBuffer();
        response.getOutputStream().close(); // 强制关闭输出流
    }
}
