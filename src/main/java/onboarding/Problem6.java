package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();

        List<Crew> crew = new ArrayList<>();
        Set<Crew> set = new HashSet<>();

        String lis [] = {"제이엠", "제이슨", "워니", "엠제이", "이제엠"};
        String lis2 [] = {"jm@email.com","jason@email.com","woniee@email.com","mj@email.com","nowm@email.com"};
        for (int i=0;i<lis.length;i++) {
            Crew tempCrew = new Crew();
            tempCrew.setNickname(lis[i]);
            tempCrew.setEmail(lis2[i]);
            crew.add(tempCrew);
        }


        for (int i=0;i<crew.size();i++) {
            for (int n=i+1;n<crew.size();n++) {
                for (int j = 1; j < crew.get(i).getNickname().length(); j++) {
                    for (int k = 1; k < crew.get(n).getNickname().length(); k++) {
                        if (crew.get(i).getNickname().charAt(j - 1) == crew.get(n).getNickname().charAt(k - 1) && crew.get(i).getNickname().charAt(j) == crew.get(n).getNickname().charAt(k)) {
                            set.add(crew.get(n));
                            set.add(crew.get(i));
                        }
                    }
                }
            }
        }

        List<Crew> ans = new ArrayList<>(set);
        for (int i=0;i<ans.size();i++) {
            answer.add(ans.get(i).getEmail());
        }


        return answer;
    }
}
