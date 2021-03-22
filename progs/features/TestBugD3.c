#include <stdio.h>
#include <stdlib.h>

union ilword {
    int n;
    union ilword* ptr;
    void(*f)();
};
typedef union ilword word;

word param[1];
int next_param = 0;

word r0 = {0};

word vg0 = {0};
word vg1 = {0};
word vg2 = {0};
void INIT();
void MAIN();
void TestBugD3_f();
int main() {
    INIT();
    MAIN();
    return 0;
}

void INIT() {
    word vl[0];
    word r4 = {0};
    word r3 = {0};
    word r2 = {0};
    word r1 = {0};
    int p;
    for(p = 0; p <= -1 && p < 1; p++) {
        vl[p] = param[p];
    }
    next_param = 0;
INIT:
    r2.n = 0;
    vg0.ptr = calloc(r2.n, sizeof(word));
    r2.n = 0;
    vg1.ptr = calloc(r2.n, sizeof(word));
    r2.n = 1;
    vg2.ptr = calloc(r2.n, sizeof(word));
    r3 = vg2;
    r4.f = &TestBugD3_f;
    *(r3.ptr) = r4;
    return;
}

void MAIN() {
    word vl[0];
    word r7 = {0};
    word r6 = {0};
    word r5 = {0};
    word r4 = {0};
    word r3 = {0};
    word r2 = {0};
    word r1 = {0};
    int p;
    for(p = 0; p <= -1 && p < 1; p++) {
        vl[p] = param[p];
    }
    next_param = 0;
MAIN:
    r1.n = 1;
    r2.ptr = calloc(r1.n, sizeof(word));
    *(r2.ptr) = vg2;
    r3 = *(r2.ptr);
    r4.n = 0;
    r5.ptr = r3.ptr + r4.n;
    r6 = *(r5.ptr);
    param[next_param++] = r2;
    (*(r6.f))();
    r7 = r0;
    printf("%d\n", r7);
    return;
}

void TestBugD3_f() {
    word vl[4] = {0,0,0,0};
    word r8 = {0};
    word r7 = {0};
    word r6 = {0};
    word r5 = {0};
    word r4 = {0};
    word r3 = {0};
    word r2 = {0};
    word r1 = {0};
    int p;
    for(p = 0; p <= 3 && p < 1; p++) {
        vl[p] = param[p];
    }
    next_param = 0;
TestBugD3_f:
    vl[1].n = 3;
    vl[2].n = 3;
    vl[3].n = 2;
    r4.n = vl[1].n >= vl[3].n;
    r6 = r4;
    if (r6.n == 0) goto TestBugD3_f_0;
    r5.n = vl[1].n >= vl[2].n;
    r6 = r5;
TestBugD3_f_0:
    if (r6.n == 0) goto TestBugD3_f_1;
    r7.n = 1;
    printf("%d\n", r7);
    goto TestBugD3_f_2;
TestBugD3_f_1:
    r8.n = 0;
    printf("%d\n", r8);
TestBugD3_f_2:
    r0.n = 0;
    return;
}

