#include <iostream>
#include <vector>
#include <conio.h>

void transpose(std::vector< std::vector<int> > matrix)
{
	int row = matrix.size();
	int col = matrix[0].size();
	int **result;
	result = new int *[col];
	for (int i = 0; i < col; i++)
		result[i] = new int[row];

	for (int i = 0; i<row; i++)
		for (int j = 0; j<col; j++)
			result[j][i] = matrix[i][j];

	for (int i = 0; i<col; i++) {
		for (int j = 0; j<row; j++)
			std::cout << result[i][j] << "\t";
		std::cout << std::endl;
	}
}