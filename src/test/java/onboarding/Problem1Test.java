package onboarding;

import onboarding.problem1.ConditionValue;
import onboarding.problem1.ProblemOneValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {

    @Test
    @DisplayName("Problem1 클래스가 가지고 있는 필드가 ProblemOneValidation 클래스가 맞는지 테스트")
    void ProblemOne_have_field_problemOneValidation() throws NoSuchFieldException {
        // given
        Problem1 problem1 = new Problem1();
        Field field = problem1.getClass().getDeclaredField("validation");

        // when
        boolean result = field.getType().equals(ProblemOneValidation.class);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("페이지 번호를 각 자리 숫자를 더한 경우와 곱한 경우 크기값을 비교하여 큰 값을 반환한다.")
    void findMaxValue() {
        // given
        List<Integer> pobi = new ArrayList<>(){{
            add(199);
            add(200);
        }};
        int expectValue = 81;

        // when
        int result = Problem1.findMaxValue(pobi);

        // then
        assertThat(result).isEqualTo(expectValue);
    }

    @Test
    @DisplayName("왼쪽과 오른쪽 페이지 번호를 각 자리 숫자를 더하여 큰값을 반환한다.")
    void getSumMaxValue() {
        // given
        int leftPageNumber = 100;
        int rightPageNumber = 101;
        int expectValue = 2;

        // when
        int result = Problem1.getSumMaxValue(leftPageNumber, rightPageNumber);

        // then
        assertThat(result).isEqualTo(expectValue);
    }

    @Test
    @DisplayName("페이지 번호를 받아서 각 자리 숫자의 합을 구해 반환한다.")
    void getSumValue() {
        // given
        int pageNumber = 100;
        int expectValue = 1;

        // when
        int result = Problem1.getSumValue(pageNumber);

        // then
        assertThat(result).isEqualTo(expectValue);
    }

    @Test
    @DisplayName("리스트 목록에서 전체 합을 구하여 반환한다.")
    void getSum() {
        // given
        String[] givenPageNumber = {"1", "0", "0"};
        int expectValue = 1;

        // when
        int result = Problem1.getSum(givenPageNumber);

        // then
        assertThat(result).isEqualTo(expectValue);
    }

    @Test
    @DisplayName("각 페이지번호의 각 자리수를 곱하고 가장 큰 값을 반환한다.")
    void getMultiplicationMaxValue() {
        // given
        int leftPageNumber = 233;
        int rightPAgeNumber = 234;
        int expectValue = 24;

        // when
        int result = Problem1.getMultiplicationMaxValue(leftPageNumber, rightPAgeNumber);

        // then
        assertThat(result).isEqualTo(expectValue);
    }

    @Test
    @DisplayName("페이지 번호를 받아 각 자리수를 곱하여 반환한다,")
    void getMultiplicationValue() {
        // given
        int pageNumber = 233;
        int expectValue = 18;

        // when
        int result = Problem1.getMultiplicationValue(pageNumber);

        // then
        assertThat(result).isEqualTo(expectValue);
    }

    @Test
    @DisplayName("포비님과 크롱님의 숫자를 비교하여 크롱님이 이기면 2를 반환한다.")
    void getResult_Crong_Win() {
        // given
        int pobiMaxValue = 43;
        int crongMaxValue = 45;
        int expectValue = ConditionValue.CRONG_WIN.getValue();

        // when
        int result = Problem1.getResult(pobiMaxValue, crongMaxValue);

        // then
        assertThat(result).isEqualTo(expectValue);
    }

    @Test
    @DisplayName("포비님과 크롱님의 숫자를 비교하여 포비님이 이기면 1를 반환한다.")
    void getResult_Pobi_Win() {
        // given
        int pobiMaxValue = 45;
        int crongMaxValue = 43;
        int expectValue = ConditionValue.POBI_WIN.getValue();

        // when
        int result = Problem1.getResult(pobiMaxValue, crongMaxValue);

        // then
        assertThat(result).isEqualTo(expectValue);
    }

    @Test
    @DisplayName("포비님과 크롱님의 숫자를 비교하여 무승부면 0을 반환한다.")
    void getResult_Pobi_Crong_Draw() {
        // given
        int pobiMaxValue = 45;
        int crongMaxValue = 45;
        int expectValue = ConditionValue.POBI_CRONG_DRAW.getValue();

        // when
        int result = Problem1.getResult(pobiMaxValue, crongMaxValue);

        // then
        assertThat(result).isEqualTo(expectValue);
    }

    @Test
    @DisplayName("포비님과 크롱님의 숫자를 비교하여 예외 시 -1를 반환한다.")
    void getResult_Exception() {
        // given
        int pobiMaxValue = -1;
        int crongMaxValue = 43;
        int expectValue = ConditionValue.EXCEPTION_VALUE.getValue();

        // when
        int result = Problem1.getResult(pobiMaxValue, crongMaxValue);

        // then
        assertThat(result).isEqualTo(expectValue);
    }
}