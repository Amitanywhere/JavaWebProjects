package com.student.web;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.junit.*;
import org.mockito.*;


public class RegisterInstituteTest {
	
	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	RequestDispatcher requestDispatcher;
	
	@Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    } 
	
	@Test
	public void doPostMethodTestWhenNameAndCityPresent() throws IOException, ServletException {
		
		when(request.getParameter("name")).thenReturn("Abc");
        when(request.getParameter("city")).thenReturn("Kolkata");
        when(request.getRequestDispatcher("instituteLogin")).thenReturn(requestDispatcher);

		StringWriter strWrite = new StringWriter();
		PrintWriter printWrite = new PrintWriter(strWrite);
		when(response.getWriter()).thenReturn(printWrite);
		
		new RegisterInstitute().doPost(request, response);
		
		String actualResult = strWrite.getBuffer().toString().trim();
		String expectedResult = "Institute Register successfully <a href='index.html'>Home</a>";
		assertEquals(expectedResult , actualResult);
        
	}
@Test
public void doPostMethodTestWhenNameAndCityEmpty() throws IOException, ServletException {
		
		when(request.getParameter("name")).thenReturn("");
        when(request.getParameter("city")).thenReturn("");
        when(request.getRequestDispatcher("instituteLogin")).thenReturn(requestDispatcher);

		StringWriter strWrite = new StringWriter();
		PrintWriter printWrite = new PrintWriter(strWrite);
		when(response.getWriter()).thenReturn(printWrite);
		
		new RegisterInstitute().doPost(request, response);
		
		String actualResult = strWrite.getBuffer().toString().trim();
		String expectedResult = "provide valid name and city for institute";
		assertEquals(expectedResult , actualResult);
        
	}

}
