import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
   public static List<Integer> list= new ArrayList<>(List.of(1,10,11,12,15,8,9,22,55,14));

    public static void main(String[] args) {
        findMinMax(list.stream(), Integer::compareTo,(x,y)-> System.out.printf("min %d, max %d", x,y));
        System.out.println("\n задание 2");
       System.out.println(getCount(list));
    }
    public static  <T> void findMinMax(Stream<? extends T> stream,
                                Comparator<? super T> order,
                                BiConsumer<? super T, ? super T> minMaxConsumer){
       List<T> list1=stream.sorted(order).collect(Collectors.toList());
       if(!list1.isEmpty()){
           minMaxConsumer.accept(list1.get(0),list1.get(list1.size()-1));
       }
       else {
           minMaxConsumer.accept(null,null);
       }
    }
    public static Long getCount (List<Integer> listok){
        return listok.stream().filter(integer -> integer % 2 == 0).count();
    }
}