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
public class MAcce {
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
     public static String c1(String[][]matAcce){
         int nInter=0,ncol=0;
         int[] renglon=new int[matAcce.length];
         int[] columna=new int[matAcce.length];
         int n=matAcce.length;
         int max=(int) (((Math.pow((n+1),2))+(n+1))/2);
         String colgante="", aislado="",intermedios="",finales="",inicial="",c3="",total="",co2="", mt="",co8="";
        //cuenta  + por  ren y col
         for(int f=0;f<matAcce.length;f++){
            for(int g=0;g<matAcce.length;g++){
                if("+".equals(matAcce[f][g])){
                    nInter++;
                }
            }
            for(int num=0;num<matAcce.length;num++){                
                if("+".equals(matAcce[num][f])){
                    ncol++;
                }
                
            }
            renglon[f]=nInter;
            columna[f]=ncol;
            nInter=0;
            ncol=0;
        }
          
         for(int a=0;a<matAcce.length;a++){  
                //System.out.println( (a+1) +"  columna  es: " + columna[a]+"\nPor renglon: "+renglon[a]);
            
                for (String[] m11 : matAcce) {
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
        co2=c2(matAcce,matAcce.length);
        mt=("\nM(G)= \n")+imprimirS(matAcce,n);
        String potencia="\nEs necesario elevar  la  matriz de adyacencia \nhasta la potencia: "+max;
        total=c3+potencia+"\nAnálisis:\n "+co2+"\n"+inicial+finales+intermedios+aislado+colgante;
        
       return total;
     }
}


