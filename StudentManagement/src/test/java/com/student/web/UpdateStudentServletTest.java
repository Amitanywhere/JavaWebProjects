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

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
public class UpdateStudentServletTest {
	
	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	RequestDispatcher requestDispatcher;
	
	@Mock
	HttpSession mockHttpSession;
	
	@Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void doGetMethodWithValidSession() throws IOException{
		InstituteModel institute = new InstituteModel("xyz" , "Bangur");
		StudentModel student = new StudentModel("xyz" , "Sanu" , "Naihati" , 5675675432l);
		InstituteDao.addInstitute(institute);
		InstituteDao.addStudent(institute.getInstituteName(), student);
		mockHttpSession.setAttribute("institute", mockHttpSession);
		
		StringWriter strWrite = new StringWriter();
		PrintWriter printWrite = new PrintWriter(strWrite);
		
		when(response.getWriter()).thenReturn(printWrite);
		when(request.getSession(false)).thenReturn(mockHttpSession);
		when(request.getParameter("id")).thenReturn(String.valueOf(student.getStudentId()));
		when(mockHttpSession.getAttribute("institute")).thenReturn(institute);
		
		new UpdateStudentServlet().doGet(request, response);
		
		boolean actualOutput = strWrite.getBuffer().toString().trim().contains("<title>Update Student</title>");
		boolean expectedOutput = true;
		
		assertEquals(expectedOutput , actualOutput);
		
	}
	
	@Test
	public void doGetMethodWithoutValidSession() throws IOException {
		when(request.getSession(false)).thenReturn(null);
		
		new UpdateStudentServlet().doGet(request, response);
		
		verify(response).sendRedirect("instituteLogin");
		
	}
	
	@Test
	public void doPostMethodTest() throws IOException {
		InstituteModel institute = new InstituteModel("xyz" , "Bangur");
		InstituteDao.addInstitute(institute);
		StudentModel student = new StudentModel("xyz" , "Sanu" , "Naihati" , 5675675432l);

		
		InstituteDao.addStudent("xyz" , student);
		
		StringWriter strWrite = new StringWriter();
		PrintWriter printWrite = new PrintWriter(strWrite);
		
		when(response.getWriter()).thenReturn(printWrite);
		
		when(request.getParameter("sid")).thenReturn(String.valueOf(student.getStudentId()));
		when(request.getParameter("instname")).thenReturn("xyz");
		when(request.getParameter("sname")).thenReturn("Sanu");
		when(request.getParameter("scity")).thenReturn("Dum dum");
		when(request.getParameter("snumber")).thenReturn("6578543234");
		
		new UpdateStudentServlet().doPost(request, response);
		
		verify(response).sendRedirect("studentList");
		
	}
}
