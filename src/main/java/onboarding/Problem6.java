package onboarding;

import java.util.List;
import java.util.LinkedList;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Problem6 problem = new Problem6();
        List<String> answer = List.of("answer");
        LinkedList<String> nicknamelist = new LinkedList<>();
        LinkedList<String> splitnickname = new LinkedList<>();

        for(List e : forms) {
            nicknamelist.add((String) e.get(1));
        }

        splitnickname = problem.splitTwoNickname(nicknamelist);


        return answer;
    }

    public LinkedList<String> splitTwoNickname(LinkedList<String> nicknamelist) {
        LinkedList<String> resultlist = new LinkedList<>();

        for(String nickname : nicknamelist) {
            for(int i=0; i<nickname.length()-1; i++) {
                resultlist.add(nickname.substring(i,i+2));
            }
        }

        return resultlist;
    }

}
