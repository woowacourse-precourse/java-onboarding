package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
public class Problem3 {
    public static int solution(int number) {
        String[] games = {"3","6","9"};

        int count = 0;

        for (int i=0;i < number+1; i++) {
            String str = Integer.toString(i);
            ArrayList<String> myList = new ArrayList<>(Arrays.asList(str.split("")));  //str to list
            //System.out.println(myList);
            for (String my : myList) {
                for (String game : games) {
                    if (my.contains(game)) {
                        count += 1;
                    }
                }
            }
        }
        return count;
    }
}
