package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;

class PageTest {
    Page pobi = new Page(Arrays.asList(199, 200));
    Page crong = new Page(Arrays.asList(201, 202));

    @Test
    void 두_객체를_비교한_뒤_더_큰_수를_가진_객체의_사용자_이름_꺼내기() {
        //given
        Page pobi = this.pobi.findMaxValue("pobi");
        Page crong = this.crong.findMaxValue("crong");

        //when
        String maxValueUser = pobi.findMaxValue(crong);

        //then
        Assertions.assertThat(maxValueUser).isEqualTo("pobi");
    }

    @Test
    void 더하기_곱하기_최대값을_가지고_있는_Page_객체_꺼내기() {
        //when
        Page pobi = this.pobi.findMaxValue("pobi");

        //then
        assertAll(
                () -> Assertions.assertThat(pobi.getLeftPageNumber()).isEqualTo(199),
                () -> Assertions.assertThat(pobi.getRightPageNumber()).isEqualTo(200),
                () -> Assertions.assertThat(pobi.getMaxValue()).isEqualTo(81),
                () -> Assertions.assertThat(pobi.getMaxValueUser()).isEqualTo("pobi")
        );
    }

    @Test
    void 더하기_곱하기_비교_테스트() {
        //when
        int leftMaxValue = pobi.compareNumberPerPageSumTimes(pobi.getLeftPageNumber());
        int rightMaxValue = pobi.compareNumberPerPageSumTimes(pobi.getRightPageNumber());

        //then
        Assertions.assertThat(leftMaxValue).isEqualTo(81);
        Assertions.assertThat(rightMaxValue).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:3", "220:221"}, delimiter = ':')
    @DisplayName("왼쪽 페이지는 짝수, 오른쪽 페이지는 홀수 확인 테스트 -> false값 반환")
    public void 왼쪽_페이지_짝수_오른쪽_페이지_홀수_테스트_실패(int leftPage, int rightPage) {
        //given
        Page page = new Page(Arrays.asList(leftPage, rightPage));

        //when
        boolean expected = page.validationCheck();

        //then
        Assertions.assertThat(expected).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"401:402", "-1:0"}, delimiter = ':')
    @DisplayName("페이지의 범위를 초과하는 경우 테스트 -> false값 반환")
    public void 페이지_범위_테스트_실패(int leftPage, int rightPage) {
        //given
        Page page = new Page(Arrays.asList(leftPage, rightPage));

        //when
        boolean expected = page.validationCheck();

        //then
        Assertions.assertThat(expected).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"3:4", "5:6"}, delimiter = ':')
    @DisplayName("오른쪽 페이지에서 왼쪽 페이지의 차이가 1일 경우 테스트 -> true값 반환")
    public void 페이지_차이_테스트_정상(int leftPage, int rightPage) {
        //given
        Page page = new Page(Arrays.asList(leftPage, rightPage));

        //when
        boolean expected = page.validationCheck();

        //then
        Assertions.assertThat(expected).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:4", "3:2"}, delimiter = ':')
    @DisplayName("오른쪽 페이지에서 왼쪽 페이지의 차이가 1이 아닐 경우 테스트 -> false값 반환")
    public void 페이지_차이_테스트_실패(int leftPage, int rightPage) {
        //given
        Page page = new Page(Arrays.asList(leftPage, rightPage));

        //when
        boolean expected = page.validationCheck();

        //then
        Assertions.assertThat(expected).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2", "399:400"}, delimiter = ':')
    @DisplayName("시작면과 끝면인 페이지가 나오는 테스트 -> false값 반환")
    public void 페이지_경계값_테스트_false(int leftPage, int rightPage) {
        //given
        Page page = new Page(Arrays.asList(leftPage, rightPage));

        //when
        boolean expected = page.validationCheck();

        //then
        Assertions.assertThat(expected).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"3:4", "397:398"}, delimiter = ':')
    @DisplayName("시작면과 끝면인 페이지가 나오는 테스트 -> true값 반환")
    public void 페이지_경계값_테스트_true(int leftPage, int rightPage) {
        //given
        Page page = new Page(Arrays.asList(leftPage, rightPage));

        //when
        boolean expected = page.validationCheck();

        //then
        Assertions.assertThat(expected).isTrue();
    }
}
