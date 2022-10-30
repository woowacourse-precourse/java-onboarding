package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Problem6 {

    private static int sequence;
    private final static String EMAIL_DOMAIN = "@email.com";
    private static Map<String, Integer> indexMap = new HashMap<>();
    private static List<Integer>[] trieList;
    private static List<Pair> checkList = new ArrayList<>();

    private static boolean checkEmail(String email) {
        if (email == null)
            return true;
        else if (email.length() < 11 || email.length() > 19)
            return true;
        else if (!email.endsWith(EMAIL_DOMAIN))
            return true;
        return false;
    }

    private static boolean checkNickname(String nickname) {
        if (nickname == null)
            return true;
        else if (nickname.length() < 1)
            return true;
        for (int i=0; i<nickname.length(); i++)
            if (Character.getType(nickname.charAt(i)) != 5)
                return true;
        return false;
    }

    private static void parseForms(String nickname) {
        String c1, c2;
        int length = nickname.length();

        if (length == 1) {
            c1 = nickname.substring(0, 1);
            if (!indexMap.containsKey(c1)) {
                indexMap.put(c1, sequence++);
            }
        } else {
            for (int i = 0; i < length - 1; i++) {
                c1 = nickname.substring(i, i + 1);
                c2 = nickname.substring(i + 1, i + 2);
                if (!indexMap.containsKey(c1)) {
                    indexMap.put(c1, sequence++);
                }
                if (!indexMap.containsKey(c2)) {
                    indexMap.put(c2, sequence++);
                }
            }
        }
    }

    private static void initSolution(List<List<String>> forms) {
        int size = forms.size();

        indexMap.clear();
        sequence = 0;
        checkList.clear();
        for (int i = 0; i < size; i++) {
            parseForms(forms.get(i).get(1));
        }
        trieList = new ArrayList[sequence];
        for (int i = 0; i < sequence; i++) {
            trieList[i] = new ArrayList<>();
        }
    }

    private static boolean checkParam(List<List<String>> forms) {
        if (forms == null)
            return true;
        int size = forms.size();
        if (size == 0 || size > 10000)
            return true;
        for (int i=0; i<size; i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            if (checkEmail(email) || checkNickname(nickname))
                return true;
        }
        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static class Pair {
        Integer i1;
        Integer i2;

        public Pair(Integer i1, Integer i2) {
            this.i1 = i1;
            this.i2 = i2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair pair = (Pair)o;
            return Objects.equals(i1, pair.i1) && Objects.equals(i2, pair.i2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(i1, i2);
        }
    }
}
