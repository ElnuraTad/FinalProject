# Learning Management System (LMS)

## 📌 Project Description

This is a web-based **Learning Management System** (LMS) designed for universities or training centers to manage courses, students, instructors, and partner organizations. 
The application supports user roles and permissions and integrates AI functionality for student assistance.

---

## ✅ Included Features

### 1. Core CRUD Operations:
- **Companies:** Add/remove partner organizations.
- **Courses:** Create and modify course details (title, duration, syllabus).
- **Instructors & Students:** Manage user profiles and assignments.
- **Groups:** Organize students into cohorts with shared courses.

### 2. Relationships:
- Enforce constraints (e.g., a student can’t be added to a non-existent group).

### 3. User Roles:
- **Admin:** Full access (manage everything).
- **Instructors:** Can create and edit courses.
- **Students:** Can view their enrollments and interact with an AI assistant.

---

## 🛠️ Technologies Used

- **Java 17** (Amazon Corretto)
- **Spring Boot** + Spring MVC
- **Hibernate** + JPA + PostgreSQL
- **Thymeleaf** for server-side rendering
- **Spring Security** for role-based access
- **HTML/CSS** for UI
- **OpenAI API** (for AI assistant integration)

---

## 🚀 How to Run

1. Clone the repository:

```bash
git clone https://github.com/your-username/your-lms-project.git
