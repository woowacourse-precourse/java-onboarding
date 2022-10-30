package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem3Test {


    @Nested
    class ClapCountTest {

        @Test
        @DisplayName("clapCount 테스트 - 1")
        void test1(){
            int num = 3;
            int count = Problem3.clapCount(num);

            assertThat(count).isEqualTo(1);

        }

        @Test
        @DisplayName("clapCount 테스트 - 2")
        void test2(){
            int num = 33;
            int count = Problem3.clapCount(num);

            assertThat(count).isEqualTo(14);
        }

    }


}
