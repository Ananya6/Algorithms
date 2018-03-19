package Page_Replacement;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Portal on 3/19/2018.
 */
public class leastRecentlyUsed {
    static int frame=3;
    static ArrayList<Integer> pg=new ArrayList<>(Arrays.asList(7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1));//1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5));
    static ArrayList<Integer> memory=new ArrayList<>();
    static int[] occurence=new int[frame];
    static int lru(){
        int leastUsed=Integer.MAX_VALUE;
        int leastUsedIndex=-1;
        for(int j=0;j<occurence.length;j++){
            if(occurence[j]<leastUsed){
                leastUsed=occurence[j];
                leastUsedIndex=j;
            }
        }
        return leastUsedIndex;
    }
    public static void main(String[] args) {
     int i;
     int pagefaults=0;
     for(i=0;i<frame;i++){
         memory.add(pg.get(i));
         occurence[i]=i;
     }
     pagefaults+=frame;
     for(i=frame;i<pg.size();i++){
         int index=memory.indexOf(pg.get(i));
         if(index<0){
             int replacedindex=lru();
             memory.set(replacedindex,pg.get(i));
             occurence[replacedindex]=i;
             pagefaults++;
         }else
         {
             occurence[index]=i;
         }
     }
        System.out.println("Page Faults are: "+pagefaults);

    }
}
