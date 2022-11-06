#include <stdio.h>

#include <conio.h>

#include <math.h>

#define PI 3.14159

int main() {

            int r;

            float chuvi, dientich;

            printf("Nhap ban kinh r:");

            scanf("%d", &r);

            chuvi = 2*PI*r;

            dientich = PI*r*r;

            printf("Chu vi hinh tron la: %f\n", chuvi);

            printf("Dien tich hinh tron la: %f", dientich);

            getch();}
