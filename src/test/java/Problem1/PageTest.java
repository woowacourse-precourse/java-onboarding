package Problem1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageTest {

    @Test
    @DisplayName("올바른 페이지 입력")
    void checkPageSuccess() {
        Page page = new Page(5, 6);
        assertTrue(page.checkPage());
    }

    @Test
    @DisplayName("범위 오류")
    void checkPageFailWithRange() {
        Page page = new Page(451, 452);
        assertFalse(page.checkPage());
    }

    @Test
    @DisplayName("타입(짝수, 홀수) 오류")
    void checkPageFailWithType() {
        Page page = new Page(242, 243);
        assertFalse(page.checkPage());
    }

    @Test
    @DisplayName("연속 페이지 오류")
    void checkPageFailWithNext() {
        Page page = new Page(101, 108);
        assertFalse(page.checkPage());
    }
}