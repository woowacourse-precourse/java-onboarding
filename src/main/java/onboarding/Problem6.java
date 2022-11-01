package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        String nick = "";
        String compare_nick = "";
        String continuas_str = "";
        String compare_continuas_str = "";

        for(int i = 0; i < forms.size(); i++){
            nick = forms.get(i).get(1);
            for(int k = 0; k < nick.length() - 1; k++){
                continuas_str = String.valueOf(nick.charAt(k) + nick.charAt(k + 1));
                for(int j = 0; j < forms.size(); j++){
                    compare_nick = forms.get(j).get(1);
                    if(compare_nick.equals(nick)){
                        break;
                    }
                    else{
                        for(int l = 0; l < compare_nick.length() -1; l++){
                            compare_continuas_str = String.valueOf(compare_nick.charAt(l) + compare_nick.charAt(l + 1));
                            if(continuas_str.equals(compare_continuas_str)){
                                answer.add(forms.get(i).get(0));
                                answer.add(forms.get(j).get(0));
                                break;
                            }
                        }
                    }
                }
            }
        }

        // 중복 제거 다시 해야함
        answer.stream().sorted();
        return answer;
    }
}
