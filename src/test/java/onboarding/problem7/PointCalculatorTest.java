package onboarding.problem7;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class PointCalculatorTest {

    PointCalculator calculator = new FriendPointCalculator();

    @Test
    void 입력된_친구_목록과_친구_점수로_계산된_키밸류_반환_성공() throws Exception {
        List<String> friends = List.of("hi", "bi", "ti", "hi", "hi");
        Map<String, Integer> result = calculator.calculateWithPoint(friends, 10);

        Map<String, Integer> expect = new HashMap<>();
        expect.put("hi",30);
        expect.put("bi",10);
        expect.put("ti",10);
        assertThat(result).containsAllEntriesOf(expect);
    }
}