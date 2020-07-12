package InteractiveMST;

import java.util.Arrays;

class Algorithm {

    public int[] primsAlgorithm(int[][] dist, int n) {

        int[] key = new int[n], nodes = new int[n];
        boolean[] matched = new boolean[n];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(matched, false);
        key[0] = 0;
        nodes[0] = -1;

        for (int i = 0; i < n - 1; i++) {
            int x = findMin(key, matched);
            matched[x] = true;
            for (int j = 0; j < n; j++)
                if (dist[x][j] != 0 && !matched[j] && dist[x][j] < key[j]) {
                    nodes[j] = x;
                    key[j] = dist[x][j];
                }
        }
        return nodes;
    }

    public int findMin(int[] key, boolean[] nodes) {
        int min = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < key.length; i++)
            if (!nodes[i] && key[i] < min) {
                min = key[i];
                index = i;
            }
        return index;
    }
}
