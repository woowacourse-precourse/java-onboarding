package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();

            boolean isOverlap = false;
            HashSet<Integer> set = new HashSet<Integer>();

            outerLoop:
            for(int i = 0; i < forms.size(); i++)
            {
                /*비교할 기준이 될 회원의 이름*/
                String comparedName = forms.get(i).get(1);
                int camparedNameLen = comparedName.length();

                /*이름이 2글자 이상이면 검색 시작*/
                if(camparedNameLen >= 2){
                    for(int j = 1; j < camparedNameLen; j++)
                    {
                        String searchStr = comparedName.substring(j-1,j+1);
                        /* 문자열을 다른 항목들에 검색함 */
                        for(int k = i + 1; k < forms.size(); k++)
                        {
                            if(forms.get(k).get(1).indexOf(searchStr) != -1) {
                                set.add(i); //기준이 되는 값의 인덱스 저장
                                set.add(k); //비교하고 있는 인덱스 저장
                            }
                        }
                    }
                }
            }
        /* set을 answer(list)에 추가함 */
        Iterator<Integer> iterSet = set.iterator();
        while(iterSet.hasNext()){
            answer.add(forms.get(iterSet.next()).get(0));
        }

        /* 오름차순 정렬*/
        Collections.sort(answer);

        return answer;
    }
}
