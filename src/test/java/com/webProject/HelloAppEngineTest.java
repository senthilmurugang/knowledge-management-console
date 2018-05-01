package com.webProject;

import java.io.IOException;

import com.google.cloud.datastore.core.exception.DatastoreException;

import org.junit.Assert;
import org.junit.Test;

public class HelloAppEngineTest {

  @Test
  public void test() throws IOException {
    MockHttpServletResponse response = new MockHttpServletResponse();
    new HelloAppEngine().doGet(null, response);
    Assert.assertEquals("text/plain", response.getContentType());
    Assert.assertEquals("UTF-8", response.getCharacterEncoding());
    Assert.assertEquals("Hello App Engine!\r\n", response.getWriterContent().toString());
  }

  @Test
  public void testFirstService() throws IOException {
    MockHttpServletResponse response = new MockHttpServletResponse();
    new GetData().doGet(null, response);
    Assert.assertEquals("text/plain", response.getContentType());
    Assert.assertEquals("UTF-8", response.getCharacterEncoding());
    Assert.assertEquals("Hello", response.getWriterContent().toString());
  }

  @Test
  public void testDatatStoreService() throws DatastoreException {

    

    
  }

}
