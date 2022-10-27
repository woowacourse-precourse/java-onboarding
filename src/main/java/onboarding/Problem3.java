package onboarding;

import java.util.List;

/**
 * 기능 요구사항
 * 1. 3, 6, 9의 개수를 세는 메서드를 작성한다.
 */
public class Problem3 {
    static int answer;
    static List<Character> threeSixNine = List.of('3','6','9');
    public static int solution(int number) {
        answer = countClap(number);
        return answer;
    }

    public static int countClap(int number){
        for(int i=1;i<=number;i++){
            String str = String.valueOf(i);
            for(int j=0;j<str.length();j++){
                if(threeSixNine.contains(str.charAt(j))){
                    answer++;
                }
            }
        }
        return answer;
    }
}
