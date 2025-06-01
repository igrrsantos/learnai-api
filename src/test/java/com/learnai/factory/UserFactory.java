package com.learnai.factory;

import com.learnai.entity.User;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserFactory {

    public static User createDefaultUser() {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setEmail("usuario" + System.nanoTime() + "@teste.com");
        user.setPassword("senha123");
        user.setFullName("Igor Santos");
        user.setRole("USER");
        user.setEnabled(true);
        user.setAccountLocked(false);
        user.setCreatedAt(LocalDateTime.now().minusDays(1));
        user.setUpdatedAt(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now().minusHours(2));
        user.setFailedAttempts(0);
        user.setLockedUntil(null);
        return user;
    }

    public static User createUserWithEmail(String email) {
        User user = createDefaultUser();
        user.setEmail(email);
        return user;
    }

    public static User createAdminUser() {
        User user = createDefaultUser();
        user.setRole("ADMIN");
        user.setEmail("admin" + System.nanoTime() + "@teste.com");
        return user;
    }

    public static User createLockedUser() {
        User user = createDefaultUser();
        user.setAccountLocked(true);
        user.setLockedUntil(LocalDateTime.now().plusDays(1));
        return user;
    }

    public static User createDisabledUser() {
        User user = createDefaultUser();
        user.setEnabled(false);
        return user;
    }

    public static User createUserWithFailedAttempts(int attempts) {
        User user = createDefaultUser();
        user.setFailedAttempts(attempts);
        return user;
    }

    public static User createCustomUser(
            String email,
            String password,
            String fullName,
            String role,
            boolean enabled,
            boolean accountLocked,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            LocalDateTime lastLogin,
            int failedAttempts,
            LocalDateTime lockedUntil
    ) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setEmail(email);
        user.setPassword(password);
        user.setFullName(fullName);
        user.setRole(role);
        user.setEnabled(enabled);
        user.setAccountLocked(accountLocked);
        user.setCreatedAt(createdAt);
        user.setUpdatedAt(updatedAt);
        user.setLastLogin(lastLogin);
        user.setFailedAttempts(failedAttempts);
        user.setLockedUntil(lockedUntil);
        return user;
    }
}
