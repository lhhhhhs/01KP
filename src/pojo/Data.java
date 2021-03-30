package pojo;

import java.util.Arrays;
import java.util.List;

/**
 * @author sxy
 * @create 2021-03-30-16:29
 */
public class Data {
    Integer[][] profit = null;
    Integer[][] weight = null;
    Integer[] profit1 = null;
    Integer[] weight1 = null;
    List<Float> list = null;

    public Data() {
    }

    public Data(Integer[][] profit, Integer[][] weight, List<Float> list) {
        this.profit = profit;
        this.weight = weight;
        this.list = list;
    }

    public Integer[] getWeight1() {
        return weight1;
    }

    public void setWeight1(Integer[] weight1) {
        this.weight1 = weight1;
    }

    public Integer[] getProfit1() {
        return profit1;
    }

    public void setProfit1(Integer[] profit1) {
        this.profit1 = profit1;
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

    public List<Float> getList() {
        return list;
    }

    public void setList(List<Float> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "data{" +
                "profit=" + Arrays.toString(profit) +
                ", weight=" + Arrays.toString(weight) +
                '}';
    }
}
