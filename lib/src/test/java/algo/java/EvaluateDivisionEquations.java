package algo.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class EvaluateDivisionEquations {
    static class Solution {

        record Edge(String to, double val) {
        };

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            var g = new HashMap<String, List<Edge>>();
            int i = 0;
            for (var edge : equations) {
                var list1 = g.getOrDefault(edge.get(0), new ArrayList<Edge>());
                list1.add(new Edge(edge.get(1), values[i]));
                g.put(edge.get(0), list1);
                var list2 = g.getOrDefault(edge.get(1), new ArrayList<Edge>());
                list2.add(new Edge(edge.get(0), 1 / values[i]));
                g.put(edge.get(1), list2);
                i++;
            }
            double[] res = new double[queries.size()];
            i = 0;
            var vis = new HashSet<String>();
            for (var q : queries) {
                vis.clear();
                res[i++] = dfs(g, q.get(0), q.get(1), vis);
            }
            return res;
        }

        private double dfs(Map<String, List<Edge>> g, String from, String to, Set<String> vis) {
            if (!g.containsKey(from) || !g.containsKey(to))
                return -1.0;
            if (from.equals(to))
                return 1.0;
            vis.add(from);
            for (var edge : g.get(from)) {
                if (!vis.contains(edge.to)) {
                    double tmp = dfs(g, edge.to, to, vis);
                    if (tmp > 0) {
                        return edge.val * tmp;
                    }
                }
            }
            return -1.0;
        }
    }

    @Test
    public void testEvaluateDivisionEquations() {
        var solution = new Solution();
        var test1_equations = List.of(
                List.of("a", "b"),
                List.of("b", "c"));
        var test1_values = new double[] { 2.0, 3.0 };
        var test1_queries = List.of(
                List.of("a", "c"),
                List.of("b", "a"),
                List.of("a", "e"),
                List.of("a", "a"),
                List.of("x", "x"));
        var expected1 = new double[] { 6.00000, 0.50000, -1.00000, 1.00000, -1.00000 };
        Assert.assertArrayEquals(expected1, solution.calcEquation(test1_equations, test1_values, test1_queries),
                0.0001);
    }
}
