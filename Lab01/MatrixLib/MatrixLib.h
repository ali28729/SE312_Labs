// MatrixLib.h

#pragma once

using namespace System;
#include <vector>
namespace MatrixLib {

	public ref class Class1{
		void transpose(std::vector< std::vector<int> > matrix);
		void add();
		void multiply(int a1[3][3], int a2[3][3]);
	};

}
