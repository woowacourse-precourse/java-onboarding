package onboarding;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Set;

class Problem4Test {

    @Test
    void createAlphaTest(){
        HashMap<Character, Character> map = Problem4.createAlphabetMap();
        Set<Character> keySet = map.keySet();
        keySet.forEach(key -> {
            System.out.println("key = " + key + " value = " + map.get(key));
        });
    }

    @Test
    void solutionTest(){
        String result = Problem4.solution("I love you");
        System.out.println("result = " + result);
        org.assertj.core.api.Assertions.assertThat(result).isEqualTo("R olev blf");

    }
}