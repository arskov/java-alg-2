package algo.java;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ReorderRoutesMakeAllPathsLeadCityZero {
    static class Solution {

        private static class Edge {
            int to;
            boolean isOut;

            private Edge(int to, boolean isOut) {
                this.to = to;
                this.isOut = isOut;
            }

            static Edge of(int to, boolean isOut) {
                return new Edge(to, isOut);
            }
        }

        public int minReorder(int n, int[][] connections) {
            if (connections == null || connections.length == 0)
                return 0;
            boolean[] vis = new boolean[n];
            var adj = new ArrayList<List<Edge>>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<Edge>());
            }
            for (int i = 0; i < connections.length; i++) {
                int[] edge = connections[i];
                var list1 = adj.get(edge[0]);
                list1.add(Edge.of(edge[1], true));
                var list2 = adj.get(edge[1]);
                list2.add(Edge.of(edge[0], false));
            }
            vis[0] = true;
            return dfs(0, adj, vis);
        }

        private int dfs(int n, List<List<Edge>> adj, boolean[] vis) {
            int count = 0;
            for (var edge : adj.get(n)) {
                if (!vis[edge.to]) {
                    vis[edge.to] = true;
                    if (edge.isOut) {
                        count += 1 + dfs(edge.to, adj, vis);
                    } else {
                        count += dfs(edge.to, adj, vis);
                    }
                }
            }
            return count;
        }
    }

    @Test
    public void testReorderRoutesMakeAllPathsLeadCityZero() {
        var solution = new Solution();
        var test1 = new int[][] { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } };
        Assert.assertEquals(3, solution.minReorder(6, test1));
        var test2 = new int[][] { { 1, 0 }, { 1, 2 }, { 3, 2 }, { 3, 4 } };
        Assert.assertEquals(2, solution.minReorder(5, test2));
        var test3 = new int[][] { { 1, 0 }, { 2, 0 } };
        Assert.assertEquals(0, solution.minReorder(3, test3));
    }
}
