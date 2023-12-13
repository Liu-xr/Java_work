package exception;

public class exception1 {
	public static void main(String[] args) {

        /*有返回值*/
        System.out.println(withReturn0());
        System.out.println(withReturn1());
        System.out.println(withReturn2());
        System.out.println(withReturn3());

        /*正常函数编写*/
        System.out.println(withReturn(10, 0));  //有异常：执行finally语句和语句体外的return a。a的初始值10
        System.out.println(withReturn(10, 5));  //无异常：执行finally语句和try中的首个return。

    }

    /* 一、 有返回值：finally中和语句块外不能同时存在return，否则出现语法错误：不可到达的错误*/
    //正常函数编写：try中可有可无return，语句体外一定要有return，finally内不建议有return语句
    public static int withReturn(int a, int b){
        try{
            a = a / b;
            return a;
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
            System.out.println("withReturn()：执行finally子句");
        }
        return a;
    }
    //1. return在语句体外
    // 有异常：不会执行try中return，执行finally中信息输出和语句体外return的a初始值。
    public static int withReturn0(){
        int a = 1, b = 0;
        try{
            a = a / b;
            return a;
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
            System.out.println("withReturn0()：执行finally子句");
        }
        return a;
    }
    //无异常：执行try中的首个return和finally中输出（先），不执行语句体外的return
    public static int withReturn1(){
        int a = 1, b = 1;
        try{
            a = a / b;
            return a;
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
            System.out.println("withReturn1()：执行finally子句");
        }
        return a;
    }

    //2. return在finally中：会出现警告，不建议
    //有异常：执行finally中输出和return
    @SuppressWarnings("finally")    // 注释说明是警告
	public static int withReturn2(){
        int a = 1, b = 0;
        try{
            a = a / b;
            return a;
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
            System.out.println("withReturn2()：执行finally子句");
            return 0;
        }
    }
    //无异常：执行try和finally中语句，但是执行finally第二个return，return只能执行一个，但finally语句一定执行，所以。
    @SuppressWarnings("finally")     // 注释说明是警告
	public static int withReturn3(){
        int a = 1, b = 1;
        try{
            a = a / b;
            return a;
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
            System.out.println("withReturn3()：执行finally子句");
            return 10;
        }
    }


    /* 二、无返回值 */
    // try有异常，不执行try中输出，只执行finally中输出
    // try无异常，既执行try输出又执行finally输出
    public static void withVoid(){
        int a = 1, b = 0;
        try{
            a = a / b;
            System.out.println("得到a= " + a);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
            System.out.println("执行finally子句");
        }
    }


}
