package onboarding;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import org.junit.jupiter.api.Test;

class Problem6Test {

    @Test
    void 결과테스트() {

        List<List<String>> case1 = List.of(
                List.of("asas2858@email.com", "박한수"),
                List.of("abc@email.com", "바나나"),
                List.of("zansu@email.com", "나나콘"),
                List.of("zansu@email.com", "니르바나"),
                List.of("hspark@email.com", "아나콘다"),
                List.of("invidam@email.com", "인비담")
        );

        List<String> result = List.of("abc@email.com", "hspark@email.com", "zansu@email.com");

        assertThat(Problem6.solution(case1)).isEqualTo(result);
    }

    @Test
    void 예외결과테스트() {

        List<List<String>> case1 = new ArrayList<List<String>>();

        for(int i=0;i<10_005;++i)
            case1.add(List.of("abc@gmail.com", "바나나"));

        List<List<String>> case2 = List.of(
                List.of("abc@gmail.com", "바나나")
        );

        List<List<String>> case3 = List.of(
                List.of("veryverylongandlongandlongemail@email.com", "니르바나")
        );

        List<List<String>> case4 = List.of(
                List.of("invidam@email.com", "")
        );

        List<List<String>> case5 = List.of(
                List.of("invidam@email.com", "김수한무거북이와두루미삼천갑자동방삭치치카")
        );


        assertThrows(InputMismatchException.class, () -> Problem6.solution(case1));
        assertThrows(InputMismatchException.class, () -> Problem6.solution(case2));
        assertThrows(InputMismatchException.class, () -> Problem6.solution(case3));
        assertThrows(InputMismatchException.class, () -> Problem6.solution(case4));
        assertThrows(InputMismatchException.class, () -> Problem6.solution(case5));
    }

}