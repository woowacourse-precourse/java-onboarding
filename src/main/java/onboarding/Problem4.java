package onboarding;

import java.util.Scanner;

public class Problem4 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Problem4 ra = new Problem4();
        Scanner sc = new Scanner(System.in);
        System.out.println("알파벳을 입력하시오");
        String str = sc.nextLine();
        System.out.println("sol : " + str);
        System.out.println(ra.solution(str));

    }

    public String solution(String word) {
        String result = "";
        char[] wordtmp = word.toCharArray();
        int rev, abs, ascii = 0;
        for(int i = 0; i < wordtmp.length; i++) {
            if(Character.isUpperCase(wordtmp[i]))
            {
                ascii = 65;
            }else if(Character.isLowerCase(wordtmp[i]))
            {
                ascii = 97;
            }else {
                result = result + ' ';
                continue;
            }
            abs = Math.abs(ascii - wordtmp[i]);
            rev = (ascii + 25) - abs;
            result = result + String.valueOf((char) rev);
        }

        return result;
    }

}
