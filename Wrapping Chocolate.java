import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] ch = new int[n][2];
        int[][] box = new int[m][2];

        for (int i = 0; i < n; i++) ch[i][0] = sc.nextInt();
        for (int i = 0; i < n; i++) ch[i][1] = sc.nextInt();
        for (int i = 0; i < m; i++) box[i][0] = sc.nextInt();
        for (int i = 0; i < m; i++) box[i][1] = sc.nextInt();

        Arrays.sort(ch, (x, y) -> y[0] - x[0]);
        Arrays.sort(box, (x, y) -> y[0] - x[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j < m && box[j][0] >= ch[i][0]) {
                pq.add(box[j][1]);
                j++;
            }

            if (pq.isEmpty() || pq.poll() < ch[i][1]) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
