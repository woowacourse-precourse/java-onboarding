package onboarding.resolve.problem1;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class ExceptionHandlerTest {

    @Test
    void 범위_테스트() {
        boolean notIn1To400 = false;
        boolean result = ExceptionHandler.validateInput(List.of(0,401));
        assertThat(notIn1To400).isEqualTo(result);
    }

    @Test
    void 시작면_마지막면_테스트() {
        boolean startOrLastPage = false;
        boolean result=  ExceptionHandler.validateInput(List.of(1,400));
        assertThat(result).isEqualTo(startOrLastPage);
    }

    @Test
    void 왼쪽_홀수_오른쪽_짝수_아님_테스트() {
        boolean oddAndEvenTest = false;
        boolean result = ExceptionHandler.validateInput(List.of(2,3));
        assertThat(result).isEqualTo(oddAndEvenTest);
    }

    @Test
    void 왼쪽_오른쪽_차이가_1이_아님() {
        boolean leftNRightNot1 = false;
        boolean result = ExceptionHandler.validateInput(List.of(1,4));
        assertThat(result).isEqualTo(leftNRightNot1);
        assertThat(result).isEqualTo(leftNRightNot1);
    }

}