package code;

import java.util.Arrays;
import java.util.HashSet;

public class PIMCollection<T> extends HashSet<T> {

    public String getPublic() {
        return null;
    }

    //    private Object[] items;
//    private int cnt;
//    private final int MAX = 5000;
//
//    public PIMCollection(){
//        items = new Object[MAX];
//        cnt = 0;
//    }
//
//    public int length(){
//        return cnt;
//    }
//
//    public void add(T t) throws Exception {
//        if(cnt < MAX){
//            items[cnt] = t;
//            cnt ++;
//        }
//        else {
//            throw new Exception("超过容量");
//        }
//    }
//
//    public T get(int idx){
//        if(idx < 0 || idx >= cnt ){
//            throw new IllegalArgumentException("下标越界");
//        }
//        return (T) items[idx];
//    }
//
//    @Override
//    public String toString() {
//        return "PIMCollection{" +
//                "items=" + Arrays.toString(items) +
//                ", cnt=" + cnt +
//                ", MAX=" + MAX +
//                '}';
//    }

}
