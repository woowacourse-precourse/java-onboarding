package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class Problem6Test {

    @Test
    @DisplayName("partNames 메소드 테스트")
    void partNamesTest(){

        List<String> names = List.of("김철수", "이유리", "고길동");
        Set<String> partNameList = Set.of(
                "김철", "철수", "김철수",
                "이유", "유리", "이유리",
                "고길", "길동", "고길동"
        );

        Set<String> result = Problem6.partNames(names);

        assertThat(result).isEqualTo(partNameList);
    }

    @Test
    @DisplayName("checkNames 메소드 테스트")
    void checkNamesTest(){

        List<List<String>> forms = List.of(
                List.of("abcd123@email.com", "김길동"),
                List.of("bcd123@email.com", "최길동"),
                List.of("cd123@email.com", "박길동"),
                List.of("qwer123@email.com", "박하")
        );

        List<String> answer = List.of(
                "abcd123@email.com",
                "bcd123@email.com",
                "cd123@email.com"
        );

        List<String> result = Problem6.checkNames(forms);

        assertThat(result).isEqualTo(answer);
    }
}
