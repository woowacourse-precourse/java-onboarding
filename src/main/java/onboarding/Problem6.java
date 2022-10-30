package onboarding;

import java.util.*;

public class Problem6 {
    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        System.out.println(solution(forms));
    }
    // TODO 크루의 닉네임을 가져오는 메서드
    public static List<String> getNickname(List<List<String>> list) {
        List<String> nickname = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            nickname.add(list.get(i).get(1));
        }
        return nickname;
    }

    // TODO 닉네임을 두글자씩 나눈뒤 리스트에 저장
    public static ArrayList<ArrayList<String>> checkDuplication(List<String> nickname) {
        ArrayList<ArrayList<String>> splitNickname = new ArrayList<>();

        for (int i = 0; i < nickname.size(); i++) {
            splitNickname.add(new ArrayList<>());
            String str = "";

            for (int j = 0; j < nickname.get(i).length()-1; j++) {
                str = nickname.get(i).substring(j, j+2);
                splitNickname.get(i).add(str);
            }
        }
        return splitNickname;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        List<String> nickname = getNickname(forms);
        ArrayList<ArrayList<String>> list = checkDuplication(nickname);

        return answer;
    }
}
