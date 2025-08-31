package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class Reception extends JFrame {
    Reception() {
        this.setTitle("Shourya Hospital - Modern Healthcare Management System");
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

        // Header panel with modern design
        JPanel headerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Create rounded rectangle with shadow effect
                g2d.setColor(new Color(255, 255, 255, 250));
                g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 15, 15));
                g2d.dispose();
            }
        };
        headerPanel.setLayout(null);
        headerPanel.setBounds(20, 20, 1880, 120);
        headerPanel.setOpaque(false);
        mainPanel.add(headerPanel);

        // Hospital title in header
        JLabel titleLabel = new JLabel("SHOURYA HOSPITAL");
        titleLabel.setBounds(30, 20, 400, 40);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(new Color(41, 128, 185));
        headerPanel.add(titleLabel);

        JLabel subtitleLabel = new JLabel("Healthcare Management System");
        subtitleLabel.setBounds(30, 60, 400, 25);
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        subtitleLabel.setForeground(new Color(127, 140, 141));
        headerPanel.add(subtitleLabel);

        // Images in header
        ImageIcon i1 = new ImageIcon("src/Icons/doc.png");
        Image image = i1.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(1750, 20, 80, 80);
        headerPanel.add(label);

        ImageIcon i11 = new ImageIcon("src/Icons/logo.png");
        Image image1 = i11.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon i22 = new ImageIcon(image1);
        JLabel label1 = new JLabel(i22);
        label1.setBounds(1650, 20, 80, 80);
        headerPanel.add(label1);

        // Main content panel
        JPanel contentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Create rounded rectangle with shadow effect
                g2d.setColor(new Color(255, 255, 255, 250));
                g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 15, 15));
                g2d.dispose();
            }
        };
        contentPanel.setLayout(null);
        contentPanel.setBounds(20, 160, 1880, 900);
        contentPanel.setOpaque(false);
        mainPanel.add(contentPanel);

        // Create modern buttons with hover effects
        JButton btn1 = createModernButton("Add Patient", 30, 30, 250, 50, new Color(46, 204, 113));
        contentPanel.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewPatient();
            }
        });

        JButton btn2 = createModernButton("Rooms List", 310, 30, 250, 50, new Color(52, 152, 219));
        contentPanel.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });

        JButton btn3 = createModernButton("Department", 590, 30, 250, 50, new Color(155, 89, 182));
        contentPanel.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();
            }
        });

        JButton btn4 = createModernButton("Staff Info", 870, 30, 250, 50, new Color(230, 126, 34));
        contentPanel.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Staff();
            }
        });

        JButton btn5 = createModernButton("Patient Info", 1150, 30, 250, 50, new Color(231, 76, 60));
        contentPanel.add(btn5);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PatientInfo();
            }
        });

        JButton btn6 = createModernButton("Patient Discharge", 590, 100, 250, 50, new Color(149, 165, 166));
        contentPanel.add(btn6);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Discharge();
            }
        });

        JButton btn7 = createModernButton("Update Patient Details", 870, 100, 250, 50, new Color(26, 188, 156));
        contentPanel.add(btn7);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdatePatient();
            }
        });

        JButton btn8 = createModernButton("Hospital Ambulance", 1150, 100, 250, 50, new Color(241, 196, 15));
        contentPanel.add(btn8);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ambulance();
            }
        });

        // Logout button moved to top left corner
        JButton btn10 = createModernButton("LOG OUT", 30, 170, 120, 40, new Color(192, 57, 43));
        contentPanel.add(btn10);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add some decorative elements
        addDecorativeElements(contentPanel);

        setSize(1920, 1080);
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

    // Helper method to add decorative elements
    private void addDecorativeElements(JPanel panel) {
        // Add some decorative text or icons
        JLabel welcomeLabel = new JLabel("Welcome to the Hospital Management System");
        welcomeLabel.setBounds(30, 200, 600, 40);
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        welcomeLabel.setForeground(new Color(52, 73, 94));
        panel.add(welcomeLabel);

        JLabel infoLabel = new JLabel("Select an option from the menu above to manage hospital operations");
        infoLabel.setBounds(30, 240, 800, 30);
        infoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        infoLabel.setForeground(new Color(127, 140, 141));
        panel.add(infoLabel);
    }

    public static void main(String[] args) {
        new Reception();
    }
}
