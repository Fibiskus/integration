package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;

public class allPanels extends JFrame{
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTable table1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton addButton1;
    private JButton deleteButton1;
    private JTabbedPane tabbedPane3;
    private JTable table2;
    private JTextField textField21;
    private JTextField textField22;
    private JTextField textField23;
    private JButton addButton2;
    private JTextField textField24;
    private JButton deleteButton2;
    private JTabbedPane tabbedPane4;
    private JTable table3;
    private JTextField textField31;
    private JTextField textField32;
    private JButton addButton3;
    private JTextField textField33;
    private JButton deleteButton3;
    private JTabbedPane tabbedPane5;
    private JTable table4;
    private JTextField textField42;
    private JButton addButton4;
    private JTextField textField43;
    private JButton deleteButton4;
    private JTabbedPane tabbedPane6;
    private JTable table5;
    private JTextField textField51;
    private JButton addButton5;
    private JTextField textField52;
    private JButton deleteButton5;

    public void createFrame(){
        setTitle("App");
        setSize(1800, 800);
        JPanel pane = new JPanel();
        pane.add(tabbedPane1);
        add(pane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //transportation tab
    public void setTable1(){
        String data[][] = new String[8][6];
        String columns[] = { "transportation ID", "customer ID", "cargo ID", "truck ID", "city ID","transportation date" };

        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/zdeoruk",
                    "root", "893PM11c");

            PreparedStatement st = connection.prepareStatement("SELECT * FROM zdeoruk.transportation");
            ResultSet rs = st.executeQuery();
            int i =0;



            while (rs.next()) {

                int trans = rs.getInt("transportationID");
                String customer = rs.getString("customerID");
                String cargo = rs.getString("cargoID");
                String truck = rs.getString("truckID");
                String city = rs.getString("cityID");
                String transDate = rs.getString("transportationDate");
                data[i][0] = trans + "";
                data[i][1] = customer;
                data[i][2] = cargo;
                data[i][3] = truck;
                data[i][4] = city;
                data[i][5] = transDate;
                i++;

            }
            DefaultTableModel model = new DefaultTableModel(data, columns);
            table1.setModel(model);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void setAddButton1(){
        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/zdeoruk",
                    "root", "893PM11c");

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO zdeoruk.transportation(transportationID,customerID, cargoID, truckID, cityID, transportationDate) VALUES(?,?,?,?,?,?)");
            preparedStatement.setString(1, null);
            preparedStatement.setString(2, textField2.getText());
            preparedStatement.setString(3, textField3.getText());
            preparedStatement.setString(4, textField4.getText());
            preparedStatement.setString(5, textField5.getText());
            preparedStatement.setString(6, textField6.getText());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Successfully added.");

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,"Failed.");
            sqlException.printStackTrace();
        }
    }

    public void setDeleteButton1() {
        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/zdeoruk",
                    "root", "893PM11c");
            int deleteId = Integer.parseInt(textField7.getText());

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM zdeoruk.transportation WHERE transportationID = '"+deleteId+"' ");
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Successfully deleted.");

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,"Failed.");
            sqlException.printStackTrace();
        }
    }

    //trucks tab
    public void setTable2(){
        String data[][] = new String[8][6];
        String columns[] = { "truckID", "truckNumber", "loadCapacity", "driver" };

        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/zdeoruk",
                    "root", "893PM11c");

            PreparedStatement st = connection.prepareStatement("SELECT * FROM zdeoruk.trucks");
            ResultSet rs = st.executeQuery();
            int i =0;



            while (rs.next()) {

                int truckId = rs.getInt("truckID");
                String truck = rs.getString("truckNumber");
                String load = rs.getString("loadCapacity");
                String driver = rs.getString("driver");
                data[i][0] = truckId + "";
                data[i][1] = truck;
                data[i][2] = load;
                data[i][3] = driver;
                i++;

            }
            DefaultTableModel model = new DefaultTableModel(data, columns);
            table2.setModel(model);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void setAddButton2(){
        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/zdeoruk",
                    "root", "893PM11c");

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO zdeoruk.trucks(truckID, truckNumber, loadCapacity, driver) VALUES(?,?,?,?)");
            preparedStatement.setString(1, null);
            preparedStatement.setString(2, textField21.getText());
            preparedStatement.setString(3, textField22.getText());
            preparedStatement.setString(4, textField23.getText());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Successfully added.");

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,"Failed.");
            sqlException.printStackTrace();
        }
    }

    public void setDeleteButton2() {
        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/zdeoruk",
                    "root", "893PM11c");
            int deleteId = Integer.parseInt(textField24.getText());

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM zdeoruk.trucks WHERE truckID = '"+deleteId+"' ");
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Successfully deleted.");

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,"Failed.");
            sqlException.printStackTrace();
        }
    }

    //cargoes tab
    public void setTable3(){
        String data[][] = new String[8][6];
        String columns[] = { "cargoID", "cargo", "weight" };

        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/zdeoruk",
                    "root", "893PM11c");

            PreparedStatement st = connection.prepareStatement("SELECT * FROM zdeoruk.cargoes");
            ResultSet rs = st.executeQuery();
            int i =0;



            while (rs.next()) {

                int cargoId = rs.getInt("cargoID");
                String cargo = rs.getString("cargo");
                String weight = rs.getString("weight");
                data[i][0] = cargoId + "";
                data[i][1] = cargo;
                data[i][2] = weight;
                i++;

            }
            DefaultTableModel model = new DefaultTableModel(data, columns);
            table3.setModel(model);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void setAddButton3(){
        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/zdeoruk",
                    "root", "893PM11c");

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO zdeoruk.cargoes(cargoID, cargo, weight) VALUES(?,?,?)");
            preparedStatement.setString(1, null);
            preparedStatement.setString(2, textField31.getText());
            preparedStatement.setString(3, textField32.getText());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Successfully added.");

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,"Failed.");
            sqlException.printStackTrace();
        }
    }

    public void setDeleteButton3() {
        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/zdeoruk",
                    "root", "893PM11c");
            int deleteId = Integer.parseInt(textField33.getText());

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM zdeoruk.cargoes WHERE cargoID = '"+deleteId+"' ");
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Successfully deleted.");

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,"Failed.");
            sqlException.printStackTrace();
        }
    }

    //customers tab
    public void setTable4(){
        String data[][] = new String[8][2];
        String columns[] = { "customerID", "customer" };

        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/zdeoruk",
                    "root", "893PM11c");

            PreparedStatement st = connection.prepareStatement("SELECT * FROM zdeoruk.customers");
            ResultSet rs = st.executeQuery();
            int i =0;



            while (rs.next()) {

                int customerId = rs.getInt("customerID");
                String customer = rs.getString("customer");
                data[i][0] = customerId + "";
                data[i][1] = customer;
                i++;

            }
            DefaultTableModel model = new DefaultTableModel(data, columns);
            table4.setModel(model);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void setAddButton4(){
        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/zdeoruk",
                    "root", "893PM11c");

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO zdeoruk.customers(customerID, customer) VALUES(?,?)");
            preparedStatement.setString(1, null);
            preparedStatement.setString(2, textField42.getText());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Successfully added.");

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,"Failed.");
            sqlException.printStackTrace();
        }
    }

    public void setDeleteButton4() {
        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/zdeoruk",
                    "root", "893PM11c");
            int deleteId = Integer.parseInt(textField43.getText());

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM zdeoruk.customers WHERE customerID = '"+deleteId+"' ");
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Successfully deleted.");

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,"Failed.");
            sqlException.printStackTrace();
        }
    }

    //cities tab
    public void setTable5(){
        String data[][] = new String[8][2];
        String columns[] = { "cityID", "city" };

        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/zdeoruk",
                    "root", "893PM11c");

            PreparedStatement st = connection.prepareStatement("SELECT * FROM zdeoruk.cities");
            ResultSet rs = st.executeQuery();
            int i =0;



            while (rs.next()) {

                int cityId = rs.getInt("cityID");
                String city = rs.getString("city");
                data[i][0] = cityId + "";
                data[i][1] = city;
                i++;

            }
            DefaultTableModel model = new DefaultTableModel(data, columns);
            table5.setModel(model);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void setAddButton5(){
        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/zdeoruk",
                    "root", "893PM11c");

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO zdeoruk.cities(cityID, city) VALUES(?,?)");
            preparedStatement.setString(1, null);
            preparedStatement.setString(2, textField51.getText());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Successfully added.");

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,"Failed.");
            sqlException.printStackTrace();
        }
    }

    public void setDeleteButton5() {
        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/zdeoruk",
                    "root", "893PM11c");
            int deleteId = Integer.parseInt(textField52.getText());

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM zdeoruk.cities WHERE cityID = '"+deleteId+"' ");
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Successfully deleted.");

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,"Failed.");
            sqlException.printStackTrace();
        }
    }



    public allPanels() {
        createFrame();
        setTable1();
        setTable2();
        setTable3();
        setTable4();
        setTable5();

        tabbedPane2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setTable1();
            }
        });

        addButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAddButton1();
            }
        });
        deleteButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDeleteButton1();
            }
        });
        tabbedPane3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setTable2();
            }
        });
        addButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAddButton2();
            }
        });
        deleteButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDeleteButton2();
            }
        });
        tabbedPane4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setTable3();
            }
        });
        addButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAddButton3();
            }
        });
        deleteButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDeleteButton3();
            }
        });

        tabbedPane5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setTable4();
            }
        });
        addButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAddButton4();
            }
        });

        deleteButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDeleteButton4();
            }
        });
        tabbedPane6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setTable5();
            }
        });
        addButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAddButton5();
            }
        });
        deleteButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDeleteButton5();
            }
        });
    }

    public static void main(String[] args) {
         allPanels app = new allPanels();
    }
}
