package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<List<String>> test = new ArrayList<>();
        List<String> real = new ArrayList<>();
        List<String> email = new ArrayList<>();
        LinkedHashSet<String> realSet = new LinkedHashSet<>(); /** 순서를 보장해주는 LinedHashSet*/
        LinkedHashSet<String> realSet2 = new LinkedHashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            for (int j = 0; j < forms.get(i).get(1).length(); j++) {
                real.add(forms.get(i).get(1).substring(j, j + 2) + forms.get(i));
                if (j + 2 == forms.get(i).get(1).length()) {
                    break;
                }
            }
        }

        for (int i = 0; i < real.size(); i++) {
            for (int j = i + 1; j < real.size(); j++) {
                if (real.get(i).substring(2).equals(real.get(j).substring(2))) {
                    continue;
                    /* 0번 index, 1번 index를 쪼개서 만들었기 때문에 이메일과 풀네임이 같으면 뛰어넘는 거임.*/
                }
                if (real.get(i).substring(0, 2).equals(real.get(j).substring(0, 2)) &&
                    !real.get(i).substring(2).equals(real.get(j).substring(2))) {
                    realSet.add(real.get(i));
                    realSet.add(real.get(j));
                    realSet2.add(real.get(i));
                    realSet2.add(real.get(j));
                }
            }
        }

        Iterator<String> it = realSet.iterator();
        Iterator<String> it2 = realSet2.iterator();
        int indexCheck = 0;
        for (int i = 0; i < realSet.size(); i++) {
            indexCheck = it.next().indexOf(",");
            email.add(it2.next().substring(3, indexCheck));
        }
        Collections.sort(email);

        for (int i = 0; i < email.size(); i++) {
            if(!answer.contains(email.get(i))) { /** 중복 검사 하는 부분임 */
                answer.add(email.get(i));
            }
        }


        return answer;
    }
}
