#include<iostream>
#include"LinkStack.h"
using namespace std;
void main()
{
	int test;
	int x = 9;
	LinkStack<int> LinkStack1;
	LinkStack1.Push(x);
	test = LinkStack1.GetTop();
	cout << test << endl;
	LinkStack1.~LinkStack();
	LinkStack1.Push(8);
	test = LinkStack1.GetTop();
	cout << test << endl;
}