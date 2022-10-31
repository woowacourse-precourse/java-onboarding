package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Problem2 {
    static String result = "";
    public static String solution(String cryptogram) {

        if(!checkStringLength(cryptogram))
            return result;

        String word = cryptogram.toLowerCase();
        String answer = "answer";
        String[] arr = word.split("");
        answer = comp(arr);
        return answer;
    }

    public static String comp(String[] arr) {

        List<String> stringList = new ArrayList<>(Arrays.asList(arr));

        for (int i = 1; i < stringList.toArray().length; i++) {
            if (Objects.equals(arr[i], arr[i - 1])) {
                stringList.remove(i - 1);
                stringList.remove(i - 1);
                String[] array = stringList.toArray(new String[stringList.size()]);
                result = String.join("", stringList);
                comp(array);
                return result;
            }

        }

        return result;
    }

    public static boolean checkStringLength(String cryptogram){
        return cryptogram.length()>=1 && cryptogram.length()<=1000;
    }
}
