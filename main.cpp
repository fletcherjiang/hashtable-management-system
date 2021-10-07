#include<iostream>
#include<string>
#include<vector>
#include <fstream> 
#include <sstream> 

using namespace std;


class people_data {
	friend class DatasControl;
private:
	string id;
	string FullName;
	string UserName;
	string email;
	string Skills;
	string City;
	string Country;
};

class DatasControl {
public:
	//构造函数
	DatasControl() {
		vector<people_data>  mid_allPeopleDatas; //暂存所有人员数据
		//需要从txt文件中读取数据
		ifstream infile;   //输入流
		infile.open("input_datas.txt", ios::in);
		if (infile.is_open())
		{
			people_data input_middata;  //临时的一个人员数据对象用于暂存从txt文件中获取的数据
			vector<string> all_inputdata; //用来暂存一个人员的所有数据
			string line;
			getline(infile, line);
			while (!infile.eof())
			{
				string line;
				getline(infile, line); //从文件中获取一行数据到line中
				//如果到了txt文件的末尾，那么就退出txt
				if (infile.eof())
				{
					break;
				}
				line += '\t'; //最后一个字符加上制表符
				all_inputdata.clear(); //先清零再用于存储
				int p = 0, q = 0;
				while (q < line.size())
				{
					if (line[q] == '\t')
					{
						all_inputdata.push_back(line.substr(p, q - p));
						p = q + 1;
					}
					q++;
				}
				input_middata.id = all_inputdata[0];
				input_middata.FullName = all_inputdata[1];
				input_middata.UserName = all_inputdata[2];
				input_middata.email = all_inputdata[3];
				input_middata.Skills = all_inputdata[4];
				input_middata.City = all_inputdata[5];
				input_middata.Country = all_inputdata[6];
				//将一个人员数据放入暂存所有人员数据vector中
				mid_allPeopleDatas.push_back(input_middata);
			}
		}
		infile.close();
		//获取完了所有的数据
		//将所有的数据映射到哈希表中
		allPeopleDatas = vector<vector<people_data>>(mid_allPeopleDatas.size()); //初始化哈希表的大小为总的数据大小
		for (int i = 0; i < mid_allPeopleDatas.size();i++)
		{
			allPeopleDatas[hashFunction(mid_allPeopleDatas[i].FullName)].push_back(mid_allPeopleDatas[i]);
		}
	}
	//析构函数
	~DatasControl() {

	}
	void findPeopleByName(string onePeopleName) {
		bool flag = false;
		for (int i = 0; i < allPeopleDatas[hashFunction(onePeopleName)].size();i++)
		{
			if (allPeopleDatas[hashFunction(onePeopleName)][i].FullName == onePeopleName)
			{
				cout << "id:" << allPeopleDatas[hashFunction(onePeopleName)][i].id<<" ";
				cout << "FullName:" << allPeopleDatas[hashFunction(onePeopleName)][i].FullName << " ";
				cout << "UserName:" << allPeopleDatas[hashFunction(onePeopleName)][i].UserName << " ";
				cout << "email:" << allPeopleDatas[hashFunction(onePeopleName)][i].email << " ";
				cout << "Skills:" << allPeopleDatas[hashFunction(onePeopleName)][i].Skills << " ";
				cout << "City:" << allPeopleDatas[hashFunction(onePeopleName)][i].City << " ";
				cout << "Country:" << allPeopleDatas[hashFunction(onePeopleName)][i].Country << endl;
				flag = true;
			}
		}
		if (flag == false)
		{
			cout << "Not found!!!"<<endl;
		}
	}
	void addPeopleData() {
		people_data middata;
		char inputdata[100];
		cout << "Input people id:";
		cin.getline(inputdata, 100);
		middata.id = inputdata;
		cout << "Input people FullName:";
		cin.getline(inputdata, 100);
		middata.FullName = inputdata;
		cout << "Input people UserName:";
		cin.getline(inputdata, 100);
		middata.UserName = inputdata;
		cout << "Input people email:";
		cin.getline(inputdata, 100);
		middata.email = inputdata;
		cout << "Input people Skills:";
		cin.getline(inputdata, 100);
		middata.Skills = inputdata;
		cout << "Input people City:";
		cin.getline(inputdata, 100);
		middata.City = inputdata;
		cout << "Input people Country:";
		cin.getline(inputdata, 100);
		middata.Country = inputdata;

		allPeopleDatas[hashFunction(middata.FullName)].push_back(middata);
	}
	void findSameCityPeoples(string cityName) {
		bool flag = false;
		for (int i = 0; i < allPeopleDatas.size(); i++)
		{
			for (int j = 0; j < allPeopleDatas[i].size(); j++)
			{
				if (allPeopleDatas[i][j].City == cityName)
				{
					flag = true;
					cout << "id:" << allPeopleDatas[i][j].id << " ";
					cout << "FullName:" << allPeopleDatas[i][j].FullName << " ";
					cout << "UserName:" << allPeopleDatas[i][j].UserName << " ";
					cout << "email:" << allPeopleDatas[i][j].email << " ";
					cout << "Skills:" << allPeopleDatas[i][j].Skills << " ";
					cout << "City:" << allPeopleDatas[i][j].City << " ";
					cout << "Country:" << allPeopleDatas[i][j].Country << endl;
				}
			}
		}
		if (flag == false)
		{
			cout << "Not found!!!" << endl;
		}
	}
	void findSameCountryPeoples(string countryName) {
		bool flag = false;
		for (int i = 0; i < allPeopleDatas.size(); i++)
		{
			for (int j = 0; j < allPeopleDatas[i].size(); j++)
			{
				flag = true;
				if (allPeopleDatas[i][j].Country == countryName)
				{
					cout << "id:" << allPeopleDatas[i][j].id << " ";
					cout << "FullName:" << allPeopleDatas[i][j].FullName << " ";
					cout << "UserName:" << allPeopleDatas[i][j].UserName << " ";
					cout << "email:" << allPeopleDatas[i][j].email << " ";
					cout << "Skills:" << allPeopleDatas[i][j].Skills << " ";
					cout << "City:" << allPeopleDatas[i][j].City << " ";
					cout << "Country:" << allPeopleDatas[i][j].Country << endl;
				}
			}
		}
		if (flag == false)
		{
			cout << "Not found!!!" << endl;
		}
	}
	void deleteOnePeopleData(string deletePeopleName)
	{
		bool flag = false;
		for (int i = 0; i < allPeopleDatas[hashFunction(deletePeopleName)].size(); i++)
		{
			if (allPeopleDatas[hashFunction(deletePeopleName)][i].FullName == deletePeopleName)
			{
				flag = true;
				allPeopleDatas[hashFunction(deletePeopleName)].erase(allPeopleDatas[hashFunction(deletePeopleName)].begin()+ i);
			}
		}
		if (flag == false)
		{
			cout << "Not have the people!!!" << endl;
		}
		else
		{
			cout << "Delete sucess!!!" << endl;
		}
	}
private:
	vector<vector<people_data>> allPeopleDatas;

	//哈希函数
	int hashFunction(string key)
	{
		unsigned int hashvalue = 0;
		for (char ch : key)
		{
			hashvalue = 37 * hashvalue + ch;
		}
		return hashvalue % allPeopleDatas.size();
	}
};
int main()
{
	DatasControl theDatasControl;
	while (1)
	{
		int flag = 0;
		cout << "☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆" << endl;
		cout << "**************************************************************" << endl;
		cout << "      1、find one people by fullname                          " << endl;
		cout << "_     2、find people by city                                 _" << endl;
		cout << "_     3、find people by country                              _" << endl;
		cout << "_     4、delete a people data                                _" << endl;
		cout << "_     5、add a people data                                   _" << endl;
		cout << "_     0、exit                                                _" << endl;
		cout << "**************************************************************" << endl;
		cout << "☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆" << endl;
		cin >> flag;
		char inputdata[100];
		cin.getline(inputdata, 100);
		switch (flag)
		{
		case 1:
		{
			cout << "Input people name:";
			cin.getline(inputdata,100);
			theDatasControl.findPeopleByName(inputdata);
			getchar();
			break;
		}
		case 2:
		{
			cout << "Input city:";
			cin.getline(inputdata, 100);
			theDatasControl.findSameCityPeoples(inputdata);
			getchar();
			break;
		}
		case 3:
		{
			cout << "Input country:";
			cin.getline(inputdata, 100);
			theDatasControl.findSameCountryPeoples(inputdata);
			getchar();
			break;
		}
		case 4:
		{
			cout << "Input delete people name:";
			cin.getline(inputdata, 100);
			theDatasControl.deleteOnePeopleData(inputdata);
			getchar();
			break;
		}
		case 5:
		{
			theDatasControl.addPeopleData();
			getchar();
			break;
		}
		case 0:  //退出本系统
		{
			break;
		}
		default:
		{
			cout << "Input error！" << endl;
			break;
		}
		}
		if (flag == 0)
		{
			break;
		}
	}
	return 0;
}