package com.webProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(
    name = "GetData",
    urlPatterns = {"/getData"}
)
public class GetData extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
      
    String requestUrl = request != null && request.getParameter("url") != null ? request.getParameter("url") : null;
    if(requestUrl != null){
    	URL url = new URL(requestUrl);
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.connect();
	    InputStreamReader in = new InputStreamReader((InputStream) conn.getContent());
	    response.setContentType(conn.getContentType());
	    response.setCharacterEncoding(conn.getContentEncoding());
	    BufferedReader buff = new BufferedReader(in);
	    String line;
	    do {
	      line = buff.readLine();
	      if(line != null)
	    	  response.getWriter().print(line);
	    } while (line != null);
    } else {
    	response.setContentType("text/plain");
    	response.setCharacterEncoding("UTF-8");
    	response.getWriter().print("Hello");
    }
  }
}