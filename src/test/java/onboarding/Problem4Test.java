package onboarding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Problem4Test {

    private Problem4 problem4;

    @BeforeEach
    void setUp() {
        problem4 = new Problem4();
    }
    @Nested
    @DisplayName("isUpperCase 메소드는")
    class isUpperCaseTest {
        @Nested
        @DisplayName("대문자 아스키 코드를 입력하면")
        class Context_with_upper_case_ascii_code{
            @Test
            @DisplayName("true를 반환한다.")
            void it_returns_true() {
                int upperCaseAsciiCode = 67;
                assertThat(problem4.isUpperCase(upperCaseAsciiCode)).isTrue();
            }
        }

        @Nested
        @DisplayName("다른 아스키 코드를 입력하면")
        class Context_with_other_ascii_code{
            @Test
            @DisplayName("false를 반환한다.")
            void it_returns_false() {
                int otherAsciiCode = 91;
                assertThat(problem4.isUpperCase(otherAsciiCode)).isFalse();
            }
        }
    }


    @Nested
    @DisplayName("isLowerCase 메소드는")
    class isLowerCaseTest {
        @Nested
        @DisplayName("소문자 아스키 코드를 입력하면")
        class Context_with_lower_case_ascii_code {
            @Test
            @DisplayName("true를 반환한다")
            void it_returns_true() {
                int lowerCaseAsciiCode = 97;
                assertThat(problem4.isLowerCase(lowerCaseAsciiCode)).isTrue();
            }
        }
        @Nested
        @DisplayName("다른 아스키 코드를 입력하면")
        class Context_with_other_ascii_code {
            @Test
            @DisplayName("false를 반환한다")
            void it_returns_false() {
                int otherAsciiCode = 90;
                assertThat(problem4.isLowerCase(otherAsciiCode)).isFalse();
            }
        }
    }
}