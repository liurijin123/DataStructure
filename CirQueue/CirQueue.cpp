#include<iostream>
#include"CirQueue.h"
using namespace std;
void main()
{
	int test;
	int x = 9;
	CirQueue<int> CirQueue1;
	CirQueue1.EnQueue(x);
	test = CirQueue1.GetQueue();
	cout << test << endl;
}