#include<iostream>
#include"SeqStack.h"
using namespace std;
void main()
{
	int test;
	int x = 10;
	SeqStack<int> SeqStack1;
	SeqStack1.Push(x);
	test = SeqStack1.Pop();
	cout << test << endl;
}