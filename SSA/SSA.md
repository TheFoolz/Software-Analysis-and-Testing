# 软件分析测试	10.15					

​																																	by    吴腾超		MP1933024

## SSA（Static Single Assignment）静态单赋值分析

### 定义

* 静态单赋值形式 （SSA）

  ​	每个变量都只被赋值一次 

### 作业

本次作业程序分析框架选用LLVM。

c++源码：

```
	//SSA
	int m, n;
	m = 10;
	n = 10;
	m = m + n;
	m = m - 10;

	//部分SSA
	int c = 10;
	int* x = &c;
	*x = 100;
```

在`cmd`中使用命令`clang -S -emit-llvm SSA.cpp -o SSA.ll`后讲cpp文件转换为ll文件。

使用了LLVM后的程序代码如下：

```
entry:
  %m = alloca i32, align 4
  %n = alloca i32, align 4
  %c = alloca i32, align 4
  %x = alloca i32*, align 8
  store i32 10, i32* %m, align 4
  store i32 10, i32* %n, align 4
  %0 = load i32, i32* %m, align 4
  %1 = load i32, i32* %n, align 4
  %add = add nsw i32 %0, %1
  store i32 %add, i32* %m, align 4
  %2 = load i32, i32* %m, align 4
  %sub = sub nsw i32 %2, 10
  store i32 %sub, i32* %m, align 4
  store i32 10, i32* %c, align 4
  store i32* %c, i32** %x, align 8
  %3 = load i32*, i32** %x, align 8
  store i32 100, i32* %3, align 4
  ret i32 0
```

其中

```
  %m = alloca i32, align 4
  %n = alloca i32, align 4
  %c = alloca i32, align 4
  %x = alloca i32*, align 8
```

为定义部分，为变量m,n,c,*x分配了内存空间。



除开定义部分，将c语言程序分为两个部分

第一部分为：

	m = 10;
	n = 10;
	m = m + n;
	m = m - 10;
该部分可以完全转化为SSA，形式如下：

```
m0 = 10;
n0 = 10;
m1 = m0 + n0;
m2 = m1 - 10;
```

在LLVM中的代码如下：

```
store i32 10, i32* %m, align 4
store i32 10, i32* %n, align 4
%0 = load i32, i32* %m, align 4
%1 = load i32, i32* %n, align 4
%add = add nsw i32 %0, %1
store i32 %add, i32* %m, align 4
%2 = load i32, i32* %m, align 4
%sub = sub nsw i32 %2, 10
store i32 %sub, i32* %m, align 4
```



第二部分为：

	int c = 10;
	int* x = &c;
	*x = 100;
这里首先c赋值10，然后指针x指向了c的内存地址，并且由于改变了*x的值即修改了c所在内存地址的数据，同时会对c产生新的赋值，导致不能满足SSA，只能使用部分SSA,在LLVM的代码如下：

```
store i32 10, i32* %c, align 4
store i32* %c, i32** %x, align 8
%3 = load i32*, i32** %x, align 8
store i32 100, i32* %3, align 4
```

这里的c在`*x = 100;`这一步中产生了新的赋值，但是其内存位置并没有发生改变