package com.student.web;

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
import com.student.model.InstituteModel;
import com.student.model.StudentModel;

import javax.servlet.http.*;

public class DeleteStudentServletTest {
	
	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	HttpSession mockSession;
	
	@Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    } 
	
	@Test
	public void doGetMethodWithValidSession() throws IOException {
		InstituteModel institute = new InstituteModel("xyz" , "Bangur");
		InstituteDao.addInstitute(institute);
		StudentModel student = new StudentModel("xyz" , "Sanu" , "Naihati" , 5675675432l);
		InstituteDao.addStudent("xyz" , student);
		mockSession.setAttribute("institute", institute);
		
		StringWriter strWrite = new StringWriter();
		PrintWriter printWrite = new PrintWriter(strWrite);
		
		when(response.getWriter()).thenReturn(printWrite);
		when(request.getSession(false)).thenReturn(mockSession);
		when(mockSession.getAttribute("institute")).thenReturn(institute);
		when(request.getParameter("id")).thenReturn(String.valueOf(student.getStudentId()));
		new DeleteStudentServlet().doGet(request, response);
		verify(response).sendRedirect("studentList");
	}
	
	@Test
	public void doGetMethodSessionNull() throws IOException {
		when(request.getSession(false)).thenReturn(null);
		StringWriter strWrite = new StringWriter();
		PrintWriter printWrite = new PrintWriter(strWrite);
		
		when(response.getWriter()).thenReturn(printWrite);
		new DeleteStudentServlet().doGet(request, response);
		verify(response).sendRedirect("instituteLogin");
	}
}
