package onboarding;

import onboarding.problem6.Problem6Validation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem6CustomTest {

    private static final int MIN_EMAIL_INPUT = 11;
    private static final int MAX_EMAIL_INPUT = 20;

    private static final int MIN_NICKNAME_INPUT = 1;
    private static final int MAX_NICKNAME_INPUT = 20;

    @Nested
    class Problem6Test {

        @Test
        void 골뱅이가없는이메일주소() {
            String email = "marongemail.com";
            boolean impossible = Problem6Validation.problem6Validation(email, "제이엠", MIN_EMAIL_INPUT,MAX_EMAIL_INPUT,MIN_NICKNAME_INPUT,MAX_NICKNAME_INPUT);
            assertThat(impossible).isFalse();
        }

        @Test
        void 이메일닷컴플러스알파인이메일주소() {
            String email = "marong@email.com1";
            boolean impossible = Problem6Validation.problem6Validation(email, "제이엠", MIN_EMAIL_INPUT,MAX_EMAIL_INPUT,MIN_NICKNAME_INPUT,MAX_NICKNAME_INPUT);
            assertThat(impossible).isFalse();
        }

        @Test
        void 이메일닷컴이없는이메일주소() {
            String email = "marong@email";
            boolean impossible = Problem6Validation.problem6Validation(email, "제이엠", MIN_EMAIL_INPUT,MAX_EMAIL_INPUT,MIN_NICKNAME_INPUT,MAX_NICKNAME_INPUT);
            assertThat(impossible).isFalse();
        }

        @Test
        void 이메일의길이가max길이보다큰경우() {
            String email = "marongajdkajfkqjewjkrdkf@email.com";
            boolean impossible = Problem6Validation.problem6Validation(email, "제이엠", MIN_EMAIL_INPUT,MAX_EMAIL_INPUT,MIN_NICKNAME_INPUT,MAX_NICKNAME_INPUT);
            assertThat(impossible).isFalse();
        }

        @Test
        void 이메일잘통과하는지() {
            String email = "marong@email.com";
            boolean possible = Problem6Validation.problem6Validation(email, "제이엠", MIN_EMAIL_INPUT,MAX_EMAIL_INPUT,MIN_NICKNAME_INPUT,MAX_NICKNAME_INPUT);
            assertThat(possible).isTrue();
        }

        @Test
        void 닉네임이한글이아닌경우() {
            String nickname = "abc";
            boolean impossible = Problem6Validation.problem6Validation("marong@email.com", nickname, MIN_EMAIL_INPUT,MAX_EMAIL_INPUT,MIN_NICKNAME_INPUT,MAX_NICKNAME_INPUT);
            assertThat(impossible).isFalse();
        }

        @Test
        void 닉네임의길이가맞지않는경우() {
            String nickname = "";
            boolean impossible = Problem6Validation.problem6Validation("marong@email.com", nickname, MIN_EMAIL_INPUT,MAX_EMAIL_INPUT,MIN_NICKNAME_INPUT,MAX_NICKNAME_INPUT);
            assertThat(impossible).isFalse();
        }

        @Test
        void 닉네임의길이가맞지않는경우1() {
            StringBuilder nicknameBuilder = new StringBuilder();
            for (int i = 0; i < MAX_NICKNAME_INPUT + 1; i++) {
                nicknameBuilder.append("김");
            }
            String nickname = nicknameBuilder.toString();
            boolean impossible = Problem6Validation.problem6Validation("marong@email.com", nickname, MIN_EMAIL_INPUT,MAX_EMAIL_INPUT,MIN_NICKNAME_INPUT,MAX_NICKNAME_INPUT);
            assertThat(impossible).isFalse();
        }
        @Test
        void 닉네임통과하는경우() {
            StringBuilder nicknameBuilder = new StringBuilder();
            for (int i = 0; i < MAX_NICKNAME_INPUT; i++) {
                nicknameBuilder.append("김");
            }
            String nickname = nicknameBuilder.toString();
            boolean possible = Problem6Validation.problem6Validation("marong@email.com", nickname, MIN_EMAIL_INPUT,MAX_EMAIL_INPUT,MIN_NICKNAME_INPUT,MAX_NICKNAME_INPUT);
            assertThat(possible).isTrue();
        }
    }

}
