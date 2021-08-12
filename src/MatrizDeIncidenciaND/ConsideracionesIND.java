/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatrizDeIncidenciaND;

/**
 *
 * @author hades
 */
public class ConsideracionesIND {
    static compara comp = new compara();
    static int conta = 0;
    public static String c1(int[][] matriz, int n, int m){// no usar , ya esa  en la  función principal :v
        int sumc;
        int elemA=0; 
        String co1="";
        int gradoI[]= new int[m];
         for(int i = 0; i <m; i++){
                sumc=0;  
                for (int j = 0; j <n;j++) {  
                    sumc=(int)(sumc+matriz[j][i]);
                }
                gradoI[i]=sumc;
                //System.out.println("La suma de la columa   "+(i+1)+"es: " + gradoI[i]);
        } 
         
        for(int a=0;a<m;a++){
                if(gradoI[a]==2)
                    elemA++;
        }
         if(elemA==(m)){
             co1="La matriz  corresponde  a  una  matriz de  incidencia \npara grafos  no dirigidos.";
         }else {
             co1="La matriz no corresponde  a  una  matriz de  incidencia \npara grafos  no dirigidos.";
         }
         return  co1; 
    }
    public static String c2(int[][] matriz, int n, int m){
        int  contador=0;
        int sumc;
        int elemA=0; 
        int gradoI[]= new int[n];
        String co2="",co3="",co4="",co5="";String co6="",co8="",co11="";
        co3=c3(matriz,n,m);
        co4=c4(matriz,n,m);
        co5=c5(matriz,n,m);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matriz[i][j]==2){
                    contador++;
                    co2+="\nExiste un bucle en el nodo "+(i+1);
                }else{
                    if(contador==0){
                       co2="\nNo hay  bucles"; 
                    }
                }
            }
        }
         
        
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
           
            System.out.println("\n");
        }
          if(co6.equals("")){
                co6="\nNo hay líneas paralelas";
            } 
         for(int i = 0; i <n; i++){
                sumc=0;  
                for (int j = 0; j <m;j++) {  
                    sumc=(int)(sumc+matriz[i][j]);
                }
                gradoI[i]=sumc;
        }
        if((co6.equals("\nNo hay líneas paralelas"))&&(co2.equals("\nNo hay  bucles"))){
            co11=c11(gradoI,0,0);
        }else{
            co11=c11(gradoI,1,1);
        }
        
          co8=c8(co2,co6);
          
        return co2+co3+co4+co5+co6+co8+co11;
    }
    public static String c3(int[][] matriz, int n, int m){
        int sumc;
        int elemA=0; 
        String co3="";
        int gradoI[]= new int[n];
         for(int i = 0; i <n; i++){
                sumc=0;  
                for (int j = 0; j <m;j++) {  
                    sumc=(int)(sumc+matriz[i][j]);
                }
                gradoI[i]=sumc;
                co3+="\nEl grado del nodo "+(i+1)+" es: " + gradoI[i];
        }
         return  co3; 
    }
    public static String c4(int[][] matriz, int n, int m){
        int sumc;
        int contador=0; 
        String co4="";
        int gradoI[]= new int[n];
         for(int i = 0; i <n; i++){
                sumc=0;  
                for (int j = 0; j <m;j++) {  
                    sumc=(int)(sumc+matriz[i][j]);
                }
                gradoI[i]=sumc;
        }
        for(int i = 0; i <n; i++){
            if(gradoI[i]==0){
                contador++;
                co4+="\nEl nodo "+(i+1)+" es aislado";
            }else{
                if(contador==0){
                    co4="\nNo hay nodos aislados";
                }
            }
        }
         return  co4; 
    }
    public static String c5(int[][] matriz, int n, int m){
        int sumc;
        int contador=0; 
        String co5="";
        int gradoI[]= new int[n];
         for(int i = 0; i <n; i++){
                sumc=0;  
                for (int j = 0; j <m;j++) {  
                    sumc=(int)(sumc+matriz[i][j]);
                }
                gradoI[i]=sumc;
        }
        for(int i = 0; i <n; i++){
            if(gradoI[i]==1){
                contador++;
                co5+="\nEl nodo "+(i+1)+" es colgante";
            }else{
                if(contador==0){
                    co5="\nNo hay nodos colgantes";
                }
            }
        }
         return  co5; 
    }
    public static String c8(String bucle, String paralela){
        String co8="";
        String co9="",co10="";
        if((paralela.equals("\nNo hay líneas paralelas"))&&(bucle.equals("\nNo hay  bucles"))){
            co8="\nLa gráfica es  simple";
        }else{
            co8="\nLa gráfica es general";
        }
        if((!bucle.equals("\nNo hay  bucles"))){
            if((paralela.equals("\nNo hay líneas paralelas"))||(!paralela.equals("\nNo hay líneas paralelas"))){
                 co9="\nEs una pseudográfica";
             }
         }else if((!paralela.equals("\nNo hay líneas paralelas"))){
              co10="\nEs una multigráfica\nNo es pseudográfica";
         }else{
            co10="\nNo es una multigráfica ni pseudográfica";
        }
        return co8+co9+co10;
    }
    public static String c11(int[]gradoE,int paralela,int bucle){
      int elemA=0, bandera=0,com=0,b=0,fco=0,a=0;
      String co11="",co12="",co13="";
        int n=gradoE.length;
        for(int i=0;i<n;i++){
           // recorremos los valores del array B
            for(int j=0;j<n;j++){
                // Cada valor del array A lo comparemos con todos los valores del array B
                if(gradoE[i]==gradoE[j])
                    elemA++;
           }
            
                bandera=elemA;
                //System.out.println(elemA+"\n");
                elemA=0;
       }
        for(int i=0;i<n;i++){
           // recorremos los valores del array B
            for(int j=0;j<n;j++){
                // Cada valor del array A lo comparemos con todos los valores del array B
                if(gradoE[i]==(n-1))
                    b++;
           }
                com=b;
                //System.out.println(elemA+"\n");
                b=0;
       }
        for(int i=0;i<n;i++){
           // recorremos los valores del array B
            for(int j=0;j<n;j++){
                // Cada valor del array A lo comparemos con todos los valores del array B
                if(gradoE[i]==(n+1))
                    a++;
           }
                fco=a;
                //System.out.println(elemA+"\n");
                a=0;
       }
        if((paralela==0)&&(bucle==0)){
         if(fco==n){
               co13="\nEs gráfica completa.";
            }else{
               co13="\nNo es gráfica completa.";
            }
        }else{
            co13="\nNo es gráfica completa."; 
        } 
        if((paralela==0)&&(bucle==0)){
         if(com==n){
               co12="\nEs gráfica completa.";
            }else{
               co12="\nNo es gráfica completa.";
            }
        }else{
            co12="\nNo es gráfica completa."; 
        } 
        //System.out.println(bandera+"\n");
         //System.out.println(paralela+"\n");
          //System.out.println(bucle+"\n");
         if((paralela==0)&&(bucle==0)){
            if(bandera==n){
               co11="\nEs gráfica regular.";
            }else{
               co11="\nNo es gráfica regular.";
            }
        }else{
            co11="\nNo es gráfica regular."; 
        } 
          return co11+co12+co13;
    }
}
