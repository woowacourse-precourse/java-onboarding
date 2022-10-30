package onboarding;
import java.util.HashSet;
import java.util.Set;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuffer str = new StringBuffer(cryptogram);
        Set<Integer> set;
        Integer[] arr;
        String answer;
        while(true){
            set = new HashSet<>();
            //setSet(): 중복 문자의 인덱스를 담은 set을 생성하는 메서드
            setSet(str, set);
            arr = set.toArray(new Integer[0]);
            //isLenZero(): 중복 문자가 없을 경우 반복을 중단하는 메서드
            if (isLenZero(arr)) break;
            //delOverlapChar(): 인덱스를 통해 중복 문자를 제거하는 메서드
            delOverlapChar(str, arr);
        }
        answer = new String(str);
        return answer;
    }
}
