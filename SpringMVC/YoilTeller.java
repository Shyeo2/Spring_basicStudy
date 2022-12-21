package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 년월일을 입력하면 요일을 알려주는 프로그램 
@Controller
public class YoilTeller {
	// main 메서드의 매개변수 args를 String으로 값을 받음 
//	public static void main(String[] args) {
		@RequestMapping("/getyoil")
//		public static void main(HttpServletRequest request, HttpServletResponse respose) throws IOException {
//		// 1. 입력 (값을 year, month,day 에 저장)
//		String year = request.getParameter("year");
//		String month = request.getParameter("month");
//		String day = request.getParameter("day");
		public void main(int year, int month, int day, HttpServletResponse respose) throws IOException {

		// 2. 작업 (날짜)
		// 문자형이기 때문에 숫자로 바꿔줌
//		int yyyy = Integer.parseInt(year);
//		int mm = Integer.parseInt(month);
//		int dd = Integer.parseInt(day);
		
		// 2. 처리 (Controller)
		Calendar cal = Calendar.getInstance();
		cal.set(year, month -1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);	// DAY_OF_WEEK요일, 숫자로 나옴 ex)1:일요일, 2: 월요일
		char yoil = "일월화수목금토".charAt(dayOfWeek);		// 숫자를 문자로 바꿔줌 
		// 처리와 출력의  데이터 전달을 위해서 Model이 필요 =>MVC 패턴 
		
		// 3. 출력 (View) 
		//브라우저는 보내는 내용이 텍스트인지 바이너리인지 모르기 때문에 텍스트를 보내는지 인코딩이 무엇인지 알려줘야함 
		respose.setContentType("text/html");
		respose.setCharacterEncoding("utf-8");
		PrintWriter out = respose.getWriter();	//response객체에서 브라우저로의 출력스트림을 얻는다
		out.println(year + "년" + month + "일" + day + "일은");
		out.println(yoil + "입니다.");
	}
}
