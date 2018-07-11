import java.io.IOException;
//import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
//import java.text.SimpleDateFormat;
//import java.util.TimeZone;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hello"}
)
public class HelloAppEngine extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
      
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");
    ZonedDateTime zd = ZonedDateTime.now(ZoneId.of("Asia/Tokyo")); 
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    
    int t = zd.getHour();
    if (t>=4 && t<=10) {
    	response.getWriter().println("Good morning~~!");
    	response.getWriter().println("Have a nice day!");
    	response.getWriter().println("");
    }
    else if (t>=11 && t<=16) {
    	response.getWriter().println("Hello~~!");
    	response.getWriter().println("What did you have for lunch ?");
    	response.getWriter().println("");
    }
    else if(t>=17 && t<=21) {
    	response.getWriter().println("good evening~~!");
    	response.getWriter().println("Would you like to go out for a dinner with me？♡");
    	response.getWriter().println("");
    }
    else {
    	response.getWriter().println("good night!!!");
    	response.getWriter().println("Have a nice dream ♡");
    	response.getWriter().println("");
    }
    response.getWriter().print(zd.format(formatter));
    
    
  }
}