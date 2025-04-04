# FeedbackHub_Using_JavaServlet
MiniProject

# 📝 Online Feedback System

This is a **Java-based Dynamic Web Project** for an **Online Feedback System**, built using **JSP/Servlets** and **MySQL**. It enables students to submit feedback and allows administrators to manage and view results.

---

## 📁 Project Overview

- **Frontend**: HTML, CSS (e.g., `index.html`, `register.html`, `UserLogin.html`, `AdminLogin.html`)
- **Backend**: Java Servlets (e.g., `AdminLoginServlet`, `userLoginServlet`, `UserRegisterServlet`)
- **Database**: MySQL (accessed through DAO classes like `AdminDAO`, `FeedbackDAO`)
- **Server**: Apache Tomcat
- **IDE**: Eclipse (Dynamic Web Project)

---

## 🚀 Features

- 👨‍🎓 Student Registration and Login
- 🧑‍🏫 Admin Login Panel
- ✅ Submit Feedback
- 📊 Feedback Management
- 🔒 Session Handling
- 🗃️ Database Operations via JDBC

---

## 📦 Folder Structure

OnlineFeedbackSystem/
├── build/classes/               # Compiled .class files
│   ├── AdminDAO.class
│   └── FeedbackDAO.class
├── src/main/java/              # Java source files
│   ├── AdminLoginServlet.java
│   ├── UserLoginServlet.java
│   └── UserRegisterServlet.java
├── src/main/webapp/            # Web resources
│   ├── index.html
│   ├── register.html
│   ├── AdminLogin.html
│   ├── UserLogin.html
│   ├── style.css
│   └── WEB-INF/
│       └── web.xml             # Deployment descriptor
├── .classpath
├── .project
└── .settings/                  # Eclipse settings



---

## 🛠️ Setup Instructions

### ✅ Requirements

- **JDK 8 or higher**
- **Eclipse IDE for Enterprise Java Developers**
- **Apache Tomcat 9.x**
- **MySQL Server**

---

### 📥 Installation Steps

1. **Import Project in Eclipse**  
   - `File → Import → General → Existing Projects into Workspace`
   - Choose the extracted folder.

2. **Configure Apache Tomcat**  
   - In Eclipse, go to **Servers** tab → Add Tomcat 9.x
   - Right-click your project → `Run As → Run on Server`

3. **Database Setup**  
   - Create a new database, e.g., `feedback_system`
   - Create required tables (structure likely defined in the DAO classes)
   - Update DB credentials inside Java DAO classes if needed

4. **Run the Application**  
   - Visit: `http://localhost:8080/OnlineFeedbackSystem` (adjust based on project name)

---

## ✨ Key Java Classes

- **`AdminLoginServlet.java`** - Handles admin authentication
- **`userLoginServlet.java`** - Processes student login
- **`UserRegisterServlet.java`** - Manages student registration
- **`AdminDAO.java`** - Handles database logic for admin actions
- **`FeedbackDAO.java`** - Stores and retrieves feedback

---

## 🙋‍♂️ Author

- **Your Name**
- GitHub: [@vinayakBhandare14](https://github.com/vinayakBhandare14)

