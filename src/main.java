import pojo.Data;
import utils.Utils;

import java.util.Scanner;

/**
 * @author sxy
 * @create 2021-03-30-16:59
 */
public class main {
    public static void main(String[] args) {
        Data data = new Data();
        String filename = null;
        int index = 0;
        int a  = 0;
        do{
            System.out.println("1.输入文件名");
            System.out.println("2.输入组数");
            System.out.println("3.计算结果");
            System.out.println("4.退出");
            Scanner s = new Scanner(System.in);
            a = s.nextInt();
            switch (a) {
                case 1:
                    System.out.println("输入文件名：");
                    filename = s.next();
                    break;
                case 2:
                    System.out.println("输入组数：");
                    index = s.nextInt();
                    break;
                case 3:
                    if(filename == null || index == 0 || index >11){
                        System.out.println("先输入文件名和组数");
                    }else {
                        Utils.getData(filename,index,data);
                        Integer[][] profit = data.getProfit();
                        Integer[][] weight = data.getWeight();
                        int N = Utils.getC(index);           // 物品组数
                        System.out.printf("请输入容量：");
                        int C = s.nextInt();           // 背包容量
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
                    break;
                case 4:
                    s.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误");
                    break;
            }
        }while (a != 0);

    }
}
