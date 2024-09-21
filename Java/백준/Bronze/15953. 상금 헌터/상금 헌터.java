import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        for(int i=0; i<cnt; i++){
            String input = br.readLine();
            String[] split = input.split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            System.out.println(firstPrice(a)+secondPrice(b));
        }
    }

    private static int firstPrice(int a) {
        //switch case 쓰지마셈 ㅋ
         if(a ==0 || a>21){
            return 0;
        }
        if (a == 1) {
            return 5000000;
        } else if (a <= 3) {
            return 3000000;

        } else if (a <= 6) {
            return 2000000;
        } else if (a <= 10) {
            return 500000;
        } else if (a <= 15) {
            return 300000;
        } else if (a <= 21) {
            return 100000;
        }
        //진출하지 못할경우 혹은 a=0이라는 특수한 경우 고려

    return 0;
    }
    private static int secondPrice(int a){
        //switch case 쓰지마셈 ㅋ
        if(a ==0 || a>31){
            return 0;
        }
        if(a <=1){
            return 5120000;
        }
        else if(a<=3){
            return 2560000;

        }
        else if(a<=7){
            return 1280000;
        }
        else if(a<=15){
            return 640000;
        }
        else if(a<=31){
            return 320000;
        }
    return 0;

    }


}
