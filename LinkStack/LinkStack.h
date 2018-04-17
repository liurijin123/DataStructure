#pragma once
#include<iostream>
using namespace std;
template<class DataType>
struct Node
{
	DataType data;
	Node<DataType>*next;
};
template<class DataType>
class LinkStack
{
public:
	LinkStack() { top = NULL; }
	~LinkStack();
	void Push(DataType x);
	DataType Pop();
	DataType GetTop() { if (top != NULL)return top->data; }
	int Empty() { top == NULL ? return 1 : return 0; }
private:
	Node<DataType>*top;
};
//��������
template<class DataType>
inline LinkStack<DataType>::~LinkStack()
{
	while (top!=NULL)
	{
		Node<DataType>*q = top;
		top = top->next;
		delete q;
	}
}
//��ջ
template<class DataType>
inline void LinkStack<DataType>::Push(DataType x)
{
	Node<DataType>*s = new Node<DataType>;
	s->data = x;
	s->next = top;
	top = s;
}
//��ջ
template<class DataType>
inline DataType LinkStack<DataType>::Pop()
{
	if (top == NULL)throw"����";
	int x = top->data;
	Node<DataType>*p = top;
	top = top->next;
	delete p;
	return x;
}
