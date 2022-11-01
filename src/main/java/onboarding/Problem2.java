package onboarding;



public class Problem2 {
    public static String solution(StringBuilder str2, int length) {
        StringBuilder str = str2;
        System.out.println(str);
        for (int i = 0; i < length; i++) {
            if (str.length() == 0) {
                return "";
            }
            System.out.println("i : " + i);
            if (i+1 < str.length()) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    System.out.println("str.charAt(i) : " + str.charAt(i));
                    System.out.println("str.charAt(i+1) : " + str.charAt(i + 1));
                    str.deleteCharAt(i);
                    str.deleteCharAt(i);
                    length -= 2;
                    solution(str, length);
                }
            }

        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s = "browoanoommnaon";
//		String s = "zyelleyz";
        StringBuilder str = new StringBuilder(s);

        System.out.println("test : " + (solution(str, s.length())));

    }
}
