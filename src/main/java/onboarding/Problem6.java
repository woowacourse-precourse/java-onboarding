package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for(int i=0; i<forms.size(); i++){
            List<String> containList = isContain(i,forms);
            answer.removeAll(containList);
            System.out.println("answer1 = " + answer);
            answer.addAll(containList);
            System.out.println("answer2 = " + answer);

        }

        return answer;
    }

    //닉네임 포함되는 경우 기능 구현
    public static List<String> isContain(int index, List<List<String>> forms){
        List<String> emailIndexList = new ArrayList<>();
        String nowFormNick = forms.get(index).get(1);
        for(int i=index+1; i<forms.size();i++){
            String nextFormNick = forms.get(i).get(1);
            for(int j=0; j<nextFormNick.length()-1; j++) {
                String tmpWord = nextFormNick.substring(j, j + 2);
                System.out.println("nowFormNick = " + nowFormNick);
                System.out.println("nextFormNick = " + nextFormNick);
                System.out.println("tmpWord = " + tmpWord);
                if (nowFormNick.contains(tmpWord)) {
                    emailIndexList.add(forms.get(i).get(0));
                    break;
                }
            }
        }
        if (emailIndexList.size() != 0){
            emailIndexList.add(forms.get(index).get(0));
        }
        return emailIndexList;
    }
}
