# 						常用内置方法和属性

## 数组 [ ] 的方法

### 数组的初始化

```java
// 一维数组的话，必须指定长度！！！！！！！！！

// 1. 直接 指定长度
int[] nums = new int[3];
nums[0]=1;
nums[2]=4;

// 2. 直接赋值，也就是 等于指定长度
int[] nums = new int[]{1,2,3,5};
nums[0]=6;
        
```



### 基本数据类型 用 普通for循环遍历 

```java
int[] nums = new int[]{1,2,3,5};

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
```



### 如果是引用类型 用增强 for循环遍历

```java
String[] str = new String[]{"123","666","777"};
        for (String s : str) {

            System.out.println(s);
        }
```



### int [ ] 整型数组 原地排序 改变原数组

```java
// 排序 是 根据 ”大小“ 关系 进行 排序！！！
int [] nums = new int[6]{1,3,5,9,-1,0};

		//  sort(nums) 方法，只能 传入 int []数组 ！！！而且是 原地 排序 ，没有返回新数组 
	// 而且  一般 都是  “只能”  传入  int [] 整数型 数组 ！！！！升序，降序
	//  并不适合 String [] 字符串数组 倒序 

		// 这个是 ”原地“ 排序 ，就是只对 传入的数组 进行排序，而 不是 返回 一个 排序号后的 新数组！！！
     Arrays.sort(nums);   
		System.out.println(nums[5])// 此时 最后一个下标的元素值  就是  最大值  9
```

### int [ ] 整型数组 只是 找 最大值 不改变原数组

```java

	int[] nums = new int[]{1,10,7,8,6};
//  这里的算法 只是 “找”最大值，并不是对 整个数组 进行排序，变动元素  
        for (int i = leftIndex; i < rightIndex; i++) {
            if (nums[i] > maxVal){
                
                 maxIndex = i;
                 maxVal = nums[i];
                
            }
        }
```

### 两个数组的 复制 

```java

int[] nums = new int[]{1,10,7,8,6}; 

  // 错误写法 × ：  这样是错误。因为nums是在 堆里， a就只是一个 对象引用，指向 nums数组，所以 nums改变了的话， 临时数组 temp而会跟着改变，所以 就失去了意义 
 int [] temp = nums;
    
 // 正确写法 √ ： 调用 数组nums内置的 clone()方法 
 int[] a= nums.clone();
```

### 从数组中的 某个下标范围 复制到一个新数组

```java
// 原始数组
        int [] originalArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        									
        // 复制从索引 2 到索引 5（不包括）的元素
        int [] newArray = Arrays.copyOfRange(originalArray, 2, 5);
        
        // 输出新数组中的元素
        System.out.println(Arrays.toString(newArray)); // 输出: [3, 4, 5]

```



### 两个数组的 是否相等

```java
int[] num1 = new int[]{1,2,3,4,6};
        int[] num2 = new int[]{1,2,3,4,6};
									// 调用	Arrays类的equals(,)方法			
        System.out.println(Arrays.equals(num1, num2)); // true
```



### 数组转为 list集合 

```java

        String [] str = new String[]{"aaa","bbb","ccc","ddd"};

    
   //  通过Arrays类的  asList() 方法，传入 字符串数组 str 。
		List<String> list = Arrays.asList(str);
     //  其实也可以 传入  多个值，因为 asList()方法是 可变参数 ...
    Arrays.asList(1, 2, 3, 4, 5);

```



### String [ ] 数组 反转 但要先转为list集合

```java
		 //  该方法 常常 用于  String [] 字符串类型  的数组 反转
        //  注意 是  “反转” ！！！只是 交换 顺序 。。 而不是 排序， 升序 或 降序

        String [] str = new String[]{"aaa","bbb","ccc","ddd"};
        // 注意 传入的必须是 一个list集合，所以还要配合一下 Arrays的asList(str)方法。采用的是 方式一
        //      从而把字符串 数组 转为 list 集合 ，那么就能传入  reverse() 
					

   // 第 1 步：   先通过Arrays的  asList() 方法，传入 字符串数组 str 。返回值 就是 List集合
		List<String> list = Arrays.asList(str);

//第 2 步： Collections 的 reverse()方法传入的必须是 list  集合。因为 它是有序的 ！！set 就不行！
			// 而且是  ”原地“反转 哦！！
		Collections.reverse(list);

		System.out.println(list);// list 集合的顺序肯定是反转了： [ddd, ccc, bbb, aaa]
		
	 // "原地" 反转 后，此时的 str 字符串 数组 也变为了：[ddd, ccc, bbb, aaa]
        for(String s :str)
            System.out.println(s);
```

### 数组的初始化 全指定为某个值

```java
int [] nums = new int[10];  // 本来默认都是 0 

// 那我们如果要指定呢？

// 调用 Arrays类的fill(数组名,指定的初始值) 方法
 Arrays.fill(result,-1);


```





### 数组长度值

```java
int [] nums = new int[10];

// 调用它们的属性 length ，进行返回 数组的长度
n = nums.length;


```

### 二维数组的初始化



```java
//方式1： 定义一个二维数组，指定 行数 和列数 ，此时二维数组的行数为3，列数为2。 
int[][] arr = new int[3][2];
// 然后就可以赋值了
	arr[0][1]=1;


// 方式2 ： 只需要指定 行数，列数可以不指定。。此时所有的一维数组还没有分配内存空间；arr[i]的地址为null

int[][] arr = new int[3][];
	
// 切记！！下面还要给 给每个一维数组 开辟空间，若没有这一步，直接赋值[i][j]就会 报错！！
for (int i = 0; i < arr.length; i++) {
    
    arr[i] = new int[i + 1];    
}

// 之后才能赋值 ！！。。。。
arr[0][1]=1;





```



### 二维数组的行数和列数

```java


int[][] arr = new int[3][2];
    //  就是代表 "行"	
int row = arr.length;
 
	//  arr[i].length 得到对应的 每个一维数组的长度，也就是"列" 
	int col = arr[0].length;



```

## 整型 Integer 的方法

### 纯数字字符串 整个转为数字

```java

        String s = "123";
        					// parseInt(s) 方法，只能传入 纯数字 的 字符串 "123"
        int num = Integer.parseInt(s);
		System.out.println(num); // 输出 123
```

### 纯数字字符串 获取单个数字

```java
        String s = "123";
         
   // charAt(i) 方法，只能传入 0,1,2下标，获取字符串中的单个 数字字符， 一一转为 数字类型
		// 记得 要减去 '0' ，这个很关键 ！！！！
		for(int i=0;i<s.length();i++){
            int num = s.charAt(i)-'0';
            System.out.println(num); 
        }
        			// 输出  1 
				   //       2 						
				   //       3
```

### 整数最大值

```java

// 这种 定义出来的时候，常用于找 数组中符合某些条件的一些 最小值，所以要先初始化 result变量作为 Integer的最大值，每次在 for循环里面 进行比较，不断更新赋值

int result =Integer.MAX_VALUE;
```



### 整数最小值 

```java

// 这种 定义出来的时候，常用于找 数组中符合某些条件的一些 最大值，所以要先初始化 result变量作为 Integer的最小值，每次在 for循环里面 进行比较，不断更新赋值

int result =Integer.MIN_VALUE;
```



## 字符串String的方法

### 字符串 转为 字符数组 

```java
String s = "abc";
					//  toCharArray()方法，直接调用就行，无参数 
 char [] chars = s.toCharArray();
int n = char.length;
```

### 字符数组 转为 字符串 

```java

String s = "asdbasdasdddeeevg";
char[] cs = s.toCharArray();

             
	
			  //  new String(cs)，类似 对象声明式 的转换
String key = new String(cs);
```

### 获取某个下标对应的 某个字符 

```java
String shujin="adasd";
String zazhi="asfdafee";
for (int i = 0; i < zazhi.length(); i++) { 
                
      		// charAt(i)方法，传入 一个 下标值 就行
                if(shujin.charAt(i)==zazhi.charAt(i)){
           
                }
}
```

### 遍历  字符串中  的每一个 字符

```java
		
			String a = "adasd";
			//  建议用for 循环 遍历 String  ！！！！！！！  
	for (int i = 0; i < a.length(); i++) { 
                
      		System.out.println(a.charAt(i));
}
```



### 统计字符串的 长度

```java
String a="adasd";
// 这个 就比较特殊 ，是调用一个方法length()，而不是 调用属性length
int n = a.length();
```

### 截取 字符串中 的 子串

```java
String a="adasd";
// substring(begin,end) 。注意注意！！！它返回的是从 beginIndex 到 endIndex - 1 的子字符串。

  	// 所以应该返回 0，3 下标之间的 子字符串。所以 最终 结果 是 adas
String result = a.substring(0,4);  
				 
```

### 去除 字符串的 首尾 空格

```java
String a="   a dasd ";
// trim() 注意注意！！！它  只去除 首尾的 一个或者多个空格
String result = a.trim();  // 所以 最终 结果 是 "a dasd"
```

### 以某个 分隔符 分割 字符串

```java
// 普通 情况
String str = "Hello sb six boy";
				   //  split(" ")传入的是一个分隔符，比如 空格符号  " " 或 逗号","
        String[] split = str.split(" ");   //  返回的是  一个 String [] 的 字符串 数组 
					//  输出的是  ["Hello","sb","six","boy"]
        

     // ”特殊“情况 ，特殊用法  

	String str = "Hello   sb"; 
	// 此时 每个 单词 之间  的 空格 个数 比较多，那么 如果 之间有 3个空格，会分割产生2个 空字符串"",""
	// 输出的是 	["Hello","","","sb"]

		// 我们仍要 按照 空格 分隔，并且 当有 多个空格 的时候，我们也是 能 只分割 单词

		// + 加号 的话就是，会 按照1个或者多个 空格 对 单词进行 分割 
		//   返回的就会是 我们想要的答案 了 ["Hello","sb"] 
        String[] split = str.split(" +");
```

### 匹配两个字符串是否相等

**切记**！！ 比较字符串相等的时候，用 **equals**("") ，而不是 == ！

```java
// 普通 情况
String ss = "Hello sb six boy";
String pp = "hhhhhhh";
       
boolean flag = true;

//  就是 直接调用字符串 ss.equals(另外要比较的字符串)
if(!ss.equals(pp))
    flag =  false;

String[] str = new String[]{"2","1","+","3","*"};
for(String s : str)
   if(s.equals("+"))
       System.out.println(s);
```



### 如何判断 数字字符 

```java
 		
		String str = "123sbasb";
        String numStr="";
		
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch >= '0' && ch <= '9') {
                numStr+=ch;
            }
        }
		
		int num = Integer.parseInt(numStr);

		
```

### 如何判断 小写字母

```java
 		
		String str = "123sbasb";
        String res ="";

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                res+=ch;
            }
        }
```



### 如何判断 大写字母

```java
 		
		String str = "123ZaBb";
        String res ="";

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                res+=ch;
            }
        }
```







## 字符串 StringBuilder 

**String类** 该有的方法 ，它也是 **早就拥有**的了

就是  **多了一些特性 ** 罢了。

### String字符串 转为 StringBuilder

```java
String shujin="adasd";
//  一般 普通的String 字符串 都要先变成 StringBuilder 类的话，就要 先 new StringBuilder(shujin)，
//													把自己直接 传进去 就行 
StringBuffer a =new StringBuilder(shujin);
```

### StringBuilder 转为 String字符串

```java


StringBuffer a =new StringBuilder();
a.append("abc");
a.append("def");
					
					// new String(a),   对象声明式   转换 
	String key = 	new String(a);
```

### 尾部 增加 字符串

```java
  	// 因为String 类 字符串 不可变长，不能原地修改 。。。所以要用 StringBuilder 字符串 
	//所以遇到题目中出现填充字符串的时候，一般 都是用这个 StringBuilder 字符串 类，因为它 的 内置方法 比较丰富！！。。。。
        //  而且 它 是 可变长!!! 字符串 类型

		String s = "zwj123";
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            
            if (Character.isDigit(s.charAt(i))) {
                // append("")方法 ，直接传入一个 字符串 就行
                // "原地" 增加 
                sb.append("number");
            }else sb.append(s.charAt(i));
        
        }
        System.out.println(sb); // 输出 ： zwjnumbernumbernumber
```

### 删除 某一个 指定字符

```java
String shujin="adasd";
//  一般 普通的String 字符串 都要先变成 StringBuilder 类的话，就要 先 new StringBuilder(shujin)，
//													把自己先 传进去 
StringBuilder a =new StringBuilder(shujin);
      
        for (int i = 0; i < a.length(); i++) { 
			// deleteCharAt(i)方法，传入 下标值  ，就能删除该下标对应的字符
            
            // “原地” 删除 
                    a.deleteCharAt(i);
              }

  }
```

### 反转 字符串

```java

String str = "Hello";
			//  可以直接 这样传入 一个 String 类型的到 new StringBuilder(str)
StringBuilder sb = new StringBuilder(str);

			// 使用 StringBuilder 的 reverse()反转字符串，最后记得再 转为String 类型!!
			//  是返回一个新的 反转后的 新 字符串  
StringBuilder res = sb.reverse();
String reversedStr = new String(res); 

System.out.println(reversedStr); // 输出结果: olleH
```

## list集合的方法

相比于之前的 数组 类型。集合**最大的特点**就是**不定长**

常见特点 ，**有序，可重复**的

### 添加元素

```java

 List<Integer> list = new ArrayList<>();

 
            //  add(i)方法，传入具体值 ，元素值  可以重复 
          
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);  // [1,2,2,4]
           
        
```
### 增强for循环 遍历 list集合

```java

// 毕竟是 存储的是 引用数据类型，推荐用 增强 for循环 遍历
List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);


        
		// 通过 增强for循环 依次 遍历 元素 
        for(Integer a :list){

           System.out.println(a);
        }
```

### 根据 下标 获取元素

```java






 List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

    
        	// 主要 通过 get(i) 下标 来获取 元素 
        int a =  list.get(i);
        
```

### list 集合 转为 数组

```java
List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

			
    
		// 保存数据的 数组 
        int[] res = new int[list.size()];

        
            for(int i=0;i<list.size();i++){

                res[i]=list.get(i);
                
                
            }
		
```

### 是否包含某个元素

```java


 List<Integer> list = new ArrayList<>();
            
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);  // [1,2,2,4]
        
		
            
            //  用 contains(i)方法  判断 是否包含 某个元素  
            if(list.contains(4))
                System.out.println(666);
        
```

### 统计元素个数

```java

 List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);  // [1,2,2,4]
           
    

			//  这个 又有点不一样，是 size()方法，返回元素的个数
int n = list.size(); // 长度为 4 
```

### 反转 list 集合

```java
// 注意是 “反转” list 集合！！ 。 而不是 排序 ！！

        
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(10);
        list.add(5);
        list.add(4);

        System.out.println(list);// list 集合的 初始 状态  [1, 10, 5, 4]
//   Collections 的 reverse()方法传入的必须是 list  集合。因为 list 集合 是有序的 ！！set 集合 就不行！
        // 而且是  ”原地“反转 哦！！
        Collections.reverse(list);

        System.out.println(list);// list 集合的顺序肯定是反转了： [4, 5, 10, 1]
```

### 排序 list 集合

```java
List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(10);
        list.add(2);
        list.add(5);
        list.add(4);

        System.out.println(list);  // 此时 list 集合 初始 是   [1,10,2,5,4]

		


		// 方式一 ：
			// 主要 还是配合  这个  Collections的sort()方法，默认 升序 
			// 是 ”原地“ 排序，并不是返回一个 新的 集合 ！！
			Collections.sort(temp); 
			System.out.println(list);  // 此时 list 集合 初始 是  [1, 2, 4, 5, 10]




        // 方式二： collections 的sort( , )方法 中 第一个参数 就是需要传入的 list集合，它的泛型是 <Integer> ,包装类型的 整型
        
        // 第二个参数就是传入一个 lambda表达式 , 实现 函数式接口 。谁 减去 谁 就决定了 最终是 升序 还是 降序。k1-k2 是升序。k2-k1 是 降序 
                                   
            // 如果 泛型 是其他 类型 < >，那么就需要调用 某些方法 然后再减去
			// 而且 也是 “原地”排序 ！！！
        Collections.sort(list,(k1,k2)->k1-k2);
	
        System.out.println(list);  // 此时 list 集合 初始 是  [1, 2, 4, 5, 10]
```

### 找list 集合中的 最大值  和 最小值

```java
	List<Integer> temp = new ArrayList<>();
				temp.add(1);
				temp.add(9);
				temp.add(6);
				temp.add(4);
				
					// 主要 还是配合  这个  Collections的sort()方法，默认 升序 
					// 是 ”原地“ 排序，并不是返回一个 新的 集合 ！！
					Collections.sort(temp);


					// 因为 排序之后的话 最后一个下标 就是 集合中元素的 最大值 了
                   int max = temp.get(temp.size() - 1); 

					// 因为 排序之后的话 下标 0  就是 集合中元素的 最小值 了
					int min = temp.get(0); 

                    System.out.println(max);   // 输出 max 的值 是  9  
					  System.out.println(min); //  min的值 1
```

## set集合的方法

相比于之前的 数组 类型。集合**最大的特点**就是 **不定长**

常见特点，**唯一**的， “**去重**”  的

### 添加元素

```java
int [] nums = new int[]{1,2,2,3,5,3};
 Set<Integer> set1 = new HashSet<>();
        
        //增强for循环  遍历 int 数组
        for (int i : nums1) {
            
            //  add(i)方法，传入具体值 ，但是会 去重 哦！
            set1.add(i);
        }
//  因为 set集合 中 的元素 不重复，所以最终 set集合 里面 元素 只有 1，2，3，5
```

### 增强for循环 依次遍历  set集合

```java
Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

		

		// 通过 增强for循环 依次 遍历 元素 
        for(Integer a :set){

          System.out.println(a);
            
        }
```

### 是否包含某个元素

```java

 Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);

       
            
            //  用 contains(i)方法  判断 是否包含 某个元素  
            if(set1.contains(2))
                System.out.println(666);
        
```

### 统计元素个数

```java

 Set<Integer> set1 = new HashSet<>();
        
        set1.add(1);
        set1.add(2);
        set1.add(2);
        set1.add(3);
        set1.add(5);
//  因为 set集合 中 的元素 不重复，所以最终 set集合 里面 元素 只有 1，2，3，5

			//  这个 又有点不一样，size()方法，返回元素的个数
int n = resSet.size(); // 长度为  4 
```

### set集合转为list集合

```java
//   一般用于 集合嵌套 的时候，内部的 集合需要 "去重"，然后就要先用set集合 存储，之和再转为 list 集合

Set<List<Integer>> set = new HashSet<>();
							// new ArrayList<>(set) 括号里传入即可
 List<List<Integer>> list = new ArrayList<>(set);


// 或者是   单纯的  想 “去重”


        Set<Integer> set = new HashSet<>();
			
        // 只能  new ArrayList<>(set) 括号里传入
        List<Integer> list = new ArrayList<>(set);
```

## map集合的方法

相比于之前的 数组 类型。集合 **最大的特点 **就是 **不定长**

常见特点， key唯一，**value可覆盖**，所以经常用到 **累加统计次数** ，用于 统计数组中  某个数 作为 key ，出现的次数 value



### 插入key

```java
HashMap<Character,Integer> map = new HashMap<>();

//  put(key,value)方法 不仅可以插入一个新的key
map.put('a',6);
// 这里的话 仍然是 a字符 作为key，所以可以 对原有 key 的值 进行   “覆盖”
map.put('a',7);


map.put('b',9);
map.put('c',12);
```

### 移除key

```java
HashMap<Character,Integer> map = new HashMap<>();
map.put('a',6);
map.put('a',7);
map.put('b',9);
map.put('c',12);

	//  remove(key)方法，传入 key值 ，也就是具体元素的值
  map.remove('a');
```

### 是否包含某个key

```java
HashMap<Character,Integer> map = new HashMap<>();
map.put('a',6);
map.put('a',7);
map.put('b',9);
map.put('c',12);


				// containsKey(key)方法，传入 key值 ，也就是具体元素的值
boolean flag = map.containsKey('a') // 返回 true
```

### 返回某个key的值

```java
HashMap<Character,Integer> map = new HashMap<>();
map.put('a',6);
map.put('a',7);
map.put('b',9);
map.put('c',12);
   
 		
   //  get(key)， 这里是  get方法 
   //   因为 字符 a 有多个，作为key的时候，只会插入一个 key。所以后面的value 值 会不断被覆盖	
	// 所以 这里 是输出  7。   a字符 这个 value值 是  7
			System.out.println(map.get('a'));
```

### 返回某个key的值带默认值

```java

        Map<Character, Integer> charCount = new HashMap<>();
						
		String magazine = "asdbasdasdddeeevg";	
 
    for (char ch : magazine.toCharArray()) {
        
     //  getOrDefault(key, )方法，第一个参数是查询的 元素，第二个参数是 查询失败返回的 值
        
        //   这个 值 其实 就是 换种说法， 比如是 某个 字符 的 "出现次数"
        // 如果 某个字符 已经存在 map字典中，那么就返回它出现的次数，不存在的话 就返回0 
        //  又因为  是要  累加 某个字符 出现的 次数，所以 在设置 value的时候 要这么操作
        
        charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
    }
```

### 依次遍历  map集合中的 key

```java
 HashMap<Character,Integer> map = new HashMap<>();
        map.put('a',6);
        map.put('a',7);
        map.put('b',9);
        map.put('c',12);
							// keySet() ，返回的是一个 Set接口 
							// 用的是 增强for循环遍历 
        for (Character a : map.keySet()){
            System.out.println(a);
        }
```

### 依次遍历  map集合中的 value

```java
 HashMap<Character,Integer> map = new HashMap<>();
        map.put('a',6);
        map.put('a',7);
        map.put('b',9);
        map.put('c',12);
							// keySet() ，返回的是一个 Set接口 
							// 用的是 增强for循环遍历 
        for (Integer a : map.values()){
            System.out.println(a);
        }
```

### 直接返回 整个map 所有 key值

```java
Map<Character, Integer> map = new HashMap<>();
String s = "asdbasdasdddeeevg";	
 
for (char key : s.toCharArray()) {
 		map.put(key,1);
    				
}
				// keySet()空参方法 获取 map的所有 key  值。  返回的 是一个 Set 子接口
					// 两者也可以转换的。 但要用到  ”强转“。 List集合 也是子接口。 
					
List<Character> values = (List<Character>) map.values();
```

### 直接返回 整个map 所有 value值

```java
Map<Character, Integer> map = new HashMap<>();
String s = "asdbasdasdddeeevg";	
 
for (char key : s.toCharArray()) {
 		map.put(key,1);
    				
}
				// values()空参方法 获取 map的所有value值。  返回的 是一个 Collections 父接口
					// 可以向下转型，因为 List集合 是子接口。  所以要用到  ”强转“
					// 成功获取到了 List 集合！！！
List<Integer> values = (List<Integer>) map.values();
```

### 根据 map集合的 value 值 排序 连同key移动

```java
// key 是 元素值，value 是出现的次数  
Map<Integer,Integer> maps=new HashMap<>();
            maps.put(3,1);
            maps.put(2,2);
            maps.put(4,3);
            maps.put(1,5);
            maps.put(5,6);
		

		// 第 1 步 ：都是 先通过 map 集合的 entrySet()  方法 去实现。返回一个 set 集合 ，里面装有 很多个 map.entry对象。
		
        //  Map.Entry 是 Map接口定义的 内部接口。比较好用。。。。。
		// 其实就是 把 map 中的 很多对 kv 分别打包成 一个个 Map.entry 对象。而每个 map.entry 对象 只存储 一对 kv。。然后把 每个 map.entry对象 作为 一个元素 存储 在set集合
	
        Set<Map.Entry<Integer, Integer>> set = maps.entrySet();


	// 因为 后面的 collections的sort( ，) 方法传入的 只能是一个 list集合 ，而不是set ！！
			// 因为 list集合有序，所以 排序是 有意义的。而set集合 是无序，排序也没有任何意义
	// 所以 这里先直接 把 set集合 转为 list 集合。很简单，但是注意声明的List的< >泛型书写！！
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(set);
			

 //  其实 也可以简写成：
	// List<Map.Entry<Integer, Integer>> list = new ArrayList<>(maps.entrySet());



        System.out.println(list);  // 此时 list 内部是长这样的：[1=5, 2=2, 3=1, 4=3, 5=6]
			
       // 第 2 步 ：collections 的sort( , )方法 中 第一个参数 就是需要传入的 list集合，而第二个参数就是传入一个lambda表达式，实现函数式接口。谁 减去 谁 就决定了 最终是 升序 还是 降序 
        Collections.sort(list,(k1,k2)->k1.getValue()-k2.getValue());

		// 本质上就是对 map.entry的 value值进行排序，对应的key 位置 也一起移动了
        System.out.println(list); // 此时 对list 排序好之后变为 [3=1, 2=2, 4=3, 1=5, 5=6]
```



### 为数组中的元素映射 累加次数

```java
		
		int[] nums = new int[]{1,2,3,1,3,5,0,2};
	
		// 给数组中的 每个数字 ，记录它们出现的次数 
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            
           // 1. getOrDefault(nums[i],0) 方法很关键！！如果第一次查询到这个元素的时候，不存在 map集合中，那么这个方法返回的是 0 
          //  如果之后又遇到 它这个元素 的话，那么就是直接返回之前它的 value值
            
            // 2.不管是哪种情况，都要在 getOrDefault(nums[i],0)的后面 +1 ，因为要累加次数 
   // 记得要把它们放在 put()方法 其实就是通过覆盖 原来的key，通过累加+1，达到  更新次数 的效果
  		map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            		
        }
```



## Stack 栈的方法

“**先进后出**”的

### 遍历 栈 必须要用 while循环 配合 出栈

```java
//  创建一个堆，其实  	PriorityQueue 优先级队列就是一个 堆。
        //  其实要传入一个Comparator比较器 接口
        // 但是这里 用到了 lambda表达式,前面减去 后面的话，就代表升序 。
        Stack<Integer>  stack = new Stack<>();
        stack.offer(9);
        stack.offer(1);
        stack.offer(4);
        stack.offer(7);

       
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
```



### 栈顶 进栈

```java
//  Stack 栈 ,其实本质上就是 集合里面的一种数据结构罢了 ，他就是一个 class 类 
			// 声明也很像List

        Stack<Integer> stack = new Stack<>();

		// push(i)方法,栈的常用方法里面，只有它需要传参数 ，即 插入值 
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack); // [1, 2, 3]
```

### 栈顶 出栈

```java
Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack); // [1, 2, 3]

        // pop()方法，不仅 会弹出这个 栈顶元素，还会返回 弹出的值
        int a = stack.pop();
        System.out.println(a);  // 3

        System.out.println(stack);  // [1, 2]

```

### 查看栈顶元素

```java

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack); // [1, 2, 3] 

		// peek()方法，只返回 栈顶的 值，并不会弹出
        int a = stack.peek();
		System.out.println(a);  // 2
									// 因为只返回 栈顶的 值 ，所以 元素还是原来的
        System.out.println(stack);  // [1, 2,3]
```

### 判断栈为 空

```java

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack);   // [1, 2, 3] 

			// isEmpty()方法
			// 如果栈 非空，那么就输出 整个栈 的元素  
		if(!stack.isEmpty()){
            System.out.println(stack);
        }
```

### 统计 栈 的长度

```java

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack); // [1, 2, 3] 

			// 和集合一样，也是 size()方法 
		int size = stack.size(); // 长度为 3 
```

## Deque 双端队列的方法

它是 “**先进先出**” 的。 一般的话如果要用队列，那么就是会首先用这个 “ **<u>双端</u>** 队列”。因为它 的 某一端       既可以 **<u>入队</u>** 也可以 **<u>出队</u>**。 

目前**只**有   **队列**  ！！！！   **不能存入 null值 ** 元素 

### 遍历 队列 必须要用 while循环 配合 出队



```java
//  创建一个堆，其实  	PriorityQueue 优先级队列就是一个 堆。
        //  其实要传入一个Comparator比较器 接口
        // 但是这里 用到了 lambda表达式,前面减去 后面的话，就代表升序 。
        Deque<Integer>  q = new ArrayDeque<>();
        q.offer(9);
        q.offer(1);
        q.offer(4);
        q.offer(7);

        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
```



### 队尾 进队

```java
//  队列 ，这里一般 用 “双端” 队列 Deque 接口，并且 用它的 实现类 ArrayDeque ，功能更多 ！！
	

	// 举个例子，比如 原始的 队列 quene 接口的 peekFirst() 方法只能看 队头 的元素。而现在的 deque接口的 peekLast() 方法 ，还可以 查看 队尾 ！！的 元素 		
   // 而且还能在 队尾 ！！出队 元素  


	 Deque<Integer> deque = new ArrayDeque<>();
	
		// offerLast(i)方法，后面记得加上Last
	 deque.offerLast(1);
	 deque.offerLast(2);
	 deque.offerLast(3); // [1,2,3]
```

### 队头 出队

```java
	Deque<Integer> deque = new ArrayDeque<>();

	 deque.offerLast(1);
	 deque.offerLast(2);
	 deque.offerLast(3);  // [1,2,3]

		// pollFirst()方法， 方法名 后面记得加上 First 
		//  不仅仅是 弹出元素 ，而且还会返回，弹出的元素值
	 int num = deque.pollFirst(); // 1
	
      System.out.println(deque);  // [2, 3]
```

### 查看 队头 元素

```java
Deque<Integer> deque = new ArrayDeque<>();

	 deque.offerLast(1);
	 deque.offerLast(2);
	 deque.offerLast(3);  // [1,2,3]
	 // peekFirst()  仅仅 只是 返回 队头 的 值，并不会弹出
	 int num = deque.peekFirst(); // 1
```



### 队头 进队 （特殊）

```java


	 Deque<Integer> deque = new ArrayDeque<>();

	// offerFirst(i)方法，后面 记得加上 First 
	 deque.offerFirst(1);
	 deque.offerFirst(2);
	 deque.offerFirst(3);  // [3,2,1]
```



### 队尾 出队（特殊）

```java
Deque<Integer> deque = new ArrayDeque<>();

	 deque.offerLast(1);
	 deque.offerLast(2);
	 deque.offerLast(3);  // [1,2,3]

		// pollLast()方法，后面记得加上 Last
	 int num = deque.pollLast(); // 3

   System.out.println(deque);  // [1, 2]
```



### 查看 队尾 元素（特殊）

```java
Deque<Integer> deque = new ArrayDeque<>();

	 deque.offerLast(1);
	 deque.offerLast(2);
	 deque.offerLast(3);  // [1,2,3]
 // peekLast()  
	 int num = deque.peekLast(); // 3
```

### 判断队列为 空

```java
Deque<Integer> deque = new ArrayDeque<>();
	
		// offerLast(1)方法，后面记得加上Last
	 deque.offerLast(1);
	 deque.offerLast(2);
	 deque.offerLast(3); // [1,2,3]


			// 仍然是 isEmpty() 方法
	if(!deque.isEmpty()){
            System.out.println(quene);
        }
```

### 统计 队列  的长度

```java
Deque<Integer> deque = new ArrayDeque<>();
	
	 deque.offerLast(1);
	 deque.offerLast(2);
	 deque.offerLast(3); // [1,2,3]


			// 和集合一样，也是 size()方法 
		int size = deque.size();  //  长度为 3 
```

## PriorityQueue 优先级队列

满足 ”**先进先出**“ 。

目前**只**有 **队列**！！**不能存入 null**值元素



**原来队列 ** 该有的**方法**，， **他也是都有**的。

就是多了一些**特性**，它会将添加的元素，根据初始传入的的**Comparator比较器**，直接自动**内部会  排序。**（升序 or 降序）。它其实就是 大根堆或者 小根堆。 

### while 循环 按某种排序 输出 元素

```java
//  创建一个堆，其实  	PriorityQueue 优先级队列就是一个 堆。
        //  其实要传入一个Comparator比较器 接口
        // 但是这里 用到了 lambda表达式,前面减去 后面的话，就代表升序 。
        PriorityQueue<Integer>  q = new PriorityQueue<>((a,b)->a-b);
        q.offer(9);
        q.offer(1);
        q.offer(4);
        q.offer(7);

       
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
```



## 数学Math类的方法

### 求两个数的最大值

```java
int a = 1, b =3;
			// max(a,b) 方法，要传入 想要比较的 2个 int 数值
			//  其实 就是  省的你去写一些 三目运算符，以及 if判断语句了 
int c = Math.max(a,b);
```

### 求两个数的最小值

```java
int a = 1, b =3;
// min(a,b) 方法，要传入 想要比较的 2个 int 数值
int c = Math.min(a,b);
```















# 代码随想录+ Hot100

## 数组

### 704 二分查找

#### 二分查找

题目描述：

```
给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。


示例 1:

输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
示例 2:

输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1
```

题解 ：https://leetcode.cn/problems/binary-search/solutions/6700/hua-jie-suan-fa-704-er-fen-cha-zhao-by-guanpengchn/

```java

// "二分查找"的前提是 ----> 有序 

class Solution {
    public int search(int[] nums, int target) {
         
        int left = 0 , right = nums.length-1;
        	 
        //因为是 “左闭右闭” 原则 , 所以是  带等号的 <=
        while(left <= right){
           
            
             int mid = (left + right)/2;
            //说明找到了，直接 return 
            if(nums[mid]==target)
                return mid;
            
            
            if(target<nums[mid])
     //  当这个target 元素小于mid的元素，说明target在左半边，right 下标要更新成  mid-1 了
                right = mid - 1;
            
            else 
     // 当这个target 元素大于 mid的元素，说明target在右半边， left 下标 要更新成 mid +1 了
                left = mid + 1;
            
            	

        }
        
        // 执行完 while 循环，也没找到，直接 return -1 。
        return -1;

    }
}
```

### 35 搜索插入位置

#### 二分查找

题目描述：

```
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

请必须使用时间复杂度为 O(log n) 的算法。

 

示例 1:

输入: nums = [1,3,5,6], target = 5
输出: 2
示例 2:

输入: nums = [1,3,5,6], target = 2
输出: 1
```

题解：https://leetcode.cn/problems/search-insert-position/solutions/8017/hua-jie-suan-fa-35-sou-suo-cha-ru-wei-zhi-by-guanp/?envType=study-plan-v2&envId=top-100-liked

```java
// "二分查找"的前提是 ----> 有序 
// 这道题 建立在“二分查找”的基础上的 

class Solution {
    public int searchInsert(int[] nums, int target) {
         
        int left = 0 , right = nums.length-1;
        	 
        //因为是 “左闭右闭” 原则 , 所以是  带等号的 <=
        
        while(left <= right){
           
            
             int mid = (left + right)/2 ;
           if(nums[mid]==target)
                return mid;
            
            
            if(target<nums[mid])
     //  当这个target 元素小于mid的元素，说明target在左半边，right 下标要更新成  mid-1 了
                right = mid - 1;
            
            else 
     // 当这个target 元素大于 mid的元素，说明target在右半边， left 下标 要更新成 mid +1 了
                left = mid + 1;

        }	 	
         				// 主要是这行代码，很重要 ！！！
        		return left;
        
 	 /*** 
        可以返回 right + 1，也可以返回 left 的原因： 
        因为循环的最后一步一定是left==right，如果导致这个循环打破只有两个原因，要么是right = mid - 1导致left>right，说明我们要插入的元素位置应该是小于mid元素。这种情况也就导致了right的最终下标相对我们要插入的元素位置是左移的，所以最后的位置应该是right + 1； 
        要么是left=mid +1，导致的 left >right，说明我们要插入的元素位置应该是大于mid元素的。这就说明left的最终位置是相对插入元素右移了一位，因为本身插入的元素就应该右移，所以只需要返回left即可
           
           ***/

    }
}
```



### 34 在排序数组中查找元素的第一个和最后一个位置

#### 二分查找

题目描述：

```
给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。

你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。

 

示例 1：

输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
示例 2：

输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
```

题解：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/solutions/536360/yi-wen-dai-ni-gao-ding-er-fen-cha-zhao-j-ymwl/?envType=study-plan-v2&envId=top-100-liked

往下滑，有对应的

```java

// 主要思想 ：  相比于之前的 二分查找(真正的递增有序)，本题目是 非递减，其实也就是类似 递增“有序”，也就是里面的一些  元素会重复！！如果此时我们的 nums[mid] = target ,但是我们不能确定 mid 是否为该目标数的左边界，所以此时我们不可以返回下标。所以就是要把判断  == 和 < 一起合并，继续在左半区间 查询。 == 和 > 的也类似 。。。。

// 定义两个方法，也就是进行 两次 “二分查找”，，，分别找 下边界 和上边界 。。。。

class Solution {

    public int[] searchRange (int[] nums, int target) {
				
         int low = lowerBound(nums,target);  	// 找 下边界 的方法 
         int upper = upperBound(nums,target);   // 找 上边界 的方法 
         

      //  也就是如果  upper 小于 low 的话，就说明没找到 target元素。。此时就要返回 [-1,-1]
         if (upper < low) {
             return new int[]{-1,-1};
         }
			
     //  其他情况的话， 如果 ==，那么就只有一个元素， > 就说明 target存在多个，有上下边界
         return new int[]{low,upper};
    }

    
    // 计算下边界
    int lowerBound(int[] nums, int target) {
        
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            
            int mid = (left + right)/2;
           	
            
            if (target <= nums[mid]) 
                
                   // 小于的时候，此时要 带上 = 
                //当目标值 小于等于 nums[mid]时，继续在左区间查询
                right = mid - 1;

            else if (target > nums[mid]) 
                
                left = mid + 1;
            
        }
        
       //此时跳出while 循环的时候，left 指向的下标刚好是我们的下边界，所以return left 
        return left;
        
    }
    
    
    //  计算上边界， 和上面的求 上边界， 里面的代码 就是相反的改动 
    int upperBound(int[] nums, int target) {
        
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {    
            
            int mid = (left + right)/2;
            
            		      //  大于的时候，此时要 带上 = 
            		//当target目标值 大于等于 nums[mid]时，继续在右区间查询
            if (target >= nums[mid]) 
                 left = mid + 1;               
            else if (target < nums[mid]) 
                right = mid - 1;
                     
        }
    
   //此时跳出while 循环的时候，right 指向的下标刚好是我们的上边界，所以return right 
        return right;
    
    }
    
}
```



### 33 搜索旋转排序数组

#### 二分查找

题目描述 ：

```
整数数组 nums 按升序排列，数组中的值互不相同 。

在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标从0开始  计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

给你旋转后的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。

示例 1：

输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
示例 2：

输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1
```

题解：https://leetcode.cn/problems/search-in-rotated-sorted-array/solutions/221435/duo-si-lu-wan-quan-gong-lue-bi-xu-miao-dong-by-swe/    思路2更好理解一点

```java

// 这道题 的话，就是有点不一样，因为 数组并不是完全有序的，只是 两边 是有序的。
//主要思想：先根据 nums[mid] 与 nums[lo] 的关系判断 mid 是在左段还是右段，接下来再判断 target 是在 mid 的左边还是右边，从而来调整左右边界 left 和 right 。。
//举个例子 nums = [4,5,6,7,8,9,0,1,2]  ，target =5 ，nums[mid]对应元素 8 大于 nums[left]元素 4 ，所以在左半段。然后 target 是5 小于 8，那么继续缩小范围，去left 和 mid-1的区间查找 


class Solution {
    
    public int search(int[] nums, int target) {
        
    	int left = 0, right = nums.length - 1, mid = 0;
        
    while (left <= right) {
        
        	mid = (left+right)/2;
        if (nums[mid] == target) {
            return mid;
        }

        
        // 先根据 nums[mid] 与nums[left]的关系判断 mid 是在 左段还是右段
        	  // 如果  mid 对应的元素值 大于  left 的值，就说明 mid 在左半段 
        if (nums[mid] >= nums[left]) {
            
              // 再判断 target是在 mid的左边还是右边，从而调整左右边界left和right
             //  注意，这里面的 话 target 严格 小于< ，因为要不断调整 left 和 right
            if (target >= nums[left] && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            
        } 
        
        //  说明在右段，思路类似
        else {
            if (target > nums[mid] && target <= nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

			
  			  return -1;
}


}


```



### 153 寻找旋转排序数组中的最小值

#### 二分查找

题目描述：

```
已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]

注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 

给你一个元素值互不相同的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的最小元素 。

示例 1：

输入：nums = [3,4,5,1,2]
输出：1
解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
```

题解：https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/solutions/134812/yi-wen-jie-jue-4-dao-sou-suo-xuan-zhuan-pai-xu-s-3/?envType=study-plan-v2&envId=top-100-liked

```java
// 这道题 也是 非完全有序的 ，也是左半段，右半段才有序 。
// 这道题是 搜索最小值min，并不是 搜索目标值 target，不需要 if(nums[mid]==target)语句....

class Solution {
    
    
    public int findMin(int[] nums) {
        
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            
           
          // 1.一直缩小 左、右区间。直到 left,right 的左右区间里面的数组 是 完全有序 的时候，那么nums[left]的值就是最小值 ！！
            if (nums[left] <= nums[right]) {
                return nums[left];
            }
            
            
           int mid = (left + right)/2;
            
           // 2.这里就是开始 缩小  左、右边界的 判断了。。。。
         
            
          //  2.1若 nums[left] <= nums[mid]，说明区间 [left,mid] 连续递增，则最小元素一定不在这个区间里，可以直接排除。因此，令 left = mid+1，在 [mid+1,right] 继续查找
            if (nums[left] <= nums[mid]) 
                left = mid + 1;
            
            
         // 2.2否则，说明区间 [left,mid] 不连续，则最小元素一定在这个区间里。因此，令 right = mid，在 [left,mid] 继续查找!!这里的话 right 必须赋值 mid，而不是mid-1。。因为 mid无法被排除!比如 说 mid指向的值可能就是 右边的最小值呢？所以 right 必须改成 mid ！！！
            else 
                right = mid;

        }
   
// 这个返回值实际上永远不会被触发，因为输入数组总是有一个最小值，所以只是为了 让  编译器通过而已。。        
        return -1; 
        
    }
}
```



### 4 寻找两个正序数组的中位数

#### 暴力

题目描述：

```
给定两个大小分别为m和n的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数 。

算法的时间复杂度应该为 O(log (m+n)) 。

示例 1：

输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2

示例 2：

输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
```

题解：https://leetcode.cn/problems/median-of-two-sorted-arrays/solutions/259086/er-fen-fa-duo-yu-yan-javajs4-xun-zhao-liang-ge-zhe/?envType=study-plan-v2&envId=top-100-liked  直接看 暴力解法

```java
 // 1.先把 nums1 和 nums2 这两个数组 合并成 一个有序的数组 
// 2.然后再计算 中位数，就比较方便了 。。。。 
// 时间复杂度 是O(m+n)

class Solution {
    
      public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
      //1. 先合并 
        int m = nums1.length; // 第一个数组的长度
        int n = nums2.length; // 第二个数组的长度
        
        int[] newArr = new int[m + n]; // 创建第三个的数组，来存储合并后的有序数组
        
        int i = 0; // 第一个数组的 索引
        int j = 0; // 第二个数组的 索引
        int idx = 0; // 第三个的数组的 索引

   // 合并两个 nums1 和nums2 数组 ，这里的while循环条件是 i和j 遍历索引都小于自身长度，才循环
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                newArr[idx++] = nums1[i++]; // 将较小的数放入结果数组，并移动索引
            } else {
                newArr[idx++] = nums2[j++]; // 将较大的数放入结果数组，并移动索引
            }
        }
        	
        // 这里的话就说明跳出了第1个 while 循环，也就是 i或者j 遍历完了 自身数组
		
        // 如果第一个数组还有剩余元素，将它们添加到结果数组
        while (i < m) {
            newArr[idx++] = nums1[i++];
        }

        // 如果第二个数组还有剩余元素，将它们添加到结果数组
        while (j < n) {
            newArr[idx++] = nums2[j++];
        }
          
          
          //  2. 然后再 计算 中位数 。。
          
        int length = newArr.length; 

        // 如果 新数组的长度 是偶数，那么计算偶数长度数组的中位数，其实是 中间两个数的平均值
        if (length % 2 == 0) {
            return (double) (newArr[length/2] + newArr[length/2 -1])/2;
        }        
          
           // 如果新数组的长度是奇数， 返回中间的数作为中位数
      	else {
                return (double) newArr[length/2];
        }
    }

}
```



### 26 删除排序数组中的重复项

#### 双指针快慢指针

题目描述：

```
给你一个 非严格递增排列 的数组 nums ，请你原地删除重复出现的元素，使每个元素只出现一次 ，返回删除后数组的新长度。元素的相对顺序应该保持一致 。然后返回 nums 中唯一元素的个数。


示例 1：

输入：nums = [1,1,2]
输出：2, nums = [1,2,_]
解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。

```

题解 ：https://leetcode.cn/problems/remove-duplicates-from-sorted-array/solutions/34033/shuang-zhi-zhen-shan-chu-zhong-fu-xiang-dai-you-hu/

```java
// 注意 ！！！这道题的要求是“原地” 修改，也就是在原来的 nums 数组里面进行修改，不需要声明一个新的 数组！！！
// 数组是“有序” 的，那么重复的元素一定会 相邻--->这个是 前提条件。所以比较适合用 双指针，"快慢指针"
 
class Solution {
    
    public int removeDuplicates(int[] nums) {
			
        	// 快慢指针，都从 下标 0 开始 
            int slow=0;
            int fast=0;
        
            int size= nums.length;
           
           
            while(fast<size){
                
		//	比较 慢指针slow 和 快指针fast 位置的元素是否相等。。如果相等，快指针fast后移 1 位
                if(nums[fast]==nums[slow])
                    	fast++;
                
        // 如果不相等，将 fast 位置的元素复制到 slow+1 位置上，fast 后移一位，slow 后移 1 位
                else{  
                    
                    nums[slow+1]=nums[fast];
                    slow++;
                    fast++;
                    
                }
                	
            }
        
       				// 因为数组的长度是 末尾下标+1 。。。
            return slow+1;
        
    }
}
```

### 209 长度最小的子数组

#### 滑动窗口

题目描述：

```
给定一个含有 n 个正整数的数组和一个正整数 target 。

找出该数组中满足其总和大于等于 target 的长度最小的子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。

 

示例 1：

输入：target = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。
```

题解 ：

https://leetcode.cn/problems/minimum-size-subarray-sum/solutions/1706223/by-carlsun-2-iiee/

```java
// 就是使用 “滑动窗口”的思想去做 这道题
// 定义两个while循环，外层循环的，right 右边界一直向右移动
//  当满足题目条件的时候， sum>= target，就执行while内层循环，left左边界 一直向右收缩，窗口缩小，在里面不断比较 result ，记录 最小的长度

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
  // 因为要对 最终结果result 不断比较 和 更新，求数组长度的最小值。所以初始值一般是 Integer.MAX_VALUE 
            int result = Integer.MAX_VALUE;
        
        
        // 子数组的数值之和
            int sum =0;
        
        
        	 // 滑动窗口的右指针 right
        	int right=0;
            // 滑动窗口的左指针 left 
            int left=0;
              
        		// 右指针 right 没有到数组末尾，就一直 while 循环下去
           while(right<nums.length){
               
		 // 先向右扩展窗口，所以只需要移动right指针，每次移动都要累加，当前所指元素的值 
                sum+=nums[right];
               
              // 当满足 题目条件 的时候，就要开始对 左指针 left 向右移动，开始缩小窗口 
                while(sum>=target){
  						    
   //这道题是 求最“短”。当满足条件，就要在 内层while循环 更新结果 result 的操作 
                    //  求子数组的长度，记得 +1
          		 result = Math.min(result,right-left+1);
                           
         //这里体现出“滑动窗口”的精髓之处，左指针 left 不断向右移动，开始缩小窗口，也就是要把之前添加过的求和元素，把它移除！！！
                 sum-=nums[left];
				 left++;
                }
		
        // 切记要对 右指针right++ ，因为 右边指针的话只会不断的向右移动
                right++;

            }
        
			  // 如果result没有被赋值的话，就返回0，说明 没有符合条件 的子数组 
            return result==Integer.MAX_VALUE?0:result;
            
    }
}
```



### 59 螺旋矩阵II

#### 暴力

题目描述：

```
给你一个正整数 n ，生成一个包含 1到n2 所有元素，且元素 按顺时针 顺序螺旋排列的 n x n 正方形矩阵 matrix 。
```

<img src="https://piggo-zwj.oss-cn-shanghai.aliyuncs.com/leetcode_pig/image-20241005165415162.png" alt="image-20241005165415162" style="zoom:33%;" />

题解：https://leetcode.cn/problems/spiral-matrix-ii/solutions/12594/spiral-matrix-ii-mo-ni-fa-she-ding-bian-jie-qing-x/

```java
/** 填充上行从左到右→
    填充右列从上到下↓
    填充下行从右到左←
    填充左列从下到上↑
    由外向内一圈一圈这么画下去。
 
**/
// 先定义 当前 左右 、上下边界 
// while最外层的循环 必须是 小于<= 终止值 target  ...

class Solution {
public int[][] generateMatrix(int n) {
	
       int[][] res = new int[n][n];
  			 //  先定义 当前 左右 、上下边界
        int left = 0, right = n-1, top = 0, bottom = n-1;
    			
          // num 用来给 matrix矩阵的每一个空格 赋值，迭代终止值 target，也就是 n的平方
        int num = 1, target = n * n;
    
    
       // 使用num <= tar，而不是l < r || t < b作为迭代条件。。。
    // 主要是为了解决当 n为奇数时，是为了解决当 n为奇数时，矩阵中心数字 无法在迭代过程中 被填充
    
        while(num <= target){
            
            //从左到右填充，相当于缩小上边界 top
            for(int j = left; j <= right; j++) 
            {
                res[top][j] = num++;
            }
            //top 缩小上边界
            top++;
            
            //从上向下填充，相当于缩小右边界 right
            for(int i = top; i <=bottom; i++) 
            {
                res[i][right] = num++;
            }
            //缩小右边界 right
            right--;
            
            //从右向左填充，相当于缩小下边界 bottom 
            for(int j = right; j >= left; j--) 
            {
                res[bottom][j] = num++;
            }
            //缩小下边界 bottom
            bottom--;
            
            //从下向上填充，相当于缩小左边界 left 
            for(int i = bottom; i >= top; i--) 
            {
                res[i][left] = num++;
            }
            //缩小左边界 left
            left++;
            
        }
    
                    return res;
}
    
}
```

### 54 螺旋矩阵

#### 暴力

题目描述：

```
给你一个 m 行 n 列的矩阵 matrix ，请按照顺时针螺旋顺序 ，返回矩阵中的所有元素。
```

<img src="https://piggo-zwj.oss-cn-shanghai.aliyuncs.com/leetcode_pig/image-20241005165138929.png" alt="image-20241005165138929" style="zoom:33%;" />

题解：https://leetcode.cn/problems/spiral-matrix/solutions/658573/dong-hua-mo-ni-yi-xia-jiu-neng-gao-dong-i27qf/

```java
//通过左右边界，上下边界，一步步循环，从左到右遍历 →，从上到下遍历 ↓，从右到左遍历 ←，从下到上遍历↑
// 然后 每次都要判断一下 左右边界、上下边界 是否 == ，这时候就要跳出while循环了。。

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        // 创建一个空列表来存储螺旋遍历的结果
        List<Integer> arr = new ArrayList<>();
        
        // 初始化边界指针
        int left = 0, right = matrix[0].length - 1; // 左右边界
        int top = 0, down = matrix.length - 1;      // 上下边界
        
        // 开始螺旋遍历
   //这里的话就是先用一个 死循环 while(true)，然后配合 一些if条件 进行 break 跳出死循环，就行。
        while (true) {
            
            
            // 从左到右遍历并将元素添加到结果列表
            for (int i = left; i <= right; i++) {
                arr.add(matrix[top][i]);
            }
            top++; // 上边界 top 向下移动一行
            if (top > down) break;    // 如果 上下边界 相遇，则退出循环 break
            				
            
            // 从上到下遍历并将元素添加到结果列表
            for (int i = top; i <= down; i++) {
                arr.add(matrix[i][right]);
            }
            right--; // 右边界right 向左移动一列
            if (left > right) break; // 如果左右边界相遇，则退出循环 break
            
            	// 从上到下遍历的话	和下面的从下到上 一样，if 条件都是 left > right 
            
            // 从右到左遍历并将元素添加到结果列表
            for (int i = right; i >= left; i--) {
                arr.add(matrix[down][i]);
            }
            down--; // 下边界down 向上移动一行
            if (top > down) break; // 如果上下边界相遇，则退出循环 break
            				
            
            
            // 从下到上遍历并将元素添加到结果列表
            for (int i = down; i >= top; i--) {
                arr.add(matrix[i][left]);
            }
            left++; // 左边界向右移动一列
            if (left == right) break; // 如果左右边界相遇，则退出循环
        
        }
        
                    // 返回 螺旋遍历的 结果列表集合arr
                    return arr;
    }
}

```



### 1 两数之和

#### 暴力

题目描述：

```
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。

你可以按任意顺序返回答案。

 

示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
```

题解：

[https://leetcode.cn/problems/two-sum/solutions/1980200/by-william_wsj-ucpl/](https://leetcode.cn/problems/two-sum/solutions/1980200/by-william_wsj-ucpl/)

```java
// 暴力解法，双层 for 循环，一直去寻找。

class Solution {
    
    public int[] twoSum(int[] nums, int target) {

          
            int[] result = new int[2];
        
            // 暴力 解法 双层 for循环 
            for (int i = 0; i < nums.length; i ++) {

           //  为了 不找重复的元素，所以是从i的后一个数字开始查找
                for (int j = i + 1; j < nums.length; j ++) {
                    if (nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
                

            }

  
     // 因为 这道题说明了，肯定是有一个答案的。。。这里其实返回 result 就根本不会执行到这行代码。。主要是为了 leetcode的 编译通过。。。。

              return result;

          }

}
```

### 15 三数之和

#### 双指针相向指针

#### 哈希表set

题目描述：

```
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。

示例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
示例 2：

输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。
示例 3：

输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。
```

题解：[https://leetcode.cn/problems/3sum/solutions/12307/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/](https://leetcode.cn/problems/3sum/solutions/12307/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/)

```java
// 主要思想就是，从头开始 每次固定一个 下标元素 a，然后在 从它的下一个元素 b 以及 末尾下标元素 c 作为 左右双指针->相向指针，不断向中间每次靠拢，去查找 三数之和。。。


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 这里用的是Set集合，可以对最终的答案集合“去重”元素！！！
        Set<List<Integer>> result = new HashSet<>();


        // 要先对数组排序 -->"有序"这个是前提!!!! 这样才能方便使用双指针（相向指针）。
        Arrays.sort(nums);


        // 在 "双指针"模板的基础上，这里外面还多了个for循环，这个是 特殊的地方！！！
        // 这里只不过是每次都固定住一个数字a = nums[i]，其他的 两个数字 b和c就是作为 双指针
        for (int i = 0; i < nums.length; i++) {
            // 每次固定一个新的nums[i]的时候，必须重新初始化 left和right 指针！！！
            // left是i的下一个元素nums[i + 1]，right当然永远是数组的最后一个元素nums[nums.length - 1]
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i]+nums[left]+nums[right];

                if (sum < 0)
                    left++;
                else if (sum > 0)
                    right--;
                // 如果sum = 0,就说明找到了一组解a,b,c，把他们放在list集合里面
                else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));


                   // 找到一组解之后，肯定是需要同时left和right每次都向中间移动一步。。更新下标
                    left++;
                    right--;
                }
            }
        }


       // 题目中要求返回list集合，所以在new ArrayList的()传入set集合。。set转化为list集合就行
        return new ArrayList<>(result);
    }
}

```

### 18 四数之和

#### 双指针相向指针

#### 哈希表set

题解：[https://leetcode.cn/problems/4sum/solutions/573011/shua-chuan-lc-pai-xu-shuang-zhi-zhen-jie-dqx7/](https://leetcode.cn/problems/4sum/solutions/573011/shua-chuan-lc-pai-xu-shuang-zhi-zhen-jie-dqx7/)

```java
// 在"三数之和"的基础上外层再 多加 for循环就行。。。

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {


        Set<List<Integer>> result = new HashSet<>();


        Arrays.sort(nums);


        // 只不过这里的要多定义一层for循环了，其他思路和三数之和一样
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {


                int left = j + 1;
                int right = nums.length - 1;


                while (right > left) {


                    // 为什么要这么做，因为本题的4个整数相加超出int能表示的最大值
                    // 所以要强转(long)类型！！！
                    long sum = (long) nums[i]+nums[j]+nums[left]+nums[right];
                    if (sum > target)
                        right--;
                    else if (sum < target)
                        left++;
                    else {

              result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    }
                }
            }
        }


        return new ArrayList<>(result);
    }
}
```

### 349 两个数组的交集

#### 哈希表set

题目描述：

```
给定两个数组 nums1 和 nums2 ，返回它们的交集。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。

 

示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
示例 2：

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]
解释：[4,9] 也是可通过的
```

题解：https://leetcode.cn/problems/intersection-of-two-arrays/solutions/469826/zhi-jie-ji-suan-he-pai-xu-yi-ji-er-fen-fa-cha-zhao/

```java
// 求交集，比较适合 用哈希表。。这里选用 set集合，用于对最终的答案 "去重"

class Solution {
   
    public int[] intersection(int[] nums1, int[] nums2) {

    // 这个 哈希表 set1 用来 存储 数组nums1的  "去重"之后 的 剩下元素。。。
        Set<Integer> set1 = new HashSet<>();

        // 这个 哈希表 res 用来 存储 相交元素，而且会对结果 "去重"
        Set<Integer> res = new HashSet<>();

        //遍历数组nums1，把元素 存入 哈希表set1中，会“去重” ！！！
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }


   // 遍历数组 nums2 的过程中，对nums2中的每个元素 判断一下 它是否存在之前 set1 哈希表中，如果 存在，那么 就是 “相交”元素！！！！！就把它添加到  的保存结果的  res 哈希表
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }

   //因为题目最后要求返回的是一个数组[]类型，所以要另外申请一个int []数组，存放 res集合。

        int[] arr = new int[res.size()];
        int j = 0;
        for(Integer i : res){
            arr[j++] = i;
        }

        return arr;
    }
}
```



### 202 快乐数

#### 哈希表set

题目描述：

```
编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」 定义为：

对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果这个过程 结果为 1，那么这个数就是快乐数。
如果 n 是 快乐数 就返回 true ；不是，则返回 false 。

 

示例 1：

输入：n = 19
输出：true
解释：
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
示例 2：

输入：n = 2
输出：false
```

题解：[https://leetcode.cn/problems/happy-number/solutions/376711/202-kuai-le-shu-setzai-ha-xi-fa-zhong-de-ying-yong/](https://leetcode.cn/problems/happy-number/solutions/376711/202-kuai-le-shu-setzai-ha-xi-fa-zhong-de-ying-yong/)

```java
// 要证明是不是 快乐数？？？ 只要 排除 不是的情况，那么剩下的就是 快乐数的情况。。。
// 那么 就是如何判断 不是快乐数？？？ 也就是 这个数字 是会一直循环下去的，也就是说  各位数的平方和后的 数字 后来又出现过。。。那么就会无限循环。。。

// 那么就需要保存每一次 的平方和，然后每次都判断 求出来的平方和 是否之前出现过，存在过。。那么就是和用 哈希表 存储，判断是否存在。。。


class Solution {
    public boolean isHappy(int n) {

     //  声明 一个 哈希表，这里选择的是 set集合 来存储元素，每一次的 各位数平方和
        Set<Integer> set = new HashSet<>();


        //  当然是  n！=1 作为 while循环的终止条件
        while(n!=1){
            
          //  题目中说了会 无限循环，如何判断  这个数字  会  无限循环？？？？？
 //  也就是说  各位数的平方和后的 数字 后来又出现过。。。那么就会无限循环，这里就选择 直接返回 false ，跳出 循环 
            if(set.contains(n))
                return false;
            
            else{
                //  如果 在之前的 set集合中 不存在 ，那么就将它存入 set集合中，并且继续  求 这个数 的 各位数的平方和 
            set.add(n);
            		// 调用下面的方法，用于求 各位数的平方和，然后对 传入的n 这个数 重新赋值 。
            n = getNextNumber(n);
            }
            
            
        }
        
        return true;

    }


        //  所以写了 第2个 方法在下面。   功能是，求 某个整数的   各位的数字的平方和
        public int getNextNumber(int n){

            int sum=0;

                //  一般固定写法  就是 n>0 作为 循环终止条件 
            while(n>0){
                
          //  %10  就是  得到某个整数的 最后那个位置的 数值
                int temp = n%10;
                sum+=temp*temp;
           //  每次都要 截掉 整数的 最后那个数值，返回一个新的 整数，也就是少了 1位
                n = n/10;
            }

            return sum;

    }

}
```

### 49 字母异位词分组

#### 哈希表map

题目描述：

```
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

字母异位词 是由重新排列源单词的所有字母得到的一个新单词。

 

示例 1:

输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

示例 2:

输入: strs = [""]
输出: [[""]]
示例 3:

输入: strs = ["a"]
输出: [["a"]]
```

题解：[https://leetcode.cn/problems/group-anagrams/solutions/845572/yuan-lai-hui-luo-ji-qing-xi-jian-dan-yi-rj6x3/](https://leetcode.cn/problems/group-anagrams/solutions/845572/yuan-lai-hui-luo-ji-qing-xi-jian-dan-yi-rj6x3/)

```java
//  我们可以将 String [] 字符串数组中的，每个字符串 排序，就方便 后面分组了。。。
// 然后，把它们存入 哈希表。。这里采用map 集合， 按照不同的 key 进行添加同一组的 字母异位词

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       
        int len = strs.length;
        String[] tempstrs = new String[len];

 // 也可以 这么设置 map的数据类型。key就是 String 。。。。但是 value 可以设置为 是 List< > ，  保存一组 字符串。。。
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < len; i++){ 
            
            // 因为 是 字符串 String[]数组，所以先对 数组中 的 每一个 字符串String  先转变成 char[] 字符数组。。然后才方便 对 单个字符串的字符 进行排序                
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            
            //  再 把 排序后的 char[]字符数组 --> 转成 字符串String，作为key插入 map集合
            String key = new String(cs);

        //  这行代码很关键！！因为 如果 这个 排序后的字符串key 不存在，那么就第一次 插入key和 value，value先是一个空的 list集合。。。
           // 后期 会一直在这个key中 对应的value， 也就是那个 list< >集合,累计 插入 新元素
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            
    // 如果 "排序"后的字符串 存在 map 集合，，那么是插入 "未排序"原始的字符串 strs哦！！！这个也很关键。。。
    // 上面的”排序“逻辑。。。 只是为了方便 找到哪些 字母异位词
            map.get(key).add(strs[i]);
            
        }
        						
        return new ArrayList<>(map.values());
    }
}
```

### 232 用栈实现队列

#### 栈

题目描述：

```

```

题解 ：[https://leetcode.cn/problems/implement-queue-using-stacks/solutions/1724489/by-carlsun-2-kxer/](https://leetcode.cn/problems/implement-queue-using-stacks/solutions/1724489/by-carlsun-2-kxer/)

```java
class MyQueue {

    //  用2个 栈 实现 队列的 “出” ....主要 就是 pop() 和 peek() 上面 需要 做文章
    // 负责进栈
    Stack<Integer> stackIn;
    // 负责出栈
    Stack<Integer> stackOut;

    /** Initialize your data structure here. */
    public MyQueue() {
        stackIn = new Stack<>(); 
        stackOut = new Stack<>(); 
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackIn.push(x);
    }
    

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        
         // 如果stackOut 不为空 ，那么就意味着之前 已经调用过第一次的pop 了， 已经把之前的 进栈In，里面的元素 全部转移到 out出栈 中了 ，此时就直接 Out出栈调用pop就行
        if(!stackOut.isEmpty()){
            return stackOut.pop();
        }	

      // 如果stackOut为空，那么将stackIn中的元素全部放到stackOut中，这是第一次调用 pop的时候
        else{

            while(!stackIn.isEmpty()){

            stackOut.push(stackIn.pop());
        
        }
            
 // 在上面 因为 while循环已经把 入栈的元素 转移到了 出栈中，所以肯定要pop()出栈弹出 1个元素呀！
         return stackOut.pop();

        }
         
    }

    /** Get the front element. */
    public int peek() {

        //  其实 这里的 实现 逻辑和 pop()差不多的，无非就是下面是 peek()调用而已。
        
        // 这里的话,因为peek()就是 看一下队头元素值，并不是弹出 
        // 所以 可以先调用上面实现好的pop()，然后再把那个弹出的值 记得 插入进去就行 。
        
        
         int num = pop();
            stackOut.push(num);
            return num;
        
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
            // 这里当然是 两个栈 都为空 ！
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
  
}
```

### 225 用队列实现栈

#### 队列

题目描述：

```

```

题解：[https://leetcode.cn/problems/implement-stack-using-queues/](https://leetcode.cn/problems/implement-stack-using-queues/)

```java
// 用 1 个 队列 其实 就可以实现了  ，  “双端” 队列。最主要还是实现这个 pop弹出函数

class MyStack {
    
				// 声明 1 个 “双端” 队列。
        Deque<Integer> queue;

        public MyStack() {

            queue = new ArrayDeque<>();

        }

        public void push(int x) {
					// 容易想到的 
            queue.offerLast(x);
        }
    
    	// 主要就是 弹出 pop() ，要把队列中的，前size-1个 元素，按序出队，然后重新加入到队列中，
           // 然后再调用 pollFirst() 方法就行了 
        public int pop() {
	
            int size = queue.size();
          
			
            while (--size >0)
            {	
                //   一个队列在模拟栈弹出元素的时候只要将  队列头部的元素（除了最后一个元素外） 重新添加到 队列尾部 ，此时再去		弹出元素就是	栈	的顺序 了。
                queue.offerLast(queue.pollFirst());
            }

            return queue.pollFirst();

        }

        public int top() {
				 // 容易想到的 ，那么这里的peek肯定是Last队尾的
            return queue.peekLast();
        }

        public boolean empty() {
            // 容易想到的
            return queue.isEmpty();
        }
    }
```

### 155 最小栈

#### 栈

题目描述：

```

```

题解：https://leetcode.cn/problems/min-stack/solutions/42521/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-38/?envType=study-plan-v2&envId=top-100-liked  解法一

```java

class MinStack {
    
    private Stack<Integer> stack;  // 存储所有元素的栈，  主栈
    private Stack<Integer> minStack;  // 存储当前最小元素的栈， 最小栈

    
    public MinStack() {
        stack = new Stack<>();  // 初始化存储所有元素的栈
        minStack = new Stack<>();  // 初始化存储当前最小元素的栈
    }

    
    public void push(int x) {
        
        // 将元素x压入主栈，这个是正常的入栈，肯定是要无条件push的~~~
        stack.push(x); 
        
        
        // 主要就是 元素x是否要进入 最小栈，还需要 判断比较 一下！！！ 
        
       // 如果最小栈 不为空的话。此时再每次加入 新元素的时候，就要比较 往主栈加入的 元素x 和 最小栈此时的 栈顶元素 top进行比较
        if (!minStack.isEmpty()) {
            
            int top = minStack.peek();  // 查看当前最小栈的 栈顶元素top
            // 只有当 x 小于等于最小栈的栈顶元素top， 才将x压入最小栈
            if (x <= top) {
                minStack.push(x);
            }
        } 
        	
        // 如果最小栈为空，也就是第一次往主栈加入元素的时候，那么就无需判断，直接将x压入 最小栈
        else {
            
            minStack.push(x);
        }
        
    }

    	
    public void pop() {
        
          // 从主栈中弹出栈顶元素，这个是正常的出栈，肯定是要无条件 pop 的~~~       
        int pop = stack.pop(); 

        int top = minStack.peek();  // 查看当前最小栈的栈顶元素
        
        // 只有当 弹出的元素等于最小栈的栈顶元素，才从最小栈中弹出
        if (pop == top) {
            minStack.pop();
        }
    }

    
    	//这个top()方法就很简单了。。
    public int top() {
        return stack.peek();  // 返回主栈的栈顶元素
    }

    		//这个 getMin()方法也很简单  
    public int getMin() {
        return minStack.peek();  // 返回最小栈的栈顶元素，即当前最小值
    }
    
}
```



### 150 逆波兰表达式求值

#### 栈

题目描述：

```

```

题解 ：[https://leetcode.cn/problems/evaluate-reverse-polish-notation/solutions/21167/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-19/](https://leetcode.cn/problems/evaluate-reverse-polish-notation/solutions/21167/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-19/)

```java
class Solution {
    
       //    建议 背 这个 代码 ！！结构 好记些 ！！
	public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<tokens.length;i++){
            
            
            // 这里 采用 if 、else if、 else 判断结构，很方便！！ 
            
            if (tokens[i].equals("+")) {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a + b);
            } else if (tokens[i].equals("-")) {
                
                	int a = stack.pop();
                    int b = stack.pop();
     	// !!!! 注意  ，- 减的 运算符 与 除/ 运算符 比较特殊，先出栈的元素 a 要作为 减数
              // 你纸头上 可以画一下就知道谁 除 谁的 顺序 了      
                    stack.push(b - a);
                
            } else if (tokens[i].equals("*")) {
                
                	int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a * b);
                
            } else if (tokens[i].equals("/")) {
                
             	    int a = stack.pop();
                    int b = stack.pop(); 
            			 // !!!! 注意  b / a;
                    stack.push(b / a);
            } 
            
     // 把其他的情况 	只含有算符 的字符串 	+-*/ 情况 先放在上面，那么剩下的 else 情况 就肯定  只剩下 数字 了，遇到数字 字符的话，就要入栈
            else {
                			// 因为是 "1"，他是个字符串，所以要调用这个方法进行转换
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        
        return stack.pop();
        
    }

}
```

### 128 最长连续序列

#### 哈希表set

题解：https://leetcode.cn/problems/longest-consecutive-sequence/solutions/344825/java-pai-xu-ji-he-ha-xi-biao-bing-cha-ji-by-lzhlyl/?envType=study-plan-v2&envId=top-100-liked

```java
// 关键点，要先排序，从小到大升序，这样方便找 连续序列 ！！

// 因为数组中有可能 有重复的数字，所以要 跳过它们。。毕竟 连续序列的话 只有是1,2,3,4,5 这样的情况

// 而且 连续序列可能是 在数组的中间产生的，也有可能 会断掉，所以 我们要定义一个 max变量，每次都要    比较  连续序列的最大长度 

class Solution {

    public int longestConsecutive(int[] nums) {

        // 为了防止 数组为空 [] 的情况！！
        if (nums.length == 0) return 0;

            // 先 set “去重“ ！！
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
            
          // 然后排序，又因为只有 list 集合 可以排序，所以先把set转为list 集合 
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        // max 最终结果, count 当前长度, last 是记住上个数字，而不是 last++ ，这个你一定要搞清楚 ！！
        int max = 1, count = 1, last = list.get(0);

        for (int i = 1; i < list.size(); i++) {

            if (list.get(i) == last + 1)
                count++; // 符合连续，长度 +1

            else {
                max = Math.max(max, count); // 连不上了，记录长度
                count = 1; // 重新开始
            }

            last = nums[i];
        }
        
   // 别忘了 比较 最后一段的连续区间 ！！！因为它可能一直 连续到 数组末尾！！
        max = Math.max(max, count); 
        return max;

    }

}
```



### 283 移动零

#### 双指针快慢指针

题解：https://leetcode.cn/problems/move-zeroes/solutions/490356/283-yi-dong-ling-shuang-zhi-zhen-xiang-jie-by-ca-2/?envType=study-plan-v2&envId=top-100-liked

```java
class Solution {

       public void moveZeroes(int[] nums) {

            
            int size = nums.length;
            int slow = 0;
            int fast=0;
            
            while (fast<size){

                if (nums[fast] != 0)
                    nums[slow++] = nums[fast];

                fast++;
                
            }

            // 这段代码，就是 根据不同的 双指针 题目的情况，在模板的基础上 稍作修改。。。。
            // 当快指针fast 到达数组 末尾的时候，  此时 slow慢指针 后面的元素全变成 0 ，就能实现最终的效果了
            for (int i = slow; i < nums.length; i++) {
                nums[i] = 0;
            }   
           
        }

}
```

### 560 和为K的子数组

#### 暴力

```

```

题解：https://leetcode.cn/problems/subarray-sum-equals-k/solutions/2260091/bao-li-jie-yyds-suan-fa-tao-lu-duo-dan-w-7e52/?envType=study-plan-v2&envId=top-100-liked

```java
// 主要因为用 “滑动窗口”解决这道 子数组的题目，，真的做不出来。。。。所以只能用 暴力！！
// 暴力的话，一般就是 双重 for 循环，列举所有的情况罢了。。。。。
class Solution {

    public int subarraySum(int[] nums, int k) {
        
        int count = 0;  // 用于计数满足条件的子数组数量。
        
        for(int i = 0; i < nums.length; i++) {  // 遍历数组的每一个元素，作为子数组的起点。
           
    int sum = 0;  //初始化当前子数组的和 sum 为0。。。这个 每次外层for的开始的话，都要变成 0的！！ 
            for(int j = i; j < nums.length; j++) {  // 从当前元素开始，遍历其后的每一个元素，作为子数组的终点。
                sum += nums[j];  // 累加子数组的元素和。
                if(sum == k) count++;  // 如果子数组的和等于k，计数器加1。
            }
        }
        return count;  // 返回满足条件的子数组数量。
    }
}

```

### 189 轮转数组

#### 双指针相向指针

题解：https://leetcode.cn/problems/rotate-array/solutions/551634/javadai-ma-3chong-fang-shi-tu-wen-xiang-q8lz9/?envType=study-plan-v2&envId=top-100-liked

```java
// 主要就是三次翻转，，，，1.先反转全部的元素 2. //在反转前k个元素  3. 接着反转剩余的
class Solution {
        public void rotate(int[] nums, int k) {

        int length = nums.length;

        k %= length;    // 这行代码很关键！！！因为 k 可能会，大于数组的长度，而且 可以防止 数组的越界问题 。而且则旋转 k 次和旋转 k % nums.length 次的效果是一样的。这个操作可以有效地避免不必要的多次完全旋转。

        reverse(nums, 0, length - 1);//先反转全部的元素
        reverse(nums, 0, k - 1);//在反转前k个元素
        reverse(nums, k, length - 1);//接着反转剩余的
    }

    //把数组中从[start，end]之间的元素两两交换,也就是"反转"
    // 这道题的 次方法 reverse()，其实和 344 反转字符串的思想一摸一样，，，  用到了 双指针的相向指针，来实现的
    public void reverse(int[] nums, int start, int end) {

        
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

}
```





### 238 除自身以外数组的乘积

#### 暴力

题解：https://leetcode.cn/problems/product-of-array-except-self/description/  题目

https://www.bilibili.com/video/BV1xb4y1b7KM?p=74&vd_source=5fe50b1b35a25689fb0988c454fec5e0   视频 



```java
import java.util.*;

// 本题目的总体思想是 nums[i]的求解值 = nums[i]左侧的累乘 * nums[i]右侧的累乘
// 						  ans[i]  = left[i - 1] * right[i + 1]
class Solution {
    public int[] productExceptSelf(int[] nums) {


        int len = nums.length;
		
        int[] left = new int[len];
        int[] right = new int[len];
        
        int[] ans = new int[len];
		
        //3 个 “并行”的 
        
        
        // 初始化左侧数组left[i]，从左到右遍历 ->
       	
        // 这个 的话一般就是先 [0]赋值成nums[0]，所以遍历从下标[1]开始 
        left[0] = nums[0];
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i];
        }

        // 初始化右侧数组 right[i]，从右到左边遍历 <-
           // 这个 的话一般就是先 [len-1]赋值成nums[len-1]，所以遍历从下标[len-2]开始 
        right[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }

        // 计算结果数组。总体思想是 nums[i]的求解值 = nums[i]左侧的累乘 * nums[i]右侧的累乘
        // 不过要先考虑 nums[0] 和 nums[len-1] 的边界情况
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                ans[i] = right[i + 1];
            } else if (i == len - 1) {
                ans[i] = left[i - 1];
            } else {
                ans[i] = left[i - 1] * right[i + 1];
            }
        }

        return ans;
    }
}

```



### 73 矩阵置零

#### 暴力

题解：https://leetcode.cn/problems/set-matrix-zeroes/solutions/6594/o1kong-jian-by-powcai/?envType=study-plan-v2&envId=top-100-liked

```java
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public void setZeroes(int[][] matrix) {
        
        
        int row = matrix.length;  // 获取矩阵的行数
 int col = matrix[0].length;  // 获取矩阵的列数，，这个一般就是 这样获取二维数组的 列！！
        
        
        // 为什么要用 set集合，因为如果matrix[0][1] 和 matrix[0][2] 这两个元素都是0值，那么他们的行索引，都会加入到 行set集合中，那么 第0行 其实会加入两次，但只会保留1个 0行。。。
        Set<Integer> rowZero = new HashSet<>();  // 用于存储包含零的行索引的set集合
        Set<Integer> colZero = new HashSet<>();  // 用于存储包含零的列索引的set集合

     //第一遍遍历 ：找出所有是0的元素 matrix[i][j]，把他们对应的 行索引i 和 列索引j 记录下来，存入对应的 set集合
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    		// 两个 set 集合 要同时一起记录！！！ 
                    rowZero.add(i);  // 记录包含零的，行索引i 的set集合
                    colZero.add(j);  // 记录包含零的，列索引j 的set集合
                }
            }
        }

        // 第二遍遍历：再次遍历 二维矩阵，如果当前所在的 行i或 列索引 j，在 rowZero的set集合 或 colZero set集合 中，则将该行的 所有元素 置为零，或者 该列的下面所有元素 置为0
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rowZero.contains(i) || colZero.contains(j)) {
                    matrix[i][j] = 0; 
                }
            }
        }
    }
}

```

### 48 旋转图像

#### 暴力

题解：

https://leetcode.cn/problems/rotate-image/solutions/1228078/48-xuan-zhuan-tu-xiang-fu-zhu-ju-zhen-yu-jobi/?envType=study-plan-v2&envId=top-100-liked 这个是通过一个辅助矩阵的

https://leetcode.cn/problems/rotate-image/solutions/5012/yi-ci-xing-jiao-huan-by-powcai/?envType=study-plan-v2&envId=top-100-liked 这里看思路二 ，上下翻转方式+ 正对角线翻转，就也是“原地”翻转

```java

// 方式1， 辅助矩阵
class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        // 深拷贝 matrix -> tmp
        int[][] tmp = new int[n][];
        for (int i  = 0; i < n; i++)
            tmp[i] = matrix[i].clone();
        // 根据元素旋转公式，遍历修改原矩阵 matrix 的各元素
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n - 1 - i] = tmp[i][j];
            }
        }
    }
}

// 方式2，上下翻转方式+ 正对角线翻转，就也是“原地”翻转
class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        
        // 上下翻转，这个公式好理解的，主要就是记得 是 n-i-1。记得要 -1 
        for (int i = 0; i < n / 2; i ++){
            int[] tmp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = tmp;
        }
        
        // 按照 正对角对角线 翻转，内部的 j 要设置成 i+1 。
        for (int i = 0; i < n; i ++){
            for (int j= i + 1; j < n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}



```

### 74 搜索二维矩阵

#### 暴力

题解：https://leetcode.cn/problems/search-a-2d-matrix/description/?envType=study-plan-v2&envId=top-100-liked

```java
// 这道题的 代码和  240题 一摸一样的。
class Solution {

   public boolean searchMatrix(int[][] matrix, int target) {
    
    for (int i = 0; i < matrix.length; i++) {
       // 这个for循环遍历的话，其实就是 对 二维矩阵的 每一行进行遍历 。。。因为每一行都是“有序”的
        												//  所以 很适合----> 二分查找 
        int res = binarySearch(matrix[i], target);
        if (res != -1) {
            return true;
        }
    }
    return false;
}

    
//  “二分查找” 的代码 
public int binarySearch(int[] nums, int target) {
   int left = 0 , right = nums.length-1;
        	 
        //因为是 “左闭右闭” 原则 , 所以是  带等号的 <=
        
        while(left <= right){
           
            
             int mid = (left + right)/2 ;
            if(nums[mid]>target)
                // 所以 right 下标要更新成  mid-1 了
                right = mid - 1;
            else if (nums[mid]<target)
                // left 下标 要更新成 mid+1 了
                left = mid + 1;
            else
                return mid;

        }
        return -1;
}

}
```



### 240 搜索二维矩阵 II

#### 暴力

题解：https://leetcode.cn/problems/search-a-2d-matrix-ii/solutions/118335/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-4/?envType=study-plan-v2&envId=top-100-liked  只看 解法1就行

```java
// 这道题的 代码和 
class Solution {

   public boolean searchMatrix(int[][] matrix, int target) {
    
    for (int i = 0; i < matrix.length; i++) {
       // 这个for循环遍历的话，其实就是 对 二维矩阵的 每一行进行遍历 。。。因为每一行都是“有序”的
        												//  所以 很适合----> 二分查找 
        int res = binarySearch(matrix[i], target);
        if (res != -1) {
            return true;
        }
    }
    return false;
}

    
//  “二分查找” 的代码 
public int binarySearch(int[] nums, int target) {
   int left = 0 , right = nums.length-1;
        	 
        //因为是 “左闭右闭” 原则 , 所以是  带等号的 <=
        
        while(left <= right){
           
            
             int mid = (left + right)/2 ;
            if(nums[mid]>target)
                // 所以 right 下标要更新成  mid-1 了
                right = mid - 1;
            else if (nums[mid]<target)
                // left 下标 要更新成 mid+1 了
                left = mid + 1;
            else
                return mid;

        }
        return -1;
}


}
```

### 41 缺失的第一个正数

#### 暴力

题解：

https://leetcode.cn/problems/first-missing-positive/solutions/2359860/que-shi-de-di-yi-ge-zheng-shu-jian-dan-y-lnw6/?envType=study-plan-v2&envId=top-100-liked  代码 

https://leetcode.cn/problems/first-missing-positive/solutions/553194/yi-miao-jiu-neng-gao-dong-de-shi-pin-jie-et3v/?envType=study-plan-v2&envId=top-100-liked 解法二的图解 

```java

class Solution {
    
    public int firstMissingPositive(int[] nums) {
        
        
       // 第1轮循环：（原地，重排数组）
        // 元素 x 应该放在数组中下标为 x-1 的位置上，所以要进行元素的交换）
        for (int i = 0; i < nums.length; i++) {        
           // 需要交换的 元素 x必须满足以下条件：大于等于1，元素小于等于数组长度，最后一个条件就是 不和 下标 x-1上的元素相等，不然的话 就会一直 无限while死循环。。。。。。。。
         while (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) { 
             // 因为可能交换一次之后，还有符合条件的元素，所以此处不用 if ，必须改用while，这样可以执行多次
            	// 交换元素的三行代码，但是注意，对于数字x， 应该放在数组中下标为 x-1 的位置上
                        int temp = nums[i];
                        nums[i] = nums[temp-1];
                        nums[temp-1] = temp;
                
            }
            
            
        }
        
        
        // 第2轮循环：（查找缺失的最小正整数）
        // 因为 元素x放在了 下标x-1的地方。如果for循环扫描的时候，发现nums[i]的值 不等于 i+1，那么就发生了缺失，就要返回 i+1  
        
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] != i + 1) 
                return i + 1;
        }
        return nums.length + 1;
    }

   
}


```



### 739 每日温度

#### 单调栈

题解：https://leetcode.cn/problems/daily-temperatures/solutions/609485/739-mei-ri-wen-du-dan-diao-zhan-xiang-ji-8kl5/?envType=study-plan-v2&envId=top-100-liked

```java
// 这道题的话是 找右边的第一个比 当前元素大(栈顶元素)的 元素---->所以用的是 单调递增栈↑

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

 // 递增栈，用于保存遍历过的数组元素。。这里保存的是 元素的下标！！而不是元素值。。。这个是根据题目所选的 
        Stack<Integer> st = new Stack<>();
           
        int size = temperatures.length;

           // 用于保存最终的答案结果
        int[] result = new int[size];

        // 因为先保存数组的第一个元素的下标值，所以就是0
        st.push(0);
        // 所以for循环要从第二个元素，开始下标值就是1了。。而且是从左到右遍历
        for (int i = 1; i < size; i++) {

            //当前遍历的元素 小于< 栈顶元素，就直接插入 当前元素的下标值
            if (temperatures[i] < temperatures[st.peek()])  
                st.push(i);
             //  当前遍历的元素 == 栈顶元素，就直接插入 当前元素的下标值
            else if (temperatures[i] == temperatures[st.peek()])  
                st.push(i);

            
         //  当前遍历的元素 大于> 栈顶元素，就说明此时的 遍历元素 是 比当前元素(栈顶元素)大的右边第一个元素，那么就要执行 逻辑操作，以及弹栈的操作
            else {

        // 里面的这个while循环肯定是要有的 ，而且终止条件是两个！！！因为是维护的单调递增栈↑，所以 要把 栈中 比当前遍历元素 小的，都弹出去。。。直到新元素遇到了比它 大的元素，才结束while循环
                while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) { 

             //主要逻辑，，不同的题目，主要就是这里的写法不同。。。这里是 计算下标值的 差值
         // 因为 result结果数组一开始初始化的时候，都为0，这里的话是为 某些下标赋值，，
                    result[st.peek()] = i - st.peek();

                     //弹出栈顶元素。。。这个是必须要有的代码！！
                    st.pop();
                }

         // 当上面的while循环终止了，也就是直到新元素遇到了比它 大的元素，此时 才加入新元素的下标值。。。这个是必须要有的代码！！
                st.push(i);
            }
        }

        return result;

    }
}
```

### 503 下一个更大元素 II

#### 单调栈

题解：https://leetcode.cn/problems/next-greater-element-ii/solutions/611205/503-xia-yi-ge-geng-da-yuan-su-iidan-diao-9ez5/

```java
// 1、这道题 主要和之前的 每日温度一样。。找右边的第一个比 当前元素(栈顶元素)大的 元素---->所以用的是 单调递增栈↑
// 2、只不过呢，，，有个特殊的地方 。就是说 可以找当前元素的 第一个比它大的元素，还可以从头开始遍历找。。也就是“环形”。。主要是这个地方的处理。。那么就是 for循环遍历数组nums[]的 终止条件变成2倍的 size，然后要对 i取模size，防止下标溢出嘛！！  其实这个就是 等价于 原来的数组后面再接上 自身数组 。。。

class Solution {
    public int[] nextGreaterElements(int[] nums) {
    

// 递增栈，用于保存遍历过的数组元素。。这里保存的仍然是 元素的下标！！而不是元素值。。。这个是根据题目所选的 
        Stack<Integer> st = new Stack<>();
           
        int size = nums.length;

           // 用于保存最终的答案结果
        int[] result = new int[size];

    // 本道题要求的，也就是 对于 找不到 比当前元素大的那些元素，结果要赋值成-1。。。但是 初始化result结果数组的时候是0。。所以要调用内置的方法 fill ()！！把result 全部初始化为-1
        Arrays.fill(result,-1);

        // 因为先保存数组的第一个元素的下标值，所以就是0
        st.push(0);
        // 所以for循环要从第二个元素，开始下标值就是1了。。而且是从左到右遍历。。。


        // 这里由于可以“环形”的从头开始再遍历数组，所以要2*size作为终止条件，以及 每次都是要 i取模 %size
        for (int i = 1; i < 2*size; i++) {
                // 这个很关键 
            int  j = i%size;

            //当前遍历的元素 小于< 栈顶元素，就直接插入 当前元素的下标值
            if (nums[j] < nums[st.peek()])  
                st.push(j);
             //  当前遍历的元素 == 栈顶元素，就直接插入 当前元素的下标值
            else if (nums[j] == nums[st.peek()])  
                st.push(j);

            
               //  当前遍历的元素 大于> 栈顶元素，就说明此时的 遍历元素 是 比当前元素(栈顶元素)大的右边第一个元素，那么就要执行 逻辑操作，以及弹栈的操作
            else {

        // 里面的这个while循环肯定是要有的 ，而且终止条件是两个！！！因为是维护的单调递增栈↑，所以 要把 栈中 比当前遍历元素 小的，都弹出去。。。直到新元素遇到了比它 大的元素，才结束while循环
                while (!st.isEmpty() && nums[j] > nums[st.peek()]) { 

            // 主要逻辑，，不同的题目，主要就是这里的写法不同。。。这里是 赋值对应的 第一个比当前元素大的  元素值！！！
                // 这里的话是为 result数组 某些下标赋值，赋值成 元素值 ！！
                    result[st.peek()] = nums[j];

                     //弹出栈顶元素。。。这个是必须要有的代码！！
                    st.pop();
                }

         // 当上面的while循环终止了，也就是直到新元素遇到了比它 大的元素，此时 才加入新元素的下标值。。。这个是必须要有的代码！！
                st.push(j);
            }
        }

        return result;

    }
}


```

### 42 接雨水

#### 单调栈

题解：https://leetcode.cn/problems/trapping-rain-water/solutions/616404/42-jie-yu-shui-shuang-zhi-zhen-dong-tai-wguic/?envType=study-plan-v2&envId=top-100-liked

```java
// 1、这道题 主要和之前的 每日温度一样。。找右边的第一个比 当前元素(栈顶元素)大的 元素-->所以用的是 单调递增栈↑

// 2、 这道题，还要找 从左边的第一个比当前元素大的 元素，那么就是要栈顶元素的里面的下一个相邻元素。

class Solution {
    public int trap(int[] height) {

 // 递增栈，用于保存遍历过的数组元素。。这里保存的是 元素的下标！！而不是元素值。。。这个是根据题目所选的 
        Stack<Integer> st = new Stack<>();
           
        int size = height.length;

           // 用于保存最终的答案结果，也就是 对于数组中的每一个nums[i]，看它能接到的雨水面积，最后累加。
        int sum=0;

        
        // 因为先保存数组的第一个元素的下标值，所以就是0
        st.push(0);
        // 所以for循环要从第二个元素，开始下标值就是1了。。而且是从左到右遍历
        for (int i = 1; i < size; i++) {

            //当前遍历的元素 小于< 栈顶元素，就直接插入 当前元素的下标值
            if (height[i] < height[st.peek()])  
                st.push(i);
             //  当前遍历的元素 == 栈顶元素，就直接插入 当前元素的下标值
            else if (height[i] == height[st.peek()])  
                st.push(i);

            
             //  当前遍历的元素 大于> 栈顶元素，就说明此时的 遍历元素 是 比当前元素(栈顶元素)大的右边第一个元素，那么就要执行 逻辑操作，以及弹栈的操作
            else {

        // 里面的这个while循环肯定是要有的 ，而且终止条件是两个！！！因为是维护的单调递增栈↑，所以 要把 栈中 比当前遍历元素 小的，都弹出去。。。直到新元素遇到了比它 大的元素，才结束while循环
                while (!st.isEmpty() && height[i] > height[st.peek()]) { 

                    
     //主要逻辑，不同的题目，主要就是这里的写法不同。。这里是计算，数组中的每一个nums[i]，能接雨水的面积 
         // 这里比较”特殊“，要先把 栈顶元素(当前元素)弹出来！那么剩下的栈中的下一个元素 就是 栈顶元素的 左边第一个比它大的元素，不过要先保留这个中间的元素 mid。。。
                    int mid = st.pop();
                    
                 // 计算雨水的 高和宽，这里要先 if判断一下栈是否空，因为要左侧和右侧！！一定要记得！！
					 if (!st.empty()) {
               // 左边的第一个大的，和 右边第一个大进行比较，找到其中较小值。然后 和 中间mid 值作差，就能算出 雨水的高。
               int h = Math.min(height[st.peek()], height[i]) - height[mid];
               int w = i - st.peek() - 1; // 注意减一，只求中间宽度，具体可以草稿画图 ！！
                        
                         // 雨水面积累加
                         sum += h * w;
                    }
        
                }

         // 当上面的while循环终止了，也就是直到新元素遇到了比它 大的元素，此时 才加入新遍历的元素的下标值。。。这个是必须要有的代码！！
                st.push(i);
            }
        }

        return sum;

    }
}
```

### 84 柱状图中最大的矩形

#### 单调栈

题解：https://leetcode.cn/problems/largest-rectangle-in-histogram/solutions/893994/dai-ma-sui-xiang-lu-dai-ni-gao-ding-dan-e3cak/?envType=study-plan-v2&envId=top-100-liked

```java
// 1、这道题 主要和之前的 ”接雨水“题目的思路，相反！！找右边的第一个比 当前元素(栈顶元素)小的元素------->所以用的是 单调递减栈↓ 

// 2、这道题，还要找 从左边的第一个比当前元素小的 元素，那么就是要栈顶元素的里面的下一个相邻元素。

//3、这道题对于”接雨水“这题，更特殊了点，因为如果 原始的 height数组是 [1,2,3,5] 递增，会有问题，比如入栈了也不进入 计算面积这段代码;以及原始的 height数组是 [5,4,3,2,1] 递减，也会有问题，因为 每次弹栈的时候，会少左侧的元素，也导致不计算面积！！  --->所以要 对初始的height 数组 首尾加 0元素！


class Solution {
    public int largestRectangleArea(int[] heights) {

 // 递增栈，用于保存遍历过的数组元素。。这里保存的是 元素的下标！！而不是元素值。。。这个是根据题目所选的 
        Stack<Integer> st = new Stack<>();
           
    // 对原来数组扩容，返回一个新数组newHeights。在头和尾各加入一个元素 0 ！！！这个很关键！！！
        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
		
        // 对中间的，要原封不动的一一复制过来
        for (int i = 0; i < heights.length; i++){
            newHeights[i + 1] = heights[i];
        }

		int newsize = newHeights.length;
			
   // 这题的求最大值，初始化result 不应该是 Integer.MIN_VALUE，因为 面积的最小值也只是 从0开始 
           // 用于保存最终的答案结果，也就是 对于数组中的每一个nums[i]，看它能形成的矩阵面积，需要不断比较更新的
        int result= 0;

        
        // 因为先保存数组的第一个元素的下标值，所以就是0
        st.push(0);
        // 所以for循环要从第二个元素，开始下标值就是1了。。而且是从左到右遍历
        for (int i = 1; i < newsize; i++) {

        //因为这道题是递减栈↓ ，所以当前遍历的元素 大于＞ 栈顶元素，就直接插入 当前元素的下标值
            if (newHeights[i] > newHeights[st.peek()])  
                st.push(i);
             //  当前遍历的元素 == 栈顶元素，就直接插入 当前元素的下标值
            else if (newHeights[i] == newHeights[st.peek()])  
                st.push(i);

            
                //  当前遍历的元素 小于＜ 栈顶元素，就说明此时的 遍历元素 是 比当前元素(栈顶元素)小的右边第一个元素，那么就要执行 逻辑操作，以及弹栈的操作
            else {

        // 里面的这个while循环肯定是要有的 ，而且终止条件是两个！！！因为是维护的单调递减栈↓，所以 要把 栈中 比当前遍历元素 大的，都弹出去。。。直到新元素遇到了比它 小的元素，才结束while循环
                while (!st.isEmpty() && newHeights[i] < newHeights[st.peek()]) { 
           
     //主要逻辑，不同的题目，主要就是这里的写法不同。。这里是计算，数组中的每一个nums[i]，能形成的矩形面积，这个值需要不断和前面的 面积 比较！！
                    
         // 这里比较”特殊“，要先把 栈顶元素(当前元素)弹出来！那么剩下的栈中的下一个元素 就是 栈顶元素的 左边第一个比它大的元素，不过要先保留这个中间的元素 mid。。。和”接雨水“类似
                    int mid = st.pop();
                    
         // 和”接雨水“一样！！这里仍要先 if判断一下栈是否空，因为要左侧和右侧！！一定要记得！！
					 if (!st.empty()) {
            	   	
                    int left = st.peek();
                    int right = i;
                    int w = right - left - 1; // 注意减一，只求中间宽度，具体可以草稿画图！
                    int h = newHeights[mid];   
                    result = Math.max(result, w * h);
        
                    }
        
                }

         // 当上面的while循环终止了，也就是直到新元素遇到了比它 大的元素，此时 才加入新遍历的元素的下标值。。。这个是必须要有的代码！！
                st.push(i);
            }
        }

        return result;

    }
}
```



### 11 盛最多水的容器

#### 双指针双向指针

题解：https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=top-100-liked

```java
// 这道题和 。。“单调栈" 没关系 !!!

// 若向内 移动短板 ，水槽的短板 min(h[i],h[j]) 可能变大，因此下个水槽的面积 可能增大↑；若向内移动长板 ，水槽的短板 不变或变小，因此下个水槽的面积 一定变小↓ 。

//因此，初始化双指针分列水槽左、右两端，循环每轮将 短板 向内移动一格，并更新面积最大值，直到两指针相遇时跳出，即可获得最大面积。
class Solution {
    public int maxArea(int[] height) {

        int left = 0, right = height.length - 1;
        
        int res = 0;

        while(left < right) {
            
                  // 进行条件判断 
        if (height[left] < height[right]) {
			
            // 要不要再减去1，画个草稿图就行了
            // 计算面积：(右指针 - 左指针) * 左指针对应高度
            // 每次都要更新res  为当前最大面积
            res = Math.max(res, (right - left) * height[left]);
            left++; // 左指针向右移动

        } 
            // 如果height[left]大于或等于height[right]  
            else {

           
            // 计算面积：(右指针 - 左指针) * 右指针对应高度
            // 每次也要更新res  为当前最大面积 
        res = Math.max(res, (right - left) * height[right]);
            right--; // 右指针向左移动

        }


        }
        
        return res;
        
    }
}
```

### 239 滑动窗口最大值

#### 单调队列

```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
		
  // 这里 单调队列里面存入的仍然是 元素的下标 ！！！ 和单调栈有点像。。主要是为了后面的方便比较大小

        // 保存每个窗口的最大值，用list集合来保存
        List<Integer> res = new ArrayList<>();
			
        // 队列一般用的就是 “双端”队列 Deque ！！！因为它可以 一端又 入队 和 出队
        Deque<Integer> queue = new ArrayDeque<>();

        
        // 遍历数组中元素，right表示滑动窗口右边界
        for(int right = 0; right < nums.length; right++) {

			
        // 1. ------ >>>> 单调队列的开始部分，这里的话 队头是 最大值，所以是 单调递减队列↓
              
            // 如果队列不为空且当前遍历元素  大于等于队尾元素，则将队尾元素移除。
            
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) 
                queue.pollLast();
           		            
         //  直到，队列为空或当前遍历元素  小于  新的队尾元素的时候。才存储元素下标
            queue.offerLast(right);
            
           // 单调队列的 结束 部分  <<<<  -------- 
            
            
   // 2.当前遍历元素添加之后，都要重新 计算滑动窗口的左边界。。这个+1 草稿纸上 想想就知道了。。。
            int left = right - k +1;
            
            // 当队首元素(当前窗口的最大值)，的下标小于 滑动窗口的左边界left时
            // 表示队首元素 已经不在 滑动窗口内 ！！因此将其从队首移除
            if (queue.peekFirst() < left)
                queue.pollFirst();
            

            
             //！！！！这个肯定也要 注意的 ！！
  // 3.由于数组下标从0开始，因此当 滑动窗口右边界 right+1 大于等于窗口大小k时，意味着 定长k的    滑动窗口，已经形成
            //  所以，之后的话，每次循环的结束处，队首元素 就是该窗口内的 最大值，要 保存一下
            
            if (right +1 >= k) {
                res.add(nums[queue.peekFirst()]);
            }
        }
				
        
        // 把最终的结果list 集合 要 转换为  int[] 数组 ！！
        int[] arr_res = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
             arr_res[i] = res.get(i);
        }

        return arr_res;
    }

}
```



### 215 数组中的第K个最大元素

#### 优先级队列

题解：https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/1282560/cpython3java-1da-gen-dui-diao-ku-2shou-l-xveq/?envType=study-plan-v2&envId=top-100-liked

```java

// 这道题的话，需要掌握 优先级队列 PriortyQueue 调用库的做法  +  手写快速排序(面试手撕必问)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        // 创建一个大根堆（优先队列），用于存储数组中的元素
        
        // 因为默认是小根堆，升序↑。。所以要自定义比较器，重写compare方法，使得按降序 ↓排列
        // 表示b排在a前面，实现降序排列
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)->b-a);

        // 遍历数组，先将所有元素添加到大根堆中
        for (int i = 0; i <= nums.length-1; i++) {
            maxHeap.offer(nums[i]); 
        }

        //  -  -- - -然后就是弹出 ，对队 的操作！！
        // 弹出 k-1次后，因为每次弹出的都是堆顶元素(当前的最大值)。。
        // 那么 剩下的 堆顶元素即为第k大的元素 ！！懂得这个逻辑很关键，。。。。
        for (int i = 1; i <= k - 1; i++) {
            maxHeap.poll(); 
        }

        // 此时的 堆顶元素 即为第k大的元素，使用peek() 方法返回，但不移除
        return maxHeap.peek();
    }
}


```

```java
//  手写快速排序(面试手撕可能会问的第二种写法)


```



### 347 前 K 个高频元素

题解：[https://leetcode.cn/problems/top-k-frequent-elements/solutions/11201/leetcode-di-347-hao-wen-ti-qian-k-ge-gao-pin-yuan-/](https://leetcode.cn/problems/top-k-frequent-elements/solutions/11201/leetcode-di-347-hao-wen-ti-qian-k-ge-gao-pin-yuan-/)    下面的 评论 的有个名字    辰小狼睡不醒

#### 哈希表map

```java
class Solution {
   public int[] topKFrequent(int[] nums, int k) {
    	
    	// 用于返回结果的 数组 。。返回的是  元素数字， 而不是出现的次数 ！！
    	
        int[] result = new int[k];
    
        // 第 1 步，就是 统计 每个数字 出现的次数 。。最适合用 map 来存储 
    	// key : 数字 ，value ：出现的频次
        Map<Integer, Integer> map = new HashMap<>();
				
    			
        for (int i = 0; i < nums.length; i++) {
				// 因为 map的 value 值 可以覆盖，所以一般就是这样 统计 出现次数的，getOrDefault(nums[i],0) 方法就是指，如果 这个 key 存在，那么就返回对应的 value；如果不存在，就返回 0 
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

   // 第 2 步，其实就是对 map集合中的 value 进行排序，但是呢，key 也要一起连着动。所以就想到了 entrySet()方法 以及 Collections.sort( , )方法，两者结合。因为这个sort 方法只适用于list集合，所以要把entrySet()返回的Set<>集合，先转换存储在 List<>中 
       
       // 根据 map.entry 对象的 value 进行排序。。。其实 也就是 连同 key 一起移动
    	// 本题的 难点 就在这里，只有这样 才能实现 key 跟着 value排序 ，然后 一起移动
        List<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());
    
       
   
        Collections.sort(list, (a, b) -> {
            
     //因为 要返回 出现次数最高的 元素，那么 出现次数最多的那个 数字 就要排在第一位，那么就是降序。
            	// 因为 升序 是 a-b。而本题 要降序 ，所以是 b-a ！！
   	// a和b 就是 list中存储的每一个元素，所以是 map.entry类型，而且是根据对象的 value 出现次数 进行排序 ，只能通过getValue()方法 
            return b.getValue() - a.getValue();
        });
       
       //这个 sort()方法一旦执行的话，那么原来的list集合的元素 就会内部排序的，会改变的！！！
       
			
// 第 3 步： 就是把 list 集合中 存储的 每个 map.entry对象，kv结构里面的 key，就是 数字元素， 依次插入到 res 结果数组。。注意是 前 k个   map.entry对象  ！ 所以 循环终止条件 是 k 
       
        for (int i = 0; i < k; i++) {
            
            	// 通过 get(i)获取 list 集合 中的 每一个元素 
            	// 而 每一个 map.entry对象 要获得 key可以通过 getKey()方法 
            result[i] = list.get(i).getKey();
        }

        
        return result;
    }
}
```

### 77 组合

#### 回溯组合

题目描述：

```
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

你可以按 任何顺序 返回答案。

 

示例 1：

输入：n = 4, k = 2
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
```

题解：https://leetcode.cn/problems/combinations/solutions/2071017/hui-su-bu-hui-xie-tao-lu-zai-ci-pythonja-65lh

```java
// 组合的思路。。。回溯递归。。。一直向下递归 ↓ ，接着选择下一个元素
//  然后配合 for循环，就是 横向的，每次选择 起始的开始元素是哪个，
class Solution {
	
             // 基本上这两个都是这样定义好，在最外面。。。
    
            // 设置 全局列表List<List<...>> res 存储最后的所有结果
             // List<...> temp，代表每一个 到叶子节点的 临时路径答案 
    List<List<Integer>> res= new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
	
    			//自带的主函数 
    public List<List<Integer>> combine(int n, int k) {
        // 调用下面自定义的函数 ，这里传入的初始值 startIndex 是1，因为 n集合就是 从1开始的数字
      	// 这里的  startIndex 指的是，选择的第几个数字，比如1234，那么1就是1，	2就是2
        backtracking(n,k,1);
        
        return result;
    }

    public void backtracking(int n,int k,int startIndex){
				
        // 当到了  要找答案的长度的时候，也就是遇到了叶子节点，就要 保存到 最终结果 res 里面
        if(temp.size() == k){
            		
    
		// 这里的话，有个小细节，所以必须是 new ArrayList<>(temp)传入temp，开辟一个新对象，
            //  如果是 直接res.add(temp), 那么 里面的 temp 临时答案就会一直变化。。。
            res.add(new ArrayList<>(temp));
            return;

        }
        
	// 选择列表，因为这里只有一个选择列表，其实就是 1,2,3,4 里面慢慢选，是横向的 → 
        // 那么就要用到startIndex， i = startIndex，每次 都向后选一个元素 。。
        for (int i =startIndex;i<=n;i++){ 
            
            // 单个 临时路径答案，不断添加元素，比如这里先选上 第一个元素，1
            temp.add(i);
            
     // 向下递归，纵向的 ↓，记得 i+1，也就是选择 第二个元素，2，那么此时的临时路径答案是 1，2 了
            backtracking(n,k,i+1);
            
         	// 撤销，移除临时路径 末尾的元素，比如 撤销 2，那么临时路径答案又只剩下1 了
            temp.remove(temp.size()-1);
        }
    }
}
```



### 39 组合总和

#### 回溯组合

题目描述：

```
给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。

candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 

对于给定的输入，保证和为 target 的不同组合数少于 150 个。

 

示例 1：

输入：candidates = [2,3,6,7], target = 7
输出：[[2,2,3],[7]]
解释：
2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
7 也是一个候选， 7 = 7 。
仅有这两种组合。
示例 2：

输入: candidates = [2,3,5], target = 8
输出: [[2,2,2,2],[2,3,3],[3,5]]
```

题解：https://leetcode.cn/problems/combination-sum/solutions/857543/dai-ma-sui-xiang-lu-dai-ni-xue-tou-hui-s-7tum

```java
// 组合的思路。。。回溯递归。。。一直向下递归 ↓ ，接着选择下一个元素
//  然后配合 for循环，就是 横向的，每次选择 起始的开始元素是哪个，
// 但是这道题有点特殊，，， 每个元素 都可以 "重复用" ！！！	

// 这道题是 给你的初始选择列表，里面的元素都是唯一的 。。所以不需要去重 ！！

class Solution {	
    
    
	// 依旧的 两个全局变量 
     private List<List<Integer>> res = new ArrayList<>();// 存放最终结果集 res
    private List<Integer> temp = new ArrayList<>();// 用来存放 符合的单个路径答案



    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
       		// 这里还要额外对sum =0赋值，以及 startIndex =0，因为是第一个元素下标从0开始
        backtracking(candidates, target, 0, 0);
        return res;
    }


    public void backtracking(int[] candidates, int target, int sum, int startIndex) {
		// 递归结束出口，这里的话是有2个了。。。。都必须写出来哦！！！
       
        if (sum == target) {		
            res.add(new ArrayList<>(temp));
            return;
        }
        
         if (sum > target) 
            return;
        
        
// 因为只在 一个 选择列表里面取，其实就是 []数组 candidates 里面的元素，里面慢慢选，是横向的 → 
        // 那么 就要用到startIndex, i = startIndex，每次 都向后选一个元素 。。
        for (int i = startIndex; i < candidates.length; i++) {

            sum += candidates[i];
            temp.add(candidates[i]);
            
     // 不用 传入i + 1 了。。。本题 和之前的题目不一样，表示可以 "重复"读取 当前的数，所以递归函数传入的是 i !!! 然后去下一层递归 ↓ 
            backtracking(candidates, target, sum, i);  

            // 撤销 操作
            sum -= candidates[i];
            temp.remove(temp.size() - 1);
        }
    }
}
```

### 40 组合总和II

#### 回溯组合

题目描述：

```
给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用 一次 。

注意：解集不能包含重复的组合。 

 

示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
输出:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
```

题解：https://leetcode.cn/problems/combination-sum-ii/solutions/857552/dai-ma-sui-xiang-lu-dai-ni-xue-tou-hui-s-ig29/

```java
// 组合的思路。。。回溯递归。。。一直向下递归 ↓ ，接着选择下一个元素
//  然后配合 for循环，就是 横向的，每次选择 起始的开始元素是哪个，

// 这道题的要求 和 之前的 组合总和的原始题目不一样。。。有两点不太一样！！！
/**
1. 这道题，要求，求出来的最终答案 res ，也就是那么多个 单个路径答案，必须不重复！！！ 但是 给你的初始选择列表，里面的元素有可能"重复"的。。比如 1,2,3,7,-1,2,1 。。所以需要去重 ！！这里引入used[]数组来去重。。。我没采用 最终 转为 hashset 的方式 把结果集 去重。。。。

2. 而且 单个路径答案里面，每个元素只能用1次  ！！！
**/
class Solution {
    
    	// 依旧的 两个全局变量，，，
   private List<List<Integer>> res = new ArrayList<>(); // 存放最终结果集
    private List<Integer> temp = new ArrayList<>(); // 用来存放单个符合答案

    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        // 首先对 candidates 数组[]进行排序！！！方便后面 使用 used[] "去重" ！！！
        Arrays.sort(candidates);
        
        boolean[] used = new boolean[candidates.length];
        
            	// 这里还要额外对sum =0赋值 
       // 并且这里还额外传入了个 used[]数组，为了方便“去重”。哪些元素已经用，没用过 
               //  最核心的当时是  startIndex =0，因为是第一个元素下标从0开始
        backtracking(candidates, target, 0, 0, used);
        return res;
        
    }
    
    
    public void backtracking(int[] candidates, int target, int sum, int startIndex, boolean[] used) {
        
       
       
        // 多个 递归出口！！
        if (sum == target) {
            
            
            res.add(new ArrayList<>(temp));
            return;
        }
        
         if (sum >target) 
            return;
        
        		// 因为只在 一个选择列表里面取，那么就是要采用 startIndex。。i= startIndex
        for (int i = startIndex; i < candidates.length; i++) {
            	
            // used[i - 1] == true，说明同一树枝(纵向↓)，前面相邻的相同元素 使用过
            // used[i - 1] == false，说明同一"树层"(横向→)，前面相邻的相同元素 使用过
            
    // 排序之后的话，在for循环 横向→取元素的时候， 当发现  candidates[]中的i 和 i-1下标的元素相等的时候。。就需要去重了。。。但是还需要配合 used[]数组!!!那么如何判断呢？？？     
   // 要对同一"树层" 去重！！所以是 判断userd[i-1] == false！！说明 前面相邻的相同元素 使用过，
// 所以代码里面是 continue 跳过 它！！
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) 
                      continue;   
            
            sum += candidates[i];
            temp.add(candidates[i]);
            used[i] = true;  // 多了这条代码 
            
            
            backtracking(candidates, target, sum, i + 1, used); 
            used[i] = false; // 多了这条代码  
            sum -= candidates[i];
            temp.remove(temp.size() - 1);
        }
    }

    

    
}
```

### 78 子集

#### 回溯子集

题目描述：

```
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

 

示例 1：

输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
```

题解：https://leetcode.cn/problems/subsets/solutions/850474/dai-ma-sui-xiang-lu-78-zi-ji-hui-su-sou-6yfk6

```java
// 这道题的话，是 求子集问题。所以 使用回溯递归的时候， 是对 遍历的 每一个树的节点 添加到 res结果集里面。。而不是 遍历到 叶子节点 才加入res结果集中。。
//     


class Solution {
    
    	// 依旧的 两个全局变量，，，
    List<List<Integer>> result = new ArrayList<>();// 存放最终结果集
    List<Integer> temp = new ArrayList<>();// 用来存放单个符合答案
    
    public List<List<Integer>> subsets(int[] nums) {
        
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex){
				 // “特殊” 就在这里   ！！！ 。。。。
        	//遍历这个树的时候，把 “所有节点” 都记录下来，就是要求的 所有子集
      result.add(new ArrayList<>(temp));
        
        		// 所以不是在 终止条件里面写，res.add()了！！！--->这个只对 叶子节点 
        if (startIndex >= nums.length)  // 递归出口
            return;
            
        
        for (int i = startIndex; i < nums.length; i++){
            
            temp.add(nums[i]);
            
            backtracking(nums, i + 1);
            
            temp.remove(temp.size()-1);
            
        }
    }
}
```

### 46 全排列

#### 回溯排列

题目描述：

```
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

 

示例 1：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
示例 2：

输入：nums = [0,1]
输出：[[0,1],[1,0]]

```

题解：https://leetcode.cn/problems/permutations/solutions/857631/dai-ma-sui-xiang-lu-dai-ni-xue-tou-hui-s-mfrp

```java
// 又因为  {1,2} 和 {2,1}  都是  符合的答案，那么 for循环 横向遍历→ 时候，每一次都要从 i=0    开始遍历，可以 再去选取  前面上一个 的元素，那么就需要 used数组[]  √  记录此时的 temp 临时路径答案，里面 已经选了 哪些元素，如果该元素 用过了，就  不需要 再选它了， 防止 重复选取！！！   
//   所以就不需要 startIndex 参数了 ×   。。。。。

class Solution {

    	// 依旧的 两个全局变量，，，
    List<List<Integer>> result = new ArrayList<>();// 存放最终结果集
    List<Integer> temp = new ArrayList<>();// 用来存放单个符合答案
    
    
    public List<List<Integer>> permute(int[] nums) {
        
	// ‘特殊点’--->"排列" 的题目的话，就是要传入一个 used []数组 √ !! 而不是 startIndex 了 ×
     // used数组[]，主要是 标记单个答案temp里面，我们选过 哪些元素，使用过的元素我们也不再选了  
        boolean[] used = new boolean[nums.length];
        backtracking(nums,used);
        return result;
        
    }

    private void backtracking(int[] nums,boolean[] used){
        
        	// 递归出口 还是很容易想到的，就是 每个单个答案的长度 和 原数组的长度一样就停止了
        if (temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        
      // ‘特殊点’--->这里的for循环  i要从0开始了。因为 “排列” 问题，前面的元素也是可以选择的 
        for (int i = 0; i < nums.length; i++){
            
   //used数组[] 就是记录， 此时的temp 里已经选的元素，如果这个元素使用了，那么就跳过 continue，防止重复选取 。。。
            if (used[i]==true)		
                continue;
            
            used[i] = true;		// 选择的元素当然要标记一下true。
            temp.add(nums[i]);
            
            backtracking(nums,used);
            
             used[i] = false;
            temp.remove(temp.size()-1);
               
        }
    }
    
}
```



### 47 全排列 II

#### 回溯排列

题目描述：

```
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

 

示例 1：

输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
```

题解：https://leetcode.cn/problems/permutations-ii/solutions/418230/47-quan-pai-lie-iiche-di-li-jie-pai-lie-zhong-de-q

```java
// 这道题目，相对于 46题的 原始 “全排列”题目的话，就是 nums数组中存在 重复的元素，所以要去重 ！！    // 其实就是 多加了两行代码
class Solution {

    	// 依旧的 两个全局变量，，，
    List<List<Integer>> result = new ArrayList<>();// 存放最终结果集
    List<Integer> temp = new ArrayList<>();// 用来存放单个符合答案
    
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        
            // 首先对 nums 数组进行排序。方便后面 去重 ！！
        Arrays.sort(nums);
        
	// ‘特殊点’--->"排列" 的题目的话，就是要传入一个 used []数组 √ !! 而不是 startIndex 了 ×
     // used数组[]，主要是 标记单个答案temp里面，我们选过 哪些元素，使用过的元素我们也不再选了  
        boolean[] used = new boolean[nums.length];
        backtracking(nums,used);
        return result;
        
    }

    private void backtracking(int[] nums,boolean[] used){
        
        	// 递归出口 还是很容易想到的，就是 每个单个答案的长度 和 原数组的长度一样就停止了
        if (temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        
      // ‘特殊点’--->这里的 i要从0开始了。因为 “排列” 问题，前面的元素也是可以选择的 
        for (int i = 0; i < nums.length; i++){
            
             // used[i - 1] == true，说明同一树枝 nums[i - 1]使用过
            // used[i - 1] == false，说明同一"树层"  nums[i - 1]使用过
            
    // 我们去重主要是，同一"树层"的去重 。 所以只需判断 used[i - 1]==false，使用过则直接跳过
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) 
                continue;
            
            
   //used数组[] 就是记录， 此时的temp 里已经选的元素，如果这个元素使用了，那么就跳过 continue，防止重复选取 。。。 
            if (used[i]==true)		
                continue;
            
            used[i] = true;		// 选择的元素当然要标记一下。
            temp.add(nums[i]);
            
            backtracking(nums,used);
            
            used[i] = false;
            temp.remove(temp.size()-1);
               
        }
    }
    
}
```

### 509 斐波那契数

#### 动态规划基础

题目描述：

```
斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

F(0) = 0，F(1) = 1
F(n) = F(n - 1) + F(n - 2)，其中 n > 1
给定 n ，请计算 F(n) 。

 

示例 1：

输入：n = 2
输出：1
解释：F(2) = F(1) + F(0) = 1 + 0 = 1
```

题解：https://leetcode.cn/problems/fibonacci-number/solutions/853411/dai-ma-sui-xiang-lu-509-fei-bo-na-qi-shu-n389

```java
// 这道题 的话，可以使用 dp动态规划，只不过是少见的 。。。。题目中就直接给了 递归公式。。。。

class Solution {
public int fib(int n) {

    		   // 这个主要是为了防止传入 n =0的时候，数组越界。。。
          if (n == 0) return 0;  
    		
    
    			// 采用一维的 dp[]就行
    		 // 因为是 F(0)....到 F(n)，所以是求 n+1 个数，所以数组长度也是 n+1
        int[] dp = new int[n + 1];    // dp[i] 代表的是，第i个数的斐波那契数是 dp[i]
    
    
    
    					//   初始化 dp数组。 
        dp[0] = 0;
        dp[1] = 1;
    					//   遍历计算 dp数组。  for循环一般都是 i 从 2开始。
        for (int i = 2; i <= n; i++){ 
            dp[i] = dp[i-1] + dp[i-2];  // 递推公式 ，状态转移公式，dp[i]依赖前两个数
        }
    			
        return dp[n];

    }
}
```



### 70 爬楼梯

#### 动态规划基础

题目描述：

```
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

 

示例 1：

输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶
示例 2：

输入：n = 3
输出：3
解释：有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶
```

题解：https://leetcode.cn/problems/climbing-stairs/solutions/854668/dai-ma-sui-xiang-lu-dong-tai-gui-hua-jin-y1hw

```java
//  采用动态规划来做，当前的 楼梯阶数 i的走法，依赖于 前面阶数楼梯i-1的走法个数。。。。 

class Solution {

    public int climbStairs(int n) {
        
			 // 采用 一维dp[] 就行
        // 因为是 第0阶,,,,到 第 n 阶 ，所以是求 n+1 个楼梯台阶，所以 dp[]数组长度是 n+1
            int[] dp = new int[n+1]; // dp[i] 代表的是，爬到第i阶 楼梯 有 dp[i]种 走法
          			
        // 初始化 dp数组，dp[0], 代表的是 第0层楼梯的走法是 0种方法。
        //   dp[1]代表的 第一层的台阶， 只有一种方法走上去，也就是 跨一次台阶 就行。。。
            dp[0]=1;
            dp[1]=1;
				
        		   	// for循环遍历计算dp[]数组，i从2 开始 遍历就行。
            for(int i=2;i<=n;i++){
							
                // 递推公式，dp[i]的状态是 dp[i-1] ， dp[i-1]  两者相加的和
                dp[i] = dp[i-1]+dp[i-2];  

            }
                return dp[n];
    }
    
}
```

### 62 不同路径

#### 动态规划基础

题目描述：

```
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

问总共有多少条不同的路径？

示例 1：

输入：m = 3, n = 2
输出：3
解释：
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右
3. 向下 -> 向右 -> 向下
```

题解：https://leetcode.cn/problems/unique-paths/solutions/856968/dai-ma-sui-xiang-lu-dong-gui-wu-bu-qu-xi-1vkb

```java
// 采用动态规划，很明显是需要 二维 dp[][]来解决‘
// 对于 每一个 矩阵的 格子，比如 dp[i][j]只能依赖 它的左边的格子 dp[i][j-1] 以及 它顶上的格子dp[i-1][j] 这两者之间的关系 。。。找出递推关系 ！！
// 然后的话，初始化dp[][]的时候，对于第一列 和第一行 要很容易想到 它们的每个格子 的 路径数只能是 1条路径！！！

class Solution {
    	
   public int uniquePaths(int m, int n) {
       
         // 这道题很明显就是要采用 二维dp[][]
        // dp[i][j]，代表的是 从最左上角[0,0] 走到 [i,j]格子，一共有 dp[i][j]种路径 
		int[][] dp = new int[m][n];  
       
       	
       // 初始化 dp二维数组。 第一行和第一列。每个值都是1 ，也就是 每个格子的，路径数目都是1 
       // 首先dp[i][0] 代表第一列。。因为从(0, 0)的位置到 第一列(i, 0)的任意一个格子，路径只有一条，也就是 只能一路向下走。。。
       // 那么dp[0][j]也同理。它就是 矩阵的 第一行，路径也只有一条 ，只能一路 向右走。。。
        
        for (int i = 0; i < m; i++) 
            dp[i][0] = 1;
        
        for (int i = 0; i < n; i++)
            dp[0][i] = 1;
        
    // 遍历计算dp 二维数组，遍历顺序采用的是 ，从上到下 ↓，从左往右→
       // 一般来说 初始化第一行，第一列之后，所以这里的 for循环 一般 都是 下标从 1 开始了。。。。
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
              
          //递推公式，很容易发现，，dp[i][j]，依赖左边的格子 dp[i][j-1] 和上边的格子的路径数 dp[i-1][j] 两者相加 ！！ 
   // 你这么想，对于左边的格子的路径数 dp[i][j-1]已经求出来了，那么 要去右边的当前格子dp[i][j]，其实就是往右边前进一格，所以 路径的个数 仍然可以复用。。同理  对于顶上的格子，也可以复用 路径个数。综上所述，就是  等于 它们的 路径和 ！！
       			 dp[i][j] = dp[i-1][j]+dp[i][j-1]; 
            }
        }
       					
          
        return dp[m-1][n-1];
       
   }
    
}
```



### 63 不同路径 II

#### 动态规划基础

题目描述：

```
给定一个 m x n 的整数数组 grid。一个机器人初始位于 左上角（即 grid[0][0]）。机器人尝试移动到 右下角（即 grid[m - 1][n - 1]）。机器人每次只能向下或者向右移动一步。

网格中的障碍物和空位置分别用 1 和 0 来表示。机器人的移动路径中不能包含 任何 有障碍物的方格。

返回机器人能够到达右下角的不同路径数量。

示例 1：
输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
输出：2
解释：3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右


```

题解：https://leetcode.cn/problems/unique-paths-ii/solutions/545893/63-bu-tong-lu-jing-iidong-tai-gui-hua-ji-6h8h

```java
// 也是要用 dp动态规划来做，很明显是 要用 二维dp来做的。！！！
// 这道题和 63 不同路径，主要就是区别在了，初始化dp[][]数组 和 遍历dp上的一些细节差异。。。
/** 
     因为有障碍物，所以 在初始化dp[][] 的 第一行和 第一列 的时候，有些不一样。。。
     而且 在for循环遍历dp[][]的时候，也要对 障碍物的格子进行判断 ！！
**/
class Solution {
    

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length; // 获取行数
        int n = obstacleGrid[0].length;  // 获取列数，对于二维数组，只能这么获取 
        
        // 定义dp数组，二维dp[][]
        //   dp[i][j]，代表的是 从最左上角[0,0] 走到 [i,j]格子，一共有 dp[i][j]种路径
        int[][] dp = new int[m][n]; 

        // 如果在起点或终点出现了障碍，直接返回 0，没有路径 可以走了。。。 “剪枝”
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) 
            return 0;
        
 //初始化dp数组。在for循环中间的判断 加上且 &&，这样遇到障碍物格子，在它之后的格子都不需要再赋值 1	
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) 
            dp[i][0] = 1;
        
        for (int j = 0; j < n && obstacleGrid[0][j]== 0; j++) 
            dp[0][j] = 1;
        
	// 遍历计算dp 二维数组，遍历顺序采用的是 ，从上到下 ↓，从左往右→
       // 一般来说 初始化第一行，第一列之后，所以这里的 for循环 一般 都是 下标从 1 开始了。。	
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {	
                
       // 就是要多加上这一行，要采用 递推公式的前提！！！肯定 是当前格子不是 障碍物，才可以使用   
              // 怎么思考递推公式  ！！？？ 
            //很容易发现，，dp[i][j]，依赖左边的格子 dp[i][j-1] 和上边的格子的路径数 dp[i-1][j] 两者相加 ！！ 
   // 你这么想，对于左边的格子的路径数 dp[i][j-1]已经求出来了，那么 要去右边的当前格子dp[i][j]，其实就是往右边前进一格，所以 路径的个数 仍然可以复用。。同理  对于顶上的格子，也可以复用 路径个数。综上所述，就是  等于 它们的 路径和 ！！   
                if(obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            
            }
        }
        
        return dp[m - 1][n - 1];
        
    }
}
```



### 64 最小路径和

#### 动态规划基础

题目描述：

```
给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例 1：
输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
输出：7
解释：因为路径 1→3→1→1→1 的总和最小。
```

题解：https://leetcode.cn/problems/minimum-path-sum/solutions/2728404/javapython3cdong-tai-gui-hua-kong-jian-y-a5sz/

```java
// 采用 dp 动态规划，而且很明显的话，要用 二维dp数组[][]
//  同样的，对于 每一个 矩阵的 格子，比如 dp[i][j]只能依赖 它的左边的格子 dp[i][j-1] 和 它顶上的格子dp[i-1][j] 这两者之间的关系 。。。找出递推关系 ！！


class Solution {
    public int minPathSum(int[][] grid) {
   

    int m = grid.length ;  // 获得矩阵的 行数
    int n = grid[0].length; // 获得矩阵的 列数
    
    		// dp[i][j] 代表的是，从[0,0] 到 [i,j] 下标的格子，最小的路径之和是 dp[i][j]
    int[][] dp = new int[m][n];	
    
    dp[0][0] = grid[0][0];	//  特殊处理左上角元素[0,0]
    
    		// 初始化 dp数组，第一列的每个格子dp[i][0]，都是 它顶上一个格子 + 自己格子的值
    for (int i = 1;i < m;i++) 
        dp[i][0] = grid[i][0]+dp[i-1][0];
    
				// 初始化 dp数组，第一行的每个格子，都是 左边一个格子 + 自己格子的值
    for ( int i = 1;i < n;i++) 
        dp[0][i] = grid[0][i] + dp[0][i-1];
    
		// 开始for循环遍历计算 dp数组，从上到下↓，从左往右→
      // 一般来说 初始化第一行，第一列之后，所以这里的 for循环 一般 都是 下标从 1 开始了。。。 
    for ( int i = 1 ; i < m ;i++) {
        for ( int j = 1;j < n;j++) {
            
     //dp递推公式。dp[i,j]依赖于，上面格子 和 下面格子的最短路径和的 最小值，再加上当前格子的值，就是当前格子 的最短路径和。
            dp[i][j] =  Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
        }
    }
    
   			 return dp[m-1][n-1];
    
}
}


```

### 300 最长递增子序列

#### 动态规划子序列

题目描述：

```
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的
子序列
。

 
示例 1：

输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
```

题解：https://leetcode.cn/problems/longest-increasing-subsequence/solutions/2279668/dai-ma-sui-xiang-lu-leetcode300zui-chang-sh5m

```java
// 这道题的话，子序列是指 "不连续"的 。。。
// 所以在用动态规划dp ，有点特殊的地方！就是还要多定义一个 for内循环，因为它依赖和 前面多个dp[]，不断比较。。

// 这里的答案不是 返回 dp数组的末尾下标[nums.length] ，而是定义一个 max第三者遍历，在遍历计算dp数组的时候，，需要不断更新比较的 ！！！


class Solution {
    
    public int lengthOfLIS(int[] nums) {
        
       // dp[i]是指， 以下标i为结尾的  最长递增子序列的长度是 dp[i]。。。
      //因为只有这么定义 dp[i]的 "含义" ！！才方便后面的 for遍历dp[]数组时候，递增比较的时候， 可以比较 nums[j] 和 nums[i] 的大小，边界很明确
        int[] dp = new int[nums.length];
        
      // 因为在下面的 for循环遍历计算dp[]的时候，是需要不断比较找到最大值的答案，所以定义 max   
        int max = Integer.MIN_VALUE;  // "子序列" 类型的dp，特殊之处 的地方
        							
        
        // 初始化 dp数组，每一个以i下标结尾的，因为对应的dp[i] 最长递增子序列长度 至少都是 1
        for(int i =0;i<nums.length;i++){
            dp[i]=1;
          	max =1; // 初始化dp的时候，也是比较 特殊的地方，还需要给 max赋值。。
        }
            
        
      //遍历顺序，当然是从前往后遍历→。这里少有的一维dp数组，还要用 双层for循环来遍历。主要原因是，这里是 "不连续"的递增子序列，也就是 挑选的两个元素中间，可以 空开的。所以就必须再弄一个内层for 循环，j每次都从0开始遍历到i-1，把前面的每一个下标 都和 当前的下标i对应的dp数组  比较一下，求最大值。
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                		
                // 必须在某个if 条件下！！才需要用 递推公式。
// j是在前面，下标i是在j的后面，所以 只有 大于的情况 nums[i] > nums[j] ，子序列才是递增的，才用递推公式更新 dp[i] 。因为是 大于，所以 肯定可以 dp[j]+1 ，再和 当前下标dp[i] 取最大值就可以了。
                if (nums[i] > nums[j]) 
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
              
                // 记得 每次都要拿 当前的格子dp[i] 和 max 比较，然后更新最大值 ！！
				max = Math.max(max,dp[i]);   // 也是特殊的地方。。。
        } 
            
        }
        
      // 为什么这里那么特殊？？不是去直接返回 dp[nums.length-1] ,而是for循环比较大小 返回 max
            
       // 因为dp[i]是指， 以下标i为结尾的  最长递增子序列的长度是 dp[i]，所以 其实并不是说        i=nums.length最后一个下标结尾的 最长递增子序列的长度 就是最大值，也可能是 前面某个下标结尾的  才是最大值  。。。。
            	
        return max; 
        
    }
}


```

### 674 最长连续递增序列

#### 动态规划子序列

题目描述：

```
给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。

连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。

 

示例 1：

输入：nums = [1,3,5,4,7]
输出：3
解释：最长连续递增序列是 [1,3,5], 长度为3。
尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。 
```

题解：https://leetcode.cn/problems/longest-continuous-increasing-subsequence/solutions/2279675/dai-ma-sui-xiang-lu-leetcode674zui-chang-3c7s

```java
//这道题 多加了条件，是"连续"的子序列，，，比 最长递增子序列(非连续) 简单一些。。。

// 使用动态规划去做，。。。这里的话 ，只需要定义一个 for 循环！！去遍历计算就行了，因为 当前的dp[i]只是和 前一个 dp[i-1] 有关系。。。。！！！

class Solution {
    public int findLengthOfLCIS(int[] nums) {

        // dp[i]是指， 以下标i为结尾的  最长递增子序列的长度是 dp[i] 。。
        int[] dp = new int[nums.length];
        
        
        	//  因为是需要不断比较找到最大值的答案，所以定义 max
         int max = Integer.MIN_VALUE; // 特殊之处 1 
        
        // 初始化 dp数组，每一个以i下标结尾的，因为对应的dp[i] 最长递增子序列长度 至少都是 1
        for(int i =0;i<nums.length;i++)	{
            	dp[i]=1;
            	max=1; // 特殊之处 2
        }
            
        
     //for遍历计算的 顺序，当然是从前往后遍历→ ！！而且只需要一个for循环就行了
    //因为这道题是 “连续”  的递增子序列，所以 dp[i] 只跟前一个状态dp[i-1]有关，只需要比较最大值就行了。。。
    // 之前的 那道题是 "非连续"的，所以还要定义一个 内循环，把 j= 0到 i-1的每一个dp[j] 和 当前的dp[i] 进行比较 。。。。。
        for (int i = 1; i < dp.length; i++) {
       			
        // 必须在某个条件下，才需要用递推公式。
// 所以 只有 大于的情况 nums[i] > nums[i-1] ，是递增的，才用递推公式更新 dp[i] 。因为是 大于，所以 肯定可以 dp[i-1]+1 ，然后和 当前下标dp[i] 取最大值就可以了。
                if (nums[i] > nums[i-1]) 
                    dp[i] = Math.max(dp[i-1]+1,dp[i]);
             
            
            //每次都记得 和 max 比较大小，然后要更新
   				max = Math.max(max,dp[i]);  // 特殊之处 3 
        }
        

        return max;  // 特殊之处 4 
 
    }
}
```



### 718 最长重复子数组

#### 动态规划子序列

题目描述：

```
给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。

 

示例 1：

输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
输出：3
解释：长度最长的公共子数组是 [3,2,1] 。
```

题解：https://leetcode.cn/problems/maximum-length-of-repeated-subarray/solutions/853065/dai-ma-sui-xiang-lu-718-zui-chang-zhong-rowbh/  主要是看这个dp二维数组 怎么画出来的，对应格子的含义。

这里看的是 版本二

```java
// 子数组是 “连续”的 ，所以相对简单点~~~~
// 采用动态规划来做。很明显是两个数组，要采用 二维dp[][]

class Solution {
    
    public int findLength(int[] nums1, int[] nums2) {
        
        		//这里定义就是 按照两个数组的长度，定义 dp 二维数组 
     //dp[i][j]是指，表示在nums1中以下标 i 为结尾，nums2中以下标 j 为结尾的最长重复子数组长度是dp[i][j] 	
        	int m = nums1.length;
        	int n = nums2.length;
     		int[][] dp =new int[m][n];
        
     		int max=Integer.MIN_VALUE;  //  这里同样是需要不断的比较最终答案的。。。所以定义max
        
// 初始化dp数组 第一列。当j=0,也就是固定nums2 的下标为0 的那个子数组，然后遍历 nums1。
              for(int i=0;i<m;i++){
                  if(nums1[i]==nums2[0]){
                      dp[i][0]=1;
                      max=1; //特殊之处
                  }
              }
        
      // 同理，初始化dp数组的第一行，也就是固定nums1 的下标为0 的那个子数组，然后遍历 nums2。
              for(int i=0;i<n;i++){
                  if(nums2[i]==nums1[0]){
                       dp[0][i]=1;
                       max=1; //特殊之处
                  }
              }
        
     // for循环遍历顺序，当然是从上到下↓，从左到右→，因为已经对第一列和第一行遍历过了，所以i和j都是从下标1 开始遍历。。 
        		// 外层遍历的是 nums1中的元素 。。。
             for(int i=1;i<m;i++){
                    // 内层遍历的是  nums2数组中的元素 。。
                 for(int j=1;j<n;j++){
                     
  // 只有 nums1的 i下标 和 nums2的j下标指向的 两个元素相等，才会采用递推公式，去更新计算dp！！
      //dp[i][j] 当前格子，依赖前面的状态，所以就看 这两个数组nums的 分别的前一个元素也就是 nums1数组的 i-1和 nums2数组j-1，对应的 dp[i-1][j-1]值，最长重复子数组的长度是多少，然后加 1 就行了。。。就是 dp数组[][] 里面，2*2格子“斜着” 左上角那个值 。。。
                     if(nums1[i]==nums2[j])
                    	 dp[i][j]= dp[i-1][j-1]+1;
                     
                     //每次都记得 和 max 比较大小，然后要更新
                     max=Math.max(dp[i][j],max); //特殊之处
                     
                 }
             }
        
                 // 这里也是返回max，而不是 dp[][]二维数组的最末尾的下标
      // 因为不一定以最末尾的 两个数组的 nums1 和 nums2的，它的dp格子值，才是最长的 
             return max;  //特殊之处
    }
}
```





### 1143 最长公共子序列

#### 动态规划子序列

题目描述：

```
给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。

一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。

例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。

 

示例 1：

输入：text1 = "abcde", text2 = "ace" 
输出：3  
解释：最长公共子序列是 "ace" ，它的长度为 3 。
```

题解：https://leetcode.cn/problems/longest-common-subsequence/solutions/276495/java-dong-tai-gui-hua-tu-wen-jie-xi-by-sdwwld/?envType=study-plan-v2&envId=top-100-liked

```java
// “非连续”的子序列 ，也就是 选择两个元素之间可以空开。。。所以判断条件稍微复杂一点。。。
//   采用dp动态规划来做。很明显是 两个 字符串，要采用 二维dp[][]

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int m = text1.length();
        int n = text2.length();
        
        //这里定义就是 按照两个数组的长度，定义 dp 二维数组 [][]
     //dp[i][j]是指，表示在nums1中以下标 i 为结尾，nums2中以下标 j 为结尾的最长公共子数组的长度是dp[i][j] 
        int[][] dp = new int[m][n];
        
        
        //  这里同样是需要不断的比较最终答案的。。。所以定义max ..这里比较特殊， 所以要定义成 0，
        //  因为如果不存在公共子序列，那么最大值就是 0 。。。而不是 Integer.MIN_VALUE，那么就是 -2738993234234。。。。。。了
        int max = 0;   


     // 初始化dp[][]的 第一行，也就是 text1固定 第一个字符，然后去匹配 text2字符串的 各个字符 
        for (int i = 0; i < m; i++) {
            
            if (text1.charAt(i) == text2.charAt(0)) {
                dp[i][0] = 1;
                max = 1;
       // 这里为什么要加上  内部的for循环。。。可以这么理解。。此时固定的只有一个 text1的 第一个字符，只有一个字符，也就是说 最长公共子序列最多就是1！！所以当我们找到 charAt(i) ==的时候， 对于 i 之后的 i+1,i+2....直到末尾字符，它对应的 dp[][] 格子值最多就是 1 。。
                // 而且有因为这里是 "非连续"的子序列，也就是 后面的字符 哪怕是不连续的，也可以沿用前面的 已经存在的 最大公共序列长度
             
                for(int k=i;k<m;k++)
                    dp[k][0]=1;
                
                break;
            }
            
        }

     // 初始化dp[][]的 第一列，也就是 text2固定 第一个字符，然后去匹配 text1字符串的 各个字符
        for (int j = 0; j < n; j++) {
            
            if (text2.charAt(j) == text1.charAt(0)) {
                dp[0][j] = 1;
                max = 1;
                
                for(int k=j;k<n;k++)
                    dp[0][k]=1;
                break;
            }
            
        }

        
        // for遍历计算的 顺序，当然是从上到下↓，从左到右→，因为已经对第一列和第一行遍历过了，所以 i 和 j 都是从下标 1 开始遍历。。   
        
        //   外循环 遍历的是 text1的 各个字符 
        for (int i = 1; i < m; i++) {
            // 内循环 遍历的是 text2的 各个字符 
            for (int j = 1; j < n; j++) {
                
  // 只有 text1的 i下标 和 text2的 j下标指向的 两个字符 相等，才会采用递推公式，去更新计算dp！！
      // dp[i][j] 当前格子，依赖前面的状态，所以就看它们的前一个元素 dp[i-1][j-1]值， 最长公共子数组的长度是多少，然后加 1 就行了。。就是 dp数组[][] 里面，2*2格子“斜着” 左上角那个值 。。。
                if(text1.charAt(i)==text2.charAt(j))
                    dp[i][j]=dp[i-1][j-1]+1;
                
                else
            // 否则的话，如果 在 两个text 字符串的 指向的 字符 它们不相等。。
    //  那么，要么就是  text1 退前面一个字符，也就是 i-1对应的那个 dp[i-1][j]值，保存的最长公共子数组的长度。。或者是  text2 退前面一个字符，也就是 j-1对应的那个 dp[i][j-1]值，保存的最长公共子数组的长度 。。所以是取 两者的最大值就行 ！！！
                    dp[i][j]=Math.max(dp[i -1][j],dp[i][j -1]);
                
                  //每次都记得 dp[i][j]和 max 比较大小，然后要更新 max
                max = Math.max(dp[i][j], max);
            }
        }

        
        // 这里也是返回max，而不是 dp[][]二维数组的最末尾的下标
      // 因为不一定以最末尾的 两个数组的 text1 和 text2 的，它的dp格子值，才是最长的 
        return max; //特殊之处 
    }
}
```



### 53 最大子数组和

#### 动态规划子序列

题目描述 ：

```
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

子数组
是数组中的一个连续部分。

 

示例 1：

输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
示例 2：

输入：nums = [1]
输出：1
```

题解：https://leetcode.cn/problems/maximum-subarray/solutions/847114/dai-ma-sui-xiang-lu-53-zui-da-zi-xu-he-b-xqus

```java
//   这道题 我采用的是 dp动态规划去做 。。。一维 dp数组[] 就行
//   子数组是 --->“连续”的 ，所以就只要 定义一个 for循环去遍历计算 dp就行了。。

class Solution {
    
    public int maxSubArray(int[] nums) {
            
      //dp[i]是指，表示在nums中以下标 i 为结尾 的最大子数组长度是dp[i]  
        int[] dp = new int[nums.length];
        
        int max = nums[0];  //因为这道题的话，求的是最大子数组和，不一定是 数组的最后一个下标为结尾的，所以要逐个比较遍历 dp[i]数组 和 max，得出最终的答案。。
        // 这里 max初始值是 nums数组的第一个元素nums[0] 
        
        
        // 初始化dp数组，dp[0]默认就是一个nums元素
        dp[0] = nums[0];
        
        
        // 遍历顺序。很容易想到，dp[i]是依赖与 前面的状态i-1，那么就是从左往右 →
        for (int i = 1; i < nums.length; i++) {
            
            // 递推公式，就是  和前面状态dp[i-1]加上当前遍历的 数组元素nums[i]，再和 当前的nums[i] 的元素比较。。。哪个更大，再赋值计算给 dp[i]当前的格子
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            
            // 记得 每次算出来的 dp[i]格子值，要和 max比较大小，然后继续更新 
            max = Math.max(max,dp[i]); //特殊之处
            
        }
        
        
          // 这里也是返回max，而不是 dp[]数组的最末尾的下标
      // 因为不一定以最末尾的 数组的它的dp格子值dp[nums.length]，才是最大的。。。 
        return max; // 特殊之处 
    }
}
```



### 198 打家劫舍

#### 动态规划打家劫舍

题目描述：

```
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

 

示例 1：

输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。
```

题解：https://leetcode.cn/problems/house-robber/solutions/994214/dai-ma-sui-xiang-lu-dai-ni-xue-tou-dong-ezvt3

```java
//  使用dp动态规划来做。。主要是用 一维dp数组[] 


class Solution {
	public int rob(int[] nums) {
        
	// 这里是"剪枝“，如果长度为 0 那么小偷能偷的就只有  0 金额。
        // 如果 长度为 1，那么小偷能偷的 就只有 第一个房间的 金额
        if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
        
		
   // dp[i] 是指，考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为 dp[i] 
		int[] dp = new int[nums.length];
        
        // 初始化dp数组。
		dp[0] = nums[0];// dp[0] 一定是 nums[0]
		dp[1] = Math.max(nums[0], nums[1]);// dp[1] 肯定是 nums[0]和nunms[1] 中的最大值 
               
        
        // for循环遍历计算 的顺序 。依赖前面的状态，所以是 从前往后→。
		for (int i = 2; i < nums.length; i++) {
            
           /** 
     如果偷第i房间，那么dp[i] = dp[i - 2] + nums[i]，因为题目规定 相邻的第i-1 房间 一定是不能偷的，找出 下标i-2（包括i-2）以内的房屋，最多可以偷窃的金额为dp[i-2] 加上第i房间偷到的钱。

	如果不偷第i房间，那么dp[i] = dp[i - 1]，也就是只偷 第i-1房间 

	然后dp[i]取这两个情况的最大值就行。。。
				**/
            
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}

		return dp[nums.length - 1];
        
	}
}
```



### 213 打家劫舍 II

#### 动态规划打家劫舍

题解：https://leetcode.cn/problems/house-robber-ii/solutions/723062/dai-ma-sui-xiang-lu-213-da-jia-jie-she-i-o4gb

```java
 /**
       	
       这道题 II ，房间环形排列 意味着 第一间 和 最后一间 不能同时选择，所以我们可以分成两种情况来讨论：
       	1、不偷窃最后一间房间，那么问题转化为 偷窃下标0 到 最后 length-2 末尾房间 所能获得的最高金额。
		2、不偷窃第一间房间，那么问题转化为 偷窃下标1 到 length-1 号房间 所能获得的最高金额。
		
		两种情况中取最大值，这样我们就把 环形问题 转化为了 两个单排列的 子问题。    
  
**/

class Solution {
    
    public int rob(int[] nums) {
        
  		// 这里是"剪枝“，如果长度为 0 那么小偷能偷的就只有  0 金额。
        // 如果 长度为 1，那么小偷能偷的 就只有 第一个房间的 金额
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        
   // copyOfRange() 方法，传入 nums数组下标范围的 新数组，可以直接调用下面的 打家劫舍I的代码
        	// 这个方法是不包括 右边界的。。。
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)), 
                        myRob(Arrays.copyOfRange(nums, 1, nums.length)));
        
    }
    

    
    // 就是打家劫舍 I 的代码，作为了 次函数，方便 上面主函数 去调用。。。
    public int myRob(int[] nums) {
        
 // 主要是为了防止主函数传入的数组，长度为 0 或者 1，导致后面的初始化，dp[0],dp[1] 下标越界
         if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		
   // dp[i] 是指，考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为 dp[i] 
		int[] dp = new int[nums.length];
        
        // 初始化dp数组。
		dp[0] = nums[0];// dp[0] 一定是 nums[0]
		dp[1] = Math.max(nums[0], nums[1]);// dp[1] 肯定是 nums[0]和nunms[1] 中的最大值 
         
        
        
         // for循环遍历计算 的顺序 。依赖前面的状态，所以是 从前往后→。
		for (int i = 2; i < nums.length; i++) {
            
           /** 
     如果偷第i房间，那么dp[i] = dp[i - 2] + nums[i]，因为题目规定 相邻的第i-1 房间 一定是不能偷的，找出 下标i-2（包括i-2）以内的房屋，最多可以偷窃的金额为dp[i-2] 加上第i房间偷到的钱。

	如果不偷第i房间，那么dp[i] = dp[i - 1]，也就是只偷 第i-1房间 

	然后dp[i]取这两个情况的最大值就行。。。
				**/
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}

		return dp[nums.length - 1];
        
	}
    

}

```







### 416 分割等和子集

#### 动态规划01背包

题目描述

```
给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

 

示例 1：

输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。
```

题解：https://leetcode.cn/problems/partition-equal-subset-sum/solutions/553978/bang-ni-ba-0-1bei-bao-xue-ge-tong-tou-by-px33/?envType=study-plan-v2&envId=top-100-liked  只看 下面 二维dp的代码

```java
// 01背包来做，动态规划dp ，这里选用的是 二维dp数组
//  这道题目是要找 是否可以 将这个数组分割成  两个子集，使得两个子集的元素和相等。
// 那么只要找到数组里能够出现 sum/2 的子集总和，就说明 该数组可以分割成两个子集 元素和相等了。sum是这个数组的总和。

// 但是注意 ！！！ sum必须是偶数，也就是整个数组的所有元素之和 必须是 偶数，才会找到答案 。。
 

/**
	 这里就假设，背包的容量为 sum/2 作为 bigSize，
     背包要放入的物体重量为 元素的数值，这里的 价值 概念是有点模糊的。。。
      背包如果正好装满，说明找到了总和为 sum / 2 的子集。
      背包中每一个元素是不可重复放入。
**/



public class Solution {
    
    public  boolean canPartition(int[] nums) {
        
        
		// sum先累加 nums数组的总和，然后记得 sum/2 作为 01背包的容量 bigSize。
        int sum = 0;
        
        for (int i=0;i<nums.length;i++) {
            sum += nums[i];
        }
        
        // ”剪枝”，特殊判断，如果是奇数，那么就没有 两个子集的和 相等  的说法，就不符合 题目要求
        if ((sum %2 ) != 0) {
            return false;
        }

        
        // 目标 01背包容量
        int bigSize = sum / 2; 
        
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        /*
      dp[i][j]，表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，是否可以 使得这些数的和恰好等于 j ，用boolean来表示
        */
        boolean[][] dp = new boolean[nums.length][bigSize + 1];

        //  初始化 dp数组 ，对于第一列的话，就是指dp[i][0],当 bigSize=0的时候，其实 又因为 nums数组里面，每一个数都是正数，那么 是不可能选取一些数，它们的和 等于 0 的。。。所以它们的格子false
        
 //初始化 dp数组 ，对于第一行的话，只从0 到 0区间的元素选取，其实就是 选这一个 nums[0] 元素。
  // 只有当 第一个物品的重量 (nums元素值)小于等于 目标容量bigSize，那么就让 容积为它自己的背包  恰好装满， 设置为 true
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        
		// dp循环计算 遍历顺序，从左到右→，从上到下↓
        //外层for遍历 物品，这里就是 每一个 数组nums[i]的元素
        for (int i = 1; i < nums.length; i++) {
            //内层for遍历  背包，就是 bigSize， 总和的一半 sum/2
            for (int j = 0; j <= bigSize; j++) {
                 
   // 如果如果物品i的重量 大于 背包的容量j，就说明肯定不能把它放入背包。。只能沿用 上一层的也就是[0, i-1] 这个子区间的元素，dp值
                if(nums[i]>j)
                	dp[i][j] = dp[i - 1][j];

                //如果如果物品i的重量 恰好就等于 背包的容量j，那么也是满足条件的，就设置true
                else if (nums[i] == j) 
                    dp[i][j] = true;
             
                
                //如果物品i的重量 小于背包的容量j，那就可以看该物品 是否放入 背包 ：
     //如果该物品i 不放入背包，如果在 [0, i-1] 这个子区间内已经有一部分元素，使得它们的和为j，那么就是 dp[i-1][j]=true
                
    // 如果该物品放入背包，如果在 [0, i-1] 这个子区间内已经找到一部分元素，使得它们的和为j-nums[i]。 那么就是 dp[i - 1][j - nums[i]]，为true
                //  这两种情况，求个 或 || 
                else if  (nums[i] < j) 
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                
            }
        }

        return dp[nums.length-1][bigSize];

    }


}


```



### 494 目标和

#### 动态规划01背包

题目描述：

```
给你一个非负整数数组 nums 和一个整数 target 。

向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：

例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。

 

示例 1：

输入：nums = [1,1,1,1,1], target = 3
输出：5
解释：一共有 5 种方法让最终目标和为 3 。
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
```

题解：https://leetcode.cn/problems/target-sum/solutions/2898133/zhi-cuo-jiu-gai-zhe-ci-cong-er-wei-dpdao-vi4j/

```java
/** 将数组(元素均正数)分成两个子集， left子集 和 right子集：


设数组的和为 sum，  left子集的和为 left，right子集的和为 right
根据上面的分析，我们可以得出： left + right = sum (1)
同时有： left - right = target (2)
将(1)式与(2)式相加，可以得到： 2left = sum + target (3)


即：left = (sum + target) / 2 ，因为sum就是整个数组的和 是固定的，target也是题目中给出来的，也是固定的，所以我们找到了 固定的值，作为01背包的固定容量。原问题 可以转化为--> 0-1背包问题：

每个物品(也就是数组中的元素)的重量为 nums[i]， 背包的容量 bigSize 为(sum + target) / 2，问：有多少种方式将背包【恰好填满】

**/

class Solution {
    public int findTargetSumWays(int[] nums, int target) {

       
		// 先求出 整个数组nums的 总和
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        //  !!注意点1.   
      //   如果 target大于 sum，根据上述等式计算出来的 bigSize = (sum + target) / 2会大于sum，这在实际情况中是不合理的。因为 bigSize 是从数组nums中的元素组成的和，它如果 超过 数组元素总和sum，那么是 无解的
        if(sum < Math.abs(target)){
            return 0;
        }

        
           //  !!注意点 2. 
        //  如果所求的背包容量 bigSize 不是整除，结果是小数，那么 整数 数组的nums里的任何元素 自然是没有办法凑出这个小数的 
        if((sum + target) % 2 != 0) {
            return 0;
        }

        
        		// 01背包的 容量 
        int bigSize = (sum + target) / 2;
        
        // dp[i][j]：使用 下标为[0, i]的nums[i]能够凑满背包容量j，有dp[i][j]种方法。
        int[][] dp = new int[nums.length][bigSize + 1];

        // 初始化dp，第一行..
      // dp[0][0]的值，代表的是，对于 第0个物品，装满背包容量为0，就是不放它 ，那么 就有1种方法
        /**
           dp[0][j]：只放物品0， 把容量为j的背包填满有几种方法。
             只有当 背包容量为物品0 的容量 的时候，方法为1，正好装满。
            其他情况下，要不是 装不满，要不是装不下。
            所以初始化：dp[0][nums[0]] = 1 ，其他格子 均为 0  
**/
        if (nums[0] <= left) {
            dp[0][nums[0]] = 1;
        }
        
        

        // 初始化dp数组的第一列
    // 当从nums数组[0,i]的部分有n个0时，每个0可以取+/-，因此有2^n种方法 可以放到背包容量 0
        // 所以这里 额外定义了个 numZeros，代表 0的数量。
        int numZeros = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                numZeros++;
            }
            dp[i][0] = (int) Math.pow(2, numZeros);
        }

        
        // for循环遍历计算 顺序：从左到右→，从上到下↓
        // 当nums[i] > 背包容量j时，这时候nums[i]一定不能取，所以是dp[i - 1][j]种方案数
        
        // nums[i] <= j时，第i个数字 可放可不放：
        /**
        1.选择将第i个数字放入，此时，数字还剩i - 1个，背包的容量需要减去nums[i]。递推式为
dp[i][j] = dp[i - 1][j - nums[i]]；
		2.选择放弃第i个数字，背包的容量不变，直接从 [0,i-1]区间里面选择。递推式为dp[i - 1][j]
	**/
        for(int i = 1; i < nums.length; i++) {
            for(int j = 1; j <= left; j++) {
                
                if(nums[i] > j) 
                    dp[i][j] = dp[i - 1][j];
                 else 
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                
            }
        }

        return dp[nums.length - 1][left];
        
    }
}
```



### 121 买卖股票的最佳时机

#### 贪心

题解：

```java

```

### 122 买卖股票的最佳时机 II

#### 贪心

题解：

```

```





## 字符串

### 344 反转字符串

#### 双指针相向指针

题目描述：

```
编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。

不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

 

示例 1：

输入：s = ["h","e","l","l","o"]
输出：["o","l","l","e","h"]
```

题解：[https://leetcode.cn/problems/reverse-string/solutions/792118/shuang-zhi-zhen-jiao-huan-wei-zhi-by-dag-fnvf/](https://leetcode.cn/problems/reverse-string/solutions/2376290/ji-chong-bu-tong-de-xie-fa-pythonjavacgo-9trb/)

```java
// 因为要求 “原地”修改，  所以可以用 双指针来解决。。
// 两个左、右指针left 和 right ，每次相互交换值，然后再向中间靠拢就行。

class Solution {
    public void reverseString(char[] s) {
		
        //  用的是  双指针的相向指针  一个在最左端 left  ，另一个在 最右端 right   
        int left = 0;
        int right =s.length-1;
		
        while(left < right){
				
              //  常见的 二值交换的 固定代码，就是这么 3行 ！！！
            char temp = s[right];
            s[right] = s[left];
            s[left]  = temp;
            
            left++;
            right--;

        }

    }
}
```

### 151 反转字符串中的单词

#### 暴力

题目描述：

```
给你一个字符串 s ，请你反转字符串中 单词 的顺序。

单词是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。

返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。

注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。

示例 1：

输入：s = "the sky is blue"
输出："blue is sky the"

示例 2：

输入：s = "  hello world  "
输出："world hello"
解释：反转后的字符串中不能存在前导空格和尾随空格。

示例 3：

输入：s = "a good   example"
输出："example good a"
解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
```

题解 ： [https://leetcode.cn/problems/reverse-words-in-a-string/solutions/195397/151-fan-zhuan-zi-fu-chuan-li-de-dan-ci-shuang-zh-2/](https://leetcode.cn/problems/reverse-words-in-a-string/solutions/195397/151-fan-zhuan-zi-fu-chuan-li-de-dan-ci-shuang-zh-2/)

```java
// 先删除首位空格
// 再根据 空格进行分割 字符串，得到 String[] 数组 
// 从末尾遍历，反转字符串
// 通过 StringBuilder的apend()每次添加 字符串 
class Solution {
    
    public String reverseWords(String s) {
        							 
        // 1.先trim() 删除首尾空格，然后按照空格 " " 去分割字符串 split()
        // 这种情况 分割的话 ， 每个单词之间 的 空格个数 比较多，那么 如果 之间有 3个空格 ，   比如，"I am   happy"，会多会分割产生2个 空字符串["I","am","","","happy"]，所以采用" +"方式，就可以避免这样的问题 ！！！
	
        String[] strs = s.trim().split(" +"); 
        	
        // 用于存储最终的结果 res ，不断添加 append()
        StringBuilder res = new StringBuilder();
        
       // 2.“倒序”遍历单词列表，然后 再插入 。 那么 i的初始值 就是 length-1 。  这种方法很“特殊”！！
       // 从数组的 最后面 开始 遍历。。。
        for(int i = strs.length - 1; i >= 0; i--) { 
              
            res.append(strs[i] + " "); 
       
        }
        
       			
         
        // 3. 为什么还要 删除尾部空格？因为 添加 最后一个单词 的时候 它还会多 添加一个 空格  
        return new String(res).trim();
    }
}
```



### 3 无重复字符的最长子串 

#### 滑动窗口

#### 哈希表map

题目描述：

```
给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。

示例 1:

输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```

题解：

https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/572876/shua-chuan-lc-shuang-zhi-zhen-ha-xi-biao-q08m/ 

```java
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            //创建哈希表,用来存储 字符串中 的每个 字符，出现的 次数 ，为了统计 “重复”
            HashMap<Character,Integer>map=new HashMap<>();

            //定义滑动窗口的左右指针，left和right ,默认都从 0开始  
            int left=0;
            int right=0;

       // result 用于保存 最终结果，求的是 子串的最大长度。所以这里默认就是 Integer.MIN_VALUE，用于之后的比较和更新
            int result=Integer.MIN_VALUE;

            while(right<s.length()){
                    // 右指针的话就是 对扫描过的 字符，不断进行 出现次数的累加，也就是“添加”元素
                map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);

        // 因为是套 代码模板的，这道题是 求最“长” 。 所以内层的 while循环 就必须 是  不满足题目条件才触发
          // 题目要 不重复字符，所以 不满足 不重复，翻译过来就是 => 要有重复字符 的时候                	// 所以就是 字符出现次数大于1，那么就是 get(right)>1 

                while(map.get(s.charAt(right))>1){

      // left左指针仍然是 向右移动，缩小窗口，那么就要对扫描过的字符 的出现次数 -1 ，也就是“移除”元素
                     map.put(s.charAt(left),map.get(s.charAt(left))-1);
                     left++;

                }

      // 外层while循环的下面，这里就是 满足题目条件的，才去 不断比较，更新最终结果 result

                result  = Math.max(result,right-left+1);

                // 滑动窗口的右指针 向右移动，right++
                right++;
            }

             // 如果result没有被赋值的话，就返回0，说明 没有符合条件 的子数组 
           return result==Integer.MIN_VALUE?0:result; 
        }
    }
```

### 76 最小覆盖子串 

#### 滑动窗口

#### 哈希表map

题目描述：

```
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

注意：

对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
如果 s 中存在这样的子串，我们保证它是唯一的答案。

示例 1：

输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
示例 2：

输入：s = "a", t = "a"
输出："a"
解释：整个字符串 s 是最小覆盖子串。
示例 3:

输入: s = "a", t = "aa"
输出: ""
解释: t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。
```

题解 ：

https://leetcode.cn/problems/minimum-window-substring/solutions/9349/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-1-3/

```java
//  采用 “滑动窗口”的思路
// 先要对 遍历字符串 t，先初始化 每个字符的 出现次数，通过 map 实现
//  然后才是 对字符串s 进行"滑动窗口"，添加元素，减少元素。。-->这里就是对 map的 value值-1和 +1

/**主要就是 如何 判断 当前“窗口” 扫描到的 子串 已经包含 字符串t ？？？？
  
  循环遍历整个map的key ，通过 判断 map 所有的 value<=0 了，这样才说明包含了 字符串t，找到一个 子串。
 
**/  

class Solution {
    
public String minWindow(String s, String t) { 
    
    
    Map<Character, Integer> map = new HashMap<>();
    
    // 1. 遍历字符串 t，先初始化 每个字符的 出现次数。
    // 这里主要是为了 之后的 right 右指针扫描 s 字符串的时候，不断“添加”元素进去，所以 每次扫描到一个字符，如果存在于 map，就得 出现次数 -1 。。。
    // 这主要是  为了判断 S 扫描的子串， 是否包含的 字符串t 
    for (int i = 0; i < t.length(); i++) {
        char char_i = t.charAt(i);
        map.put(char_i, map.getOrDefault(char_i, 0) + 1);
    }
    
     // 滑动窗口的 左、右指针
            int left = 0;
            int right = 0;

        // 为什么这道题要定义这个 ans_ 版本 的 左、右边界？因为 这道题是 找最小子串 进行返回。  题目  要求 返回一个 字符串String ，知道 边界的话，比较好返回。

            int ans_left = 0; //保存最小子串 的左边界
            int ans_right = -1; //保存最小子串 的右边界 ,这里很奇怪，为什么是 -1 ?
    //子串的右边界初始化为-1，是因为我们在 找不到 符合的子串 时候，要返回 空字符串 "" 。恰好在返回substring(0,-1+1)， 什么都没截取到（0,0）就是一个空字符串 ""
     
  
    int ans_len = Integer.MAX_VALUE; //当前最小窗口的长度，需要不断地更新比较，重新赋值。所以初始化成  整数 的最大值。
    
    //2.遍历字符串 s，“滑动窗口”的 模板 。。每次记得要去调用下面的 match()判断，扫描的子串 是否已经包含 字符串t了。
    while (right < s.length()) {
        
		// 特殊的地方！！！！
   //这里对 right 右指针扫描，“添加”元素的操作--> 其实就是对 每个字符的 value出现 减去 1  。
        // 要先 if判断 map 中是否 包含 当前字符 !!! 只有 包含 的情况下，才能执行 -1操作 ！！ 
        if (map.containsKey(s.charAt(right))) {
			
            map.put(s.charAt(right), map.get(s.charAt(right)) - 1);  

         // 这里的话，if 的内部，都要立即 进行 while()的循环判断
     // 也就是 调用 下面定义的次函数 match() 判断，是否  已经“全部包含” ，看看有没有  已经全部  包含 所有t字符串的字母
        //如果当前窗口的子串包含了 所有字母，就进入循环
        //开始移动 左指针left ，减小窗口
    
            while (match(map)) { 
               
       // 这道题的话，就必须这样更新和 比较 最小值 ans_len ，而不是Math.min()！！！
    // 因为只有 得到更小的 ans_len 时候，我们才要对 ans_的左、右边界 进行更新！！！
                if (right-left+1 < ans_len) {
                    ans_left = left;
                    ans_right = right;
                    ans_len = right-left+1;
                }
                
          
            // 接下来就是滑动窗口 左指针left 向右边移动，执行“移除”操作     
         //判断 map 中是否有当前字母,有的话，才能进行 “移除”，所以这里的 if判断 是 必要的！！！
                
                if(map.containsKey(s.charAt(left))) {
   // 因为要把当前字母“移除”-->所有相应次数要加 1 。这个 加1 就是和之前的右指针的操作  “反”一下
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                }

                left++; // 左指针left 右移
            }
        }

        //右指针右移，扩大窗口
        right++;
    }

                
        return s.substring(ans_left, ans_right+1);
    
}

    // 3.下面定义一个  函数 ---> 这主要是  为了判断 滑动窗口内的字符串， 是否包含的 字符串t 
// 通过 判断 map 所有的 value<=0 了，这样才说明包含了 字符串t，找到一个 子串。
private boolean match(Map<Character, Integer> map) {
    for (Integer value : map.values()) {
        if (value > 0) {
            return false;
        }
    }
    return true;
}
    
    
}
```



### 242 有效的字母异位词

#### 哈希表map

题目描述：

```
给定两个字符串 s 和 t ，编写一个函数来判断 t是否是s 的字母异位词。


示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
```

题解 ：

https://leetcode.cn/problems/valid-anagram/solutions/493377/hashmapchang-gui-si-lu-by-clint/

```java
// 如何判断 两个字符串 是不是  字母异位词 ？？？
// 首先就是 它们的长度是一样的。
// 其次就是，它们包含的 每个字符个数 都是一样的。。。

// 思路就是 先遍历 s字符串的字符 出现次数。。用 map 集合 去累加。。。然后 遍历 字符串t ，对之前的 map集合出现过的字符 响应的if判断操作 。。。。

class Solution {
   public  boolean isAnagram(String s, String t) {

        int len1 = s.length(), len2 = t.length();

   	//  这行必须加！！！  因为 你下面的这个 map计数的方法，以及里面的判断，必须是 长度相等才行
       // 其实也就是 ”剪枝“ 。。。。
        if (len1 != len2)
            return false;
       

			// 用于统计 字符串中的 每个字符 的出现次数 
        HashMap<Character, Integer> dic = new HashMap<>();

       
       // 上面的这个 for循环，先去统计 s字符串， 每个字符的出现次数
        for (int i = 0; i < len1; i++) {
				//  put() 和 getOrDefault()一起使用，更新累加
            dic.put(s.charAt(i) , dic.getOrDefault(s.charAt(i), 0) + 1);
        }

       
       	// 下面的这个 for循环，去遍历 t字符串的！！！！
        for (int i = 0; i < len2; i++) {
            
             // 如果 s字符串的这个字符，存在 之前的map集合，那么对 出现次数 -1 操作。。。
     // 并且内部还要if判断，此时的 出现次数 小于0 了吗，小于的话就说明 这两个字符串s和t 的字符出现次数不一致 。。。就不是 字母异位词 ！！return false 
            if (dic.containsKey(t.charAt(i))) {
                
                dic.put(t.charAt(i), dic.get(t.charAt(i)) - 1);
                if (dic.get(t.charAt(i)) < 0)
                    return false;
            }
            
            // 如果这个字符都不存在 字符串s中，那么直接 return  false;
            else
                return false;
        }

			// 其余情况，那么就是 字母异位词 。返回true 
        
        return true;
    }
}
```

### 20 有效的括号

#### 栈

题目描述：

```
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。
 

示例 1：

输入：s = "()"

输出：true

示例 2：

输入：s = "()[]{}"

输出：true
```

题解 ：[https://leetcode.cn/problems/valid-parentheses/solutions/1737575/by-carlsun-2-ij1t/](https://leetcode.cn/problems/valid-parentheses/solutions/1737575/by-carlsun-2-ij1t/)

```java
// 首先！ 明确本题  正确 的 字符串是怎么样的 ----> 比如 ()(){}[]()  或 [({})] 
//  比如常见的错误  ----> (] 或 (( 或者 ))

			
//这道题 用 “栈” 的思想 ！！！
/**
   主要思想，在匹配左括号{的时候，我们是把 它的右括号}先入栈。如果 当遇到 字符串中的右括号的时候， 比如 } ，看看它和 栈顶的元素是否相等，相等就说明匹配，那么就把栈顶元素出栈，一直这样循环比较，出栈入栈
**/
class Solution {
    public boolean isValid(String s) {
       	
            // “剪枝”。字符串的个数的判断，如果是 匹配字符串，那肯定是偶数。
              if (s.length()%2!=0)
                return false;
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            
            char ch = s.charAt(i);
            
            //碰到 左括号，就把相应的 "右"括号 入栈 ！！ 这样的 “反向”思路更好理解  
          
            if (ch == '(') 
                stack.push(')');
            
            else if (ch == '{') 
                stack.push('}');
            
            else if (ch == '[') 
                stack.push(']');

            
           
      //第一种情况：遍历字符串匹配的过程中，栈已经 为空了，说明只剩下右括号 之类的，它没有找到对应的左括号 再去匹配了,所以return false 。比如 ([])) ，最后的 )匹配不了了 
            
      //第二种情况：遍历字符串匹配的过程中，栈不为空，发现栈里没有我们要匹配的字符,所以return false 。比如 ([]}, (和 } 匹配不了
            
           
            else if (stack.isEmpty())
                return false;
            
            else if(stack.peek() != ch)
                return false;
                
  // 其余的情况就是，右括号 和 "栈顶"元素 匹配相等，因为"栈顶"元素 存的是 左括号的对应 右括号，那么就要 出栈 ~~~
 
            else 
                stack.pop();
            
        }
        
     //for循环 遍历完 字符串后。还要检查 栈是否为空 如果栈不为空，说明有相应的左括号 没有 右括号来匹配，返回 false。。。 如果是 空的话，说明匹配完毕了，那么返回 true  ！！
       // 就是第三种情况  ： 左括号 没有匹配的 情况有这些： 比如 (( 
        return stack.isEmpty();
        
    }
}
```

### 1047 删除字符串中的所有相邻重复项

#### 栈

题目描述：

```
给出由小写字母组成的字符串 s，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

在 s 上反复执行重复项删除操作，直到无法继续删除。

在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

 

示例：

输入："abbaca"
输出："ca"
```

题解 ：[https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/solutions/1743118/by-carlsun-2-srfq/](https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/solutions/1743118/by-carlsun-2-srfq/)

```java
//  用“栈”
// 一直往里面添加元素，但是每次添加的时候，都要判断，如果 和 栈顶元素不相等的话，那么 该字符才入栈，如果  相等，那么就 把栈顶元素 弹出去。

class Solution {
public String removeDuplicates(String S) {

    Stack<Character> stack = new Stack<>();
    
    for (int i = 0; i < S.length(); i++) {
        
        char ch = S.charAt(i);
        
            // 如果栈为空的话，那么也就是说第一次开始判断字符串，那么就要用isEmpty()判空，入栈
        if (stack.isEmpty()) {
            stack.push(ch);
        } 
        
// 如果栈不为空，那么就要对 里面的 "栈顶" 的元素进行判断,只是判断 不需要 弹出栈，所以调用peek()
        else
        {   

 // 如果 "栈顶" 元素和 要添加的相邻字符不重复，也就是不相等，那么就要把这个 字符 入栈。 
            if(stack.peek()!=ch)
                stack.push(ch);
// 否则的话，就是 字符 相等 的情况，就只需要 pop()出栈即可。
            else
                stack.pop();
        }

    }

    // 声明 StringBuffer 去接收 出栈的 的 字符 ，并添加到字符串里 
    StringBuffer res = new StringBuffer();

//因为 最后的栈中 剩余的元素，即为 不重复的元素,通过 一个while循环依次 出栈，加入res 中 
       
    while (!stack.isEmpty()) {
        // 调用 StringBuffer 的append()方法，不断加入
       res.append(stack.pop());
        
    }
     
    // 只不过 添加之后的 字符串 与想要的 结果 是相反的，所以调用reverse()方法 倒序一下就行。 
    return new String(res.reverse());
}
}
```



### 394 字符串解码

#### 栈

题目描述:

```
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

 

示例 1：

输入：s = "3[a]2[bc]"
输出："aaabcbc"
```

题解：https://leetcode.cn/problems/decode-string/solutions/6274/ti-jie-czhan-by-youlookdeliciousc/?envType=study-plan-v2&envId=top-100-liked

```java
// 因为这道题带了 括号，所以很大概率要使用 “栈” 来解决
// 用的是 两个“栈”来解决问题。


/** 
   一个是数字栈nums。用来 保存字符串s 中出现的数字字符 numStr，用于 倍数拼接字符串多少次。

   另一个是 字符串栈strs。用于保存 res 的结果字符串 
   
   当我们循环遍历 字符串s 的时候，每次遇到 '[' 的时候，就要把之前的 res结果字符串 入栈，以及 之前的数字 numStr 放入  数字栈，同时记得 给他们清零，因为 内部括号还会继续遇到 数字 和字符，嵌套！！！ 
    当 遇到 ']'，那么就是需要 for 循环 不断 append()拼接字符串了，然后 一直 更新 res结果字符串 
**/

public class Solution {
    
    public String decodeString(String s) {
        
        
        Stack<Integer> nums = new Stack<>();
        Stack<String> strs = new Stack<>();
        
        	
  // 因为  字符串中有多个数字字符 比如'1'、'2'，我们要采用拼接的方式，把它们拼接成 12。还要配合	Integer.parseInt(numStr)方法转成 int类型的数字 								
        String numStr = "";   
        
        String res = "";
       
        
        
        
        for (int i = 0; i < s.length(); i++) {
            
            char ch = s.charAt(i);
            	
       // 对于 字符串中的 数字字符判断 就应该这么 写。
            if (ch >= '0' && ch <= '9') {
              	// 对于这样的 "123[ab]" 我是这样子把123取出来的，先保存在numStr字符串中
                 numStr+=ch;
            } 
            
       //如果是 小写字母的话，判断是这样写的。。这时候的话就是普通的 结果字符串res 的一直拼接字符
            else if (ch >= 'a' && ch <= 'z') {
                res += ch;
            }
            
 // 当遇到'[' 时！！就要把'['的之前的数字 num 压入nums栈内， 结果字符串 res 压入strs栈内  
            
 	// 记得要为 numStr 重置！！因为 每遇到一次'['的话，就要把'['的之前的数字 num 压入nums栈内。 有可能 '[' 内部还有 数字字符,又是新的了，所以必须重置numStr =""  。比如"abc100[20[a]]"
            
   // 记得也要为 res 重置！！因为 在遇到'[' 之后，还会遇到括号里面的小写字符，它们都是保存在res中   
            else if (ch == '[') { 
                			
                nums.push(Integer.parseInt(numStr));
                numStr="";
                             
                strs.push(res);
                res = "";    
            } 
            
            // 遇到']' 时，操作与之相配的‘[’之间的字符， res。
            else { 
                
                int times = nums.pop();
                StringBuilder temp = new StringBuilder(strs.pop());
                
                for (int j	 = 0; j < times; j++) {
                    
         // 因为 在遇到'[' 之后，还会遇到括号里面的小写字符，它们都是保存在res中。所以要 用 之前的保存在strs栈里面的 字符串 temp，再拼接上 倍数的 res
                    temp.append(res);
                }
                		// 还要将拼接好的 temp 赋值给 结果字符串 res。要为下一次循环做准备
                res = new String(temp); 
            }
        }
                        // 最周返回结果字符串 
        return res;
    }
    
}

```



### 438 找到字符串中所有字母异位词

#### 哈希表map

#### 滑动窗口

题目描述：

```
给定两个字符串 s 和 p，找到 s 中所有 p 的 
异位词
 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

 

示例 1:

输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
```

题解：https://leetcode.cn/problems/find-all-anagrams-in-a-string/solutions/1125936/gong-shui-san-xie-shuang-zhi-zhen-shi-xi-t5hc/

```java
//这道题 先用map 集合，记录 字符串p各个字符出现的次数。
//  然后用 “滑动窗口”的思想，去 遍历整个 字符串 s ，记得是固定长度，也就是 字符串p的长度作为 滑动窗口的定长。   
//   去统计 当前字符串 s 中的子串 的各个字符出现的次数 。
 
class Solution {
   public   List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();
							// 这里的 m作为 下面 “滑动窗口”的 定长长度 ！！！！
        int n = s.length(), m = p.length();

   

        // 先存储 p字符串中的每个字符 出现的次数。把它放入 map2 哈希表中     
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < m; i++)
        {
            char ch = p.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
       
      
     // map1 哈希表的话，是对于  “滑动”窗口的时候要用的，用来统计「滑动窗口」内的 s 的子串词频 ，然后 和 map2已有的 进行比较。。。当两个map 所统计词频相等，说明找到了一个异位组，将窗口的左边界left 加入答案。
        HashMap<Character, Integer> map1 = new HashMap<>();
        
        int left = 0, right = 0;

        // 有点 “滑动窗口” 的 最长或者 最短的 代码模板的样子
        //  但里面的内层while判断 有点特殊的。   <----- “定长” 滑动窗口 的 模板
        while (right<s.length()) {

            // 先添加 右边界的元素
            char ch_r = s.charAt(right);
            map1.put(ch_r,map1.getOrDefault(ch_r,0)+1);

            //当 窗口的长度大于 m的时候，那么 左边界left 就要往右移动
            if(right - left + 1 > m){
                // 移除 左边界对应的 元素 ，并且 左边界要 右移！！
                char ch_l = s.charAt(left);
                map1.put(ch_l,map1.get(ch_l)-1);
                left++;

          //   这行肯定要加的！！因为如果 这个字符 出现的 次数 为0了，但是这个key还是存在的
                  // 如果不删除它，那么 之后 两个map比较的时候会出问题，会误识别 异位词。。
                if(map1.get(ch_l)==0)
                    map1.remove(ch_l);
               
            }

     //  当滑动窗口 等于定长的 时候，就要比较 map1和map2，如果相等的话 ，就添加left 作为结果
            if(right-left+1==m){

                if(map1.equals(map2))
                    ans.add(left);
            }


            // right 右边界 在最下面的地方要 继续往右移动。
            right++;

        }

        return ans;

    }
}
```

### 17 电话号码的字母组合

#### 回溯组合

题目描述：

```
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例 1：

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：

输入：digits = ""
输出：[]
示例 3：

输入：digits = "2"
输出：["a","b","c"]
```

题解：https://leetcode.cn/problems/letter-combinations-of-a-phone-number/solutions/839901/dai-ma-sui-xiang-lu-17-dian-hua-hao-ma-d-ya2x

```java
// 也是 回溯组合 的方法去做，不断递归 。。。
// 这里默认的话，传入的 digits数字键字符串，它的长度是多少，那么最终答案res保存的 单个临时路径答案的字符串组合的长度就是几， digits=“23” ,那么 他的长度是2 ，最终返回的 ["ad","ae","af",..] 这样的
// 只不过这里是 两个选择的集合了。。。所以 这里的话，在下面的for 循环，横向→ 选择元素的是，i=0 ，而不是 i= startIndex 开始了 ！！！

class Solution {
		
    // 基本上这两个都是这样定义好，在最外面。。。
    // 设置全局列表存储最后的所有结果
    List<String> res = new ArrayList<>();
    // 设置全局列表存储每次递归的 单个临时路径的答案
    StringBuilder temp = new StringBuilder();
			
   									// 自带的主函数 
    public List<String> letterCombinations(String digits) {

            // 这里的话，这个就是必须要加了的。。判断传入为空的 digits
        if (digits.length() == 0) {
            return res;
        }
        
        
        // 每个数字键 和 包含字符串 之间的映射！！为了直接对应2-9，新增了两个无效的字符串""  
        // 下标 2-"abc" ,3-"def" ,以此类推 
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
   // 主函数传入的额外参数 numString[] 字符串数组，其实就是 对应手机的 每个数字键，它里面包含的 字符串。。。比如 数字键2->"abc"
       // ！！然后就是 index 参数，代表  当前遍历的 字符串 digits的下标。第一个字符，它的下标是从0开始。这里它的含义是，指向的 digits字符串中的第几个 数字字符....  
        // 比如 digits ="23" ，index =0，就是指向 '2'数字字符
        backTracking(digits, numString, 0);
        
        return res;

    }


    
    public void backTracking(String digits, String[] numString, int index) {
        
        // 递归的结束条件
      //比如输入字符串 digits="23"，是两个数字，那么根节点往下递归 两层 ,就可以了，叶子节点就是要收集的结果集res 。。
     // 所以 这里的 只需要 index 的下标遍历到了 digits字符串的长度(2)，就是递归 2次 ，就可以结束了.....
        if (index == digits.length()) 
        {		
            res.add(new String(temp));
            return;
        }
        
        
    // 比如传入的 自带参数，数字字符串digits 为"23",那么 index 下标 为0，指向'2'，再转为数字 2，从数字键映射表 numString ，取出对应的字符串 "abc"，也就是 str
    // str 表示当前 数字键，对应的字符串   	
            String str = numString[digits.charAt(index) - '0'];
        
        
       	  // 规定模板的for循环语句。。。因为这里是 从两个集合里面 选元素，那么就是i=0开始。。                       也就是从 str 里面一个个取出 字母字符，寻找组合答案 			
        for (int i = 0; i < str.length(); i++) {
            
            temp.append(str.charAt(i));
            // 递归，处理下一层 。。很常见的 index+1，其实就是指向 digits 数字字符串中 下一个 数字字符，也就是 下一个 数字键。 比如 digits="23",那么下一个取出的数字键 就是 '3'
            backTracking(digits, numString, index + 1);
            // 剔除末尾的，继续尝试
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
```

### 131 分割回文串

#### 回溯分割

题目描述：

```
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串。返回 s 所有可能的分割方案。

 

示例 1：

输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
```

题解：https://leetcode.cn/problems/palindrome-partitioning/solutions/640336/131-fen-ge-hui-wen-chuan-hui-su-sou-suo-yp2jq

```java
//  使用 回溯递归 的方法。
// 要定义一个 startIndex 参数，这里是作为 字符串的切割点，不过注意的是，要获取 其中的回文子串，需要从[startIndex,i] 这个下标区间 去获取。当它属于 回文子串的时候，那么才需要不断向下 回溯递归，去查找
// 所以，这道题还要在下面 定义一个，判断 是不是回文串的子函数 。


class Solution {
    
    
    private List<List<String>> res = new ArrayList<>();
    private List<String> temp = new ArrayList<>();

    public List<List<String>> partition(String s) {
        					
        				// 这里的  startIndex 就是切割线，初始化是0 
        					// 比如说 "abc" ，startIndex=0 的话，就是 "a|bc"
        backtracking(s, 0);
        return res;
        
    }
    
    
    public void backtracking(String s, int startIndex) {
        
  // 如果切割线 startIndex 的起始位置已经大于等于 s 的长度，说明已经找到 一组分割方案了，递归出口
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = startIndex; i < s.length(); i++) {
            			
            // 通过[startIndex,i]区间，就能获取在 s 中的子串。
       // 调用下面自定义的 判断回文串函数 isPalindrome()，只有判断是 回文串的话才能回溯递归!!!
            if (isPalindrome(s, startIndex, i)) {  
						// 因为要获取 回文子串，只能通过 substring()方法，所以 i+1才能获取。
                String str = s.substring(startIndex, i + 1);
                temp.add(str);
                
                backtracking(s, i + 1); //因为不能重复切割！所以寻找 i+1 为起始位置的子串，
                temp.remove(temp.size() - 1); // 回溯过程，弹出本次已经添加的 回文子串
            }
            
           
        }
    }
				
    			// 判断回文串的函数，这个比较简单。
    public boolean isPalindrome(String s, int start, int end) {  
        for (int i = start, j = end; i < j; i++, j--) {
				 if (s.charAt(i)!= s.charAt(j)) 
                return false;
        }
        
        return true;
    }

}
```



### 93 复原 IP 地址

#### 回溯分割

题目描述：

```
有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。

 

示例 1：

输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]
```

题解：https://leetcode.cn/problems/restore-ip-addresses/solutions/850482/dai-ma-sui-xiang-lu-93-fu-yuan-ip-di-zhi-pzjo

```java
//  这道题要用 回溯递归 来解决。
//   也要定义一个 startIndex 参数，作为每一次的 字符串的 切割点。  [startIndex,i] 这个区间就是截取的子串，需要判断  这个子串数字 是否符合ip地址的 规范。
//  然后还要定义一个 pointNum 参数，作为每一次符合分割 加入一个 点号.  用于递归出口的结束。因为 只要有了3个点. 就说明已经分割完毕了，正常的ip地址 就是 3个 点. 
//  注意！！每次当达到 3个点. 之后，还要在 递归出口里面判断，剩下的的 第四个数字 是否符合 ip规范 ！！只有 if判断为true 的情况下，才会把某个ip子串 加入到 res结果集中 。


class Solution {
    
    private List<String> result = new ArrayList<>(); // 记录结果
	
      public List<String> restoreIpAddresses(String s) {
        		
          	// 这里的  startIndex 就是切割线，初始化是0 
        				// 比如说 "11123" ，startIndex=0 的话，就是 "1|1123"
          
          // 这里还要传入一个 pointNum 参数，代表往原始字符串s 添加的 点号. 数量，主要作为递归出口的判断
        backtracking(s, 0, 0);
          
        return result;
          
    }
   
    public void backtracking(String s, int startIndex, int pointNum) {
        
        // 点号 数量为 3 时，分隔结束，递归出口。说明已经分成了四个字串了，已经是 ip地址格式
        if (pointNum == 3) {
            
            //  这行代码很关键！！！
            // 还需要再判断 第四段 ！！！ 剩下的子串是否合法，如果合法就放进 result 中
            if (isValid(s, startIndex, s.length() - 1)) {
                	// 这里的话比较特殊，因为String 类型是不可变的，所以这里直接加 s就可以，	
                result.add(s);
            }
            return;
        }
        
        
        for (int i = startIndex; i < s.length(); i++) {
            
                  // 通过 [startIndex,i] 这个区间，就能获取到 s的子串，然后判断 是否合法	
            if (isValid(s, startIndex, i)) { 
                	
          // 注意！！！这里的话，对于符合 需要对 原始字符串 s 每次都更新 ！！添加 点号.  	                                和之前的那种temp.add()不太一样 ！！！！
                
    //在原始字符串s 的i下标对应 的后面，插入一个逗点，主要通过substring(),注入传入的下标！！
		   // 其实还是很好理解的，先要截取 i之前的 所有字符串s ，然后加上 点号.  然后再拼接上 i 下标到剩下的 length()-1 的截取字符串s  
                s = s.substring(0, i + 1) + "." + s.substring(i + 1); 
                pointNum++;
                
                backtracking(s, i + 2, pointNum); //插入点号. 后 ！！因为原始字符串s 多了个字符串，所以下一个子串的起始位置为 i + 2 。。这点也很特殊 ！！																			
                pointNum--;         // 回溯，点号数量 -1
                s = s.substring(0, i + 1) + s.substring(i + 2);    // 回溯删掉点号.  ，这里记得 后面的截取 s字符串，也要从 i+2 开始，毕竟有之前的点号 .
            
            }
            
           
        }
        
    }
		
    
    // 判断字符串 s 在  左闭右闭区间[start, end] 所组成的数字是否合法
    public boolean isValid(String s, int start, int end) {
        
        if (start > end) {
            return false;
        }
        
        if (s.charAt(start) == '0' && start!= end) { // 1、开头是0 的数字不合法
            return false;
        }
        
        
        int num = 0;
        						// 因为是闭区间，所以要 <=
        for (int i = start; i <= end; i++) {
            
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 2、遇到非数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 3、如果大于 255 了不合法
                return false;
            }
            
        }
        	
        return true;
   
    }

}	
```



### 22 括号生成

#### 回溯其他

题目描述：

```
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

 

示例 1：

输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
示例 2：

输入：n = 1
输出：["()"]
```

题解：https://leetcode.cn/problems/generate-parentheses/solutions/938191/shen-du-you-xian-bian-li-zui-jian-jie-yi-ypti/?envType=study-plan-v2&envId=top-100-liked

```java
/**首先我们需要知道一个结论，一个合法的 括号序列：
	1、左右括号,数量相等  都等于 n 括号对数。比如 n是3 ，那么 左括号和右括号的数量都是3 个
	2、左括号数量 >= 右括号数量
**/


// 如果 左括号数量 小于 n，我们就可以放一个 左括号(，来等待一个右括号来匹配 。当 左括号数量等于n的时候，此时如果 (右括号数量 小于 左括号的数量，我们就可以放一个右括号，来使一个右括号和一个左括号相匹配

// 这里采用  dfs回溯递归的方式，构建一颗 二叉树，来匹配 左右括号。

class Solution {
    				//全局变量，最终的结果集 res
    static List<String> res = new ArrayList<String>();  

    public List<String> generateParenthesis(int n) {
        
        	// 1.初始时定义序列的左括号数量lc 和右括号数量rc都为0 。这里是加法 。
	// 这里的话，把保存临时的 单个答案作为参数 String，不断递归更新了，是 值传递 的形式，下一层的变化对 上一层 是没有影响的 
        
        backtracking(n, 0, 0, "");
        return res;
        
    }
    
    public void backtracking(int n ,int left, int right ,String str)
    {
      			//  2 左括号和 右括号的数量都等于 n ，将当前合法序列str加入结果集 res中。
        if( left == n && right == n) { //递归出口 
            
            	// 因为 String 是不可变的，所以直接加入就行。
             res.add(str);   
             return;
        }
        
        
        // 3.如果 左括号的个数小于n，则在当前序列str后拼接左括号--->来等待一个 右括号来匹配
        if(left < n) 
            backtracking(n, left + 1, right, str + "(");         
        		
    //4. 如果 右括号的个数小于左括号的个数，则在当前序列str后拼接右括号。-->来使一个右括号和一个  左括号相匹配		---> 切记！！当然 right也必须小于 n ！！！！
        if(right<left && right < n ) 
            backtracking(n, left, right + 1, str + ")");  	 
        
    }
}

```



### 5 最长回文子串

#### 暴力

题目描述：

```
给你一个字符串 s，找到 s 中最长的回文子串。

 

示例 1：

输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：

输入：s = "cbbd"
输出："bb"
```

题解：https://leetcode.cn/problems/longest-palindromic-substring/solutions/7792/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419   看法3就行。

```java
 // 采用「中心扩散法」, for 循环遍历 每一个下标，以这个下标为中心，利用「回文串」中心对称的特点，往两边扩散 left 和 right ，看最多能扩散多远。。
   //  所以 对于 一个长度为n 的字符串，我们可以用它的 任意一个字符 当做 --->中心点，所以中心点的个数是n
   /** 找出来的所有回文子串 就是只有下面两种情况 ：
  	一种是回文子串长度 为奇数（如aba，中心是b）
	另一种回文子串长度 为偶数（如abba，中心是b，b）
**/

class Solution {
    
   
    public String longestPalindrome(String s) {
       	
  		// 求最大长度的时候，一般都是把 maxlen 初始化成 整数最小值
   // 因为这里需要返回 子串，所以需要知道 子串的最左边界下标 ！！！所以定义了 start=0
         int start = 0, maxLen = Integer.MIN_VALUE;
        
        for (int i = 0; i < s.length(); i++) {
            
            // 这两种情况都要进行计算的,为了找的回文子串，全一点！！！就是调用两次 find()
            
            //  以单字符为中心扩散，找出来的 回文子串长度是-->奇数
            int len1 = find(s, i, i);
            //以两个字符中间为中心扩散   回文子串长度是-->偶数
            int len2 = find(s, i, i + 1);
            
            int len = Math.max(len1, len2);
            
             if (len > maxLen) {
                maxLen = len;		
                 
          // 此时的 最左侧边界的下标如何 更新 ？？？ 因为此时的 i指向的是 回文子串的中心点下标，那么其实 此时的 该回文子串的长度是 maxlen。。要算出 这个 回文子串的最左侧下标的话.。。
                 // 就必须先算出来 maxlen要先减去-1再除以2 的值，，然后 用 i减去 它 就能算出最左侧下标，赋值给 start
                start = i - (maxLen - 1)/2;	
               
            }
        }
       
        
       // 知道最大子串的左边界起始位置，加上最大长度，就可以返回 最长的回文子串了
        return s.substring(start, start + maxlen);
        
    }

    private int find(String s, int left, int right) {
        
     while (left >= 0 && right <=s.length()-1 && s.charAt(left) == s.charAt(right)) 	{
            left--;
            right++;
        }
        						
         // 注意此处 right,left 的值循环完后  是恰好不满足循环条件的时刻
         // 所以求出来的 最大回文子串的长度，是 right-left-1 
// 比如 "aba",那么此时 跳出循环结束的时候，left= -1，right = 3 。求出来的长度 是 3-(-1)-1= 3
// 下标: 012
        return right - left - 1;
    }
}

```





### 647 回文子串

#### 暴力

题目描述：

```
给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。

回文字符串 是正着读和倒过来读一样的字符串。

子字符串 是字符串中的由连续字符组成的一个序列。

 

示例 1：

输入：s = "abc"
输出：3
解释：三个回文子串: "a", "b", "c"
示例 2：

输入：s = "aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
```

题解：https://leetcode.cn/problems/palindromic-substrings/solutions/732485/shu-ju-jie-gou-he-suan-fa-dong-tai-gui-h-3bms  看法2

```java
// 采用 "中心扩散" 的方法。。。。去找有多少个 回文子串，统计个数 
// 就是 从某个字符 作为中心点，然后有两个指针，从中心点分别向left 和 right 扩散移动，每次移动，  如果发现它们指向的 字符 是相等的，就说明找到了一个 回文子串。。。。

//  所以 对于 一个长度为n 的字符串，我们可以用它的 任意一个字符 当做 --->中心点，所以中心点的个数是n

class Solution {
    
    // 回文串的数量,当作全局变量，这样子的话，在下面的 次函数find()里面也可以直接更新了。
		int count = 0;
		
    
	public int countSubstrings(String s) {
   		
            for (int i = 0; i < s.length(); i++) {
                
 // 这里面的话，每次for循环的时候，是调用两次find()，而不是 只选择某一种if情况，主要是为了找全所有的回文子串， 因为 它们是 奇数长度 或 偶数 长度 ！！
                
   //那么就是 传入 i,i，找出来的回文子串长度就是 奇数。也就是 初始化的时候，指向的中心点 是一个字符，然后左右扩散
                find(s, i, i);
      //传入 i,i+1，找出来的回文子串是长度就是偶数。也就是 初始化的时候，指向的中心点 是两个字符，然后左右扩散
                find(s, i, i + 1);
                
            }
   				 return count;
}

	//	对于一个长度为n的字符串，我们可以用它的任意一个字符当做中心点，所以中心点的个数是n		
	public void find(String s, int left, int right) {
    
        while (left >= 0 && right <=s.length()-1&& s.charAt(left) == s.charAt(right)) 		{
                            left--;
                            right++;
                            count++;
         }
	}

}

```



### 516 最长回文子序列

#### 动态规划子序列

题目描述：

```
给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。

子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。

 

示例 1：

输入：s = "bbbab"
输出：4
解释：一个可能的最长回文子序列为 "bbbb" 。
```

题解：https://leetcode.cn/problems/longest-palindromic-subsequence/solutions/930750/dai-ma-sui-xiang-lu-dai-ni-xue-tou-dpzi-dv83q

```java
// 这道题，和前面的 回文子串问题 不太一样，子串是 "连续"的 。
// 这道题 是子序列“不连续”的。。所以不能用中心扩散来做了，只能用 ---> 动态规划dp 来做
// 而且这道题的话 二维dp，双层for循环，需要从下往上↑遍历


//    首先定义 dp数组含义。dp[i][j]是指，字符串s在 下标[i, j]范围内 最长的回文子序列的长度为 dp[i][j]。

/**   很容易想到 递推公式 ：
  当 i下标对应的字符和 j下标对应的字符相等 情况下，此时的dp[i,j]等于 内部的下标范围[i+1,j-1]的 最长回文子序列的dp[i+1,j-1]的长度，再加上它们两个字符的长度也就是还要 +2 
               
                
    如果它们 不相等。那么就只可能是 下标范围 [i,j-1]或者下标范围 [i + 1][j] 的dp数组中的 最大值 
**/ 


public class Solution {
    
    public int longestPalindromeSubseq(String s) {
        
         // dp[i][j]是指，字符串s在 下标[i, j]范围内 最长的回文子序列的长度为 dp[i][j]。
         // 比如s = "abbc"  [0,2] 是指 字符串"abb" 那么最长回文子序列的长度是 dp[0,2]=2 
       //   下标     0123
        int[][] dp = new int[s.length()][s.length()]; 
        
         // 先初始化dp数组，也就是指在 下标[i,i]相等范围的 字符串的 最长回文子序列的长度为 1 。
        // 比如"abbc"    [0,0] 是指"a"那么最长回文子序列是1 ，[1,1] 是指"b" 同为1 
       //  下标  0123
        for (int i = 0; i < s.length(); i++)
             dp[i][i] = 1;
        		


    // 画出的2*2的方格，根据 这道题的dp递推公式，可以判断是 从下往上 遍历↑，然后再从 左往右遍历→
        		/**      _________	________
        			   |dp[i,j-1] | dp[i,j] |
        			   |dp[i+1,j-1]| dp[i+1,j] |
        			   	___________	__________
        			   	
                             --→  dp[i,j]
                              ↗     ↑
        		**/
    // 因为是 从下往上遍历↑计算的话，那么就是 外层for循环要从 i下标从 length()-1开始了。。。
      // 又因为 这道题，只是dp矩阵数组的 右上方的元素才需要值，那么 j都是 从 i+1开始遍历计算
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                
    // dp递推公式。当 i下标对应的字符和 j下标对应的字符相等 情况下，此时的dp[i,j]等于 内部的下标范围[i+1,j-1]的 最长回文子序列的dp[i+1,j-1]的长度，再加上它们两个字符的长度也就是还要 +2 
                if (s.charAt(i) == s.charAt(j)) 
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                
    // 当 i下标对应的字符和 j下标对应的字符  不相等 情况下。那么就只可能是 下标范围 [i,j-1]或者下标范围 [i + 1][j] 的dp数组中的 最大值 
                else 
                    dp[i][j] = Math.max(dp[i][j - 1],dp[i + 1][j]);
                
            }
        }
        
      // 这道题比较特殊!!!前面的xxx求最大的dp题目，都是 返回max(在for循环遍历计算的不断比较更新)
        // 但是这道题 返回的就是 下标范围 [0,n-1] 的 dp数组，这个和 dp数组的含义有关系，因为是整个范围从0到 末尾下标i-1
  											    	 
        return dp[0][n - 1];
    }
}



```

### 72 编辑距离

#### 动态规划子序列

题目描述：

```
给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符
 

示例 1：

输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
```

题解：https://leetcode.cn/problems/edit-distance/solutions/2354497/72-bian-ji-ju-chi-by-wetoria-04hr/?envType=study-plan-v2&envId=top-100-liked

```java
// 这道题很明显是需要用 动态规划dp来做，而且是 二维的。
// 这里定义的是 dp数组 的含义，dp[i][j]是指，以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，word1 → word2的 编辑次数 为dp[i][j] 。。。切记 ！！这里只针对 把word1 变成word2！


//  根据那个dp数组矩阵，可以指导，在第一行的话， 要想 word1变成 word2，就是 第一行的每个元素，对应要添加 word2的下标j的元素就行了。对于 第一列的话，word1 变成word2，因为 word1的元素不断添加，但是 word2一直是 ""空串，就只需要每添加一个 i下标的字符 时候，把它 删除一次就行。。。



public class Solution {

   
    
    public int minDistance(String word1, String word2) {
        
        int len1 = word1.length();
        int len2 = word2.length();
	
  // ----->这里比较特殊了，
 // +1 多开一行一列，是为了保存边界条件，即字符长度为 0 的情况""，这样子方便后面的dp数组初始化。。记得for循环里面的 终止条件要写成 <= ，小于等于了。。。
 	
 // 所以此时的 dp[i][j]是指，以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，word1 → word2的 编辑次数 为dp[i][j]
        int[][] dp = new int[len1 + 1][len2 + 1];
        
        // 初始化dp数组的 第1列，当 word2 为 "" 时。将 word1 的全部删除即可，编辑次数就是非空字符串word1的长度 i
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        
        // 初始化dp数组的第1行，当 word1 为"" 时。将 word2 的全部增加即可，编辑次数就是非空字符串word2的长度 j
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = j;
        }

       
 //dp数组的 循环计算遍历 顺序，因为dp[i][j] 依赖左上角，上边元素，左边元素 ，所以是 从上到下↓，从左到右→遍历，就是 i=1，j=1 了
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                
                // 这是最佳情况，word1和word2的此时 两个字符 相等的时候
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
  // 此时的dp[i][j]递推公式等于，dp[i-1][j-1]，就是左上角的元素。。其实就是 它们分别去掉一个字符的剩下字符串 
                    dp[i][j] = dp[i - 1][j - 1];
                    
                }
                
                
  // 如果 两个字符 不相等，那么就是对 word1 增删改 操作，从三种情况中 选步骤最少的！！然后再次数+1 
                else{

     // 1、选左边元素 [i,j-1]，因为要算 dp[i,j]，此时 word2多了一个字符，那么就只需要在word1后面 增加一个 和 word2一样的j下标对应的字符
                    int insert = dp[i][j - 1];
                    
     // 2、选左上角元素[i-1,j-1],因为 要算dp[i,j]，其实 就是把 word1的末尾字符 替换成 和 word2一样的末尾字符就可以了
                int replace = dp[i - 1][j - 1];
                    
     // 3、选上边元素dp[i-1][j];,因为要算 dp[i,j]，此时 word1多了一个字符，就是把 word1的末尾字符 删掉就行了。。。
                int delete = dp[i - 1][j];
                    
              //此时的递推公式，依赖于 就是取这三者的最小值，然后再 +1 次数就可以了
                dp[i][j] = Math.min(Math.min(insert, replace), delete)+1;
                }
               

            }
        }
        
        	// 这道题比较特殊!!!前面的xxx求最大的dp题目，都是 返回max(在for循环遍历计算的不断比较更新)
        // 但是这道题 返回的就是 下标范围 [0,n-1] 的 dp数组，这个和 dp数组的含义有关系，因为是整个范围从0到 末尾下标i-1
        return dp[len1][len2];
    }
}


```



## 链表

① 一般来说， 链表使用1个移动指针cur 就够了；有时候需要 2个 快慢移动指针 slow 和 fast，然后它们 对   链表进行操作 。

② 一般来说，cur.next = ...，就是拉链的意思，有点 "删除" 某个节点的味道；如果是cur = cur.next，那么就是移动到下一个 节点 的意思

③一般的话，特殊情况下的边界条件，不需要判断，比如先判断 传入的是空链表 null 什么的。 

④	 如果这道链表题目，需要用到虚拟头节点dummyHead，一般都是要在 while循环 里面用  cur.next  进行判断空！！然后最后的话要返回dummyHead.next 因为这个才是 真正的 头节点！！如果这道题用到了fast指针，每次要移动2 步，那么结果就会和 节点的个数，奇数还是偶数，有关系的时候，或是 cur.next不为null && cur.next.next 不为null，必须是 少的next在前面，也必须用  &&！！

​		如果这道题没用到 虚拟头节点，那么 while循环里面的话，有可能是判断cur.next为空，也可能是判断cur不为空，具体看题目，不能定向思维！！最后返回的话就是 head可以了！！如果这道题用到了fast指针，每次要移动2 步，那么结果就会和节点的个数，奇数还是偶数，有关系的时候，while循环里面 必须是cur不为null && cur.next ，必须是少next的在前面，也必须用 且&&，

### 虚拟头节点

​       一般来说，涉及 **删除**某个节点 、**两两交换 **链表中的节点、**两个链表合并**为第三个链表 的时候 的操作，我们要引入 ”**<u>虚假</u>**“头节点  ！！  引入的作用就是  -----> 方便对 头节点的操作 ！ 
​       

#### 203 移除链表元素

##### 暴力

题解：[https://leetcode.cn/problems/remove-linked-list-elements/solutions/554354/dong-hua-yan-shi-die-dai-fa-203-yi-chu-l-vfr9/](https://leetcode.cn/problems/remove-linked-list-elements/solutions/554354/dong-hua-yan-shi-die-dai-fa-203-yi-chu-l-vfr9/)

```java

// 因为涉及到 “移除”节点，所以引入 "虚拟头节点”，主要目的就是，方便对 头节点的操作 ！
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        // 声明一个虚拟头节点，这个（0）是随便取的
        // 虚假头节点的 next 要指向真正的头节点，进行连接 ----- > 这个是通用写法 ，2行代码
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 声明一个移动指针 cur，它要通过循环遍历链表不断后移，起始位置当然是从虚假头节点开始 ！
        ListNode cur = dummyHead;

        // 如果引入虚拟头节点后，while一般要判断移动指针 cur 的 next 不为 null，才执行 while 循环
        // 其实就这么理解，如果当前链表为空，那么 “虚拟”头节点的next就是null 
        while (cur.next != null) {
            // 这里为什么是判断移动指针 cur 的 next ，主要是因为删除某个节点的话，都要先找到它的前面节点，
            if (cur.next.val == val) {
                // 删除指定节点的写法，简单的断链，这个是通用写法！！！！
                // 就是要让 cur.next 指向 cur.next 的 next
                cur.next = cur.next.next;
            } else {
                // 否则，因此 cur 向后移动一个位置
                cur = cur.next;
            }
        }
        
        // 如果链表题目的代码里引入了虚假头节点 ！！ 最后的返回值一般是 dummyHead.next ，因为这个才是真正的头节点 
        return dummyHead.next;
    }
}

```



#### 24 两两交换链表中的节点

题解 ：[https://leetcode.cn/problems/swap-nodes-in-pairs/solutions/1720490/by-carlsun-2-mav4/](https://leetcode.cn/problems/swap-nodes-in-pairs/solutions/1720490/by-carlsun-2-mav4/)

##### 暴力

```java
//因为涉及到 两两交换节点，所以引入 “虚拟”头节点 这里是为了 获取某个节点的 前一个节点，方便改指向。
class Solution {
    public ListNode swapPairs(ListNode head) {
          
         
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // cur 这个指针是 移动指针，一开始是指向 “虚拟”头节点
        ListNode cur = dummyHead;

   // 也是可以 这样子声明节点的，声明 临时节点，主要是因为这道题，断链比较复杂了， 要在断链之前，要先 保存某个节点的 后继节点
        ListNode temp1;
        ListNode temp2;
      
        
 //  只有出现 cur移动指针是 走2步的话,就得考虑！！链表节点个数是 奇数还是偶数个，因为这会影响 循环条件的 书写，不过 这两种 循环结束条件 可以通过草稿纸 画图 得知
    // 又因为 这道题本来就是 cur移动指针 是走了2步的，所以 更要判断 链表节点个数是 奇数还是偶数个！
 // 而且！！本来这道题就是引入了 “虚拟”头节点，肯定要有cur.next判断 是否为空， 其实它就是 偶数的情况，那么奇数的情况就是 cur.next.next，多了一个next的 
        
    	//而且 必须是 的cur.next先写在前面, cur.next.next写在后面。如果 cur.next.next 写在前面的话，当 cur.next就是null的时候，还要去判断 next是否为空，那么就会空指针异常 ！
        
    //而且 中间的连接符号 必须用 且  &&  ！！ 不可以用 或  ||
        
    
        while(cur.next!=null&&cur.next.next!=null){

        // temp1 这个 临时节点，你可以画个图好好考虑得出为什么这么 保存
    //  ！！！如果要 断链的话，那么 必须！！就要先保留它这个节点的 下一个节点 cur.next，然后再 断链
                 temp1 = cur.next;

 //temp2 这个 临时节点，你可以画个图好好考虑得出为什么这么 保存，分析同temp1 ！
                 temp2 = cur.next.next.next;
               
			// 这里是以 dummyHead->1->2->3->4->5 为例子 。断链 的操作,要按照这个顺序，3行 代码
                //  先执行 cur 指向节点2 ，这行代码很好想的 
                cur.next = cur.next.next; 
            
         // 然后要执行，节点2 要指向节点1 。首先就是要获取2节点。 就应该是 cur.next 是2 了，而不是最开始的 cur.next.next 。因为 上面执行过了 cur 指向节点2，也就是cur的next域已经是节点了
                cur.next.next = temp1;
                temp1.next = temp2;

            
         // cur 移动指针 每次都要移动 2步  ！！为什么呢 ? 这个可以在草稿纸上 画图 ,基本上就知道了
                cur = temp1;

                }
        
 // 如果链表题目的代码里引入了虚假头节点 ！！ 最后的返回值一般是 dummyHead.next ，因为这个才是真正的头节点        
        return dummyHead.next;


    }
}
```

#### 19 删除链表的倒数第 N 个结点

题解：[https://leetcode.cn/problems/remove-nth-node-from-end-of-list/solutions/598026/dong-hua-yan-shi-kuai-man-zhi-zhen-19-sh-n9ih/](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/solutions/598026/dong-hua-yan-shi-kuai-man-zhi-zhen-19-sh-n9ih/)

##### 双指针快慢指针

```java
  //  本题目 也是因为考虑到要  "删除" 真实的头节点 比较麻烦。。所以为了方便起见，我们引入 ”虚拟“头节点 这个概念
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        
     
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;


        // 要定义快慢指针，它们初始 都是指向  "虚拟" 头结点
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
       
  // for 循环 中对 fast 快指针移动 n+1 步 ！！这个分析出来很关键！！！！！！
        for(int i=0;i<=n;i++){
        
            fast = fast.next;
        }
		
        //！！！这里就是典型的，两个 循环是 前后执行。先for循环在前面 执行好。然后 while循环在后面执行
        
      // 如果这道题引入了“虚拟”头节点，一般while循环条件里面都是 .next是否为null
        
        //  但是这里的while 终止条件是fast！=null，这个可以草稿纸 画图理解！！因为有些题目的终止条件 是fast.next != null，主要还是看你的思路和 题目 而 决定 ！！
        while(fast!=null){
            // 那么两个指针 都同时移动一步 
            fast = fast.next;
            slow = slow.next;

        }


      // 慢指针slow现在已经指向  待删节点 的  前 一个 节点了，这样删起来就很方便了！！！！
        // 这样就将待删除节点删除了
        slow.next = slow.next.next;

        // 题目如果引入了 ”虚拟“头节点， 最后的返回值 一般都是  dummyHead的next
        return dummyHead.next;


    }
}
```







#### 21 合并两个有序链表

##### 暴力

题目描述：

```
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例 1：

输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]
```

题解：https://leetcode.cn/problems/merge-two-sorted-lists/solutions/2361535/21-he-bing-liang-ge-you-xu-lian-biao-shu-aisw/

```java
// 因为涉及到了 两个链表合并为第三个链表，所以引入  “虚拟”头节点，方便第三个链表的 不断插入新节点。
// 其实大体思想和  合并两个有序数组 差不多，这里就是需要改一下 指针指向。。。
class Solution {
    
     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
         
		
         // 这个是 第三个链表，用于不断拉链，接上新的 节点 。。
        ListNode dummyHead = new ListNode(0);
		ListNode cur  = dummyHead;
         
         // 两个移动指针a和b，分别遍历 list1链表和 list2链表
     	ListNode a = list1;
        ListNode b = list2;

        while (a != null && b != null) {
			
   
			// 如果a 移动指针 指向的 list1链表的节点元素 小于 b移动指针指向的 list2链表节点，那么就 cur的next 就指向 a
            // 然后记得 cur 和 a 一起都向后移动一位 
            if (a.val < b.val) {
                cur.next = a;
                cur = cur.next;
                a = a.next;

            } 
            
            else {
                cur.next = b;
                cur = cur.next;
                b = b.next;
            }

        }
                
         // 当 a移动指针或者 b移动指针走到了 自己遍历的链表末尾的话，那么  结果指针cur 就直接指向另外一个 移动指针剩下的链表部分就行!!!~~~ 
            if (a == null)
                cur.next = b;
         
            else
                 cur.next = a;      
      
         return dummyHead.next;
    
     }

}
```

#### 23 合并K个升序链表

##### 暴力

题目描述：

```
给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。

 

示例 1：

输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
```

题解：https://leetcode.cn/problems/merge-k-sorted-lists/solutions/574324/shua-chuan-lc-you-xian-dui-lie-jie-fa-sh-3flb/

https://www.bilibili.com/video/BV1vv4y1S7vu/?spm_id_from=333.337.search-card.all.click&vd_source=5fe50b1b35a25689fb0988c454fec5e0

```java
// 因为  多个链表合并到 一个链表中，所以引入  “虚拟”头节点，方便第三个链接的 不断插入新节点。
// 这里用到了 PriorityQueue 优先级队列 ，内置方便排序 比较。
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        
         // 这个是 合并出来的 结果链表，用于不断拉链，接上新的 节点 。。
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        
        
				//  创建一个堆，其实  	PriorityQueue 优先级队列就是一个 堆。	
                        //  其实要传入一个Comparator比较器 接口
                          // 但是这里 用到了 lambda表达式,前面减去 后面的话，就代表升序 。
        PriorityQueue<ListNode>  queue = new PriorityQueue<>((a,b)->a.val-b.val);
        						
        
        	   
             // 实际上只是 先把k个链表的每个 头节点都放入了 堆中而已，里面会进行 升序排序 。 
        for (ListNode node : lists) { 
   // 这里有个前提，就是  PriorityQueue 优先级队列 不能存入 null值。所以要判断if
            if (node != null) queue.offer(node);
        }
        
        	
        
     //  将k个链表 的头结点，放入「堆」。然后每次都从「堆」中挑出最小值，并将 最小值的头节点的   下一个节点 添加进「堆」。 这样一直循环添加，比较。。。
        while (!queue.isEmpty()) {
            
            ListNode head = queue.poll();
            cur.next = head;
            cur = cur.next;
            
      			   // 记得要用 if ！！！！！ 而不是 while 
                // 因为如果是 while的话，每一次 选择一个最小值的头节点之后，会把该链表的剩余所有节点都放入 「堆」，这样子 会让 「堆」 越来越大。而 每次 poll的时候只是 poll 出去一个。。。。         
            if(head.next != null) 
                queue.offer(head.next);
            
        }
        
        // 本道题 引入了 “虚拟” 头节点 。 所以最后返回的就是 dummyHead的next
        return dummyHead.next;
    }
}


```

#### 148 排序链表

##### 双指针快慢指针

题解：https://leetcode.cn/problems/sort-list/solutions/437400/pai-xu-lian-biao-di-gui-die-dai-xiang-jie-by-cherr

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


 // 知识点1：归并排序的整体思想
 // 知识点2：找到一个链表的中间节点的方法，快慢指针slow和fast，慢指针每次走一步，fast每次都两步，快指针走到了末尾，此时的slow就指向了 中间节点。
 // 知识点3：合并两个已排好序的链表为一个新的有序链表，这个其实就是 合并两个有序的代码，一模一样

class Solution {
    public ListNode sortList(ListNode head) {
            
     // 因为用到了，递归。所以要有递归出口， 当一开始传入的是空链表，所以 直接返回就可以
      // 当进行递归的时候，一直向下递归，当遇到一个节点的时候，其实就是有序的，不需要再对他					        排序了，直接返回就行
         if(head==null || head.next==null) 
             return head;

        ListNode slow = head; //慢指针
        ListNode fast = head.next; //快指针
        
        while(fast!=null && fast.next!=null){ //快慢指针找到链表中点
            
            slow = slow.next; //慢指针走一步
            fast = fast.next.next; //快指针走两步
       
        }
        
        ListNode rightHead = slow.next; //链表右半部分的头节点
        slow.next = null; //从中间节点，截断链表
        
        ListNode left = sortList(head); //递归排序，左半段链表
        ListNode right = sortList(rightHead); //递归排序，右半段链表
        						
        return merge(left,right);	  // 合并已排序的左半链表 和右半链表       
    }  
 


    
    public  ListNode merge(ListNode list1, ListNode list2) {
         
        ListNode dummyHead = new ListNode(0);
		ListNode cur  = dummyHead;        
         
     	ListNode a = list1;
        ListNode b = list2;

        while (a != null && b != null) {
				
            if (a.val < b.val) {
                cur.next = a;
                cur = cur.next;
                a = a.next;

            } 
            
            else {
                cur.next = b;
                cur = cur.next;
                b = b.next;
            }

        }           
        
            if (a == null)
                cur.next = b;   
            else
                 cur.next = a;    
        
         return dummyHead.next;
     }
}
```



#### 2 两数相加

##### 暴力

题解：https://leetcode.cn/problems/add-two-numbers/solutions/446483/liang-ge-shu-xiang-jia-zui-rong-yi-li-jie-de-jie-f/?envType=study-plan-v2&envId=top-100-liked

```java
// 因为涉及到了 两个链表合并为第三个链表，所以 引入了 “虚拟” 头节点 。，

// 这道题，好好分析题干，以及 给的实例，其实能得出规律，其实就是分别 顺序遍历，两个链表的对应节点，每次要求和，记得如果 和 大于等于10，最终保留的节点值是 个位数，也就是对10取模的结果。
// 进位 如果 和 大于等于10，还要考虑 进位问题
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int addOne = 0; // 进位,这个是优化点，必须要考虑的！！ 把它 定义在外面 ！！
        
        // 这个是 第三个链表，用于不断拉链，接上新的 节点 。。
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        ListNode a = l1;
        ListNode b = l2;

        while (a!= null && b!= null) { 
                           
            int sum = a.val  + b.val + addOne; // 还要考虑前面节点相加的进位问题！可能会传1
            addOne = sum >= 10? 1 : 0;  // 处理此时的 两个节点相加 有进位的情况 比如5+8=13。 进位1
            cur.next = new ListNode(sum%10); // 如果 5+8等于13，那么其实最后存入的是3，所以要对10取模。。
            cur = cur.next;  

            a = a.next;
            b = b.next;
        }

        // 处理链表 a 有剩余节点的情况，那么还要继续 相加，一般来说就是 和0 相加。。
        	// 这里还要和 addOne相加，就是怕遇到9->9->9->9 和 9->9 。。那么即便有个链表走到了末尾，每次去遍历剩下的 单个链表节点，和 addOne 会一直 10，进位 1 ，持续不断。。
        while (a!= null) {
            
            int sum = a.val + addOne; 
            addOne = sum >= 10? 1 : 0; 
            cur.next = new ListNode(sum % 10);
            cur = cur.next;                                            

            a = a.next;
        }

        // 处理链表 b 有剩余节点的情况
        while (b!= null) {
            
            int sum = b.val + addOne; 
            addOne = sum >= 10? 1 : 0; 
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            b = b.next;
        }

        // 处理最后可能存在的进位 ！！  这个也很关键
        if (addOne!= 0) {
            cur.next = new ListNode(addOne);
        }

        return dummyHead.next;
    }
}
```

#### 92 反转链表 II

##### 双指针快慢指针

题解：

```
给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。

示例 1：

输入：head = [1,2,3,4,5], left = 2, right = 4
输出：[1,4,3,2,5]
```

题解：https://leetcode.cn/problems/reverse-linked-list-ii/solutions/1992226/you-xie-cuo-liao-yi-ge-shi-pin-jiang-tou-teqq/

```java
  //  这道题，也是有两两反转的感觉。但和 最原本的 反转链表 题目，不一样，那个只需要反转 整个链表  就行了，所以不需要考虑 "头节点"的特殊性质。。。
// 但是这道题 是   反转某个"区间" ！！需要 知道反转"区间"的 前一个节点是什么，才能方便连接，所以 为了统一方便操作，用了 "虚拟头节点" ！！
class Solution {
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
       
        ListNode dummyHead = new ListNode(0);
        dummyHead.next =head;
        
        // 初始化指针 p0 指向 dummyHead
        ListNode p0 = dummyHead;

        
        // 将 p0 移动到指定反转区间的，前一个节点 。。因为还要对 区间反转的链表进行 首尾连接。。。所以需要用到p0！！
        for (int i = 0; i < left-1; i++)
            p0 = p0.next;
		
        
        //这里的话，就和 之前的 原本的反转链表的代码一样了。。。
        ListNode slow = null, fast = p0.next;
        
        // 对指定区间的节点进行反转操作，只不过限定反转的节点个数了。。
        for (int i = 0; i < right - left + 1; i++) {
            
            ListNode temp = fast.next;
            fast.next = slow; 
            slow = fast;
            fast = temp;
            
        }
		      //  因为 这个"区间" 反转完毕之后，要对它 重新加入 链表中 。。
       // 那么 p0的next 这个节点 其实 就是 这个"区间"的 首节点， p0的next的next要指向 快指针 fast ，fast 其实已经指向了 这个区间末尾的 下一个节点了。
        	//最后才是对 p0的next 去指向  这个"区间"的 第一个 尾节点， 完成 反转了。
        p0.next.next = fast;
        p0.next = slow;
        
        
        return dummyHead.next;
    }
}
```



#### 25 K 个一组翻转链表

##### 双指针快慢指针

题目描述：

```
给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。

k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

 

示例 1：


输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]
```

题解：https://leetcode.cn/problems/reverse-nodes-in-k-group/solutions/1992228/you-xie-cuo-liao-yi-ge-shi-pin-jiang-tou-plfs/

```java
// 这道题 其实和  反转链表II 很像，它是只对  其中的一个"区间" 反转 ，这道题是 每个"k长度"的区间，一直 反转
// 而且如果最后的剩余节点不足 k个，那么就不反转。。。。
// 所以要先统计出 链表的总长度，然后每次k个反转之后，总长度记得减去 k ，算出剩余节点个数 

// 但是这道题 是   反转"区间" ！！需要 知道反转"区间"的 前一个节点是什么，才能方便连接，所以 为了统一方便操作，用了 "虚拟头节点" ！！
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
             
        int n = 0;
        ListNode cur = head;
        
        	//  先用一个while循环，遍历一遍 链表，每次++，得出链表长度 
        while (cur!= null) {
            n++;  
            cur = cur.next;
        }

        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
         // 初始化指针 p0 指向 dummyHead
        ListNode p0 = dummyHead;
        
        ListNode slow = null;
        ListNode fast = head;
        		
        // 就是在这里多了个外层的的while循环，每次要判断一下 剩余的节点个数 大于等于k吗，是的话才会反转这段区间的链表。。。
        while (n >= k) {
            
                n -= k;  // 所以每次反转的时候，链表总长度n 要减去这段链表的 k个节点数 ！！
            				
                // 内层for循环就是最最平常的 反转链表的代码。
            for (int i = 0; i < k; i++) {  
                ListNode temp = fast.next;
                fast.next = slow;  
                slow = fast;
                fast = temp;
            }

          	// 因为每次 反转完，p0又要指向 下一个"区间" 的前一个节点，其实就是p0.next，所以要先用临时指针保存一下，因为 p0.next之后要拉链了。
            ListNode temp2 = p0.next;
            
            
            
             //  因为 这个"区间" 反转完毕之后，要对它 重新加入 链表中 。。
       // 那么 p0的next 这个节点 其实 就是 这个"区间"的 首节点， p0的next的next要指向 快指针 fast ，fast 其实已经指向了 这个区间末尾的 下一个节点了。
      //最后才是对 p0的next 去指向  这个"区间"的  尾节点,其实现在是 慢指针 slow 指向着。完成 反转了。
            p0.next.next = fast;
            p0.next = slow;
            
            p0 = temp;  //  记得移动p0！！ 因为 还要 给 下一个 k长度的区间 继续反转。。。
            
        }

        return dummyHead.next;
    }
}

```

### 不用虚拟头节点

​     其他情况的话， 一般。。。不需要 引入 ”虚假“头节点 。。。。

​    除了个别的 很 "特殊" 例子。。。。

#### 83 删除排序链表中的重复元素

##### 双指针快慢指针

题解 ：https://leetcode.cn/problems/remove-duplicates-from-sorted-list/solutions/2656499/shuang-zhi-zhen-shan-chu-lian-biao-zhong-z143/

```java
		/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// 这道题比较特殊。虽然是 “删除”链表的节点，但是并没用到 “虚拟”头节点。主要是因为 头节点不重复，不需要删除！！！
class Solution {
    
    
 // 给定的是 已经“排序”的 单链表的，那么重复的元素一定会 相邻，所以比较适合 用快慢指针。那个是前提条件。
			// 但是基本上给你的  有序 的。 如果无序，那么就要先对 链表进行排序 
    public ListNode deleteDuplicates(ListNode head) {
          // slow，fast快慢指针 初始值，都直接指向了 链表的表头 head 
        ListNode slow = head, fast = head;
        
        // 这个就是 剪枝，可写可不写 					
        if(head == null)
            return null;
        		
        //	 就是 让fast快指针  一直向后移动 先去 “探路”， 判空条件就是 它 不等于 null
        while(fast != null){
            
            	// if的判断其实 和 数组去重复的判断 差不多
            if(slow.val != fast.val){
                  // 只不过 这里的 删除重复元素 和 数组 有点不一样，但这个是 链表的基本操作了。。
                 // 就是 断链。
                slow.next = fast;
                 // 通过断链， 删除重复元素之后，每次slow都要向移动的 
                slow = slow.next;
            }
             // fast快指针 肯定要移动 
            fast = fast.next;
        }
        
         //最后的话 要记得 给它的最后末尾 指向null。才是一个 完整的链表
        slow.next = null;
        return head;
    }
}


```







#### 206 反转链表

题解：[https://leetcode.cn/problems/reverse-linked-list/solutions/2361282/206-fan-zhuan-lian-biao-shuang-zhi-zhen-r1jel/](https://leetcode.cn/problems/reverse-linked-list/solutions/2361282/206-fan-zhuan-lian-biao-shuang-zhi-zhen-r1jel/)

##### 双指针快慢指针

```java


 // 因为这道题 虽然有两两交换的味道，，但是 比较特殊。。没有用 “虚假”头节点 dummyhead  ！

class Solution {
    public ListNode reverseList(ListNode head) {
        
        // slow 指针 是慢指针, fast 是快指针
        // 初始化必须 慢指针slow 指向 null，快指针fast指向 head头节点
        ListNode slow = null;
        ListNode fast = head;
        
        // 要声明 临时指针 temp，因为要断链，所以在断链之前要保存当前 fast 指针的后继节点 fast.next 
        
        ListNode temp;

        // 循环结束的条件是当快指针 fast 不为 null 的时候
        while (fast != null) {
            
            // 必须先用 temp 临时指针先保存 fast快指针 的后继节点 fast.next
            // 然后再将 fast 快指针断链，指向 slow 慢指针
            temp = fast.next;
            fast.next = slow;

            // 两个指针都要后移一个节点
            // 必须 slow 慢指针先移动，然后 fast 快指针再移动
            slow = fast;
            fast = temp;
        }
        
        // 必须返回 slow 指针，因为 此时的fast快指针已经指向了null，因为跳出了while循环了
        return slow;
    }
}

```

#### 234 回文链表

##### 双指针快慢指针

题解：https://leetcode.cn/problems/palindrome-linked-list/solutions/37367/dong-hua-yan-shi-234-hui-wen-lian-biao-by-user7439/?envType=study-plan-v2&envId=top-100-liked

```java
// 1.找到链表的中间节点
//2.反转 后半部分的链表
// 3. 在对这两个链表的节点比较
class Solution {
    
   public boolean isPalindrome(ListNode head) {
        

        // 快慢指针找中间节点
        ListNode slow = head;  // 慢指针，每次移动一步
        ListNode fast = head;  // 快指针，每次移动两步

       
       
       // 1.通过快慢指针，slow 移动一步，fast 移动两步。当 fast 或者 fast.next 为 null 时，slow 就指向了中间节点!!
        while (fast!= null && fast.next!= null) {
            slow = slow.next;  // 慢指针移动
            fast = fast.next.next;  // 快指针移动，2步
        }

       
        // 2.反转 后半部分的链表，就和 反转链表 的代码一样！！
        ListNode cur = slow;  // 当前节点
        ListNode pre = null;  // 前一个节点prev，必须是指向null的！！

        while (cur!= null) {
            ListNode temp = cur.next;  // 暂存当前节点的下一个节点
            cur.next = pre;  // 当前节点指向前一个节点，完成反转
            pre = cur;  // 更新前一个节点
            cur = temp;  // 更新当前节点
        }

        // 3.比较前半部分和反转后的后半部分
       
        ListNode firstHalf = head;  // 前半部分的起始节点
        ListNode secondHalf = pre;  // 反转后半部分的起始节点

       
       // 有个细节！！ 如果链表长度是奇数，那么前半部分的长度比后半部分长度多1个
		// 所以只需要判断 后半部分是否为null就行了，主要是为了防止遍历 空节点。。。
        while (secondHalf!= null) {
            // 如果对应节点的值不相等，不是回文链表，返回 false
            if (firstHalf.val!= secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;  // 前半部分指针移动
            secondHalf = secondHalf.next;  // 后半部分指针移动
        }
       
       
        // 比较完都相等，是回文链表，返回 true
        return true;
    }
}
```



#### 160 相交链表

题解 ： [https://leetcode.cn/problems/intersection-of-two-linked-lists/solutions/12624/intersection-of-two-linked-lists-shuang-zhi-zhen-l/](https://leetcode.cn/problems/intersection-of-two-linked-lists/solutions/12624/intersection-of-two-linked-lists-shuang-zhi-zhen-l/)

[https://www.bilibili.com/video/BV17D4y1z7pk?p=68&vd_source=5fe50b1b35a25689fb0988c454fec5e0](https://www.bilibili.com/video/BV17D4y1z7pk?p=68&vd_source=5fe50b1b35a25689fb0988c454fec5e0)

##### 双指针分离指针

```java
// 本题 虽然是 两个链表,,,.....但是这里没有用到 “虚拟”头节点  ！！！！ 而且也不是必须要用它的！！ 

//  因为这里是两个链表， 两个双指针相向指针，分别 指向 两个链表  。。。。  所以 这里称 “分离”指针 ！！！

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // 本题 没有用到 “虚拟”头节点 
        ListNode A = headA;
        ListNode B = headB;

       

            // 循环结束条件，  就是  两个指针 相等了的话，就是找到了相交节点，跳出 while 循环
   // 很奇怪？！！为什么这里 A == B。。因为这道题本来就是 设计好的。这个“相交”的两个链表就是长这样。。
        
			// 你可能会有疑惑，如果A，B 链表 没有交点，会不会无限死循环？答案是 并不会。
        // 因为 条件是 A ！= B，如果没有交点，A,B走过第二遍时 肯定会同时为null，也就是A，B交点为 None 的情况。（即将两链表末端的 None 看作交点），所以仍会退出循环。

         while(A != B) {

         //  A指针一直在链表A移动，每次移动一步，如果到了 链表末尾，那么就指向 链表B。。。换个链表指
                if(A != null) 
                    A =  A.next;
                 else 
                    A = headB;
                
//  B指针一直在链表B移动，每次移动一步，如果到了 链表末尾，那么就指向 链表A。。。换个链表指
                if(B != null) 
                    B = B.next;
                 else 
                    B = headA;
            
        }
        return A;

    }
}
```

#### 141 环形链表

题解 ：   https://leetcode.cn/problems/linked-list-cycle/solutions/1033149/kuai-man-zhi-zhen-fa-dai-ma-zhong-zhu-sh-cdst/

##### 双指针快慢指针

```java
	// 这里没有涉及 删除 节点， 并没有用 “虚假”头节点 
 //  看到 “环形”的题目，快慢 指针 速度 移动步数 一般 就是 2步，1步

public class Solution {

    public boolean hasCycle(ListNode head) {
        
        
      	  ListNode slow = head;
      	  ListNode fast = head;
        
  //   如何判断有无环：因为 快指针fast是 每次走2步，所以要考虑链表是奇数还是 偶数个节点 。就是看 快指针 fast.next 有没有走到 null 或者 fast.next 是否为null  
        // 中间的符号记得还是 且 && ！！！ 而且 多的next在后面 ！！！
         // 这里具体的奇数，偶数的情况 判断null 都可以通过草稿纸得出来的

        while(fast!=null&&fast.next!=null){

           // 看到 “环形”的题目，快慢 指针 速度 移动步数 一般 就是fast  2步，slow 1步
            slow = slow.next;
            fast = fast.next.next;  
			
            
            // 那如果判断 有“环”呢  ？ 快慢指针 == 相等的话，就是 “环”内偶遇，就有环了 
            if(slow == fast){
                return true;
            }

        }
        
            return false;
        
    }
}
```

#### 142 环形链表 II

题解 ：[https://leetcode.cn/problems/linked-list-cycle-ii/solutions/12616/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/](https://leetcode.cn/problems/linked-list-cycle-ii/solutions/12616/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/)

##### 双指针快慢指针

```java

// 这里没有涉及 删除 节点， 并没有用 “虚假”头节点 

public class Solution {
    
    
    public ListNode detectCycle(ListNode head) {
        
	// 这里没有用到“虚拟”头节点，所以 快慢指针 都 直接指向真实的 head 就行 。
            ListNode slow = head;
            ListNode fast = head;

        //   // 1.如何判断有无环：因为 快指针fast是 每次走2步，所以要考虑链表是奇数还是 偶数个节点 。就是看 快指针 fast.next 有没有走到 null 或者 fast.next 是否为null  
        // 中间的符号记得还是 且 && ！！！ 而且 多的next在后面 ！！！
         // 这里具体的奇数，偶数的情况 判断null 都可以通过草稿纸得出来的

        while (fast != null && fast.next != null) {
            
               //  快指针走 2步，慢指针 1步 
            slow = slow.next;
            fast = fast.next.next;

          			// 快慢指针 第一次 “相遇”
            if (slow == fast) {
                
                //2.找出 那个 环的 入口。 这里就是开始了 
                //  让 fast快指针 回到 头节点！！这个很关键！！移动步数 变成1 步，和 慢指针 一样速度
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                    // 这里返回谁都一样 ，因为这里是 第二次 “相遇” 了
                return slow;
            }
        }

        //如果上面的那个 while 循环直接跳出来了，那么就说明fast快指针到了 链表的末尾，那么就说明没有环，那么就直接 返回 null 
        return null;
    }
}
```



#### 138 随机链表的复制

##### 哈希表map

题解：https://leetcode.cn/problems/copy-list-with-random-pointer/solutions/2361362/138-fu-zhi-dai-sui-ji-zhi-zhen-de-lian-b-6jeo

```java
// 如果采用一轮while循环，每次遍历一个原节点，创建一个新节点，指向next，就会导致random节点找不到。。。。
class Solution {
    
    public Node copyRandomList(Node head) {
        
        
        Node cur = head;
        // 初始化 哈希表 dic
        Map<Node, Node> map = new HashMap<>();
        
        // 1.复制各节点，先建立 “原节点 -> 新节点” 的 Map 映射
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        
        //再遍历一轮，所以cur又要指回原链表的头节点
        cur = head;
        
        
        // 2.构建新链表的 next 和 random 指向
        while (cur != null) {
            
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        
        }
        
        // 5. 返回新链表的头节点
        return map.get(head);
    }
}

```

#### 146 LRU 缓存

##### 暴力

题目描述：

```
请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
实现 LRUCache 类：
LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。

 

示例：

输入
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
输出
[null, null, null, 1, null, -1, null, -1, 3, 4]

解释
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4
```

题解：https://leetcode.cn/problems/lru-cache/solutions/2456294/tu-jie-yi-zhang-tu-miao-dong-lrupythonja-czgt

```java
class LRUCache {
    
    // 定义一个 自定义的双向链表，作为内部类。这里面的 链表头节点，就代表着最近被访问过的 关键字
    								// 每次 访问过某个关键字，就会被插入到 表头
    								// 链表尾节点就是 最久未被访问的节点
    private static class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }
		
    // 申明 LRU类的三个final属性 
    private final int capacity; // LRU能保存的 容量，关键字个，也就是能保存多少个链表节点
    private final Node dummy = new Node(0, 0); // 双向链表的 虚拟头节点 
    private final Map<Integer, Node> keyToNode = new HashMap<>(); // map哈希表，快速 知道某个关键字 key，也就是对应的 链表节点，是否存在 

    		// LRU缓存的 构造方法
    public LRUCache(int capacity) {
        this.capacity = capacity;
        
        	// 这里的虚拟头节点，初始化的时候prev和 next都指向自己。
        this.dummy.prev = dummy;
        this.dummy.next = dummy;
    }

    
    	// 核心方法get(key) ,需要调用下面的基础方法 
    public int get(int key) {
        
        Node node = getNode(key);
        return node != null ? node.value : -1;
        
    }

    // 核心方法put(key,value)，也需要调用下面的3个基础方法。。。 
    public void put(int key, int value) {
        
        Node node = getNode(key);
        if (node != null) {    // 有这本书
            node.value = value; // 更新 value
            return;
        }
        	
        // 如果 这本书 不存在，那么它就是 新书
        node = new Node(key, value); 
        //记得往 这个 hashmap里面插入进去，key以及对应 node 节点。。便于后面去判断它是否存在
        keyToNode.put(key, node);
        pushFront(node); // 因为是最近访问的，也要记得 放在最上面，也就是 链表的表头
        			
// 通过map哈希表就能知道，key关键字数量，如果超过 初始容量capacity，就要 删除链表的最后一个尾节点 
        if (keyToNode.size() > capacity) {
            
            
       // 先通过 虚拟头节点的 prev，就能获取链表尾节点。。因为是 双向链表，这样可以直接获取到
            Node backNode = dummy.prev; 
            keyToNode.remove(backNode.key);  // 哈希表map也要删除它！！！
            remove(backNode); // 同时，也要删除 双向链表的最后一个尾节点 ！！
            
        }
    }

    // 下面三个是最基础的方法。。。getNode(key)、remove(node)、pushFront(node)
    private Node getNode(int key) {
        
        if (!keyToNode.containsKey(key)) { // map哈希表查询，没有这个链表节点，就返回null
            return null;
        }
        		// 如果map哈希表中，查询的到 这个链表节点
        Node node = keyToNode.get(key); 
        
        remove(node); // 把这个节点先从 原来的位置删除
        pushFront(node); // 因为最近被访问了，就要把它放在最前面，链表表头
        return node;  // 最后返回该节点 
    }

    
    // 从链表中，删除一个节点，前面后面断链就行，这里就2行就可以
    private void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    // 在链表表头，添加一个节点
    private void pushFront(Node x) {
        x.prev = dummy;
        x.next = dummy.next;
        x.prev.next = x;
        x.next.prev = x;
    }
    
}


```





## 二叉树

### 常见树的主要类型

#### 满二叉树

这棵二叉树为满二叉树，也可以说  深度  为 k，有  2^k-1  个节点的二叉树。

![image-20240927112022344](https://piggo-zwj.oss-cn-shanghai.aliyuncs.com/leetcode_pig/image-20240927112022344.png)

#### 完全二叉树

​	在完全二叉树中，除了	最底层  节点可能  没填满外，其余每层节点数都达到最大值，并且	最下面一层的节点都集中在该层		最左边	的若干位置

![image-20240927112039891](https://piggo-zwj.oss-cn-shanghai.aliyuncs.com/leetcode_pig/image-20240927112039891.png)

#### 二叉搜索树

若它的左子树不空，则 左  子树上所有结点的值均  小于  它的  根结点  的值；

若它的右子树不空，则 右  子树上所有结点的值均  大于  它的  根结点  的值

它的左、右子树  也分别为  二叉  搜索  树，其实么就是 二叉  排序  树

![image-20240927112050838](https://piggo-zwj.oss-cn-shanghai.aliyuncs.com/leetcode_pig/image-20240927112050838.png)

#### 平衡二叉搜索树

它是 棵  空树  或  它的  左右两个子树  的  高度差的绝对值   不超过  1，并且左右两个子树都是一棵平衡二叉树

![image-20240927112100919](https://piggo-zwj.oss-cn-shanghai.aliyuncs.com/leetcode_pig/image-20240927112100919.png)



### DFS 深度优先遍历

1、确定递归函数的  **参数**和**<u>返回值</u>**   

   首先，我们看题目中最原始的 **<u>主函数</u>** 的 方法名的**<u>返回值</u>**类型，来确定   **是否**  下面要在写 "**次"递归函数**

​		 如果是 **<u>主函数</u>** 返回的是 **<u>List <...></u>**  集合，那么就要在下面  **再定义**一个**“次”递归函数**。**“次”递归函数**的 返回值 是 void ， 常见↑的情况，第一个形参 肯定是 节点 TreeNode，第二个形参 是**<u>List<...></u>** 集合， 这个是对象引用，可以在递归的过程中**<u>不断更新</u>**的，用于返回最终结果的， 其他 形参根据情况而定 ；很少↓ 的情况，会出现 第一个形参是 left左节点，第二个形参 是 right右节点 ，第三个 形参是 List<>集合，然后是其他参数；**次递归函数** 的 **单层递归**的 **逻辑代码** ，记得向 list 集合形参 进行添加元素。对于**“次”递归函数**的**自身递归**调用的时候，对于**某些其他形参**，可以在**递归函数调用**时候 **传参** 有些**小逻辑**，如 +1或 +node.val 求和  或 +"->" 字符串拼接 。最后要在 在  **<u>主函数</u>** 里面 定义一个 List<> 集合，**调用** 下面的 **"次"递归函数** ，要传参list 集合，和其他形参，如 sum的话，就是传入0，如果是 字符串拼接，那么传入空串 ""。最后 return 这个list 集合 就行，或者对 list集合做一些判断罢了，不同题目不同写法。

​        如果是 **<u>主函数</u>** 要返回的是**<u>int 、boolean、TreeNode</u>** 等 类型，常见情况↑，就只需要 对这个  **<u>主函数</u>**  当成   **<u>递归函数</u>** 就行，返回值类型就是自带的，形参也是自带的就行，然后开始 书写代码；较少情况↓ 如果 !!!! 分析题目发现， 自带的主函数给的 形参不太好用的话，那么 才需要在下面再 定义个 **“次”递归函数**，那么就要定义多个 形参，形参的个数和类型就得自己好好考虑咯，当然 返回值类型  和 主函数 肯定是 一样 ；较少的情况↓ ，是 返回值类型 不一样的，如  **<u>主函数</u>**  返回值是boolean，但 **“次”递归函数** 是 void，那是因为这里是 传入了一个  list集合 形参 不断变化，最终对 list 作出判断 。最后要在 主函数里面 调用    下面定义的递归函数，传入对应的参数即可，一般调用之后就 直接 return 就行了 ，主函数的代码是最少的

​	  有时候，我们也会定义一些**全局变量** 比如 max 或者Hashmap，写在方法的 最外面，为了 能让下面的递归函数使用它。

 2、确定  **终止条件** 
     我们在写  递归函数时候，必须  要写  **递归出口** 。主要是 if(...) 里面的 **判断逻辑**  怎么书写, 就是**<u>不</u> ** **满足题意 和 遍历到空节点null(传入空树)**的几个情况要写在**递归出口**，**但是有时候**却只需要考虑 **遍历到空节点null(传入空树)** 的情况，    下面的**单层递归逻辑代码**就是  **符合**题意 且  **非空**的情况了 。多数情况的话↑，都是遍历到二叉树最下面的 空节点      if (root ==null) ，才是递归出口；多数情况↑，只有一个递归出口，形式都是 if （root ==null） return  。      比如说 如果 递归函数的返回值 是 void  ，那就是 if(root ==null)  return     。如果 递归函数 的返回值 是 int ，那就是  if(root ==null)  return 0 或其他数字。如果是  boolean 那么就是 if(root ==null)  return true 或 false；较少情况↓，有多个 递归出口 ，也就是  if (...)  return   if (...)  return  if (...)  return 

​	切记， **递归出口** 必须要考虑 **正确 和 全面**，因为这很影响这道题是否ac的。。。

  3、确定  **单层递归 **的  **逻辑代码** 
         先确定你用 哪种 **遍历顺序**，一般只用 **<u>前序</u>** 或  **后序** 的**递归**，这样才能 确定   单层递归的   **逻辑代码** 写在**哪**。不过主要还是    这段**逻辑代码**   应该怎么写 。如果是 **<u>修改  和 寻找</u>** 二叉树的话,适合 <u>**前序**</u>  ，那么就是     **逻辑代码** 写在**<u>最前面</u>** ，剩下的两行 就是 递归函数名。对于**<u>修改</u>** 而言，一般是**<u>创建</u>**二叉树、二叉树 **<u>增加</u>**节点、二叉树**<u>删除</u>**节点，剩下的两行要用**<u>root.left</u>**和 **<u>root.right</u>**去  **<u>接收</u>**  递归函数处理后的 左子树和右子树。对于**<u>查找</u>**而言，那么就只需要return 递归函数就行了，**<u>不需要</u>** root.left和root.right去接收;如果是**判断 和 计算 **二叉树的话,一般适合用 **后序**， 会**用 一个变量** 去**接收** 递归左子树的**返回值** ，**另外一个变量** 也去 **接收** 递归右子树的 **返回值**，最后把这两个 变量进行 **逻辑操作** ，比如 &&，或者max( )取最大值，或者直接 把它们相加，  最后  return 返回 

​		注意！！！你写 **<u>前序递归</u>** 或者 **后序递归 **的时候，千万**<u> 别</u>**想   **具体**的过程！！<u>**别 **</u>   **一直代入**递归函数自己去**一层层的想**！！因为这样思路会很乱！！所以你应该做的是，就比如 **后序**，那么你就当 上面的左子树递归函数 和 右子树递归函数   **已经执行完**，你脑子里就想象下 ，整颗二叉树中的**带有3个节点**的 **子树**， 然后进行比较然后向上  return 返回，能弄明白子树的逻辑，其他就是一层层向上返回罢了。





#### 226 翻转二叉树

题解 ： https://leetcode.cn/problems/invert-binary-tree/solutions/73159/dong-hua-yan-shi-liang-chong-shi-xian-226-fan-zhua/https://leetcode.cn/problems/invert-binary-tree/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
   
   
       public TreeNode invertTree(TreeNode root) {
		
            if(root ==null)
                return null;
		
           	//  这个是 “修改”，所以是 --->前序，中-左-右
          
           // 其实和 之前的那种 交换两个值一样的逻辑。这里是交换节点的代码，不仅仅是值交换了
            TreeNode temp = root.left;  // 中
            root.left = root.right;
            root.right = temp;

         root.left =invertTree(root.left); // 左
        root.right =invertTree(root.right);  // 右

        return root;

    }


    }
```

#### 101 对称二叉树

题解:  [https://leetcode.cn/problems/symmetric-tree/solutions/862694/dai-ma-sui-xiang-lu-dai-ni-xue-tou-er-ch-hnjo/](https://leetcode.cn/problems/symmetric-tree/solutions/862694/dai-ma-sui-xiang-lu-dai-ni-xue-tou-er-ch-hnjo/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public boolean isSymmetric(TreeNode root) {
        
        // 最终要调用下面的 “次”函数，并且传入 左、右节点 作为参数
        return compare(root.left, root.right);
        
    }
		
   	// 因为主函数 提供的方法参数 不够，所以定义了个 “次”函数，而且 形参是两个。比较“特殊”
    private boolean compare(TreeNode left, TreeNode right) {

        //  递归的出口 就是 以下 几种情况
          
        //  左右节点中  只要它们都是 空节点 是 为空那么就是 true    
        if (left == null && right == null) 
            return true;
        
        // 这行代码，必须写在下面，你自己想想吧，如果把它写在上面的话，当两个 二叉树都是null的时候，也只会进入这个判断，变成false了，所以 是不合理的 。。。。，所以只能 把它放在第2个递归出口
        //  左右节点中  只要有一个 是 为空那么就是 false    
        if (left == null || right == null) {
            return false;
        
       
        //  因为此时只剩下的情况就是，左右节点都不为空，并且值不相等 那么就是 false    
        if (left.val != right.val) 
            return false;
      

        
       // 因为我们把以上情况都排除之后，剩下的就是 左右节点都不为空，并且 数值相同的情况。
       //  因为是判断  ，，，  采用的是 ---> 后序遍历 


        //先递归的比较 左节点的左孩子 和 右节点的右孩子，比较外侧
		//再比较  左节点的右孩子 和 右节点的左孩子，比较内侧
        	
        boolean compareOutside = compare(left.left, right.right); // 左
        
        boolean compareInside = compare(left.right, right.left);  // 右
        
        return compareOutside && compareInside;  // 中
    }
}
```

#### 100 相同的树

题解：https://leetcode.cn/problems/same-tree/solutions/12686/hua-jie-suan-fa-100-xiang-tong-de-shu-by-guanpengc/

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
		// 这道题，其实和 101 的次函数的 一摸一样，，，，
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        // 递归出口有多个，有以下几种情况
        

         //  递归的出口 就是 以下 几种情况
          
        //  左右节点中  只要它们都是 空节点 是 为空那么就是 true    
        if (p == null && q == null) 
            return true;
        
        // 这行代码，必须写在下面，你自己想想吧，如果把它写在上面的话，当两个 二叉树都是null的时候，也只会进入这个判断，变成false了，所以 是不合理的 。。。。，所以只能 把它放在第2个递归出口
        //  左右节点中  只要有一个 是 为空那么就是 false    
        if (p == null || q == null) {
            return false;
        
       
        //  因为此时只剩下的情况就是，左右节点都不为空，并且值不相等 那么就是 false    
        if (p.val != q.val) 
            return false;
        
        
        
         // 因为我们把以上情况都排除之后，剩下的就是 左右节点都不为空，且数值相同的情况。
       //  因为是判断  ，，，  采用的是 ---> 后序遍历 
       
        // 比较外侧：左节点的左孩子和右节点的右孩子
        boolean compareLeft = isSameTree(p.left, q.left);
        
        // 比较内侧：左节点的右孩子和右节点的左孩子
        boolean compareRight = isSameTree(p.right, q.right);
        
        // 只有左右子树都相同，两个树才相同
        return compareLeft && compareRight;
    }
}

```

#### 572 另一个树的子树

题解：https://leetcode.cn/problems/subtree-of-another-tree/solutions/235760/java-di-gui-ban-by-kelly2018/

```java

// 双递归版本 ，，也是第一次遇到这样写法。。主要这道题 可以 在 力扣100题的基础上，稍加修改。

// 要判断一个树 t 是不是树 s 的子树，那么可以判断 t 是否和树 s 的任意子树相等。满足下面3个情况之一就行，所以是 或 的关系 

 // 	当前两棵树相等  ---- > 对应 主函数 return 的第1个  表达式 
//   或者，t 是 s 的左子树； ---- > 对应 主函数 return的第2个  表达式 
//   或者，t 是 s 的右子树。---- >  对应 主函数 return的第3个  表达式  

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        
        // 仍然是 多个 递归出口 
        if(s == null && t == null) 
            return true;
        
        // 这里的 s和 t 是否为 null的情况必须分开！！ 这道题 是不太一样的 。。。
        if(t == null) 
            return true;
        if(s==null)
            return false;   
        
        
        // 这里的话，主函数的 这里就不需要 判断 s.val 是不是等于 t.val了，因为只需要判断s的某个节点下面的 子树，和 t 这个二叉树是否相等就行了，，，，，，而且 主函数的 最下面的 return 第一个表达式就是 调用下面的 “次”递归函数，这里面 会有对 val的判断的，交给他就行 ！！！
        
        return isSametree(s,t)   || isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    
    
    public boolean isSametree(TreeNode s, TreeNode t) {
        
        if(s == null && t == null) 
            return true;
        
        if(s == null || t == null) 
            return false;
        
        if(s.val != t.val)
            return false;
        
        return isSametree(s.left,t.left) && isSametree(s.right,t.right);
    }
}
```

104 二叉树的最大深度

题解：https://leetcode.cn/problems/maximum-depth-of-binary-tree/solutions/10740/hua-jie-suan-fa-104-er-cha-shu-de-zui-da-shen-du-b/  

```java


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        
        if(root == null)
            return 0;
         	
           			// 因为是 计算，所以是 -----> 后序遍历 
        
        int left = maxDepth(root.left);  // 左 
        int right = maxDepth(root.right);  //右
       	
		return Math.max(left, right) + 1;		//中
        
    }
}

```

#### 110 平衡二叉树

题解： [https://leetcode.cn/problems/balanced-binary-tree/solutions/16112/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-25/](https://leetcode.cn/problems/balanced-binary-tree/solutions/746538/shu-ju-jie-gou-he-suan-fa-ping-heng-er-c-ckkm/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    
    
    public boolean isBalanced(TreeNode root) {
       
        
         // 首先是 递归三部曲的 第二步： 书写  递归出口 
     // 因为 这道题 比较 “复杂” ，所以 这里的采用的 递归出口 是 多个。   
        
    // 第 1 个 递归出口 就是，它是一棵 空树 ，就是 true， 是 平衡二叉树  
    if (root == null) {
        return true;
    }
     
   // 第 2个 递归出口 就是，它的  左右两个子树  的深度差的绝对值 超过1，就是 false， 不是 平衡二叉树  
    // 这里 就要 调用下面的 “次”方法， 去求 左、右子树的深度 
    int leftDepth = getTreeDepth(root.left);
    int rightDepth = getTreeDepth(root.right);
    if (Math.abs(leftDepth - rightDepth) > 1) {
        return false;
    }
        
        // 那么剩下的情况就是 左右子树 的深度差，小于等于1的情况，
 
 // 现在 这里才是 递归三部曲的第三步 ： 确定单层 操作逻辑，以及 选 前序 还是 后序。
        //  因为是 判断 ，所以选择 ---> 后序 

    
      boolean leftFlag = isBalanced(root.left);   // 左
       boolean  rightFlag = isBalanced(root.right);  // 右 
        
       //左右两个子树都是一棵平衡二叉树的话，那么 这整个二叉树 才是平衡的 
    return leftFlag && rightFlag;  // 中
 
}

    
    
   // “次”方法，求二叉树的 深度 。用的是之前的 层序遍历 去求的。力扣104题  。用来 被上面调用 ，主要是去求 左、右子树的 深度的 
 public int getTreeDepth(TreeNode root) {
        
        if(root == null)
            return 0;
         	
           			// 因为是 计算，所以是 -----> 后序遍历 
        
        int left = getTreeDepth(root.left);  // 左 
        int right = getTreeDepth(root.right);  //右
       	
		return Math.max(left, right) + 1;		//中
        
    }
```



#### 257  二叉树的所有路径

题解 ：[https://leetcode.cn/problems/binary-tree-paths/solutions/400434/257-er-cha-shu-de-suo-you-lu-jing-tu-wen-jie-xi-by/](https://leetcode.cn/problems/binary-tree-paths/solutions/400434/257-er-cha-shu-de-suo-you-lu-jing-tu-wen-jie-xi-by/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
	
  // 这道题比较特殊，因为自带的主函数的形参不够用。。所以又在下面定义了个 “次”函数，它作为递归函数。
//  然后在 主函数里面调用下面的 “次”递归函数，记得传入 list集合，以及初始化 path = "" 
    public List<String> binaryTreePaths(TreeNode root) {
        
         List<String> res = new ArrayList<>();
        paths(root,res,"");

        return res;
    }

    public void paths(TreeNode root,List<String> res,String path) {
     
        // 一个递归出口，很简单，就是考虑遍历到空节点null的时候
        if (root==null)
            return;

        // 因为本题 属于  找...的类型，所以适合用  ----->前序
        // 只有当 遍历到 叶子 节点，才 添加一次 结果路径字符串 到 res集合
     // 题目中这个 加了return，其实没必要加的，因为再执行一次递归函数，就达到了 叶子节点的左孩子， 其实空节点，也会自动返回的。。。
        
       if (root.left==null &&root.right==null)      //   中 
                res.add(path+root.val);
                
      // 只不过 这里递归函数的  形参里 用了一些 小小的 逻辑 
        paths(root.left,res,path+root.val+"->");		// 左
        paths(root.right,res,path+root.val+"->");		// 右
       
    }
}
```

#### 112 路径总和

题解：https://leetcode.cn/problems/path-sum/description/

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
   // 就是 在 257二叉树的所有路径 这道题的基础上，稍微改改，，就是"次"函数中间的第二个形参改一下。
class Solution {
    
  // 这道题比较特殊，因为自带的主函数的形参不够用。。所以又在下面定义了个 “次”函数，它作为递归函数。
//  然后在 主函数里面调用下面的 “次”递归函数，记得传入 list集合，以及初始化 的sum =0，
    public boolean hasPathSum(TreeNode root, int targetSum) {
				
    
  // 让res 集合 保存 每一条路径上的 之和，其实就是作为 每一个元素。最后再看看里面的元素 是否包含 targetSum。包含的话就是 true，否则就是 false 	
        List<Integer> res = new ArrayList<>();
        pathSum(root,0,res);
        		//  最后就是还要 调用一下这个 contains()函数 ，是否包含 targetSum
        return res.contains(targetSum);
       
    }
    		
   
    public void pathSum(TreeNode root,int sum,List<Integer> res) {	
        // 一个递归出口，很简单，就是考虑 遍历到空节点null的时候
        if (root==null)
            return; 
            		
        	// 本道题 是 属于  找... 的类型，所以我们采用的是---->前序
        
        	//  每次遍历到 叶子节点，那么就必须要 往这个 res里添加 这一条路径上的总和了
        	// 所以 res集合里面 保存的都是 每一条路径之和 
        if (root.left==null&&root.right==null)    // 中 
            res.add(sum + root.val);
        			
      //在 257二叉树的所有路径 这道题的基础上，稍微改改，，就是"次"函数中间的第二个形参改一下。
        pathSum(root.left,sum+root.val,res);		// 左
        pathSum(root.right,sum+root.val,res);    // 右
    }

}
```

#### 113 路径总和 II 

题解：https://leetcode.cn/problems/path-sum-ii/solutions/867902/dai-ma-sui-xiang-lu-dai-ni-xue-tou-er-ch-sbm3/ 

```java

// 这道题。。。比较特殊 。。。只能用  回溯法去做 ！！！
class Solution {
    		
    // 依旧的 两个全局变量，，，
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       
        travesal(root, targetSum,0);
        return res;
        
    }

    private void travesal(TreeNode root, int targetSum,int sum) {
        	
        // 当传入的是一颗空树的时候。。或者 是遍历到了 空节点，那么就要返回了 
        if (root == null) 
            return;
      		
        // 这里是 寻找，所以用的是 --->前序遍历
        // 开始 单层的递归逻辑了。。。
        sum+=root.val;
        temp.add(root.val);
        
        
        if (root.left == null && root.right == null &&  sum== targetSum) {
            		// 小细节，要new 添加 它
            	res.add(new ArrayList<>(temp));	
     	// 特殊1 ，不能加 return！！！！！！这样子的话，找到的这个节点不能自己撤销自己了
        }

        travesal(root.left, targetSum,sum);
        travesal(root.right, targetSum,sum);
        
        			//  特殊2 ，这里也不需要那个 sum-=root.val，其实这里没用了。。。。
        temp.remove(temp.size() - 1); // 撤销之前的添加，回溯 
        
    }
}
```



#### 106 从中序与后序序列构造二叉树

题解： [https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/](https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
       // 在方法的最外面，定义一个全局变量，这个写法很特殊！！主要是为了根据节点值查找 下标位置  
            Map<Integer, Integer> map = new HashMap<>();  
    
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        // 用 map 保存 中序数组 的每个数值，对应的下标位置
  //目的是，为了在 下面递归函数里面， 根据后序数组的，最后一个元素值，也就是根节点。然后去map中找到它  在中序数组 的 下标值。这个很关键！！！
        for (int i = 0; i < inorder.length; i++) 
            map.put(inorder[i], i);
                                                                                               // 左闭右开 [ , )  所有传入的是  两个数组的长度 length  
        return findNode(inorder,  0, inorder.length, postorder,0, postorder.length);    
    }

    	
    public TreeNode findNode(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        
        // 参数里的范围都是 左闭右开 [, )
          // 不满足左闭右开 [ , )  所以要在 大于号 > 的基础上 加上等于号=  
           // 也就是起始下标 >= 终止下标  ，说明没有元素，返回空树 null
        if (is >= ie || ps >= pe)   
            return null;
        	
        
        	//  因为是 “修改”，构造，所以采用 --->前序遍历
        		// 中 
        int rootIndex = map.get(postorder[pe - 1]);  // 先找  后序数组 的最后一个元素 是根节点， 找它在中序遍历中的位置
        TreeNode root = new TreeNode(inorder[rootIndex]);  // new 构造 根结点，主要就是传入对应的 val 值
        int lenOfLeft = rootIndex - is;  //保存中序数组 左子树的节点个数，用来下面，确定后序数组中 需要遍历的 末尾下标是多少，会被用到2次，很关键！！！


         // 左  
        // 递归 构造左子树：   中左数组 + 后左数组
        root.left = findNode(inorder, is, rootIndex,       //   中左数组 的 终止下标是   rootIndex，也就是根节点。而且 这里是 左闭右开，所以 也就是 遍历不到 根节点的。放心好了
                postorder, ps, ps + lenOfLeft);   //  后左数组的 终止下标，就是起始下标 ps 必须再加上 lenOfLeft 。死记硬背就行了!!!它同 后右数组的 起始下标

        
        
        // 右
        // 递归构造 右子树：   中右数组 + 后右数组
          root.right = findNode(inorder, rootIndex + 1, ie, // 为什么中右数组，起始下标 这里是 rootIndex +1 。是因为 rootIndex 就是根节点，不能从它开始遍历，而且是[ 闭区间，rootIndex +1 是 右子树的 第一个起始节点，得从它开始遍历
             postorder, ps + lenOfLeft, pe - 1); //因为后序数组的 最后一个元素是 根节点，已经被用掉了，而且是 开区间 )，所以 后右数组的 终止下标 你就死记硬背吧，pe-1

        return root;
    }
    
}
```

#### 105 从前序与中序遍历序列构造二叉树

题解：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
	//  仿照 106 的模板，稍微改改然后就好了
class Solution {
    
   // 在方法的最外面，定义一个全局变量，这个写法很特殊！！主要是为了根据节点值查找 下标位置  
    Map<Integer, Integer> map = new HashMap<>(); 
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {

       // 用 map 保存 中序数组 的每个数值，对应的下标位置
  //目的是，为了在 下面递归函数里面， 根据后序数组的，最后一个元素值，也就是根节点。然后去map中找到它  在中序数组 的 下标值。这个很关键！！！
        for (int i = 0; i < inorder.length; i++) 
            map.put(inorder[i], i);
        
		// 左闭右开 [ , )  所有传入的是  两个数组的长度 length
        return findNode(inorder,  0, inorder.length, preorder,0, preorder.length);  
   
    }

    public TreeNode findNode(int[] inorder, int is, int ie, int[] preorder, int ps, int pe) {
        
         // 参数里的范围都是 左闭右开 [, )
          // 不满足左闭右开 [ , )  所以要在 大于号 > 的基础上 加上等于号=  
           // 也就是起始下标 >= 终止下标  ，说明没有元素，返回空树 null
        if (is >= ie || ps >= pe) 
            return null;
      
		
        
        
        	//  因为是  因为是 “修改”，构造，所以采用 --->前序遍历
        	// 中
        int rootIndex = map.get(preorder[ps]);  // 先找  前序遍历的第一个元素 是根节点， 找它在中序遍历中的位置
        TreeNode root = new TreeNode(inorder[rootIndex]);  //  new构造 根结点
        int lenOfLeft = rootIndex - is;  // 保存中序数组 左子树的节点个数，用来确定前序数组中 需要遍历的末尾下标

		// 左
        // 递归 构造左子树：   中左数组 + 前左数组
        root.left = findNode(inorder, is, rootIndex,// 中左数组 的 终止下标是   rootIndex，也就是根节点。而且 这里是 左闭右开，所以 也就是 遍历不到 根节点的。放心好了
         preorder, ps+1,  ps+1+ lenOfLeft); //前左数组的 起始下标 肯定是除了第一个根节点的下一个 下标，那么就是 ps+1 。那么前左数组的 终止下标，就是起始 ps+1 必须再加上 lenOfLeft 。死记硬背就行了!!!它同 前右数组的 起始下标

        
        // 右
        // 递归 构造右子树：  中右数组 + 前右数组
        root.right = findNode(inorder, rootIndex + 1, ie, // 为什么中右数组，起始下标 这里是 rootIndex +1 。是因为 rootIndex 就是根节点，不能从它开始遍历，而且是[ 闭区间，rootIndex +1 是 右子树的 第一个起始节点，得从它开始遍历
           preorder, ps+1+ lenOfLeft, pe); // 前右数组的 终止下标就是 末尾了，因为是 右开区间) 

        return root;
    }
}
```

#### 654 最大二叉树

题解：[https://leetcode.cn/problems/maximum-binary-tree/solutions/604651/654-zui-da-er-cha-shu-gen-ju-shu-zu-gou-q0hp9/](https://leetcode.cn/problems/maximum-binary-tree/solutions/604651/654-zui-da-er-cha-shu-gen-ju-shu-zu-gou-q0hp9/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
			
class Solution {
    
    	// 发现一个主函数不够用 ， 所以要下面定义一个  “次”递归函数，  多设点 方法形参
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
   	// 这里仍然用的是  左闭右开 [ , ) 原则 	，所以传入的是 length		
        return buildTree(nums, 0, nums.length);
        
    }
    
    
    
		   // 方法形参，定义一下 数组的起始 start 和 终止下标 end		
    public TreeNode buildTree(int[] nums, int start, int end) {
        
        	// 这里的递归出口的写法，参考了 105和106题 
 	// 递归出口 ， 因为这里采用的是 左闭右开 [ , ) 原则 ， 所以要 >= 大于等于号，带上 等于号= 
        if( start >= end)
            return null;
        
        	
        // 因为是  因为是 “修改”，构造，所以 用---->前序 
        //中 
        
        
 //并不是 修改原数组，，而是通过 下标直接在原数组上 比较查找，不会修改原数组，往递归函数里 传入 起始 和 终止下标 就行
 // 每次默认 最大值下标 是 数组的起始下标 对应的元素，因为这个maxIndex 后面还要用，所以这里要先定义出来。。。。       
        int maxIndex = start;
        int maxVal = nums[start];// 最大值 也就是 数组的起始下标对应的元素
       
        //  这里的算法 只是 “找”最大值，并不是对 整个数组 进行排序，变动元素  
        for (int i = start; i < end; i++) {
            if (nums[i] > maxVal){
                
                 maxIndex = i;
                 maxVal = nums[i];
                
            }
        }
    
        TreeNode root = new TreeNode(maxVal);

        
         //左
        
    	// 根据maxIndex划分左右子树  
        // 左闭右开：[start, maxIndex)
        root.left = buildTree(nums, start, maxIndex);
        
        
        	 //右
        
       	  // 左闭右开：[maxIndex + 1, end) 起始下标肯定是要跳过 maxIndex这个对应值的,因为 这个最大值 已经被作为 根节点用过了。
        root.right = buildTree(nums, maxIndex + 1, end);
        
        return root;

    }

}
```

#### 617 合并二叉树

题解 ：[https://leetcode.cn/problems/merge-two-binary-trees/solutions/424346/617-he-bing-er-cha-shu-san-chong-di-gui-yi-chong-d/](https://leetcode.cn/problems/merge-two-binary-trees/solutions/424346/617-he-bing-er-cha-shu-san-chong-di-gui-yi-chong-d/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode { 
 *     
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        //  递归出口  有多个 。。
     // 递归 出口，只要 遇到 root1 或者 root 2 中 某个节点为空的话，那么就返回另外一个树的 节点					
                if (root1 == null) return root2;
                if (root2 == null) return root1;
        
// 因为2个递归出口的情况排除后，只剩下 root1 和 root2 遍历节点都非空的情况，就可以正常书写 逻辑了
               
       		      // 因为是 因为是 “修改”，构造，采用的是  --->前序 遍历 
        
        		//中 
                TreeNode root = new TreeNode(root1.val + root2.val);
                 
        // 左： 当然都是  两棵树的 左子树 
                root.left = mergeTrees(root1.left, root2.left);
       // 右： 当然都是  两棵树的 左子树 
                root.right = mergeTrees(root1.right, root2.right);

                return root;

    }
}
```



#### 543 二叉树的直径

题解:https://leetcode.cn/problems/diameter-of-binary-tree/solutions/37205/hot-100-9er-cha-shu-de-zhi-jing-python3-di-gui-ye-/?envType=study-plan-v2&envId=top-100-liked

```java
class Solution {
    
    //用于记录最终结果，定义在最外面,这个写法 其实也很“常见”。。。。
    // 它会在 “次”递归函数里面不断被更新 
    int res=0;
    
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        dfs(root);
        
        return res;
    }
    
    // 求二叉树的深度的 “次”函数
    int dfs(TreeNode root){
        
        if (root==null) 
            return 0;
        
        int left=dfs(root.left);
        int right=dfs(root.right);
        
   // 要每次都要进行比较，对每个节点的左、右子树的深度之和 与 最终结果res 比较，哪个更大，然后更新
        res=Math.max(res,left+right);
        
        return Math.max(left,right)+1;
    }
    
}
```

#### 700 二叉搜索树中的搜索

题解：https://leetcode.cn/problems/search-in-a-binary-search-tree/solutions/867987/dai-ma-sui-xiang-lu-dai-ni-xue-tou-er-ch-3ww7/

```java
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {

        
      // 递归出口就一个，很简单，就是考虑 遍历到空节点null 的时候 
            // 这里就不需要再写， 并不符合题意的 情况了。
            // 因为如果再写 root.val!=val作为递归出口的话，会一个问题。如果是根节点不符合，但是 其他节点== val了，那么这个出口就是有问题的 ！！
        if (root == null ) 
            return null;
        
        
        // 剩下的情况，就是节点非空，并且符合题意的 
        
        // 因为是 查找，所以用 ---> 前序 
        if(root.val == val)  //中 
            return root;

        if (root.val < val)  // 左
            return searchBST(root.right, val);
        			  
     //所以这里改成了 else的写法，，因为只剩下 大于>这种情况了。。。否则不符合，力扣的 返回规则
        else			// 右 
            return searchBST(root.left, val);

       
        
    }
}


```

#### 701 二叉搜索树中的插入操作

题解：https://leetcode.cn/problems/insert-into-a-binary-search-tree/submissions/546173957/

```java
class Solution {
   
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
   // 递归出口也只需要考虑这一个，当 二叉树为空null的时候，也是需要 把传入的val作为根节点返回的
        // 另一种理解就是，当遍历到 空节点的时候，就要返回 val值的节点给上层 
        if (root == null) {
            return new TreeNode(val);
        }
        
		
   // 这道题的话，，，其实是 类似“修改”类型，但是这里并不是----> “前序”遍历的样子
        						// 只能算 ≈ “前序”，所以写法很“特殊” 
        // 由于这道题 的基础上是 二叉搜索树，所以代码可以参照 700去书写 
        
   //  而且这道题是  插入节点，那么肯定是要 用 root.left和root.right去接收 递归函数的返回值的 
        								// 这样最终才能返回修改之后 root根节点的 二叉树 
        if (val<root.val) 
            root.left = insertIntoBST(root.left, val);
 
        else 
            root.right = insertIntoBST(root.right, val);
        
        return root;
    }
}


```



#### 450 删除二叉搜索树中的节点

题解：https://leetcode.cn/problems/delete-node-in-a-bst/solutions/582561/miao-dong-jiu-wan-shi-liao-by-terry2020-tc0o/

```java


class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        
        
        // 递归出口也只需要考虑 1种，就当 传入的 root 为空树null，另一种含义就是递归过程中遍历到了null空节点
        if (root == null) 
            return null;
        
        
        // 因为是 删除，也就是 因为是 “修改”，所以用-----> 前序 
        
        if (root.val == key) {				//中 
                  
          //这里的“删除”root节点,在代码中的体现就是直接 return 返回 它的 左、右子树就行！！！
            							// 这个“规律”，我们要熟记和掌握的！！
            if (root.left == null)  
                return root.right;   
            
            else if (root.right == null) 
                return root.left;
            
               // 剩下的就只有 左、右子树 都不为空的情况
            else{
			       // 临时移动指针 t ，用于去找 root.right右子树中的最左边的那个节点 
                    TreeNode t = root.right;

                //注意，while的终止条件必须是 t.left不为空，这里你画个草稿纸就知道了
                    while (t.left != null)   
                        t = t.left;   
                
                //找到 root.right右子树中的最左边的那个节点之后，要进行 连接了 
                    t.left = root.left;

                    return root.right;
            }
            
        } 
        
        else if (key<root.val)  
            root.left = deleteNode(root.left, key);   // 左 
        else 
            root.right = deleteNode(root.right, key); // 右
        
        return root;
    }
}


```



#### 669 修剪二叉搜索树

题解：https://leetcode.cn/problems/trim-a-binary-search-tree/solutions/1814532/by-ac_oier-help/

```java

// 上一道题目是只删除 1个节点，这道题目是删除多个节点，所以就是要在返回的时候也要返回删除过的子树 

class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        
        if (root == null) 
            return null;
        
        
         // 因为是 删除，也就是 因为是 “修改”，所以用-----> 前序 
        
        				
        if (root.val < low) 		// 中	
            
           // 因为这道题目是“删除” 多个节点，根据“删除”节点 root 的代码规则。所以就是要return 返回 递归函数删除之后的子树，给上层
  	// 又因为 root的值小于low最小值边界，而且由于二叉搜索树的性质，那么它的右子树是大于root的，所以有可能满足 []的，所以是去 递归遍历 右子树
            return trimBST(root.right, low, high);
        
        
        if (root.val > high) 
            return trimBST(root.left, low, high);
        
        
     // 肯定是要最后用 root.left和  root.right 去接收 递归函数的返回值的！！
        root.left = trimBST(root.left, low, high); // 左 
        root.right = trimBST(root.right, low, high); // 右 
        return root;
    }
}

```



#### 98 验证二叉搜索树

题解：https://leetcode.cn/problems/validate-binary-search-tree/solutions/84032/er-cha-sou-suo-shu-yu-zhong-xu-bian-li-by-wisemove/

```java
class Solution {

            

        public boolean isValidBST(TreeNode root) {

            List<Integer> res = new ArrayList<>();
                
      // 因为是 二叉搜索树，所以它的  中序遍历 是递增的，这个“特点”一定要记住！！！！！！
        //  所以 先调用“次”函数，  往list集合添加元素。
            // 然后通过下面的 for循环，来看看是否 是递增的，如果出现 前面元素大于 后面元素，就不是 而二叉搜索树，返回false
            inorder(root,res);

            for(int i = 0; i < res.size() - 1; i++){
                if(res.get(i) >= res.get(i+1))
                    return false;	
            }
            return true;
        }

        //  “次”函数 。通过中序遍历 二叉搜索树，往list集合添加元素 
        public void inorder(TreeNode node,List<Integer> res){

            if(node == null)
                return;
            midorder(node.left,res);
            res.add(node.val);
            midorder(node.right,res);
        }

    }
```

#### 108 将有序数组转换为二叉搜索树

题解：https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/solutions/313508/jian-dan-di-gui-bi-xu-miao-dong-by-sweetiee/?envType=study-plan-v2&envId=top-100-liked

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


//  主要就是 找中间值+ 递归  ，具体的可以参考105，和106 。这里仍然是 左闭右开原则 [ , )
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        return fun(nums,0,nums.length);
    }


    public TreeNode fun(int[] nums,int start,int end) {
		
        if(start>=end)
            return null;

        // 因为是  构造，所以是---> 前序 
        
        int mid = (start+end)/2;                 // 中
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = fun(nums,start,mid);  // 左
        root.right = fun(nums,mid+1,end); // 右
        return root;

    }
}
```

#### 230 二叉搜索树中第K小的元素

题解：https://leetcode.cn/problems/kth-smallest-element-in-a-bst/solutions/409487/di-kxiao-yuan-su-de-san-chong-zhao-fa-by-lan-se-2/?envType=study-plan-v2&envId=top-100-liked 

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        
          //  记得是 k-1
        return list.get(k-1);
        
    }
		// 这道题 也是用到了 二叉搜索树的 中序遍历结果是单调自增的特性，直接解出来了。
    public void inorder(TreeNode root,List<Integer> list) {
        
            if (root == null)   
                return;
            inorder(root.left,list);
            list.add(root.val);
            inorder(root.right,list);
            
    }
}
```



#### 235 二叉树的最近公共祖先

题解：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solutions/240096/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/?envType=study-plan-v2&envId=top-100-liked

```java

// 这道题，，，理解有点困难。。。。背一下吧。。。。。。。。
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
             // 一个递归出口，很简单，就是考虑遍历到空节点null的时候
        if(root == null)
            return null;
        	
        		// 因为是 查找，所以用--->前序遍历 
        if(root == p || root == q)            // 中
            return root;
        					
        TreeNode left = lowestCommonAncestor(root.left, p, q);   //左 
        TreeNode right = lowestCommonAncestor(root.right, p, q);   //右
        	
  	// 所以 剩下的这堆 逻辑。。。  和 “前序”遍历的，其实 是有点中途的，”特殊”记忆吧。。用于不断向上返回，，，，

                // 其实 题目中分析的太全面了，但是 本题目的q和p是一定存在二叉树的，所以 1.情况是不需要考虑的！！！所以我这里就没写
        if(left != null && right != null) return root; // 2. 
        
        if(right == null) return left; // 3.
        else	return right; //4.  要这么写，否则 力扣的最后返回值会出问题。。。。
            
        
        
    }
}


```



#### 114 二叉树展开为链表

题解：https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/solutions/17274/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/?envType=study-plan-v2&envId=top-100-liked

```java

//  “原地”修改   -- --  ！！！！
// 这道题的话就记住这个解法就够了 √ ！！。。。“递归”的解法×，实在很难理解。。。。
//  代码的写法 和 解法一的图片顺序有点不太一样的。。按照代码顺序即可。！！
class Solution {
      
public void flatten(TreeNode root) {
    
		// 外面要套一层while循环，这个root节点，好比是一个 "移动"指针，一直是 移动 到root的 right 右节点！！...  一直重复上边的过程，直到 新的右子树为 null
    while (root != null) { 
        
        // 左子树为 null，直接考虑下一个节点，也就是root的右节点right 。
        if (root.left == null) {
            root = root.right;
        } 
        		// 左子树不为空null 的时候 
        else {
            
            // 2.先找  左子树最右边的节点，用 pre 临时移动指针 每次去保存。每一次while循环 都会重新初始化。
            TreeNode pre = root.left;
            while (pre.right != null) {
                pre = pre.right;
            } 
            
            //1.将原来的右子树 接到  左子树的最右边节点
            pre.right = root.right;
               
            // 将左子树插入到右子树的地方，记得给 root的左节点置为null，题目要求的
            root.right = root.left;
            root.left = null;
            
            
            // 做完上边的操作之和，肯定也要考虑下一个节点，也就是root的右节点 right
            root = root.right;
        }
    }
}

}

```



#### 124 二叉树中的最大路径和

题解：

https://leetcode.cn/problems/binary-tree-maximum-path-sum/solutions/297276/shou-hui-tu-jie-hen-you-ya-de-yi-dao-dfsti-by-hyj8/?envType=study-plan-v2&envId=top-100-liked  文字思路 

https://leetcode.cn/problems/binary-tree-maximum-path-sum/solutions/275919/er-cha-shu-de-zui-da-lu-jing-he-zhu-yao-li-jie-ti-/?envType=study-plan-v2&envId=top-100-liked  代码参考

```java
// 别纠结 递归的细节 ！！！！！！！！要直接想象成 已经遍历好的结果。。。

//核心：在于计算结果的时候要 先计算 左右子树的最大路径和，然后每次都要 更新全局变量res 最大路径和，也就是 leftmax+rightmax+root.val ，最后递归向上返回的时候只能返回 较大的一边，并且加上根节点。


class Solution {
    
    // 挺常见的写法，递归的时候，定义一个 全局变量res 
    // 因为 找最大值的话，都是 把res 定义成 Integer的最小值，然后在过程中不断比较，更新res的值
    int res = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        
         
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        
        // 这里的递归出口就只是 遍历到空节点的时候，那么此时返回的最大路径和就是0
        // 另一种含义的话，就是 传入的是一颗空树，那么它的 最大路径和当然是0
        
        // 这道题的话，就只需要 考虑 为空的递归出口就行;对于 不符合题意的，不需要讨论了！！~~
        if (root == null) {
            return 0;
        }
        
    /**
    Q：左、右孩子贡献 为什么要大于等于0？
    A: 因为计算从某一节点出发的路径和的时候，计算公式为： 当前节点值 + 左孩子贡献 + 右孩子贡献，
        而左、右孩子贡献 是「可选的」，也就是说当某一边贡献小于0的时候，也就是 负数 ，其实是不需要去选择 左边 或右边 的路径，只需要返回 0，就代表 不选择 某一边的路径。。。当两边路径都是 负数的时候，完全可以两条路径 都不，也就是都选择 0。那么就只需要 0+0+ root.val  = root.val ，当前节点root的值就可以作为从该节点root 出发的最大路径和 
    **/
        
        
        //  因为是 计算类型的题目，所以是 --->后序
        
        int leftMax  = Math.max(0, dfs(root.left));         // 左：左孩子贡献
        int rightMax = Math.max(0, dfs(root.right));        // 右：右孩子贡献
        
        // 这个 肯定是要一直更新的，三者的要相加 ！！！ 				
        													
        res = Math.max(res, root.val + leftMax + rightMax); // 中：更新res
        
        
        return root.val + Math.max(leftMax, rightMax);      // 返回当前节点的总贡献
    }

    
}

```

### BFS 广度优先遍历

   基本上就是这套模板了，如果 某道题目你要用 **层序**遍历的话，就按照 **双层while循环**的 写法。**外层 while 循环**  控制 遍历是否结束，只要 队列Deque 不为空，遍历就没结束；**内层 for循环** 控制 入队的元素个数 ，然后配合一个 队列 Deque和  定义的一个 **队列长度 size**的 变量，代表 二叉树 **每一层的节点数**。不过  根据 题目的不同，   代码 **有些地方 是需要改  **，比如  返回值 return 的地方，或者 其他地方。。



#### 107 二叉树的层次遍历 II

题解：https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/description/

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();


        if (root == null) {
            return res;
        }

        deque.offerLast(root);

        while (!deque.isEmpty()) {

            List<Integer> list = new ArrayList<>();
            int size = deque.size();

             for (int i = 0; i < size; i++) {

                TreeNode treeNode = deque.pollFirst();
                list.add(treeNode.val);

                if (treeNode.left != null) {
                    deque.offerLast(treeNode.left);

                }

                if (treeNode.right != null) {
                    deque.offerLast(treeNode.right);
                }
            }

            res.add(list);


        }
		
        // 就是 多了 这个 ”反转“的语句 
        Collections.reverse(res);
        return res;


    }
}
```

#### 199 二叉树的右视图

题解 ：https://leetcode.cn/problems/binary-tree-right-side-view/

```java
// 这个 妙！！  只需要 记录  每一层的 	最后一个 节点 就行！！
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        
        while (!deque.isEmpty()) {
            
            int size = deque.size();
            
            for (int i = 0; i < size; i++) {
                
                TreeNode node = deque.pollFirst();
                if (node.left != null) {
                    deque.offerLast(node.left);
                }
                if (node.right != null) {
                    deque.offerLast(node.right);
                }	
                
                     // 如何表示 当前层的最后一个节点？  i==size-1 就行了
                        //将当前层的  最后一个节点 放入  结果列表res
                if (i==size-1) {  
                    res.add(node.val);
                
                }
                
            }
        }
        return res;
    }
}
```

#### 637 二叉树的层平均值

题解 ：https://leetcode.cn/problems/average-of-levels-in-binary-tree/description/

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Solution {
     public List<Double> averageOfLevels(TreeNode root) {

        List<Double> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();


        if (root == null) {
            return res;
        }

        deque.offerLast(root);

        while (!deque.isEmpty()) {


            int size = deque.size();
			
     // sum 和 avg 是记录 当前层的  节点元素之和 以及 平均值，每次都需要 重置一下
            double sum =0;
            double avg = 0;

            for (int i = 0; i < size; i++) {


                TreeNode treeNode = deque.pollFirst();
                sum += treeNode.val;
				
     // 只需要这里 改动一下即可 ，当遍历到最后一个节点的时候，将之前的sum累计和求一下平均值
                if (i=size-1) {

                    avg = sum / size;
                    res.add(avg);
                }



                if (treeNode.left != null) {
                    deque.offerLast(treeNode.left);

                }

                if (treeNode.right != null) {
                    deque.offerLast(treeNode.right);
                }

            }

        }

        return res;


    }
}
```

#### 429 N叉树的层序遍历

题解：https://leetcode.cn/problems/n-ary-tree-level-order-traversal/description/

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
   public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<>();
        Deque<Node> deque = new ArrayDeque<>();


        if (root == null) {
            return res;
        }

        deque.offerLast(root);

        while (!deque.isEmpty()) {

            int size = deque.size();

            List<Integer> list = new ArrayList<>();

           for (int i = 0; i < size; i++) {
                
                Node treeNode = deque.pollFirst();
                list.add(treeNode.val);    
                
                // 不要怕，主要就是如何让自己的  多个孩子节点 挨个入队。。 增强for循环就行  
                if (treeNode.children != null) {
                    for (Node node: treeNode.children) {
                        deque.offerLast(node);
                    }

                }

            }

            res.add(list);

        }


        return res;

    }
}
```

#### 515 在每个树行中找最大值

题解：https://leetcode.cn/problems/find-largest-value-in-each-tree-row/description/

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }   
 * }
 */


class Solution {
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();


        if (root == null) {
            return res;
        }

        deque.offerLast(root);

        while (!deque.isEmpty()) {


            int size = deque.size();
            
	// 定义 max变量 ，用来保存 每一层 的 最大值，不断和 节点比较
            int max = Integer.MIN_VALUE;
            
          for (int i = 0; i < size; i++) {

                TreeNode treeNode = deque.pollFirst();
               
              
		// 这是  找 每一层 最大值的 逻辑 ，判断比较
                if (treeNode.val>max) {
  
                    max =treeNode.val;
                    
                }


                if (treeNode.left != null) {
                    deque.offerLast(treeNode.left);
                }

                if (treeNode.right != null) {
                    deque.offerLast(treeNode.right);
                }

            }
            
            // 内层for循环结束之后，把每层的 max 插入到 res结果集中
            res.add(max);

        }

        return res;

    }
}
```

#### 116 填充每个节点的下一个右侧节点指针

题解：https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

//“纯”自己写的。通过  
//  这道题 比较特殊 ，因为  每一层的 节点 都是满的 。。。。
class Solution {
    
    public Node connect(Node root) {
		
     // 这里 最前面的  框架没什么 变化 。。因为要处理 这颗二叉树 ，而且 最终返回的 也是一颗 二叉树 
      // 而在这个方法内 ，对于 root 这颗 二叉树 处理的时候，root的结构 也是不断在变化 的。
        //  所以，最后 返回这个 root 根节点就行
        	// 所以 这里就不用 自己 定义一个 List 结果集合 了
        Deque<Node> deque = new ArrayDeque<>();

        if (root == null) {
            return root;
        }

        deque.offerLast(root);

        
        while (!deque.isEmpty()) {


            int size = deque.size();


             for (int i = 0; i < size; i++) {

                Node node = deque.pollFirst();
                
               // 对于 每一层的最后一个节点，那么就是 它的 next域设置成 null
                if (i == size-1)
                    node.next =null;
                 
    // 其余 情况的 话，只需要 next 赋值为 peekFirst()的节点 就行。必须是peek!!!而不是 poll，这个你很容易发现  的
                else 
                  node.next = deque.peekFirst();
                
                    

                if (node.left != null) {
                    deque.offerLast(node.left);
                }

                if (node.right != null) {
                    deque.offerLast(node.right);
                }

            }

        }
        
        return root;

    }
}
```

#### 117 填充每个节点的下一个右侧节点指针II

题解：https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/description/

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

//“纯”自己写的。通过  
//  这道题 比较特殊 ，因为  每一层的 节点 不一定是满的 。。。。  但是 也不影响。。 和 力扣 116 的 答案一摸一样 的！！！
class Solution {
    
    public Node connect(Node root) {
		
     // 这里 最前面的  框架没什么 变化 。。因为要处理 这颗二叉树 ，而且 最终返回的 也是一颗 二叉树 
      // 而在这个方法内 ，对于 root 这颗 二叉树 处理的时候，root的结构 也是不断在变化 的。
        //  所以，最后 返回这个 root 根节点就行
        	// 所以 这里就不用 自己 定义一个 List 结果集合 了
        Deque<Node> deque = new ArrayDeque<>();

        if (root == null) {
            return root;
        }

        deque.offerLast(root);

        
        while (!deque.isEmpty()) {


            int size = deque.size();


             for (int i = 0; i < size; i++) {

                Node node = deque.pollFirst();
                
               // 对于 每一层的最后一个节点，那么就是 它的 next域设置成 null
                if (i == size-1)
                    node.next =null;
                 
    // 其余 情况的 话，只需要 next 赋值为 peekFirst()的节点 就行。必须是peek!!!而不是 poll，这个你很容易发现  的
                else 
                  node.next = deque.peekFirst();
                
                    

                if (node.left != null) {
                    deque.offerLast(node.left);
                }

                if (node.right != null) {
                    deque.offerLast(node.right);
                }

            }

        }
        
        return root;

    }
}
```

#### 111 二叉树的最小深度

题解：https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//  深度的话，是指 从根节点 到叶子节点的距离，所以 是从上到下的  ↓
	 
class Solution {
   public int minDepth(TreeNode root) {

        Deque<TreeNode> deque = new ArrayDeque<>();
        int minCount = 0;

        if (root == null) {
            return 0;
        }

        deque.offerLast(root);

        while (!deque.isEmpty()) {


            int size = deque.size();
            // 虽然  统计 的是 最小 深度 。但 还是得  不断 对 minCount++ 
            minCount++;

          for (int i = 0; i < size; i++) {


                TreeNode node = deque.pollFirst();
                
 // 因为 题目中 说了， 最小深度 是指，从 根节点 到  "最近" 的 叶子节点 
      // 所以 每次 对  出队的节点 检查，只要 它 是 叶子 节点 ，那么 它就是  最近的 叶子节点。此时 就直接return 返回 minCount 最小深度了。不需要再 遍历 了
                if (node.left==null&node.right==null)
                    return minCount;


                
                if (node.left != null) {
                    deque.offerLast(node.left);
                }

                if (node.right != null) {
                    deque.offerLast(node.right);
                }

            }

        }

        return minCount;

    }
}
```

#### 222 完全二叉树的节点个数

题解：

https://leetcode.cn/problems/count-complete-tree-nodes/solutions/21544/chang-gui-jie-fa-he-ji-bai-100de-javajie-fa-by-xia/  层序迭代 

https://leetcode.cn/problems/count-complete-tree-nodes/solutions/21544/chang-gui-jie-fa-he-ji-bai-100de-javajie-fa-by-xia/  后序递归

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Solution {
    public int countNodes(TreeNode root) {

        if (root==null)
            return 0;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);

        //  其实就是改一下 这里罢了。。。用一个 计数变量 count
        int count=0;
        
        while (!deque.isEmpty()) {

            int size = deque.size();
            count += size;
            
            while(size-->0){
                
                TreeNode treeNode = deque.pollFirst();
                
                if (treeNode.left!=null)
                    deque.offerLast(treeNode.left);

                if (treeNode.right!=null)
                    deque.offerLast(treeNode.right);
   
    
            }
            
            
        }
        return count;
    }
}


// 这个做了解即可，另外展示一下 后序递归的方式。。。----->

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public int countNodes(TreeNode root) {
      
    if (root == null){
        return 0;
    }
      		int leftCount = 	countNodes(root.left);
      		int rightCount = countNodes(root.right);
    return leftCount + rightCount + 1;
}


}

```

#### 404 左叶子节点之和

题解 ： [https://leetcode.cn/problems/sum-of-left-leaves/solutions/866969/dai-ma-sui-xiang-lu-dai-ni-xue-tou-er-ch-j6f9/](https://leetcode.cn/problems/sum-of-left-leaves/solutions/866969/dai-ma-sui-xiang-lu-dai-ni-xue-tou-er-ch-j6f9/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

   // 题解中是用 前序的迭代方法。。我这里用的是 "层序" 的迭代遍历，，，其实是 一样的逻辑!!
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {

        Deque<TreeNode> deque = new ArrayDeque<>();
        int sum = 0;

        if (root == null)
            return 0;

        deque.offerLast(root);

        while (!deque.isEmpty()) {

            int size = deque.size();

            while(size-->0){

                TreeNode treeNode = deque.pollFirst();
                
     //  主要还是对 左叶子节点  如何判断，如何书写代码。
// 其实就是 某个节点的左节点非空。然后这个左节点的 左、右节点 也都为空。那么它就是 --> 左叶子节点
  if (treeNode.left != null && treeNode.left.left == null && treeNode.left.right == null) 				
                    sum += treeNode.left.val;
                
                if (treeNode.left!=null)
                    deque.offerLast(treeNode.left);

                if (treeNode.right != null) 
                    deque.offerLast(treeNode.right);
                
            }

        }
        return sum;
    }
}
```

#### 513 找左下角的值

题解：[https://leetcode.cn/problems/find-bottom-left-tree-value/solutions/1616928/by-ac_oier-sv59/](https://leetcode.cn/problems/find-bottom-left-tree-value/solutions/1616928/by-ac_oier-sv59/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//  这题 最主要就是要知道， 最后一层的 第一个节点 ！！！---- >也就是 最左下角的 那个元素！！！
class Solution {
   public int findBottomLeftValue(TreeNode root) {

        Deque<TreeNode> deque = new ArrayDeque<>();
		
       // 这个res变量会不断更新赋值 ！！ 会 重新记录 每一层的第一个节点
       
       // 所以当内循环for 遍历到最后一层的时候，它会保存 "最终" 一层的， 第一个节点的
       // 此时再返回 res 即可！！！！！！！！
        int res =0;

        if (root == null)
            return 0;

        deque.offerLast(root);

        while (!deque.isEmpty()) {

            int size = deque.size();

            for (int i = 0; i < size; i++) {
			
                TreeNode treeNode = deque.pollFirst();
                // 记录 每一层的 第一个节点 ，会用于最下面 的 判断 最后一层的 第一个节点
     // 它这个值 会不断更新的，直到遍历到最后一层了，res记录的就是 最后一层的第一个节点
                if (i==0)
                    res = treeNode.val;

                if (treeNode.left!=null)
                    deque.offerLast(treeNode.left);

                if (treeNode.right != null)
                    deque.offerLast(treeNode.right);

            }


        }
				//  循环遍历完之后 。。。。。。。
				 //  直接返回res就行，因为此时的 res 记录的是 最后一层的第一个节点 ，
       									// 也就是 最左下角的 那个元素！！！
        return res;
    }
}
```



# 非常规leetcode题型

## 线程交替打印

### 线程交替打印奇数偶数

```java
// 两个线程交替打印 奇数偶数

class OddEvenPrinter { 
    
    // count计数器，用于表示当前要打印的数字
    private int count = 1;
    // lock对象锁，用于线程间的同步
    private final Object lock = new Object();

    // 打印 奇数 的方法
    public void printOdd() {
        while (count < 100) {
            // 进入同步块，确保线程安全
            synchronized (lock) {
                // 如果当前数字是奇数
                if (count % 2 == 1) {
                    System.out.println("奇数线程：" + count);
                    count++;
                    // 通知等待的线程
                    lock.notify();
                } else {
                    try {
                        // 当前数字不是奇数，等待
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    // 打印 偶数 的方法
    public void printEven() {
        while (count <= 100) {
            synchronized (lock) {
                // 如果当前数字是偶数
                if (count % 2 == 0) {
                    System.out.println("偶数线程：" + count);
                    count++;
                    // 通知等待的线程
                    lock.notify();
                } else {
                    try {
                        // 当前数字不是偶数，等待
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        
        OddEvenPrinter printer = new OddEvenPrinter();
        
        // 创建打印奇数的线程
        Thread oddThread = new Thread(printer::printOdd);
        // 创建打印偶数的线程
        Thread evenThread = new Thread(printer::printEven);

        oddThread.start();
        evenThread.start();
    }


}


```

### 三个线程交替打印ABC

```java
// 三个线程交替打印ABC，10轮 

class PrintABC {

 //number 表示当前编号，用于控制三个线程的 执行顺序。1代表 线程1，2代表 线程2，3代表 线程3
    private  int number = 1;
    // lock对象锁，用于线程间的同步
    private final Object lock = new Object();

    // 线程1，打印 A 的方法
    public void printA() {
        for (int i = 0; i < 20; i++) {    //  for循环 这里控制 轮数。为啥是20？？因为如果执行过一次了，那么就会 执行下一个循环，这时候就是阻塞了，所以每2次循环才会打印一次。
            synchronized (lock) {
                 // 如果number 是1，应该是线程 1 执行
                if(number==1){
                    // 打印 A
                    System.out.println("线程 1：A" );
                    // 更新状态，为下一个线程2 的执行做准备
                    number=2;
                    // 唤醒 其他两个等待的线程
                    lock.notifyAll();
                }
                    // 如果不是 线程 1 执行，就等待
                else{
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                }

            }
        }
    }

    // 线程2，打印 B 的方法
    public void printB() {
        for (int i = 0; i < 20; i++) {
            synchronized (lock) {
                // 如果number是2，应该是 线程2 执行
                if(number==2){
                    // 打印 B
                    System.out.println("线程 2：B" );
                    // 更新状态，为下一个线程3 的执行做准备
                    number=3;
                    // 唤醒 其他两个等待的线程
                    lock.notifyAll();
                }
                 // 如果number 不是 2，那么就等待
                else{
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                }


            }
        }
    }

    // 线程3，打印 C 的方法
    public void printC() {
        for (int i = 0; i < 20; i++) {
            synchronized (lock) {
                // 如果number 是3，应该是线程 3 执行
                if(number==3){
                    // 打印 C
                    System.out.println("线程 3：C" );
                    // 更新状态，为下一个线程的执行做准备
                    number=1;
                    // 唤醒 其他两个等待的线程
                    lock.notifyAll();
                }
              // 如果number 不是3 ，那么就等待
                else{
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                }
            }
        }
    }

    public static void main(String[] args) {
        PrintABC printer = new PrintABC();
        // 创建线程1，负责打印 A 
        Thread thread1 = new Thread(printer::printA);
        // 创建线程2，负责打印 B 
        Thread thread2 = new Thread(printer::printB);
        // 创建线程3，负责打印 C 
        Thread thread3 = new Thread(printer::printC);

        threadA.start();
        threadB.start();
        threadC.start();
    }

}
```

### 三个线程交替打印1-100

```java
// 三个线程交替打印1-100
    
class ThreeThreadsPrinter {
    
    // count计数器，用于表示 当前要打印的数字
    private int count = 1;
    
 //number 表示当前编号，用于控制三个线程的 执行顺序。1代表 线程1，2代表 线程2，3代表 线程3
    private int number = 1;
    
    // lock对象锁，用于线程间的同步
    private final Object lock = new Object();

    // 线程 1 的打印方法
    public void printByThread1() {
        while (count <= 100) {
            synchronized (lock) {
                // 如果当前编号1，是线程 1 执行
                if (number == 1) {
                    System.out.println("线程 1：" + count);
                    count++;
                    // 将当前线程编号设置为线程 2
                    number = 2;
                    // 唤醒所有等待的线程
                    lock.notifyAll();
                } else {
                    try {
                        // 当前不是线程 1 执行，等待
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    // 线程 2 的打印方法
    public void printByThread2() {
        while (count <= 100) {
            synchronized (lock) {
                //如果当前编号2，线程 2 执行
                if (number == 2) {
                    System.out.println("线程 2：" + count);
                    count++;
                    // 将当前线程编号设置为线程 3
                    number = 3;
                    // 唤醒所有等待的线程
                    lock.notifyAll();
                } else {
                    try {
                        // 当前不是线程 2 执行，等待
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    // 线程 3 的打印方法
    public void printByThread3() {
        while (count <= 100) {
            synchronized (lock) {
                // 如果当前编号3，线程 3 执行
                if (number == 3) {
                    System.out.println("线程 3：" + count);
                    count++;
                    // 将当前线程编号设置为线程 1，开始下一轮循环
                    number = 1;
                    // 唤醒所有等待的线程
                    lock.notifyAll();
                } else {
                    try {
                        // 当前不是线程 3 执行，等待
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
    
     public static void main(String[] args) {
        ThreeThreadsPrinter printer = new ThreeThreadsPrinter();
        // 创建线程 1
        Thread thread1 = new Thread(printer::printByThread1);
        // 创建线程 2
        Thread thread2 = new Thread(printer::printByThread2);
        // 创建线程 3
        Thread thread3 = new Thread(printer::printByThread3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
    
}


   
```





## 实现⼀个线程安全的计数器

```java

class AtomicCounter {

    // 采用原子类 AtomicInteger ，来保证线程安全。
    private AtomicInteger count = new AtomicInteger(0);


    public void increment() {
        for (int i = 0; i < 1000; i++) {
            // 调用 AtomicInteger 的 incrementAndGet()方法，是原子性的 ++
            count.incrementAndGet();
        }

    }

    public int getCount() {
        return count.get();
    }


    public static void main(String[] args) throws InterruptedException {

        AtomicCounter counter = new AtomicCounter();
		
        // 创建3个线程，每个线程都 自增++ 1000次，所以 最终 count的值是 3000 

        // 创建线程 1
        Thread thread1 = new Thread(counter::increment);
        // 创建线程 2
        Thread thread2 = new Thread(counter::increment);
        // 创建线程 3
        Thread thread3 = new Thread(counter::increment);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
// 为什么对 这3个线程 要加 join()？？
        
// 因为 join()方法的作用是，确保 主线程main 等到子线程1，2，3 全部都执行完毕后吗，再继续执行下面  这段代码，打印最终的计数器的值。。。
 //  如果不使用join()方法，主线程main 可能会在 三个子线程 还未完成 1000次自增++，就输出计数器的值，导致结果不准确。   
        
        System.out.println("最终计数器的值：" + counter.getCount());
    }


}

```

## 实现一段死锁的代码

```java
class DeadlockExample {
    
    // 创建两个对象，用于模拟资源竞争
    private  Object resource1 = new Object();
    private  Object resource2 = new Object();

    public void method1() {
        
        synchronized (resource1) {
            System.out.println("线程A 持有资源 1");
            // 暂停一下，增加死锁发生的可能性
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // 尝试获取资源 2 的锁
            synchronized (resource2) {
                System.out.println("线程A 持有资源 2");
            }
        }
    }

    public void method2() {
        
        synchronized (resource2) {
            System.out.println("线程B 持有资源 2");
            // 暂停一下，增加死锁发生的可能性
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // 尝试获取资源 1 的锁
            synchronized (resource1) {
                System.out.println("线程B 持有资源 1");
            }
        }
    }
}

public class Main {
    
    public static void main(String[] args) {
        
        DeadlockExample example = new DeadlockExample();
        
        // 创建两个线程，一个执行 method1，一个执行 method2
        Thread thread1 = new Thread(example::method1);
        Thread thread2 = new Thread(example::method2);

        thread1.start();
        thread2.start();
        
    }
}

/** 
        线程 A 通过 synchronized (resource1) 获得 resource1 的监视器锁，然后通过Thread.sleep(1000); 让线程 A 休眠 1s 为的是让线程 B 得到执⾏然后获取到 resource2 的监视器锁。线程 A 和线程 B 休眠结束了，都开始企图请求获取对⽅的资源，然后这两个线程就会陷⼊互相等待的状态，这也就产⽣了死锁。
   满足了 4个 必要条件：
        1. 互斥条件：该资源任意⼀个时刻只由⼀个线程占⽤。
        2. 请求与保持条件：⼀个线程因请求资源⽽阻塞时，对已获得的资源保持不放。
        3. 不剥夺条件:线程已获得的资源在未使⽤完之前不能被其他线程强⾏剥夺，只有⾃⼰使⽤
        完毕后才释放资源。
        4. 循环等待条件:若⼲线程之间形成⼀种头尾相接的循环等待资源关系。
**/
```



## 单例模式

### 懒汉式（线程不安全）

```java

public class Singleton {
        
     private static Singleton instance;

     private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

/**
	先不创建实例，当第一次被调用时，再创建实例。

优点： 延迟了实例化，如果不使用该类，就不会被实例化，节省了内存空间。

缺点： 线程不安全，多线程环境下，如果多个线程同时进入了 if (instance == null) ，若此时还未实例化，也就是 instance == null，那么就会有多个线程执行 instance = new Singleton(); ，就会实例化多个实例；

**/


    
```

### 懒汉式（线程安全）

```java
public class Singleton {
        
    private static Singleton instance;

    private  Singleton() {
    }

    private static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}


/**
	 在get()方法前面用 sychronized 修饰。当多个线程访问，每次只有拿到锁的的线程能够进入该方法，避免了多线程不安全问题的出现。

优点： 是线程安全的。

缺点： 虽然解决了线程安全问题，但是性能降低了。因为加了 sychronized锁，会使其他线程阻塞，上下文切换，等待时间过长。


**/

```



### 双重检查锁（线程安全）

```java
public class Singleton {

    private volatile static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }  
}


/**
	
	双重检查锁 ，相当于是改进了的 "懒汉式"。
主要就是 两次if判断是否 null，加上中间的 synchronized锁。
	第1次判断null，主要就是是如果当前实例已经存在，那么就直接返回，如果不存在，再进行接下来的操作
	然后就是 来到了 synchronized 代码块。因为会有多个线程进来，来创建 实例，所以只能有 1个线程获取到锁，去创建实例，防止多个线程 去创建多个实例。。。
	第2次判断null，因为 已经有线程 创建好实例，就会释放锁，然后 其他线程会获取到synchronized锁，会发现实例 已经被创建，那么就直接return 返回它。
	
	
  为什么使用 volatile 关键字修饰 instance 实例？？？？
		instance = new Singleton(); 这段代码执行时分为三步：
                    1 在堆上开辟内存空间
                    2 创建instance 实例对象
                    3 将 对象引用 指向 堆内存
   使用 volatile 关键字修饰，可以插入内存屏障 禁止 JVM 的指令重排，从而保证代码的 有序性。
	
优点： 延迟加载，节省了内存空间；线程安全，并且相对于 线程安全的懒汉式，性能也提高了。

**/




```



### 饿汉式（线程安全）

```java

   
public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

}


/**
	类加载的时候，就已经 先实例化好了 实例。

优点： 是线程安全的。

缺点： 因为直接实例化好了实例，不再延迟实例化；如果 很久之后才需要使用这个实例，这样就会浪费内存空间



**/
```

### 静态内部类（线程安全）

```java

   
public class Singleton {

    private Singleton() {
    }

    private static class SingletonInner {
        
        private static final Singleton INSTANCE = new Singleton();
        
    }

    public static Singleton getInstance() {
        return SingletonInner.INSTANCE;
    }

}
```

### 枚举类实现（线程安全）

```java
public enum Singleton {

    INSTANCE;

    //添加自己需要的操作
    public void fun() {
			
    }

}




/**
	枚举类型 在类加载时就会 被初始化，并且只有一个实例。是线程安全的

优点： 写法简单，线程安全，可以避免通过反射破坏枚举单例



**/

```

## 排序算法

### 快速排序

题解：https://www.bilibili.com/video/BV1j841197rQ/?spm_id_from=333.337.search-card.all.click&vd_source=5fe50b1b35a25689fb0988c454fec5e0

```java
// 快速排序的主要函数 quickSort()，对 nums[left...right]进行排序 ，不断递归调用
// 下面还定义了 次函数 partition()，用于每次找到一个 mid分区下标。
 
public class Sort {

    public  static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            // 调用 partition()方法， 找到分区的 mid索引
            int mid = partition(nums, left, right);

            // 对左分区进行快速排序，递归
            quickSort(nums, left, mid - 1);

            // 对右分区进行快速排序，递归
            quickSort(nums, mid + 1, right);
        }
    }

    // 进行数组分区操作，然后返回 mid 下标 
    private  static int partition(int[] nums, int left, int right) {

        int pivot = nums[left];  // 选第一个元素作为 基准值


        while (left < right) {
      // right 指针 从右向左←，找小于midValue的值，找到之后，记得把它放到 left指针下标位置
            while (left < right && nums[right] >= pivot) 
                right--;
            
            nums[left] = nums[right];

  // left 指针 从左向→，找大于midValue的值，找到之后，记得把它放到 right 指针下标位置
            while (left < right && nums[left] <= pivot) 
                left++;
            
            nums[right] = nums[left];
        }
        
        			// 此时把 基准元素 放在 两个指针相遇的下标位置
        nums[left] = pivot;

        return left; // 返回基准值的 索引下标
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        quickSort(arr,0,arr.length-1);
        System.out.println("排序后的数组：");
        for (int num : arr){
            System.out.print(num + " ");
        }
    }

}
```

### 归并排序

题解：https://www.bilibili.com/video/BV1Pt4y197VZ/?spm_id_from=333.337.search-card.all.click&vd_source=5fe50b1b35a25689fb0988c454fec5e0

```java
public class Sort {
    
private static void mergeSort(int[] arr, int left, int right) {

    // 如果区间还有多个元素（非单个元素），就一直向下递归排序和合并 。如果只剩一个 元素，那么就是有序的
    if (left < right) {

        // 计算中间索引 mid 
        int mid = left + (right - left) / 2;
        
        // 对 左半区间 进行递归，归并排序
        mergeSort(arr, left, mid);
        // 对 右半区间 进行递归排序，归并排序
        mergeSort(arr, mid + 1, right);
        
        //递归的处理逻辑，每次都是要调用下面的merge()方法，合并 已排序的左半区间和右半区间
        merge(arr, left, mid, right);

    }
}

	// 这个merge()方法，主要作用其实就是 合并两个有序数组
private static void merge(int[] arr, int left, int mid, int right) {

    // 创建临时数组temp 来存储合并后的结果，长度要指定的 
    int[] temp = new int[right - left + 1];
    int p = 0;  // 临时数组temp 的指针p，不断后移 添加元素
    
    int i = left;  // 左子数组 的指针i
    int j = mid + 1;  // 右子数组 的指针j
    

    // 比较 左子数组 和 右子数组的元素，将较小的元素 放入 临时数组temp
    while (i <= mid && j <= right) {
        if (arr[i] < arr[j])
            temp[p++] = arr[i++];
        else
            temp[p++] = arr[j++];
    }

    // 如果 左子数组 还有剩余元素，将其 放入 临时数组temp
    while (i <= mid) {
        temp[p++] = arr[i++];
    }

    // 如果 右子数组 还有剩余元素，将其放入临时数组
    while (j <= right) {
        temp[p++] = arr[j++];
    }

 // 切记！！每次都还要将 temp临时数组中的元素 复制回 原始数组。。注意是 往原始数组的 left下标++
    for (i = 0; i < temp.length; i++) {
        arr[left++] = temp[i];
    }
}
    
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        mergeSort(arr,0,arr.length-1);
        System.out.println("排序后的数组：");
        for (int num : arr){
            System.out.print(num + " ");
        }
    }
    
}
    
    
```

### 冒泡排序

```java
public class BubbleSort {
    
    public static void bubbleSort(int[] arr) {
        
            int n = arr.length;
// 外层for循环，只需要 遍历 n-1次就行了，因为每次确立一个元素的最终位置，确立 n-1个元素之后，那么最后一个元素，它不需要再进行比较就已经有序了。        
        for (int i = 0; i < n - 1; i++) {  
// 内层for循环，每次都是 n-1-i 比较次数，因为每次确立一个元素之后，那么之后的元素 比较的次数会依次 -1，
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
           // 这里是要求升序，如果前面的元素比后面元素大，就交换 arr[j] 和 arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);
        System.out.println("排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```



## 二叉树的层序遍历

题解：https://www.bilibili.com/video/BV1GY4y1u7b2/?spm_id_from=333.788&vd_source=5fe50b1b35a25689fb0988c454fec5e0

```java
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
        	this.val = val;
            this.left = left;
           this.right = right;
      }
}


class Solution {
    
    public List<List<Integer>> levelOrder(TreeNode root) {

        // 一般来说  返回值 是 一个 二维的“数组”。所以用 List< List<...> >嵌套，来模拟表示  
                      /***  就是这样子
                            1
                            2 3 	
                            4 5 6 7 
                       ***/
        List<List<Integer>> res = new ArrayList<>();

        // 声明 一个 双端队列 Deque。  "先进先出" 原则
        Deque<TreeNode> queue = new ArrayDeque<>();

        // 因为如果传入的 根节点 为空的话，那么就直接返回这个最初始化的  空的 嵌套 res 集合
        if (root == null)
            return res;

	
        // 首先把 树的 根节点 入队列 
        queue.offerLast(root);

        // 模板 ！ 双层 while循环。 队列非空 作为循环 终止条件
        while (!queue.isEmpty()) {

  //每次最外层循环开始的时候，必须 重新记录 此时的 队列的长度, 即 二叉树的 当前层的需遍历的节点数，很关键 ！！
            int size = queue.size();
            // level 集合 保存  每一层的 节点，按顺序添加。
            List<Integer> level = new ArrayList<>();

            // 内循环 循环的次数， 也就是 该层 出队 几个 节点元素，通过 size 控制！！
            for (int i = 0; i < size; i++) {

      // 符合 每层节点的 “先进先出” ！！！从队列 弹出 该节点 ，并且 把他加入到 level 集合，
                TreeNode node = queue.pollFirst();
                level.add(node.val);

                // 只要 出队的节点 有 左右孩子节点，那么就要 把他们 插入 队列 ！
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

           // 每次  内层循环 执行完，也就是 该层的节点全部装入 level 集合里了，那么 接下来的操作 就是要把 保存该层的，所有节点的 level 集合 作为嵌套，插入到最终 要返回的 res 集合里。
            res.add(level);

        }
            // 返回 这个res 集合，外层集合，它里面 有一个个 level 集合而已 
        return res;
    }
 
}
```



## 二叉树的非递归遍历

### 前序  迭代 

题解：https://www.bilibili.com/video/BV15f4y1W7i2/?spm_id_from=333.788&vd_source=5fe50b1b35a25689fb0988c454fec5e0

```java
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
        	this.val = val;
            this.left = left;
           this.right = right;
      }
  }


// 就是 要配合 “栈” 来实现，迭代遍历！！！   "先进后出"原则
//   入栈顺序：中-右-左 ，那么出栈顺序 才是 中-左-右，符合 前序遍历 的结果 
class Solution {
    
    public List<Integer> preorderTraversal(TreeNode root) {
        
        // 保存最终的 遍历结果的 res 集合 
        List<Integer> res = new ArrayList<>();
        
        if (root == null)
            return res;
        
        
        Stack<TreeNode> stack = new Stack<>();
        // 首先把 树的 根节点 入栈 
        stack.push(root);
        		
        // "栈" 不为空的话， 就一直遍历，控制 while循环的结束。。
        // 相比于 “层序”遍历，它只需要一个外层的 while 循环就行了
        while (!stack.isEmpty()){
            	
                 // 先 出“栈”
            TreeNode node = stack.pop();
            result.add(node.val);
            
            
      //  先判断左、右孩子 是否为空，非空的话 入栈
            // 前序迭代的话 ，入栈顺序是 右-左 ，这样出栈才是 左-右
            if (node.right != null){
                stack.push(node.right);
            }
            
            if (node.left != null){
                stack.push(node.left);
            }
            
        }
        return res;
    }
}


```

### 后序 迭代 

题解：https://www.bilibili.com/video/BV15f4y1W7i2/?spm_id_from=333.788&vd_source=5fe50b1b35a25689fb0988c454fec5e0

```java


public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
        	this.val = val;
            this.left = left;
           this.right = right;
      }
}

// 就是 要配合 “栈” 来实现，迭代遍历！！！   "先进后出"原则
//  入栈顺序：中-左-右 ， 出栈顺序：中-右-左， 最后 Collections.reverse()翻转结果的话，左-右-中，就是 后序遍历 的结果

//！所以在 “前序”迭代的代码中，改动的就只有  下面判断 左、右节点为空的地方调换一下顺序，变成 左-右
// 以及 最后 对 result集合进行翻转，就是用  Collections.reverse() 方法！
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        // 保存最终的 遍历结果的 res 集合 
        List<Integer> result = new ArrayList<>();
        
        if (root == null){
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<>();
         // 首先把 树的 根节点 入栈 
        stack.push(root);
        
        
// "栈" 不为空的话， 就一直遍历，控制 while循环的结束。。
        // 相比于 “层序”遍历，它只需要一个外层的 while 循环就行了
        while (!stack.isEmpty()){
            
            TreeNode node = stack.pop();
            result.add(node.val);
            
            // 先插入 左节点，再插入 右节点
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
        
    // 以及 最后 对 result集合进行翻转，就是用  Collections.reverse() 方法！
        Collections.reverse(result);
        return result;
    }
}
```

### 中序 迭代

题解：https://www.bilibili.com/video/BV1Zf4y1a77g/?spm_id_from=333.788&vd_source=5fe50b1b35a25689fb0988c454fec5e0

```java
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
        	this.val = val;
            this.left = left;
           this.right = right;
      }
}


// “中序”的 迭代 , 和 前序 、后序 的代码实现 不太一样。。。。略微 复杂！！！
class Solution {
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        
        if (root == null)
            return result;
        
        	
        Stack<TreeNode> stack = new Stack<>();
        // 本来下面应该要有 stack.push(root)这行代码，插入根节点，，但是这里没写，很特殊！！！因为换成了 cur 移动指针 
        // 这里要定义一个 cur 节点指针，用于 访问 树中的每一个节点 ！！
        // 这里是 “特殊”的地方 ！！！ !!!!!!!
        TreeNode cur = root;
        			
  // 只有一个外层 while循环，当 cur节点指针 不指向空节点  或  栈不为空的时候，继续遍历执行
        while (cur != null || !stack.isEmpty()){
            
            	// 先 一路向 左 ，入栈 ！！ 
           if (cur != null){
               
               stack.push(cur);
               cur = cur.left;
               
           }
            		// 遇到空节点的话，就要开始 出栈了  ！！
            		// 以及 要往 右节点 遍历了。。。
            else{	
                	// 记得要让 cur 接收重新指向 ！！！
               cur = stack.pop();
               result.add(cur.val);
               cur = cur.right;
           }
        }
        
        return result;
    }
}
```



## 二叉树的递归遍历

### 前序 递归

题解：https://www.bilibili.com/video/BV1Wh411S7xt/?spm_id_from=333.788&vd_source=5fe50b1b35a25689fb0988c454fec5e0

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// 前序遍历, 中  左右
class Solution {
    
    
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        
      // 这里的话 就只需要 调用 1次 外面定义的 "次"递归函数即可。传入 root 根节点和 result 集合
        // result 集合 在 递归过程中 是不断变化的 
        preorder(root,result);
        
        // 所以等 外面的 递归函数 执行完后 ，直接返回list 集合就行 
        return result;
    }
		
   // 这里 只是 举一个 前序递归 的例子，先 在外面 定义一个递归函数，因为是传入 result引用对象，
   // 所以  随着 递归的深入，result 是不断变化的 。
    // 之后 还要把 preorder( , ) 方法 在 放到上面的  preorderTraversal() 方法内部 进行 调用！
    public void preorder(TreeNode root,List<Integer> result) {
        
        if (root == null) {
            return;
        }
        
        result.add(root.val);		 // 注意这一句，放最前面 
        preorder(root.left, result);
        preorder(root.right, result);
        
    }
}


// 中序遍历  左 中 右
class Solution {
    
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
       
        inorder(root,result);
        return res;
    }

    public void inorder(TreeNode root,List<Integer> result) {
        if (root == null) {
            return;
        }
        
        inorder(root.left,result);
        result.add(root.val,result);             // 注意这一句，放中间 
        inorder(root.right,result);
        
    }
}


```

### 中序 递归

题解：https://www.bilibili.com/video/BV1Wh411S7xt/?spm_id_from=333.788&vd_source=5fe50b1b35a25689fb0988c454fec5e0

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


// 中序遍历  左 中 右
class Solution {
    
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
       
        inorder(root,result);
        return res;
    }

    public void inorder(TreeNode root,List<Integer> result) {
        if (root == null) {
            return;
        }
        
        inorder(root.left,result);
        result.add(root.val,result);             // 注意这一句，放中间 
        inorder(root.right,result);
        
    }
}

```

### 后序 递归

题解：https://www.bilibili.com/video/BV1Wh411S7xt/?spm_id_from=333.788&vd_source=5fe50b1b35a25689fb0988c454fec5e0

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


// 后序遍历 左右 中 
class Solution {
    
    public List<Integer> postorderTraversal(TreeNode root) {
       
        List<Integer> result = new ArrayList<>();
        postorder(root,result);
        return res;
    }

    public void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        
        postorder(root.left);
        postorder(root.right);
        
        result.add(root.val);             // 注意这一句，放最后
    }
}
```





# 方法整理

## 暴力

### 适用范围

什么类型都适用，一般是 你  **第一时间想到**  并且 **没有其他思路 **的时候

### 方法详解

  一般都是 **双重 循环**（两个for，两个while，一个for一个while），也可以是一重循环（一个for，一个while）。 然后  配合一些  **特定数据结构**（比如List、Set、map，或者栈，队列 等等）及  常用**内置方法**，然后做一些**if条件判断** 。。。。

**暴力**的  **<u>本质</u>**  思想，就是把 **<u>数组</u>** 或 **<u>字符串</u>** 等等，里面的 **”所有情况“** 都列举出来，根据一些if判断，从而找出正确的答案，



书写算法的  **套路**   ：

① **判断**语句   if，else if，else

​    主要就是注意 if 的 括号（）里  判断终止条件的 书写，这个你得好好想清楚。可以  在草稿纸上 书写出来。

注意，在 if括号( )  里面的逻辑符号 ， 且 && ，或 || ，非 ！ 的 正确使用

注意, if 语句一般格式是  if  ( ) {   }     else if ( ) {  }     else if  ( )  {  }    else {  } 等

注意, if 语句可以嵌套   if  ( ) {   }    else {  if  ( ) {  }   else if ( )  { }   else { }  } 等

注意，也可以 并行  if   ( ) {  }  ，if   ( ){  } ，if  ( )  {  }   else if  ( ) {  }   else {  }  等

注意，也可以 并行  if   ( ) {  }  ，if   ( ){  } ，else ( )  {  }  等

注意，if 语句后面要不要接上 else，这个是有讲究的，如果 if ( ) { }  else{ }，if 后面直接接上了else的话， 只会执行其中一个。。如果 if ( ) { }  {....} 这样的话 ，if 后面的语句 {....} 肯定是 会执行的 



② **循环** 语句   for ， while

​    for 循环 主要是针对 固定 长度的 字符串或数组 等数据结构 ，注意  循环终止条件 是 ”固定“长度！一般就是nums.length等。但也有复杂 写法。如for循环的初始条件两个 变量，自增也有两个变量，for循环的终止条件    可以有 逻辑判断   且&& ，或||，非！

   for (**int t = 0, j = left **; j <= right; **j++, t++**){}    for (int i = 0; i < nums.length **&&** right < nums.length-1; i++) { }

​    while 循环的话，一般适合“不定”长度，循环终止条件 就很“灵活”了。可以是 while(true)，然后 通过   break      跳出死循环，也可以是复杂的 语句while( !stack.isEmpty())等等

​     注意，一般来说是 循环嵌套，比如for{  for {   }   } 或while{   while{  }  }或for{  while{	} } 或while{  for {  }  }  但是有时也可前后执行，其实就是 分成 2个 步骤进行处理 ,如 for {  } ,  while { } 或 while {  }  , for {  } 等其他组合。   记得要和   continue   以及    break    关键字 结合使用！！！

③ **if 与  while** 的 **联系**

​    if和 while 都有  判断语句  的味道 。只不过if 满足条件后，里面的语句块只执行   一次，而 while 满足条件后，里面的语句块可以 多次执行   

④ **判断**语句 与 **循环**语句的 **嵌套 使用**

​    有时候是 if 判断语句 里面 嵌套 循环语句for 或者 while ； 有时候也有 循环语句 while，for 内部 嵌套 if 等判断语句。你要随机应变，灵活运行！！！

⑤ 当题目很复杂 的时候  可以在原来的提供的主函数下面  ，**再写个 次函数**，用于 被上面的 主函数调用 

​	比如说 int twoSum(  ) {   ... }  这个是 主函数 ， 那么还可以在它的下面 写个次函数，用来被调用。比如   写一个 boolean fun( ) { ... }    。然后可以 比如在 主函数的  if 语句里面  调用  次函数，if ( fun ( ) ) } { ....}

⑥ 有时候很复杂的时候，也可以定义一个**全局变量**，比如 int count =0，作为累加次数，它也可以在次函数里面不断 ++，最后 在主函数里面 return count 即可。

## 二分查找

### 适用范围

当 int 整型数组  **<u>有序</u>** 的时候，或者  **<u>非递减</u>**  的时候，可以考虑用这个方法

### 方法详解

就是定义两个 边界指针，left 和 right ，在while循环里面，每次都先计算 mid下标= (left+right)/2 ，对应的元素 nums[mid] 和 target 比大小，如果 target 小于 mid对应的元素，那么 就去左半边 区域查找，记得 给  right = right -1 。。。否则就是去 右半边，那么 left = left +1 。。。

直到找到 nums[mid]== target ，就 return 返回  



## 双指针

### 适用范围



一般适用于 **数组、链表、字符串**  

双指针法使用的 大部分情况↑， 前提就是 **数组 或 链表** 已经是 **<u>有序</u>** 的状态！！！若数组 并非有序，可以 先使用 **Arrays**.**sort**( )方法 转为  **<u>有序</u>数组** 。如果 链表无序，那么就只能用 原始的方法，比如xx排序。 对于字符串 ，其实没啥要求 ； 较少↓情况下的话，其实 **不**需要 **排序** 的。



比如 会定义两个指针 ，比如慢指针slow，以及快指针fast，有可能它们每次都是移动1步，也有可能 fast移动2步，slow移动一步。也有可能是 相向指针，一个是 leftr左指针，一个是right 右指针。题目用 哪种 指针，要根据具体情况  ，具体分析 ！！

### 方法详解

[https://blog.csdn.net/zy_dreamer/article/details/131017948](https://blog.csdn.net/zy_dreamer/article/details/131017948)    这个可以记住代码模板 ，要背住它！！

https://www.bilibili.com/video/BV1iG411W7Wm/?p=3&spm_id_from=pageDriver  labuladong的视频用来理解



### 快慢指针

就是都在同一个数组里面，**快指针fast** 先在**前面快速**移动，**探路**。。。而 **慢指针slow**  在**后面慢慢**移动，一般是用来**保存最终结**果的

### 相向指针

就是都在同一个数组里面，一个 **left** 指针在 **左端 0处**  ， 一个指针 **right** 在最 **右端 length-1处**



### 分离指针

两个指针在不同的地方，比如在分别在两个  **不同 **的 **链表**







## 滑动窗口

### 适用范围

当出现	**子数组**，**子序列**，**子串**	的时候，或者有 **固定长度 的 序列**时候，或者**字符序列**的时候，就要优先 使用   <u>**滑动窗口**</u>    这个方法 。。但是有时候 使用 **<u>滑动窗口</u>**  不一定能解决这类问题。。。。。。

而且外层的循环  滑动窗口的  右边指针right   **只**遍历  **一次** ，  **只**  **走一遍** 整个数组 



### 方法详解

[https://blog.csdn.net/m0_65431718/article/details/130730847](https://blog.csdn.net/m0_65431718/article/details/130730847)  这里面有求 **最长** 或 **最短** 的 代码模板!!!

但是 **定长**的 代码模板 ，，，就是**内部**要换成  **if** ( 窗口长度**大于** > **k定长**的时候) { ...左边界++}

https://www.bilibili.com/video/BV1AV4y1n7Zt/?spm_id_from=333.788&vd_source=5fe50b1b35a25689fb0988c454fec5e0   这个是 labuladon 的 滑动窗口的讲解，主要是 加深 理解 



## 哈希表

### 适用范围

当我们遇到了要快速判断     这个元素  **是否出现过**  的时候 ，或 这个元素 **是否存在集合里**  ， 这时候就要想到 **哈希表** 这个方法



一般都是可以把之前的 双重 for 循环遍历， 而 哈希 表法， 只需要 从头 开始 for 循环 遍历 1次

一般 可以选择  [ ] 数组（固定长度）、set(可去重)、map （可以保存key和对应的value）这3种结构来进行解题。

其实就是 牺牲了	空间   换取了	时间

### 方法详解



### 数组

如果 题目的要求 ,可以确定 数组的  "**固定" 长度**是多少 。。。。那么就 考虑用这种方法

### set

当一道题的 长度  不受限制 的时候，并且 需要  "**去重**" !!! 所以 我们 应该 想到这个  set 集合。

而且 你 查找 某个元素 **是否出现过**，或  一个元素 是否在 集合 里，用**contains**(value)方法 也非常 方便。

### map

常用于  要  “**<u>映射</u>**”  的时候 ~~~~

比如 对于每个数组 元素值，还要 返回对应的 **它的下标**，你就可以 用map 集合。你就可以用key 存储 元素值 nums[i]，value存储 下标 i 。

比如 对于字符串中的 每个字符，你要统计出现  每个字符 **出现的次数 **。可以用 map.put()方法进行不断更新覆盖。不过一般都是 要配合 **getOrDefault**( , 0 ) 方法，因为如果这个字符没有出现过的话，那么就是返回1，不然的话就是返回它之前的出现次数 。 所以总体的写法就是 **map.put( ...  ,  getOrDefault( , 0 ) +1)**  。

对于字符串中 **是否存在重复字符**，也就是要先统计每个字符的出现次数，如果某个字符 **get( )，发现>1**，那么就说明 它这个字符 在 字符串中 出现过

比如 你 查找 某个元素 **是否出现过**，或  一个元素 是否在 集合 里，用**containsKey**(key)方法 也非常 方便。





## 栈与队列

### 适用范围

​    适合 “**<u>相邻</u>**” ，“**<u>匹配</u>**” 的情况，主要还是 “**<u>相邻</u>**”。大致的思路就是，如果匹配的话就要 “出”栈 pop( )；不匹配的话 “入”栈 push( ) 。。。这时候可能用        **栈**     的概率大一点

​	 如果**一端 **进入，**一端 **出去，比如  **固定长度k** 的 **滑动窗口**，就可以考虑用 **<u>队列</u>**



### 方法详解

### 栈

  一般就是 Stack 数据结构   

 **“先进后出”**，适合 “**<u>相邻</u>**” ，“**<u>匹配</u>**” 的情况，主要还是 “ **<u>相邻</u> **”。大致的思路就是，如果匹配的话就要 “出”栈 pop( )；不匹配的话 “入”栈 push( ) 。

### 队列

  一般就是 Deque 双端队列 数据结构

**“先进先出”**，如果一端 进入，一端 出去，比如  **固定长度k** 的 **滑动窗口**，就可以考虑用 **<u>队列</u>** 

### 单调栈

 一般就是 Stack 数据结构   

   一种特殊的栈。在栈的「先进后出」规则基础上。其中满足 **从栈顶到栈底的元素  是 "始终保持" 单调递增** 或 **单调递减**的 栈，**每次  加入或者  删除元素 时都保持序列里的元素  有序**，即保证 **栈顶**元素 始终是**最小值**或者  **最大值** ，叫做「**单调栈**」

每次元素入栈 时候，把某些元素 **出栈 丢弃**，从而保证 **有序**。要“  **手动**  ”编码实现，就是些 if **判断语句 **！  

​	https://www.bilibili.com/video/BV1my4y1Z7jj/?spm_id_from=333.788&vd_source=5fe50b1b35a25689fb0988c454fec5e0     视频版本

​     https://blog.csdn.net/weixin_50348837/article/details/136304458   文字版本，含有 **代码模板**



总结一下 单调栈里，存放的是  数组num[ ]元素的什么 （这个得看具体题目要求什么）：

① 元素的下标，这个更常用！！

② 元素值

总结一下选 递增 or 递减栈（因为这会决定 **代码模板** 某些地方的书写）：

① 如果题目中 找左边或者右边 比当前遍历元素 大的元素时候，那么就用 单边递增栈↑。栈顶-栈底，递增

② 如果题目中 找左边或者右边 比当前遍历元素 大的元素时候，那么就用 单边递减栈↓。栈顶-栈底，递减

总结一下：

① 不管是什么类型的题目，**都是**   for循环从左到右开始遍历  数组num[ ] 



### 单调队列

  一般就是 Deque 双端队列 数据结构

  一种特殊的队列。在栈的「先进先出」规则基础上，**<u>队列</u>**中的元素  **"始终保持" 着单增或者单减**  的特性。
在每次  **加入或者  删除元素** 时都**保持序列里的元素**  **有序**，即保证  **队首元素** 始终是  **最小值**或者  **最大值** ，叫做「**单调队列**」

每次元素入队 时候，把某些元素 **出队 丢弃**，从而保证**有序**。要“ **手动** ”编码实现，就是些 if **判断语句** ！

https://blog.csdn.net/m0_63997099/article/details/137123780  看 二、 就行 



① 其实这个 单调队列和 单调栈有点像的。。。一般都是存入元素的 下标。。。

② 单调递减队列↓，队头是最大的元素 

​     单调递增队列↑，对头是最小的元素



### 优先级队列

  一般就是使用 **<u>PriorityQueue</u>** 数据结构，，，你要可能会联想到 Arrays.sort( ) 和 Collections.sort( )  ，这两个方法，是把已经存在的 [ ] 数组 或者 list集合，直接整个扔进去，直接  获得排序后的结果，比如升序的数组； 而  **<u>PriorityQueue</u>** 是需要把 数组的元素 nums[i] 通过for循环，一个个地添加进去，是一个 循序渐进的 不断排序    的过程。。。。别搞混了！！！

  **<u>优先级队列</u>** ，它基于 **堆** 的，其实就是一颗 “**特殊**” 的 **完全二叉树**。

   分为 **小顶堆** 和 **大顶堆**。**小顶堆**的  根节点元素  **最小**，  小于等于  其子节点；**大顶堆 ** 根节点最大，大于等于 其子节点。 **小顶堆** 可以保证输出的元素 是 **升序的**↑；**大顶堆** 可以保证输出的元素 是 **降序的↓**；

   每次元素入队 时候，**不需要** 出队  **丢弃** ！！！

​	**<u>优先级队列</u>**，**默认**是  **小**顶堆，也就是 **升序↑** 。也可以指定**大**顶堆，为1降序↓的~~~

![image-20240724202518330](C:\Users\zwj90\AppData\Roaming\Typora\typora-user-images\image-20240724202518330.png)

https://blog.csdn.net/studyForMokey/article/details/128955587  看 二、





## 回溯

### 适用范围

当遇到 **组合**、**切割**、**子集**、**排列**  问题的时候，可以想到用  **<u>回溯算法</u>**。其实它就是 " **<u>递归</u>**" 的一种运用。。

就是 **穷举** 所有情况的感觉。。。。

### 方法详解

https://programmercarl.com/%E5%9B%9E%E6%BA%AF%E7%AE%97%E6%B3%95%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%80.html#%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%80  这里面的  思路可以参考一下，然后的话，里面还有  **代码模板**！！！其实和 "递归三部曲“。。挺像的



### 组合

**注意点**：

​     不过这里建议的是保存每次的 **临时路径结果** 的用 **List<...> temp**或者其他 **StringBuilder temp**等等类型。然后最终的 **所有结果**的 用**List<List<...>> res**或者 **List<...> res**  ，它们都定义最外面的**全局变量**，被下面的**<u>回溯函数</u>**递归的时候不断添加和更新。

   然后在**自带主函数**直接**调用**下面 自定义  **<u>回溯函数</u>**  就可以了，传入自带形参，有时候要传入额外形参，以及传入 **startIndex** 形参的初始值0，或者1，这个  **startIndex**  参数的**含义**就是，每次**取当前**元素  or  **当前元素的下一个**元素，，，而**不会取** 前面**上一个**元素 ！！！！

①   **<u>回溯函数</u>**的  **返回值 **和  **参数** 

​		基本上 **返回值**   **都**是 **void**，很少是其他类型  

​		**参数**的话，可能**比较多** 。肯定要有题目给的 自带形参，然后根据情况，再增加几个额外形参。。。

​		比较常见的是，会新增一个 **startIndex**  参数，代表 每次递归 向右边**选择的元素**是哪个 ， 从哪个    **开始**，**起始路径**的临时答案中的 **元素** 是哪个，下次递归是  **从自己元素**  开始，或 **自己的下一个**元素开始！  不同的题目 ，它具体的含义有一点点差异的。。。

②    **<u>回溯函数</u>**的  **递归终止条件 **

​		一般就是if(...) {  结果集   存放临时路径答案 return } ，重点还是括号(...) 里面的书写。 一般就是 if ( ) 判断到了答案的长度时候，就停止递归了。或者就是 遍历到末尾了。

​	    然后这里的话，有个**细节**，就是 res 结果集，存放临时路径答案 temp 的时候，必须是res.add（**new ArrayList<>(temp)**），开辟一个独立的 对象！！！如果是 res.add(temp)的话， 结果集的 临时路径答案temp 会受到每次递归影响，而一直变化。。因为它是传入的引用类型嘛，指向同一个地址了。。。

③	**<u>回溯函数</u>**的  **单层递归逻辑 **

​		可能**for循环的上面 **还需要再加一些  代码逻辑 ！！这个要根据不同的题目。。。

​		单层的递归逻辑，主要就是for循环的逻辑。比如for循环的  for **( )**  括号里面的书写，i=**startIndex**，有时候for循环的 i又=**0** 。如果是从 **一个选择集合** 里面取，就是 i=**startIndex**！从 **两个选择集合** 里面取，就 **i=0**。然后就是小于   数组的长度 或者 字符串的长度。最后当然是 i++

​	    然后是for **{ ... }**里面的具体写法了， 首先是 单个答案的每次**添加**元素，list.**add**()或者 str.**append**()等等

​	   然后是递归调用自己的 **<u>回溯函数</u>**，一般是，如果自己元素取过了，**不能重复** 取，要**递归取自己元素的下一个**，那么就传入**backtracking**(自带参数，额外参数，**i+1**) 或  **backtracking**(自带参数，额外参数，**startIndex+1**)！！！如果是 可以自己元素取过了，下一层递归 **还可以从自己元素 **开始**重复**取，那么就是传入 **backtracking**(自带参数，额外参数，**i**) 或  **backtracking**(自带参数，额外参数，**startIndex**)

​       最后是 **撤销**上次递归的添加元素，也就是说  **移除末尾**  元素 ，一般是 temp.**remove**(temp.size()-1) 或 temp.**deletecharAt**(str.length()-1)

### 分割  

​	其实就是建立在组合的基础上的。。。。

**注意点**：

​    这部分和组合的差不多

①   **<u>回溯函数</u>**的  **返回值 **和  **参数** 

​		这里有点区别的就是，常见的 **startIndex** 参数含义变了，代表  **切割线**，每次递归向右边 **从哪个字符** 开始 **切**，从哪个开始，下次递归是从自己元素开始，或 自己的下一个元素开始。不同的题目，它具体的含义有一点点差异的。

②    **<u>回溯函数</u>**的  **递归终止条件 **

​     这里有点区别，有些题目，**有可能还要 **在 if( ... ){  **if(...)** 结果集 存放临时路径答案 return }，递归出口 if() 里面可能 **还要多一次** if 判断，符合的才会最终被添加到结果集。

​	    

③	**<u>回溯函数</u>**的  **单层递归逻辑 **

​		这里唯一的区别就是，需要获得**每次切割**的 **子串**，基本上就是  **[startIndex,i]**  左闭右闭区间，所以  经常需要配合 字符串的 **substring**(s,startIndex,**i+1**)方法，记得是 **i+1**，因为右边下标是 取不到的。然后的还要经常**配合** 下面定义的**次函数** 是否符合条件，所以写法变成了  for(....) {  **if ( 次函数 ) { 回溯逻辑... }** }，只有**符合条件**的子串， **才需要 ** 回溯递归。

​		**有时候，有可能**, **只需要**对**原始的 字符串**String进行 **操作 **就可以了，所以的话就是 **不需要temp.add()**了

### 子集

​	也是建立在组合的基础上。。	但是  **<u>求子集</u>** 问题  和  组合问题 **不一样**。**求组合**问题是**收集叶子节点**，**<u>求子集</u>**问题是收集  **<u>所有的节点</u>**！！

**注意点**：	

​    这部分和组合的差不多

①   **<u>回溯函数</u>**的  **返回值 **和  **参数** 

​	  这部分和组合的差不多

②    **<u>回溯函数</u>**的  **递归终止条件 **

​     这里有点区别的是 ， 要在 if(...){  return } 的**上面写上** ，结果集 存放临时路径答案 res.add( )！！！因为这样才是对 **<u>每一个节点</u>** 收集结果 ！！！所以 **递归出口 ** 里面就  **不用写**res.add( ) 。。。。。

​	    

③	**<u>回溯函数</u>**的  **单层递归逻辑 **

​		  这部分和组合的差不多

### 排列

​	和 组合问题  **区别挺大**的   ！！！  又因为  {1,2} 和 {2,1}  都是  **符合**的答案，那么**for循环 横向遍历**  →   时候，每一次都要从 **i=0** 开始遍历，可以 **再去选**取   **前面上一个**的元素，那么就需要 **used数组[ ]**  √  记录此时的 temp 临时路径答案，里面 **已经选了** 哪些元素，如果该元素 **用过了**，就  **不需要**  再选它了

**防止** **重复**选取！！！   主要就不需要 startIndex 参数了 ×   。。。。。

**注意点**：	

​    这部分和组合的差不多

①   **<u>回溯函数</u>**的  **返回值 **和  **参数** 

​	   主要区别在于，传入参数的话，只要一个 **used数组[ ]**  √  ，初始值  **boolean[] used = new boolean[nums.length]**  ！！！！ 不需要startIndex参数了 ×  

②    **<u>回溯函数</u>**的  **递归终止条件 **

​    这里和组合差不多

③	**<u>回溯函数</u>**的  **单层递归逻辑 **

​		  这里主要区别，就是 **for循环**的 （） 括号里面，**i = 0** 了！！！要从0下标开始，因为"排列"，{1,2} 和 {2,1} 两个答案，都是 **符合答案** 的。所以 我们都是可以选择 **前面上一个的元素**，那么就是要从 i =0 下标开始选。

​			然后for循环的 {...} 递归逻辑里面的话，**每次都要** 判断  **if(used[i]==true)** ，就要 **coninue 跳过**。毕竟 上一个选过的元素   只能选一次，**不能重复**选择！！！ 

### 其他

​	  解法就五花八门了。。。



## 动态规划

### 适用范围

   当遇到 **基础** ( 斐波那契数，爬楼梯，不同路径 )、**01背包** ( 每个物体只能取一次 )、**完全背包**（每个物体 可以重复取）、**打家劫舍**、**子序列** ( 子串和 子数组一般是连续，子序列一般是不连续的。。编辑距离的题目都是不连续的。。回文的题目 也分 连续和 不连续)  这几类  题型的时候，一般都是要用   **<u>dp 动态规划</u>** 去做的。其实它就是  **<u>for循环</u>** 遍历，把dp[i]挨个**赋值**，最后就可以求出答案了

​	每一个状态 dp[i]，一定是依赖 上一个状态dp[i-1] 推导得来的。

### 方法详解

https://programmercarl.com/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%80.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE   有 **dp五步曲**  的解题思路 。。但是没有代码模板。。



### 基础

**dp五步曲**：

① **确定dp数组**，以及 **下标的含义**。这个**也很重要**！！dp数组可能是**一维**的 dp[i]，也可能**二维**的dp[i] [j] 。 也就是说要写出文字，比如 第 i个斐波那契数是 dp[i]， 第i阶楼梯有 dp[i]种解题方法 。。。**基本上**的话，都是 按照   **字符串** str.length()或**数组的长度** nums.length，来**确定dp数组的长度**的 ！！！！

② **递推公式**，也就是 **状态转移方程 **。这个是 **最难想** 的，但也是解题的 **核心**！！！可以根据题目的例子，举一点，看看前后之间的关联性，或许可以推出来。。。。。

③ **初始化 **dp数组。这个**也很重要**的！！如果 dp数组 是**一维**，那么 dp[0] = 和 dp[1]=   ；如果 dp数组 是**<u>二维</u>**，那么就是先通过 for 循环，第一列 dp[i] [0]  =  和 第一行 dp[0] [j] = 。 

④ **遍历**的 **顺序**。这个**也很重要**的！！如果 dp数组 是**一维**，一般都是 从前往后→，但也可能 从后往前 ← 遍历计算， **一般是一层** for循环，而且一般从 **i =2**开始遍历计算；如果 dp数组 是 **<u>二维</u>**，还要考虑从上往下↓，还是 从下往上 遍历↑，**一般是双层** for循环，但是 内外for循环 分别 遍历什么，也有讲究的，for循环 一般都是 **从i=1开始 **遍历计算。

⑤ 打印dp数组。这个就是你写完代码，看看和 定义的dp含义是否一致，但是没有跑通的情况下，你才需要这么做 。。。。

​     但是 ！！！上面的是  dp题目的思考过程。。。实际上 **写代码**的时候，**顺序**是 ①-->③-->④-->②

​      注意 ！！！**一般**来说。。。最后的答案结果都是 return 返回  dp[**nums.length-1**] 



### 01背包

​     01背包问题，主要就是 有N件物品和一个最多能背重量为W 的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。每件物品**只能**  用**一次**，求解将 哪些物品 装入背包里物品 价值总和最大。。。

​     

​    最主要！！**提取题目**中的  有效**信息**，剥去题目 外壳， **必须得到** 所谓的   **背包的固定常数的容量 **是多少 ！！一般来说，题目中的数组每个**元素nums[i]**就是 每一个**物体**，  每个数组**元素的值** 就是 物体的**重量**

​    下面的 代码步骤，  对于**不同的题目**，都**只是**往这个  背包模板的 “**应用**”。。有些细节上的地方会和原本的**代码不同**。。。比如 初始化 dp的时候；再比如 双层for循环遍历计算 的时候；对于不同的if分支计算

递推公式的时候（不一定是 max比较 两种值）。。。。

**dp五步曲**：

① **确定dp数组**。补充的话，这里采用的是 最容易的理解的 **二维dp数组** dp[i] [j] 的方法。这里的话对于     背包的容量话，还要考虑 它是 背包容量为0 的时候，所以 dp定义的时候，**列**的长度  还要记得 **+1**

 <img src="https://piggo-zwj.oss-cn-shanghai.aliyuncs.com/leetcode_pig/image-20241102150005706.png" alt="image-20241102150005706" style="zoom:25%;" />

![image-20241102150059049](https://piggo-zwj.oss-cn-shanghai.aliyuncs.com/leetcode_pig/image-20241102150059049.png)

<img src="https://piggo-zwj.oss-cn-shanghai.aliyuncs.com/leetcode_pig/image-20241102221236239.png" alt="image-20241102221236239" style="zoom: 50%;" />

② **递推公式**。补充的话，只有 当前遍历的 **第i个物体**的 重量，**小于** 背包容量j 的时候，**才考虑**的递推公式

<img src="https://piggo-zwj.oss-cn-shanghai.aliyuncs.com/leetcode_pig/image-20241102233341296.png" alt="image-20241102233341296" style="zoom:33%;" />



<img src="https://piggo-zwj.oss-cn-shanghai.aliyuncs.com/leetcode_pig/image-20241102233416241.png" alt="image-20241102233416241" style="zoom:33%;" />





<img src="https://piggo-zwj.oss-cn-shanghai.aliyuncs.com/leetcode_pig/image-20241102233441301.png" alt="image-20241102233441301" style="zoom: 50%;" />

<img src="https://piggo-zwj.oss-cn-shanghai.aliyuncs.com/leetcode_pig/image-20241102150119164.png" alt="image-20241102150119164" style="zoom: 50%;" />





③ **初始化 **dp数组。补充的话，首先是对于 **第一列**的初始化。

<img src="https://piggo-zwj.oss-cn-shanghai.aliyuncs.com/leetcode_pig/image-20241102220309670.png" alt="image-20241102220309670" style="zoom: 33%;" />

   然后的话，就是对于 **第一行**的初始化。

​		![image-20241102220924033](https://piggo-zwj.oss-cn-shanghai.aliyuncs.com/leetcode_pig/image-20241102220924033.png)



④ **遍历**的 **顺序**。补充的话，一般都是 **先**外层for循环 i 遍历**物体**，**然后** 内层for循环 遍历 j **背包**容量。

![image-20241102232508951](https://piggo-zwj.oss-cn-shanghai.aliyuncs.com/leetcode_pig/image-20241102232508951.png)



<img src="https://piggo-zwj.oss-cn-shanghai.aliyuncs.com/leetcode_pig/image-20241102221117839.png" alt="image-20241102221117839" style="zoom: 50%;" />

⑤ 一样思路。。。

​	   

### 完全背包



​    完全背包问题主要就是，某个物品 i ，可以 **重复选取** 多次。。。

​    主要就是 在   **递归公式逻辑** 和 01背包不太一样 ！！！！！！！！

​     已经不是 第i个 物品 **小于** 背包的时候 分两种情况： **取 还是 不取了**，，，这里考虑的 ！！！

**dp五步曲**：

① **确定dp数组**。差不多



② **递推公式**。补充的话，当 **第i个**物品  **小于** 背包容量的时候，**还是**分  **两种**情况： **取 还是 不取了**。。。。**只是扩展地**去考虑， 第 i个物品 可以**取几个** 。。。。。0，1，2，3... k 个

  所以 dp[i] [j] = Math.max(dp[ i-1] [ j] ， dp[ ] [ j-] +1 )；





③ **初始化 **dp数组。差不多



④ **遍历**的 **顺序**。差不多



⑤ 一样思路。。。



### 打家劫舍

都差不多。。。。



### 子序列

**dp五步曲**：

① **确定dp数组**。补充的话，dp数组是**一维** dp[i]，比如代表 以i 下标为结尾的最长子序列的长度是 dp[i] ；如果是**二维 **dp[i] [j] ，比如代表 字符串在 [i,j] 下标范围的最长的子序列的长度是 dp[i] [j] ，还有表示在nums1中以下标 i 为结尾，nums2中以下标 j 为结尾的公共子序列长度是dp[i] [j] 。**有时候**的话，都是 按照这个字符串或者 输入数组的 **长度 +1** ，来**确定dp数组的长度**的，就是多考虑  **空串！！**的 **这一列** 和 **这一行** 的情况。。。而且有可能是会多定义而且 **<u>还可能</u>** 会定义成   **<u>boolean类型</u>**  的 dp数组 ，每个格子的值是 true 和 false 。。。

② **递推公式**。补充的话，**在某些条件**下，**才会**有递推公式，**<u>不同</u> if条件**下的 **递推公式  是<u>不同</u>**  的！！！

③ **初始化 **dp数组。补充的话，如果 dp数组 是**一维**，那么 **<u>先通过for循环</u>** 遍历 <u>**dp[i] =**</u>  ；如果 dp数组  是 **二维**，那么就是先通过 for 循环，遍历第一列 dp[i] [0]  =  和 第一行 dp[0] [j] =  ，也<u>**有可能是 dp[i] [i] =**</u> 

④ **遍历**的 **顺序**。补充的话，如果 dp数组 是 **一维**，一般遍历计算 都是 从前往后→，但也可能  从后往前  ←， **一般用一层** for循环，**从前往后**遍历→，一般**<u>从 i =1开始</u>** 遍历计算，**很少是二层 **for循环。。 ；如果 dp数组 是 **<u>二维</u>**， 如何确立   **<u>遍历顺序</u>**，就需要 **<u>画图！就是2*2的正方形格子</u>** 画出来，再根据 **递推公式**，就能知道     <u>**遍历顺序**</u>了，是考虑从上往下↓，还是 从下往上 ↑遍历，如果是从下往上 ↑遍历的话，**双层for **循环 一般都是      **外层for循环 的 i= len-1 开始遍历计算，<u>然后内层for循环 j 的话</u> 要么就是 i，要么就是 i+1**，**j** **或者**是 **其他值**。。。 **双层**for循环，如果是 正常遍历的 **从上往下↓**的话，那么就是 **i=1，j=1**这样子。。如果是 **很少是一层 **for循环。。

⑤ 一样思路。。。

​	   补充的话，"子序列"问题， **一般来说**的话！！！而是返回 reutrn  第三者变量，比如**一直在比较**的 **max** 最大值  ！！！！很少 return 返回 数组的**末尾**下标， dp[nums.length]  。。。

## 贪心

这个方法其实是最难的。。。因为没有特定的接替套路。。。





# SQL语句



<img src="https://piggo-zwj.oss-cn-shanghai.aliyuncs.com/leetcode_pig/image-20240927112140055.png" alt="image-20240927112140055" style="zoom: 33%;" />



0、一些特殊的函数

​	 ① 当查询到 一些列不存在，显示为null值的时候，我们也要给他 显示值，比如 s_score 分数 是 null值，要显示成 0 ，就要用到 ifnull( , )函数 。 比如 ifnull ( s_score , 0 )  

​    ② 比如对 聚合函数求出来的值，需要保留几位小数，可以用round( , ) 。比如 round ( avg ( s_score ) , 2) ，就会保留2位小数

​    ③ 如果要对 日期进行截取。获取现在的时间，now( )；截取 年份，用 year(now( ))函数；月份的话，就是 month(now( )) ；第几周，用 week( now( ) )；每月的几号，是 day(now( ))；对日期的显示 进行格式化，date_format( now( ), '%Y%m%d') ，其实就是把 中间  -  去掉了



1、sql语句的 关键字 书写顺序。。 select 、from、join 、on、where、group by、having、order by 

​	但执行顺序的话！ ！ from、join 、on、where、group by、having、select 、开窗函数、order by 




2、对于sql语句的 起别名，也有些说法的。

​	① 比如 给某个表 取别名 from student a  ，那么下面的 where  以及 group by，having，order by 以及最前面的select ，如果要取里面的 列名，必须是    a.列名     。。。

​    ②  注意注意！！！即便是  from  临时表 ，临时表 里面定义的别名，在外层的话也是可以 使用的 



3、如果 select 显示的 多个字段在 不同的表 里面，所以 尽量用     多表连接 ！！！ 来代替 不必要的子查询。。。。

​	 ① 一般用 from  。。。where 。。。 进行 多表连接 就行。它其实是隐式的 inner join 内连接。 

​	 ②如果有特殊需求！！比如 要显示 没成绩的学生，那么才。。要考虑左外连接 left join 或者  右外连接 right join。。

​	 ③ 特殊特殊情况！！！那么 什么时候用自连接，也是多个表连接， 只不过呢。。就是 两张相同的表。

​	    如果题目出现，  同一个字段要满足 两个 条件值，比如  课程号'01'  比 课程号 '02'。或者 同一个字段要求 值不同，比如 不同 课程。



4、那么问题来了，子查询 什么时候才用呢？

​		①   in 某个范围的时候， select 。。 from 。。 where  。。in（select 。。）  

​		②  某个字段 = 最值 ， select 。。 from 。。 where 字段 = （select max(..) from ... where ....）

​		③  也可以在 from 后面出现，其实就是多了个 临时表， 比如 select 。。 from （select 。。from 。。where ）a  where 。。。



5、用了 group by 分组查询的话，select 只能 出现 group by 后面的列、聚合函数、常数。。。

​	 ① 但是 对于 聚合函数( )里面的列名，可以随便  ~  ~

​	 ②  对于 group by 后面，也可以接多个 列名的，如果要题目要 显示的列名多，那么group by后面就要 对应的 加上几个列名，比如 select  a ,b   from 。。where 。。。group by  a,b

​	 ③ 这里有一个潜规则，也就是说 当 group by 主键的时候，比如 group sid ，那么 select 的时候，可以显示 其他的 列名 ，也就是  select   sid，sname   from 。。。where 。。group by sid 

​     ④ group by 后面一般也要接 having 关键字，having 关键字 主要是使用 聚合函数作为判断条件，比如 select c_id from score group by c_id having max(score) >60 



6、order by 排序，可以指定一下， 升序 还是 降序。

​	  ① order by 后面也可以接 两个列名，就是指，当前面那个列 相等的时候，后面的 列 按照 升序或 降序

​       

7、最近新学的关键字 ，case when  表达式  then  返回值 else 返回值 end 它常常 与 聚合函数一起用。   那么当然也会涉及到 分组 group by 咯。如 要查看成绩表，每个课程 里面，分数大于85分的人数有多少个  select  c_id  , sum(case when s_score>=85 then 1 else 0 end)  '[100-85]'   from   score    group by   c_id



8、最近新学的 开窗函数，这个也很重要！！主要作用就是，可以多显示一列，按照每个"分组"，排序显示 里面的 排名，第几名。。。不过这里面的话，和之前的 group by 分组是有区别的，以前就是 把所有的     比如 c_id =1 的 记录 浓缩成一行，但是 这里的 开窗函数，"分组"的意思指，c_id =1的所有记录是 全部显示的，然后按照另外一个列进行“组内”排序，主要是返回 多行记录 ！！！

​		 [SQL开窗函数（窗口函数）详解_sql开窗函数详解-CSDN博客](https://blog.csdn.net/qq_31183727/article/details/107023293)

​    ①   因为在 sql语句执行顺序上：from > join > on > where > group by > having > order by > select  

   而 partition by 应用在这些 关键字 之后，可以简单理解为 在执行完 select 之后，在所得 结果集 之上，再进行partition by 分组，以及它后面的 order by 排序。

​     ② 推荐的写法，就是开创函数 rank( ) over( partition by  列名1 order by 列名 2)  rk 里的列名1 和列名2 都要写在 select 的后面 ，这样子更加清楚一点。。。也就是 select    列名1  ， 列名 2   ， rank( )   over  ( partition by  列名1 order by 列名 2  )  rk

​      ③ 常见的就是   rank( )   、rank_dense ( )   、row_number( ) 

​        rank( )  over （partition by  列名1 order by 列名 2 ）前两名如果相等，并列第1，第三个就是 第3

​		rank_dense ( )  over （partition by  列名1 order by 列名 2 ）,前两名如果相等，并列第1，第三个是 第2

​       row_number( )  over （partition by  列名1 order by 列名 2 ）,相等的话，仍然按照最前面的id行号 来排序 ，没有 并列第1的说法。。

​	  ④ 其实 rank( ) over( partition by  列名1 order by 列名 2  )里面的 partition by 可以不写，也就是可以不在每个 分组 里面进行排序，直接在所有的 记录里面进行排序。。。也就是写成 rank( ) over( order by 列名 2  )

​       ⑤ 其实也可以和 group by 分组一起连用，也就是 先gropup by 分组，对分组之后的结果，再 开窗。

 

​        

```sql
#1. 查询‘01‘课程比‘02’课程成绩高的学生信息以及课程分数  --->自连接,因为在一张 score表里面 不可能 where c_id = '01' and  c_id = '02' 同时成立的。。。所以要对 score 自连接。。。
SELECT
	c.*,  
	a.s_score  s01,
	b.s_score  s02 
FROM
	score  a,
	score  b,
	student  c 
WHERE
	
	a.s_id = b.s_id 
	AND a.c_id = '01' 
	AND b.c_id = '02' 
	AND a.s_score > b.s_score
	AND c.s_id = a.s_id 



	
#3. 查询 平均成绩 大于等于60分的 同学的学生编号和学生姓名和平均分  
SELECT
	a.s_id,
	b.s_name,
	avg(a.s_score) avg_s 
FROM
	score a,
	student b 
WHERE
	a.s_id = b.s_id 
GROUP BY
	a.s_id,
	b.s_name
HAVING
	avg(a.s_score)>= 60;
	

#4. 查询平均成绩小于60分的同学的学生编号和学生姓名和平均分(包括有成绩和无成绩的学生) -->所以就要用  外连接了，并且要处理 null值，通过 ifnull(,) 函数
SELECT
	a.s_id,
	a.s_name,
	ifnull(avg(b.s_score),0) avg_s 
FROM
	student a
	LEFT JOIN score b ON a.s_id = b.s_id 
GROUP BY
	a.s_id,
	a.s_name 
HAVING
	ifnull(avg(b.s_score),0)< 60;
	
	


#5. 查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩(没有成绩的学生，也要查出来)  -->  所以就要用  外连接了，并且要处理 null 值，通过 ifnull(,) 函数
SELECT
	a.s_id,
	a.s_name,
	count(b.c_id) count,
	IFNULL(sum(b.s_score),0) sum 
FROM
	student a
	LEFT JOIN score b ON a.s_id = b.s_id 
GROUP BY
	a.s_id,
	a.s_name

#6. 查询“李”姓老师的数量
SELECT
	t_id,
	t_name,
	count(t_id) cont 
FROM
	teacher 
WHERE
	t_name LIKE '李%'

#7. 查询学过“张三”老师授课的学生信息
SELECT
	a.* 
FROM
	student a,
	teacher b,
	course c,
	score d 
WHERE
	d.s_id = a.s_id 
	AND c.t_id = b.t_id 
	AND d.c_id = c.c_id 
	AND b.t_name = '张三'
	
#8. 查询 没有学过 “张三”的授课的学生信息  --->要用 not in 配合一个子查询，如果只是 对 第7题 改成  != ，那么就会重复显示学生 。。。
SELECT
	* 
FROM
	student 
WHERE
	s_id NOT IN (SELECT d.s_id FROM teacher b,course c,score d WHERE c.t_id = b.t_id 
					AND d.c_id = c.c_id AND b.t_name = '张三')


#9. 查询学过编号为 ‘01’并且也学过编号为‘02’的课程的同学的信息
SELECT
	c.* 
FROM
	score AS a,
	score AS b,
	student AS c 
WHERE
	a.c_id = '01' 
	AND b.c_id = '02' 
	AND a.s_id = b.s_id 
	AND c.s_id = a.s_id

#10. 查询学过编号’01‘  但是 没有学过‘02’ 的同学信息  ---> in 和 not in 一起用,配合 子查询

SELECT
	* 
FROM
	student 
WHERE
	s_id IN (SELECT s_id FROM score WHERE c_id = '01') 
	AND s_id NOT IN (SELECT s_id FROM score WHEREc_id = '02')
	           
	
	
#11. 查询 没有学全 所有课程的 同学信息--> 需要用到 子查询 ！！！有时候感觉它使用也挺广泛的 。而且这道题的话，就要用 左外连接 left join，因为还要把没选课的学生，也包括进去！！！
SELECT
	a.id,
	count(b.c_id) cnt 
FROM
	student a
	LEFT JOIN score b ON a.s_id = b.s_id 
GROUP BY
	a.s_id 
HAVING
	count(b.c_id)<(SELECT count(c_id) FROM course)


#12. 查询至少有1门课 与 ’01‘同学的所学课程相同 的同学信息(结果记得 要排除 ‘01’同学)
SELECT DISTINCT
	a.* 
FROM
	student a
	LEFT JOIN score b ON a.s_id = b.s_id 
WHERE
	b.c_id IN (SELECT c_id FROM score WHERE s_id = '01') 
	AND a.s_id != '01'




#15、查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩
SELECT
	a.s_id,
	a.s_name,
	avg(b.s_score) 
FROM
	student  a
	LEFT JOIN  score b ON a.s_id = b.s_id 
WHERE
	b.s_score < 60 
GROUP BY
	a.s_id,
	a.s_name
HAVING
	count(b.s_score)>= 2;
 
#16、检索"01"课程分数小于60，按分数降序排列的学生信息
SELECT
	a.*
FROM
	student a,
	score b 
WHERE
	a.s_id = b.s_id 
	AND b.c_id = '01' 
	AND b.s_score < 60 
ORDER BY
	b.s_score DESC;
	
#17、按 平均成绩从高到低 显示 所有学生的 所有课程的成绩 以及 平均成绩 -->这道题稍微有点难度，这里的话就是用到了 from 临时表，这个是子查询查出来的 ， 目的就是，可以通过对这两个 临时表进行 多表连接，在原有的score 表的后面接上 avg_score这个列，方便 order by 排序 
select 
	a.s_id,
	a.s_score,
	b.avg_score
from 
	(select * from score) a,
	(SELECT s_id,AVG(s_score) avg_score from score GROUP BY s_id) b
where 
	a.s_id = b.s_id

order by 
	b.avg_score DESC            
         
         
         
#18. 以如下形式显示：课程ID，课程name，最高分，最低分，平均分，及格率，中等率，优良率，优秀率。 及格 >=60，中等 70-80，优良 80-90，优秀 >=90  --> 这里就很适合 case when ，再配合 聚合函数就能实现这个查询了。 用到了 round(x,d) 函数主要是进行数值的小数点保留， d是指保留几位小数。
select 
	a.c_id,
	b.c_name,
	MAX(s_score) max_score,
	MIN(s_score) min_score,
	ROUND(AVG(s_score),2) avg_score,
	ROUND(100*(SUM(case when a.s_score>=60 and a.s_score<=90 then 1 else 0 end)/SUM(case when a.s_score then 1 else 0 end)),2)  及格率,
    ROUND(100*(SUM(case when a.s_score>=70 and a.s_score<=80 then 1 else 0 end)/SUM(case when a.s_score then 1 else 0 end)),2)  中等率,
	ROUND(100*(SUM(case when a.s_score>=80 and a.s_score<=90 then 1 else 0 end)/SUM(case when a.s_score then 1 else 0 end)),2)  优良率,
	ROUND(100*(SUM(case when a.s_score>=90 then 1 else 0 end)/SUM(case when a.s_score then 1 else 0 end)),2)  优秀率
from 
	score a,
	course b 
WHERE 
	a.c_id = b.c_id 	
GROUP BY 
	a.c_id
    
    
#19、按各科成绩 进行排序，并显示排名 -->开窗函数，rank()的使用  

SELECT
	c_id,
	s_score,
	rank() over (PARTITION BY c_id ORDER BY s_score DESC) rk 
FROM
	score
	 	
		
#20、查询学生的总成绩 并进行排名  --->这里用到了 from 临时表，临时表 是通过 子查询 得到的。其实这样的写法也是越来越多见了。。 先通过 子查询，里面的分组查询，以及聚合函数 得到每个学生的总成绩，作为临时表。。。 而且 还要用到开窗函数 rank() over ，毕竟要显示 排名，第几名。


SELECT
	t.*,
	rank() over (ORDER BY sum DESC) rk 
FROM
	(SELECT s_name, sum(s_score) sum FROM score a,student b where b.s_id = a.s_id
	 GROUP BY s_name) t
	
	
#21、查询不同老师所教不同课程平均分从高到低显示 


SELECT
	a.t_name,
	b.c_name, 
	ROUND(avg(s_score),2)  avg_score 
FROM
	teacher a,course b,score c 
where	
	a.t_id = b.t_id
  and  b.c_id = c.c_id 
GROUP BY
	a.t_name,
	b.c_name 
ORDER BY
	ROUND(avg(s_score),2) DESC


#22、查询 所有课程 里面，成绩第2名到第3名的学生信息及该课程成绩-->用到了from 临时表，通过子查询得来的，这个子查询里面 用到了 开窗函数。。。

select 
	a.*,t.s_score
from
		student a,
		(select 
			s_id,
			s_score,
			rank() over (ORDER BY s_score desc) rk
		from score) t 
WHERE
	a.s_id = t.s_id
	and t.rk between 2 and 3 

#23、统计各科成绩各分数段人数:课程编号,课程名称,[100-85],[85-70],[70-60],[0-60]及所占百分比
 
select 
 	b.c_id, 
 	b.c_name, 
	sum(case when a.s_score>=85 then 1 else 0 end)  '[100-85]人数',
	sum(case when a.s_score>=70 and a.s_score<85 then 1 else 0 end)  '[85-70]人数',
	sum(case when a.s_score>=60 and a.s_score<70 then 1 else 0 end)  '[70-60]人数',
	sum(case when a.s_score<60 then 1 else 0 end)  '[60-0]人数',
	sum(case when a.s_score>=85 then 1 else 0 end)/count(a.s_id)  '[100-85]百分比',
	sum(case when a.s_score>=70 and a.s_score<85 then 1 else 0 end)/count(1) '[85-70]百分比',
	sum(case when a.s_score>=60 and a.s_score<70 then 1 else 0 end)/count(1)  '[70-60]百分比',
	sum(case when a.s_score<60 then 1 else 0 end)/count(1)  '[60-0]百分比'
from 
	score  a,
	course b
where 
	a.c_id=b.c_id
group by 
	b.c_id, 
 	b.c_name
 

#24、查询学生平均成绩及其名次 -->仍然是 开窗函数 的应用啦！！！
SELECT s_id,
       AVG(s_score)  avg_s,
       RANK() OVER (ORDER BY AVG(s_score) desc)  rk
FROM 
	score
GROUP BY 
	s_id


				
				
#25、查询各科成绩前3名的学生信息---->开窗函数，要定义一个临时表，这样子才可以拿到 临时表里面的 别名列 rk

SELECT t.*
FROM (
    SELECT 
           a.s_name,
           c.c_name,
           b.s_score,
           -- 定义排名窗口函数
           rank() OVER (PARTITION BY  c.c_name ORDER BY b.s_score DESC)  rk
    FROM student a,score b,course c
    where   a.s_id = b.s_id and c.c_id = b.c_id
    		
) t
WHERE t.rk between 1 and 3 
 

#26、查询每门课程被选修的学生数 
 
select 
	c_id,
	count(s_id) 人数 
from 
	score a 
GROUP BY 
	c_id
 
#27、查询出只有两门课程的全部学生的学号和姓名 
select 
	a.s_id,a.s_name 
from 
	student a,
	score b
where a.s_id = b.s_id
group by
	a.s_id 
HAVING 
	COUNT(b.c_id)=2
 
#28、查询男生、女生人数 
select 
	s_sex,
	COUNT(s_sex)  人数  
from 
	student 
GROUP BY 
	s_sex
 
#29、查询名字中含有"风"字的学生信息
 
select 
	* 
from 
	student 
where 
	s_name like '%风%'
 
#30、查询同名同性学生名单，并统计同名人数 
 
select 
	s_name,
	s_sex,
	count(*) 人数
from 
	student 
group by 
	s_name,s_sex 
having 
	count(s_name)>1
 
 
 
#31、查询1990年出生的学生名单
 
select 
	s_name 
from 
	student 
where 
	year(s_birth) =1990
 
#32、查询每门课程的平均成绩，结果按平均成绩降序排列，平均成绩相同时，按课程编号升序排列 
 
select 
	c_id,
	ROUND(AVG(s_score),2)  avg_score 
from 
	score 
GROUP BY 
	c_id 
ORDER BY 
	ROUND(AVG(s_score),2) DESC,c_id ASC
 
#33、查询平均成绩大于等于85的所有学生的学号、姓名和平均成绩 
 
select 
	a.s_id,
	b.s_name,
	ROUND(avg(a.s_score),2)  avg_score 
from 
	score a,student b 
where
    a.s_id=b.s_id 
GROUP BY 
 	s_id 
HAVING 
	ROUND(avg(a.s_score),2)>=85
 
#34、查询课程名称为"数学"，且分数低于60的学生姓名和分数 
 
select 
	a.s_name,
	b.s_score 
from 
	score b,
	student a,
	course c
where
	a.s_id=b.s_id 
 	and b.c_id=c.c_id
	and c_name ='数学'
	and b.s_score<60
 
#35、查询所有学生的课程及分数情况； 
 
 
select 
	a.s_id,a.s_name,
    SUM(case when c.c_name='语文' then b.s_score else 0 end)  '语文',
    SUM(case when c.c_name='数学' then b.s_score else 0 end)  '数学',
    SUM(case when c.c_name='英语' then b.s_score else 0 end)  '英语',
    SUM(b.s_score) as  '总分'
from 
	student a,
	score b,
    course c
where 
	a.s_id = b.s_id 
    and b.c_id = c.c_id 
GROUP BY 
	a.s_id,a.s_name
 
 
#36、查询任何一门课程成绩在70分以上的学生姓名 

select 
	DISTINCT a.s_name
	
from 
	student a,
	score b
where 
	a.s_id = b.s_id 
	and a.s_id in (select s_id from score group by s_id having min(s_score)>70)

 
 
 
#37、查询不及格的课程
select 
	a.s_id,
	a.c_id,
	b.c_name,
	a.s_score 
from 
	score a, 
	course b 
where
    a.c_id = b.c_id
    and a.s_score<60 
 
#38、查询课程编号为01且课程成绩在80分以上的学生的学号和姓名 
select 
	a.s_id,
	b.s_name 
from 
	score a,
	student b 
where 
	a.s_id = b.s_id
    and a.c_id = '01' 
    and a.s_score>80
 
#39、求每门课程的学生人数 
select 
	count(*) 
from 
	score 
GROUP BY c_id;
 
#40、查询选修"张三"老师所授课程的学生中，成绩最高的 学生信息 及其成绩 --->这道题的话，视频里面写的话，考虑的条件少了，如果“张三”老师教了两门课，那么就要返回 两个学生的信息。而且如果是 某门课的最高分是两个人，那么就要返回两个学生。。。所以 我们都要在原来的基础上继续修改。。。。 
 
 
SELECT
	s.*,
	sc.s_score
FROM 
	student s, 
	score sc, 
	course c, 
	teacher t
WHERE 
	s.s_id = sc.s_id
  AND sc.c_id = c.c_id
  AND c.t_id = t.t_id
  AND t.t_name = '张三'
  AND sc.s_score in (SELECT MAX(sc2.s_score)
                                FROM score sc2, course c2, teacher t2
                                WHERE sc2.c_id = c2.c_id
                                  AND c2.t_id = t2.t_id
                                  AND t2.t_name = '张三'
                                GROUP BY sc2.c_id)
            
            
            
#41、查询 不同课程,成绩相同的学生的 学生编号、课程编号、学生成绩 --->用了 自连接，因为是同一个字段的 值不同。。。
select 
    DISTINCT b.s_id,
    b.c_id,
    b.s_score 
from 
	score a,
	score b 
where 
	a.c_id != b.c_id 
	and a.s_score = b.s_score
    
    
    
#42、查询每门功成绩最好的 前两名 ---> 开窗函数，这里要用一个临时表 t，这样子才能访问里面的rk 字段
        

select 
	* 
from 
	(select
	c_id,s_score,
  rank() over(partition by c_id order by s_score desc) rk
from 
	score) t
where 
	t.rk<=2
	


        
        
        
# 43、统计每门课程的学生选修人数(超过5人的课程才统计)。要求输出课程号和选修人数，查询结果按人数降序排列，若人数相同，按课程号升序排列  

select 
	c_id,
	count(*) total 
from 
	score 
GROUP BY 
	c_id 
HAVING 
	count(*)>5 
ORDER BY 
	total desc,c_id ASC
        
        
        
# 44、检索至少选修两门课程的学生学号 
select 
	s_id,
	count(*) total 
from 
	score 
GROUP BY 
	s_id 
HAVING 
	count(*)>=2
        
# 45、查询选修了全部课程的学生信息 
SELECT 
	* 
FROM 
	student 
WHERE 
	s_id IN ( 
	SELECT s_id FROM score GROUP BY s_id HAVING count(*)=( 
	SELECT count(*) 
	FROM course)
	)
	
	
	
#46、查询各学生的年龄
   
select *,(year(NOW()) - year(s_birth)) age from student
 
 
#47、查询本周过生日的学生
    select * from student where WEEK(NOW()) = WEEK(s_birth)
    

#48、查询下周过生日的学生
     select * from student where WEEK(NOW())+1 = WEEK(s_birth)
 
#49、查询本月过生日的学生
 
    select * from student where MONTH(NOW()) =MONTH(s_birth)
 
#50、查询下月过生日的学生
    select * from student where MONTH(NOW())+1 =MONTH(s_birth)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
```

