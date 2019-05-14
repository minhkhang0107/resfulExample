package controller.Api;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.EmployeDao;
import dbconnect.MysqlConnect;
import model.EmployeModel;
import utils.EmployUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(urlPatterns = {"/api-employe"})
public class EmployeApi extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MysqlConnect mysqlConnection = new MysqlConnect();
        EmployeDao employeDao = new EmployeDao(mysqlConnection);
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        EmployeModel employeModel = EmployUtil.of(request.getReader()).toModel(EmployeModel.class);
        employeDao.insert(employeModel);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(), employeModel);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("application/json");
//        MysqlConnect mysqlConnection = new MysqlConnect();
//        EmployeDao employeDao = new EmployeDao(mysqlConnection);
//        request.getReader();
//        EmployeModel employeModel = employeDao.getEmployeById(1);
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.writeValue(response.getOutputStream(), employeModel);
        MysqlConnect mysqlConnection = new MysqlConnect();
        EmployeDao employeDao = new EmployeDao(mysqlConnection);
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        EmployeModel employeModel = EmployUtil.of(request.getReader()).toModel(EmployeModel.class);
        employeDao.insert(employeModel);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(), employeModel);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MysqlConnect mysqlConnection = new MysqlConnect();
        EmployeDao employeDao = new EmployeDao(mysqlConnection);
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        EmployeModel employeModel = EmployUtil.of(request.getReader()).toModel(EmployeModel.class);
        employeDao.deleteEmployeByAge(employeModel.getAge());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(), employeModel);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MysqlConnect mysqlConnection = new MysqlConnect();
        EmployeDao employeDao = new EmployeDao(mysqlConnection);
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        EmployeModel employeModel = EmployUtil.of(request.getReader()).toModel(EmployeModel.class);
        employeDao.deleteEmployeByAge(employeModel.getAge());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(), employeModel);
    }
}
