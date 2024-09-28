import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] split = input.split(" ");

        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);

        String name = br.readLine();
        String[] splitName = name.split(" ");

        String first = splitName[0];
        String second = splitName[1];

        // score
        int[] score = {3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        StringBuilder sb = new StringBuilder();
        int lenFirst = first.length();
        int lenSecond = second.length();

        int minIdx = Math.min(lenFirst, lenSecond);

        for (int i = 0; i < minIdx; i++) {

                sb.append(first.charAt(i));
                sb.append(second.charAt(i));

        }

        if (lenFirst > lenSecond) {
            sb.append(first.substring(minIdx));
        } else {
            sb.append(second.substring(minIdx));
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < sb.length(); i++) {
            arrayList.add(score[sb.charAt(i) - 'A']);
        }

        
        ArrayList<Integer> lastList = compoundScore(arrayList);
        StringBuilder ans = new StringBuilder();
        ans.append(lastList.get(0)).append(lastList.get(1)).append("%");

        if (ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }

        System.out.println(ans);
    }

    private static ArrayList<Integer> compoundScore(ArrayList<Integer> arr) {
        while (arr.size() > 2) {
            ArrayList<Integer> tmpScore = new ArrayList<>();
            for (int i = 0; i < arr.size() - 1; i++) {
                tmpScore.add((arr.get(i) + arr.get(i + 1)) % 10); // 10을 넘기지 않도록
            }
            arr = tmpScore; // arr을 tmpScore로 갱신
        }
        return arr;
    }
}