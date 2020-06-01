package DS08_10;

import java.util.Arrays;

public class RecProblem_3 {
    public static void main(String args[]) {
        int[] randomArr = new int[100];

        for (int i = 0; i < randomArr.length; i++) {
            // 배열에 난수 대입.
            randomArr[i] = (int) (Math.random() * 1000) + 1;
        }

        Arrays.sort(randomArr);	// 이미 정렬된 배열을 통해 이진탐색을 실행햐아함.

        for (int i = 1; i <= 200; i++) {
            // 200번 탐색 테스트 실행
            int temp = (int) (Math.random() * 1000) + 1;
            System.out.print(binarySearch(randomArr, temp, 0, randomArr.length - 1) +" ");

            if(i % 10 == 0) {
                System.out.println();
            }
        }
    }

    static int binarySearch(int[] arr, int targetX, int low, int high) {
        // 선조건 : 정렬된 배열이 arr매개변수로 들어온다.

        if (high <= low) {	// 탈출 조건
            return -1;
        }

        int i = (high + low) / 2;

        int temp = arr[i];

        if (temp == targetX) {
            // target값을 찾은 경우
            return i;
        }

        if (temp > targetX) {
            //i번째 원소가 target보다 큰 경우 high 값 자리에 i - 1 로 대체하여 탐색 범위를 나눈다.
            return binarySearch(arr, targetX, low, i - 1);
        } else {
            // i번째 원소가 target보다 작은 경우, low 값 자리에 i+1로 대체하여 탐색범위를 나눈다.
            return binarySearch(arr, targetX, i + 1, high);
        }

    }

}
