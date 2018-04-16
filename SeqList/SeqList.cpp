#include<iostream>
#include"SeqList.h"
#define N 10
using namespace std;
void main()
{
	//int test;
	int a[N] = { 0,1,2,3,4,5,6,7,8,9 };
	SeqList<int> list(a,N);
	list.Insert(2,10);	
	list.PrintList();
	list.~SeqList();
	list.PrintList();
}