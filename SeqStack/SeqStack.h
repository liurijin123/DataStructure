#pragma once
#include<iostream>
using namespace std;
const int StackSize = 10;
template<class DataType>
class SeqStack
{
public:
	SeqStack() { top = -1; }
	~SeqStack() {};
	void Push(DataType x);
	DataType Pop();
	DataType GetTop() { if (top != -1) return data[top]; }
	int Empty() { top == -1 ? return 1 : return 0; }
private:
	DataType data[StackSize];
	int top;
};
//入栈
template<class DataType>
inline void SeqStack<DataType>::Push(DataType x)
{
	if (top == StackSize - 1)throw"上溢";
	data[++top] = x;
}
//出栈
template<class DataType>
inline DataType SeqStack<DataType>::Pop()
{
	if (top == -1)throw"下溢";
	DataType x = data[top--];
	return x;
}
