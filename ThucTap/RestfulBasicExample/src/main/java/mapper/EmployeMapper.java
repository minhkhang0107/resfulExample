package mapper;

import model.EmployeModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeMapper implements IRowMapper {
    public EmployeModel mapRow(ResultSet rs) {
        EmployeModel employeModel=null;
        try {

            employeModel.setId(rs.getInt("id"));
            employeModel.setName(rs.getString("eName"));
            employeModel.setDesc(rs.getString("eDesc"));
            employeModel.setAge(rs.getInt("age"));
            employeModel.setAddress(rs.getString("address"));
            employeModel.setSex(rs.getString("sex"));
            return employeModel;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
