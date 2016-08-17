import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by zq on 2016/8/16.
 */
public class Advance1115 {

    private static HashMap<Integer,Integer>theNodeNumberOfLevel;
    private static Integer maxLevel = 0;
    private static Node tree = null;

    public static void main(String[] arg){

        theNodeNumberOfLevel = new HashMap<Integer,Integer>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0;i<n;i++){
            int a = scanner.nextInt();
            Node node = new Node(a);
            tree = getLevel(node,tree,0);
        }


        int n1 = getOrDefault(maxLevel);
        int n2 = getOrDefault(maxLevel-1);
        int n3 = n1+n2;

        System.out.println(n1+" + "+n2+" = "+n3);
    }

    private static int getOrDefault(int i){
        if(theNodeNumberOfLevel.get(i)!=null) return theNodeNumberOfLevel.get(i);
        else return 0;
    }


    private static Node getLevel(Node node1, Node node2,int i) {
        if(node2==null) {
            theNodeNumberOfLevel.put(i,1+getOrDefault(i));
            if(maxLevel<i) maxLevel = i;
            return node1;
        }
        if(node1.value<=node2.value){
            node2.leftNode = getLevel(node1,node2.leftNode,i+1);
        }else node2.rightNode = getLevel(node1,node2.rightNode,i+1);
        return node2;
    }

    private static class Node{
        public int value;
        public Node leftNode = null;
        public Node rightNode = null;

        public Node(int value){
            this.value = value;
        }
    }

}
