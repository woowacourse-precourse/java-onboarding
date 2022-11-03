package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6UnitTest {
    @Test
    public void validateEmailPatternTest() {
        // given
        Map<String, String> testMap = new HashMap<>();

        // when
        testMap.put("test1", "test1@email.com");
        testMap.put("test2", "test2@gdfsgd.com");
        testMap.put("test3", "@$#test3@email.com");
        testMap.put("test4", "92fsdgq4g657ygvg13443vqb45@email.com");

        // then
        List<String> invalidEmail = Problem6.validateEmailPattern(testMap);
        Assertions.assertThat(testMap.get("test2")).isIn(invalidEmail);
        Assertions.assertThat(testMap.get("test3")).isIn(invalidEmail);
        Assertions.assertThat(testMap.get("test4")).isIn(invalidEmail);
        Assertions.assertThat(testMap.get("test1")).isNotIn(invalidEmail);
    }
}
