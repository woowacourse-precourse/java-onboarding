package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {


        int formsFirstRowLength = forms.toArray().length; //가입 요청 개수

        //예외사항 1 : 크루는 1명 이상 10,000명 이하이다.
        if (formsFirstRowLength < 1 || formsFirstRowLength > 10000){
            System.out.println("Please, Enter number of member between 1 ~ 10000");
            return Collections.emptyList();
        }


        String nickName ="";
        String emailAddress ="";

        HashMap<String, String> hashMapCheckOverlap = new HashMap<String, String>(); //연속되는 두글자가 오버랩 되는지 확인하기 위한 Hashmap 생성
        HashMap<String, String> hashMapCollectOverlapEmail = new HashMap<String, String>(); //연속되는 오버랩된 닉네임을 가진 사람들의 email을 수집하기 위한 Hashmap 생성



        while(formsFirstRowLength > 0){
            emailAddress = forms.get(formsFirstRowLength - 1).get(0); //가입자의 email address 추출


            //예외사항2 : 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
            int emailAddressLength = emailAddress.length(); //email 길이 확인

            if (emailAddressLength<11 || emailAddressLength>20){
                System.out.println("Please, Enter email address length between 11~20");
                return Collections.emptyList();

            } else if (!emailAddress.substring(emailAddressLength - 9).equals("email.com")){ // 예외사항 3 :신청할 수 있는 이메일은 `email.com` 도메인으로만 제한한다.
                System.out.println("Please, Enter email domain only 'email.com'");
                return Collections.emptyList();
            }

            nickName = forms.get(formsFirstRowLength - 1).get(1); //가입자의 Nickname 추출

            //예외사항4 : 전체 길이는 1자 이상 20자 미만이다.
            int nickNameLength = nickName.length();
            if (nickNameLength<1 || nickNameLength>20){
                System.out.println("Please, Enter Nickname length between 1~20");
                return Collections.emptyList();
            }
            //예외사항 5 : 닉네임은 한글만 가능하다.




            for (int i = 0; i < nickNameLength - 1; i++){
                String twoWords = nickName.substring(i, i+2);

                if (hashMapCheckOverlap.containsKey(twoWords)){

                    hashMapCollectOverlapEmail.put(emailAddress,"");
                    hashMapCollectOverlapEmail.put(hashMapCheckOverlap.get(twoWords),"");
                    continue;

                }

                hashMapCheckOverlap.put(twoWords,emailAddress);

            }
            formsFirstRowLength -=1;


        }


        List<String> answer = new ArrayList(List.of(hashMapCollectOverlapEmail.keySet().toArray(new String[hashMapCollectOverlapEmail.size()])));
        answer.sort(Comparator.naturalOrder());




        return answer;
    }
}
