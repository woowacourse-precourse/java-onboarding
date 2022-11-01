import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Problem6Debugging {

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );

            int formsFirstRowLength = forms.toArray().length;
//예외사항 1 : 크루는 1명 이상 10,000명 이하이다.
        if (formsFirstRowLength < 1 || formsFirstRowLength > 10000){
            System.out.println("Please, Enter number of member between 1 ~ 10000");

        }

            String nickName ="";
            String emailAddress ="";

            HashMap<String, String> hashMapCheckOverlap = new HashMap<String, String>(190000);
            HashMap<String, String> hashMapCollectOverlapEmail = new HashMap<String, String>(10000);



            while(formsFirstRowLength > 0){
                emailAddress = forms.get(formsFirstRowLength - 1).get(0);
                int emailAddressLength = emailAddress.length();
                //예외사항2 : 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
                if (emailAddressLength<11 || emailAddressLength>20){
                    System.out.println("Please, Enter email address length between 11~20");

                } else if (!emailAddress.substring(emailAddressLength - 9).equals("email.com")){ // 예외사항 3 :신청할 수 있는 이메일은 `email.com` 도메인으로만 제한한다.
                    System.out.println("Please, Enter email domain only 'email.com'");

                }
                nickName = forms.get(formsFirstRowLength - 1).get(1);
                int nickNameLength = nickName.length();
                //예외사항4 : 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
                if (nickNameLength<1 || nickNameLength>20){
                    System.out.println("Please, Enter Nickname length between 1~20");

                }

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
    }
}
