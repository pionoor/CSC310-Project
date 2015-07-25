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


string radomString(int length )
{
    auto randchar = []() -> char
    {
        const char charset[] =
        "0123456789"
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        "abcdefghijklmnopqrstuvwxyz";
        const int max_index = (sizeof(charset) - 1);
        return charset[ rand() % max_index ];
    };
    std::string str(length,0);
    std::generate_n( str.begin(), length, randchar );
    return str;
}

int randomInt(int length){
    return (rand()%length)+1;
}

float randomFloat(int length){
    float f = static_cast <float> (rand()) / (static_cast <float> (RAND_MAX/length));
    return f;
}

string randomDate(){
    //(rand() % range) + min;
    int randomYear = (rand() % 66) + 1950;
    int randomMonth = (rand() % 11) + 10;
    int randomDay = (rand() % 29) + 10;
    return string(to_string(randomYear) + '-' + to_string(randomMonth) + '-' + to_string(randomDay));
}
int main()
{
    int UniqueNumCounter;
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
    
    myfile.open ("ProfessionalSocietyMember.txt");
    UniqueNumCounter = 0;

    for(auto i = 0; i < numColumns; i++)
        
    {

        for (auto j = 0; j < numRows; j++) {

            switch (columnType[j]) {
                //integer
                case 'i':
                    myfile << randomInt(columnLength[j]);
                    break;
                //char
                case 'c':
                    myfile << radomString(columnLength[j]);

                    break;
                //float
                case 'f':
                    myfile << randomFloat(columnLength[j]);

                    break;
                //unique integer
                case 'u':
                    myfile << UniqueNumCounter++;

                    break;
                    
                //date
                case 'd':
                    myfile << randomDate();
                    
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
       /* if (i == numColumns-2) {
            UniqueNumCounter = 0;
        }*/
    }
    
    myfile.close();
    
    return 0;
}