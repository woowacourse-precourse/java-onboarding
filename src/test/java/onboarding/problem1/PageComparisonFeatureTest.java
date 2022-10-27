package onboarding.problem1;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PageComparisonFeatureTest {

    PageCalculationFeature<Integer, Integer> pageCalculator = new PageNumberCalculator();
    PageComparisonFeature<Page, Integer> pageComparator = new PageNumberComparator(pageCalculator);

    @Test
    void 페이지_번호의_합_곱_중_큰_결과_반환_성공() throws Exception {
        Page page = new Page(List.of(31, 32));
        Integer result = pageComparator.lagerNumberOfCondition(page);

        assertThat(result).isEqualTo(6);
    }
    
    @Test
    void 두개의_페이지_중_첫번째_페이지의_결과가_더_크면_1을반환() throws Exception {
        Page firstPage = new Page(List.of(31, 32));
        Page secondPage = new Page(List.of(21, 22));
        Integer result = pageComparator.comparePageBetween(firstPage, secondPage);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void 두개의_페이지_중_두번째_페이지의_결과가_더_크면_2를반환() throws Exception {
        Page firstPage = new Page(List.of(21, 22));
        Page secondPage = new Page(List.of(31, 32));
        Integer result = pageComparator.comparePageBetween(firstPage, secondPage);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void 두개의_페이지의_계산_결과가_동일하면_0을반환() throws Exception {
        Page firstPage = new Page(List.of(21, 22));
        Page secondPage = new Page(List.of(21, 22));
        Integer result = pageComparator.comparePageBetween(firstPage, secondPage);

        assertThat(result).isEqualTo(0);
    }
}