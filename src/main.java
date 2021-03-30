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
            System.out.println("2.输入组索引");
            System.out.println("3.计算结果");
            System.out.println("4.输出重量价值比");
            System.out.println("5.绘制散点图");
            System.out.println("6.退出");
            Scanner s = new Scanner(System.in);
            a = s.nextInt();
            switch (a) {
                case 1:
                    System.out.println("输入文件名：");
                    filename = s.next();
                    break;
                case 2:
                    System.out.println("输入组索引：");
                    index = s.nextInt();
                    break;
                case 3:
                    if(filename == null || index == 0 || index >11){
                        System.out.println("先输入文件名和组索引");
                    }else {
                        Utils.getData(filename,index,data);
                        Integer[][] profit = data.getProfit();
                        Integer[][] weight = data.getWeight();
                        int N = Utils.getC(index);           // 物品组数
                        System.out.printf("请输入容量：");
                        int C = s.nextInt();           // 背包容量
                        int[][] dp = new int[N+1][C+1];
                        Utils.Dynamicprogramming(N, C, dp, profit, weight);
                    }
                    break;
                case 4:
                    System.out.println(data.getList());
                    break;
                case 5:
                    Utils.getChart(data.getProfit1(), data.getWeight1());
                    break;
                case 6:
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
