package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import java.util.Date;

public class NewPatient extends JFrame implements ActionListener {
    JComboBox comboBox;
    JTextField textField, textFieldName, textFieldAge, textFieldDisease, textFieldDeposit;
    JRadioButton r1, r2;
    Choice c1;
    JLabel labeltitle, labelID, labelName, labels, labelAge, labelblood, date;
    JButton btn1, btn2;

    NewPatient() {
        this.setResizable(false);
        this.setTitle("Shourya Hospital - Add New Patient");
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
        formPanel.setBounds(20, 20, 500, 580);
        formPanel.setOpaque(false);
        mainPanel.add(formPanel);

        // Title
        JLabel labeltitle = new JLabel("NEW PATIENT FORM");
        labeltitle.setBounds(50, 20, 400, 40);
        labeltitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        labeltitle.setForeground(new Color(41, 128, 185));
        labeltitle.setHorizontalAlignment(SwingConstants.CENTER);
        formPanel.add(labeltitle);

        // Form fields
        int yPos = 80;
        int fieldWidth = 200;
        int fieldHeight = 35;

        // ID
        JLabel labelID = new JLabel("ID:");
        labelID.setBounds(50, yPos, 150, 25);
        labelID.setFont(new Font("Segoe UI", Font.BOLD, 14));
        labelID.setForeground(new Color(52, 73, 94));
        formPanel.add(labelID);

        textField = createModernTextField(220, yPos, fieldWidth, fieldHeight);
        formPanel.add(textField);

        // Name
        yPos += 50;
        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(50, yPos, 150, 25);
        labelName.setFont(new Font("Segoe UI", Font.BOLD, 14));
        labelName.setForeground(new Color(52, 73, 94));
        formPanel.add(labelName);

        textFieldName = createModernTextField(220, yPos, fieldWidth, fieldHeight);
        formPanel.add(textFieldName);

        // Gender
        yPos += 50;
        JLabel labels = new JLabel("Gender:");
        labels.setBounds(50, yPos, 150, 25);
        labels.setFont(new Font("Segoe UI", Font.BOLD, 14));
        labels.setForeground(new Color(52, 73, 94));
        formPanel.add(labels);

        r1 = createModernRadioButton("Male", 220, yPos);
        formPanel.add(r1);

        r2 = createModernRadioButton("Female", 320, yPos);
        formPanel.add(r2);

        // Age
        yPos += 50;
        JLabel labelAge = new JLabel("Age:");
        labelAge.setBounds(50, yPos, 150, 25);
        labelAge.setFont(new Font("Segoe UI", Font.BOLD, 14));
        labelAge.setForeground(new Color(52, 73, 94));
        formPanel.add(labelAge);

        textFieldAge = createModernTextField(220, yPos, fieldWidth, fieldHeight);
        formPanel.add(textFieldAge);

        // Disease
        yPos += 50;
        JLabel labeldisease = new JLabel("Disease:");
        labeldisease.setBounds(50, yPos, 150, 25);
        labeldisease.setFont(new Font("Segoe UI", Font.BOLD, 14));
        labeldisease.setForeground(new Color(52, 73, 94));
        formPanel.add(labeldisease);

        textFieldDisease = createModernTextField(220, yPos, fieldWidth, fieldHeight);
        formPanel.add(textFieldDisease);

        // Blood Group
        yPos += 50;
        JLabel labelblood = new JLabel("Blood Group:");
        labelblood.setBounds(50, yPos, 150, 25);
        labelblood.setFont(new Font("Segoe UI", Font.BOLD, 14));
        labelblood.setForeground(new Color(52, 73, 94));
        formPanel.add(labelblood);

        comboBox = new JComboBox(new String[]{"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"});
        comboBox.setBounds(220, yPos, fieldWidth, fieldHeight);
        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboBox.setForeground(new Color(52, 73, 94));
        comboBox.setBackground(new Color(248, 249, 250));
        comboBox.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        formPanel.add(comboBox);

        // Room
        yPos += 50;
        JLabel labelroom = new JLabel("Room:");
        labelroom.setBounds(50, yPos, 150, 25);
        labelroom.setFont(new Font("Segoe UI", Font.BOLD, 14));
        labelroom.setForeground(new Color(52, 73, 94));
        formPanel.add(labelroom);

        c1 = new Choice();
        try {
            connect c = new connect();
            ResultSet resultSet = c.statement.executeQuery("select * from room where Availability = 'Available'");
            while (resultSet.next()) {
                c1.addItem(resultSet.getString("Room_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        c1.setBounds(220, yPos, fieldWidth, fieldHeight);
        c1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        c1.setForeground(new Color(52, 73, 94));
        c1.setBackground(new Color(248, 249, 250));
        formPanel.add(c1);

        // Time
        yPos += 50;
        JLabel labelDate = new JLabel("Time:");
        labelDate.setBounds(50, yPos, 150, 25);
        labelDate.setFont(new Font("Segoe UI", Font.BOLD, 14));
        labelDate.setForeground(new Color(52, 73, 94));
        formPanel.add(labelDate);

        Date date1 = new Date();
        date = new JLabel("" + date1);
        date.setBounds(220, yPos, fieldWidth, 25);
        date.setForeground(new Color(52, 73, 94));
        date.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(date);

        // Deposit
        yPos += 50;
        JLabel labelDeposit = new JLabel("Deposit:");
        labelDeposit.setBounds(50, yPos, 150, 25);
        labelDeposit.setFont(new Font("Segoe UI", Font.BOLD, 14));
        labelDeposit.setForeground(new Color(52, 73, 94));
        formPanel.add(labelDeposit);

        textFieldDeposit = createModernTextField(220, yPos, fieldWidth, fieldHeight);
        formPanel.add(textFieldDeposit);

        // Buttons - moved down and properly positioned
        yPos += 80;
        btn1 = createModernButton("ADD", 100, yPos, 120, 40, new Color(46, 204, 113));
        formPanel.add(btn1);

        btn2 = createModernButton("BACK", 250, yPos, 120, 40, new Color(231, 76, 60));
        formPanel.add(btn2);

        // Image panel - adjusted height
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
        imagePanel.setBounds(540, 20, 300, 580);
        imagePanel.setOpaque(false);
        mainPanel.add(imagePanel);

        ImageIcon icon1 = new ImageIcon("src/Icons/pat.jpeg");
        Image image = icon1.getImage().getScaledInstance(250, 450, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(image);
        JLabel label = new JLabel(icon2);
        label.setBounds(25, 50, 250, 450);
        imagePanel.add(label);

        setUndecorated(true);
        setSize(870, 620);
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

    // Helper method to create modern radio buttons
    private JRadioButton createModernRadioButton(String text, int x, int y) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setBounds(x, y, 80, 25);
        radioButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        radioButton.setForeground(new Color(52, 73, 94));
        radioButton.setBackground(new Color(255, 255, 255, 0));
        radioButton.setOpaque(false);
        return radioButton;
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
        button.addActionListener(this);
        
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            connect c = new connect();
            String radioBTN = null;
            if (r1.isSelected()) {
                radioBTN = "Male";
            } else if (r2.isSelected()) {
                radioBTN = "Female";
            }
            String id = textField.getText();
            String name = textFieldName.getText();
            String gender = radioBTN;
            String age = textFieldAge.getText();
            String disease = textFieldDisease.getText();
            String blood = (String) comboBox.getSelectedItem();
            String room = (String) c1.getSelectedItem();
            String Date = date.getText();
            String Deposit = textFieldDeposit.getText();

            try {
                String q = "insert into patient_info values ('" + id + "','" + name + "', '" + gender + "' , '" + age + "', '" + disease + "', '" + blood + "', '" + room + "' , '" + Date + "', '" + Deposit + "') ";
                String q1 = "update room set Availability = 'Occupied' where Room_no = " + room;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Patient Added Successfully");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NewPatient();
    }
}