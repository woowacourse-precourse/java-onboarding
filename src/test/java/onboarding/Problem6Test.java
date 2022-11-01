package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem6Test {

    Problem6 problem6;

    @Test
    @DisplayName("2개의 닉네임 비교하여 연속된 글자가 있는지 판단하기")
    void containsWord() {
        problem6 = new Problem6();
        assertTrue(problem6.containsWord("제이엠", "제이슨"));
        assertFalse(problem6.containsWord("제이엠", "이제엠"));
    }

    @Test
    @DisplayName("유사한 닉네임이 있는지 체크")
    void findDuplicateNickname() {
        problem6 = new Problem6();
        HashSet<String> testDuplicateEmail = new HashSet<>();
        testDuplicateEmail.add("jason@email.com");
        testDuplicateEmail.add("jm@email.com");
        testDuplicateEmail.add("mj@email.com");

        List<CrewInfo> crews = new ArrayList<>(Arrays.asList(
                new CrewInfo("jm@email.com", "제이엠"),
                new CrewInfo("jason@email.com", "제이슨"),
                new CrewInfo("woniee@email.com", "워니"),
                new CrewInfo("mj@email.com", "엠제이"),
                new CrewInfo("nowm@email.com", "이제엠")
        ));

        assertEquals(testDuplicateEmail, problem6.findDuplicateNickname(crews));
    }
}