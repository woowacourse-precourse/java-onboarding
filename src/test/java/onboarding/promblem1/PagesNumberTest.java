package onboarding.promblem1;

import onboarding.promblem1.PageException;
import onboarding.promblem1.PageNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PagesNumberTest {

    @Test
    void case2_max() {

        PageNumber pageNumber = new PageNumber(97);
        assertThat(63).isEqualTo(pageNumber.getMax());
    }

    @Test
    void throw_if_MaxOrMin(){
        assertAll(
                () -> assertThrows(PageException.class, () -> new PageNumber(1)),
                () -> assertThrows(PageException.class, () -> new PageNumber(400))
        );
    }
}