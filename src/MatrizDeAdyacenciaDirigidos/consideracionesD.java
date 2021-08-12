/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatrizDeAdyacenciaDirigidos;

import static MatrizDeAdyacencia.metodos.transponer;
import java.util.Arrays;

/**
 *
 * @author hades
 */
public class consideracionesD {
    public static  boolean c3(long[][] matriz){
        boolean con3=false;
        long[][]MxT=transponer(matriz);
        if(Arrays.deepEquals(matriz,MxT)){
                    //Si esta  condición se  cumple inicia el analisis
                    con3=true;
        }else{
            con3=false;
        }
        return con3;
    }
    public static String asimetrica(long [][] mat){
        int numparalelas=0;
        int paralelas=0;
        int n=mat.length;
        int numbucles=0;
        int bucle=0;
        String asime="";
         for (int i=0;i<mat.length;i++){
             for(int j=0;j<mat.length;j++){
                if(mat[i][j]==2){
                    numparalelas+=2;
                }else if(mat[i][j]<=1){
                    paralelas++;
                }                          
            }  
        }
         //bucles
        for (int i=0;i<n;i++){
            if(mat[i][i]==1){
                numbucles+=1;
                //System.out.print("Bucle en ["+num+"]["+num+"]"+m[num][num]+"\n"); 
            }else if(mat[i][i]==0){
                bucle++; //Si hay un 0 en la  posicion num,num bucle suma 1
            }
       }
        if((paralelas==(n*n))&&(bucle==n)){
            asime="La digráfica es asimétrica. \n"; 
        }else{
            asime="La digráfica no es asimétrica. \n"; 
        }
        return  asime;
           
    }
    public static String c4(long [][] mat){// esta función calcula si hay paralelas
        int x=0;
        int y=0;
        int numparalelas=0;
        int banderap=0;
        int n=mat.length;
        String consideracion4="";
        String co6_13="";
        for (int i=0;i<mat.length;i++){
             for(int j=0;j<mat.length;j++){
                if(mat[i][j]==2){
                    x=i+1;y=j+1;
                    numparalelas+=2;
                    consideracion4+="Hay una línea paralela que va del nodo "+x+" al nodo "+y+"."+"\n";
                }else if(mat[i][j]<=1){
                    banderap++;
                     if(banderap==(n*n)){
                        consideracion4="No hay lineas paralelas.\n";
                     }
                }                          
            }  
        }
        return consideracion4;
      }
    public static String c10(long [][]m){ // función de  los bucles
        int x=0;
        int y=0;
        int numbucles=0;
        int banderabu=0;
        int n=m.length;
        String con10="";
        for (int i=0;i<m.length;i++){
            x=i+1;
            if(m[i][i]==1){
                numbucles+=1;
                //System.out.print("Bucle en ["+num+"]["+num+"]"+m[num][num]+"\n");
                con10+="Hay un bucle en el nodo "+(x)+"."+"\n";
            }else if(m[i][i]==0){
                banderabu++; //Si hay un 0 en la  posicion num,num bucle suma 1
                if(banderabu==(n)){
                    //System.out.print(bucle);                                      
                    con10="No hay bucles.\n";
                }
            }
       }
        return con10;
    }
    public static String c11(long[][]mat){// esta función dice  si es simple multidigráfica o pseudodigráfica
        int numparalelas=0;
        int banderap=0;
        int n=mat.length;
        int numbucles=0;
        int banderabu=0;
        String con11="";
         for (int i=0;i<mat.length;i++){
             for(int j=0;j<mat.length;j++){
                if(mat[i][j]==2){
                    numparalelas+=2;
                }else if(mat[i][j]<=1){
                    banderap++;
                }                          
            }  
        }
         //bucles
        for (int i=0;i<n;i++){
            if(mat[i][i]==1){
                numbucles+=1;
                //System.out.print("Bucle en ["+num+"]["+num+"]"+m[num][num]+"\n"); 
            }else if(mat[i][i]==0){
                banderabu++; //Si hay un 0 en la  posicion num,num bucle suma 1
            }
       }
        if((banderap==(n*n))&&(banderabu==(n))){
            con11="Es una digráfica simple.\n";
        }else{
            if((banderabu==(n))&&(banderap>0)){
                con11="No es  una  digráfica simple.\nEs una digráfica multidigráfica.\n";
            }else if (banderabu>0){
                 if(banderap>0 || banderap<=0)
                    con11="No es  una  digráfica simple ni multidigráfica.\nEs una gráfica pseudodigráfica.\n";
            }else 
                con11="No es una gráfica pseudodigráfica ni multidigráfica ni simple.\n";
        }                      
        return con11;
    }
    public static String c12(long[][]mat){
         int i,j;
         int n=mat.length;
         int lineas=0;
         String co12="";
         for(i=0;i<n;i++){
             for(j=0;j<n;j++){
                 if(mat[i][j]==1){
                     lineas++;
                 }
                 if(mat[i][j]==2){
                     lineas+=2;
                 }
             }
         }
         co12="La digráfica tiene "+lineas+" líneas \n";
         return co12;
     }  
    public static String c13(long[][] m){// consideracion 13 , 14 y 15
        int n=m.length;
        int p;
        int sumaF = 0;
        int sumc;
        int elemA=0; 
        int bandera=0;
        int numparalelas=0;
        int banderap=0;
        int numbucles=0;
        int banderabu=0;
        boolean sw = true;
        String co13="";
        String co15="";
        String co16="";
        String co5="";
        String co6="";
        String co7="";
        String co8="";
        int gradoE[]= new int[n];
        int gradoI[]= new int[n];
         for(int i = 0; i <n; i++){
                p = 0;
                while ((p < n) && (sw == true)){
                    sumaF = (int) (sumaF + m[i][p]);
                    if(p == m[i].length){
                       sw = false;
                    }
                    p++;
                }
                sumc=0;  
                for (int j = 0; j <n;j++) {  
                    sumc=(int)(sumc+m[j][i]);  
                } 
                gradoE[i]=sumaF;
                gradoI[i]=sumc;
                //System.out.println("La suma de la fila " + num + " es: " + sumaF);
                co13+="Nodo "+(i+1)+" tiene grado externo = "+sumaF+" y tiene grado interno = "+sumc+".\n";
                sumaF = 0;
        } 
        for(int i=0;i<n;i++){
           // recorremos los valores del array B
            for(int j=0;j<n;j++){
                // Cada valor del array A lo comparemos con todos los valores del array B
                if(gradoE[i]==gradoI[j])
                    elemA++;
           }//System.out.println(elemA+".\n");
                bandera=elemA;
                elemA=0;
       }//paralelas
         for (int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                if(m[i][j]==2){
                    numparalelas+=2;
                }else if(m[i][j]<=1){
                    banderap++;
                }                          
            }  
        }
         //bucles
         for (int i=0;i<n;i++){
            if(m[i][i]==1){
                numbucles+=1;
                //System.out.print("Bucle en ["+i+"]["+i+"]"+m[i][i]+"\n"); 
            }else if(m[i][i]==0){
                banderabu++; //Si hay un 0 en la  posicion i,i banderabu suma 1
            }
       }
         int nAislado=0;
         int nTerminal=0;
         int nInicial=0;
          for(int a=0;a<n;a++){
            if((gradoE[a]==0)&&(gradoI[a]==0)){
                    nAislado++;
                    co8+="El nodo "+(a+1)+" es aislado."+"\n";
            }
            if((gradoE[a]==0)&&(gradoI[a]>0)){
                    nTerminal++;
                    co5+="El nodo "+(a+1)+" es nodo terminal."+"\n"; 
            }else if((gradoE[a]>0)&&(gradoI[a]==0)){
                    nInicial++;
                    co6+="El nodo "+(a+1)+" es nodo inicial."+"\n"; 
            }else if((gradoE[a]>0)&&(gradoI[a]>0)) {
                co7+="El nodo "+(a+1)+" es nodo intermedio."+"\n"; 
            }
        }
        if(co8.equals("")){
            co8="No hay nodos aislados.\n"; 
        }
        if(co5.equals("")){
            co5="No hay nodos terminales.\n"; 
        } 
        if(co6.equals("")){
            co6="No hay nodos iniciales.\n"; 
        }
        if((banderap==(n*n))&&(banderabu==(n))){
            if(bandera==n){
               co15="Es digráfica regular.\n";
            }else{
               co15="No es digráfica regular.\n";
            }
        }else{
            co15="No es digráfica regular.\n"; 
        }
        co16=c16(gradoE,gradoI,m);
          return co5+co6+co7+co8+co13+co15+co16;
     }
    public static String c16(int [] gradoE,int[] gradoI,long [][]m){
        int n=gradoE.length;
        int elemA=0; 
        int bandera=0;
        int numparalelas=0;
        int banderap=0;
        int numbucles=0;
        int banderabu=0;
        String co16="";
        String co17="";
         boolean b= Arrays.equals(gradoE,gradoI);
        //paralelas
         for (int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                if(m[i][j]==2){
                    numparalelas+=2;
                }else if(m[i][j]<=1){
                    banderap++;
                }                          
            }  
        }
         //bucles
         for (int i=0;i<n;i++){
            if(m[i][i]==1){
                numbucles+=1;
                //System.out.print("Bucle en ["+i+"]["+i+"]"+m[i][i]+"\n"); 
            }else if(m[i][i]==0){
                banderabu++; //Si hay un 0 en la  posicion i,i banderabu suma 1
            }
       }
        if((banderap==(n*n))&&(banderabu==(n))){
            if(b==!true){
               co16="No es digráfica balanceada.\n";
               
            }else{
              co16="Es digráfica balanceada.\n"; 
            }
        }else{
            co16="No es digráfica balanceada.\n"; 
        }
        co17=c17(m,gradoE,gradoI);
         return co16+co17;
     }
    public static String c17(long[][]mat,int[] gradoE,int[] gradoI){
        int completa=0;
        int numparalelas=0;
        int banderap=0;
        int n=mat.length;
        int numbucles=0;
        int banderabu=0;
        int elemA=0; 
        int p, sumaF = 0;
        int bandera=0;
        String co17="";
        String co18="";
        //paralelas
         for (int i=0;i<mat.length;i++){
             for(int j=0;j<mat.length;j++){
                if(mat[i][j]==2){
                    numparalelas+=2;
                }else if(mat[i][j]<=1){
                    banderap++;
                }                          
            }  
        }
         //bucles
        for (int i=0;i<n;i++){
            if(mat[i][i]==1){
                numbucles+=1;
                //System.out.print("Bucle en ["+i+"]["+i+"]"+m[i][i]+"\n"); 
            }else if(mat[i][i]==0){
                banderabu++; //Si hay un 0 en la  posicion i,i banderabu suma 1
            }
       }
        //para saber si es completa
        for(int j=0;j<gradoE.length;j++){
           if((gradoE[j]==mat.length-1)&&(gradoE[j]==mat.length-1))
               completa=1;
           else{
               completa=-1;
            }
        }
        
        //para saber si es regular
        for(int i=0;i<gradoE.length;i++){
           // recorremos los valores del array B
            for(int j=0;j<gradoE.length;j++){
                // Cada valor del array A lo comparemos con todos los valores del array B
                if(gradoE[i]==gradoI[j])
                    elemA++;
           }//System.out.println(elemA+".\n");
                bandera=elemA;
                elemA=0;
       }
        if((banderap==(n*n))&&(banderabu==(n))&&(bandera==n)){
            if(completa==-1){
                co17="La digrafica no es completa.\n"; 
            }else if(completa==1){
                co17="La digráfica  es completa.\n"; 
            }
        }else{
            co17="La digráfica  no es completa por que no es regular.\n"; 
        }
        co18=c18(mat,gradoE,gradoI);
        //ystem.out.println("la matriz  mide"+mat.length+".\n ");
        //System.out.println("el gradoE debe ser de n-2 es="+(mat.length-1)+".\n ");
        return co17+co18;
    } 
    public static String c18(long[][]mat,int[] gradoE,int[] gradoI){
        String co18="";
        int acompleta=0;
        int numparalelas=0;
        int banderap=0;
        int n=mat.length;
        int t=n-1;
        int numbucles=0;
        int banderabu=0;
        int sumaRC[]= new int[n];
        //paralelas
         for (int i=0;i<mat.length;i++){
             for(int j=0;j<mat.length;j++){
                if(mat[i][j]==2){
                    numparalelas+=2;
                }else if(mat[i][j]<=1){
                    banderap++;
                }                          
            }  
        }
         //bucles
        for (int i=0;i<n;i++){
            if(mat[i][i]==1){
                numbucles+=1;
                //System.out.print("Bucle en ["+i+"]["+i+"]"+mat[i][i]+"\n"); 
            }else if(mat[i][i]==0){
                banderabu++; //Si hay un 0 en la  posicion i,i banderabu suma 1
            }
       }
        for(int i=0;i<n;i++){
            sumaRC[i]=gradoE[i]+gradoI[i];
        }
        for(int i=0;i<n;i++){
            if(sumaRC[i]==t){
                acompleta=1;
            }else{
                acompleta=-1;
                break;
            }
        }
        if((banderap==(n*n))&&(banderabu==(n))){
            if(acompleta==-1){
                co18="La digrafica no es asimétrica completa.\n"; 
            }else if(acompleta==1){
                co18="La digráfica  es asimétrica completa.\n"; 
            }
        }else{
            co18="La digráfica  no es asimétrica completa.\n"; 
        }
        return co18;
    }
    public static String imprimir(long[][] matriz) {
        String co17="";
            for (long[] matriz1 : matriz) {
                co17+=("|");
                for (int y = 0; y < matriz1.length; y++) {
                    co17+=(matriz1[y]);
                    if (y != matriz1.length - 1) {
                        co17+=("\t");
                    }
                }
                co17+=("|\n");
            }
            return co17;
	}
    public static long[][] sumar (long[][] m1,long[][] m2) {

		long[][] resultado = new long[m1.length][m2[0].length];
		
		for (int x=0; x < resultado.length; x++) {
            for (int y=0; y < resultado[x].length; y++) {
            		resultado [x][y] = m1[x][y] + m2[x][y];
            }
		}
		return resultado;
	}
	// Multiplica Matrices
    public static long[][] multiplicar (long[][] m1,long[][] m2) {
		
		int fil_m1 = m1.length;
		int col_m1 = m1[0].length;
		
		int fil_m2 = m2.length;
		int col_m2 = m2[0].length;
		
		if (col_m1 != fil_m2)
			throw new RuntimeException("No se pueden multiplicar las matrices");
		
		// La nueva matriz es de filas de M1 y columnas de M2
		long[][] multiplicacion = new long[fil_m1][col_m2];
		
	for (int x=0; x < multiplicacion.length; x++) {
            for (int y=0; y < multiplicacion[x].length; y++) {
            		
            		// El nuevo bucle suma la multiplicaci�n de la fila por la columna
            		for (int z=0; z<col_m1; z++) {
            			multiplicacion [x][y] += m1[x][z]*m2[z][y];
            		}
            }
		}
       
         return multiplicacion;
    } 
    public static String potencia (long[][] m1){
       long[][] original= new long[m1.length][m1.length];
       long[][] mp= new long[m1.length][m1.length];
       long[][] cambios;
       int i,j,k;
       int n=m1.length-1;
       String co17="";
       String co18="";
       String mpo="";
       for(j=0;j<m1.length;j++){
           for(k=0;k<m1.length;k++){
               original[j][k]=m1[j][k];
            }
       }
       for(i=0;i<n;i++){
           cambios=multiplicar(original,m1);
           //System.out.println("X(G)^"+(i+2)+"\n");
           for(int u=0;u<m1.length;u++){
               for(int v=0;v<m1.length;v++){
                  mp[u][v]+=cambios[u][v];
               }
           }
           mpo=("Matriz P= \n")+imprimir(mp);
           co17+=("X(G)^"+(i+2)+"\n")+imprimir(cambios);
           m1=cambios;
       }
        for (long[] m11 : mp) {
            for (int b = 0; b<m1.length; b++) {
                if (m11[b] == 0) {
                    co18="Es una gráfica desconectada.\n";
                    break;
                } else {
                    co18="La gráfica es conectada.\n";
                }
            }  
        }
       return co17+co18+"\n"+mpo;
    }
    public static String c20(long[][]m){//obtiene las potencias de la matriz
        long[][] m3= new long[m.length][m.length];
        int i=1;
        int p=m.length;
        int n=m.length;
         String co20="";
         co20=potencia(m);
       return co20; 
    }
}
