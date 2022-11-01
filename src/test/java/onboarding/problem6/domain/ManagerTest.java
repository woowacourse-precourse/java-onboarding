package onboarding.problem6.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ManagerTest {
    @Test
    @DisplayName("저장된 이메일 오름차순으로 정렬 후 반환")
    void returnResultEmails() {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠"),
                List.of("adg@email.com", "이")
        );
        List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
        
        final Manager manager = new Manager(forms);
        manager.saveDuplicateAccounts();
        
        assertThat(manager.getDuplicateAccountEmails()).isEqualTo(result);
    }
}