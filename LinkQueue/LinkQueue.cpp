#include<iostream>
#include"LinkQueue.h"
using namespace std;
void main()
{
	int test;
	int x = 9;
	LinkQueue<int> LinkQueue1;
	LinkQueue1.EnQueue(x);
	test = LinkQueue1.GetQueue();
	cout << test << endl;
}