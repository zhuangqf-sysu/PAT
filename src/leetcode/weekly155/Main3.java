package leetcode.weekly155;

import org.omg.CORBA.INTERNAL;
import sun.awt.image.ImageWatched;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author zhuangqf
 * @date 2019/9/22
 */
public class Main3 {

    public static void main(String[] args) {
        Main3 main3 = new Main3();
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0,3));
        pairs.add(Arrays.asList(1,2));
        pairs.add(Arrays.asList(0,2));
        System.out.println(main3.smallestStringWithSwaps("dcab",pairs));
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int[] parent = new int[s.length()];
        Map<Integer,List<Character>> map = new HashMap<>();
        Map<Integer,List<Integer>> index = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            parent[i] = i;
        }
        char[] chars = s.toCharArray();
        for(List<Integer> pair : pairs) {
            mergeParent(parent,chars,map,index,pair.get(0),pair.get(1));
        }
        map.forEach((key,list)->{
            List<Integer> indexList = index.get(key);
            Collections.sort(list);
            Collections.sort(indexList);
            for(int i=0;i<list.size();i++) {
                chars[indexList.get(i)] = list.get(i);
            }
        });

        return new String(chars);
    }

    private void mergeParent(int[] parent, char[] chars, Map<Integer,List<Character>>map, Map<Integer,List<Integer>>index, Integer i, Integer j) {
        int pi = findParent(parent,i);
        int pj = findParent(parent,j);
        if(pi == pj) {
            return;
        }
        int min = Math.min(pi,pj);
        int max = Math.max(pi,pj);
        List<Character> charList = map.get(min);
        List<Integer> indexList = index.get(min);
        if(charList == null) {
            charList = new LinkedList<>();
            indexList = new LinkedList<>();
            charList.add(chars[min]);
            indexList.add(min);
            map.put(min,charList);
            index.put(min,indexList);
        }
        List<Character> charList2 = map.get(max);
        List<Integer> indexList2 = index.get(max);
        if(charList2!=null) {
            charList.addAll(charList2);
            indexList.addAll(indexList2);
            map.remove(max);
            index.remove(max);
        }else{
            charList.add(chars[max]);
            indexList.add(max);
        }
    }

    private int findParent(int[] parent, Integer i) {
        if(parent[i] == i) {
            return i;
        }
        int p = findParent(parent,parent[i]);
        parent[i] = p;
        return p;
    }

}
