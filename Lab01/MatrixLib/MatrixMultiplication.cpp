#include "stdafx.h"
#include<iostream>
#include<conio.h>
#include"MatrixLib.h"

using namespace std;

void MatrixLib::Class1::multiply(int a1[3][3], int a2[3][3]){
	int final[3][3];
	int a=0, sum = 0;
	for (int i = 0; i < 3; i++){
		for (int j = 0; j < 3; j++){
			for (int k = 0; k < 3; k++){
				a = a1[i][k] * a2[k][j];
				sum += a;
			}
			final[i][j] = sum;
			sum = 0;
		}
	}

	for (int x = 0; x < 3; x++){
		for (int y = 0; y < 3; y++){
			cout << final[x][y] << "  ";
			cout << endl;
		}
	}
}