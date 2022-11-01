package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        ArrayList<String> arr = new ArrayList<>();
        HashSet<String> arr2 = new HashSet();
        HashSet<String> arr3 = new HashSet();
        HashSet<String> answer = new HashSet();
        for (int i = 0; i < forms.size(); i++) {
            String a = forms.get(i).get(1);
            arr.add(a);
        }
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 1; j < arr.get(i).length(); j++) {
                String b ="";
                b += arr.get(i).charAt(j-1);
                b += arr.get(i).charAt(j);
                int count1 =arr2.size();
                arr2.add(b);
                int count2 =arr2.size();
                if (count1 == count2){
                    arr3.add(b);
                }

            }
        }
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 1; j < arr.get(i).length(); j++) {
                String b ="";
                b += arr.get(i).charAt(j-1);
                b += arr.get(i).charAt(j);
                int count1 =arr3.size();
                arr3.add(b);
                int count2 =arr3.size();
                if (count1 == count2){
                    answer.add(forms.get(i).get(0));
                }

            }
        }

        return (List<String>) answer;
    }
}
