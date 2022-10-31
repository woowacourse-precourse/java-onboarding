package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        ArrayList<String> duplicateList = new ArrayList<>(Arrays.asList("aa","bb","cc","dd","ee","ff","gg","hh","ii","jj","kk","ll","mm","nn","oo","pp","qq","rr","ss","tt","uu","vv","ww","xx","yy","zz"));
        System.out.println(duplicateList);
//cryptogram에서 중복문자를 골라낼 중복문자를 담은 매열 duplicateList를 생성
        String answer;
        int j = 0;
        do {
            System.out.println("전"+cryptogram);
            answer = cryptogram;

            System.out.println("전컴페어"+answer);
            for (int i=0;duplicateList.size()>i;i++){
                cryptogram = cryptogram.replace(duplicateList.get(i),"");
            }
            System.out.println("조건문전크립"+cryptogram);
            System.out.println("조건문전"+answer);
            if (answer.equals(cryptogram)) {break;}
            j += 1;
        } while(j<9999999);
        System.out.println("결과는"+answer);
// duplicateList내의 중복문자를 for문을 통해 한번씩 제거하되, do while식의 조건으로 로직전과 로직후가 동일하다면 그시점에서 break, while문법을 고려하여 j값은 충분히 큰 수를 줌
        System.out.println(answer);
        return answer;
    }
}
