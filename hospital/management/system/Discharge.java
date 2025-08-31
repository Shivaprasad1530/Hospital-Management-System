package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import java.util.Date;

public class Discharge extends JFrame {
    JTextField textField;
    
    Discharge(){
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
        formPanel.setBounds(20, 20, 760, 360);
        formPanel.setOpaque(false);
        mainPanel.add(formPanel);

        // Title
        JLabel label = new JLabel("PATIENT DISCHARGE");
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label.setBounds(50, 20, 400, 30);
        label.setForeground(new Color(41, 128, 185));
        formPanel.add(label);

        // Form fields
        int yPos = 70;
        int fieldWidth = 200;
        int fieldHeight = 35;

        // ID
        JLabel label2 = new JLabel("Patient ID:");
        label2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label2.setBounds(50, yPos, 150, 25);
        label2.setForeground(new Color(52, 73, 94));
        formPanel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(220, yPos, fieldWidth, fieldHeight);
        choice.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        choice.setForeground(new Color(52, 73, 94));
        choice.setBackground(new Color(248, 249, 250));
        formPanel.add(choice);

        try{
            connect c = new connect();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("ID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Check button
        JButton check = createModernButton("Check", 450, yPos, 100, 35, new Color(52, 152, 219));
        formPanel.add(check);

        // Room No
        yPos += 50;
        JLabel label3 = new JLabel("Room No:");
        label3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label3.setBounds(50, yPos, 150, 25);
        label3.setForeground(new Color(52, 73, 94));
        formPanel.add(label3);

        JLabel RN = new JLabel();
        RN.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        RN.setBounds(220, yPos, fieldWidth, 25);
        RN.setForeground(new Color(52, 73, 94));
        formPanel.add(RN);

        // In Time
        yPos += 50;
        JLabel label4 = new JLabel("In Time:");
        label4.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label4.setBounds(50, yPos, 150, 25);
        label4.setForeground(new Color(52, 73, 94));
        formPanel.add(label4);

        JLabel IN = new JLabel();
        IN.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        IN.setBounds(220, yPos, fieldWidth, 25);
        IN.setForeground(new Color(52, 73, 94));
        formPanel.add(IN);

        // Out Time
        yPos += 50;
        JLabel label5 = new JLabel("Out Time:");
        label5.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label5.setBounds(50, yPos, 150, 25);
        label5.setForeground(new Color(52, 73, 94));
        formPanel.add(label5);

        Date date = new Date();
        JLabel OUT = new JLabel("" + date);
        OUT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        OUT.setBounds(220, yPos, fieldWidth, 25);
        OUT.setForeground(new Color(52, 73, 94));
        formPanel.add(OUT);

        // Buttons
        yPos += 60;
        JButton btn = createModernButton("Discharge", 150, yPos, 120, 40, new Color(231, 76, 60));
        formPanel.add(btn);

        JButton backBtn = createModernButton("Back", 300, yPos, 120, 40, new Color(149, 165, 166));
        formPanel.add(backBtn);

        // Action listeners
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connect c = new connect();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from patient_info where ID = '"+choice.getSelectedItem()+"' ");
                    while(resultSet.next()){
                        RN.setText(resultSet.getString("Room"));
                        IN.setText(resultSet.getString("Date"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connect c = new connect();
                try {
                    c.statement.executeUpdate("delete from patient_info where ID = '" + choice.getSelectedItem() + "' ");
                    c.statement.executeUpdate("update room set Availability = 'Available' where Room_no = '"+RN.getText()+"'");
                    JOptionPane.showMessageDialog(null, "Discharge Successful");
                    setVisible(false);
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
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
        new Discharge();
    }
}
