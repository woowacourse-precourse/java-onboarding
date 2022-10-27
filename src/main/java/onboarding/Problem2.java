package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        Problem2 problem2 = new Problem2();

        String answer = problem2.solveCryptogram(cryptogram);

        return answer;
    }

    public String solveCryptogram(String cryptogram) {
        String modifiedCryptogram = cryptogram;
        String answer = cryptogram;

        while (true) {
            modifiedCryptogram = deleteRepeatedString(modifiedCryptogram);
            if (modifiedCryptogram.equals("NOT MODIFIED")) {
                break;
            }
            answer = modifiedCryptogram;
        }

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
