# 📞 Address Book API

A simple Spring Boot API to manage contacts.

## 🚀 Quick Start

Follow these steps to get the API running.

### 🛠️ Prerequisites

-   Java 17+
-   MySQL
-   Gradle

### 📦 Installation

1.  Clone the repository:

    ```bash
    git clone <repository_url>
    ```

2.  Navigate to the project:

    ```bash
    cd addressbook
    ```

3.  Configure MySQL in `src/main/resources/application.yml`:

    ```yaml
    spring:
      datasource:
        url: jdbc:mysql://localhost:3306/corelia_task
        username: <your_username>
        password: <your_password>
    ```

### ▶️ Run

1.  Build the project:

    ```bash
    ./gradlew build
    ```

2.  Run the application:

    ```bash
    ./gradlew bootRun
    ```

    The API will be available at `http://localhost:8080`.

## ⚙️ API Usage

### 👤 User Registration

-   **`POST /api/v1/registration`**: Create a new user.
    -   JSON body: `firstName`, `lastName`, `email`, `password`.

### 📞 Contact Management

-   **`POST /api/v1/contacts`**: Create a contact.
    -   JSON body: `firstName`, `lastName`, `phoneNumber`, `emailAddress`, `birthdate`.
-   **`GET /api/v1/contacts`**: List contacts (with `page`, `size`, `sort` query params).
-   **`GET /api/v1/contacts/{id}`**: Get a contact by ID.
-   **`PUT /api/v1/contacts/{id}`**: Update a contact.
-   **`DELETE /api/v1/contacts/{id}`**: Delete a contact.

### ✅ Validation

-   Input is validated (name, email, password, phone, birthdate).
-   Errors are returned in the response.
