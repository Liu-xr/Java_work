package com.lzjtuimis._4_queue;

import java.util.Stack;

public class QueueApplication {

    /* 实现杨辉三角 */
    public static void yhTriangle(IQueue<Integer> queue ,int n){
        // 第一层先进队0/1
        queue.offer(0);
        queue.offer(1);
        int i = 0;                      // 控制层数
        while(i<=n){
            int a = queue.poll();
            if(a==0){                 // 出队队首元素，0，进队0/1,换行
                queue.offer(0);
                queue.offer(1);
                if(i>0) {
                    System.out.println();
                }
                // 三角形式输出，左边有空格输出右边确定了
                for(int j =0;j<n-i;j++)
                    System.out.print("    ");
                i++;
            }
            else{                    // 非0，显示打印，将其与新的队首元素相加进队
                int b = queue.peek();
                queue.offer((a + b));
                System.out.print("\t" + a + "\t");
            }
        }
    }

    /* 简单表达式求值，后缀表达式 */
    static class ExpressClass{
        String exp;							//存放中缀表达式
        StringBuilder postExp = new StringBuilder();					//存放后缀表达式

        //设置exp
        public void setExp(String str){
            exp = str;
        }
        //取post exp
        public String getPostExp(){
            return postExp.toString();
        }

        //将算术表达式exp转换成后缀表达式post exp
        public void Trans(){
            Stack<Character> opor = new Stack<Character>();	//运算符栈
            int i = 0;							//i作为exp的下标，计数遍历
            char ch;
            //exp表达式未扫描完时循环
            while (i<exp.length()){
                ch = exp.charAt(i);;
                if (ch=='(')
                    opor.push(ch);		//判定为左括号,将左括号进栈
                else if (ch==')'){		//判定为右括号
                    while (!opor.empty() && opor.peek()!='('){
                        //将栈中'('之前的运算符退栈并存入post exp
                        postExp.append(opor.pop());
                    }
                    opor.pop();						//将(退栈
                }
                //判定为加或减号
                else if (ch=='+' || ch=='-'){
                    while (!opor.empty() && opor.peek()!='('){
                        //将栈中'('之前的所有运算符退栈并存入post exp
                        postExp.append(opor.pop());
                    }
                    opor.push(ch);				//再将'+'或'-'进栈
                }
                //判定为'*'或'/'号
                else if (ch=='*' || ch=='/'){
                    while (!opor.empty() && opor.peek()!='(' && (opor.peek()=='*' || opor.peek()=='/')){
                        //将op栈中'('之前的'*'或'/'运算符依次出栈并存放到post exp中
                        postExp.append(opor.pop());
                    }
                    opor.push(ch);				//再将'*'或'/'进栈
                }
                //处理操作数
                else{
                    //判定为数字
                    while (ch>='0' && ch<='9'){
                        postExp.append(ch);;
                        i++;					//将连续的数字放入post exp
                        if (i<exp.length())
                            ch = exp.charAt(i);
                        else
                            break;
                    }
                    i--;						//退一个字符
                    postExp.append('#');			//用#标识一个数值串结束
                }
                i++;							//继续处理其他字符
            }
            //此时exp扫描完毕,栈不空时循环
            while (!opor.empty()){  //将栈中所有运算符退栈并放入post exp
                postExp.append(opor.pop());
            }
        }

        //计算后缀表达式post exp的值v
        public double getValue(){
            Stack<Double> opand = new Stack<Double>();	//运算数栈opand
            double a,b,c,d;
            int i = 0;
            char ch;
            //扫描post exp串
            while (i<postExp.length()){
                ch = postExp.charAt(i);		//从后缀表达式中取一个字符ch
                switch (ch){
                    case '+':						//判定为'+'号
                        a = opand.pop();			//退栈取数值a
                        b = opand.pop();			//退栈取数值b
                        c = b + a;					//计算c
                        opand.push(c);				//将计算结果进栈
                        break;
                    case '-':						//判定为'-'号
                        a=opand.pop();				//退栈取数值a
                        b=opand.pop();				//退栈取数值b
                        c=b-a;					    //计算c
                        opand.push(c);				//将计算结果进栈
                        break;
                    case '*':						//判定为'*'号
                        a = opand.pop();				//退栈取数值a
                        b = opand.pop();				//退栈取数值b
                        c = b*a;					//计算c
                        opand.push(c);				//将计算结果进栈
                        break;
                    case '/':						//判定为'/'号
                        a = opand.pop();				//退栈取数值a
                        b = opand.pop();				//退栈取数值b
                        if (a!=0){
                            c = b / a;				//计算c
                            opand.push(c);			//将计算结果进栈
                        }
                        else
                            throw new ArithmeticException("运算错误:除零");
                        break;
                    default:						//处理数字字符
                        d = 0;						//将连续的数字符转换成数值存放到d中
                        //判定为操作数
                        while (ch>='0' && ch<='9'){
                            d=10*d+(ch-'0');
                            i++;
                            ch=postExp.charAt(i);
                        }
                        opand.push(d);				//将数值d进栈
                        break;
                }
                i++;							//继续处理其他字符
            }
            return opand.peek();				//栈顶元素即为求值结果
        }
    }
}
