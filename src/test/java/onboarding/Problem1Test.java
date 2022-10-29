package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {

    @Test
    void maxTest(){
        int a = 10;
        int b = 9;
        int maxValue = Problem1.max(a, b);
        assertThat(maxValue).isEqualTo(a);
    }


    @Test
    void calculateTest(){
        List<Integer> pages = List.of(100, 101);

        int maxValue = Problem1.calculate(pages);
        assertThat(maxValue).isEqualTo(2);
    }

    @Nested
    class exceptionvalidatetest {


        @Test
        @DisplayName("예외가 없는 경우")
        void case1(){
            List<Integer> pobi = List.of(97, 98);
            List<Integer> crong = List.of(13, 14);

            int validationCode = Problem1.exceptionValidate(pobi, crong);
            assertThat(validationCode).isEqualTo(1);

        }
        @Test
        @DisplayName("펼친 페이지의 두 수가 연속하지 않음")
        void case2(){
            List<Integer> pobi = List.of(97, 100);
            List<Integer> crong = List.of(101, 102);


            int validationCode = Problem1.exceptionValidate(pobi, crong);
            assertThat(validationCode).isEqualTo(-1);
        }

        @Test
        @DisplayName("페이지의 수가 책의 범위 벗어남")
        void case3(){
            List<Integer> pobi = List.of(-1, 0);
            List<Integer> crong = List.of(400, 401);

            int validationCode = Problem1.exceptionValidate(pobi, crong);
            assertThat(validationCode).isEqualTo(-1);
        }
    }


}
