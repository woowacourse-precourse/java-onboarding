package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {

    static Map<String,String> formMap = new HashMap<>();
    static Map<String,Integer> nameCountMap = new HashMap<>();

    /*
    *기능 정리
    *1. forms의 이름을 key, email은 value로 <String,String> hashMap에 저장
    *2. key로 저장해둔 이름을 꺼내서 2글자 이상으로 만들 수 있는 문자열 경우의 수를 모두 따짐. 그리고 <String,int>hashMap에 각 문자열 개수를 저장.
    *3. <String,int>hashMap의 value값이 2이상인 값은 중복된 이름이므로 해당 key값을 가진 value(email)을 list에 저장
    *4. list 정렬 하고 return
    * */

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer =
        return answer;
    }
}
