package codigo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrea
 */
public class Interfaz extends javax.swing.JFrame {

    java.util.Stack<String> pilaSintactica = new java.util.Stack<String>();

    public Interfaz() {
        initComponents();
        inicializar();
    }

    private void inicializar() {
        numerolinea = new NumeroLinea(jTextArea2);
        jScrollPane2.setRowHeaderView(numerolinea);
    }

    NumeroLinea numerolinea;
    int Renglon = 0;
    int Columna = 0;
    int ProducionInice = 0;
    int penultimo = 0;
    String accion;
    int numeroLinea = 1;
    private DefaultTableModel Tabla;
    boolean banDetener = true;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setBackground(new java.awt.Color(213, 237, 249));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setBackground(new java.awt.Color(213, 237, 249));
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/programacion.png"))); // NOI18N
        jButton1.setText("Analizar");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/programacion (1).png"))); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setBackground(new java.awt.Color(213, 237, 249));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Entrada", "Pila", "Acción"
            }
        ));
        jScrollPane4.setViewportView(jTable2);

        jTextArea3.setEditable(false);
        jTextArea3.setBackground(new java.awt.Color(213, 237, 249));
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane5.setViewportView(jTextArea3);

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/boton-eliminar.png"))); // NOI18N
        jButton2.setText("Borrar");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/boton-eliminar (1).png"))); // NOI18N
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Errores");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5)
                            .addComponent(jScrollPane4)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(23, 23, 23)))))
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    String Renglones[] = {"I0", "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10", "I11", "I12", "I13", "I14", "I15", "I16", "I17", "I18", "I19", "I20", "I21", "I22", "I23", "I24", "I25", "I26", "I27", "I28", "I29", "I30", "I31", "I32", "I33", "I34", "I35", "I36", "I37"};
    String Columnas[] = {"id", "num", "int", "float", "char", ",", ";", "+", "-", "*", "/", "(", ")", "=", "$", "P", "Tipo", "V", "A", "S", "E", "T", "F"};
    String matrizSintactica[][] = {
        {"I7", "0", "I4", "I5", "I6", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I1", "I2", "0", "I3", "0", "0", "0", "0"},
        {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "ACEPTA", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"I8", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "P2", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"P3", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"P4", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"P5", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I9", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"0", "0", "0", "0", "0", "I11", "I12", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I10", "0", "0", "0", "0", "0"},
        {"I20", "I21", "0", "0", "0", "0", "0", "I14", "I15", "0", "0", "I19", "0", "0", "0", "0", "0", "0", "0", "I13", "I16", "I17", "I18"},
        {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "P1", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"I22", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"I7", "0", "I4", "I5", "I6", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I23", "I2", "0", "I3", "0", "0", "0", "0"},
        {"0", "0", "0", "0", "0", "0", "I24", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"I20", "I21", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I19", "0", "0", "0", "0", "0", "0", "0", "0", "I25", "I17", "I18"},
        {"I20", "I21", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I19", "0", "0", "0", "0", "0", "0", "0", "0", "I26", "I17", "I18"},
        {"0", "0", "0", "0", "0", "0", "P11", "I27", "I28", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"0", "0", "0", "0", "0", "0", "P14", "P14", "P14", "I29", "I30", "0", "P14", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"0", "0", "0", "0", "0", "0", "P17", "P17", "P17", "P17", "P17", "0", "P17", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"I20", "I21", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I19", "0", "0", "0", "0", "0", "0", "0", "0", "I31", "I17", "I18"},
        {"0", "0", "0", "0", "0", "0", "P19", "P19", "P19", "P19", "P19", "0", "P19", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"0", "0", "0", "0", "0", "0", "P20", "P20", "P20", "P20", "P20", "0", "P20", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"0", "0", "0", "0", "0", "I11", "I12", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I32", "0", "0", "0", "0", "0"},
        {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "P7", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "P8", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"0", "0", "0", "0", "0", "0", "P9", "I27", "I28", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"0", "0", "0", "0", "0", "0", "P10", "I27", "I28", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"I20", "I21", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I19", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I33", "I18"},
        {"I20", "I21", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I19", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I34", "I18"},
        {"I20", "I21", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I19", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I35"},
        {"I20", "I21", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I19", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I36"},
        {"0", "0", "0", "0", "0", "0", "0", "I27", "I28", "0", "0", "0", "I37", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "P6", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"0", "0", "0", "0", "0", "0", "P12", "P12", "P12", "I29", "I30", "0", "P12", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"0", "0", "0", "0", "0", "0", "P13", "P13", "P13", "I29", "I30", "0", "P13", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"0", "0", "0", "0", "0", "0", "P15", "P15", "P15", "P15", "P15", "0", "P15", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"0", "0", "0", "0", "0", "0", "P16", "P16", "P16", "P16", "P16", "0", "P16", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        {"0", "0", "0", "0", "0", "0", "P18", "P18", "P18", "P18", "P18", "0", "P18", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}};

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTextArea1.setText("");
        File fichero = new File("codigo.txt");
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(fichero));
            writer.write(jTextArea2.getText());
            writer.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar archivo de entrada debido a " + ex.toString());
            System.out.println("Compilador.Interfaz.jButton1ActionPerformed()");
        }
        try {

            BorrarComponentes();
            TablaPila();
            AnalisisLexico();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Tabla.setRowCount(0);
        jTextArea2.setText("");
        BorrarComponentes();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void AnalisisLexico() throws IOException {
        // Abre el archivo "codigo.txt" para lectura
        Reader reader = new BufferedReader(new FileReader("codigo.txt"));

        // Crea un objeto Lexer para analizar el archivo
        Lexer lexer = new Lexer(reader);

        // Bucle infinito para analizar los tokens
        while (true) {
            // Obtiene el siguiente token del Lexer
            Token token = lexer.yylex();

            // Si no hay más tokens, realiza un análisis sintáctico final y sale del bucle
            if (token == null) {
                AnalisisSintactico("$", numeroLinea);
                return;
            }

            // Evalúa el tipo de token y realiza acciones específicas en consecuencia
            switch (token) {
                case salto:
                    // Agrega un salto de línea en jTextArea1 y actualiza el número de línea
                    jTextArea1.setText(jTextArea1.getText() + "\n");
                    numeroLinea = numeroLinea + 1;
                    break;
                case reservada:
                case coma:
                case finSentencia:
                case aritmetico:
                case agrupacion:
                case asignacion:
                    // Agrega el lexema del token seguido de un espacio en jTextArea1
                    // y realiza un análisis sintáctico con el lexema y la línea actual
                    jTextArea1.setText(jTextArea1.getText() + lexer.lexeme + " ");
                    AnalisisSintactico(lexer.lexeme, numeroLinea);
                    break;
                case ERROR:
                    // Agrega un mensaje de error léxico en jTextArea3 indicando la línea y el token no reconocido
                    jTextArea3.setText(jTextArea3.getText() + "ERROR Lexico linea " + numeroLinea + " token " + lexer.lexeme + " no reconocido \n");
                    break;
                default:
                    // Agrega el valor del token (que no es uno de los casos anteriores) en jTextArea1
                    // y realiza un análisis sintáctico con el valor del token convertido a cadena y la línea actual
                    jTextArea1.setText(jTextArea1.getText() + token + " ");
                    AnalisisSintactico(token + "", numeroLinea);
            }
        }
    }

    public void BorrarComponentes() {
        // Esta función se encarga de borrar o restablecer varios componentes
        // de la interfaz de usuario y variables de control.

        banDetener = true; // Establece la variable 'banDetener' en 'true'.
        numeroLinea = 1;  // Restablece la variable 'numeroLinea' a 1.
        pilaSintactica.clear(); // Limpia (borra) el contenido de la lista 'pilaSintactica'.
        Renglon = 0;  // Restablece la variable 'Renglon' a 0.
        Columna = 0;  // Restablece la variable 'Columna' a 0.
        penultimo = 0;  // Restablece la variable 'penultimo' a 0.
        jTextArea1.setText("");  // Borra el texto en el componente 'jTextArea1'.
        jTextArea3.setText("");  // Borra el texto en el componente 'jTextArea3'.
    }

    public void TablaPila() {
        // Esta función se utiliza para inicializar una tabla y una pila sintáctica
        // en la interfaz de usuario.

        pilaSintactica.push("$");  // Agrega el símbolo '$' a la pila sintáctica.
        pilaSintactica.push("IO");  // Agrega el símbolo 'IO' a la pila sintáctica.
        Tabla = new DefaultTableModel();  // Crea una nueva instancia de DefaultTableModel.
        Tabla.addColumn("Entrada");  // Agrega una columna llamada "Entrada" a la tabla.
        Tabla.addColumn("Pila");  // Agrega una columna llamada "Pila" a la tabla.
        Tabla.addColumn("Accion");  // Agrega una columna llamada "Accion" a la tabla.
        jTable2.setModel(Tabla);  // Establece el modelo de datos de 'jTable2' con la tabla 'Tabla'.
    }

    String NumProduccion[] = {"P0", "P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8", "P9", "P10", "P11", "P12", "P13", "P14", "P15", "P16", "P17", "P18", "P19", "P20"};
    String ProducionDerecha[] = {"P'", "P", "P", "Tipo", "Tipo", "Tipo", "V", "V", "A", "S", "S", "S", "E", "E", "E", "T", "T", "T", "F", "F", "F"};
    String ProducionIzquierda[] = {"ACEPTA", "Tipo id V", "A", "int", "float", "char", ", id V", "; P", "id = S ;", "+ E", "- E", "E", "E + T", "E - T", "T", "T * F", "T / F", "F", "( E )", "id", "num"};
    int NumPops[] = {2, 6, 2, 2, 2, 2, 6, 4, 8, 4, 4, 2, 6, 6, 2, 6, 6, 2, 6, 2, 2};

    public void AnalisisSintactico(String Token, int numLin) {
        // Método para realizar el análisis sintáctico a partir de un token y número de línea.

        if (banDetener) {
            // Si la variable banDetener es verdadera, continuamos con el análisis.

            penultimo = 0;

            accion = matrizSintactica[Renglon()][Columna(Token)];
            // Obtenemos una acción basada en la matriz sintáctica y la posición actual.

            if (accion.startsWith("I")) {
                // Si la acción comienza con "I" (para desplazar),

                Tabla.addRow(new Object[]{Token, pilaSintactica.toString(), " Desplaza " + Token + " a " + accion});
                // Agregamos una fila a la tabla con información de la acción.

                pilaSintactica.push(Token);
                pilaSintactica.push(accion);
                // Colocamos el token y la acción en la pila sintáctica.

            } else if (accion.startsWith("P")) {
                // Si la acción comienza con "P" (para producir),

                int numIniceProduccion = ColumnaPops(accion);
                // Obtenemos el número de producción a partir de la acción.

                Tabla.addRow(new Object[]{Token, pilaSintactica.toString(), " Produccion " + NumProduccion[numIniceProduccion] + " = " + ProducionDerecha[numIniceProduccion] + "->" + ProducionIzquierda[numIniceProduccion]});
                // Agregamos una fila a la tabla con información de la producción.

                for (int i = 0; i < NumPops[numIniceProduccion]; i++) {
                    pilaSintactica.pop();
                }
                // Realizamos las operaciones "pop" en la pila sintáctica.

                pilaSintactica.push(ProducionDerecha[numIniceProduccion]);
                // Colocamos el lado derecho de la producción en la pila sintáctica.

                accion = matrizSintactica[penultimo()][Columna(pilaSintactica.peek())];
                // Calculamos la próxima acción basada en la pila sintáctica.

                pilaSintactica.push(accion);

                AnalisisSintactico(Token, numLin);
                // Llamamos recursivamente al método para continuar el análisis.

            } else if (accion == "ACEPTA") {
                // Si la acción es "ACEPTA",

                jTextArea3.setText(jTextArea3.getText() + "Se acepta");
                // Actualizamos el texto en jTextArea3.

                Tabla.addRow(new Object[]{Token, pilaSintactica.toString(), accion});
                // Agregamos una fila a la tabla con información de la acción.

            } else if (accion == "0") {
                // Si la acción es "0" (indicando un error),

                jTextArea3.setText(jTextArea3.getText() + "ERROR linea " + numLin + ": Se encontró un token inesperado :" + Token + "\n");
                // Mostramos un mensaje de error en jTextArea3.

                accion = matrizSintactica[Renglon()][Columna(Token)];

                String SeEsperaba = "";
                // Inicializamos una cadena para almacenar lo que se esperaba.

                for (int i = 0; i < 23; i++) {
                    accion = matrizSintactica[CadenaAEntero(pilaSintactica.peek())][i];

                    if (!accion.equals("0")) {
                        // Si la acción no es "0",

                        switch (Columnas[i]) {
                            // Realizamos un switch para determinar qué se esperaba en base a las columnas de la matriz.

                            case "S":
                                SeEsperaba = SeEsperaba + "+ - id num ";
                                break;
                            case "E":
                                SeEsperaba = SeEsperaba + "( id num ";
                                break;
                            case "T":
                                SeEsperaba = SeEsperaba + "( id num ";
                                break;
                            case "F":
                                SeEsperaba = SeEsperaba + "( id num ";
                                break;
                            case "V":
                                SeEsperaba = SeEsperaba + ", ; ";
                                break;
                            case "A":
                                SeEsperaba = SeEsperaba + "id ";
                                break;
                            case "P":
                                SeEsperaba = SeEsperaba + "int float char id ";
                                break;
                            default:
                                SeEsperaba = SeEsperaba + Columnas[i] + " ";
                        }
                    }
                }

                jTextArea3.setText(jTextArea3.getText() + "ERROR linea " + numLin + ": Se esperaba  ->    " + eliminarElementosRepetidosEnSeEsperaba(SeEsperaba) + "\n");
                // Mostramos un mensaje de error con lo que se esperaba en jTextArea3.

                banDetener = false;
                // Desactivamos la bandera banDetener para detener el análisis.
            }
        }
    }

    public static String eliminarElementosRepetidosEnSeEsperaba(String input) {
        // Divide la cadena en elementos individuales
        String[] elementos = input.split(" ");

        // Utiliza un conjunto (LinkedHashSet) para eliminar elementos duplicados
        LinkedHashSet<String> set = new LinkedHashSet<>(Arrays.asList(elementos));

        // Convierte el conjunto nuevamente a un arreglo
        String[] elementosUnicos = set.toArray(new String[0]);

        // Une los elementos únicos en una cadena separados por espacios
        String resultado = String.join(" ", elementosUnicos);

        return resultado;
    }

    public void noDuplicadosTxtMensaje() {

        // Divide el texto en jTextArea3 en líneas individuales y almacena cada línea en un arreglo de strings.
        String[] lines = jTextArea3.getText().split("\n");

        // Crea un conjunto (Set) llamado 'set' que utiliza LinkedHashSet para mantener un conjunto de líneas sin duplicados.
        Set<String> set = new LinkedHashSet<String>(Arrays.asList(lines));

        // Convierte las líneas únicas nuevamente en un solo texto, uniendo los elementos del conjunto con saltos de línea.
        String noDuplicateText = String.join("\n", set);

        // Establece el texto en el componente jTextArea3 para mostrar el texto sin duplicados.
        jTextArea3.setText(noDuplicateText);
    }

    public static int CadenaAEntero(String cadena) {
        // Inicializa una cadena vacía 'digitos' para almacenar los dígitos encontrados en la cadena de entrada.
        String digitos = "";

        // Itera a través de cada carácter en la cadena de entrada 'cadena'.
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);

            // Verifica si el carácter es un dígito numérico.
            if (Character.isDigit(caracter)) {
                // Si es un dígito, agrega el carácter a la cadena 'digitos'.
                digitos += caracter;
            }
        }

        // Si no se encontraron dígitos en la cadena, se lanza una excepción.
        if (digitos.isEmpty()) {
            throw new IllegalArgumentException("La cadena no contiene dígitos.");
        }

        // Convierte la cadena 'digitos' en un entero y lo devuelve.
        return Integer.parseInt(digitos);
    }

    // Método que busca la posición de la cima de la pila dentro de Renglones y devuelve su posición
    public int Renglon() {
        for (int i = 0; i < Renglones.length; i++) { // Recorre el arreglo Renglones
            if (Renglones[i].equals(pilaSintactica.peek())) { // Compara el elemento en la posición 'i' de Renglones con el elemento en la cima de la pilaSintactica
                Renglon = i; // Asigna el valor de 'i' a la variable Renglon
                break; // Sale del bucle una vez que se encuentra una coincidencia
            }
        }
        return Renglon; // Devuelve la posición de la cima de la pila en el arreglo Renglones
    }

    public int penultimo() {
        for (int i = 0; i < Renglones.length; i++) { // Recorre el arreglo Renglones
            if (Renglones[i].equals(pilaSintactica.get(pilaSintactica.size() - 2))) { // Compara el elemento en la posición 'i' de Renglones con el penúltimo elemento de la pilaSintactica
                penultimo = i; // Asigna el valor de 'i' a la variable penúltimo
                break; // Sale del bucle una vez que se encuentra una coincidencia
            }
        }
        return penultimo; // Devuelve la posición del penúltimo elemento de la pila en el arreglo Renglones
    }

// Método que busca la posición del token dentro de encabezadosColumnas y devuelve su posición
    public int Columna(String token) {
        for (int i = 0; i < Columnas.length; i++) { // Recorre el arreglo Columnas
            if (token.equals(Columnas[i])) { // Compara el token con el elemento en la posición 'i' de Columnas
                Columna = i; // Asigna el valor de 'i' a la variable Columna
                break; // Sale del bucle una vez que se encuentra una coincidencia
            }
        }
        return Columna; // Devuelve la posición del token en el arreglo Columnas
    }

// Método que busca la posición del token dentro de NumProduccion y devuelve su posición
    public int ColumnaPops(String accionProduccion) {
        for (int i = 0; i < NumProduccion.length; i++) { // Recorre el arreglo NumProduccion
            if (accionProduccion.equals(NumProduccion[i])) { // Compara accionProduccion con el elemento en la posición 'i' de NumProduccion
                ProducionInice = i; // Asigna el valor de 'i' a la variable ProducionInice
                break; // Sale del bucle una vez que se encuentra una coincidencia
            }
        }
        return ProducionInice; // Devuelve la posición del token en el arreglo NumProduccion
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    // End of variables declaration//GEN-END:variables
}
