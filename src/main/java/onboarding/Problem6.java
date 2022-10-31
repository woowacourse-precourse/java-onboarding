package onboarding;

import java.util.*;

public class Problem6 {
    /**
     * Goal: 신청받은 닉네임 중 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록을 오름차순으로 return 하도록
     * solution 메서드를 완성
     * How:
     *     1. forms의 element를 하나씩 iterate 한다
     *     2. element의 닉네임을 2개씩 쪼개서 Hashmap에 키로 존재하지 않는다면 키로 쓰고 밸류는 이메일로 정한다. 있다면 이메일을 결과 Set에
     *     추가한다. (*Set을 써야 중복 제거를 할 수 있다. *Hashmap을 써야 contains가 O(1)의 time complexity를 갖는다.)
     *     3. 결과 set를 리스트로 바꿔 정렬하고 리턴한다
     * @param forms ["abcd@email.com", "에비씨"] 형식의 엘리먼트가 들어있는 리스트.
     * @return
     */
    public static List<String> solution(List<List<String>> forms) {
        Set<String> result = new HashSet<String>();
        Map<String, String> nameMap = new HashMap<>();

        for (int i=0; i<forms.size(); i++) {
            List<String> emailName = forms.get(i);
            String email = emailName.get(0);
            String name = emailName.get(1);
            for (int j=0; j<name.length()-1; j++) {
                String nameSubString = name.substring(j, j+2);
                if (nameMap.containsKey(nameSubString)) {
                    if (!(nameMap.get(nameSubString) == email)) {
                        //this checks whether the substring is from the same nickname ex. "제이제이" has two "제이"
                        result.add(nameMap.get(nameSubString));
                        result.add(email);
                    }
                } else {
                    nameMap.put(nameSubString, email);
                }
            }
        }
        List<String> sortedResult = new ArrayList<>(result);
        sortedResult.sort(Comparator.naturalOrder());
        return sortedResult;
    }
}
