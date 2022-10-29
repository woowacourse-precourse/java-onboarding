package onboarding;

import java.util.*;

public class Problem6 {
    static class Crew {
        private String email;
        private String nickname;

        public Crew(List<String> list) {
            this.email = list.get(0);
            this.nickname = list.get(1);
        }
    }

    static class Team {
        private Set<Crew> crewSet = new HashSet<>();
        private Map<String,List<String>> overlapSet = new HashMap<>();

        public Team(List<List<String>> forms) {
            //forms.stream().map(i -> new Crew(i)).map(c -> crewSet.add(c));    // 왜 안 되지?
            for(List<String> f : forms){
                Crew crew = new Crew(f);
                crewSet.add(crew);
            }
        }

        private void addNicknamePartition() {
            for(Crew crew : crewSet){
                for(int i=0 ; i<crew.nickname.length()-1 ; i++){
                    String tmp = crew.nickname.substring(i,i+2);
                    List<String> orDefault = overlapSet.getOrDefault(tmp, new ArrayList<>());
                    orDefault.add(crew.email);
                    overlapSet.put(tmp, orDefault);
                }
            }
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
