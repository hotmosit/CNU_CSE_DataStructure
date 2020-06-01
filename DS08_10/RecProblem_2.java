package DS08_10;

public class RecProblem_2 {
    public static void main(String args[]) {
        System.out.println(func2(35));
    }

    static int func2(int a) {
        if (a < 2) {
            return 0;
        }

        return 1 + func2(a / 2);
    }
}
