package onboarding.problem3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Game369Test {
    @Test
    @DisplayName("CheckNumberIs 3 6 9")
    void validateCheckNumberIs369(){
        Assertions.assertThat(Game369.checkNumberIs369(0)).isEqualTo(false);
        Assertions.assertThat(Game369.checkNumberIs369(1)).isEqualTo(false);
        Assertions.assertThat(Game369.checkNumberIs369(2)).isEqualTo(false);
        Assertions.assertThat(Game369.checkNumberIs369(3)).isEqualTo(true);
        Assertions.assertThat(Game369.checkNumberIs369(4)).isEqualTo(false);
        Assertions.assertThat(Game369.checkNumberIs369(5)).isEqualTo(false);
        Assertions.assertThat(Game369.checkNumberIs369(6)).isEqualTo(true);
        Assertions.assertThat(Game369.checkNumberIs369(7)).isEqualTo(false);
        Assertions.assertThat(Game369.checkNumberIs369(8)).isEqualTo(false);
        Assertions.assertThat(Game369.checkNumberIs369(9)).isEqualTo(true);
    }

    @Test
    @DisplayName("get clap counts of a number")
    void validateGetClapTimeOfNumber(){
        Assertions.assertThat(Game369.getClapTimeOfNumber(1255)).isEqualTo(0);
        Assertions.assertThat(Game369.getClapTimeOfNumber(665)).isEqualTo(2);
        Assertions.assertThat(Game369.getClapTimeOfNumber(155)).isEqualTo(0);
        Assertions.assertThat(Game369.getClapTimeOfNumber(305)).isEqualTo(1);
        Assertions.assertThat(Game369.getClapTimeOfNumber(240)).isEqualTo(0);
        Assertions.assertThat(Game369.getClapTimeOfNumber(145255)).isEqualTo(0);
        Assertions.assertThat(Game369.getClapTimeOfNumber(9999)).isEqualTo(4);
    }

    @Test
    @DisplayName("get total clap counts of numbers in range")
    void validateGetTotalClapTimeOfNumbersInRange(){
        Assertions.assertThat(Game369.getTotalClapTimeOfNumbersInRange(3,3)).isEqualTo(1);
        Assertions.assertThat(Game369.getTotalClapTimeOfNumbersInRange(1,1)).isEqualTo(0);
        Assertions.assertThat(Game369.getTotalClapTimeOfNumbersInRange(1,10)).isEqualTo(3);
        Assertions.assertThat(Game369.getTotalClapTimeOfNumbersInRange(1,20)).isEqualTo(6);
        Assertions.assertThat(Game369.getTotalClapTimeOfNumbersInRange(1,30)).isEqualTo(10);
        Assertions.assertThat(Game369.getTotalClapTimeOfNumbersInRange(1,40)).isEqualTo(22);
    }
}
