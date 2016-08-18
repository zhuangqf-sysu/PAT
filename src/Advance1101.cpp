#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int myList[100001];
int isPivot[100001];
vector<int>answer;

int main()
{
    int n;
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>myList[i];
        isPivot[i] = true;
    }

    int leftMaxValue = myList[0];
    for(int i=0;i<n;i++)
    {
        if(myList[i]>=leftMaxValue) leftMaxValue = myList[i];
        else isPivot[i] = false;
    }

    int rightMinValue = myList[n-1];
    for(int i=n-1;i>=0;i--)
    {
        if(myList[i]<=rightMinValue) rightMinValue = myList[i];
        else isPivot[i] = false;
    }

    for(int i=0;i<n;i++)
        if(isPivot[i]) answer.push_back(myList[i]);

    sort(answer.begin(),answer.end());
    cout<<answer.size()<<endl;
    if(!answer.empty()) cout<<answer[0];
    for(int i=1;i<answer.size();i++)
        cout<<" "<<answer[i];

    cout<<endl;
}
