import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());  // 배열의 크기 입력
        int[] original = new int[n];  // 원본 배열
        int[] target = new int[n];    // 목표 배열

        // 원본 배열 입력 처리
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            original[i] = Integer.parseInt(input[i]);
        }

        // 목표 배열 입력 처리
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            target[i] = Integer.parseInt(input[i]);
        }

        // 선택 정렬 과정에서 배열이 같은지 확인
        if (isArrayEqual(original, target)) {
            System.out.println(1);
            return;
        }

        // 선택 정렬 진행 (내림차순 정렬)
        for (int i = n - 1; i >= 0; i--) {
            int maxIndex = i;

            // 최대값의 인덱스 찾기
            for (int j = 0; j < i; j++) {
                if (original[j] > original[maxIndex]) {
                    maxIndex = j;
                }
            }

            // 교환
            swap(original, i, maxIndex);

            // 정렬 후 배열이 같은지 확인
            if (isArrayEqual(original, target)) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);  // 정렬 후에도 동일하지 않으면 0 출력
    }

    // 두 배열이 같은지 확인하는 메서드
    private static boolean isArrayEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // 배열의 두 요소를 교환하는 메서드
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}