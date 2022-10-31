package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decrypt(cryptogram); /// solution("zyelleyz")
    }

    private static String decrypt(String cryptogram) {
        StringBuilder list = new StringBuilder(cryptogram.length());

        for (int i = 0; i < cryptogram.length(); i++) {
            int cnt = 0;
            char cur = cryptogram.charAt(i);

            while (i + 1 < cryptogram.length() && cur == cryptogram.charAt(i + 1)) {
                /// 같은게 존재하면 스킵하고 붙힘. -> 이게 한 사이클
                i++;
                cnt++;
            }
            if (cnt == 0) {
                list.append(cryptogram.charAt(i));
            }
        }

        String result = list.toString();

        if (cryptogram.length() == result.length()) {
            return result;
        }
        else {
            return decrypt(result);
        }

    }
}
//
//    public static String solution(String cryptogram) {
//        String result = "";
//
//        List<String> list = Arrays.asList(cryptogram.split(""));
//        /// [b, r, o, w, o, a, n, o, o, m, m, n, a, o, n]
//        int l = list.size(); /// size 확인
//        HashSet<String> set = new HashSet<String>(); // set 선언
//
//        for (String s : list) {
//            set.add(s);
//        }
//
//        int sl = set.size();
//
//        while (sl != l) {
//            int ll = list.size(); /// 바뀐 리스트 사이즈
//            l = ll;
//            int cnt = 1;
//            Stack<String> stack = new Stack<>(); // char형 스택 선언
//            Stack<String> stack1 = new Stack<>(); // char형 스택 선언
//            stack.push(list.get(0));
//
//            for (int i = 1; i < ll; ++i) {
//                if (!(Objects.equals(stack.get(stack.size() - 1), list.get(i))) && cnt > 1) {
//                    for (int j = 0; j < cnt + 1; i++) {
//                        stack.pop();
//                    }
//                    if (Objects.equals(stack.get(stack.size() - 1), list.get(i))) {
//                        stack.push(list.get(i));
//                    } else {
//                        cnt = 1;
//                        stack.push(list.get(i));
//                    }
//                } else if (!Objects.equals(stack.get(stack.size() - 1), list.get(i))) {
//                    stack.push(list.get(i));
//                } else {
//                    cnt += 1;
//                    stack.push(list.get(i));
//                }
//            }
//            stack1 = stack;
//            if (stack1.size() == 2 && (Objects.equals(stack1.get(0), stack1.get(1)))) {
//                return result;
//            } else if (stack1.size() == 2) {
//                return String.join("", stack1);
//            }
//            return String.join("", stack1);
//
//        }
//
//        return result;


