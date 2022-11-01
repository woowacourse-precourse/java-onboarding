package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;

        answer = duplicationNicknameExtracting(forms);

        return emailAscendingOrder(answer);
    }//public static List<String> solution

    public static List<String> duplicationNicknameExtracting(List<List<String>> forms){
        Map<String,String> crewMap = new HashMap<>(10000);
        List<String> crewNicknameList = new ArrayList<>();
        List<String> duplicationNicknameList = new ArrayList<>();
        List<String> result;

        for(List<String> list : forms) {
            crewMap.put(list.get(1), list.get(0));
            crewNicknameList.add(list.get(1));
        }

        result = emailSearching(crewMap,duplicationWordSearching(crewNicknameList, duplicationNicknameList));

        return result;
    }//public static List<String> duplicationNicknameExtracting

    public static List<String> duplicationWordSearching(List<String> crewNicknameList,List<String> duplicationNicknameList){
        List<String> multiLetterNicknameList = new ArrayList<>();

        for (String s : crewNicknameList) {
            if (s.length() > 1) {
                multiLetterNicknameList.add(s);
            }
        }
        duplicationNicknameList.addAll(multiLetterNicknameDuplicationSearching(multiLetterNicknameList));
        return duplicationNicknameList;
    }//public static List<String> duplicationNicknameSearching

    public static List<String> multiLetterNicknameDuplicationSearching(List<String> multiLetterNicknameList){
        List<String> result = new ArrayList<>();

        for(int i = 0; i < multiLetterNicknameList.size(); i++){
            String nickName1 = multiLetterNicknameList.get(i);
            for (int j = i+1; j < multiLetterNicknameList.size(); j++){
                String nickName2 = multiLetterNicknameList.get(j);
                result.addAll(equalWordSearching(nickName1,nickName2));
            }
        }
        return result.stream().distinct().collect(Collectors.toList());
    }//public static List<String> multiLetterNicknameDuplicationSearching

    public static List<String> equalWordSearching(String nickName1,String nickName2){
        List<String> result = new ArrayList<>();

        for(int k = 0; k < nickName1.length() - 1; k++){
            for(int l = 0; l < nickName2.length() - 1; l++){
                if(nickName1.substring(k,k+2).equals(nickName2.substring(l,l+2))){
                    result.add(nickName1);
                    result.add(nickName2);
                }
            }
        }
        return result;
    }//public static List<String> equalWordSearching

    public static List<String> emailSearching(Map<String,String> crewMap,List<String> duplicationNicknameList){
        List<String> result = new ArrayList<>();

        for (String s : duplicationNicknameList) {
            result.add(crewMap.get(s));
        }

        return result;
    }//public static List<String> emailSearching

    public static List<String> emailAscendingOrder(List<String> answer){
        Collections.sort(answer);
        return answer;
    }//public static List<String> emailAscendingOrder

}//public class Problem6
