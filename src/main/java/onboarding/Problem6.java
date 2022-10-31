package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        char[][] name= new char[forms.size()][];
        List<String> nameList = new ArrayList<>();

        int len=0;
        for(int i=0;i<name.length;i++) {
            name[i] = forms.get(i).get(1).toCharArray();
            len+=name[i].length-1;
        }

        for(int i=0;i<name.length;i++) {
            for(int j=0;j<name[i].length-1;j++) {
                nameList.add(String.valueOf(name[i][j])+String.valueOf(name[i][j+1]));

            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<len;i++) {
            for(int j=i+1;j<len;j++) {
                if(Objects.equals(nameList.get(i),nameList.get(j))){
                    list.add(i);
                    list.add(j);
                }
            }
        }

        Set<Integer> set = new HashSet<Integer>(list);
        List<Integer> newList =new ArrayList<Integer>(set);

        for(int i=0;i<newList.size();i++) {
            int t=name[0].length-1;
            for(int j=0;j<name.length;j++) {
                if(newList.get(i)<t) {
                    answer.add(forms.get(j).get(0));
                    break;
                }else {
                    t+=name[j+1].length-1;
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
