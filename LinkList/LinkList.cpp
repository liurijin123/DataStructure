#include<iostream>
#include"LinkList.h"
#define N 10
using namespace std;
void main()
{
	int test;
	int a[N] = { 0,1,2,3,4,5,6,7,8,9 };
	LinkList<int> List(a,N);
	List.Insert(1, 10);
	List.Delete(1);
	test = List.Get(1);
	List.PrintList();
	List.~LinkList();	
}