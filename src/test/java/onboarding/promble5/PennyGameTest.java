package onboarding.promble5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;

public class PennyGameTest {
    @Test
    void separate_money_only_50000(){
        int money = 59543;
        assertThat(PennyGame.start(money)).isEqualTo(1);
    }
}
