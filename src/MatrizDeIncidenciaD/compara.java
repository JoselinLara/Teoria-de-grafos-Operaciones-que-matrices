package MatrizDeIncidenciaD;

import MatrizDeIncidenciaND.*;

public class compara {

    public int [] columnas (int i, int n, int m, String [][] matrix){
        int paralelas [] = new int[m];
        boolean paralela = true;
        
        for(int j = 0; j < m; j++){
            for(int k = 0; k < n; k++){
                if(j!=i){
                    if(matrix[k][i] == null ? matrix[k][j] != null : !matrix[k][i].equals(matrix[k][j])){
                        paralela = false;
                    }
                    if(paralela){
                        paralelas[j] = 1;
                    }else{
                        paralelas[j] = 0;
                        break;
                    }
                }else{
                    paralelas[j] = 0;
                    
                }
            }
            paralela = true;
        }
        
        return paralelas;
    }
    
    public int [] renglones (int i, int n, int m, int [][] matrix){
        int circuitos [] = new int[n];
        boolean circuito = true;
        
        for(int j = 0; j < n; j++){
            for(int k = 0; k < m; k++){
                if(j!=i){
                    if(matrix[i][k] != matrix[j][k]){
                        circuito = false;
                    }
                    if(circuito){
                        circuitos[j] = 1;
                    }else{
                        circuitos[j] = 0;
                        break;
                    }
                }else{
                    circuitos[j] = 0;
                    
                }
            }
            circuito = true;
        }
        
        return circuitos;
    }
    
}
