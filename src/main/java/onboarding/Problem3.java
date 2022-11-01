package onboarding;

public class Problem3 {
    public static int solution(int number) {

        int total_number_of_clap = 0;
        for(int i=1; i<=number; i++){
            total_number_of_clap += get_number_of_clap(i);
        }
        return total_number_of_clap;

    }

    static int get_number_of_clap(int number){
        int number_of_clap = 0;
        String number_to_string = Integer.toString(number);
        for(int i=0; i<number_to_string.length(); i++){
            if(is_clap_number(number_to_string.charAt(i) - '0')){
                number_of_clap++;
            }
        }
        return number_of_clap;
    }

    static boolean is_clap_number(int number){
        if(number == 3 || number == 6 || number == 9) return true;
        return false;
    }

}
