import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ropeCnt = Integer.parseInt(br.readLine());

        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0; i<ropeCnt; i++){
            int x = Integer.parseInt(br.readLine());
            al.add(x);
        }

        Collections.sort(al);

        int maxWeight = 0;
        for(int i=0; i<ropeCnt; i++){
            int currentMax= al.get(i)*(ropeCnt-i);
            maxWeight= Math.max(currentMax,maxWeight);
        }

        System.out.println(maxWeight);
    }


}
