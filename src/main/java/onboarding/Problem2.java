package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {

    public static String solution(String cryptogram) {
        Problem2 solve = new Problem2();
        solve.procException(solve.hasException(cryptogram));
        List<String> crytogram = new ArrayList<>(Arrays.asList(cryptogram.split("")));
        return solve.getDecryption(crytogram)
                .stream()
                .collect(Collectors.joining(""));
    }

    private void procException(Boolean isException) {
        if (isException) {
            throw new RuntimeException("Error Occur");
        }
    }

    private boolean hasException(String crytogram){
        if(crytogram.length() < 1 || crytogram.length() > 1000)
            return true;
        else if (crytogram.equals(crytogram.toLowerCase()) == false)
            return true;
        return false;
    }

    private List<String> getDecryption(List<String> cryptogram){
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
