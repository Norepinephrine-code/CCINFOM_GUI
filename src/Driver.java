public class Driver {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/medical_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "12301388dlsu";

    private static Connection connection;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connected to the database!");

            SwingUtilities.invokeLater(() -> {
                MainView mainView = new MainView();
                mainView.setVisible(true);
            });

        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database connection failed.");
            e.printStackTrace();
        }
    }
}
