package utils;

import pojo.Data;

import java.io.*;
import java.util.Scanner;

/**
 * @author sxy
 * @create 2021-03-30-14:19
 */
public class Utils {


    public static void getData(String fileName, int index, Data data){
        int index1 = 3;
        int n = 0;
        Integer[][] profit = null;
        Integer[][] weight = null;
        if (index == 1) {
            index = 5;
            index1 = index + 2;
            n = 10;
        } else if (index == 2) {
            index = 13;
            index1 = index + 2;
            n = 100;
        } else if (index == 3) {
            index = 21;
            index1 = index + 2;
            n = 200;
        } else if (index == 4) {
            index = 29;
            index1 = index + 2;
            n = 300;
        } else if (index == 5) {
            index = 37;
            index1 = index + 2;
            n = 400;
        } else if (index == 6) {
            index = 45;
            index1 = index + 2;
            n = 500;
        } else if (index == 7) {
            index = 53;
            index1 = index + 2;
            n = 600;
        } else if (index == 8) {
            index = 61;
            index1 = index + 2;
            n = 700;
        } else if (index == 9) {
            index = 69;
            index1 = index + 2;
            n = 800;
        } else if (index == 10) {
            index = 77;
            index1 = index + 2;
            n = 900;
        } else if (index == 11) {
            index = 85;
            index1 = index + 2;
            n = 1000;
        } else {
            System.out.println("输入有误！");
        }
        profit = new Integer[n+1][3];
        weight = new Integer[n+1][3];
        FileInputStream fis = null;

        InputStreamReader isr = null;

        BufferedReader br = null; //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。

        try {
            String str = "";

            String str1 = "";
            String str2 = "";

            fis = new FileInputStream(fileName);// FileInputStream

            // 从文件系统中的某个文件中获取字节

            isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,

            br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
            int i = 0;
            while ((str = br.readLine()) != null) {
                if (index == i) {
                    str1 = str;
                }
                if (index1 == i) {
                    str2 = str;
                }
                i++;
            }
            str1 = str1.replace(".", "");
            str2 = str2.replace(".", "");
//            System.out.println(str1);// 打印出str1
//            System.out.println(str2);// 打印出str2
            String[] split = str1.split(",");
//            for (String s : split) {
//                System.out.printf(s + " ");
//            }
            int k = 1;
            int l = 0;
            int x = 0;
            for (int j = 1; j <= split.length; j++) {
                profit[k][x++] = Integer.parseInt(split[j - 1]);
                if (j % 3 == 0 && j != 1) {
                    k++;
                    x = 0;
                }
            }
//            System.out.println("");
            String[] split1 = str2.split(",");
//            for (String s : split1) {
//                System.out.printf(s + " ");
//            }
            k = 1;
            l = 0;
            x = 0;
            for (int j = 1; j <= split1.length; j++) {
                weight[k][x++] = Integer.parseInt(split1[j - 1]);
                if (j % 3 == 0 && j != 1) {
                    k++;
                    x = 0;
                }
            }
//            System.out.println("");
//            System.out.println(profit[0][0]);
//            for (int j = 0; j < profit.length; j++) {
//                for (int m = 0; m < 3; m++) {
//                    System.out.printf(profit[j][m] + " ");
//                }
//                System.out.println("");
//            }
//            for (int j = 0; j < weight.length; j++) {
//                for (int m = 0; m < 3; m++) {
//                    System.out.printf(weight[j][m] + " ");
//                }
//                System.out.println("");
//            }


        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件");

        } catch (IOException e) {
            System.out.println("读取文件失败");

        } finally {
            try {
                data.setProfit(profit);
                data.setWeight(weight);
                br.close();

                isr.close();

                fis.close();

                // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m

            } catch (IOException e) {
                e.printStackTrace();

            }

        }
    }

}
