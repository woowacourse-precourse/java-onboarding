package onboarding;

import java.util.List;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Problem6 problem = new Problem6();
        List<String> answer;

        LinkedList<String> nicknamelist = new LinkedList<>();
        LinkedList<String> splitnickname;
        LinkedList<String> duplicatenickname;
        HashSet<String> answerset = new HashSet<>();

        for(List e : forms) {
            nicknamelist.add((String) e.get(1));
        }

        splitnickname = problem.splitTwoNickname(nicknamelist);
        duplicatenickname = problem.findDuplicateNick(splitnickname);

        for(String e : duplicatenickname) {
            for(List list : forms) {
                answerset.add(problem.findEmail(e, list));
            }
        }

        answerset.remove("");
        answer = new LinkedList<>(answerset);
        Collections.sort(answer);

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

    public LinkedList<String> findDuplicateNick(LinkedList<String> nicknamelist) {
        HashSet<String> resultset = new HashSet<>();

        for(String e : nicknamelist) {
            if(Collections.frequency(nicknamelist, e) > 1) {
                resultset.add(e);
            }
        }

        LinkedList<String> resultlist = new LinkedList<>(resultset);
        return resultlist;
    }

    public String findEmail(String duplicatenick, List list) {
        String nickname = (String) list.get(1);
        String result = "";

        if(nickname.contains(duplicatenick)) {
            result = (String) list.get(0);
        }

        return result;
    }
}
