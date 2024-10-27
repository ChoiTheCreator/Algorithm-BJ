import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sangunCardLen = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> hastSet = new HashSet<>();

        for(int i=0; i<sangunCardLen; i++){
            hastSet.add(Integer.parseInt(st.nextToken()));
        }

        int howmuchCard = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<howmuchCard; i++){
            if(hastSet.contains(Integer.parseInt(st.nextToken()))){
                sb.append("1 ");
            }
            else{
                sb.append("0 ");
            }
        }

        System.out.println(sb);

    }
}
