/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatrizTrayectoria;
import java.awt.Color;
import java.awt.Container;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 
 import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JScrollPane;
 import javax.swing.JTextArea;
 import javax.swing.JOptionPane;
 import javax.swing.JTextField;
 
 public class MatrizT extends JFrame implements ActionListener{
    int pregunta=ingreso("Ingrese el número de circuitos");
    int pregunta2=ingreso2("Ingrese el número de lineas");
    Container contenedor;
    JLabel[] etiqueta1;
    JLabel[] etiqueta2;
    JTextField[][] matriz;
    JTextArea mensaje;
    JTextArea mayor;
    JScrollPane scrollpane;
    JScrollPane scrollpanemayor;
    JButton aceptar;
    JButton grafica;
    static compara comp = new compara();
    static int contador = 0;
    public String consideraciones(int[][] mat){
        int n=pregunta;
        int m=pregunta2;
        int bandera=0;
        int p;
        int sumaF = 0,cont=0,cero=0,bandera2=0;
        int sumc;
        boolean sw = true;
        String ceros="";
        int gradoE[]= new int[n];
        String comprobacion="",total="",c="",co1="";
        for(int i = 0; i < n; i++){
            int vectorCircuitos [] = comp.renglones(i, n, m, mat);
            
            for(int u = 0; u < n; u++){
                //System.out.print(vectorParalelas[u]);
                if(vectorCircuitos[u] == 1){
                    comprobacion+=("\nLa trayectoria "+(i+1)+" es igual a la trayectoria: "+(u+1));
                    contador++;
                }
            }
           contador = 0;
            System.out.println("\n");
        } 
        if(comprobacion.equals("")){
                comprobacion=("\nNo hay circuitos repetidos\n");
                bandera=1;
            }
        
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
                
                sumaF = 0;
        } 
          
          for(int i=0;i<n;i++){
            if(gradoE[i]==0){
                ceros+="\nEl renglón "+(i+1)+" tiene solo ceros.";
            }else{
                cero++;
            }
        }  
        if(cero==n){
            bandera2=1;
        }
        if(bandera==1 && bandera2==1){
            c="\nSe puede realizar el Análisis";
            co1=ConsiTray.c1(mat, n,m);
            total=c+comprobacion+co1;
            
        }else{
            c="\nNo se  puede realizar el Análisis";
            total=c+comprobacion+ceros;
        }
        
        return total;
    }
    public MatrizT(){
        matriz=new JTextField[pregunta][pregunta2];
        etiqueta1=new JLabel[pregunta2];
        etiqueta2=new JLabel[pregunta];
        contenedor=getContentPane();
        contenedor.setLayout(null);
        mayor=new JTextArea();
        scrollpanemayor=new JScrollPane(mayor);
        scrollpanemayor.setBounds(0,0,789,660);
        scrollpanemayor.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollpanemayor.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        mayor.setBackground(Color.darkGray);
         for(int i=0;i<pregunta;i++){
             for(int j=0;j<pregunta2;j++){
                 etiqueta1[j]=new JLabel(""+(j+1));
                 etiqueta2[i]=new JLabel(""+(i+1));
                 etiqueta1[j].setBounds((int) ((j+2.4)*25),25,25,25);
                 etiqueta2[i].setBounds(21,(i+2)*25,25,25);
                 mayor.add(etiqueta1[j]);
                 mayor.add(etiqueta2[i]);
             }
         }
         for (int i=0;i<matriz.length;i++){
                  for(int j=0;j<pregunta2;j++){
                        matriz[i][j]=new JTextField();
                        matriz[i][j].setBounds((j+2)*25,(i+2)*25,25,25);
                        mayor.add(matriz[i][j]);
                        matriz[i][j].addActionListener( this );
                   }
         }
         
                int p=matriz[pregunta-1][pregunta2-1].getX();
                int w=matriz[pregunta-1][pregunta2-1].getY();
                int abajo=matriz[pregunta-1][pregunta2-1].getY();
                aceptar=new JButton("Aceptar");
                aceptar.setBounds ( 60, w+30, 100, 30 );
                aceptar.addActionListener( this );
                mensaje=new JTextArea();
                scrollpane=new JScrollPane(mensaje);
                scrollpane.setBounds(60,abajo+65,500,280);
                String cadena=new String("");
                for(int c=0;c<(p/2.9);c++)
                  {
                     cadena+=" ";
                  }
                mayor.setText(cadena);
                String cadena1=new String("");
                for(int d=0;d<(w/14);d++)
                {
                  cadena1+="\n";
                }
                mayor.setText(cadena+cadena1);
                mensaje.setEditable(false);
                mayor.add(aceptar);
                mayor.add(scrollpane);
                mayor.setEditable(false);
                contenedor.add(scrollpanemayor);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setTitle("Matriz Trayectoria");
                setSize(807,707);
                setLocationRelativeTo(null);
                show ();
                matriz[0][0].grabFocus();
    }
    public int ingreso(String men){
           boolean ban=true;
           int valor=0;
           int contador=0;
           do{
                try{
                    valor=Integer.parseInt(JOptionPane.showInputDialog(null,men,"Entrada de  datos",JOptionPane.QUESTION_MESSAGE));
                    
                    ban=true; 
                    if(valor<=1||valor>10)
                        throw new Exception("Tamaño inválido");
                 }catch(NumberFormatException e){
                          contador++;
                          JOptionPane.showMessageDialog(null,"Solo ingrese números enteros","Error",JOptionPane.ERROR_MESSAGE);
                          ban=false;
                   }catch(Exception e){
                         contador++;
                         JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                         ban=false;
                    }
                    if(contador==3)
                        System.exit(0);
            }while(ban==false);
         return valor;
    }
    public int ingreso2(String men){
           boolean ban=true;
           int valor=0;
           int contador=0;
           do{
                try{
                    valor=Integer.parseInt(JOptionPane.showInputDialog(null,men,"Entrada de  datos",JOptionPane.QUESTION_MESSAGE));
                    
                    ban=true; 
                    if(valor<=1||valor>20)
                        throw new Exception("Tamaño inválido");
                 }catch(NumberFormatException e){
                          contador++;
                          JOptionPane.showMessageDialog(null,"Solo ingrese números enteros","Error",JOptionPane.ERROR_MESSAGE);
                          ban=false;
                   }catch(Exception e){
                         contador++;
                         JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                         ban=false;
                    }
                    if(contador==3)
                        System.exit(0);
            }while(ban==false);
         return valor;
    }
    @Override
    public void actionPerformed(ActionEvent evento){
       int bandera=0;
       int[][] circuito=new int[pregunta][pregunta2];
       if(evento.getSource()==aceptar){
                       for (int i=0;i<pregunta;i++){
                            for(int j=0;j<pregunta2;j++){
                                  if((matriz[i][j].getText()).equals("")){
                                      bandera++;
                                  }
                            }
                       }
                   try{
                        if(bandera>=1){
                             throw new Exception("Faltaron valores por ingresar");
                        }else{
                            for (int i=0;i<pregunta;i++)
                                for(int j=0;j<pregunta2;j++){
                                    if((Integer.parseInt(matriz[i][j].getText())<=1)&&(Integer.parseInt(matriz[i][j].getText())>=0)){   
                                        circuito[i][j]=Integer.parseInt(matriz[i][j].getText());
                                    }else
                                         throw new Exception("Solo se aceptan 1,0");
                                 }
                            String resultado=consideraciones(circuito);
                                        mensaje.setText(resultado);
                        }            
                   }catch(Exception e){
                                       JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
                                       
                     }
                  
         }
         if(evento.getSource()==grafica){
                           JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
         }
       }
 }