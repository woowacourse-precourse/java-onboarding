package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    static Map<String, String> splitNickMap = new HashMap<>();
    static Set<String> answer;

    public static List<String> solution(List<List<String>> forms) {
        answer = new HashSet<>();
        List<String> form;
        List<String> subStringList;
        String currentEmail;
        String currentNickName;

        for (int index = 0; index< forms.size(); index++){
            form = forms.get(index);
            currentEmail = form.get(0);
            currentNickName = form.get(1);

            subStringList = splitTwiceList(currentNickName);
            addSplitNickName(subStringList, currentEmail);
        }

        return answer.stream().sorted().collect(Collectors.toList());
    }

    public static List<String> splitTwiceList(String nickName){
        List<String> twiceList = new ArrayList<>();
        String subNickName;

        for (int index = 0; index < nickName.length()-1; index++){
            subNickName = nickName.substring(index, index + 2);
            twiceList.add(subNickName);
        }

        return twiceList;
    }

    public static void addSplitNickName(List<String> subList, String email){
        String subNickName;
        boolean checkSameNickName = false;
        for ( int index = 0; index < subList.size(); index++){
            subNickName = subList.get(index);
            checkNickName(email, subNickName);
        }


        for ( int index = 0; index < subList.size(); index++) {
            splitNickMap.put(subList.get(index), email);
        }
    }

    public static void checkNickName(String email, String subNickName){

        if (splitNickMap.containsKey(subNickName)){
            answer.add(email);
            answer.add(splitNickMap.get(subNickName));
        }
    }
}
