import java.util.LinkedHashSet;
import java.util.Set;

public class CmdSet {
    public static void main(String[] args) {
        Set<String> s = new LinkedHashSet<>();
        //将命令行的每个字符串加到集合s中，不包含重复元素
        for (String a:args
             ) {
            if(!s.add(a))
                System.out.println("重复元素" + s);
        }
        System.out.println(s.size() +"不同元素有" + s);
    }
}
