package pojo;

import java.util.Arrays;

/**
 * @author sxy
 * @create 2021-03-30-16:29
 */
public class Data {
    Integer[][] profit = null;
    Integer[][] weight = null;

    public Data() {
    }

    public Data(Integer[][] profit, Integer[][] weight) {
        this.profit = profit;
        this.weight = weight;
    }

    public Integer[][] getProfit() {
        return profit;
    }

    public void setProfit(Integer[][] profit) {
        this.profit = profit;
    }

    public Integer[][] getWeight() {
        return weight;
    }

    public void setWeight(Integer[][] weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "data{" +
                "profit=" + Arrays.toString(profit) +
                ", weight=" + Arrays.toString(weight) +
                '}';
    }
}
