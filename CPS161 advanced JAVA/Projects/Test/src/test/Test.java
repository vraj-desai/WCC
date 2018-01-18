/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Vraj
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int []A = {0, 23, 0, 55, 33, 0};
        int []nonzeros = nonZeros(A);
        for(int i = 0; i < nonzeros.length; i++){
            System.out.println(nonzeros[i]);
        }
    }
    
    public static int[] nonZeros(int[] A){
        
        int num_nonzeros = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] != 0){
                num_nonzeros++;
            }
        }
        int[] result;
        result = new int[num_nonzeros];
        int idx = 0;
        for(int i = 0; i < A.length-1; i++){
            if(A[i] != 0){
                result[idx++] = A[i];
            }
        }
        
        while(idx == 0){
            
        }
        return result;
    }
    
}
