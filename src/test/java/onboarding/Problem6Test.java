package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem6Test {

    Problem6 problem6;

    @Test
    @DisplayName("2개의 닉네임 비교하여 연속된 글자가 있는지 판단하기")
    void containsWord() {
        problem6 = new Problem6();
        assertTrue(problem6.containsWord("제이엠", "제이슨"));
        assertFalse(problem6.containsWord("제이엠", "이제엠"));
    }


}