package com.student.web;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.student.dao.InstituteDao;
import com.student.model.InstituteModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

public class AddStudentServletTest {
	
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
	public void doPostMethodWithoutSession() throws IOException{
		
		when(request.getSession(false)).thenReturn(null);
		
		new AddStudentServlet().doPost(request, response);
		verify(response).sendRedirect("instituteLogin");
	}
	
	@Test
	public void doPostMethodWithSession() throws IOException {
		InstituteModel institute = new InstituteModel("Abc" , "Kolkata");
		InstituteDao.addInstitute(institute);
		when(request.getParameter("sname")).thenReturn("Amit");
		when(request.getParameter("scity")).thenReturn("Kolkata");
		when(request.getParameter("snumber")).thenReturn("8765432189");
		
		mockHttpSession.setAttribute("institute", institute);
		when(request.getSession(false)).thenReturn(mockHttpSession);
		when(mockHttpSession.getAttribute("institute")).thenReturn(institute);
		new AddStudentServlet().doPost(request, response);
		
		verify(response).sendRedirect("studentList");
	}
	
}
