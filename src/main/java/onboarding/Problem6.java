package onboarding;

import java.util.*;

/**
 * 구현해야할 기능
 * 객체 사용 Crew(부모 키, 이메일, 이름)
 * 부모 키의 경우 중복된 이름을 찾는데 도움을 줄 수 있음
 * ex) 제이슨, 제이엠의 경우 동일한 부모키를 갖는다.
 * 이름을 두글자씩 자른 후 이것을 해시맵으로 저장
 * 해시셋에 존재한다면 Crew의 부모키를 TwoLetters 부모키로 변경
 * 이메일을 오름차순으로 정렬하는 기능
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<Crew> crewList = new ArrayList<>();
        Map<String, Integer> tlMap = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String name = forms.get(i).get(1);
            int parentKey = -1;  // Crew 객체 사이에서 parentKey가 같을 경우 중복된 글자가 있음
            int key = -1;  // 해시맵 키찾을 때

            ArrayList<String> twoLetterList = new ArrayList<>();  // 두글자씩 저장하기 위한 배열리스트
            if (name.length() < 2) {
                twoLetterList.add(name.substring(0, 1));
            } else {
                for (int j = 0; j <= name.length() - 2; j++)
                    twoLetterList.add(name.substring(j, j + 2));
            }
            // key값을 찾는다면 twoLetterList에 있는 모든 데이터를 해시맵에 같은 value로 저장
            for (int j = 0; j < twoLetterList.size(); j++) {
                if (tlMap.containsKey(twoLetterList.get(j))) {
                    key = tlMap.get(twoLetterList.get(j));
                    break;
                }
            }

            for(int j = 0; j< twoLetterList.size(); j++) {
                if(key != -1)
                    tlMap.put(twoLetterList.get(j), key);
                else
                    tlMap.put(twoLetterList.get(j), i);
            }

            parentKey = tlMap.get(twoLetterList.get(0));
            crewList.add(new Crew(parentKey, email, name));
        }

        int[] crewCount = new int[crewList.size()];
        // 중복되는 parentKey 체크
        for (int i = 0; i < crewList.size(); i++)
            crewCount[crewList.get(i).parentKey]++;

        List<String> answer = new ArrayList<>();

        for (int i = 0; i < crewCount.length; i++) {
            if (crewCount[i] > 1) {  // 하나 이상일 시 중복되는 글자가 있다는 의미
                for (int j = 0; j < crewList.size(); j++) {
                    if (crewList.get(j).parentKey == i)
                        answer.add(crewList.get(j).email);
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }


    public static class Crew {
        int parentKey;
        String email;
        String name;

        public Crew(int parentKey, String email, String name) {
            this.parentKey = parentKey;
            this.email = email;
            this.name = name;
        }
    }
}
