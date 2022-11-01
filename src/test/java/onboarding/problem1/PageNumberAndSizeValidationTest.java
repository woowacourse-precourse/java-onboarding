package onboarding.problem1;

import onboarding.problem1.infra.PageNumberAndSizeValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PageNumberAndSizeValidationTest {

    @Test
    @DisplayName("포비님과 크롱님의 펼친 페이지의 사이즈가 2가 맞는지 테스트")
    void isPageSize() {
        // given
        List<Integer> pobi = new ArrayList<>() {{
            add(99);
            add(100);
        }};

        List<Integer> crong = new ArrayList<>() {{
            add(201);
            add(202);
        }};

        PageNumberAndSizeValidation validation = new PageNumberAndSizeValidation();

        // when
        validation.checkedPageSize(pobi.size(), crong.size());

        // then
        assertThat(validation).isNotNull();
    }

    @Test
    @DisplayName("유효하지 않는 데이터가 들어온 경우 예외를 던진다.")
    void isPageNumberValidation() {
        // given
        List<Integer> woowahanTeacher1 = new ArrayList<>() {{
            add(1);
            add(400);
        }};

        List<Integer> woowahanTeacher2 = new ArrayList<>() {{
            add(99);
            add(102);
        }};

        List<Integer> woowahanTeacher3 = new ArrayList<>() {{
            add(403);
            add(404);
        }};

        // when
        PageNumberAndSizeValidation validation = new PageNumberAndSizeValidation();

        // then
        assertThatThrownBy(() -> validation.checkedPageNumber(woowahanTeacher1.get(0), woowahanTeacher1.get(1)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validation.checkedPageNumber(woowahanTeacher2.get(0), woowahanTeacher1.get(1)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validation.checkedPageNumber(woowahanTeacher3.get(0), woowahanTeacher1.get(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}