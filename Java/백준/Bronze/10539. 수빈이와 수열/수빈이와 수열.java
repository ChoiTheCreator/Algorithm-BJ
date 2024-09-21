import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String input = br.readLine();
        //빈칸이 포함된 문자열에서  split이 제일 효율적 + " " regex는 따옴표 두개임
        String[] splitNumbers = input.split(" ");

        int[] parsedInt = new int[n];

        //parseInt
        for(int i=0; i<n; i++){
            parsedInt[i] =Integer.parseInt(splitNumbers[i]);

        }

        for(int ans : changeFunction(parsedInt)){
            System.out.print(ans+" ");
        }





    }

    private static int[] changeFunction(int x[]){
        int size = x.length;
        int[] ans = new int[size];

        ans[0] = x[0];
        for(int i=1; i<size; i++){
            int sum = 0;
            int div = i+1;
            //정답 배열의 이전합 구하는 코드
            for(int j=0; j<i; j++ ){
                sum += ans[j];
            }
            ans[i] = x[i]*div - sum;
        }
        return ans;
    }
}
