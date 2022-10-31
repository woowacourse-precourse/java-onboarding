package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> emailSet = new HashSet<>();

        for (int i=0; i<forms.size(); i++)
            findAndAddEmail(emailSet, forms, i);

        List<String> answer = new ArrayList<>(emailSet);
        answer.sort(Comparator.naturalOrder());

        return answer;
    }

    public static void findAndAddEmail(HashSet<String> emailSet,
                                       List<List<String>> forms,
                                       int start) {
        String myNickName = forms.get(start).get(1);
        String myEmail = forms.get(start).get(0);
        for (int j=start+1; j<forms.size(); j++) {
            String otherNickName = forms.get(j).get(1);
            String otherEmail = forms.get(j).get(0);
            String shortNickName = myNickName;
            String longNickName = otherNickName;

            if (myNickName.length() > otherNickName.length()) {
                shortNickName = otherNickName;
                longNickName = myNickName;
            }

            for (int k=0; k<shortNickName.length() - 1; k++) {
                String somePart = shortNickName.substring(k, k + 2);
                if (longNickName.contains(somePart)) {
                    emailSet.add(myEmail);
                    emailSet.add(otherEmail);
                }
            }
        }
    }
}

/*
<<요구사항>>
1. 이메일과 닉네임 쌍 리스트가 입력으로 들어온다
2. 같은 글자가 연속되는 사람들을 모두 찾아 이메일만 뽑아낸다
3. 뽑아낸 이메일들을 오름차순으로 정렬하고 중복은 제거해서 리턴한다
 */

/*
<<기능 목록>>
- [V] 중복되는 사람들의 이메일을 모을 emailSet를 만든다
- [V] forms를 순회하며 이메일과 닉네임을 가져온다
- [V] 그 다음 번 사람부터 마지막 사람까지 순회하며 이메일과 닉네임을 가져온다
- [V] 두 사람의 닉네임 중 더 짧은 걸 고른다
- [V] 더 짧은 닉네임에서 2글자씩 뽑는다
- [V] 뽑은 문자열이 긴 닉네임에 포함되면 두 사람의 이메일을 emailSet에 넣는다
- [V] emailSet을 이용해 answer를 만들고 오름차순으로 정렬한다
 */
