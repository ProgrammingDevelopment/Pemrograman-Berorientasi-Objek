import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class EmployeeSystemGUI extends JFrame {
    private ArrayList<Employee> employees;
    private JTextArea displayArea;
    private Connection connection;

    public EmployeeSystemGUI() {
        employees = new ArrayList<>();

        setTitle("Employee Management System");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new FlowLayout());
        JButton addEmployeeButton = new JButton("Add Employee");
        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });
        inputPanel.add(addEmployeeButton);

        displayArea = new JTextArea(15, 30);
        displayArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Initialize database connection
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:employees.db");
            createEmployeeTable();
            loadEmployees();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void createEmployeeTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS employees (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL)";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    private void addEmployee() {
        String name = JOptionPane.showInputDialog("Enter employee name:");
        if (name != null && !name.isEmpty()) {
            try {
                String sql = "INSERT INTO employees (name) VALUES (?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, name);
                preparedStatement.executeUpdate();
                loadEmployees();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void loadEmployees() {
        employees.clear();
        try {
            String sql = "SELECT * FROM employees";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                employees.add(new Employee(id, name));
            }
            displayEmployees();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void displayEmployees() {
        displayArea.setText("");
        for (Employee emp : employees) {
            displayArea.append("ID: " + emp.getId() + ", Name: " + emp.getName() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeSystemGUI gui = new EmployeeSystemGUI();
            gui.setVisible(true);
        });
    }
}

class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
