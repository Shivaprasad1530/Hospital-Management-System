package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;

public class UpdatePatient extends JFrame {

    UpdatePatient() {
        ImageIcon icon = new ImageIcon("src/Icons/cross.png");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Modern gradient background
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                
                // Create gradient background
                GradientPaint gradient = new GradientPaint(0, 0, new Color(52, 152, 219), getWidth(), getHeight(), new Color(41, 128, 185));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
        mainPanel.setLayout(null);
        setContentPane(mainPanel);

        // Main form panel
        JPanel formPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                g2d.setColor(new Color(255, 255, 255, 250));
                g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 20, 20));
                g2d.dispose();
            }
        };
        formPanel.setLayout(null);
        formPanel.setBounds(20, 20, 500, 500);
        formPanel.setOpaque(false);
        mainPanel.add(formPanel);

        // Title
        JLabel label1 = new JLabel("UPDATE PATIENT DETAILS");
        label1.setBounds(50, 20, 400, 30);
        label1.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label1.setForeground(new Color(41, 128, 185));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        formPanel.add(label1);

        // Form fields
        int yPos = 80;
        int fieldWidth = 200;
        int fieldHeight = 35;

        // ID
        JLabel label2 = new JLabel("Patient ID:");
        label2.setBounds(50, yPos, 150, 25);
        label2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label2.setForeground(new Color(52, 73, 94));
        formPanel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(220, yPos, fieldWidth, fieldHeight);
        choice.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        choice.setForeground(new Color(52, 73, 94));
        choice.setBackground(new Color(248, 249, 250));
        formPanel.add(choice);

        try {
            connect c = new connect();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()) {
                choice.add(resultSet.getString("ID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Room No
        yPos += 50;
        JLabel label3 = new JLabel("Room No:");
        label3.setBounds(50, yPos, 150, 25);
        label3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label3.setForeground(new Color(52, 73, 94));
        formPanel.add(label3);

        JTextField textField = createModernTextField(220, yPos, fieldWidth, fieldHeight);
        formPanel.add(textField);

        // In Time
        yPos += 50;
        JLabel label4 = new JLabel("In Time:");
        label4.setBounds(50, yPos, 150, 25);
        label4.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label4.setForeground(new Color(52, 73, 94));
        formPanel.add(label4);

        JTextField textFieldIN = createModernTextField(220, yPos, fieldWidth, fieldHeight);
        formPanel.add(textFieldIN);

        // Amount Paid
        yPos += 50;
        JLabel label5 = new JLabel("Amount Paid:");
        label5.setBounds(50, yPos, 150, 25);
        label5.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label5.setForeground(new Color(52, 73, 94));
        formPanel.add(label5);

        JTextField textFieldAmount = createModernTextField(220, yPos, fieldWidth, fieldHeight);
        formPanel.add(textFieldAmount);

        // Amount Pending
        yPos += 50;
        JLabel label6 = new JLabel("Amount Pending:");
        label6.setBounds(50, yPos, 150, 25);
        label6.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label6.setForeground(new Color(52, 73, 94));
        formPanel.add(label6);

        JTextField textFieldPending = createModernTextField(220, yPos, fieldWidth, fieldHeight);
        formPanel.add(textFieldPending);

        // Buttons
        yPos += 60;
        JButton update = createModernButton("UPDATE", 50, yPos, 100, 40, new Color(46, 204, 113));
        formPanel.add(update);

        JButton check = createModernButton("CHECK", 170, yPos, 100, 40, new Color(52, 152, 219));
        formPanel.add(check);

        JButton back = createModernButton("BACK", 290, yPos, 100, 40, new Color(231, 76, 60));
        formPanel.add(back);

        // Image panel
        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                g2d.setColor(new Color(255, 255, 255, 250));
                g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 20, 20));
                g2d.dispose();
            }
        };
        imagePanel.setLayout(null);
        imagePanel.setBounds(540, 20, 380, 500);
        imagePanel.setOpaque(false);
        mainPanel.add(imagePanel);

        ImageIcon icon1 = new ImageIcon("src/Icons/update.png");
        Image image = icon1.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(image);
        JLabel label = new JLabel(icon2);
        label.setBounds(40, 100, 300, 300);
        imagePanel.add(label);

        // Action listeners
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from patient_info where ID='" + id + "'";
                try {
                    connect c = new connect();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    String roomNo = "";
                    String deposit = "";
                    
                    while (resultSet.next()) {
                        roomNo = resultSet.getString("Room");
                        textField.setText(roomNo);
                        textFieldIN.setText(resultSet.getString("Date"));
                        deposit = resultSet.getString("Deposit");
                        textFieldAmount.setText(deposit);
                    }

                    ResultSet rs = c.statement.executeQuery("select * from room where Room_no='" + roomNo + "'");

                    while (rs.next()) {
                        String price = rs.getString("Price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                        textFieldPending.setText(("" + amountPaid));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    connect c = new connect();
                    String q = choice.getSelectedItem();
                    String room = textField.getText();
                    String time = textFieldIN.getText();
                    String deposit = textFieldAmount.getText();
                    c.statement.executeUpdate("update patient_info set Room = '"+room+"',Date = '"+time+"', Deposit = '"+deposit+"' where name = '"+q+"'  ");
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(950, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    // Helper method to create modern text fields
    private JTextField createModernTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textField.setForeground(new Color(52, 73, 94));
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        textField.setBackground(new Color(248, 249, 250));
        return textField;
    }

    // Helper method to create modern buttons
    private JButton createModernButton(String text, int x, int y, int width, int height, Color color) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                if (getModel().isPressed()) {
                    g2d.setColor(color.darker());
                } else if (getModel().isRollover()) {
                    g2d.setColor(color.brighter());
                } else {
                    g2d.setColor(color);
                }
                
                g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 10, 10));
                g2d.dispose();
                
                super.paintComponent(g);
            }
        };
        
        button.setBounds(x, y, width, height);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        
        return button;
    }

    public static void main(String[] args) {
        new UpdatePatient();
    }
}
