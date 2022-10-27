package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public String deleteRepeatedString(String cryptogram) {
        boolean isModified = false;
        String modifiedCryptogram = cryptogram;

        int index = 0;
        while (index < (modifiedCryptogram.length() - 1)) {
            if (modifiedCryptogram.charAt(index) == modifiedCryptogram.charAt(index + 1)) {
                modifiedCryptogram = deleteRepeatedCharacter(modifiedCryptogram, index);
                isModified = true;
            } else {
                index++;
            }
        }

        if (!isModified) {
            modifiedCryptogram = "NOT MODIFIED";
        }

        return modifiedCryptogram;
    }

    public String deleteRepeatedCharacter(String cryptogram, int repeatStartIndex) {
        List<String> cryptogramList = new ArrayList<>(Arrays.asList(cryptogram.split("")));

        while ((cryptogramList.size() > 1) &&
            (cryptogramList.get(repeatStartIndex).equals(cryptogramList.get(repeatStartIndex + 1)))) {
            cryptogramList.remove(repeatStartIndex);
        }
        cryptogramList.remove(repeatStartIndex);

        String modifiedCryptogram = String.join("", cryptogramList);

        return modifiedCryptogram;
    }
}
