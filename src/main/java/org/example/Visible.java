package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class Visible {
    public void Form() throws SQLException {
        JFrame frame = new JFrame("Вывод");
        frame.setSize(600,500);

        String [] colname = new String[] {"Код","Наименование услуги","Код услуги","Цена"};

        Statement statement1 = Connect.getConnection().createStatement();
        Statement statement2 = Connect.getConnection().createStatement();

        ResultSet resultSet1 = statement1.executeQuery("SELECT * FROM yslygi");
        ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM yslygi");
        int i = 0;

        while(resultSet1.next())
        {
            i++;
        }
        String[][] k = new String[i][4];
        int j = 0;

        while(resultSet2.next())
        {
            k[j][0] = resultSet2.getString(1);
            k[j][1] = resultSet2.getString(2);
            k[j][2] = resultSet2.getString(3);
            k[j][3] = resultSet2.getString(4);
            j++;
        }

        JTable table = new JTable(k, colname);

        table.setGridColor(Color.blue);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(1,1,400,200);
        frame.add(scrollPane);

        JLabel label = new JLabel();
        label.setBounds(1, 100,500,50);
        frame.add(label);

        table.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                label.setText(table.getValueAt(row,0)+ " " + table.getValueAt(row,1) + " " + table.getValueAt(row,2) + " " + table.getValueAt(row,3));
                System.out.println(row);
            }

        });



        Connect.getConnection().close();

        frame.setVisible(true);
        frame.setLayout(null);

    }
}
