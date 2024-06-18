/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class Lantai1 extends JFrame {
    private JPanel slotPanel;
    private ParkingSlotDAO slotDAO;
    private JLabel floorLabel;
    private JButton backButton;

    public Lantai1() {
        setTitle("Parking Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setLayout(new BorderLayout());
        slotDAO = new ParkingSlotDAO();

        // Initialize the floor label
        floorLabel = new JLabel("Lantai 1", SwingConstants.CENTER);
        floorLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(floorLabel, BorderLayout.NORTH);

        slotPanel = new JPanel(new GridLayout(5, 10));
        add(slotPanel, BorderLayout.CENTER);
        
        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement your back button functionality here
                // For example, you might want to close this window and open another one
                dispose(); // Close the current window
            }
        });
        add(backButton, BorderLayout.SOUTH);
        
        refreshSlots();
    }

    private void refreshSlots() {
        slotPanel.removeAll();
        try {
            List<ParkingSlot> slots = slotDAO.getAllSlots();
            for (ParkingSlot slot : slots) {
                JButton slotButton = new JButton(String.valueOf(slot.getSlotNumber()));
                slotButton.setBackground(slot.isOccupied() ? Color.RED : Color.GREEN);
                slotButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        slot.setOccupied(!slot.isOccupied());
                        try {
                            slotDAO.updateSlot(slot);
                            refreshSlots();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                slotPanel.add(slotButton);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        slotPanel.revalidate();
        slotPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Lantai1().setVisible(true);
            }
        });
    }
}

