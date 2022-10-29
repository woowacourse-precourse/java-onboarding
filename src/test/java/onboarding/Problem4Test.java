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

    @Nested
    @DisplayName("getInverseAlphabet 메소드는")
    class getInverseAlphabetTest {
        @Nested
        @DisplayName("소문자 아스키코드가 입력되면")
        class Context_with_lower_case {
            @Test
            @DisplayName("역순의 소문자 아스키코드를 반환한다")
            void it_returns_inverse_lower_case_alphabet() {
                int lowerCaseAsciiCode = 97;
                int inverseLowerCase = 122;
                assertThat(problem4.getInverseAlphabet(lowerCaseAsciiCode)).isEqualTo(inverseLowerCase);
            }
        }
        @Nested
        @DisplayName("대문자 아스키코드가 입력되면")
        class Context_with_upper_case {
            @Test
            @DisplayName("역순의 대문자 아스키코드를 반환한다")
            void it_returns_inverse_upper_case_alphabet() {
                int upperCaseAsciiCode = 67;
                int inverseUpperCase = 88;
                assertThat(problem4.getInverseAlphabet(upperCaseAsciiCode)).isEqualTo(inverseUpperCase);
            }
        }

        @Nested
        @DisplayName("그 외 아스키코드가 입력되면")
        class Context_with_other_ascii_code {
            @Test
            @DisplayName("아스키코드를 그대로 반환한다")
            void it_returns_as_it_is() {
                int otherAsciiCode = 5;
                assertThat(problem4.getInverseAlphabet(otherAsciiCode)).isEqualTo(otherAsciiCode);
            }
        }
    }
}