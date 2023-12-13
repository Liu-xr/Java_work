package com.lzjtuimis._3_stack;

public class StackApplication {
    // 括号配对
    public static boolean isMatch(String str){
        int i = 0;
        SeqStackClass<Character> stack = new SeqStackClass<Character>();	//建立一个顺序栈存放表达式的运算符
        while (i < str.length()){
            char e = str.charAt(i);
            //将左括号进栈
            if (e=='(' || e=='[' || e=='{')
                stack.push(e);
                //右边括号配对
            else{
                if (e==')'){
                    if (stack.empty()) return false;		//栈空
                    if (stack.peek()!='(') return false;	//栈顶不是匹配的'('
                    stack.pop();
                }
                if (e==']'){
                    if (stack.empty()) return false;		//栈空
                    if (stack.peek()!='[') return false;	//栈顶不是匹配的'['
                    stack.pop();
                }
                if (e=='}'){
                    if (stack.empty()) return false;		//栈空返回false
                    if (stack.peek()!='{') return false;	//栈顶不是匹配的'{'
                    stack.pop();
                }
            }
            i++;										//继续遍历str的下一个字符
        }
        //栈不空，多出来的括号，返回false
        return stack.empty();								//栈空表示全部配对完成，返回true
    }

    /* 判断是否回文 */
    // 字符串的前半部分进栈，若前半部分的依次出栈序列与字符串后半部分一样则是回文，若字符串长度奇数，则以中位数为间隔分前后部分。
    public static boolean isPalindrome(String str){
        SeqStackClass<Character> st = new SeqStackClass<>();	//建立一个顺序栈
        int n = str.length();
        int i = 0;
        //将str前半字符进栈
        while (i<n/2){
            st.push(str.charAt(i));
            i++;						//继续遍历str
        }
        //n为奇数时跳过中间的字符
        if (n % 2==1)
            i++;
        //遍历str的后半字符，与进栈的前半部分的出栈顺序比较
        while (i<n){
            if (st.pop()!=str.charAt(i))
                return false;			//若str[i]不等于出栈字符返回false
            i++;
        }
        return true;					//是回文返回true
    }

    /* 大数加法 */
    public static StringBuffer addition(String strA, String strB){
        LinkStackClass<String> SA = new LinkStackClass<>();   // 存大数A
        LinkStackClass<String> SB = new LinkStackClass<>();   // 存大数B
        LinkStackClass<Integer> SC = new LinkStackClass<>();   // 结果栈C
        for(int i=0;i<strA.length();i++)
            SA.push(String.valueOf(strA.charAt(i)));
        for(int i=0;i<strB.length();i++)
            SB.push(String.valueOf(strB.charAt(i)));
        int a, b;     // 临时保存大数A和B出栈元素
        int c = 0,d;  // 保存大数A和B相加的和的个位数d，以及进位c
        // 若两个加数栈都非空，则依次从栈中弹出栈顶数字相加；若两栈都为空则相加完全
        while(!SA.empty() || !SB.empty()){
            if(!SA.empty())
                a = Integer.parseInt(SA.pop());
            else    				 // 有一个大数栈出栈完，则在相加时视为0
                a = 0;
            if(!SB.empty())
                b = Integer.parseInt(SB.pop());
            else
                b = 0;
            d = (a+b+c) % 10;   // 取余，相加后和的个位数，如9+8=17，7位和的个位数
            c = (a+b+c) / 10;   // 取模，相加后的进位，a+b+c表示两数的同位数与上一位数的进位相加
            SC.push(d);         // 相加后的同一位数进结果栈，如9+8=17，进栈7
        }
        if(c!=0)  					// 最高位最后的进位情况
            SC.push(c);
        StringBuffer strC = new StringBuffer();
        while(!SC.empty())  		// 结果栈出栈
            strC.append(SC.pop());
        return strC;
    }
}
