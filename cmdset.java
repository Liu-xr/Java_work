import java.util.LinkedHashSet;
import java.util.Set;

public class CmdSet {
    public static void main(String[] args) {
        Set<String> s = new LinkedHashSet<>();
        //�������е�ÿ���ַ����ӵ�����s�У��������ظ�Ԫ��
        for (String a:args
             ) {
            if(!s.add(a))
                System.out.println("�ظ�Ԫ��" + s);
        }
        System.out.println(s.size() +"��ͬԪ����" + s);
    }
}
