package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        HashMap<String, String> map = new HashMap<>(); //similarName 을 가진 지원자의 map (key: 닉네임, value: 이메일)
        HashSet<String> emailSet = new HashSet<String>(); //similarName 을 가진 지원자의 set (이메일)

        //forms[i][1].substring(j,j+2)를 전체랑 비교.
        for (int i = 0; i < forms.size(); i++) { // 현재 닉네임
            for (int j = 0; j < forms.size(); j++) { // 현재 닉네임과 비교될 전체 닉네임
                for (int k = 0; k < forms.get(i).get(1).length() - 1; k++) { //현재 닉네임 - 한글자씩
                    for (int l = 0; l < forms.get(j).get(1).length() - 1; l++) { //비교될 닉네임 - 한글자씩
                        if (i != j) {

                            boolean firstEquals = forms.get(i).get(1).substring(k, k + 2).charAt(0) == forms.get(j).get(1).substring(l, l + 2)
                                    .charAt(0);
                            boolean secondEquals = forms.get(i).get(1).substring(k, k + 2).charAt(1) == forms.get(j).get(1).substring(l, l + 2)
                                    .charAt(1);
                            if (firstEquals && secondEquals) { // 글자 두개가 같을 때
                                map.put(forms.get(i).get(1), forms.get(i).get(0));
                                map.put(forms.get(j).get(1), forms.get(j).get(0));
                                emailSet.add(forms.get(i).get(1));
                                emailSet.add(forms.get(j).get(1));
                            }
                        }
                    }
                }
            }
        }

        Iterator itr = emailSet.iterator();
        while(itr.hasNext()) {
            answer.add(map.get((String) itr.next()));
        }

        Collections.sort(answer);

        return answer;
    }
}
