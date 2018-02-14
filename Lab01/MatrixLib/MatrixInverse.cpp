
#include "stdafx.h"

using namespace std;

#include <iostream>
#include <vector>
#include <conio.h>
#include"MatrixLib.h"

void MatrixLib::Class1::transpose(std::vector< std::vector<int> > matrix)
{
	int row = matrix.size();
	int col = matrix[0].size();
	std::vector<std::vector<int>> result(col, std::vector<int>(row, 0));


	for (int i = 0; i<row; i++)
		for (int j = 0; j<col; j++)
			result[j][i] = matrix[i][j];

	for (int i = 0; i<col; i++) {
		for (int j = 0; j<row; j++)
			std::cout << result[i][j] << "\t";
		std::cout << std::endl;
	}
}