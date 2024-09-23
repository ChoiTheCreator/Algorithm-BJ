import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        String[] split = input.split(" ");

        int[] parsedArr = new int[n];

        for(int i=0; i<n; i++){
            parsedArr[i] = Integer.parseInt(split[i]);
        }

        System.out.println(findMax(parsedArr)-findMin(parsedArr));




    }

    private static int findMax(int[] arr){
        int tmpMax = arr[0];
        int len = arr.length;
        for(int i=1; i<len; i++){
            if(tmpMax <arr[i]){
                tmpMax =arr[i];
            }
        }
        return tmpMax;
    }

    private static int findMin(int[] arr){
        int tmpMin = arr[0];
        int len = arr.length;
        for(int i=1; i<len; i++){
            if(tmpMin >arr[i]){
                tmpMin =arr[i];
            }
        }
        return tmpMin;
    }
}
