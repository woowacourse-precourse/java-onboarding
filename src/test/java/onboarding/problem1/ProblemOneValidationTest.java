package onboarding.problem1;

import onboarding.Problem1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProblemOneValidationTest {

    @Test
    @DisplayName("포비님과 크롱님의 펼친 페이지의 사이즈가 2가 맞는지 테스트")
    void isPageSize() {
        // given
        List<Integer> pobi = new ArrayList<>(){{
            add(99);
            add(100);
        }};

        List<Integer> crong = new ArrayList<>() {{
            add(201);
            add(202);
        }};

        ProblemOneValidation validation = new ProblemOneValidation();
        validation.settingFixedPageSize(ConditionValue.FIXED_LIST_SIZE.getValue());

        // when
        boolean result = validation.isPageSize(pobi.size(), crong.size());

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("우아한테크 선생님의 페이지 번호가 유효한지 테스트 " +
            "(왼쪽 페이지는 홀수이고 오른쪽 페이지는 짝수이며 페이지 번호는 왼쪽과 오른쪽이 한 페이지 차이 여야 한다." +
            "임의로 책을 펼칠 때 시작면이거나 마지막 면이 나오면 안된다.")
    void isPageNumberValidation() {
        // given
        List<Integer> woowahanTeacher1 = new ArrayList<>(){{
            add(200);
            add(201);
        }};

        List<Integer> woowahanTeacher2 = new ArrayList<>(){{
            add(99);
            add(102);
        }};

        List<Integer> woowahanTeacher3 = new ArrayList<>(){{
            add(403);
            add(404);
        }};

        ProblemOneValidation validation = new ProblemOneValidation();
        Integer leftPage = ConditionValue.LEFT_INDEX.getValue();
        Integer rightPage = ConditionValue.RIGHT_INDEX.getValue();


        // when && then
        validation.settingPageNumber(woowahanTeacher1.get(leftPage), woowahanTeacher1.get(rightPage));
        boolean result1 = validation.isPageNumberValidation();
        assertThat(result1).isFalse();

        validation.settingPageNumber(woowahanTeacher2.get(leftPage), woowahanTeacher2.get(rightPage));
        boolean result2 = validation.isPageNumberValidation();
        assertThat(result2).isFalse();

        validation.settingPageNumber(woowahanTeacher3.get(leftPage), woowahanTeacher3.get(rightPage));
        boolean result3 = validation.isPageNumberValidation();
        assertThat(result3).isFalse();
    }

}