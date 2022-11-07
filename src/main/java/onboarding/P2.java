//package onboarding;
//
//import java.util.ArrayList;
//import java.util.Stack;
//
//public class P2 {
//    public static void main(String[] args) {
//        String s = "browoanoommnaon";
//        System.out.println(1);
//        System.out.println(solution(s));
//    }
//
//    public static String solution(String cryptogram) {
//        String answer = "";
//        answer = overlap(cryptogram);
//        return answer;
//    }
//
//    public static String overlap(String s) {
//        Stack<String> st = new Stack<>();
//        ArrayList<Character> sLst = new ArrayList<>();
//
//
//        for(int i = 0; i < s.length(); i++) {
//            char currentCharacter = s.charAt(i);//getting the character at current index
//            sLst.add(currentCharacter);//adding the character to the list
//        }
//        for(int i=0; i<s.length(); i++) {
//            if(st.size() == 0) {
//                st.push(String.valueOf(sLst.get(i)));
//            } else {
//                String c1 = st.peek();
//                Character c11 = c1.charAt(0);
//                Character c2 = sLst.get(i);
//                if(c11 != c2) {
//                    st.push(String.valueOf(sLst.get(i)));
//                }
//                else {
//                    st.pop();
//                }
//            }
//
//        }
//
//        return String.join("", st);
//    }
//}
