package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem6 {

    public static Map <String,Integer> distinctNickList = new HashMap <>();
    public static Set <String> warningToCrewList = new HashSet <>();

    public static List <String> solution(List <List <String>> forms) {
        for (List <String> crew : forms) {
            distinctNick(crew.get(1));
        }

        findTarget(forms);

        return warningToCrewList.stream().sorted().collect(Collectors.toList());
    }
    public static void distinctNick(String nickName) {
        for (int i = 0; i < nickName.length() - 1; i++) {
            String partOfNick = nickName.substring(i, i + 2);

            if (!distinctNickList.containsKey(partOfNick)) {
                distinctNickList.put(partOfNick, 1);
                continue;
            }

            distinctNickList.put(partOfNick, 1 + distinctNickList.get(partOfNick));
        }
    }

    public static void findTarget(List <List <String>> forms){
        for(String key : distinctNickList.keySet()){
            if(distinctNickList.get(key) >= 2){
                for(List<String> crew : forms){
                    if(crew.get(1).contains(key)){
                        warningToCrewList.add(crew.get(0));
                    }
                }
            }
        }
    }
}