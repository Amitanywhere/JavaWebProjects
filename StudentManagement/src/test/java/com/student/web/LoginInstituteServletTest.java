package com.student.web;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.student.dao.InstituteDao;
import com.student.model.*;

import javax.servlet.http.*;

public class LoginInstituteServletTest {
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
	public void doGetWithoutSession() throws IOException{
		when(request.getSession(false)).thenReturn(null);

		StringWriter strWrite = new StringWriter();
		PrintWriter printWrite = new PrintWriter(strWrite);
		when(response.getWriter()).thenReturn(printWrite);
	    new LoginInstituteServlet().doGet(request, response);
	    
	    boolean actualResult = strWrite.getBuffer().toString().trim().startsWith("<html>");
	    assertEquals(true , actualResult);
	}
	
	@Test
	public void doGetWithSession() throws IOException {
		when(request.getSession(false)).thenReturn(mockHttpSession);
		new LoginInstituteServlet().doGet(request, response);
		
		verify(response).sendRedirect("studentList");
		
	}
	
	@Test
	public void doPostWithCredentialNotMatch() throws IOException {
		when(request.getParameter("name")).thenReturn("Amit");
		when(request.getParameter("password")).thenReturn("abcd");
		
		StringWriter strWrite = new StringWriter();
		PrintWriter printWrite = new PrintWriter(strWrite);
		when(response.getWriter()).thenReturn(printWrite);
		new LoginInstituteServlet().doPost(request, response);
		String actualResult = strWrite.getBuffer().toString().trim();
		String expectedResult = "Name or password is not correct or register the institute first <a href='index.html'>Home</a>";
		assertEquals(expectedResult , actualResult);
	}
	
	@Test
	public void doPostWithCredentialMatch() throws IOException {
		InstituteModel institute = new InstituteModel("Abc" , "Sodepur");
		InstituteDao.addInstitute(institute);
		InstituteDao.addStudent("Abc", new StudentModel("Abc" , "Akash" , "kolkata" ,  4567456745l));
		
		when(request.getParameter("name")).thenReturn("Abc");
		when(request.getParameter("password")).thenReturn("admin123");
		when(request.getSession()).thenReturn(mockHttpSession);
		
		new LoginInstituteServlet().doPost(request, response);
		verify(mockHttpSession).setAttribute("institute", institute);
		verify(response).sendRedirect("studentList");
	}
}
