package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        List<String> duplicateNick=new ArrayList<>();
        char[] nickname=new char[0];

        for (List<String> member: forms) {
            char[] nickString = (member.get(1)).toCharArray();

            if (nickname.length==0) {
                nickname=nickString;
            }
            checkDuplicate(nickname, nickString, member, duplicateNick);
        }

        answer=removeDuplication(duplicateNick);
        answer.sort(Comparator.naturalOrder());

        return answer;
    }

    static void checkDuplicate(char[] nickArray, char[] nickArray2, List<String> member, List<String> duplicateNickList) {
        for (int i=0; i< nickArray.length-1; i++) {
            for (int j=0; j< nickArray2.length-1; j++) {
                if(nickArray[i]==nickArray2[j] && nickArray[i+1]==nickArray2[j+1]){
                    duplicateNickList.add(member.get(0));
                    nickArray=nickArray2;
                }
            }
        }
    }

    static List<String> removeDuplication(List<String> list) {
        Set<String> set = new HashSet<String>(list);
        List<String> newList = new ArrayList<String>(set);

        return newList;
    }

}
