#include <stdio.h>
#include <stdlib.h>

union ilword {
    int n;
    union ilword* ptr;
    void(*f)();
};
typedef union ilword word;

word param[2];
int next_param = 0;

word r0 = {0};

word vg0 = {0};
word vg1 = {0};
word vg2 = {0};
void INIT();
void MAIN();
void Fac_ComputeFac();
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
    for(p = 0; p <= -1 && p < 2; p++) {
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
    r4.f = &Fac_ComputeFac;
    *(r3.ptr) = r4;
    return;
}

void MAIN() {
    word vl[0];
    word r8 = {0};
    word r7 = {0};
    word r6 = {0};
    word r5 = {0};
    word r4 = {0};
    word r3 = {0};
    word r2 = {0};
    word r1 = {0};
    int p;
    for(p = 0; p <= -1 && p < 2; p++) {
        vl[p] = param[p];
    }
    next_param = 0;
MAIN:
    r1.n = 1;
    r2.ptr = calloc(r1.n, sizeof(word));
    *(r2.ptr) = vg2;
    r3.n = 10;
    r4 = *(r2.ptr);
    r5.n = 0;
    r6.ptr = r4.ptr + r5.n;
    r7 = *(r6.ptr);
    param[next_param++] = r2;
    param[next_param++] = r3;
    (*(r7.f))();
    r8 = r0;
    printf("%d\n", r8);
    return;
}

void Fac_ComputeFac() {
    word vl[3] = {0,0,0};
    word r11 = {0};
    word r10 = {0};
    word r9 = {0};
    word r8 = {0};
    word r7 = {0};
    word r6 = {0};
    word r5 = {0};
    word r4 = {0};
    word r3 = {0};
    word r2 = {0};
    word r1 = {0};
    int p;
    for(p = 0; p <= 2 && p < 2; p++) {
        vl[p] = param[p];
    }
    next_param = 0;
Fac_ComputeFac:
    r1.n = 1;
    r2.n = vl[1].n < r1.n;
    if (r2.n == 0) goto Fac_ComputeFac_0;
    vl[2].n = 1;
    goto Fac_ComputeFac_1;
Fac_ComputeFac_0:
    r4.n = 1;
    r5.n = vl[1].n - r4.n;
    r6 = *(vl[0].ptr);
    r7.n = 0;
    r8.ptr = r6.ptr + r7.n;
    r9 = *(r8.ptr);
    param[next_param++] = vl[0];
    param[next_param++] = r5;
    (*(r9.f))();
    r10 = r0;
    r11.n = vl[1].n * r10.n;
    vl[2] = r11;
Fac_ComputeFac_1:
    r0 = vl[2];
    return;
}

