package onboarding.problem6.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DuplicateAccountEmailsTest {
    @Test
    @DisplayName("저장된 이메일 오름차순으로 정렬 후 반환")
    void returnResultEmails() {
        List<List<User>> forms = List.of(
                List.of(new User("제이", "jm@email.com"), new User("이엠", "jm@email.com")),
                List.of(new User("제이", "jason@email.com"), new User("이슨", "jason@email.com")),
                List.of(new User("워니", "woniee@email.com")),
                List.of(new User("엠제", "mj@email.com"), new User("제이", "mj@email.com")),
                List.of(new User("이제", "nowm@email.com"), new User("제엠", "nowm@email.com"))
        );
        List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
        
        DuplicateAccountEmails duplicateAccountEmails = new DuplicateAccountEmails();
        duplicateAccountEmails.saveDuplicateAccountEmails(forms);
        assertThat(duplicateAccountEmails.getDuplicateAccountEmails()).isEqualTo(result);
    }
}