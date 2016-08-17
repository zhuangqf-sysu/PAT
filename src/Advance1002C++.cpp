#include <iostream>
#include <iomanip>
using namespace std;

double p[1010];

void getPolynomial()
{
    int n;
    cin>>n;
    for(int i=0;i<n;i++)
    {
        int a;
        double b;
        cin>>a>>b;
        p[a] += b;
    }
}

int main()
{
    for(int i=0;i<1010;i++)
        p[i] = 0.0;

    getPolynomial();
    getPolynomial();

    int myCount = 0;
    for(int i=0;i<1010;i++)
        if(p[i]>0.000001||p[i]<-0.000001)
            myCount++;

    cout<<myCount;
    for(int i=1009;i>=0;i--)
        if(p[i]>0.000001||p[i]<-0.000001)
            cout<<" "<<i<<" "<<fixed<<setprecision(1)<<p[i];
    cout<<endl;

    return 0;
}
