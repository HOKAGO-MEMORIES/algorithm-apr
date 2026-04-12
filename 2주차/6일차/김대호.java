import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());

        long[] C = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            C[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(C);

        int fullCount = 0;
        int r = N - 1;

        while (r >= 0 && C[r] == X) {
            fullCount++;
            r--;
        }

        int l = 0;
        int pairs = 0;
        while (l < r) {
            if (2 * (C[l] + C[r]) >= X) {
                pairs++;
                l++;
                r--;
            } else {
                l++;
            }
        }

        long remaining = (long) N - fullCount - (2L * pairs);
        long result = (long) fullCount + pairs + (remaining / 3);

        System.out.println(result);
    }
}