package onboarding.problem1;

import onboarding.Problem1;
import onboarding.problem1.infra.PageNumberAndSizeValidation;
import onboarding.problem1.serivce.PageService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {

    private PageService pageService = new PageService();
    @Test
    @DisplayName("Problem1 클래스가 가지고 있는 필드가 pageService 클래스가 맞는지 테스트")
    void ProblemOne_have_field_problemOneValidation() throws NoSuchFieldException {
        // given
        Problem1 problem1 = new Problem1();
        Field field = problem1.getClass().getDeclaredField("pageService");

        // when
        boolean result = field.getType().equals(PageService.class);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("페이지 번호를 각 자리 숫자를 더한 경우와 곱한 경우 크기값을 비교하여 큰 값을 반환한다.")
    void findMaxValue() {
        // given
        PageNumberAndSizeValidation validation = new PageNumberAndSizeValidation();
        List<Integer> pobi = new ArrayList<>(){{
            add(199);
            add(200);
        }};

        int expectValue = 81;

        // when
        int result = pageService.findMaxValue(pobi, validation);

        // then
        assertThat(result).isEqualTo(expectValue);
    }
}