package onboarding.promblem1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PagesTest {
    @Test
    void getMax(){
        List<PageNumber> pageNumber = List.of(new PageNumber(97), new PageNumber(98));
        Pages pagesNumbers = new Pages(pageNumber);
        assertThat(pagesNumbers.getMax()).isEqualTo(72);
    }
    @Test
    void compareTo(){
        List<PageNumber> pageNumber = List.of(new PageNumber(99), new PageNumber(102));
        List<PageNumber> pageNumber2 = List.of(new PageNumber(211), new PageNumber(212));
        Pages pages1 = new Pages(pageNumber);
        Pages pages2 = new Pages(pageNumber2);
        assertThat(pages1.compareTo(pages2)).isEqualTo(-1);
    }
}