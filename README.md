# admin-audit-logging-service
A standalone Spring Boot service designed to log administrative actions performed within a system.

The service records actions such as approving a request, blocking a user, updating a configuration, or performing other admin-level operations. For each action, the system stores key details such as the admin identifier, action type, target entity, a short description, and the timestamp of when the action occurred.

This project is intended to help demonstrate backend design principles such as clean API structure, layered architecture, data persistence, and modular service design using Spring Boot. It is built as a standalone mini-project so it can be developed and tested independently, while also representing a reusable component that could later be integrated into a larger admin or banking platform.

The main goal of this project is to provide a simple and extensible foundation for admin activity tracking, while giving hands-on experience with real-world backend development patterns.
