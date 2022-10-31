package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(); // 정답을 저장

        // 1. 각 닉네임에서 길이 2의 token을 set으로 구성하여 수집함
        HashSet<String> tokens = getTokens(forms);

        // 2. 수집한 Token을 사용하여 유사 닉네임을 가진 신청정보의 index Set을 구성함
        HashSet<Integer> idxSet = getDuplCaseId(tokens, forms);

        // 3. 구성한 index Set을 사용하여 중복되는 신청정보의 email을 수집함
        for (int id : idxSet)
            answer.add(forms.get(id).get(0));

        // 4. 구성한 정보를 사전 순으로 정렬함
        Collections.sort(answer);

        return answer;
    }

    // 각 닉네임에서 길이 2의 token을 set으로 구성하여 수집
    private static HashSet<String> getTokens(List<List<String>> forms) {
        HashSet<String> tokens = new HashSet<>(); // 길이 2의 token의 set

        for(List<String> form : forms) {
            String nickname = form.get(1);
            if(nickname.length() <= 1) continue; // nickname의 길이가 1이어서 수집할 token이 없는 경우
            for(int i=0 ; i<nickname.length()-1 ; i++)
                tokens.add(nickname.substring(i, i+2));
        }

        return tokens;
    }

    // 수집한 token을 사용하여 유사 닉네임을 가진 신청정보의 index set을 구성
    private static HashSet<Integer> getDuplCaseId(HashSet<String> tokens, List<List<String>> forms) {
        String[] tokenArr = tokens.toArray(new String[0]);
        HashSet<Integer> idxSet = new HashSet<>(); // 유사 닉네임을 가진 신청정보의 Index Set

        for(String token : tokenArr) {
            Queue<Integer> queue = new LinkedList<>(); // 일시적으로 해당 token이 포함된 닉네임을 가진 신청건의 index를 저장
            for(int i=0 ; i<forms.size() ; i++) {
                if(forms.get(i).get(1).contains(token))
                    queue.add(i);
            }
            if(queue.size() > 1) { // 해당 token의 주인 외에 token을 포함하는 다른 신청건이 있는 경우
                while(!queue.isEmpty())
                    idxSet.add(queue.poll());
            }
        }

        return idxSet;
    }
}
