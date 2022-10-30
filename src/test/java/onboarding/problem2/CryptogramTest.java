package onboarding.problem2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CryptogramTest {
    @Test
    @DisplayName("CheckContinuity Check")
    void validateContinuityCheck(){
        Assertions.assertThat(StringZipper.checkContinuity("1234554321",1)).isEqualTo(false);
        Assertions.assertThat(StringZipper.checkContinuity("1234554321",4)).isEqualTo(true);
    }

    @Test
    @DisplayName("ZipStringOneTime Check")
    void validateZipStringOneTime(){
        Assertions.assertThat(StringZipper.zipStringOneTime("1234554321")).isEqualTo("12344321");
        Assertions.assertThat(StringZipper.zipStringOneTime("12344321")).isEqualTo("123321");
        Assertions.assertThat(StringZipper.zipStringOneTime("11223344")).isEqualTo("");
        Assertions.assertThat(StringZipper.zipStringOneTime("14")).isEqualTo("14");
    }

    @Test
    @DisplayName("ZipString Check")
    void validateZipString(){
        Assertions.assertThat(StringZipper.zipString("1234554321")).isEqualTo("");
        Assertions.assertThat(StringZipper.zipString("")).isEqualTo("");
    }
}
