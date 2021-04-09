package assignment_3.part_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class CityTableModel extends JTableModel {

    String[] columnNames;
    private Object[][] data;

    public void setColumnNames(String[] col) {
        columnNames = new String[col.length];
        for (int j = 0; j < col.length; j++) {
            columnNames[j] = col[j];
        }
        this.setColumnName(columnNames);
    }

    public void setTableData(ArrayList list) {
        data = new Object[list.size()][columnNames.length];
        int row = 0;
        for (int i = 0; i < list.size(); i++) {

            Cities CityData = (Cities) list.get(i);

            data[row][0] = CityData.getCity_ID();
            data[row][1] = CityData.getCity_Name();

            row++;
        }
        this.setData(data);
    }
    
     public void populateTable() {
        String[] col = {"Cities ID ", "Cities Name"};
        try {
            Connection conn;

            String dbURL = "jdbc:sqlserver://localhost;ServerName=DESKTOP-BSA7KR4;database=Assignment_03";
            String userName = "sa";
            String password = "asad507";

            conn = DriverManager.getConnection(dbURL, userName, password);

            String query = "select * from tbl_CITIES";
            Statement stmt;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            
                ArrayList<Cities> studentList = new ArrayList<Cities>();
                while (rs.next()) {
                Cities c = new Cities(
                            
                            rs.getString("City_ID"),
                            rs.getString("City_Name")
                           
                );
                studentList.add(c);

                setColumnNames(col);
                setTableData(studentList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
