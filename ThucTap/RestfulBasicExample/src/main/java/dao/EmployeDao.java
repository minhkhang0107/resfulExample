package dao;

import dbconnect.MysqlConnect;
import model.EmployeModel;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeDao extends AbtractDao{
    public EmployeDao(MysqlConnect mySqlConnectionDtb) {
        super(mySqlConnectionDtb);
    }
    public boolean insert(EmployeModel employeModel) {
        String sql = "INSERT INTO nhanvien values(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, employeModel.getId());
            preparedStatement.setString(2, employeModel.getName());
            preparedStatement.setString(3, employeModel.getDesc());
            preparedStatement.setInt(4, employeModel.getAge());
            preparedStatement.setString(5, employeModel.getAddress());
            preparedStatement.setString(6, employeModel.getSex());
            return this.excuteUpdate(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public EmployeModel getEmployeById(int id) {
        String sql = "SELECT nhanvien.id, nhanvien.eName,nhanvien.eDesc, nhanvien.age, nhanvien.address, nhanvien.sex" +
                " FROM nhanvien WHERE id=?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ArrayList<EmployeModel> list = this.excuteQuery(preparedStatement);
            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateAgeEmployeById(int id, int age) {
        String sql = "UPDATE nhanvien set age=? WHERE id=?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, age);
            preparedStatement.setInt(2, id);
            return this.excuteUpdate(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteEmployeByAge(int age) {
        String sql = "DELETE FROM nhanvien WHERE age <= ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, age);
            return this.excuteUpdate(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
