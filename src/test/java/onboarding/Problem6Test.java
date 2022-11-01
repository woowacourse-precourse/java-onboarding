package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

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

    @Test
    @DisplayName("유사한 닉네임을 갖고 있는 크루들의 이메일을 오름차순으로 정렬하여 출력")
    void searchNickname() {
        problem6 = new Problem6();
        List<String> resultEmail = Arrays.asList("jm@email.com","jason@email.com", "mj@email.com");
        Collections.sort(resultEmail);

        List<String> answer = new ArrayList<>();
        List<List<String>> forms = new ArrayList<>();
        forms.add(new ArrayList<>(Arrays.asList("jm@email.com", "제이엠")));
        forms.add(new ArrayList<>(Arrays.asList("jason@email.com", "제이슨")));
        forms.add(new ArrayList<>(Arrays.asList("woniee@email.com", "워니")));
        forms.add(new ArrayList<>(Arrays.asList("mj@email.com", "엠제이")));
        forms.add(new ArrayList<>(Arrays.asList("nowm@email.com", "이제엠")));

        assertEquals(resultEmail, problem6.searchNickname(answer, forms));
    }

}