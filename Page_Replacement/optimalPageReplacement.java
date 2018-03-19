package Page_Replacement; /**
 * Created by Portal on 3/18/2018.
 */
import java.util.*;
public class optimalPageReplacement {
    static int frames = 4;
    static  ArrayList<Integer> pg = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5));//7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1));
    static ArrayList<Integer> memory =new ArrayList<>();
    static int elementReplaced(int index){
        int[] fram=new int[frames];
        List search=pg.subList(index+1,pg.size());
        int largest=Integer.MIN_VALUE;
        int unusedIndex=-1;
        for(int i=0;i<frames;i++){
            fram[i]=search.indexOf(memory.get(i));
            if(fram[i]==-1)
                return i;
            if(fram[i]>largest){
                largest=fram[i];
                unusedIndex=i;
            }
        }

        return unusedIndex;
    }
    public static void main(String[] args) {

       //{1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        //{0, 2, 1, 6, 4, 0, 1, 0, 3, 1, 2, 1};/*

        //System.out.println(memory.indexOf(2));
        int i;
        int pageFaults = 0;

        for(i=0;i<frames;i++){
            memory.add(pg.get(i));
        }
        pageFaults+=frames;
        for(i=frames;i<pg.size();i++){
            if(!memory.contains(pg.get(i))){
                memory.set(elementReplaced(i),pg.get(i));
                pageFaults++;
            }
        }
        System.out.println("No. of page faults are: "+pageFaults);
    }
}
