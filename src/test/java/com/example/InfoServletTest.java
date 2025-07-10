package com.example;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class InfoServletTest {

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
        InfoServlet servlet = new InfoServlet();
        servlet.doGet(request, response);

        // Xác minh hành vi
        Mockito.verify(response).setContentType("text/html");

        // Kiểm tra nội dung đầu ra
        writer.flush(); // Đảm bảo nội dung được ghi
        String output = stringWriter.toString();
        assertTrue(output.contains("<h2>Thông tin nhóm:</h2>"), "Không tìm thấy tiêu đề thông tin nhóm");
        assertTrue(output.contains("Nguyễn Thị Tâm"), "Không tìm thấy tên Nguyễn Thị Tâm");
        assertTrue(output.contains("Đỗ Thị Phúc"), "Không tìm thấy tên Đỗ Thị Phúc");
        assertTrue(output.contains("Nguyễn Thị Xinh"), "Không tìm thấy tên Nguyễn Thị Xinh");
    }
}