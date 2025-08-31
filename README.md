# 🏥 Hospital Management System

A comprehensive **Java Swing-based Hospital Management System** designed to streamline hospital operations with a modern, aesthetic GUI. This application provides a complete solution for managing patients, staff, rooms, departments, and ambulance services through an intuitive user interface built with Object-Oriented Programming principles.

## 📋 Project Overview

This Hospital Management System is a desktop application developed using **Java Swing** and **MySQL** database, featuring a modern gradient-based GUI with card layouts, custom styling, and responsive design. The system follows Object-Oriented Programming concepts and provides a complete hospital management solution with secure authentication, patient management, staff administration, room allocation, and emergency services coordination.

## ✨ Key Features

### 🔐 **Authentication & Security**
- **Secure Login System**: Username and password authentication
- **Session Management**: Proper user session handling
- **Logout Functionality**: Secure session termination

### 👥 **Patient Management**
- **New Patient Registration**: Complete patient information entry with form validation
- **Patient Information Display**: Comprehensive patient database with searchable records
- **Patient Details Update**: Modify existing patient information
- **Patient Discharge**: Process patient discharge with proper documentation

### 🏢 **Hospital Infrastructure Management**
- **Room Management**: Track room availability, pricing, and room types (General, Private, ICU)
- **Department Information**: Complete department directory with contact details
- **Staff Management**: Comprehensive staff database with roles and departments

### 🚑 **Emergency Services**
- **Ambulance Management**: Track ambulance availability, drivers, and contact information
- **Emergency Coordination**: Quick access to emergency service details

### 🎨 **Modern User Interface**
- **Gradient Backgrounds**: Beautiful blue gradient theme throughout the application
- **Card-Based Layout**: Modern card-style panels with rounded corners
- **Custom Styling**: Modern buttons with hover effects and smooth animations
- **Responsive Tables**: Enhanced table displays with alternating row colors
- **Professional Typography**: Segoe UI font for better readability

## 🛠️ Technology Stack

- **Frontend**: Java Swing (GUI Framework)
- **Backend**: Java (Core Programming)
- **Database**: MySQL
- **Database Connectivity**: JDBC (Java Database Connectivity)
- **External Libraries**: 
  - `net.proteanit.sql.DbUtils` (for table data binding)
- **Design Patterns**: Object-Oriented Programming (OOP)

## 📁 Project Structure

```
Hospital Management System/
├── src/
│   └── hospital/
│       └── management/
│           └── system/
│               ├── Login.java              # Authentication screen
│               ├── Reception.java          # Main dashboard
│               ├── NewPatient.java         # Patient registration
│               ├── PatientInfo.java        # Patient information display
│               ├── UpdatePatient.java      # Patient details update
│               ├── Discharge.java          # Patient discharge
│               ├── Room.java              # Room management
│               ├── Department.java         # Department information
│               ├── Staff.java             # Staff management
│               ├── Ambulance.java         # Ambulance services
│               ├── connect.java           # Database connection
│               └── SQL.txt                # Database schema
├── Icons/                                 # Application icons
└── README.md                             # Project documentation
```

## 🚀 Installation & Setup

### Prerequisites

1. **Java Development Kit (JDK) 8 or higher**
2. **MySQL Server 5.7 or higher**
3. **MySQL Connector/J (JDBC Driver)**
4. **IDE** (Eclipse, IntelliJ IDEA, or NetBeans)

### Step 1: Database Setup

1. **Install MySQL Server** on your system
2. **Open MySQL Workbench** or MySQL Command Line Client
3. **Copy and execute** the SQL commands from `src/hospital/management/system/SQL.txt`:

```sql
create database hospital_management_system;
use hospital_management_system;

-- Execute all the CREATE TABLE and INSERT statements from SQL.txt
```

### Step 2: Database Connection Configuration

1. **Open** `src/hospital/management/system/connect.java`
2. **Update** the database connection details:

```java
connection = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/hospital_management_system",
    "root", 
    "your_mysql_password"  // Replace with your actual MySQL password
);
```

### Step 3: Add Required Libraries

1. **Download** `rs2xml.jar` (for DbUtils functionality)
2. **Add to project classpath**:
   - **Eclipse**: Right-click project → Properties → Java Build Path → Libraries → Add External JARs
   - **IntelliJ**: File → Project Structure → Libraries → + → Java → Select JAR file
   - **NetBeans**: Right-click project → Properties → Libraries → Add JAR/Folder

### Step 4: Run the Application

1. **Compile** all Java files
2. **Run** `Login.java` as the main entry point:

```bash
javac -cp ".:rs2xml.jar" src/hospital/management/system/*.java
java -cp ".:rs2xml.jar:src" hospital.management.system.Login
```

## 🔧 Default Login Credentials

The system comes with pre-configured login credentials:

| Username | Password |
|----------|----------|
| `Username` | `Password` |
| `Harry` | `1234` |

**Note**: You can modify these credentials in the `login` table of the database.

## 📖 Usage Guide

### 1. **Login Screen**
- Enter username and password
- Click "Login" to access the system
- Click "Cancel" to exit

### 2. **Main Dashboard (Reception)**
- **New Patient**: Register new patients
- **Patient Information**: View all patient records
- **Update Patient Details**: Modify existing patient information
- **Patient Discharge**: Process patient discharge
- **Room List**: View room availability and pricing
- **Department**: Access department information
- **Staff Info**: View staff directory
- **Hospital Ambulance**: Check ambulance availability
- **Logout**: Exit the system

### 3. **Patient Registration**
- Fill in patient details (Name, Gender, Age, Disease, Blood Group, Room, Date, Deposit)
- Click "ADD" to save patient information
- Click "BACK" to return to main dashboard

### 4. **Patient Management**
- **View Records**: Browse complete patient database
- **Update Information**: Modify patient details
- **Discharge Process**: Complete patient discharge procedures

### 5. **Hospital Services**
- **Room Management**: Check room availability and pricing
- **Department Directory**: Access department contact information
- **Staff Directory**: View staff details and contact information
- **Ambulance Services**: Check emergency vehicle availability

## 🎨 GUI Features

### **Modern Design Elements**
- **Gradient Backgrounds**: Beautiful blue gradient theme
- **Card Layouts**: Modern card-style panels with rounded corners
- **Custom Buttons**: Styled buttons with hover effects
- **Enhanced Tables**: Professional table styling with alternating colors
- **Responsive Design**: Optimized for different screen sizes

### **User Experience**
- **Intuitive Navigation**: Easy-to-use interface
- **Visual Feedback**: Hover effects and button animations
- **Professional Appearance**: Clean, modern design
- **Accessibility**: Clear typography and color contrast

## 🔒 Security Features

- **Password Protection**: Secure login system
- **Session Management**: Proper user session handling
- **Data Validation**: Input validation for all forms
- **Database Security**: Prepared statements and connection management

## 📊 Database Schema

The system uses the following database tables:

- **`login`**: User authentication credentials
- **`patient_info`**: Patient records and medical information
- **`room`**: Room availability and pricing
- **`department`**: Department information and contacts
- **`staff`**: Staff directory with roles and departments
- **`ambulance`**: Emergency vehicle information

## 🐛 Troubleshooting

### Common Issues

1. **Database Connection Error**
   - Verify MySQL server is running
   - Check database credentials in `connect.java`
   - Ensure database and tables are created

2. **Class Not Found Error**
   - Verify `rs2xml.jar` is added to classpath
   - Check all required libraries are included

3. **GUI Display Issues**
   - Ensure Java version compatibility
   - Check system display settings

### Error Resolution

- **Import Errors**: Add missing JAR files to classpath
- **Connection Issues**: Verify MySQL service status and credentials
- **Compilation Errors**: Check Java version compatibility

## 🤝 Contributing

1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/AmazingFeature`)
3. **Commit** your changes (`git commit -m 'Add some AmazingFeature'`)
4. **Push** to the branch (`git push origin feature/AmazingFeature`)
5. **Open** a Pull Request

## 📝 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Your Name**
- GitHub: [@yourusername](https://github.com/yourusername)
- Email: your.email@example.com

## 🙏 Acknowledgments

- **Java Swing** for the GUI framework
- **MySQL** for database management
- **JDBC** for database connectivity
- **Object-Oriented Programming** principles for clean code structure



---

**⭐ Star this repository if you find it helpful!**

**🏥 Built with ❤️ for better hospital management**
