package com.webProject;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.googlecode.objectify.ObjectifyService.ofy;
import com.googlecode.objectify.ObjectifyService;

@SuppressWarnings("serial")
@WebServlet(
    name = "TestDataStoreService",
    urlPatterns = {"/testDataStoreService"}
)
public class TestDataStoreService extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
    ObjectifyService.init();
    Car porsche = new Car("2FAST", 2);
    ofy().save().entity(porsche).now();    // async without the now()
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    response.getWriter().print("Hello App Engine!\r\n");

  }
}