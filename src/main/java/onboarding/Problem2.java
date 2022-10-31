package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Problem2 {
    public static String solution(String cryptogram) {
        List<String> cryptogramList = new ArrayList<>(List.of(cryptogram.split("")));
        List<Integer> needToRemoveIndex = decryption(cryptogramList);

        while(!needToRemoveIndex.isEmpty()) {
            for (int i = needToRemoveIndex.size()-1; i >=0; i--) {
                cryptogramList.remove(needToRemoveIndex.get(i).intValue());
            }
            needToRemoveIndex = decryption(cryptogramList);
        }
        return String.join("", cryptogramList);
    }

    private static List<Integer> decryption(List<String> cryptogramList) {
        List<Integer> needToRemoveIndex = new ArrayList<>();

        for(int i = 1; i < cryptogramList.size() ; i++) {
            if (Objects.equals(cryptogramList.get(i), cryptogramList.get(i-1))) {
                needToRemoveIndex.add(i-1);
                if(i == cryptogramList.size()-1) needToRemoveIndex.add(i);
            } else {
                if(!needToRemoveIndex.isEmpty() && Objects.equals(cryptogramList.get(i-1), cryptogramList.get(needToRemoveIndex.get(needToRemoveIndex.size()-1)))) {
                    needToRemoveIndex.add(i-1);
                }
            }
        }
        return needToRemoveIndex;
    }
}
