package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "";
        StringBuffer result = new StringBuffer(
            cryptogram); //delete를 사용하여 중복 문자열을 제거하기 위하여 StringBuffer 사용

        int index = 0;
        int flag=0; // 0 이면 중복 걸러내기 한번이라도 해서 다시 체크해야됨, 1 이면 아예 안둘러봤으므로 종료해도됨.
        int end_index= result.length();
        while (true) {

            if(index>=end_index-1 && flag==0){
                index=0;
                flag=1;
            }

             if((index>=end_index-1 || end_index==1) && flag==1){
                break;
             }

            System.out.println("index = " + index);
            System.out.println("end_index = " + end_index);
             if(result.charAt(index)==result.charAt(index+1)){

                 flag=0;
                 for(int i=index+1; i<end_index; i++){
                     if(result.charAt(index) != result.charAt(i)){

                         result.delete(index, i);
                         System.out.println("result = " + result);
                         end_index= result.length();
                         int size= i-index;
                         index=i-size;
                         break;

                     }
                     else if(i==end_index-1)
                     {
                         result.delete(index, i+1);
                         System.out.println("result = " + result);
                         index=0;
                         end_index=result.length();
                     }

                 }
             }
             else{

                 index++;
             }

        }

        answer = String.valueOf(result);
        System.out.println("answer = " + answer);
        return answer;
    }

   /* private static void deDuplication(StringBuffer result, int index) {
        if (result.length() == 2) {
            result.delete(index, index + 2);
        } else if (result.length() > 2) {
         for(int i=index; ; i++){
             char now_index= result.charAt(i);
             if(now_index != )


         }




        }
        return;
    }*/
}
