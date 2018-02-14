#include <iostream>
#include <vector>
#include "MatrixLib.h"

using namespace std;
int main() {
	int option = 0;
	vector<vector<int>> mat1, mat2, result;
	while (option != 4){
		cout << "Choose operation:\n1: Add\n2: Subtract\n3: Transpose\n4: Multiply\n5: Quit\n";
		cin >> option;
		if (option == 1 || option == 2 || option == 4) {
			int rows1 = 0, cols1 = 0;
			int rows2 = 0, cols2 = 0;
			cout << "Input row and columns of matrix 1 seperated by a space (<rows> <columns>):\n";
			cin >> rows1 >> cols1;
			for (int i = 0; i < rows1; i++){
				cout << "Row " << i + 1 << ":\n";
				mat1.push_back(vector<int>(cols1));
				for (int j = 0; j < cols1; j++){
					cin >> mat1[i][j];
				}
			}
			cout << "Input row and columns of matrix 1 seperated by a space (<rows> <columns>):\n";
			cin >> rows2 >> cols2;
			for (int i = 0; i < rows2; i++){
				cout << "Row " << i + 1 << ":\n";
				mat2.push_back(vector<int>(cols2));
				for (int j = 0; j < cols2; j++){
					cin >> mat2[i][j];
				}
			}
		}
		else if (option == 3) {
			int rows1 = 0, cols1 = 0;
			cout << "Input row and columns of the matrix seperated by a space (<rows> <columns>):\n";
			cin >> rows1 >> cols1;
			for (int i = 0; i < rows1; i++){
				cout << "Row " << i + 1 << ":\n";
				mat1.push_back(vector<int>(cols1));
				for (int j = 0; j < cols1; j++){
					cin >> mat1[i][j];
				}
			}
		}

		switch (option) {
		case 1:

			break;
		case 2:
			break;
		case 3:
			transpose(mat1);
			break;
		case 4:
			break;
		default:
			break;
		}
		if (result.size() != 0){
			cout << "Result:\n";
			for (int i = 0; i < result.size(); i++){
				for (int j = 0; j < result[i].size(); j++){
					cout << mat1[i][j] << " ";
				}
				cout << endl;
			}
		}
		result.clear();
		mat1.clear();
		mat2.clear();
	}

	return 0;
}