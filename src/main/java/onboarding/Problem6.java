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
        private Map<String,List<String>> partedNicknameSet = new HashMap<>();

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
                    List<String> emailList = partedNicknameSet.getOrDefault(tmp, new ArrayList<>());
                    emailList.add(crew.email);
                    partedNicknameSet.put(tmp, emailList);
                }
            }
        }

        private List<String> findOverlappedNicknameUser() {
            addNicknamePartition();
            Set<String> emailList = new HashSet<>();

            partedNicknameSet.keySet().stream()
                    .map(k-> partedNicknameSet.get(k))
                    .filter(v-> isSizeOverOne(v))
                    .forEach(emailList::addAll);

            List<String> result = new ArrayList<>(emailList);
            Collections.sort(result);
            return result;
        }

        private boolean isSizeOverOne(List<String> v) {
            return v.size() > 1;
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        Team team = new Team(forms);
        return team.findOverlappedNicknameUser();
    }
}
