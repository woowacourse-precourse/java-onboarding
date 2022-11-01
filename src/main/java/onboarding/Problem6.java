package onboarding;

import java.util.*;

public class Problem6 {
    //크루의 닉네임에 존재하는 모든 두글자 문자열의 개수를 저장하는 hashmap
    private static HashMap<String, Integer> count = new HashMap<String, Integer>();

    //주어진 nickname을 이용해 hashmap을 업데이트하는 함수
    private static void _update(String nickname){
        for(int j = 0; j<nickname.length()-1; j++){
            String key = nickname.substring(j, j+2);

            if (count.containsKey(key)) count.put(key, count.get(key) + 1);
            else count.put(key, 1);
        }
    }
    
    //주어진 nickname이 중복된 nickname인지 판별하는 함수
    private static int _is_duplicate(String nickname){
        for(String str: count.keySet()){
            if (count.get(str) >= 2){
                if (nickname.contains(str)) return 1;
            }
        }
        return 0;
    }

    //크루의 닉네임이 중복되는지 판별해 배열로 반환해주는 함수
    private static void is_duplicate(List<List<String>> forms, int[] duplicated){
        //닉네임이 중복되는지 판별하는 데 사용할 hashmap을 업데이트한다.
        for(int i = 0; i<forms.size(); i++){
            String nickname = forms.get(i).get(1);
            _update(nickname);
        }

        //닉네임이 중복되는지 판별한다.
        for(int i = 0; i<forms.size(); i++){
            String nickname = forms.get(i).get(1);
            duplicated[i] = _is_duplicate(nickname);
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

    //중복되는 닉네임을 가지는 크루들의 이메일을 이메일 형식을 제외한 부분으로 정렬한 리스트를 반환하는 함수
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
