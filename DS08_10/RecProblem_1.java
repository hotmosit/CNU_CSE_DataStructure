package DS08_10;

public class RecProblem_1 {
    public static void main(String args[]) {
        String s = func(23);

        System.out.println(s);
    }

    static String func(int a) {
        if (a <= 1) {	// base
            return a + "";
        }

        return func(a / 2) + a%2;	// 2진수의 출력과 동시에 재귀 실행
    }
}
