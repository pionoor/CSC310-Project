//
//  main.cpp
//  RandomDataGenerator
//
//  Created by Noor Thabit on 7/23/15.
//  Copyright (c) 2015 Noor Thabit. All rights reserved.
//

#include <cstdlib>
#include <iostream>
#include <fstream>
#include <vector>
#include <stdlib.h> 

using namespace std;


string radomString(int length)
{
    static const char alphabet[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int strLen = sizeof(alphabet)-1;
    char genRandom;
    string str;
    for(int i=0; i<length; i++)
    {
        genRandom = alphabet[rand()%strLen];
        str += genRandom;
    }
    return str;
}

int randomInt(int length){
    return (rand()%length)+1;
}

float randomFloat(int length){
    float f = static_cast <float> (rand()) / (static_cast <float> (RAND_MAX/length));
    return f;
}

int main()
{
    string input;
    int numRows;
    int numColumns;
    vector<char> columnType;
    vector<int> columnLength;

    ofstream myfile;

    cout << "Enter the number of the Colunmsand the Rows of the table: ";
    
    cin >> numRows >> numColumns;
    
    cout << endl << "Enter the data type of each column folowed by the length followed, example 'i 3000 c 5 f 10': ";

    while (cin >> input && input != ";") {
       
        columnType.push_back(*input.c_str());
        cin >> input;
        columnLength.push_back(atoi(input.c_str()));
    }
    
    myfile.open ("random.txt");
    
    for(auto i = 0; i < numColumns; i++)
        
    {
        
        for (auto j = 0; j < numRows; j++) {
            switch (columnType[j]) {
                case 'i':
                    myfile << randomInt(columnLength[j]);
                    break;
                    
                case 'c':
                    myfile << radomString(columnLength[j]);
                    break;
                    
                case 'f':
                    myfile << randomFloat(columnLength[j]);
                    break;
                    
                default:
                    break;
            }

            if (j == numRows-1) {
                myfile <<endl;
                continue;
            }
            myfile <<'\t';

        }
    }
    
    myfile.close();
    
    return 0;
}