package onboarding;

import java.util.*;

public class Problem6 {
    private static HashMap<String, Integer> count = new HashMap<String, Integer>();

    //크루의 닉네임이 중복되는지 판별해 배열로 반환해주는 함수
    private static void is_duplicate(List<List<String>> forms, int[] duplicated){
        for(int i = 0; i<forms.size(); i++){
            String nickname = forms.get(i).get(1);
            for(int j = 0; j<nickname.length()-1; j++){
                String key = nickname.substring(j, j+2);

                if (count.containsKey(key)){
                    count.put(key, count.get(key) + 1);
                    duplicated[i] = 1;
                    break;
                }
                else {
                    count.put(key, 1);
                }
            }
        }

        //첫 번재 요소의 경우 중복되더라도 표시되지 않으므로 다시 확인해준다.
        String nickname = forms.get(0).get(1);
        for(int i = 0; i<nickname.length()-1; i++){
            String key = nickname.substring(i, i+2);
            if (count.containsKey(key)){
                duplicated[i] = 1;
                break;
            }
        }
    }

    //닉네임이 중복되는 크루들의 이메일을 이메일 형식이 맞다면 리스트로 반환하는 함수
    private static List<String> email_list(List<List<String>> forms, int[] duplicated){
        List<String> result = new ArrayList<String>();

        for(int i = 0; i<forms.size(); i++){
            if (duplicated[i] == 1) {
                String email = forms.get(i).get(0);
                if (email.substring(email.length()-10, email.length()).equals("@email.com")) result.add(email);
            }
        }

        return result;
    }

    //
    private static List<String> sort_email(List<String> lst){
        Collections.sort(lst, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o1_sub = o1.substring(0, o1.length()-10);
                String o2_sub = o2.substring(0, o2.length()-10);

                return o1.compareTo(o2);
            }
        });

        return lst;
    }

    public static List<String> solution(List<List<String>> forms) {
        int[] duplicated = new int[forms.size()];
        List<String> ans = new ArrayList<String>();

        //크루의 닉네임이 중복되는지 판별한다.
        is_duplicate(forms, duplicated);

        //중복되는 닉네임을 가지는 크루들의 이메일을 리스트에 담는다.
        ans = email_list(forms, duplicated);

        //이메일 리스트를 정렬한다.
        ans = sort_email(ans);

        return ans;
    }
}
