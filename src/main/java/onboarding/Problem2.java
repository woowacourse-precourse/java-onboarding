package onboarding;

import onboarding.problem2.CryptogramConverter;
import onboarding.problem2.ProblemTwoValidation;

import java.util.*;

public class Problem2 {

    private static Stack<String> stack = new Stack<>();

    public static String solution(String cryptogram) {
        CryptogramConverter convertor;
        try {
            convertor = new CryptogramConverter(new ProblemTwoValidation(cryptogram));
            convertor.duplicatedWord(cryptogram);

            String result = convertor.getConverterWord();
            convertor.clear();

            return result;
        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
            return "";
        }
    }
}

