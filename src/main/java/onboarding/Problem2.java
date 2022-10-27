package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public String deleteRepeatedCharacter(String cryptogram, int repeatStartIndex) {
        List<String> cryptogramList = new ArrayList<>(Arrays.asList(cryptogram.split("")));

        while (cryptogramList.get(repeatStartIndex).equals(cryptogramList.get(repeatStartIndex + 1))) {
            cryptogramList.remove(repeatStartIndex);
        }
        cryptogramList.remove(repeatStartIndex);

        String modifiedCryptogram = String.join("", cryptogramList);

        return modifiedCryptogram;
    }
}
