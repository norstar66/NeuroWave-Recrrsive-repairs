# Capstone Project Roadmap

---

## Grading:
### Package Structure
- Requirement: Each class should include comments describing the class and its methods.
- Current Status: Comments for some files may be missing.
- Action Needed: Add or review Javadoc-style comments for all classes and methods.
#### Checklist:
- [ ] ✅ Confirm package structure is consistent and complete.
- [ ] 🔄 Review package organization with instructor for approval (optional).

###  Class Comments (2%)
- Requirement: Each class should include comments describing the class and its methods.
- Current Status: Comments for some files may be missing.
- Action Needed: Add or review Javadoc-style comments for all classes and methods.
#### Checklist:
- 🔄 Add comments to all existing classes (brief description of purpose).
- 🔄 Add comments for methods (input, output, and functionality).
- 🔄 Verify consistency of comments across the project.

### GitHub Hosting and README (5%)
- Requirement: Push project to GitHub early and include a detailed README file documenting an overview of the project.
- Current Status: Project is already hosted on GitHub, and a comprehensive README.md is created.
- Action Needed: Keep pushing updates regularly to showcase progress.
#### Checklist:
- ✅ Ensure commits are frequent and meaningful.
- ✅ Verify README.md includes all required sections (done).

###  Standard Java Naming Conventions (3%)
- Requirement: Classes, variables, methods, URLs, files,
- and packages must follow specific naming conventions.

1. Classes (PascalCase)
    - ✅ Already consistent.

2. Variables, Methods, and URLs (camelCase)
    - 🔄 Review for inconsistencies.

3. Files (snake_case)
    - 🔄 Ensure view files like HTML, CSS, and JS follow snake_case.

4. Packages (lowercase with dots, e.g., com.norstarphoenix)
    - ✅ Already follows this structure.

5. Packages should include your name and project name
    - ✅ com.norstarphoenix.neuro_wave meets this requirement.

#### Checklist:
- 🔄 Review all naming conventions for compliance.
- 🔄 Rename files or variables as needed to meet the guidelines.



##  Constant Variables (2%)
- Requirement: Use Java classes with constant variables. Examples include:
   - Request parameters
   - SQL queries in DAO
   - HTML page names
   - URL patterns for forwarding requests
- Current Status: Not explicitly defined yet.
- Action Needed: Identify areas where constants can be applied and create a Constants utility class.
### Checklist
- 🔄 Create a Constants class to store:
   - SQL queries (for DAO).
   - HTML template names.
   - URL patterns or routes.
- 🔄 Replace hardcoded values in the project with constants.

## Models and Relational Database  (12%)
1. At least four models (5%):
- Current Status: Not fully confirmed. Existing models may include User, Investor, or placeholders.
- Action Needed: Define four meaningful models for the application (e.g., User, Investor, NewsletterSubscriber, and Adventure).
2. Corresponding database tables (3%):
   - Current Status: schema.sql exists but needs to include all required tables.
   - Action Needed: Create the database schema and ensure it matches the defined models.
3. Correct implementations (3%):
   - Current Status: Models need to be reviewed for annotations like @Entity, @Table, and proper relationships (e.g., @ManyToOne, @OneToMany).
   - Action Needed: Add or update annotations to reflect relationships between models.
4. Optimization (1%):
   - Current Status: No specific optimizations implemented yet.
   - Action Needed: Optimize models and queries for performance (e.g., indexing, avoiding redundant fields).

### Checklist
🔄 Define at least four models (e.g., User, Investor, NewsletterSubscriber, Adventure).
🔄 Update schema.sql with matching database tables.
🔄 Annotate models with proper JPA annotations (@Entity, @Table, etc.).
🔄 Implement relationships (e.g., @OneToMany or @ManyToOne).
🔄 Review and optimize the schema for indexing or constraints.



### Exception Handling (2%)
- Requirement: Apply exception handling throughout the application.
- Current Status: Not fully implemented.
- Action Needed: Implement custom exceptions where applicable and use standard Java exception handling for DAO, services, and controllers.

### Checklist
- 🔄 Create custom exception classes in the exception package (e.g., ResourceNotFoundException, InvalidInputException).
- 🔄 Add try-catch blocks in service and controller layers.
- 🔄 Return meaningful error messages in response to exceptions.

# 🏗️ **Capstone Project Management Checkpoint**

## **Section 3: Database, ORM, and Hibernate (18%)**

### 🗄️ **Database Requirements**
- ✅ **Use MySQL as DBMS** (2%):
    - Ensure MySQL database is properly set up and test the connection in `application.properties`.

- 📊 **Schema Diagram and SQL** (2%):
    - [ ] Create a schema diagram for database tables (use Lucidchart, Draw.io, etc.).
    - [ ] Document the SQL queries used in the project.

- 🛠️ **Database Configuration** (2%):
    - [ ] Validate the configuration file (`application.properties`) to adhere to Spring Boot conventions.

### 🔎 **Custom Queries and ORM**
- 🔍 **Custom Queries** (3%):
    - [ ] Write at least three custom queries in repositories.

- 🧩 **Use Hibernate/JPA** (3%):
    - [ ] Ensure proper usage of Hibernate/JPA annotations (`@Entity`, `@Table`, etc.) for entity mapping.

### 🔄 **CRUD Operations**
- ✅ **CRUD Functionality** (6%):
    - [ ] Implement Create, Read, Update, and Delete operations across all models.

---

## **Section 4: Front-End Development (16%)**

### 🎨 **Styling and Design**
- 🎨 **Use CSS with External Stylesheets** (3%):
    - [ ] Apply `styles.css` across all pages for consistent styling.
    - [ ] Add custom styles to improve the user interface.

### 📄 **Dynamic Views**
- 🌐 **Six Views/Pages** (4%):
    - [ ] Ensure there are six views (current: 5). Add a new page (e.g., characters or lore page).

- 🖋️ **Use Thymeleaf for Dynamic Pages** (3%):
    - [ ] Add Thymeleaf expressions to make pages dynamic.

### 💡 **Scripts and Navigation**
- 🛠️ **Use External JavaScript File** (3%):
    - [ ] Verify the functionality of external JavaScript files (`invest.js`, `overlay.js`, etc.).

- 🔗 **Reusable Navigation** (3%):
    - [ ] Make navigation consistent and include it across all views.

---

## **Section 5: Spring Framework (25%)**

### ⚙️ **Framework and Validation**
- ✅ **Use Spring Boot** (2%):
    - Already implemented.

- 🧩 **Model Validation** (3%):
    - [ ] Add validation annotations to models (e.g., `@NotNull`, `@Size`).

### 🛠️ **Repositories and Services**
- 📂 **Repositories and Services** (4%):
    - [ ] Add and implement two repositories.
    - [ ] Add and implement two service interfaces.

### 🌱 **Spring Features**
- 🌱 **Managed Beans** (2%):
    - [ ] Create at least two managed beans using annotations (`@Component`, `@Service`).

- 🔄 **Dependency Injection** (3%):
    - [ ] Ensure proper use of `@Autowired` for dependency injection.

### 🔒 **Security and Logging**
- 🔒 **Session Management** (3%):
    - [ ] Implement session management (e.g., using Spring Security).

- 📜 **Transaction and Logging** (2%):
    - [ ] Add transaction handling and write logs to a file for request/response.

### 🌐 **Web Services**
- 🌐 **REST Endpoints** (3%):
    - [ ] Implement REST endpoints for CRUD operations.

- 🗝️ **Sign-up/Login** (3%):
    - [ ] Add user authentication with bcrypt for password hashing.

---

## **Section 6: Unit Testing (8%)**

### 🧪 **Testing Requirements**
- 🧪 **Repository Tests** (3%):
    - [ ] Write tests for repository query methods.

- 🛠️ **Service Tests** (3%):
    - [ ] Test at least one method in each service class.

- 📊 **Parameterized Tests** (2%):
    - [ ] Include at least one parameterized test.

---

## **Section 7: Presentation (5%)**

### 🎤 **Presentation Goals**
- 🗣️ **Overview** (1%):
    - [ ] Prepare a short overview of your application.

- 💼 **Business Use Cases** (1%):
    - [ ] Highlight the business use cases for the project.

- 🛠️ **Technical Perspective** (1%):
    - [ ] Showcase the technical aspects of your application.

- ✍️ **Learnings** (1%):
    - [ ] Discuss key learnings from the development process.

- 🌟 **Future Features** (1%):
    - [ ] Propose additional features for future development.

---

## **Section 8: Project Management (Extra Credit - 5%)**

### 🏆 **Optional Management Tasks**
- 🔄 **SDLC/STLC** (1%):
    - [ ] Document adherence to SDLC/STLC (e.g., V-Model).

- 📋 **Requirements Analysis** (1%):
    - [ ] Perform a formal requirements analysis.

- 🌀 **Agile Principles** (1%):
    - [ ] Incorporate Agile/Scrum practices where possible.

- 🎯 **Stand-Ups** (1%):
    - [ ] Perform stand-up sessions or meetings with stakeholders.

- 🗂️ **Project Tracking** (1%):
    - [ ] Use a project management tool (e.g., Trello, JIRA).
