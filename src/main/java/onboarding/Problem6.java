package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = checkDouble(forms);
        return answer;
    }
    public static List<String> checkDouble(List<List<String>> forms) {
        //List로 현재 이름중 중복에 해당하는 값을 저장
        Set<String> result = new HashSet<String>();
        ArrayList[] checkList = new ArrayList[forms.size()];
        ArrayList<String> checkAllList = new ArrayList<String>();
        for(int i = 0; i<forms.size();i++){
            checkList[i] = new ArrayList<>();
            String name = forms.get(i).get(1);
            System.out.println(name);
            for(int j = 0; j<name.length()-1; j++) {
                for (int m = 0; m < name.length() - 1; m++) {
                    String nextWord = name.substring(j, name.length() - m);
                    if (nextWord.length() > 1) {
                        checkList[i].add(nextWord);
                       if (checkAllList.indexOf(nextWord) < 0) {
                            checkAllList.add(nextWord);
                        }
                    }
                }
            }
        System.out.println(checkList[i]);
        }
        //checkList[i]내의 값을 돌아서, 같은 값이 있으면 result에 그값을 넣는다...
        for (int i = 0; i <forms.size()-1; i++) {
            for (int j = 0; j <checkList[i].size()-1; j++) {
                System.out.println(checkList[i].get(j));
                if(checkAllList.indexOf(checkList[i].get(j))>0){
                    result.add(forms.get(i).get(0));
                }
                checkAllList.add(checkList[i].get(j).toString());
            }
        }


        ArrayList<String> finalAnser = new ArrayList<String>(result);
        Collections.sort(finalAnser);
        return finalAnser;
    }

}
