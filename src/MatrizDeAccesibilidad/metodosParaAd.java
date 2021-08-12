/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatrizDeAccesibilidad;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author hades
 */

public class metodosParaAd {
    public static String[][] transponer(String[][] matriz) {
    String[][] nuevaMatriz = new String[matriz[0].length][matriz.length];
	for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[x].length; y++) {
            	nuevaMatriz[y][x] = matriz[x][y];
            }
	}
        return nuevaMatriz;
    }
     public static  boolean simetrica(String[][] matriz){
        boolean con3=false;
        String[][]MxT=transponer(matriz);
        if(Arrays.deepEquals(matriz,MxT)){
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
   public static String imprimirS(String[][] matriz,int n) {
        String co17="";
            for (String[] matriz1 : matriz) {
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
        if (col_m1 != fil_m2){
		throw new RuntimeException("No se pueden multiplicar las matrices");
        }// La nueva matriz es de filas de M1 y columnas de M2
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
       String [][] matAcce= new String[m1.length][m1.length];
       int[] renglon=new int[m1.length];
       int[] columna=new int[m1.length];
       int i,j,k;int  nInter=0,ncol=0,punto=0;
       int n=m1.length-1;
       int m=m1.length;
       int max=(int) (((Math.pow((n+1),2))+(n+1))/2);
       String co1="",co7="", mpo="", mt="",co2="",intermedios="",finales="",inicial="",aislado="",colgante="";String c3="";
       for(j=0;j<m1.length;j++){
           for(k=0;k<m1.length;k++){
               original[j][k]=m1[j][k];
            }
       }
       for(i=0;i<(max-1);i++){
           cambios=multiplicar(original,m1);
           //System.out.println("X(G)^"+(i+2)+"\n");
           for(int u=0;u<m1.length;u++){
               for(int v=0;v<m1.length;v++){
                  mp[u][v]+=cambios[u][v];
               }
           }
           mpo=("Matriz P= \n")+imprimir(mp);
           co1+=("X(G)^"+(i+2)+"\n")+imprimir(cambios);
           m1=cambios;
       }
         
        //matriz Accesibilidad
        for(int f=0;f<m1.length;f++){
            for(int g=0;g<m1.length;g++){
                if(mp[f][g]>0){
                     matAcce[f][g]="+";
                }else if(mp[f][g]==0){
                     matAcce[f][g]="0";
                }
            }
        }
        //cuenta  + por  ren y col
         for(int f=0;f<m1.length;f++){
            for(int g=0;g<m1.length;g++){
                if("+".equals(matAcce[f][g])){
                    nInter++;
                }
            }
            for(int num=0;num<m1.length;num++){                
                if("+".equals(matAcce[num][f])){
                    ncol++;
                }
                
            }
            renglon[f]=nInter;
            columna[f]=ncol;
            nInter=0;
            ncol=0;
        }
          
         for(int a=0;a<m1.length;a++){  
                //System.out.println( (a+1) +"  columna  es: " + columna[a]+"\nPor renglon: "+renglon[a]);
            
                for (long[] m11 : m1) {
                   if((columna[a]==0)||(renglon[a]==0)){
                       if("+".equals(matAcce[a][a])){
                           colgante+="\nEl nodo "+(a+1)+" es golgante";
                       }else{
                           colgante="\nNo hay nodos colgantes";
                       }
                   }
               }
            if((renglon[a]==0)&&(columna[a]==0)){
                    aislado+="\nEl nodo "+(a+1)+" es aislado."+"\n";
            }
            if((renglon[a]==0)&&(columna[a]>0)){
                    finales+="\nEl nodo "+(a+1)+" es nodo terminal."+"\n"; 
            }else if((renglon[a]>0)&&(columna[a]==0)){
                    inicial+="\nEl nodo "+(a+1)+" es nodo inicial."+"\n"; 
            }else if((renglon[a]>0)&&(columna[a]>0)) {
                   intermedios+="\nEl nodo "+(a+1)+" es nodo intermedio."+"\n"; 
            }
         }
        if(aislado.equals("")){
            aislado="\nNo hay nodos aislados.\n"; 
        }
        if(finales.equals("")){
            finales="\nNo hay nodos terminales.\n"; 
        } 
        if(inicial.equals("")){
           inicial="\nNo hay nodos iniciales.\n"; 
        }
        if(colgante.equals("")){
            colgante="\nNo hay nodos colgantes.";
        }
        if(intermedios.equals("")){
            intermedios="\nNo hay nodos intermedios.";
        }
        boolean con3=metodosParaAd.simetrica(matAcce);
        try{
             if(con3!=true){
                 c3="\nLa matriz es no simetrica por lo tanto es una digráfica.\n";
             }else{
                 c3="\nLa matriz es simetrica por lo tanto es  una  gráfica.\n";
                 
             }
         }catch(Exception e){
                        JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                                     
         }
        co2=c2(matAcce,m1.length);
        mt=("\nM(G)= \n")+imprimirS(matAcce,n);
        String  total="";
        String potencia="\nEs necesario elevar  la  matriz de adyacencia \nhasta la potencia: "+max;
        total=c3+potencia+"\n"+co1+"\n"+mpo+mt+"\nAnálisis:\n "+co2+"\n"+inicial+finales+intermedios+aislado+colgante;
        
       return total;
    }
     public static String c1(long[][]m){//obtiene las potencias de la matriz
        long[][] m3= new long[m.length][m.length];
        int i=1;
        int p=m.length;
        int n=m.length;
         String co20="";
         co20=potencia(m);
       return co20; 
    }
     public static String c2(String[][] matAcce,int n){
        int bandera=0;
        String co2="";
        String co8="";
        for(int f=0;f<n;f++){
            for(int g=0;g<n;g++){
                if("+".equals(matAcce[f][g])){
                    bandera++;
                }
            }
        }
         if(bandera==(n*n)){
            co2="\nLa matriz es  conectada.";
             co8="\nEs completa";
        }else{
            co2="\nLa matriz no es  conectada.";
            co8="\nNo es completa";
        }
         return co2+co8;
     }
}
