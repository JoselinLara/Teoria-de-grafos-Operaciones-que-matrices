/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatrizTrayectoria;

/**
 *
 * @author hades
 */
public class ConsiTray {
    public static String c1(int[][]mat, int n,int m){
       int p;
        int sumaF = 0,cont=0,c=0,paralelas=0;
        int sumc;
        float eM,em;
        int numerom,numm;
        int posM,posm;
        int x=0,y=0;
        boolean sw = true;
        String renglones="",col="",co3="",co6="",co7="",co8="",co19="",ruta="",e="";
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
               //System.out.println("La suma de la fila " +(pos+1)+ " es: " + gradoE[pos]);
                renglones+="\nSuma por renglon "+(i+1)+"  = "+gradoE[i];
                sumaF = 0;
        } 
          for(int i = 0; i <m; i++){
                sumc=0;  
                for (int j = 0; j <n;j++) {  
                    sumc=(int)(sumc+mat[j][i]);
                }
                gradoI[i]=sumc;
                //System.out.println("La suma de la columa   "+(pos+1)+"es: " + gradoI[pos]);
               // col+="\nSuma por columna "+(pos+1)+"  = "+gradoI[pos];
        } 
        for(int i=0;i<m;i++){
            if(gradoI[i]==0){
                co3+="\nLa línea "+(i+1)+" no pertenece a ninguna trayectoria";
            }else{
                cont++;
            }
        }  
        if(cont==m){
            co3="\nTodas las  líneas  pertenecen al menos a una trayectoria ";
        }
        for(int i=0;i<m;i++){
            if(gradoI[i]==n){
                co6+="\nLa linea "+(i+1)+" se usa en todas las trayectorias.";
            }else{
                c++;
            }
        }  
        if(c==m){
            co6="\nNo se tiene una línea que se  use en todas las trayectorias. ";
        }
        
        
        for(int i=0;i<n;i++){
            co8+="\nLa longitud de la trayectoria  "+(i+1)+"  es: "+gradoE[i];
            
        }  
        int div=n;
        
        for(int i=0;i<m;i++){
            propor[i]=(float)gradoI[i]/div;
           // System.out.println(gradoI[pos]+"\n");
        }
        eM=propor[0]; em=propor[0];
       
         for(int pos=0;pos<m;pos++){
            if(propor[pos]>eM){
               eM=propor[pos];
               x=pos;
            }
            if(propor[pos]<em){
               em=propor[pos];
               y=pos;
            } 
        }
        numerom=gradoE[0];
        numm=gradoE[0];
        posM=0;
        posm=0;
        for(int i=0;i<n;i++){
            if(gradoE[i]>numerom){
               numerom=gradoE[i];
               posM=i;
            }
            if(gradoE[i]<numm){
               numm=gradoE[i];
               posm=i;
            } 
        }
        ruta="\nLa ruta más corta es la trayectoria "+(posm+1)+" tiene longitud "+numm+
                "\nY la más larga es la trayectoria "+(posM+1)+" tiene longitud "+numerom+".";
        //System.out.println(numerom);
        //System.out.println("\n"+numm);
        e="\nLa línea más usada es "+(x+1)+"\nY la menos usada es "+(y+1);
        //System.out.println(1/2);
        for(int i=0;i<m;i++){
            co19+="\nLa proporción de  uso de la línea "+(i+1)+" es: "+propor[i];
        }
         return co3+co6+co8+co19+e+ruta;
    }
}
