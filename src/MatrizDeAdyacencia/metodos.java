/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatrizDeAdyacencia;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author hades
 */
public class metodos {
    public static long[][] transponer(long[][] matriz) {
		
		long[][] nuevaMatriz = new long[matriz[0].length][matriz.length];
		
		for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[x].length; y++) {
            		nuevaMatriz[y][x] = matriz[x][y];
            }
		}
		
		return nuevaMatriz;
		
	}
    public static  boolean conci3(long[][] matriz){
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
    //esta función es de la consideracion5 5 y llama a las consideraciones de la 6 a la 13
    public static String consideracion5(long [][] mat){// esta función calcula la si hay bucles  y llama  a c68 para pasarle el numero de  bucles
        int x=0;
        int y=0;
        int numparalelas=0;
        int banderap=0;
        int n=mat.length;
        String consideracion5="";
        String co6_13="";
        for (int i=0;i<mat.length;i++){
             for(int j=0;j<mat.length;j++){
                if(mat[i][j]==2){
                    x=i+1;y=j+1;
                    numparalelas+=2;
                    consideracion5+="Hay una línea paralela que va del nodo "+x+" al nodo "+y+"."+"\n";
                }else if(mat[i][j]<=1){
                    banderap++;
                     if(banderap==(n*n)){
                        consideracion5="No hay lineas paralelas.\n";
                     }
                }                          
            }  
        }
        co6_13=c68(mat,numparalelas);
        
        return consideracion5+co6_13;
        
    }
     //esta función es de la consideracion5 6 y llama a las consideraciones de la 7 a la 13
    public static String c68(long [][]m,int nump){
        int x=0;
        int y=0;
        int numbucles=0;
        int banderabu=0;
        int n=m.length;
        String consideracion6="";
        String consideracion8="";
        String consideracion7="";
        String consideracion9 ="";
        for (int i=0;i<m.length;i++){
            x=i+1;
            if(m[i][i]==1){
                numbucles+=1;
                //System.out.print("Bucle en ["+i+"]["+i+"]"+m[i][i]+"\n");
                consideracion6+="  "+"Hay un bucle en el nodo "+(x)+"."+"\n";
            }else if(m[i][i]==0){
                banderabu++; //Si hay un 0 en la  posicion i,i banderabu suma 1
                if(banderabu==(n)){
                    //System.out.print(banderabu);                                      
                    consideracion6="No hay bucles.\n";
                }
            }
       }
        consideracion8=c8(consideracion6,nump,numbucles);
        consideracion7=c7(m);
        consideracion9 = c9_13(m,consideracion6);
        return consideracion6+consideracion7+consideracion8+consideracion9;
    }
    //esta función es de la consideracion5 7
    public static String c7(long[][]mat){// esta función dice  si es  general o simple
        int numparalelas=0;
        int banderap=0;
        int n=mat.length;
        int numbucles=0;
        int banderabu=0;
        String co7="";
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
        if((banderap==(n*n))&&(banderabu==(n))){
            co7="Es una gráfica simple.\n";
        }else{
            co7="Es una gráfica general.\n";  
        }
        
        return co7;
    }
    //esta función es de la consideracion5 8
    public static String c8(String con6,int nump,int numb){// esta  función recibe 3 parametros el valor de la c6 calculada en c68, el numero de paralelas y el numero de bucles
        String consideracion8="";// calcula  si es  multigrafo o pseudografo
        ////////////////////////Consideracion 8 Multigráfica o pseudográfica//////////////////////////////////////////////////////////////////////////////////////////////////////////
                       if(("No hay bucles.\n".equals(con6))&&(nump>0)){
                           consideracion8="Es una gráfica multigráfica.\n";
                       }else if (numb>0){
                           if(nump>0 || nump<=0)
                                consideracion8="Es una gráfica pseudográfica.\n";

                       }else 
                          consideracion8="No es una gráfica pseudográfica ni multigráfica.\n";
        return consideracion8;
        
    }
    //esta función es de la consideracion5 9,10,12 y 13 y llama a la consideraciones de la 11
    public static String c9_13(long [][]m,String bucles){
////////////////////////Consideracion 9 Grados de los nodos//////////////////////////////////////////////////////////////////////////////////////////////////////////
        int n=m.length;
        int elemA=0; 
        int p, sumaF = 0;
        int grado[]= new int[n];
        int nAislado=0;
        int bandera=0;
        int numparalelas=0;
        int banderap=0;
        int numbucles=0;
        int banderabu=0;
        String c6="";
        String co9="";
        String co10="";
        String co11="";
        String co12="";
        String co13="";
        String co15="";
        String co16="";
        boolean sw = true;
        if("No hay bucles.\n".equals(c6)){
            for(int i = 0; i <n; i++){
                p = 0;
                while ((p < n) && (sw == true)){
                    sumaF = (int) (sumaF + m[i][p]);
                    if(p == m[i].length){
                       sw = false;
                    }
                    p++;
                }
                grado[i]=sumaF;
                //System.out.println("La suma de la fila " + i + " es: " + sumaF);
                co9+="  "+"Nodo "+(i+1)+" tiene grado = "+sumaF+".\n";
                sumaF = 0;
            }   
         }else {
            for(int i = 0; i <n; i++){
                p = 0;
                while ((p < n) && (sw == true)){
                    sumaF = (int) (sumaF + m[i][p]);
                    if(p == m[i].length){
                        sw = false;
                    }
                    p++;
                }
                //System.out.println("La suma de la fila " + i + " es: " + sumaF);
                if(m[i][i]==1){
                    co9+="  "+"Nodo "+(i+1)+" tiene grado = "+(sumaF+1)+".\n";
                    grado[i]=sumaF+1;
                    //System.out.println(auxg[i]+".\n");
                    sumaF = 0;
                }else{
                    co9+="  "+"Nodo "+(i+1)+" tiene grado = "+sumaF+".\n";
                    grado[i]=sumaF;
                    //System.out.println(grado[i]+".\n");
                    sumaF = 0;
                }
                
            }              
        }
        for(int a=0;a<n;a++){
            if (grado[a]==0) {
                    nAislado++;
                    co12+="El nodo "+(a+1)+" es aislado."+"\n";
                }
                if(grado[a]==1){
                    co13+="El nodo "+(a+1)+" es colgante."+"\n"; 
                }
        }
        for(int i=0;i<grado.length;i++){
           // recorremos los valores del array B
            for(int j=0;j<grado.length;j++){
                // Cada valor del array A lo comparemos con todos los valores del array B
                if(grado[i]==grado[j])
                    elemA++;
           }//System.out.println(elemA+".\n");
                bandera=elemA;
                elemA=0;
       }
        
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
            if(bandera==n){
            co10="Es gráfica regular.\n";
            }else{
               co10="No es gráfica regular.\n";
            }
        }else{
            co10="No es gráfica regular.\n"; 
        }
        
////////////////////////Consideracion 12 nodo aislado //////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(co12.equals("")){
            co12="No hay nodos aislados.\n"; 
        }
////////////////////////Consideracion 13 nodo colgante //////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(co13.equals("")){
            co13="No hay nodos colgantes.\n"; 
        } 
        co11=c11(m,grado);
        co15=c15(m,grado);
        co16=c16(m);
        return co9+co10+co11+co12+co13+co15+co16;
    }
    //esta función es de la consideracion5 11
    public static String c11(long[][]mat,int grado[]){///////////////////////Consideracion 11 lineas en la gráfica //////////////////////////////////////////////////////////////////////////////////////////////////////////
        int numparalelas=0;
        int banderap=0;
        int n=mat.length;
        int numbucles=0;
        int banderabu=0;
        int sumaDeLineas=0;
        int sumaGrados=0;
        int sumadegrados=0;
        int lineas=0;
        String co11="";
        String co7="";
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
        if((banderap==(n*n))&&(banderabu==(n))){
            co7="Es una gráfica simple.\n";
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][j]==1){
                         lineas+=1;
                    }
                }
            }
            sumaDeLineas=lineas/2;
        }else{
            co7="Es una gráfica general.\n";  
        }                   
//System.out.println(sumaDeLineas+".\n"); 
        if("Es una gráfica simple.\n".equals(co7)){
            co11="La gráfica tiene "+sumaDeLineas+" líneas.\n";
        }else{
            for(int i = 0; i <n; i++){
                sumadegrados+=grado[i];
            }
            sumaGrados=sumadegrados/2;
            co11="La gráfica tiene "+sumaGrados+" líneas.\n";
        }
         //System.out.println(sumadegrados+".\n"); 
        return co11;
    }
    //esta función es de la consideracion5 16
    public static String c16(long[][]m){
        int n=m.length;
        int conectadaf=0;
        String co16="";
////////////////////////Consideracion 16 gráfica fuertemente conectada //////////////////////////////////////////////////////////////////////////////////////////////////////////
        for (int i=0;i<m.length;i++){
            for(int j=0;j<m.length;j++){
                if(m[i][j]!=1){
                    co16="No es  gráfica fuertemente conectada.\n";
                }else{
                    conectadaf+=1;
                    if(conectadaf==(n*n)){
                        co16="La gráfica fuertemente conectada.\n"; 
                    }
                }                          
            }  
        }
        return co16;
    }
    //esta función es de  la consideracion5 15
    public static String c15(long[][]mat,int[] grado){
        int completa=0;
        String consideracion15="";
        int numparalelas=0;
        int banderap=0;
        int n=mat.length;
        int numbucles=0;
        int banderabu=0;
        int elemA=0; 
        int p, sumaF = 0;
        int bandera=0;
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
        for(int j=0;j<grado.length;j++){
           if(grado[j]==mat.length-1)
               completa=1;
           else{
               completa=-1;
            }
        }
        //para saber si es regular
        for(int i=0;i<grado.length;i++){
           // recorremos los valores del array B
            for(int j=0;j<grado.length;j++){
                // Cada valor del array A lo comparemos con todos los valores del array B
                if(grado[i]==grado[j])
                    elemA++;
           }//System.out.println(elemA+".\n");
                bandera=elemA;
                elemA=0;
       }
        if((banderap==(n*n))&&(banderabu==(n))&&(bandera==n)){
            if(completa==-1){
                consideracion15="La grafica no es completa.\n"; 
            }else if(completa==1){
                consideracion15="La gráfica  es completa.\n"; 
            }
        }else{
            consideracion15="La gráfica  no es completa por que no es regular.\n"; 
        }
        //ystem.out.println("la matriz  mide"+mat.length+".\n ");
        //System.out.println("el grado debe ser de n-2 es="+(mat.length-1)+".\n ");
        return consideracion15;
    }
    public static String c17(long[][]m){//obtiene las potencias de la matriz
        long[][] m3= new long[m.length][m.length];
        int i=1;
        int p=m.length;
        int n=m.length;
         String co18="";
         co18=potencia(m);
       return co18; 
    }
}
