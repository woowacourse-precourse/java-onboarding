package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {

    static Map<String, String> splitNickMap;
    static ArrayList<String> answer;

    public static List<String> solution(List<List<String>> forms) {
        answer = new ArrayList<String>();
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

        return answer;
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

        if (splitNickMap.containsKey(email)){
            answer.add(email);
            answer.add(splitNickMap.get(subNickName));
        }
    }
}
