import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        String str = br.readLine();

        System.out.println(estimate(str));
    }

    private static int estimate(String str){
        int len = str.length();
        int total = 0;
        int bonus = 0;
        for(int i=1; i<=len; i++){
            if(str.charAt(i-1) == 'O'){
                total += i;
                total +=bonus;
                bonus++;

            }
            //X일떄
            else{
                bonus=0;
                
            }
        }
        return total;
    }
}
