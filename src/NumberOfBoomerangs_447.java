import java.nio.channels.NotYetBoundException;
import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs_447 {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0;i < points.length;i ++){
            hashMap.clear();
            for (int j = 0;j < points.length;j ++){
                if (i != j){
                    int dis = dis(points, i, j);
                    Integer count = hashMap.getOrDefault(dis, 0);
                    //巧妙的节省了一次遍历
                    if (count >= 1){
                        res += 2 * count;
                    }
                    hashMap.put(dis,hashMap.getOrDefault(dis,0) + 1);
                }
            }
        }
        return res;
    }

    private int dis(int[][] points, int i, int j) {
        return (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
    }
}
