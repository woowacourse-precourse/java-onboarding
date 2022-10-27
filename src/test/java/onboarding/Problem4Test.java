package onboarding;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Problem4Test {

    @Test
    void makeDict() {

        Map<String, String> result = Problem4.makeDict();

        System.out.println(result);
    }
}