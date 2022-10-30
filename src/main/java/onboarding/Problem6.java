package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        if (forms.size()<1 || forms.size()>10000)
            return null;

        answer = new ArrayList<String>();

        for(int i = 0; i<forms.size()-1;i++){
            String email = forms.get(i).get(0);
            //@이후 email.com인지 확인하는 Regex
            String nickname = forms.get(i).get(1);
            //nickname 길이 확인 필요
            if (nickname.length()<1 || nickname.length()>=20)
                return null;

            //리스트에서 현재 닉네임에서의 연속된 2글자와 비교할 닉네임을 가져온다.
            for (int j=0;j<nickname.length();j++){
                if (j+2>nickname.length())
                    break;
                for (int k=i+1; k<forms.size()-1;k++){
                    //만약 이미 중복된 닉네임이라면 다음 닉네임으로 이동
                    if (answer.contains(forms.get(k).get(0)))
                        break;
                    //아니라면 현재 닉네임의 연속된 2글자와 중복되는 확인
                    if (forms.get(k).get(1).contains(nickname.substring(j,j+2))) {
                        //중복될 경우 현재 닉네임과 비교대상 같이 중복자에 추가
                        //만약 현재 닉네임 이미 들어가 있다면 비교대상만 추가
                        if (!answer.contains(forms.get(i).get(0)))
                            answer.add(forms.get(i).get(0));
                        answer.add(forms.get(k).get(0));
                        break;
                    }
                }
            }
        }
        answer.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        return answer;
    }
}
