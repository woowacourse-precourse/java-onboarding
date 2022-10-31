package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem5Test {


    @Test
    void walletTest1(){
        int money = 50_237;
        List<Integer> result = Problem5.putInWallet(money);

        List<Integer> answer = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
        assertThat(result).isEqualTo(answer);
    }


    @Test
    void walletTest2(){
        int money = 15_000;
        List<Integer> result = Problem5.putInWallet(money);

        List<Integer> answer = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
        assertThat(result).isEqualTo(answer);
    }
}
