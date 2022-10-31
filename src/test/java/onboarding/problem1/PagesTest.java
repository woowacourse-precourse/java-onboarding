package onboarding.problem1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PagesTest {

    @DisplayName("page is Illegal test")
    @Nested
    class 문제1_검증_테스트 {
        @DisplayName("잘_선택된_테스트")
        @Test
        void 잘_선택된_테스트() {
            Pages 잘_선택한_페이지 = new Pages(List.of(101, 102));
            assertThat(잘_선택한_페이지.isIllegal()).isEqualTo(false);
        }

        @DisplayName("null_입력시_예외테스트")
        @Test
        void null_입력시_예외테스트() {
            Pages null_선택한_페이지 = new Pages(null);
            assertThat(null_선택한_페이지.isIllegal()).isEqualTo(true);
        }

        @DisplayName("페이지_길이가_2가_아님")
        @Test
        void 페이지_길이가_2가_아님() {
            Pages 길이가_3인_페이지 = new Pages(List.of(123, 124, 52));
            assertThat(길이가_3인_페이지.isIllegal()).isEqualTo(true);
        }

        @DisplayName("페이지가 홀수 짝수가 아님")
        @Test
        void 페이지가_홀수_짝수_아님() {
            Pages 홀짝_아닌_페이지 = new Pages(List.of(122, 123));
            assertThat(홀짝_아닌_페이지.isIllegal()).isEqualTo(true);
        }

        @DisplayName("페이지가 연속되지 않은 상태")
        @Test
        void 페이지가_연속_아님() {
            Pages 연속_아님 = new Pages(List.of(111, 114));
            assertThat(연속_아님.isIllegal()).isEqualTo(true);
        }

        @DisplayName("페이지의 번호가 1~400 안에 없는 경우")
        @Test
        void 페이지가_범위에_없음() {
            Pages 범위_바깥 = new Pages(List.of(401, 402));
            assertThat(범위_바깥.isIllegal()).isEqualTo(true);
            Pages 범위_안쪽바깥 = new Pages(List.of(-1, 0));
            assertThat(범위_바깥.isIllegal()).isEqualTo(true);
        }

        @DisplayName("첫 페이지 혹은 마지막 페이지 연 경우")
        @Test
        void 끝페이지_연_경우() {
            Pages 끝 = new Pages(List.of(399, 400));
            assertThat(끝.isIllegal()).isEqualTo(true);

            Pages 시작 = new Pages(List.of(1, 2));
            assertThat(시작.isIllegal()).isEqualTo(true);
        }
    }
}
