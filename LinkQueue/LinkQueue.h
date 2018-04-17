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
class LinkQueue
{
public:
	LinkQueue();
	~LinkQueue();
	void EnQueue(DataType x);
	DataType DeQueue();
	DataType GetQueue();
	int Empty() { front == rear ? return 1 : return 0; }
private:
	Node<DataType>*front, *rear;
};
//���캯��
template<class DataType>
inline LinkQueue<DataType>::LinkQueue()
{
	Node<DataType>*s = new Node<DataType>;
	s->next = NULL;
	front = rear = s;
}
//��������	
template<class DataType>
inline LinkQueue<DataType>::~LinkQueue()
{
	while (front!=NULL)
	{
		Node<DataType>*q = new Node<DataType>;
		q = front;
		front = front->next;
		delete q;
	}
}
//���
template<class DataType>
inline void LinkQueue<DataType>::EnQueue(DataType x)
{
	Node<DataType>*s = new Node<DataType>;
	s->data = x;
	s->next = NULL;
	rear->next = s;
	rear = s;
}
//����
template<class DataType>
inline DataType LinkQueue<DataType>::DeQueue()
{
	if (rear == front)throw"����";
	Node<DataType>*p = front->next;
	int x = p->data;
	front->next = p->next;
	if (p->next = NULL)rear = front;
	delete p;
	return x;
}
//ȡ��ͷԪ��
template<class DataType>
inline DataType LinkQueue<DataType>::GetQueue()
{
	Node<DataType>*p = front->next;
	int x = p->data;
	return x;
}
