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
        }

        return answer;
    }

}
