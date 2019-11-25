# Tic_tac_toc
Tic Tac Toc is an android based simple game.

In this game check condition 

{00}{01}{02}

{10}{11}{12}

{20}{21}{22}

In programming condition :

{i0,j0}{i0,j1}{i0,j2}

{i1,j0}{i1,j1}{i1,j2}

{i2,j0}{i2,j1}{i2,j2}

        for (int i=0;i<3;i++){
            if (field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2]) && !field[i][0].equals("")){
            }
        }

For this line compare to 1st row to 2nd row and 3dn row is equal or not

        for (int i=0;i<3;i++){
            if (field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && !field[0][i].equals("")){
            }
        }
        
For this line compare to 1st column to 2nd column and 3nd column is equal or not

        if (field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2]) && !field[0][0].equals("")){
        }

        if (field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0]) && !field[0][2].equals("")){
        }
        
And also compare for dimension equal or not 

Then decide which win 
