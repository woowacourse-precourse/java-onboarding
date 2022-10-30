package onboarding;

import java.util.Arrays;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int code = 0;
        char[] c = new char[word.length()];
        char tttt = 'A';

        /**
         * A,B,C~~~~ Z까지의 값을 담을(26개) String 배열 생성,
         * Z,Y,X~~~~ A까지의 값을 담을(26개) String 배열 생성
         */
        String[] up = new String[26];
        String[] down = new String[26];

        /**
         * a,b,c ~~~ z까지의 값을 담을(26개) String 배열 생성,
         * z,y,x ~~~ a까지의 값을 담을(26개) String 배열 생성
         */
        String[] upup = new String[26];
        String[] downdown = new String[26];

        /**
         * 아스키 코드를 이용해서, up에는 A,B,C 순서대로 담고
         * down에는 Z,Y,X순서대로 담는다.
         *
         * upup에는 소문자 a,b,c / downdown에는 소문자 z,y,x
         */
        for (int i = 0; i < 26; i++) {
            up[i] = ""+(char)('A'+ i);
            down[i] = ""+(char)('Z'-i);

            upup[i] = ""+(char)('a'+i);
            downdown[i] = ""+(char)('z'-i);
            System.out.println("up[i] = " + up[i]);
            System.out.println("down = " + down[i]);

            System.out.println("upup[i] = " + upup[i]);
            System.out.println("downdown = " + downdown[i]);
        }


        /**
         * word.length만큼 배열을 돌리면서, word의 값이 대문자 일 때, 소문자일 때, 공백일 때, 배열에 포함된 문자가 아닐 때로 나누었다.
         * 대문자일 때 , 그 값을 대문자 배열 (up)에 그 값을 넣어서 인덱스 번호를 찾고,
         * 거꾸로 만들어놓은 down배열에 그 인덱스 번호를 넣어서 청개구리의 언어를 만든다.
         */
        for (int i = 0; i < word.length(); i++) {
            if ('A' <= word.charAt(i) && word.charAt(i) <= 'Z') {
                System.out.println("Arrays.asList(up,word.charAt(i)) = " + Arrays.asList(up).indexOf(""+word.charAt(i)));
                System.out.println("down[Arrays.asList(up)] = " + down[Arrays.asList(up).indexOf(""+word.charAt(i))]);
                answer += down[Arrays.asList(up).indexOf(""+word.charAt(i))];
            }else if (word.charAt(i) == ' ') {
                answer += " ";
            }else if ('a' <= word.charAt(i) && word.charAt(i) <= 'z') {
                answer += downdown[Arrays.asList(upup).indexOf(""+word.charAt(i))];
            }else {
                answer += word.charAt(i);
            }
        }

        System.out.println("answer = " + answer);

//        for (int i = 0; i < word.length(); i++) {
//            c = word.toCharArray();
//            System.out.println("c[i] = " + c[i]);
//            System.out.println("(c[i]-'0') = " + (c[i]+'0'));
//            int test = c[i]-'0';
//            System.out.println("test = " + (test+'0'));
//        }
//
//
//
//        for (int i = 0; i < word.length(); i++) {
//            code = word.charAt(i)+19;
//            System.out.println("code = " + code);
//            char c = (char)code;
//            System.out.println("c = " + c);
//        }
        
        return answer;
    }
}
