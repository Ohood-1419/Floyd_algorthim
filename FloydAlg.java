/*
Group #1
*/

import java.util.*;
// A Java program for Floyd-Warshall All Pairs Shortest Path algorithm.
public class FloydAlg {

    static char c1 = 'A'; 
    static char c2 = 'J';
    static int counter = 0 ;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("            >>_The Floyd Algorithm_<<"
                +"\n---------------------------------------------------\n");
        
//        System.out.println("\n*_start from: ");
//        c1 = sc.next().charAt(0);
//        System.out.print("*_end at: ");
//        c2 = sc.next().charAt(0);

        //print message
        System.out.print(">> The Weighted Matrix that start from (A) to (J) :\n\n");

        //record the matrix matrix
        //Assign all values of graph
        int[][] matrix = {
                //A  |B  |C  |D  |E  |F  |G  |H  |I  |J
                {0  ,10 ,999,999,999,5  ,999,999,999,999},//A
                {999,0  ,3  ,999,3  ,999,999,999,999,999},//B
                {999,999,0  ,4  ,999,999,999,5  ,999,999},//C
                {999,999,999,0  ,999,999,999,999,4  ,999},//D
                {999,999,4  ,999,0  ,999,2  ,999,999,999},//E
                {999,3  ,999,999,999,0  ,999,999,999,2  },//F
                {999,999,999,7  ,999,999,0  ,999,999,999},//G
                {999,999,999,4  ,999,999,999,0  ,3  ,999},//H
                {999,999,999,999,999,999,999,999,0  ,999},//I
                {999,6  ,999,999,999,999,8  ,999,999,0  } //J
        };

        System.out.println("\n1) The Weighted Matrix ");
        print_Matrix(matrix); // call method  print_Matrix

        System.out.println("2)The Floyd Matrix :\n");
        Floyd_Alg(matrix); // call method Floyd_Alg
    }
    
    //Find all pairs shortest path by trying all possible paths
    public static int[][] Floyd_Alg(int[][] matrix) {
        
        //k = number of iteration & Try all intermediate nodes
        for (int k = 0; k < counter; k++) { 
            //print iteration number 
            System.out.println("D("+k+") = ");  
            
            //i = to know the current row
            for (int i = 0; i < counter; i++) { 
                
                //j = to know the current colum
                for (int j = 0; j < counter; j++) { 
                    //if the summation (of #row & #colum) less than index value 
                    //--> we'll change index value.
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j]) {   
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                        
                    }
                }
            }
            print_Matrix(matrix);

        }
        return matrix;
    }

    //Method to print all element of matrix
    public static void print_Matrix(int[][] Matrix) {  
        //counter =0; c1='A'; c2='J';
        print_Alphpit();
        c1='A'; //assign it by A to print name of node for each row   
        for (int i = 0 ; i < counter; i++) {
            System.out.print(c1 + " |\t");
            c1++;
            for (int j = 0; j < counter; j++) {

                if(Matrix[i][j] == 999){ ///if element is infinity = 999 
                    System.out.print((char) 8734+"\t"); // print the original shape of it
                }else{
                    System.out.print(Matrix[i][j]); //print the value of element 
                    System.out.print("\t");
                }
            }
            System.out.println("\n");
        }
        System.out.println("\n");

    }
    
    //Method just to print line of alphapit from A-J & count num of node 
    public static void print_Alphpit(){
        System.out.print("\n\t");

        //count how many node(letter) we have & store it in variable count
        //happened when Print_Matrix method called with matrix matrix
        for (; c1 <= c2; c1++) {
            counter ++;
        }

        System.out.println("A\tB\tC\tD\tE\tF\tG\tH\tI\tJ\t");
        System.out.println("--------------------------------------------------------------------------------------");

    }



}

