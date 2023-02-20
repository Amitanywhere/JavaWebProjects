package com.student.web;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.*;


public class LogoutServletTest {
	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	HttpSession mockHttpSession;
	
	@Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void doGetMethod() throws IOException {
		when(request.getSession(false)).thenReturn(mockHttpSession);
		new LogoutServlet().doGet(request, response);
		
		verify(mockHttpSession).invalidate();
		verify(response).sendRedirect("index.html");
	}
	
}
