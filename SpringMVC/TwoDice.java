package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TwoDice {
		@RequestMapping("/rolldice")
		public void main(HttpServletResponse response) throws IOException {	//HttpServletResponse response : 브라우저 출력 
			//math.random사용하여 주사위 이미지 숫자가 바뀌도록 설정
			int idx1 = (int)(Math.random() *6)+1;
			int idx2 = (int)(Math.random() *6)+1;
			
			//print문 사용해서 html형식의 출력문 나타내기  
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("<img src='resources/dice/dice"+idx1+".jpg'>");
			out.println("<img src='resources/dice/dice"+idx2+".jpg'>");
			out.println("</body>");
			out.println("</html>");
			
		}
}
