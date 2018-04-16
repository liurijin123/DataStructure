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
class LinkList
{
public:
	LinkList();
	LinkList(DataType a[], int n);
	~LinkList();
	int Length();
	DataType Get(int i);
	int Locate(DataType x);
	void Insert(int i, DataType x);
	DataType Delete(int i);
	void PrintList();
private:
	Node<DataType>*first;
};
//无参构造函数
template<class DataType>
inline LinkList<DataType>::LinkList()
{
	first = new Node<DataType>;
	first->next = NULL;
}
//构造函数
template<class DataType>
inline LinkList<DataType>::LinkList(DataType a[], int n)
{
	first = new Node<DataType>;
	first->next = NULL;
	for (int i = 0; i < n; i++)
	{
 		Node<DataType> *s = new Node<DataType>;
		s->data = a[i];
		s->next = first->next;
		first->next = s;
	}
}
//析构函数
template<class DataType>
inline LinkList<DataType>::~LinkList()
{
	while (first!=NULL)
	{
		Node<DataType>*q = first;
		first = first->next;
		delete q;
	}
}
//求线性表长度
template<class DataType>
inline int LinkList<DataType>::Length()
{
	Node<DataType>*p = first->next;
	int count = 0;
	while (p!=NULL)
	{
		p = p->next;
		count++;
	}
	return count;
}
//按位查找
template<class DataType>
inline DataType LinkList<DataType>::Get(int i)
{
	Node<DataType>*p = first->next;
	int count = 1;
	while (p!=NULL&&count<i)
	{
		p = p->next;
		count++;
	}
	if (p == NULL)throw"位置";
	else return p->data;
}
//按值查找
template<class DataType>
inline int LinkList<DataType>::Locate(DataType x)
{
	Node<DataType>*p = first->next;
	int count = 1;
	while (p!=NULL)
	{
		if (p->data == x)return count;
		p = p->next;
		count++;
	}
	return 0;
}
//插入
template<class DataType>
inline void LinkList<DataType>::Insert(int i, DataType x)
{
	Node<DataType>*p = first;
	int count = 0;
	while (p != NULL&&count < i - 1)
	{
		p = p->next;
		count++;
	}
	if (p == NULL)throw"位置";
	else 
	{
		Node<DataType>*s = new Node<DataType>;
		s->data = x;
		s->next = p->next;
		p->next = s;
	}
}
//删除
template<class DataType>
inline DataType LinkList<DataType>::Delete(int i)
{
	Node<DataType>*p = first;
	int count = 0;
	while (p!=NULL&&count<i-1)
	{
		p = p->next;
		count++;
	}
	if (p == NULL || p->next == NULL)throw"位置";
	else
	{
		Node<DataType>*q = p->next;
		int x = q->data;
		p->next = q->next;
		delete q;
		return x;
	}
}
//遍历
template<class DataType>
inline void LinkList<DataType>::PrintList()
{
	Node<DataType>*p = first->next;
	while (p!=NULL)
	{
		cout << p->data << endl;
		p = p->next;
	}
}
