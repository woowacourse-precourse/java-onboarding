package onboarding;

public class Problem2 {

    public String solution(String word) {
        StringBuilder str = new StringBuilder(word);
        String sol = check(str, word.length());
        return sol;
    }

    public static String check(StringBuilder str2, int length) {
        StringBuilder str = str2;
        System.out.println(str);
        for (int i = 0; i < length; i++) {
            if (str.length() == 0) {
                return "";
            }
            //System.out.println("i : " + i);
            if (i+1 < str.length()) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    //System.out.println("str.charAt(i) : " + str.charAt(i));
                    //System.out.println("str.charAt(i+1) : " + str.charAt(i + 1));

                    str.deleteCharAt(i);
                    str.deleteCharAt(i);
                    length -= 2;

                    check(str, length);
                }
            }

        }
        return str.toString();
    }


}