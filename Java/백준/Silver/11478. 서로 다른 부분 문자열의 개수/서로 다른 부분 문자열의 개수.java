import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        TreeSet<String> treeSet = new TreeSet<>();


        // 포인터 두 개를 활용해서 substring을 써서 쭉 움직인다. (어차피 연속 문자열)이니까
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) { // j는 i+1부터 시작 -
                // 또한 subString의 두번째 포인터는 필연적으로 문자열 인덱스 하나를 벗어나야한다.
                String substring = str.substring(i, j); // 올바른 부분 문자열
                treeSet.add(substring);
            }
        }
        int cnt =0;

        Iterator<String> it =treeSet.iterator();
        while(it.hasNext()){
            it.next();
            cnt++;
        }
        System.out.println(cnt);


    }
}
