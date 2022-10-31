package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Problem2 {
    static String result = "";
    public static String solution(String cryptogram) {

        String answer = "answer";
        String[] arr = cryptogram.split("");
        answer = comp(arr);
        System.out.println(cryptogram + "     " + answer);
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
}
