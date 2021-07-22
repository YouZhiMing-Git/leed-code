package com.youzm.map;

import java.util.ArrayList;
import java.util.List;

/***
 * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 *
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 */
//图的深度优先搜索和广度优先搜索
public class Solution1 {

    int way=0;
    int k;
    int n;
    List<List<Integer>> map=new ArrayList<>();
    public int numWays(int n, int[][] relation, int k) {
        //构造图结构；
        this.k=k;
        this.n=n;
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] ints : relation) {
            map.get(ints[0]).add(ints[1]);
        }
        bfs(0,0);
        return way;
    }

    private void  bfs(int index,int step){
        if(step==k){
            if(index==n-1){
                way++;
            }
            return;
        }
        List<Integer> list = map.get(index);
        for (Integer nextIndex : list) {
            bfs(nextIndex,step+1);
        }
    }

}
