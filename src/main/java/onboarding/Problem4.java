package onboarding;

public class Problem4 {
    public static String solution(String word) {
        //대소문자 배열
        System.out.println("====solution====");
        char[] lower = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] upper = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        //청개구리 표현
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<word.length(); i++) {
            if(isAlphabet(word.charAt(i))==1) {
                sb.append(lower[25-((int)word.charAt(i)-97)]);
            } else if(isAlphabet(word.charAt(i))==2) {
                sb.append(upper[25-((int)word.charAt(i)-65)]);
            } else {
                sb.append(word.charAt(i));
            }
        }

        System.out.println("====solution end====");
        return sb.toString();
    }

    public static int isAlphabet(char ch) {
        if(String.valueOf(ch).matches("(^[a-z]$)")) {
            //소문자면 리턴 1
            System.out.println("ch: "+ch+", (int)ch: "+(int)ch);
            return 1;
        } else if(String.valueOf(ch).matches("(^[A-Z]$)")) {
            //대문자면 리턴 2
            System.out.println("ch: "+ch+", (int)ch: "+(int)ch);
            return 2;
        }
        //알파벳이 아니면 -1 리턴
        return -1;
    }
}
