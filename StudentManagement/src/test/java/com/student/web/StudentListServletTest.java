package com.student.web;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import com.student.model.*;

public class StudentListServletTest {
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
	  public void doGetWithSession() throws IOException {
	    InstituteModel institute = new InstituteModel("Abc" , "Kolkata");
	    institute.addStudent(new StudentModel("Abc" ,"Amit" , "kolk" , 6578675640l));
	    mockHttpSession.setAttribute("institute", institute);
	    
	    when(request.getSession(false)).thenReturn(mockHttpSession);
	    when(mockHttpSession.getAttribute("institute")).thenReturn(institute);

	    StringWriter strWrite = new StringWriter();
		PrintWriter printWrite = new PrintWriter(strWrite);
		when(response.getWriter()).thenReturn(printWrite);
		
	    new StudentListServlet().doGet(request, response);
	    
	    boolean actualResult = strWrite.getBuffer().toString().trim().startsWith("<html>");
	    assertEquals(true , actualResult);
	  }
	
	@Test
	public void doGetWithoutSession() throws IOException {
	    
	    when(request.getSession(false)).thenReturn(null);

		
	    new StudentListServlet().doGet(request, response);
	    
	    verify(response).sendRedirect("instituteLogin");
	  }
	
}
