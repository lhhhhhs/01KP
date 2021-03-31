package test;


import pojo.Data;
import utils.Utils;

/**
 * @author sxy
 * @create 2021-03-30-16:14
 */
public class utiltest {

    public static void main(String[] args) {
        Data data = new Data();
        Utils.getData("idkp1-10.txt", 1,data);
        Integer[][] profit = data.getProfit();
        Integer[][] weight = data.getWeight();
        System.out.println("");
        for (int j = 0; j < profit.length; j++) {
            for (int m = 0; m < 3; m++) {
                System.out.printf(profit[j][m] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
        for (int j = 0; j < weight.length; j++) {
            for (int m = 0; m < 3; m++) {
                System.out.printf(weight[j][m] + " ");
            }
            System.out.println("");
        }

        int N = 10;           // 物品组数
        int C = 10149;           // 背包容量

        int[][] dp = new int[N+1][C+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                dp[i][j] = dp[i-1][j];           // 不选第i组物品
                for (int k = 0; k < 3; k++) { // 第i组物品中选一件
                    if (j >= weight[i][k]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-weight[i][k]] + profit[i][k]);
                    }
                }
            }
        }
        System.out.println(dp[N][C]);
    }
}
