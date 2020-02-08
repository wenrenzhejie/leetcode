import org.omg.CORBA.StringHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0;i < strs.length;i ++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (map.getOrDefault(s,null) == null){
                List<String> list = new ArrayList<>();
                lists.add(list);
                list.add(strs[i]);
                map.put(s,list);
            }else {
                map.get(s).add(strs[i]);
            }
        }
        return lists;
    }


}
