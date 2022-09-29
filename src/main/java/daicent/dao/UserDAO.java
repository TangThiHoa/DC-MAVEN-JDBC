package daicent.dao;

import daicent.database.JDBCUtil;
import daicent.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO implements DAOInterface<User>{
    public static UserDAO getInstance(){
        return new UserDAO();
    }

    @Override
    public int insert(User t) {
        int result = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = (Connection) JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL
            String sql = "INSERT INTO teststatement.user_infomation (UserID, Username, Password) "+
                    " VALUES ('"+t.getId()+"' , '"+t.getUsername()+"' , "+ t.getPassword()+")";

            result = st.executeUpdate(sql);

            // Bước 4:
            System.out.println("Bạn đã thực thi: "+ sql);
            System.out.println("Có "+ result+" dòng bị thay đổi!");

            // Bước 5:
            JDBCUtil.closeConnection((Connection) con);
            JDBCUtil.printInfo((Connection) con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int update(User t) {
        int result = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = (Connection) JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL

            String sql = "UPDATE teststatement.user_infomation "+
                    " SET " +
                    " Username='"+ t.getUsername()+"'"+
                    ", Password="+ t.getPassword()+
                    " WHERE UserID='"+t.getId()+"\'";
            System.out.println(sql);
            result = st.executeUpdate(sql);

            // Bước 4:
            System.out.println("Bạn đã thực thi: "+ sql);
            System.out.println("Có "+ result+" dòng bị thay đổi!");

            // Bước 5:
            JDBCUtil.closeConnection((Connection) con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int delete(User t) {
        int result = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = (Connection) JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL

            String sql = "DELETE from teststatement.user_infomation "+
                    " WHERE UserID='"+t.getId()+"'";
            System.out.println(sql);
            result = st.executeUpdate(sql);

            // Bước 4:
            System.out.println("Bạn đã thực thi: "+ sql);
            System.out.println("Có "+ result+" dòng bị thay đổi!");

            // Bước 5:
            JDBCUtil.closeConnection((Connection) con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public User selectById(int id) {
        return null;
    }
}
