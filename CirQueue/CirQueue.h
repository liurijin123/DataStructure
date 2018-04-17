#pragma once
#include<iostream>
using namespace std;
const int QueueSize = 100;
template<class DataType>
class CirQueue
{
public:
	CirQueue() { front = rear = QueueSize - 1; }
	~CirQueue() {}
	void EnQueue(DataType x);
	DataType DeQueue();
	DataType GetQueue();
//	int Empty() { front == rear ? return 1 : return 0; }
private:
	DataType data[QueueSize];
	int front, rear;
};
//���
template<class DataType>
inline void CirQueue<DataType>::EnQueue(DataType x)
{
	if ((rear + 1) % QueueSize == front)throw"����";
	rear = (rear + 1) % QueueSize;
	data[rear] = x;
}
//����
template<class DataType>
inline DataType CirQueue<DataType>::DeQueue()
{
	if (rear == front)throw"����";
	front = (front + 1) % QueueSize;
	return data[front];
}
//��ȡ��ͷԪ��
template<class DataType>
inline DataType CirQueue<DataType>::GetQueue()
{
	if (rear == front)throw"����";
	int i = (front + 1) % QueueSize;
	return data[i];
}
