package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        boolean isduplication = true;

        List<String> list_cryptogram = new ArrayList<>(List.of(cryptogram.split("")));
        List<Integer> deleteIndex = new ArrayList<Integer>();
        while (isduplication) {
            deleteIndex.clear();

            String str = "";
            for (int i=0; i<list_cryptogram.size(); i++) {
                if (str.equals(list_cryptogram.get(i))) {
                    deleteIndex.add(i - 1);
                    deleteIndex.add(i);
                }
                str = list_cryptogram.get(i);
            }

            if (deleteIndex.size() == 0) {
                isduplication = false;
                continue;
            }

            for (int i=deleteIndex.size()-1; i >= 0; i--) {
                int index = deleteIndex.get(i);
                list_cryptogram.remove(index);
            }
        }

        String answer = "";
        for (int i=0; i<list_cryptogram.size(); i++) {
            answer += list_cryptogram.get(i);
        }

        return answer;
    }
}
