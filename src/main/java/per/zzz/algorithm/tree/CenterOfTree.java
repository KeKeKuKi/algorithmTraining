package per.zzz.algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/4/6 19:00
 * 310. 最小高度树
 * 树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 * 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
 * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
 * 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
 * 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
 */
public class CenterOfTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        int[] degree = new int[n];
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        int remainNodes = n;
        while (remainNodes > 2) {
            int sz = queue.size();
            remainNodes -= sz;
            for (int i = 0; i < sz; i++) {
                assert !queue.isEmpty();
                int curr = queue.poll();
                for (int v : adj[curr]) {
                    degree[v]--;
                    if (degree[v] == 1) {
                        queue.offer(v);
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            ans.add(queue.poll());
        }
        return ans;
    }
}
