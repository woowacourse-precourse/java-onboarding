package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    // 중복 제거하기
    private static String delOverlap(String s){
        if (s.equals("")){
            return "";
        }

        List<Character> arr = new ArrayList<Character>();
        // 초기값 입력
        arr.add(s.charAt(0));
        char tmp = '-';
        for (int k = 1; k<s.length(); k++){
            // 중복이여서 없앤 요소가 또 중복인 경우 (같은 문자가 연속 3번이상 등장하는 경우)
            if (tmp == s.charAt(k)) {
                continue;
            }
            if (arr.size()==0){
                // 앞쪽에 중복이 있어서 arr에 남아있는게 없는 경우
                tmp = '-';
                arr.add(s.charAt(k));
            }
            if (arr.get(arr.size()-1)==s.charAt(k)){
                // 중복인 경우 (같은 문자가 연속 2번 등장하는 경우)
                tmp = s.charAt(k);
                arr.remove(arr.size()-1);
            } else{
                tmp = '-';
                arr.add(s.charAt(k));
            }
        }

        // List를 String으로 변환
        StringBuilder builder = new StringBuilder(arr.size());
        for(Character ch: arr) {
            builder.append(ch);
        }
        String result = builder.toString();

        return result;
    }

    public static String solution(String cryptogram) {
        String answer;

        answer = delOverlap(cryptogram);

        return answer;
    }
}
