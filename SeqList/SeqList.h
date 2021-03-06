#pragma once
#include<iostream>
using namespace std;
const int MaxSize = 100;
template<class DataType>
class SeqList
{
public:
	SeqList() { length = 0; }
	SeqList(DataType a[], int n);
	~SeqList()
	{

	}
	int Length() { return length; }
	DataType Get(int i);
	int Locate(DataType x);
	void Insert(int i, DataType x);
	DataType Delete(int i);
	void PrintList();
private:
	DataType data[MaxSize];
	int length;
};
//构造函数
template<class DataType>
inline SeqList<DataType>::SeqList(DataType a[], int n)
{

	if (n > MaxSize)throw"参数非法";
	for (int i = 0; i < n; i++)
		data[i] = a[i];
	length = n;
}
//按位查找
template<class DataType>
inline DataType SeqList<DataType>::Get(int i)
{
	if (i<1 && i>length)throw"查找位置非法";
	else return data[i - 1];
}
//按值查找
template<class DataType>
inline int SeqList<DataType>::Locate(DataType x)
{
	for (int i = 0; i < length; i++)
		if (data[i] == x)return i + 1;
	return 0;
}
//插入
template<class DataType>
inline void SeqList<DataType>::Insert(int i, DataType x)
{
	if (length >= MaxSize)throw"上溢";
	if (i<1 || i>length + 1)throw"位置";
	for (int j = length; j >= i; j--)
		data[j] = data[j - 1];
	data[i - 1] = x;
	length++;
}
//删除
template<class DataType>
inline DataType SeqList<DataType>::Delete(int i)
{
	if (length == 0)throw"下溢";
	if (i<1 || i>length)throw"下溢";
	int x = data[i - 1];
	for (int j = i; j < length; j++)
		data[j - 1] = data[j];
	length--;
	return x;
}
//遍历
template<class DataType>
inline void SeqList<DataType>::PrintList()
{
	for (int i = 0; i < length; i++)
		cout << data[i] << endl;
}
