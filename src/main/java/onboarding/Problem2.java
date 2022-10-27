package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        answer = remove_str(cryptogram);

        return answer;
    }

    private static String remove_str(String crypto) {
        List<String> crypto_list = new ArrayList<>();
        String[] str = crypto.split("");

        for(String crypto_str : str) {
            crypto_list.add(crypto_str);
        }

        int count = 0;
        boolean remove_str = false;
        for(int i = 1; i < crypto_list.size(); i++) {
            if (crypto_list.get(i).equals(crypto_list.get(i - 1))) {
                count += 1;
            }

            if (count == 1) {
                crypto_list.remove(i - 1);
                crypto_list.remove(i - 1);
                count = 0;
                remove_str = true;
            }
        }

        String crypto_str = String.join("", crypto_list);

        if(remove_str) {
            crypto_str = remove_str(crypto_str);
        }

        return crypto_str;

    }
}
