package onboarding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class Problem2Test {

    @Test
    @DisplayName("빈 문자열 테스트")
    void blankTest(){
       String word = "";
        String result = Problem2.deduplicate(word);

        assertThat(result).isEqualTo("");
    }

    @Test
    @DisplayName("테스트 1")
    void test1(){
        String word = "browoanoommnaon";
        String result = Problem2.deduplicate(word);

        assertThat(result).isEqualTo("brown");
    }

    @Test
    @DisplayName("테스트 2")
    void test2(){
        String word = "zyelleyz";
        String result = Problem2.deduplicate(word);

        assertThat(result).isEqualTo("");
    }
}
