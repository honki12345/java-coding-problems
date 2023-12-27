package chapter02;

import chapter02.User.UserBuilder;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Date;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob051 {

    @DisplayName("")
    @Test
    void test() {
        // given // when // then
        // nickname과 password가 있는 사용자
        User user1 = User.getBuilder("marin21", "hjju").build();

        // nickname과 password, email이 있는 사용자
        User user2 = User.getBuilder("ik", "44fef")
            .email("ion@gmail.com")
            .build();

        // nickname과 password, email, firstname, lastname이 있는 사용자
        User user3 = User.getBuilder("monika", "klooi")
            .email("monika@gmail.com")
            .firstName("Monika")
            .lastName("Ghuenter")
            .build();
    }

    @DisplayName("")
    @Test
    void test2() {
        // given // when // then
        User user;
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        UserBuilder userBuilder = new UserBuilder("monika", "klooi0988")
            .email("monikagmailcom")
            .firstName("Monika")
            .lastName("Gunther");

        Set<ConstraintViolation<UserBuilder>> violations = validator.validate(userBuilder);
        if (violations.isEmpty()) {
            user = userBuilder.build();
            System.out.println("User successfully created on: "
                + user.getCreated());
        } else {
            printConstraintViolations("UserBuilder violations: ", violations);
        }
    }

    private static <T> void printConstraintViolations(
        String caption, Set<ConstraintViolation<T>> violations) {

        System.out.println(caption);

        violations.forEach((v) -> {
            System.out.println("\t" + v.getPropertyPath() + " " + v.getMessage());
        });
    }
}
