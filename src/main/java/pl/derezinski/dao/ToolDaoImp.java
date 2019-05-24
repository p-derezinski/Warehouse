package pl.derezinski.dao;

import pl.derezinski.model.Tool;
import pl.derezinski.model.ToolType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToolDaoImp implements ToolDao{

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/warehouse?serverTimezone=GMT&useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = PasswordGetter.get();

    @Override
    public List<Tool> getAllTools() {

        List<Tool> tools = new ArrayList<>();
        String selectSQL = "SELECT * FROM tools";
        try (Connection dbConnection = getDBConnection(); PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Long toolId = rs.getLong("id");
                String toolName = rs.getString("name");
                ToolType toolType = ToolType.valueOf(rs.getString("type"));
                boolean toolAvailability = rs.getBoolean("available");
                tools.add(new Tool(toolId, toolName, toolType, toolAvailability));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tools;
    }

    @Override
    public void setAvailability(Long id, boolean availability) {

        String updateSQL = "UPDATE tools SET available = ? WHERE id = ?";
        try (Connection dbConnection = getDBConnection(); PreparedStatement preparedStatement = dbConnection.prepareStatement(updateSQL)) {
            preparedStatement.setBoolean(1, availability);
            preparedStatement.setLong(2, id);
            int rs = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}
