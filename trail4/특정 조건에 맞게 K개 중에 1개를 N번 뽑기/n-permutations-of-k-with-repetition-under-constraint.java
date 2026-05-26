import java.util.*;
public class Main {

    static int n, k;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();

        choose(0);
    }

    static void choose(int idx) {
        if (idx == n) {
            for(Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();

            return;
        }

        for (int i=1; i<=k; i++) {
            if (idx >= 2 && list.get(list.size()-2) == list.get(list.size()-1) && list.get(list.size()-1) == i) {
                continue;
            }

            list.add(i);
            choose(idx+1);
            list.remove(list.size()-1);
        }
    }
}