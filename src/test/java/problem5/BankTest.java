package problem5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    @DisplayName("바꿀 수 있는 화폐로 교환")
    void withdraw() {
        List<Integer> result =
                new ArrayList<>(Arrays.asList(1, 0, 0, 0, 0, 2, 0, 3, 7));
        assertEquals(result, new Bank(50237).withdraw());
    }
}