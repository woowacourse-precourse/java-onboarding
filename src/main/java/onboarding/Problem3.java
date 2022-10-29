package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i < number+1; i++){
            answer+=check369Number(i);
        }
        return answer;
    }

    static int[] makeNumToArray(int number){
        String string = Integer.toString(number);
        int [] array = new int[string.length()];
        for (int i=0; i<string.length(); i++ ){
            array[i] = string.charAt(i) - '0';
        }
        return array;
    }

    static int check369Number(int number){
        int [] arr = makeNumToArray(number);
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]==3 ||arr[i]==6 || arr[i]==9){count++;}
        }
        return count;
    }

    //for each문 써서 풀면 훨씬 쉽고 보기 좋을듯?

}
