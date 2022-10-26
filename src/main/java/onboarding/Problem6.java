package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }


    /**
     * 기능1
     * 각 닉네임을 두 글자로 분리하는 기능
     * ex) 제이엠 -> 제이, 이엠
     */
    public static List<String> separateNickname(String nickname) {

        List<String> twoLetters = new ArrayList<>();
        for(int i = 0; i < nickname.length() - 1; i++)
        {
            twoLetters.add(nickname.substring(i, i + 2));
        }

        return twoLetters;
    }

    /**
     * 기능 2
     * HashMap을 통해서 중복된 닉네임을 작성한 이메일 목록을 찾는 기능
     */

    public static List<String> findDuplicateNickname(List<List<String>> forms) {

        HashMap<String, Integer> listOfAll = new HashMap<>(); // 두 글자로 분리된 이름과 인덱스를 저장할 해쉬맵
        List<String> listOfEmail = new ArrayList<>(); // 이메일을 저장할 리스트

        for(int i = 0; i < forms.size(); i++)
        {
            List<String> separatedNickname = separateNickname(forms.get(i).get(1)); // 두 글자로 분리된 닉네임 리스트

            for(int j = 0; j < separatedNickname.size(); j++)
            {
                String currentNickname = separatedNickname.get(j);
                if(listOfAll.containsKey(currentNickname))
                {
                    listOfEmail.add(forms.get(i).get(0)); //
                    listOfEmail.add(forms.get(listOfAll.get(currentNickname)).get(0));
                }else
                {
                    listOfAll.put(currentNickname, i);
                }
            }
        }

        return listOfEmail;
    }


    /**
     * 기능 3
     * 이메일 목록을 오름차순으로 정렬
     */
    public static List<String> sortEmailList(List<String> listOfEmail) {

        return listOfEmail.stream().sorted().collect(Collectors.toList());
    }

    /**
     * 기능 4
     * 이메일 목록의 중복 제거
     */

}
