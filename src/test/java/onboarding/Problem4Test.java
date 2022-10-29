package onboarding;

import org.junit.jupiter.api.Test;

import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Problem4Test {

    @Test
    void createAlphaTest(){
        HashMap<Character, Character> map = Problem4.createAlphabetMap();
        Set<Character> keySet = map.keySet();
        keySet.forEach(key -> {
            System.out.println("key = " + key + " value = " + map.get(key));
        });
    }
}