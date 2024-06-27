# Dependency Inversion Principle (DIP)

The Dependency Inversion Principle (DIP) is one of the SOLID principles of object-oriented design. It states that high-level modules should not depend on low-level modules. Both should depend on abstractions. Additionally, abstractions should not depend on details. Details should depend on abstractions.

## Why DIP Matters

DIP helps in creating a more flexible and maintainable codebase by reducing the coupling between high-level and low-level modules. It ensures that changes in low-level modules (details) do not affect high-level modules (policy) and vice versa.

## Example

### Without DIP

Consider an application where a `UserService` class depends directly on a `UserRepository` class to fetch user data from a database:

```java
public class UserRepository {
    public String getUserById(int userId) {
        // Logic to fetch user from a database
        return "User" + userId;
    }
}

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public String getUser(int userId) {
        return userRepository.getUserById(userId);
    }
}

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        System.out.println(userService.getUser(1));
    }
}
```

In this example, the `UserService` class is tightly coupled with the `UserRepository` class, making it difficult to change the data source without modifying the `UserService` class.

### With DIP

Now, let's refactor the code to adhere to DIP by introducing an abstraction:

```java
/**
 * UserRepository interface represents an abstraction for user data retrieval.
 */
public interface UserRepository {
    String getUserById(int userId);
}

/**
 * DatabaseUserRepository class implements UserRepository to fetch user data from a database.
 */
public class DatabaseUserRepository implements UserRepository {
    @Override
    public String getUserById(int userId) {
        // Logic to fetch user from a database
        return "User" + userId;
    }
}

/**
 * UserService class depends on the UserRepository abstraction.
 */
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUser(int userId) {
        return userRepository.getUserById(userId);
    }
}

/**
 * Main class demonstrates dependency injection and usage of UserService.
 */
public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new DatabaseUserRepository();
        UserService userService = new UserService(userRepository);
        System.out.println(userService.getUser(1));
    }
}
```

### Explanation

- **Interface `UserRepository`**: Defines an abstraction for user data retrieval.
- **Class `DatabaseUserRepository`**: Implements the `UserRepository` interface to fetch user data from a database.
- **Class `UserService`**: Depends on the `UserRepository` abstraction rather than a concrete class.
- **Dependency Injection**: In the `Main` class, the `UserService` is provided with an instance of `UserRepository` through its constructor, following the dependency injection pattern.

### Key Points

- **DIP Violation**: In the first example, `UserService` depends directly on `UserRepository`, leading to tight coupling and reduced flexibility.
- **DIP Adherence**: In the second example, `UserService` depends on the `UserRepository` abstraction, allowing for different implementations of `UserRepository` (e.g., `DatabaseUserRepository`, `ApiUserRepository`, etc.) to be used without modifying `UserService`.

## Conclusion

By following the Dependency Inversion Principle, we create more flexible and maintainable software. High-level modules depend on abstractions rather than concrete implementations, allowing for easier modification and extension of the codebase without affecting existing functionality.

---