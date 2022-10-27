package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem2 {
    /*
    1. for문을 돌려 start를 찾음
    2. 만약 start가 존재한다면 for문을 돌려 end 를 찾음
    3. 이후 start ~ end 까지를 삭제
    4. 문자열에 연속되는 문자열이 없을때 까지 1 - 5를 반복한다.
    * */
    public static String solution(String cryptogram) {

        while(cryptogram.length() > 1) {
            if(cryptogram.length() == 2) {
                if(cryptogram.charAt(0) == cryptogram.charAt(1)) {
                    cryptogram = ""; break;
                } else break;
            }

            int start = -1;
            for(int i = 0; i<cryptogram.length()-1; i++) {
                if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                    start = i; break;
                }
            }

            if(start != -1) {
                int end = start;
                for(int i = start+1; i<cryptogram.length(); i++) {
                    if(cryptogram.charAt(start) != cryptogram.charAt(i)) {
                        end = i; break;
                    }
                }

                StringBuilder sb = new StringBuilder();
                sb.append(cryptogram);
                sb.replace(start, end, "");
                cryptogram = sb.toString();
            } else break;
        }
        return cryptogram;

        //처음에 생각했던 풀이방법. 불필요한 중복이 많아 위의 코드로 변경
/*        while(true) {
            Set<Integer> chars = new HashSet<>();
            for(int i = 0; i< cryptogram.length()-1; i++) {
                if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                    chars.add(i);
                    chars.add(i+1);
                }
            }
            if(chars.size() == 0) break;
            StringBuilder sb = new StringBuilder();
            sb.append(cryptogram);
            for(Integer i : chars) {
                sb.replace(i,i+1," ");
            }
            cryptogram = sb.toString();
            cryptogram = cryptogram.replaceAll(" ", "");
        }
        return cryptogram;*/
    }
}
