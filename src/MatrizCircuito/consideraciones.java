/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatrizCircuito;

/**
 *
 * @author hades
 */
public class consideraciones {
    static compara comp = new compara();
    static int contador = 0;
    public static String circuito(int[][]matrix,int n,int m){
        String comprobacion="";
        for(int i = 0; i < n; i++){
            int vectorCircuitos [] = comp.renglones(i, n, m, matrix);
            
            for(int u = 0; u < n; u++){
                //System.out.print(vectorParalelas[u]);
                if(vectorCircuitos[u] == 1){
                    comprobacion+=("\nEl vertice "+(i+1)+" esta en circuito con: "+(u+1));
                    contador++;
                }
            }
           contador = 0;
            System.out.println("\n");
        } 
        if(comprobacion.equals("")){
                comprobacion=("\nNo hay circuitos repetidos");
            }
            
        return comprobacion;
    }
    public static String c3(int[][]mat,int n,int m){
        int p;
        int sumaF = 0,cont=0,c=0,paralelas=0;
        int sumc;
        boolean sw = true;
        String renglones="",col="",co3="",co6="",co7="",co8="",co19="";
        int gradoI[]= new int[m];
        int gradoE[]= new int[n];
        float propor[]= new float[m];
         for(int i = 0; i <n; i++){
                p = 0;
                while ((p < m) && (sw == true)){
                    sumaF = (int) (sumaF + mat[i][p]);
                    if(p == m){
                       sw = false;
                    }
                    p++;
                }
                
                gradoE[i]=sumaF;
               //System.out.println("La suma de la fila " +(i+1)+ " es: " + gradoE[i]);
                renglones+="\nSuma por renglon "+(i+1)+"  = "+gradoE[i];
                sumaF = 0;
        } 
          for(int i = 0; i <m; i++){
                sumc=0;  
                for (int j = 0; j <n;j++) {  
                    sumc=(int)(sumc+mat[j][i]);
                }
                gradoI[i]=sumc;
                //System.out.println("La suma de la columa   "+(i+1)+"es: " + gradoI[i]);
                col+="\nSuma por columna "+(i+1)+"  = "+gradoI[i];
        } 
        for(int i=0;i<m;i++){
            if(gradoI[i]==0){
                co3+="\nLa línea "+(i+1)+" no pertenece a un circuito";
            }else{
                cont++;
            }
        }  
        if(cont==m){
            co3="\nTodas las  líneas  pertenecen al menos a 1 circuitos ";
        }
        for(int i=0;i<n;i++){
            if(gradoE[i]==1){
                co6+="\nEn el renglón "+(i+1)+" tiene un bucle";
            }else{
                c++;
            }
        }  
        if(c==n){
            co6="\nNo hay bucles";
        }
        for(int i=0;i<n;i++){
            if(gradoE[i]==2){
                co7+="\nEl nodo "+(i+1)+" tiene líneas paralelas si es una  gráfica o recuerentes si es  digráfica";
            }else{
                paralelas++;
            }
        }  
        if(paralelas==n){
            co7="\nNo hay líneas paralelas o recurrendes";
        }
        for(int i=0;i<n;i++){
            co8+="\nLa longitud del circuito "+(i+1)+"  es: "+gradoE[i];
            
        }  
        int div=n;
        for(int i=0;i<m;i++){
            propor[i]=(float)gradoI[i]/div;
           // System.out.println(gradoI[i]+"\n");
        }
        System.out.println(1/2);
        for(int i=0;i<m;i++){
            co19+="\nLa proporción de  uso de la línea "+(i+1)+" es: "+propor[i];
        }
         return co3+co6+co7+co8+co19;
    }
}
