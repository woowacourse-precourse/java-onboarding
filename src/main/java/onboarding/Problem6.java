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
            //닉네임 받아 배열로 만들기
            char[] nickString = (member.get(1)).toCharArray();

            //닉네임 중복 확인 및 중복된 닉네임 리스트에 추가
            if (nickname.length==0) {
                nickname=nickString;
            }
            checkDuplicate(nickname, nickString, member, duplicateNick);
        }

        return answer;
    }

    //중복 확인
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

}
