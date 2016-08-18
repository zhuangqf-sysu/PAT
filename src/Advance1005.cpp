#include <iostream>
#include <string>
#include <vector>
using namespace std;

vector<string>dictionary;

void init_map()
{
    dictionary.clear();
    dictionary.push_back("zero");
    dictionary.push_back("one");
    dictionary.push_back("two");
    dictionary.push_back("three");
    dictionary.push_back("four");
    dictionary.push_back("five");
    dictionary.push_back("six");
    dictionary.push_back("seven");
    dictionary.push_back("eight");
    dictionary.push_back("nine");
}

int main()
{
    init_map();
    string num;
    cin>>num;
    int sum = 0;
    for(int i=0;i<num.size();i++)
        sum+=num[i]-'0';

    string answer;
    if(sum==0) answer=dictionary[0];
    else{
        answer=dictionary[sum%10];
        sum /= 10;
    }

    while(sum>0){
        answer = dictionary[sum%10]+" "+answer;
        sum /= 10;
    }
    cout<<answer<<endl;
    return 0;
}
