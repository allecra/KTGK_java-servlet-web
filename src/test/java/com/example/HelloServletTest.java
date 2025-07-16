package com.example;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class HelloServletTest {

    @Test
    public void testDoGet() throws Exception {
        // Mock các đối tượng Servlet
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Giả lập PrintWriter để bắt nội dung đầu ra
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        Mockito.when(response.getWriter()).thenReturn(writer);

        // Tạo và gọi phương thức doGet
        HelloServlet servlet = new HelloServlet();
        servlet.doGet(request, response);

        // Xác minh hành vi
        Mockito.verify(response).setContentType("text/html");

        // Kiểm tra nội dung đầu ra
        writer.flush(); // Đảm bảo nội dung được ghi
        String output = stringWriter.toString();
        assertTrue(output.contains("<h1>Hello, World, I am a servlet, 10.06.2025!</h1>"),
                "Nội dung đầu ra không chứa chuỗi dự kiến");
    }

    // @Test
    // public void testFailure() {
    // Test này luôn luôn fail để minh chứng CI/CD phát hiện lỗi
    // org.junit.jupiter.api.Assertions.fail("Test này sẽ luôn luôn fail để kiểm tra
    // CI/CD thui nha");
    // }

    @Test
    public void testMessageOutput() throws Exception {
        // Mock các đối tượng Servlet
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Giả lập PrintWriter để bắt nội dung đầu ra
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        Mockito.when(response.getWriter()).thenReturn(writer);

        // Tạo và gọi phương thức doGet
        HelloServlet servlet = new HelloServlet();
        servlet.doGet(request, response);

        // Kiểm tra nội dung đầu ra
        writer.flush();
        String output = stringWriter.toString();
        org.junit.jupiter.api.Assertions.assertTrue(
                output.contains("Xin chao từ HelloServlet!"),
                "Nội dung đầu ra không đúng chuỗi mong đợi roài hehe");
    }

    @Test
    public void testDoGetWithActualOutput() throws Exception {
        // Mock các đối tượng Servlet
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Giả lập PrintWriter để bắt nội dung đầu ra
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        Mockito.when(response.getWriter()).thenReturn(writer);

        // Tạo và gọi phương thức doGet
        HelloServlet servlet = new HelloServlet();
        servlet.doGet(request, response);

        // Kiểm tra nội dung đầu ra
        writer.flush();
        String output = stringWriter.toString();
        org.junit.jupiter.api.Assertions.assertTrue(
                output.contains("<h1>Hello t là ĐỖ THỊ PHÚC nè hehe</h1>"),
                "Nội dung đầu ra không đúng chuỗi mong đợi");
    }

    // Unit test này luôn luôn fail để kiểm tra CI/CD
    @Test
    public void testAlwaysFail() {
        org.junit.jupiter.api.Assertions.fail("Test này luôn luôn fail để kiểm tra CI/CD");
    }

    @Test
    public void testFailForCI() {
        org.junit.jupiter.api.Assertions.assertTrue(false, "Test này chắc chắn sẽ fail để kiểm tra CI/CD");
    }
}