package myblog.myblog11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(10,24,31,23,10,21,22,23,24,25,26,27,29,31);
        List<Integer> val = data.stream().distinct().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(val);
    }


}
