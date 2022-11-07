//package onboarding;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import static org.mockito.internal.util.StringUtil.join;
//
//public class P6 {
//    public static void main(String[] args) {
//        List<List<String>> forms = List.of(
//                List.of("jm@email.com", "제이엠"),
//                List.of("jason@email.com", "제이슨"),
//                List.of("woniee@email.com", "워니"),
//                List.of("mj@email.com", "엠제이"),
//                List.of("nowm@email.com", "이제엠")
//        );
//
//        String a = mainloop(makeNameLst(forms));
//        System.out.println(a);
//
//        finalCompare(makeNameLst(forms), mainloop(makeNameLst(forms)));
//        finalAnswer(finalCompare(makeNameLst(forms), mainloop(makeNameLst(forms))), forms);
//    }
//
//    public static List<String> solution(List<List<String>> forms) {
//        List<String> answer = List.of("answer");
//        return answer;
//    }
//
//    public static List<String> makeNameLst(List<List<String>> forms) {
//        String[] nameLst = new String[forms.size()];
//
//        for(int i=0; i< forms.size(); i++) {
//            nameLst[i] = "";
//        }
//
//        for(int i=0; i<forms.size(); i++) {
//            nameLst[i] = forms.get(i).get(1);
//        }
//        return Arrays.asList(nameLst);
//    }
//
//    public static String mainloop(List<String> nameLst) {
//        ArrayList<String> resultLst = new ArrayList<>();
//        ArrayList<String> twoNametLst = new ArrayList<>();
//        String returnName = null;
//
//        for(int i=0; i<nameLst.size(); i++) {
//
//            String originName = nameLst.get(i);
//            System.out.println(originName);
//
//            for(int j=0; j<originName.length()-1; j++) {
//                String compareName = originName.substring(j, j + 2);
//                twoNametLst.add(compareName);
//                System.out.println(compareName);
//                /**
//                 * compareName = originName의 연속된 문자열
//                 * originName 이 2글자 일 경우 compareName을 originName으로 대입
//                 */
//            }
//        }
//
//        for(int i=0; i<twoNametLst.size(); i++) {
//            String originWord = twoNametLst.get(i);
//            twoNametLst.remove(i);
//
//
//            for(int j=0; j<twoNametLst.size(); j++) {
//                if(originWord.equals(twoNametLst.get(j))) {
//                    returnName = originWord;
//                    break;
//                }
//            }
//            twoNametLst.add(i, originWord);
//        }
//
//        return returnName;
//    }
//
//    public static List<Integer> finalCompare(List<String> nameLst, String returnName) {
//        ArrayList<Integer> indexLst = new ArrayList<>();
//
//        for(int i=0; i<nameLst.size(); i++) {
//            String name = nameLst.get(i);
//
//            if(name.contains(returnName)) {
//                indexLst.add(i);
//                System.out.println(i);
//            }
//        }
//
//        return indexLst;
//    }
//
//    public static void finalAnswer(List<Integer> indexLst, List<List<String>> forms) {
//        ArrayList<String> emailLst = new ArrayList<>();
//
//
//        for(int i=0; i<indexLst.size(); i++) {
//            int location = indexLst.get(i);
//            System.out.println(forms.get(location).get(0));
//            emailLst.add(forms.get(location).get(0));
//        }
//
//        System.out.println(emailLst);
//        Collections.sort(emailLst);
//    }
//
//
//
//}
