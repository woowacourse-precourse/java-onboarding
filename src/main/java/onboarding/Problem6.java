package onboarding;
import java.util.*;
// 1. 기준 닉네임(standNick)과 다른 닉네임(compareNick)의 대조 : solution
//      	+) 이메일 중복 제거, 오름차순 정렬
// 2. 기준 닉네임(standNick)이 다른 닉네임(compareNick)의 일부를 포함하는지 확인 : boolean isContain(String standNick, String compareNick)
// 3. 닉네임을 2글자씩 분리해 담은 List: List<String> substrNick(String nick)
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // +) for문으로 생기는 중복을 HashSet으로 제거
        Set containList = new HashSet();
        for(int i=0; i< forms.size(); i++) {
            for(int j=0; j<forms.size()-1; j++) {
                // i==j인 경우 제외
                if(isContain(forms.get(i).get(1), forms.get(j).get(1))&&i!=j) {
                    containList.add(forms.get(i).get(0));
                }
            }
        }
        List<String> answer = new ArrayList<String>(containList);

        // 이메일 오름차순 정렬
        Collections.sort(answer);
        return answer;
    }

    // substrNick 메서드를 이용해 닉네임을 분리한 List를 구하고,
    // 그 List와 기준 닉네임(standNick) 포함 여부 확인
    public static boolean isContain(String standNick, String compareNick) {
        List<String> diverse = substrNick(compareNick);
        for(int j=0; j<diverse.size(); j++) {
            if(standNick.contains(diverse.get(j))) {
                return true;
            }
        }
        return false;
    }

    // 닉네임을 2글자식 분리하는 메서드
    public static List<String> substrNick(String nick)  {
        List<String> substNick = new ArrayList<String>();
        for(int i=0; i<nick.length()-1; i++) {
            substNick.add(nick.substring(i, i+2));
        }
        return substNick;
    }

}