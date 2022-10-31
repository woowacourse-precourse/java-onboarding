package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        System.out.println("====solution====");
        // 암호문 문자 리스트
        ArrayList<Character> result = new ArrayList<>();
        for(int i=0; i<cryptogram.length(); i++) {
            result.add(cryptogram.charAt(i));
        }
        System.out.println("result: "+ Arrays.toString(result.toArray()));

        //연속된 중복 문자 제거
        for(int i=result.size(); i>0; i--) {
            System.out.println("i: "+i);
            for(int j=0; j<result.size()-1; j++) {
                if(result.get(j) == result.get(j+1)) {
                    System.out.println("j: "+j);
                    result.remove(j);
                    result.remove(j);
                    System.out.println("result: "+ Arrays.toString(result.toArray()));
                }
            }
        }

        //문자열로 표현
        StringBuffer sb = new StringBuffer();
        if(!result.isEmpty()) {
            for(int i=0; i<result.size(); i++) {
                sb.append(result.get(i));
            }
        }
        System.out.println("====solution end====");
        return sb.toString();
    }
}
