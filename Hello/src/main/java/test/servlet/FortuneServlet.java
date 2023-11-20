package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//3. 어떤 경로 요청에 대해서 이 서블릿이 동작하게 할것인지 설정 
@WebServlet("/fortune")
public class FortuneServlet extends HttpServlet{ //1. 상속
	//2. service() 메소드 오버라이드 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("오잉?");
		
		//응답 인코딩 설정
		resp.setCharacterEncoding("utf-8");
		//응답 컨텐트 설정
		resp.setContentType("text/html; charset=utf-8");
		//요청을 한 클라이언트에게 문자열을 출력할수 있는 객체의 참조값 얻어내기
		PrintWriter pw=resp.getWriter();
		pw.println("<!doctype html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'>");
		pw.println("<title>오늘의 운세 페이지</title>");
		pw.println("</head>");
		pw.println("<body>");
		//오늘의 운세 5개를 미리 준비해 둔다.
		String[] fortunes={"동쪽으로 가면 귀인을 만나요", 
						"오늘은 집에만 계세요", 
						"너무 멀리가지 마세요",
						"오늘은 뭘해도 되는 날이에요",
						"로또가 당첨되요"};
		//랜덤한 수를 얻어내기 위한 객체
		Random ran=new Random();
		// 0 ~ 4 사이의 랜덤한 정수 얻어내기 
		int ranNum=ran.nextInt(5);
		
		pw.println(" \t <p> 오늘의 운세 : <strong>"+fortunes[ranNum]+"</strong> </p>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}


























