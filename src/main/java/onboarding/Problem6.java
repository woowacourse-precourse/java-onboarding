package onboarding;

import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
//      System.out.println(getAllTwoWordsByNickname("간장공장공장장")); // 간장, 공장, 장공, 장장
        return answer;
    }
    
    /**
     * 주어진 닉네임을 이루는 모든 두 글자 문자열을 반환한다.
     * @param nickname
     * @return 중복 없는 모든 두 글자 문자열
     */
    private static HashSet<String> getAllTwoWordsByNickname(String nickname) {
    	HashSet<String> twoWords = new HashSet<>();
    	for (int i = 0; i < nickname.length()-1; i++) {
    		twoWords.add(nickname.substring(i, i+2));
    	}
    	return twoWords;
    }
}
