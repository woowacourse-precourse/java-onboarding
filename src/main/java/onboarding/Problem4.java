package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int code = 0;
        char[] c = new char[word.length()];
        char tttt = 'A';

        System.out.println("tttt = " + (tttt-48));

        for (int i = 0; i < 10; i++) {
            i++;
            System.out.println("i = " + i);
        }

        for (int i = 0; i < word.length(); i++) {
            c = word.toCharArray();
            System.out.println("c[i] = " + c[i]);
            System.out.println("(c[i]-'0') = " + (c[i]+'0'));
            int test = c[i]-'0';
            System.out.println("test = " + (test+'0'));
        }



//        for (int i = 0; i < word.length(); i++) {
//            code = word.charAt(i)+19;
//            System.out.println("code = " + code);
//            char c = (char)code;
//            System.out.println("c = " + c);
//        }
        
        return answer;
    }
}
