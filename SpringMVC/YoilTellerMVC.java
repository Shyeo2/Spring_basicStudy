package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 년월일을 입력하면 요일을 알려주는 프로그램 
@Controller
public class YoilTellerMVC {
	// main 메서드의 매개변수 args를 String으로 값을 받음 
		@RequestMapping("/getyoilmvc")
		//입력받을 값들을 매개변수로 선언 
		public String main(int year, int month, int day, Model model) throws IOException {

			// 1. 유효성 검사 
			if(!isValid(year, month, day))
				return "yoilError";
	
			// 2. 요일 계산
			char yoil = getYoil(year, month, day);		
			
			// dispatcherservlet이 작업결과가 담아져 있는 모델을 View에 전달 
			// View는 데이터가 담겨있는 model객체에서 값을 읽어서 전
			// 3. 계산한 결과를 model에 저장
			model.addAttribute("year", year);
			model.addAttribute("month", month);
			model.addAttribute("day", day);
			model.addAttribute("yoil", yoil);
			
		//작업 결과를 보여줄 View
		return "yoil";
		
	}

	private boolean isValid(int year, int month, int day) {

		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month -1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);	// DAY_OF_WEEK요일, 숫자로 나옴 ex)1:일요일, 2: 월요일
		return "일월화수목금토".charAt(dayOfWeek);
	}
}
