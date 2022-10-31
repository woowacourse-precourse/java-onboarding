package onboarding;
import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {

        Map <String,Integer>map=makeMap(cryptogram);
        String answer = countoverlap(map);

        return answer;
    }

    // 중복 확인을 위해 map 자료구조를 이용하여 문자가 몇번 반복 되는지를 저장
    static Map<String,Integer> makeMap(String str){
        Map<String,Integer> map = new LinkedHashMap<>();
        for(int i = 0;i<str.length();i++) {
            String key = String.valueOf(str.charAt(i));

            if (!map.containsKey(key)){
                map.put(key,0);
            }else{
                map.put(key,map.get(key)+1);
            }
        }
        return map;
    }

    // map 에서 계산한 벨류값으로 중복되지 않은 문자를 확인하는 메소드
    static String countoverlap(Map <String,Integer> map){
        String answer = "";
        for(String key : map.keySet()) {
            int value = map.get(key);
            // 홀수이면 제거
            if (value %2 == 0){
                answer = answer + key;
            }
        }
        return answer;
    }
}
