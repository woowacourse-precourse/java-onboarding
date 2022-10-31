package onboarding;

import java.util.*;

/**
 * 반복문을 만들어 주어진 매개변수 List<List<String>>을 반복한다.
 * 각 유저의 닉네임을 변수에 저장하고 그 안에서 다른 반복문을 만든다.
 * substring 메소드를 이용해서 닉네임을 2음절로 나누어 나올수 있는 모든 연속된 2음절을 순차적으로 변수에 저장한다.
 * 다른 반복문을 만들어 변수에 저장된 닉네임의 2음절이 주어진 매개변수 다른 유저들의 닉네임에 포함되는지 확인한다.
 * 만약 포함된 닉네임이 있다면 포함된 닉네임과 2음절로 나누어진 닉네임 2개의 닉네임을 hashset에 저장한다.
 * hashset에 저장된 정보를 가지고 arraylist를 만들고 Collection을 이용해 오름차순으로 sort한다.
 * sort된 리스트를 리턴한다.
 *
 * @author heeyoung lee
 * @date 2022.10.30
 */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        if(forms.isEmpty() || forms.size()>10000) return null;
        Set<String> draft = new HashSet<>();

        for(int i=0; i<forms.size(); i++){
            String email = forms.get(i).get(0);
            String nickName = forms.get(i).get(1);
            String frag = "";

            /*
             길이가 11미만이거나 20 이상인경우 OR 이메일 형식이 @email.com을 포함하지 않는 경우 null 리턴한다.
             */
            if(!(email.contains("@email.com")) || email.length()<11 || email.length()>=20) return null;
            /*
             길이가 1미만이거나 20 이상인경우 OR 닉네임이 한글이 아닐경우 Null 리턴
             */
            if(!(nickName.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) || nickName.isEmpty() || nickName.length()>=20) return null;

            for(int j=0; j<nickName.length()-1; j++){
                frag = nickName.substring(j, j+2);
                addToList(forms, draft, frag, i);
            }
        }

        List<String> answer = new ArrayList<>(draft);
        Collections.sort(answer);
        return answer;
    }

    /**
     *
     * piece라는 연속되는 2음절 문자열을 매개변수로 받아 List<List<String>안에 있는 모든 닉네임들과 비교한다.
     * 만약 중복되는 닉네임이 있다면 중복된 2개의 닉네임 문자열을 hashset에 저장한다.
     *
     * @param a 주어진 매개변수
     * @param b 연속된 중복문자를 가지고 있는 닉네임들을 저장
     * @param piece 2음절 문자열
     * @param index List<List<String>>에 대한 인덱스
     */
    public static void addToList(List<List<String>> a, Set<String> b, String piece, int index){
        for(int i = index+1; i<a.size(); i++){
            String nickName = a.get(i).get(1);

            if(nickName.contains(piece)){
                b.add(a.get(index).get(0));
                b.add(a.get(i).get(0));
            }
        }
    }
}












//                    for(int k=i+1; k<forms.size(); k++){
//                        if(forms.get(k).get(1).contains(frag)){
//                            draft.add(forms.get(i).get(0));
//                            draft.add(forms.get(k).get(0));
//                        }
//                    }