package onboarding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        String[] param=cryptogram.split("");
        List<String> list=new ArrayList<String>();
        list.add(param[0]);
        Queue<String> queue = new LinkedList<>();
        for (int i=1;i<cryptogram.length();i++) {
            queue.add(param[i]);
        }
        while(! queue.isEmpty()){
            if (list.get(list.size() - 1).equals(queue.peek())) {
                list.remove(list.size() - 1);
                queue.remove();
            } else {
                list.add(queue.peek());
                queue.remove();
            }
        }
        answer = String.join("", list);

        return answer;
    }
}
