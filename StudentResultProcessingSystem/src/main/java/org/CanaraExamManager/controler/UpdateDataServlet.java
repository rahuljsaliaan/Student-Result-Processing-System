package org.CanaraExamManager.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.CanaraExamManager.bean.ProgrammeCourseClassBean;
import org.CanaraExamManager.bean.StudentStaffDataBean;
import org.CanaraExamManager.dao.UpdateDataDao;

@WebServlet("/UpdateDataServlet")
public class UpdateDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dataString = request.getParameter("Data");
		UpdateDataDao updateDataDao = new UpdateDataDao();
		
		if(dataString!=null || dataString!="") {
			
			switch (dataString) {
			case "student": {
				
				StudentStaffDataBean studentDataBean = new StudentStaffDataBean();
				
				 studentDataBean.setfirstName(request.getParameter("sFirstName"));//1
				 studentDataBean.setLastName(request.getParameter("sLastName"));//2
				 studentDataBean.setGender(request.getParameter("sGender"));//3
				 studentDataBean.setDOB(request.getParameter("sdob"));//4
				 studentDataBean.setEmail(request.getParameter("sEmail"));//5
				 studentDataBean.setPhone(request.getParameter("sPhone"));//6
				 studentDataBean.setAddress(request.getParameter("sAddress"));//7
				 studentDataBean.setPinCode(request.getParameter("sPincode"));//8
				 studentDataBean.setCity(request.getParameter("sCity"));//9
				 studentDataBean.setDistrict(request.getParameter("sDistrict"));//10
				 studentDataBean.setState(request.getParameter("sState"));//11
				 studentDataBean.setYear(request.getParameter("sYearOfJoining"));//12
				 studentDataBean.setProgramme(request.getParameter("sProgramme"));//13
				 studentDataBean.setClass(request.getParameter("sClass"));//14
				 studentDataBean.setCurrentSemester(request.getParameter("sSemester"));//15
				 studentDataBean.setRegNo(request.getParameter("sRegNo"));//16
				 studentDataBean.setClassYear(request.getParameter("sClassYear"));//17
				
				 String dataValidateString = updateDataDao.updateStudentData(studentDataBean) ;
				 
				 request.setAttribute("updateMessage",dataValidateString);
				 request.getRequestDispatcher("messageConfirmer.jsp").forward(request, response); 
				
				 
			}case "staff": {
				
				StudentStaffDataBean staffDataBean = new StudentStaffDataBean();
				
				staffDataBean.setfirstName(request.getParameter("staffFirstName"));//1
				staffDataBean.setLastName(request.getParameter("staffLastName"));//2
				staffDataBean.setGender(request.getParameter("staffGender"));//3
				staffDataBean.setEmail(request.getParameter("staffEmail"));//5
				staffDataBean.setPhone(request.getParameter("StaffPhone"));//6
				staffDataBean.setAddress(request.getParameter("staffAddress"));//7
				staffDataBean.setProgramme(request.getParameter("staffProgramme"));//9
				staffDataBean.setStaffId(request.getParameter("staffId"));//10
				staffDataBean.setTemp(request.getParameter("tempStaffId"));//11
				staffDataBean.setRole(request.getParameter("staffRole"));//12
				
				String dataValidateString = updateDataDao.updateStaffData(staffDataBean) ;
				 
				request.setAttribute("updateMessage",dataValidateString);
				request.getRequestDispatcher("messageConfirmer.jsp").forward(request, response);
				
			}case "programme": {
				
				ProgrammeCourseClassBean programmeBean = new ProgrammeCourseClassBean();
				
				programmeBean.setProgrammeId(request.getParameter("programmeId"));//1
				programmeBean.setProgrammeName(request.getParameter("programmeName"));//2
				programmeBean.setProgrammeDuration(request.getParameter("duration"));//3;
				programmeBean.setSemester(request.getParameter("totalSemester"));//4
				
				String dataValidateString = updateDataDao.updateProgrammeData(programmeBean);
				
				request.setAttribute("updateMessage",dataValidateString);
				request.getRequestDispatcher("messageConfirmer.jsp").forward(request, response);
				
			}case "course": {
				
				ProgrammeCourseClassBean courseDataBean = new ProgrammeCourseClassBean();
		
				courseDataBean.setCourseCode(request.getParameter("uniqueId"));//2
				courseDataBean.setCourseName(request.getParameter("courseName"));//3
				courseDataBean.setCourseType(request.getParameter("courseType"));//4
				courseDataBean.setCourseGroup(request.getParameter("courseGroup"));//5
				courseDataBean.setSemester(request.getParameter("courseSem"));//6
				courseDataBean.setMaxMarks(request.getParameter("courseMaxMarks"));//7
				courseDataBean.setMinMarks(request.getParameter("courseMinMarks"));//8
				courseDataBean.setMaxIA(request.getParameter("courseMaxIA"));//9
				courseDataBean.setTemp(request.getParameter("tempCode"));
		
				String dataValidateString = updateDataDao.updateCourseData(courseDataBean);
				 
				request.setAttribute("updateMessage",dataValidateString);
				request.getRequestDispatcher("messageConfirmer.jsp").forward(request, response);
				
				
			}case "class": {
				
				ProgrammeCourseClassBean classDataBean = new ProgrammeCourseClassBean();
				
				classDataBean.setClassId(request.getParameter("classId"));
				classDataBean.setClassName(request.getParameter("className"));
				classDataBean.setProgrammeName(request.getParameter("progNameInClass"));
				classDataBean.setClassYear(request.getParameter("classYear"));
				
				String dataValidateString = updateDataDao.updateClassData(classDataBean);
				 
				request.setAttribute("updateMessage",dataValidateString);
				request.getRequestDispatcher("messageConfirmer.jsp").forward(request, response);
				
				
			}default:{
				response.sendRedirect("home.jsp");
				
			}
			
			}
			
		}
		
	}
}


