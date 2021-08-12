/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatrizDeIncidenciaD;
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
 
 public class MatrizIncidenciaDirigido extends JFrame implements ActionListener{
    int pregunta=ingreso("Ingrese el número de nodos");
    int pregunta2=ingreso2("Ingrese el número de aristas");
    Container contenedor;
    JLabel[] etiqueta1;
    JLabel[] etiqueta2;
    JTextField[][] matriz;
    JTextArea mensaje;
    JTextArea mayor;
    JScrollPane scrollpane;
    JScrollPane scrollpanemayor;
    JButton aceptar;
    public String consideraciones(String[][] mat){
        int n=pregunta;
        int m=pregunta2;
        int sumc;
        int elemA=0;
        int cont=0;
        String total="";
        String consideracion1="";
        String consideracion2="";
        String consideracion6="";
        int gradoI[]= new int[m];
         for(int i = 0; i <m; i++){
                sumc=0;  
                for (int j = 0; j <n;j++) {
                    if(mat[j][i].equals("+-1")){
                       cont++;
                       if(cont==1){
                           sumc=0;
                       }else{
                           break;
                       }
                    }else{
                        sumc=(int)(sumc+Integer.parseInt(mat[j][i]));
                    }
                }
                gradoI[i]=sumc;
                //System.out.println("La suma de la columa   "+(i+1)+" es: " + gradoI[i]);
        } 
         
        for(int a=0;a<m;a++){
                if(gradoI[a]==0)
                    elemA++;
        }
         if(elemA==(m)){
             consideracion1="La matriz  corresponde  a  una  matriz de  incidencia \npara grafos   dirigidos.";
             consideracion2=ConsideracionesD.gradoEI(mat, n, m);
             total=consideracion1+consideracion2;
         }else {
             consideracion1="La matriz no corresponde  a  una  matriz de  incidencia \npara grafos   dirigidos.";
             total=consideracion1;
         }
         return total;
    }
    public MatrizIncidenciaDirigido(){
        matriz=new JTextField[pregunta][pregunta2];
        etiqueta1=new JLabel[pregunta2];
        etiqueta2=new JLabel[pregunta];
        JLabel jLabel1 = new javax.swing.JLabel();
        jLabel1.setText("Para representar un bucle ingrese  +-1");
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13));
        contenedor=getContentPane();
        contenedor.setLayout(null);
        mayor=new JTextArea();
        scrollpanemayor=new JScrollPane(mayor);
        scrollpanemayor.setBounds(0,0,789,660);
        scrollpanemayor.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollpanemayor.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        mayor.setBackground(Color.darkGray);
        
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addContainerGap(320, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(275, Short.MAX_VALUE))
        );
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
         
                int p=matriz[pregunta-1][pregunta-1].getX();
                int w=matriz[pregunta-1][pregunta-1].getY();
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
                setTitle("Matriz de incidencia para grafos dirigidos");
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
            }while(ban==false);
         return valor;
    }
    @Override
    public void actionPerformed(ActionEvent evento){
       int bandera=0;
       if(evento.getSource()==aceptar){
             String adyacencia[][]=new String[pregunta][pregunta2];
                   
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
                                 if((matriz[i][j].getText()).contains("1")||(matriz[i][j].getText()).contains("-1")||(matriz[i][j].getText()).contains("0")||(matriz[i][j].getText()).contains("+-1")){   
                                        adyacencia[i][j]=matriz[i][j].getText();
                                    }else
                                         throw new Exception("Solo se aceptan 1,0,-1,+-1");
                            }
                            
                                        String resultado=consideraciones(adyacencia);
                                        mensaje.setText(resultado);
                        }            
                   }catch(Exception e){
                              for (int k=0;k<pregunta;k++)
                                  for(int l=0;l<pregunta2;l++)
                                       adyacencia[k][l]="0";
                                       JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                                       matriz[0][0].grabFocus();
                     }
                  
         }
       }

                               
}