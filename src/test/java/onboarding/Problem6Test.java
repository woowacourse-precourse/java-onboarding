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
}
