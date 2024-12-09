<div style="border: 2px solid #4CAF50; padding: 10px; border-radius: 5px; background-color: #333; color: #fff;">
# 🌌 **NeuroWave Capstone Project** 🌌


    <div style="font-size: 18px;">

**NeuroWave** is an innovative gamified learning platform that combines 
🎮 education, 🤖 artificial intelligence, and 🌟 immersive storytelling 
to redefine how we learn and grow. 

This project serves as the foundation for building a scalable, interactive 
learning environment where users can engage with AI companions and develop 
real-world tech skills.

---

## 🌟 **Project Purpose**
This project aims to:
1. 🚀 Announce and showcase the NeuroWave platform.
   2. 💼 Attract investors, collaborators, and early adopters.
   3. 🌐 Build a community of learners, players, and AI enthusiasts.
   4. 🎲 Lay the groundwork for the NeuroWave gamified learning system.
   5. 🎓 Serve as the Capstone Project for the Java Developer Certification.

---

## 🎮 **Features**
### 🔥 Current Features:
- **🏠 Home Page (`index.html`)**:
  - Introduces the NeuroWave platform and its mission.
  - Highlights the problems NeuroWave aims to solve and how it works.
  - Includes a call-to-action for user engagement.
  - **🛠️ Adventures Page (`adventures.html`)**:
    - Placeholder for GitHub App integration.
    - Users can embark on learning adventures with AI functionality planned for future iterations.
  - **💸 Investors Page (`investors.html`)**:
    - Allows potential investors to explore investment opportunities.
    - Includes a form to gather investor details and display investment perks dynamically.
  - **📬 Newsletter Page (`newsletter.html`)**:
    - Placeholder for user subscription to updates and newsletters.

### 🔮 Planned Features:
- 🔑 GitHub OAuth integration for user authentication on the Adventures page.
  - 🗄️ Database connection for storing user data (e.g., newsletters, investments).
  - 🧠 A robust back-end powered by Spring Boot and JPA for data handling.
  - 📖 Expanded lore and storytelling for immersive user engagement.

---



## 🗂️ **Project Structure**
### **Directory Overview**
```plaintext
NeuroWave-CAP312/
├── 📁 docs/                           # Project documentation
│   ├── 🧩 architecture.md             # Architecture design and system overview
│   ├── 🕒 changelog.md                # Record of changes and updates
│   ├── 🔗 resources.md                # References to tools, libraries, and materials
│   ├── 🛤️ roadmap.md                  # Timeline and milestones
│   ├── 🗺️ site-map.md                 # Sitemap for the website
│   └── 📋 todo.md                     # To-do list and feature tracking
├── 📂 src/
│   ├── java/
│   │   └── com.norstarphoenix.neuro_wave/
│   │       ├── ⚙️ config/              # Application configuration classes
│   │       ├── 📡 controller/          # HTTP request handling
│   │       ├── ❗ exception/           # Custom exception handling
│   │       ├── 📊 model/               # Data models/entities
│   │       ├── 📚 repository/          # Data access layers
│   │       └── 🧠 service/             # Business logic
│   ├── 📁 resources/
│   │   ├── 🎨 static/                  # Static assets (CSS, JS, images)
│   │   ├── 🖋️ templates/               # HTML templates for Thymeleaf
│   │   ├── 🛠️ application.properties   # Configuration file
│   │   └── 📜 schema.sql               # Database schema
├── 🧪 test/
│   ├── java/
│   │   └── com.norstarphoenix.neuro_wave/
│   │       ├── 🧪 controller/          # Controller tests
│   │       ├── 🧪 repository/          # Repository tests
│   │       └── 🧪 service/             # Service tests
├── 🔐 .env                             # Environment variables for sensitive data
├── ⚙️ pom.xml                          # Maven configuration
└── 📖 README.md                        # Project documentation
```


## 🛠️ **Technologies Used**

⚙️ Back-End:
🧩 Spring Boot: REST API and back-end logic.
🗄️ Spring Data JPA: ORM for database interaction.
🛢️ MySQL: Relational database for data persistence.

🌐 Front-End:
🎨 HTML5, CSS3, JavaScript: Core web technologies.
🖋️ Thymeleaf: Dynamic HTML rendering.

🛠️ Tools:
⚡ Lombok: Reduce boilerplate Java code.
🔒 Dotenv: Secure environment variable management.
🔧 Maven: Dependency management and build tool.


# 🧑‍💻**Setup Instructions**
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/norstar66/NeuroWave-CAP312.git
   cd NeuroWave-CAP312 
   ```
   
2. **Configure Environment Variables**:

   - Create a `.env` file with the following keys:

     ```markdown
       DB_URL=jdbc:mysql://localhost:3306/neurowave
       DB_USERNAME=root
       DB_PASSWORD=yourpassword
       GITHUB_CLIENT_ID=your-client-id
       GITHUB_CLIENT_SECRET=your-client-secret
     ```
  

3. **Run the Application**:

   - **Use Maven to start the Spring Boot server**:
     ```bash
       mvn spring-boot:run  
     ```  

   4. Access the Application:
   - Navigate to http://localhost:8080 in your browser.

    </div>
</div>

---

🚀 Resolving MySQL Dependency Issues
🛑 Problem
While configuring the mysql-connector-java dependency in pom.xml, the artifact was not resolving correctly due to a change in Maven artifact coordinates.

✅ Solution
The correct dependency coordinates for the latest stable version are as follows:

```xml
<dependency>
    <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
    <version>8.1.0</version>
</dependency>
```

📝 Key Steps
🔍 Identify the Issue:

Error logs showed the dependency mysql:mysql-connector-java was missing.
Research revealed the artifact had been moved to com.mysql.
🔧 Correct the Dependency:

Updated the pom.xml with the new group ID and artifact ID.
🛠 Verify Settings:

Ensured settings.xml was configured correctly, with no proxy or mirror blocking access to Maven Central.
🔄 Rebuild the Project:

Used the following commands to refresh and rebuild:
```bash
mvn clean install
mvn dependency:purge-local-repository
mvn dependency:resolve
```
🎉 Success:

The issue was resolved, and the application successfully connected to MySQL.
💡 Lessons Learned
💡 Always check for updated dependency coordinates when an artifact fails to resolve.
🌐 The Maven Repository website (mvnrepository.com) is an excellent resource for verifying dependencies.
🛡 Keeping your settings.xml file correctly configured is crucial to avoid unnecessary issues.
💡 Pro Tip
Documenting your fixes not only helps you in the future but also makes your project README much more valuable for collaborators! 🙌