package hospital.management.system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textField;
    JTextField jPasswordField;
    JButton b1, b2;

    Login() {
        this.setResizable(false);
        this.setTitle("Shourya Hospital - Modern Healthcare Management");
        ImageIcon icon = new ImageIcon("src/Icons/cross.png");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Modern gradient background panel
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                
                // Create gradient background
                GradientPaint gradient = new GradientPaint(0, 0, new Color(41, 128, 185), getWidth(), getHeight(), new Color(44, 62, 80));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
        mainPanel.setLayout(null);
        setContentPane(mainPanel);

        // Create modern card panel for login form
        JPanel loginCard = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Create rounded rectangle with shadow effect
                g2d.setColor(new Color(255, 255, 255, 240));
                g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 20, 20));
                g2d.dispose();
            }
        };
        loginCard.setLayout(null);
        loginCard.setBounds(50, 50, 350, 400);
        loginCard.setOpaque(false);
        mainPanel.add(loginCard);

        // Hospital title
        JLabel titleLabel = new JLabel("SHOURYA HOSPITAL");
        titleLabel.setBounds(25, 30, 300, 40);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(41, 128, 185));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginCard.add(titleLabel);

        // Subtitle
        JLabel subtitleLabel = new JLabel("Healthcare Management System");
        subtitleLabel.setBounds(25, 70, 300, 25);
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitleLabel.setForeground(new Color(127, 140, 141));
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginCard.add(subtitleLabel);

        // Username section
        JLabel nameLabel = new JLabel("Username");
        nameLabel.setBounds(25, 130, 300, 25);
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        nameLabel.setForeground(new Color(52, 73, 94));
        loginCard.add(nameLabel);

        textField = new JTextField();
        textField.setBounds(25, 155, 300, 40);
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textField.setForeground(new Color(52, 73, 94));
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        textField.setBackground(new Color(248, 249, 250));
        loginCard.add(textField);

        // Password section
        JLabel password = new JLabel("Password");
        password.setBounds(25, 210, 300, 25);
        password.setFont(new Font("Segoe UI", Font.BOLD, 14));
        password.setForeground(new Color(52, 73, 94));
        loginCard.add(password);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(25, 235, 300, 40);
        jPasswordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jPasswordField.setForeground(new Color(52, 73, 94));
        jPasswordField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        jPasswordField.setBackground(new Color(248, 249, 250));
        loginCard.add(jPasswordField);

        // Modern buttons
        b1 = new JButton("Login");
        b1.setBounds(25, 300, 140, 45);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(46, 204, 113));
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.setFocusPainted(false);
        b1.addActionListener(this);
        loginCard.add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(185, 300, 140, 45);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(231, 76, 60));
        b2.setBorder(BorderFactory.createEmptyBorder());
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.setFocusPainted(false);
        b2.addActionListener(this);
        loginCard.add(b2);

        // Image panel on the right
        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Create rounded rectangle for image
                g2d.setColor(new Color(255, 255, 255, 240));
                g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 20, 20));
                g2d.dispose();
            }
        };
        imagePanel.setLayout(null);
        imagePanel.setBounds(450, 50, 300, 400);
        imagePanel.setOpaque(false);
        mainPanel.add(imagePanel);

        // Load and display image
        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("Icons/baby.png"));
        Image i1 = imageicon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon imageicon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageicon1);
        label.setBounds(25, 75, 250, 250);
        imagePanel.add(label);

        // Welcome text on image panel
        JLabel welcomeLabel = new JLabel("Welcome to");
        welcomeLabel.setBounds(25, 20, 250, 30);
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        welcomeLabel.setForeground(new Color(41, 128, 185));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imagePanel.add(welcomeLabel);

        JLabel hospitalLabel = new JLabel("Modern Healthcare");
        hospitalLabel.setBounds(25, 45, 250, 30);
        hospitalLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        hospitalLabel.setForeground(new Color(46, 204, 113));
        hospitalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imagePanel.add(hospitalLabel);

        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            try{
                connect c = new connect();
                String user = textField.getText();
                String pass = jPasswordField.getText();

                String q = "select *  from login where username ='"+user+"' and password = '"+pass+"' ";
                ResultSet resultSet = c.statement.executeQuery(q);

                if(resultSet.next()){
                    new Reception();
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "Wrong Username or Password");
                }

            }catch(Exception E){
                E.printStackTrace();
            }

        }else {
            System.exit(10);
        }
    }
}
