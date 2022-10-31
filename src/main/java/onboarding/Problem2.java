package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        if(hasException(cryptogram)){
            return null;
        }
        List<String> crytogram = new ArrayList<>(Arrays.asList(cryptogram.split("")));
        return getDecryption(crytogram)
                .stream()
                .collect(Collectors.joining(""));
    }

    public static boolean hasException(String crytogram) {
        if (crytogram.length() < 1 || crytogram.length() > 1000)
            return true;
        else if (crytogram.equals(crytogram.toLowerCase()) == false)
            return true;
        return false;
    }

    public static List<String> getDecryption(List<String> cryptogram){
        int currentIndex=0;
        while(cryptogram.size() > currentIndex && cryptogram.size() > currentIndex+1){
            int nextIndex = currentIndex+1;
            if (cryptogram.get(currentIndex).equals(cryptogram.get(nextIndex)) == true) {
                cryptogram.remove(currentIndex);
                cryptogram.remove(currentIndex);
                currentIndex = 0;
                continue;
            }
            currentIndex = nextIndex;
        }
        return cryptogram;
    }
}
