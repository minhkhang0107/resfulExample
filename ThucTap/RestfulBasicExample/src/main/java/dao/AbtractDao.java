package dao;

import dbconnect.MysqlConnect;
import mapper.EmployeMapper;
import model.EmployeModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AbtractDao {
    private MysqlConnect mySqlConnec;
    protected Connection connection;

    public AbtractDao(MysqlConnect mySqlConnectionDtb) {
        this.mySqlConnec = mySqlConnectionDtb;
        this.connection = this.mySqlConnec.getConnection();
    }

    protected boolean excuteUpdate(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            } else return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    protected ArrayList<EmployeModel> excuteQuery(PreparedStatement preparedStatement) throws SQLException {
        ArrayList<EmployeModel> list = new ArrayList<EmployeModel>();
        ResultSet resultSet = preparedStatement.executeQuery();
        EmployeMapper employeMapper= new EmployeMapper();
        while (resultSet.next()) {
            EmployeModel employe = employeMapper.mapRow(resultSet);
            list.add(employe);
        }
        return list;
    }
}
