// SSA.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
using namespace std;

int main()
{
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

}

