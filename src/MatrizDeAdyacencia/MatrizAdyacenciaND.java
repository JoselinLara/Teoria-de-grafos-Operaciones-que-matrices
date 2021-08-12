/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatrizDeAdyacencia;

/**
 *
 * @author hades
 */
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
 
 public class MatrizAdyacenciaND extends JFrame implements ActionListener{
    int pregunta=ingreso("Ingrese el numero de nodos");
    Container contenedor;
    JLabel[] etiqueta1;
    JLabel[] etiqueta2;
    JTextField[][] matriz;
    JTextArea mensaje;
    JTextArea mayor;
    JScrollPane scrollpane;
    JScrollPane scrollpanemayor;
    JButton aceptar;
    public String consideraciones(long[][] m){
         int n=m.length;
         String total="";
         String consideracion1="";
         String c3="";
         String consi="";
         String consideracion17="";
         boolean con3=metodos.conci3(m);
         try{
             if(con3!=true){
                 c3="La matriz es no simetrica.\n No es  una matriz de adyacencia.";
             }else{
                 c3="La matriz es simetrica.\n";
                 consideracion1="La matriz  tiene "+n+" nodos.\n";
                 consi=metodos.consideracion5(m);// este String es la suma de la consideracion5 5 a la 16
                 consideracion17=metodos.c17(m); 
                 
             }
         }catch(Exception e){
                        JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                                     
         }
        total=consideracion1+c3+consi+"\n"+consideracion17;
                return total;
        
    }
    public MatrizAdyacenciaND(){
        matriz=new JTextField[pregunta][pregunta];
        etiqueta1=new JLabel[pregunta];
        etiqueta2=new JLabel[pregunta];
        contenedor=getContentPane();
        contenedor.setLayout(null);
        mayor=new JTextArea();
        scrollpanemayor=new JScrollPane(mayor);
        scrollpanemayor.setBounds(0,0,889,660);
        scrollpanemayor.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollpanemayor.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        mayor.setBackground(Color.darkGray);
         for(int i=0;i<pregunta;i++){
                 etiqueta1[i]=new JLabel(""+(i+1));
                 etiqueta2[i]=new JLabel(""+(i+1));
                 etiqueta1[i].setBounds((int) ((i+2.4)*25),25,25,25);
                 etiqueta2[i].setBounds(21,(i+2)*25,25,25);
                 mayor.add(etiqueta1[i]);
                 mayor.add(etiqueta2[i]);
         }
         for (int i=0;i<matriz.length;i++){
                  for(int j=0;j<matriz.length;j++){
                        matriz[i][j]=new JTextField();
                        matriz[i][j].setBounds((j+2)*25,(i+2)*25,25,25);
                        mayor.add(matriz[i][j]);
                        matriz[i][j].addActionListener( this );
                   }
         }
                int p=matriz[pregunta-1][pregunta-1].getX();
                int w=matriz[pregunta-1][pregunta-1].getY();
                aceptar=new JButton("Aceptar");
                aceptar.setBounds ( p+80,  40, 100, 30 );
                aceptar.addActionListener( this );
                mensaje=new JTextArea();
                scrollpane=new JScrollPane(mensaje);
                scrollpane.setBounds(p+80,80,500,500);
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
                setTitle("Matriz de adyacencia para grafos no dirigidos");
                setSize(907,707);
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
                
            }while(ban==false);
         return valor;
    }
    @Override
    public void actionPerformed(ActionEvent evento){
       int bandera=0;
       if(evento.getSource()==aceptar){
             long adyacencia[][]=new long[pregunta][pregunta];
                   
                       for (int i=0;i<pregunta;i++){
                            for(int j=0;j<pregunta;j++){
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
                                for(int j=0;j<pregunta;j++){
                                 if((matriz[i][j].getText()).contains("1")||(matriz[i][j].getText()).contains("2")||(matriz[i][j].getText()).contains("0")){   
                                        adyacencia[i][j]=Long.parseLong(matriz[i][j].getText());
                                    }else
                                         throw new Exception("Solo se aceptan 1,0,2");
                            }
                            
                                        String resultado=consideraciones(adyacencia);
                                        mensaje.setText(resultado);
                        }            
                   }catch(Exception e){
                              for (int k=0;k<pregunta;k++)
                                  for(int l=0;l<pregunta;l++)
                                       adyacencia[k][l]=0;
                                       JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                                       matriz[0][0].grabFocus();
                     }
                  
         }
       }

                               
}
       
 
 
  