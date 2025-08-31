package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;

public class PatientInfo extends JFrame {
    JTable table;
    
    PatientInfo(){
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

        // Header panel
        JPanel headerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                g2d.setColor(new Color(255, 255, 255, 250));
                g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 15, 15));
                g2d.dispose();
            }
        };
        headerPanel.setLayout(null);
        headerPanel.setBounds(20, 20, 1460, 80);
        headerPanel.setOpaque(false);
        mainPanel.add(headerPanel);

        // Title
        JLabel titleLabel = new JLabel("PATIENT INFORMATION");
        titleLabel.setBounds(30, 20, 1400, 40);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(new Color(41, 128, 185));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(titleLabel);

        // Content panel for table
        JPanel contentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                g2d.setColor(new Color(255, 255, 255, 250));
                g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 15, 15));
                g2d.dispose();
            }
        };
        contentPanel.setLayout(null);
        contentPanel.setBounds(20, 120, 1060, 450);
        contentPanel.setOpaque(false);
        mainPanel.add(contentPanel);

        // Modern table with scroll pane
        table = new JTable();
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.setGridColor(new Color(189, 195, 199));
        table.setSelectionBackground(new Color(52, 152, 219));
        table.setSelectionForeground(Color.WHITE);
        table.setBackground(new Color(248, 249, 250));
        table.setForeground(new Color(52, 73, 94));
        
        // Create scroll pane for table
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 60, 1000, 300);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 1));
        contentPanel.add(scrollPane);

        // Custom table header renderer
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBackground(new Color(41, 128, 185));
        header.setForeground(Color.WHITE);
        header.setPreferredSize(new Dimension(header.getWidth(), 40));

        // Custom cell renderer
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (isSelected) {
                    c.setBackground(new Color(52, 152, 219));
                    c.setForeground(Color.WHITE);
                } else {
                    if (row % 2 == 0) {
                        c.setBackground(new Color(248, 249, 250));
                    } else {
                        c.setBackground(Color.WHITE);
                    }
                    c.setForeground(new Color(52, 73, 94));
                }
                return c;
            }
        };
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, renderer);

        // Load data
        try {
            connect c = new connect();
            String q = "select * from patient_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            
            // Set column widths after data is loaded
            if (table.getColumnCount() >= 9) {
                table.getColumnModel().getColumn(0).setPreferredWidth(80);  // ID
                table.getColumnModel().getColumn(1).setPreferredWidth(120); // Name
                table.getColumnModel().getColumn(2).setPreferredWidth(80);  // Gender
                table.getColumnModel().getColumn(3).setPreferredWidth(60);  // Age
                table.getColumnModel().getColumn(4).setPreferredWidth(120); // Disease
                table.getColumnModel().getColumn(5).setPreferredWidth(80);  // Blood Group
                table.getColumnModel().getColumn(6).setPreferredWidth(80);  // Room
                table.getColumnModel().getColumn(7).setPreferredWidth(150); // Date
                table.getColumnModel().getColumn(8).setPreferredWidth(100); // Deposit
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Modern back button
        JButton back = createModernButton("BACK", 470, 380, 120, 40, new Color(231, 76, 60));
        contentPanel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1500, 600);
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
        new PatientInfo();
    }
}

