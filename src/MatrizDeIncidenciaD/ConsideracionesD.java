/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatrizDeIncidenciaD;

import java.util.Arrays;

/**
 *
 * @author hades
 */

public class ConsideracionesD {
    static compara comp = new compara();
    static int conta = 0;
    public static String c1(String[][] matriz, int n, int m){//verifica  que sera  m de incidencia 
        int sumc;
        int elemA=0;
        int cont=0;
        String co1="";
        int gradoI[]= new int[m];
         for(int i = 0; i <m; i++){
                sumc=0;  
                for (int j = 0; j <n;j++) {
                    if(matriz[j][i].equals("+-1")){
                       cont++;
                       if(cont==1){
                           sumc=0;
                       }else{
                           break;
                       }
                    }else{
                        sumc=(int)(sumc+Integer.parseInt(matriz[j][i]));
                    }
                }
                gradoI[i]=sumc;
                System.out.println("La suma de la columa   "+(i+1)+"es: " + gradoI[i]);
        } 
         
        for(int a=0;a<m;a++){
                if(gradoI[a]==0)
                    elemA++;
        }
         if(elemA==(m)){
             co1="La matriz  corresponde  a  una  matriz de  incidencia \npara grafos   dirigidos.";
         }else {
             co1="La matriz no corresponde  a  una  matriz de  incidencia \npara grafos   dirigidos.";
         }
         return  co1; 
    }
    public static String gradoEI(String[][] matriz, int n, int m){
        int sumc=0; int elemA=0; int bandera=0; 
        int sumaG[]=new int[m];
        int gradoI[]= new int[m];
        int gradoE[]= new int[m];
        int p;
        int sumaF = 0,paralela=1;
        int contador=0;
        int cont2=0;
        int cont3=0;
        int cont4=0;
        int cont5=0;
        int cont6=0;int banderabu=0;
        String co2="",co3="",co7="",co6="",co8="",co9="",co10="",co11="",co13="",co16="",co17="",co19="",co18="";
        boolean sw = true;
        boolean prueba=true;
        for(int i = 0; i <n; i++){
                p = 0;
                sumc=0; 
                while ((p < m) && (sw == true)){
                    switch (matriz[i][p]) {
                        case "+-1":
                            sumaF++;
                            sumc++;
                            break;
                        case "1":
                            sumaF = (int) (sumaF +Integer.parseInt(matriz[i][p]) );
                            break;
                        case "-1":
                            sumc++;
                            break;
                        default:
                            break;
                    }
                     if(matriz[i][p].equals("+-1")){
                                co11+="\nEl nodo "+(i+1)+" tiene un bucle";
                            }else{
                                cont6++;
                            }
                    if(p == m){
                       sw = false;
                    }
                    p++; 
                }
                    gradoE[i]=sumaF;
                    gradoI[i]=sumc;
                //System.out.println("La suma de la fila " + num + " es: " + sumaF);
                co2+="\nNodo "+(i+1)+" tiene grado externo = "+gradoE[i]+" y tiene grado interno = "+ gradoI[i]+".";
                
                if((gradoE[i]==0)&&(gradoI[i]==0)){
                    co3+="\nEl nodo "+(i+1)+" es aislado";
                }else{
                    contador++;
                }
                if(gradoE[i]==0){
                    co7+="\nEl nodo "+(i+1)+" es nodo terminal";
                }else{
                    cont2++;
                }
                if(gradoI[i]==0){
                    co8+="\nEl nodo "+(i+1)+" es nodo inicial";
                }else{
                    cont3++;
                }
                if(gradoE[i]>=1&&gradoI[i]>=1){
                    co9+="\nEl nodo "+(i+1)+" es nodo intermedio";
                }else{
                    cont4++;
                }
                if(gradoE[i]==1&&gradoI[i]==0){
                    co10+="\nEl nodo "+(i+1)+" es nodo colgante e inicial";
                }else if(gradoE[i]==0&&gradoI[i]==1){
                    co10+="\nEl nodo "+(i+1)+" es nodo colgante y final";
                }else {
                    cont5++;
                }
                sumaF = 0;
        } 
         for(int i=0;i<m;i++){
           // recorremos los valores del array B
            for(int j=0;j<m;j++){
                // Cada valor del array A lo comparemos con todos los valores del array B
               if(gradoE[i]!=gradoI[j])
                    elemA++;
           }//System.out.println(elemA+".\n");
                bandera=elemA;
                elemA=0;    
       }
         if(contador==n){
            co3="\nNo hay nodos aislados";
        }
        if(cont2==n){
            co7="\nNo hay nodos terminales";
        }
        if(cont3==n){
            co8="\nNo hay nodos Iniciales";
        }
        if(cont4==n){
            co9="\nNo hay nodos intermedios";
        }
        if(cont5==n){
            co10="\nNo hay nodos colgantes";
        }
        if(cont6==(n*m)){
            co11="\nNo hay bucles";
        }
        
        boolean b= Arrays.equals(gradoE,gradoI);
        if(b==!true){
              co19="\nNo es digráfica balanceada.";
        }else{
              co19="\nEs digráfica balanceada."; 
        }
         if(bandera==m){
               co18="\nEs digráfica regular.";
            }else{
               co18="\nNo es digráfica regular.";
            }
         co6=c6(matriz, n, m);
         if((co6.equals("\nNo hay líneas paralelas"))){
             paralela=0;
         }
         if((paralela==0)&&(cont6==(n*m))){
             co13="\nEs una digráfica simple, pero no es pesudodigráfica ni multidigráfica";
         }else if((cont6==0)){
             if((paralela==0)||((paralela==1))){
                 co13="\nEs una pseudodigráfica, pero no es digráfica simple ni multidigráfica";
             }
         }else if((paralela==0)){
              co13="\nEs una multidigráfica, no es digráfica simple ni pseudodigráfica";
         }
           ////Digráficas  simétricas
          for(int i=0;i<m;i++){
              sumaG[i]=gradoE[i]+gradoI[i];
          }
           for(int i=0;i<m;i++){
               if((sumaG[i]!=(n-1))){
                    prueba=false;
                    break;
               }
          }
           int dcom=0;
           for(int i=0;i<m;i++){
               if((gradoE[i]==(n-1))&&(gradoI[i])==(n-1)){
                   dcom=1;
               }else{
                   dcom=-1;
                   break;
               }
          }
           if((dcom==1)&&(cont6==(n*m))&&(paralela==0)){
               co16="\nEs una digráfica completa";
           }else{
               co16="\nNo es una digráfica completa";
           }
           if((prueba==true)&&(cont6==(n*m)) &&(paralela==0)){
               co17="\nEs digráfica asimétrica completa";
           }else{
               co17="\nNo es digráfica asimétrica completa";
           }
       System.out.println(n-1);
         return  co2+co3+co6+co7+co8+co9+co10+co11+co13+co16+co17+co18+co19; 
    }
    public static String c6(String[][] matriz, int n, int m){///lineas  paralelas
        
        String co6="";
         for(int i = 0; i < m; i++){
            int vectorParalelas [] = comp.columnas(i, n, m, matriz);
            
            for(int u = 0; u < m; u++){
                //System.out.print(vectorParalelas[u]);
                if(vectorParalelas[u] == 1){
                   co6+=("\nLa línea "+(i+1)+" es paralela a: "+(u+1));
                    conta++;
                }
            }
            conta = 0;
           
            //System.out.println("\n");
        }
          if(co6.equals("")){
                co6="\nNo hay líneas paralelas";
            }
          
         return  co6; 
    }
}
