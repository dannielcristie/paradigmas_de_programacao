
#include <iostream>
using namespace std;

class Geometry  {

    public:
    virtual void draw ();
};

void Geometry::draw () {
    cout << "draw geometry" << endl;
}

class Rectangle : public Geometry {
    private:
        int x = 10;
        int y = 30;
    public:
     
     void draw ();
     void m();
};

void Rectangle::draw () {
    cout << "draw Rectangle" << endl;
}

void Rectangle::m() {
    cout << "m" << endl;
}

int main () {

Rectangle* r ;
//r = new Geometry();
r->draw();
r = new Rectangle();
r->draw();

int *p = (int*)r;

cout << p[0] << endl;
cout << p[1] << endl;
//*p = 20;
//r->m();

/*
    Geometry* geo = new Geometry();
    geo->draw(); 
    //(*geo).draw();
    //geo = new Rectangle();
    geo->draw(); 
    ((Rectangle*)geo)->m();
*/
}
