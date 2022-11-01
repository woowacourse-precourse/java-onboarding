package onboarding.problem1;

import java.util.Arrays;
import onboarding.problem1.PagePair.CompareResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PagePairTest {
    @Test
    @DisplayName("페이지 연속성 검사")
    void validatedPageContinuityCheck(){
        new PagePair(Arrays.asList(11,12));
        Assertions.assertThatThrownBy(() -> new PagePair(Arrays.asList(11,14)))
            .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("페어 최댓값 반환 체크 ")
    void validateGetMaxValueOfPair(){
        PagePair pair = new PagePair(Arrays.asList(11,12));
        PagePair pair2 = new PagePair(Arrays.asList(23,24));
        Assertions.assertThat(pair.getMaxValueOfPair()).isEqualTo(3);
        Assertions.assertThat(pair2.getMaxValueOfPair()).isEqualTo(8);
    }

    @Test
    @DisplayName("페어 간 비교 체크")
    void validateComparePagePair(){
        PagePair pair1 = new PagePair(Arrays.asList(11,12));
        PagePair pair2 = new PagePair(Arrays.asList(23,24));

        Assertions.assertThat(pair1.comparePagePair(pair2))
            .isEqualTo(CompareResult.LOSE.ordinal());
        Assertions.assertThat(pair2.comparePagePair(pair1))
            .isEqualTo(CompareResult.WIN.ordinal());
        Assertions.assertThat(pair2.comparePagePair(pair2))
            .isEqualTo(CompareResult.DRAW.ordinal());
    }
}
