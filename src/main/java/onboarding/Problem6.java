package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> result = new ArrayList<>();
        List<List<String>> constrainedEmailList = new ArrayList<>();

        List<Crew> crews = getCrewList(forms);
        List<List<Crew>> combinations = getCombination(crews);

        for (List<Crew> crewPair : combinations) {
            List<String> newConstrainedEmails = getConstrainedEmailList(crewPair);
            constrainedEmailList.add(newConstrainedEmails);
        }

        result = constrainedEmailList.stream()
                .flatMap(Collection::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        return result;
    }
    public static List<Crew> getCrewList(List<List<String>> forms){
        List<Crew> result = new ArrayList<>();
        forms.stream().forEach(form -> result.add(new Crew(form.get(0), form.get(1))));

        return result;
    }

    static List<String> getConstrainedEmailList(List<Crew> crewPair) {
        List<String> emailList = new ArrayList<>();

        Crew crew1 = crewPair.get(0);
        Crew crew2 = crewPair.get(1);

        if (isSimilar(crew1, crew2)){
            emailList.add(crew1.getEmail());
            emailList.add(crew2.getEmail());
        }

        return emailList;
    }

    static boolean isSimilar(Crew crew1, Crew crew2){

        Stream<String> tokenStream = getTokens(crew1).stream();
        String name2 = crew2.getName();
        Stream<String> containedTokens =  tokenStream.filter(token -> name2.contains(token));

        return containedTokens.count() > 0;

    }

    static List<String> getTokens(Crew crew) {
        List<String> result = new ArrayList<String>();

        String name = crew.getName();
        for (int i = 0; i < name.length() - 1; i++) {
            String token = name.substring(i, i + 2);
            result.add(token);
        }

        return result;
    }

    static List<List<Crew>> getCombination(List<Crew> crews){
        List<List<Crew>> result = new ArrayList<>();
        int keyCnt = crews.size();

        for (int i = 0; i < keyCnt - 1; i++){
            Crew crew1 = crews.get(i);
            List<Crew> remainCrews = crews.subList(i + 1, keyCnt);
            remainCrews.stream().forEach(crew2 -> result.add(List.of(crew1, crew2)));
        }

        return result;
    }



}

class Crew{
    private String name;
    private String email;

    Crew(String email, String name){
        this.name = name;
        this.email = email;
    }
    String getName() {
        return name;
    }
    String getEmail() {
        return email;
    }
}
