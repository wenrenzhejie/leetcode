import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.xml.stream.events.EndElement;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MaxPoints_149 {
    public int maxPoints(int[][] points) {
        HashMap<String, Integer> map = new HashMap<>();
        int[][] pointsNR = new int[points.length][2];
        int max = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0;i < points.length;i ++){
            if (hashMap.getOrDefault(points[i][0]+"#"+points[i][1],0) == 0){
                pointsNR[hashMap.size()][0] = points[i][0];
                pointsNR[hashMap.size()][1] = points[i][1];
                hashMap.put(points[i][0]+"#"+points[i][1],1);
            }else {
                hashMap.put(points[i][0]+"#"+points[i][1],hashMap.get(points[i][0]+"#"+points[i][1]) + 1);
            }
        }
        if (hashMap.size() == 0){
            return 0;
        }
        if (hashMap.size() == 1){
            return hashMap.get(pointsNR[0][0]+"#"+pointsNR[0][1]);
        }
        if (hashMap.size() == 2){
            return hashMap.get(pointsNR[0][0]+"#"+pointsNR[0][1]) + hashMap.get(pointsNR[1][0]+"#"+pointsNR[1][1]);
        }
            for (int i = 0;i < hashMap.size();i ++){
            int a = pointsNR[i][0];
            int b = pointsNR[i][1];
            map.clear();
            for (int j = i + 1;j < hashMap.size();j ++){
                    int a1 = pointsNR[j][0];
                    int b1 = pointsNR[j][1];
                    int y = b1 - b;
                    int x = a1 - a;
                    //无斜率
                    if (Math.abs(x) == 0){
                        if (map.getOrDefault(a+"",0) == 0){
                            map.put(a+"",hashMap.get(a+"#"+b)+hashMap.get(a1+"#"+b1));
                        }else {
                            map.put(a+"",map.get(a+"") + hashMap.get(a1+"#"+b1));
                        }
                        max = Math.max(max,map.get(a+""));
                    }else {
                        //有斜率
                        //求对y与x约分，先求两者的最大公因数
                        int factor = maxFactor(y, x);
                        x = x / factor;
                        y = y / factor;
                        // y/x == k
                        String m = b + "-"+ y+"/"+x +"*"+a;
                        if (map.getOrDefault(y+"/"+x+"*"+m,0) == 0){
                            map.put(y+"/"+x+"*"+m,hashMap.get(a+"#"+b)+hashMap.get(a1+"#"+b1));
                        }else {
                            map.put(y+"/"+x+"*"+m,map.get(y+"/"+x+"*"+m)+hashMap.get(a1+"#"+b1));
                    }
                        max = Math.max(max,map.get(y+"/"+x+"*"+m));
                    }
                }
        }
        return max;
    }

    private int maxFactor(int i, int j){
        while (i % j != 0){
            int temp = j;
            j = i % j;
            i = temp;
        }
        return j;
    }

    public static void main(String[] args){
        int[][] points = new int[][]{{0,0},{94911151,94911150},{94911152,94911151}};
        int i = new MaxPoints_149().maxPoints(points);
        System.out.println(i);
    }
}
