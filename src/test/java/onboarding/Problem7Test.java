package onboarding;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class Problem7Test {

    @Test
    void 사용자목록테스트() {
        String user = "hansu";
        List<List<String>> friends = List.of(
                List.of("hansu", "sungjoon"),
                List.of("hansu", "jiwon"),
                List.of("sungjoon", "chaemin"),
                List.of("minjae", "hansu"),
                List.of("jaewoo", "minjae"),
                List.of("hansu", "jaewoo")
        );
        List<String> visitors = List.of("sungjoon", "sungjoon", "minjae", "jiwon", "invidam", "invidam", "sonny");
        Map<String, Integer> result = new HashMap<String, Integer>();
        result.put("hansu", 0);
        result.put("sungjoon", 0);
        result.put("jiwon", 0);
        result.put("chaemin", 0);
        result.put("minjae", 0);
        result.put("jaewoo", 0);
        result.put("invidam", 0);
        result.put("sonny", 0);

        assertThat(Problem7.fillUserList(user,friends,visitors)).isEqualTo(result);
    }

}