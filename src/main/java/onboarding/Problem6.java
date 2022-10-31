package onboarding;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    private static boolean isRepeat(String name1, String name2){
        List<String> names1 = new ArrayList<>();
        List<String> names2 = new ArrayList<>();

        for(int i = 0; i < name1.length() - 1; i++){
            names1.add(name1.substring(i, i + 2));
        }
        for(int i = 0; i < name2.length() - 1; i++){
            names2.add(name2.substring(i, i + 2));
        }

        for(int i = 0; i < names1.size(); i++){
            if(names2.contains(names1.get(i))){
                return true;
            }
        }
        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> repeats = new HashSet<>();

        for(int i = 0; i < forms.size(); i++){
            for(int j = i + 1; j < forms.size(); j++){
                if(isRepeat(forms.get(i).get(1), forms.get(j).get(1))){
                    repeats.add(forms.get(i).get(0));
                    repeats.add(forms.get(j).get(0));
                }
            }
        }

        List<String> answer = Lists.newArrayList(repeats);
        Collections.sort(answer);

        return answer;
    }
}
