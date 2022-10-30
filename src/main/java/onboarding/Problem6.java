package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = null;

        answer = finalAnswer(finalCompare(makeNameLst(forms), mainloop(makeNameLst(forms))), forms);


        return answer;
    }

    public static List<String> makeNameLst(List<List<String>> forms) {
        String[] nameLst = new String[forms.size()];

        for(int i=0; i< forms.size(); i++) {
            nameLst[i] = "";
        }

        for(int i=0; i<forms.size(); i++) {
            nameLst[i] = forms.get(i).get(1);
        }
        return Arrays.asList(nameLst);
    }

    public static String mainloop(List<String> nameLst) {
        ArrayList<String> twoNametLst = new ArrayList<>();
        String returnName = null;

        for(int i=0; i<nameLst.size(); i++) {

            String originName = nameLst.get(i);

            for(int j=0; j<originName.length()-1; j++) {
                String compareName = originName.substring(j, j + 2);
                twoNametLst.add(compareName);
                /**
                 * compareName = originName의 연속된 문자열
                 * originName 이 2글자 일 경우 compareName을 originName으로 대입
                 */
            }
        }

        for(int i=0; i<twoNametLst.size(); i++) {
            String originWord = twoNametLst.get(i);
            twoNametLst.remove(i);


            for(int j=0; j<twoNametLst.size(); j++) {
                if(originWord.equals(twoNametLst.get(j))) {
                    returnName = originWord;
                    break;
                }
            }
            twoNametLst.add(i, originWord);
        }

        return returnName;
    }

    public static List<Integer> finalCompare(List<String> nameLst, String returnName) {
        ArrayList<Integer> indexLst = new ArrayList<>();

        for(int i=0; i<nameLst.size(); i++) {
            String name = nameLst.get(i);

            if(name.contains(returnName)) {
                indexLst.add(i);
            }
        }

        return indexLst;
    }
//
//    public static List<String> finalAnswer(List<Integer> indexLst, List<List<String>> forms) {
//        ArrayList<String> emailLst = new ArrayList<>();
//
//
//        for(int i=0; i<indexLst.size(); i++) {
//            int location = indexLst.get(i);
//            emailLst.add(forms.get(location).get(0));
//        }
//        Collections.sort(emailLst);
//        return emailLst;
//    }
}
