### Ϊʲô Java �������ǡ�ƽ̨�޹ص����ԡ���
answer��
- ������˵һ��ʲô��**ƽ̨**��<br/>
ƽ̨��CPU�Ͳ���ϵͳ�����塣��ͬ��CPUʹ����ͬ��ͬ��ָ�������ͬ�Ĳ���ϵͳ֧�ֲ�ͬ��CPU�����������������Ĳ���ϵͳ��֧��������CPU�������� windows��liunx��֧��Intel��AMD�ĸ���ָ���������֧��PowerPC��ʹ�õľ���ָ��������ڵ�MAC����ʹ�õ���PowerPC������������Ҳ���޷���MAC��ֱ�Ӱ�װwindows��
- ƽ̨�޹ص����ԣ�Ҳ����˵�����ٲ�ͬ��ƽ̨�����ϰ����У���һ�α�д�������С���Java֮����������������������ִ�з�ʽ�����ȱ������͡�����˵��һ��ƽ̨д�õĳ���.java�ļ���ͨ�����������.class�ļ����ֽ����ļ�����������ֽ���������ƽ̨������ͨ��JVM��Java������������͵ģ���ͬƽ̨�Ĳ�ͬ��JVM��������ɲ�ͬ�ĵ��ʺϱ�ƽ̨�Ļ���ָ�Ȼ��ִ�д���ͬ�Ľ����������Javaͨ��.class�ļ�������м��С����ʵ���˿�ƽ̨�������ڿƻõ�Ӱ�е�����ͨ������һ������һ������ͨ������֮�󣬸�������������ֻ��Ҫ��ȥѧϰ��һ�����ԣ��Ϳ���ʵ���������κ�һ���˽�������Ȼǰ���ǶԷ�Ҳ��ͨ�����ԣ���.class���൱���Ǹ�ͨ�����ԡ�
[�ο�����](https://blog.csdn.net/LB_fighting/article/details/52880079)

### JDK �� JRE ��������ʲô��
answer��
- ���Ƚ���JDK��JDK����Կ�����Ա����������������ṩ������Ŀ������������л�����
- ��JRE(Java Runtime Environment)������java�����ʹ���ߣ���Java�����л�����ֻ��JVM���޷���class�ļ����еģ��ڽ���class�ļ���ʱ��JVM��Ҫ���ý�������Ҫ��**���**������������jreĿ¼���bin�ļ��С�
- ��һ��JDK�İ�װĿ¼���ᷢ���кܶ��ļ��У����о���jre����jre�������bin�ļ�����lib�ļ���bin�ļ����������Ϊ��JVM����bin���������⡣����������һ����ϵ��jdk����jre����jre����jvm��������ϸһ���ᷢ�֣���ʵ���滹��һ��jre�ļ������jre�ļ�����jdk�ļ�ͬһ����ģ�������jdk�ļ������ļ���ΪʲôҪװ����jre�أ�ԭ�����jdk����Ĺ��ߺö඼��Javaд�ģ�������Щ����Ҳ��JavaӦ�ó������Ҫʹ��jdk�����Ĺ������������򣬾���Ҫ��������һ��jre���á�
[�ο�����](https://www.cnblogs.com/myitm/archive/2011/05/03/2035942.html)

### ʲô��ֵ���ݺ����ô��ݣ�
[�ο�����](https://www.zhihu.com/question/31203609/answer/50992895)
- ֵ���ݣ��β���ʵ�ε�һ���������ٷ����ж��βε�ֵ���иı䲢��Ӱ���ⲿʵ�ε�ֵ��Ҳ����˵��ֵ�����ǵ���ģ�������ֵֻ���ٷ�����Ϊ����Ϊ�����ܴ�����
- ���ô��ݣ��βξ���ʵ�εı��������βεĲ������Ƕ�ʵ�εĲ������β������ŵ���ʵ�α����ĵ�ַ�����βν��в������ͻ�ͨ�������ַ�ҵ�ʵ�Σ���ʵ�ν���ͬ���Ĳ�����Ҳ����˵�����������βε��κβ������ᱻ����ɼ��Ѱַ������Ϊ��ˣ����������Բ������κβ�������Ӱ������������ʵ�α�������ʵ�Σ��β����ڴ��д�ŵ�ַ�ĽǶ�˵������ı��ʣ�������⣺
```c++
#include<iostream>
using namespace std;
//ֵ����
 void change1(int n){
    cout<<"ֵ����--����������ַ"<<&n<<endl;         //��ʾ���ǿ����ĵ�ַ������Դ��ַ 
    n++;
}

//���ô���
void change2(int & n){
    cout<<"���ô���--����������ַ"<<&n<<endl; 
    n++;
}
 } 
int main(){
    int n=10;
    cout<<"ʵ�εĵ�ַ"<<&n<<endl;
    change1(n); 
    cout<<"after change1() n="<<n<<endl;
    change2(n);
    cout<<"after change2() n="<<n<<endl;
    return true;
}
```
���Ϊ![result](https://i.loli.net/2019/03/16/5c8cdfc1eeab0.png)
�ӽ�����Կ���������ֵ���ݵ�ʱ�򣬺���������ַ������ʵ�α������Զ������в��������ܸı�ʵ�ε�ֵ���������ô��ݲ����ĵ�ַ����ʵ�ε�ַ�����Զ����Ĳ���Ӱ�����Ȼ�ļӵ��˶�ʵ�ε�Ӱ����ȥ��
- ������Java��ֻ��ֵ���ݣ�û�����ô��ݡ������׶�ҡ����۵�ľ��ڡ���java�����������ʹ��ݺ����ô���������̡�
1. �������ʹ���ʱ������������ӣ�
```java
package com.zejian.test;

public class CallByValue {
	
    private static int x=10;
	
    public static void updateValue(int value){
        value = 3 * value;
    }
	
    public static void main(String[] args) {
        System.out.println("����ǰx��ֵ��"+x);    // ����ǰx��ֵ��10
        updateValue(x);
        System.out.println("���ú�x��ֵ��"+x);    // ���ú�x��ֵ��10
    }	
}
```
����Ȼ������������У���ֵ���ݣ�valueֻ��x��һ��������value = 3 * value֮����value�����30������x��
2. �������͵Ĵ��ݹ��̣�
```java
package com.zejian.test;
public class User {
    private String name;
    private int age;
    public User(String name, int age) {
        this.name=name;
        this.age=age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

//ִ�������£�
package com.zejian.test;

public class CallByValue {
    private static User user=null;
    public static void updateUser(User student){
        student.setName("Lishen");
        student.setAge(18);
    }
	
	
    public static void main(String[] args) {
        user = new User("zhangsan",26);
        System.out.println("����ǰuser��ֵ��"+user.toString());
        updateUser(user);
        System.out.println("���ú�user��ֵ��"+user.toString());
    }
}
```
����ǰuser��ֵ��User [name=zhangsan, age=26]
���ú�user��ֵ��User [name=Lishen, age=18]<br/>
������������������Ϊ���ǰ����õ��ã����ô��ݣ��ġ���ʵ��Ȼ��������������һ��������̣�user�����������ָ��User���󣬶�`updateUser(user)`����֮�����ò���student������user��ֵ����ʱstudent�������Ҳָ��User����������ȷ��Ļ����൱�ڣ�User�����Ǹ����ӻ�����uer�������þ���������ӻ���ң���������� `updateUser(user)` ����֮�����ң�����������˶����Ǹ߷µģ���Ҳ�ܶԵ��ӻ�Ϊ����Ϊ�����ԣ���user��student��ָ��ͬ���User���������£�˭���������������õģ���Ȼ���˭���ܲ������ɷ�Χ�ģ�updateUser(user)�����ù�֮��student��׼�������ɣ���û�л����ڶԵ��ӻ���ô���ˣ�<br/>
��������ľͲ��ǰ����ô��ݡ���Ϊ��student��user�����Զ�User������������student�ҵ�userȻ����userȥ��������User��
����ֵ���ݺ����ô��ݵ���������[����](https://www.cnblogs.com/yanlingyin/archive/2011/12/07/2278961.html)<br/>
�����ο�����[������](https://blog.csdn.net/javazejian/article/details/51192130)[������](https://www.zhihu.com/question/31203609/answer/50992895)