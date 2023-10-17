/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package codigo;

import compilerTools.Token;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andrea
 */
public class PrincipalCom extends javax.swing.JFrame {

    private ArrayList<Token> tokens;
    int valorAnterior = 1;
    int variable = 1;
    int renglones = 0, columnas = 0, penultimo = 0;
    java.util.Stack<String> pila = new java.util.Stack<String>();
    Boolean banP = true; //Bandera para ver si ya se inicio la Pila
    private DefaultTableModel modeloTabla;
    
    NumeroLinea numerolinea;

    public PrincipalCom() {
        
        initComponents();
        tokens = new ArrayList<>();
        inicializar();

    }
    
    private void inicializar()
    {
        numerolinea = new NumeroLinea(compilador);
        jScrollPane1.setRowHeaderView(numerolinea);
        
    }

    String encabezadosRenglones[] = {"I0", "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10", "I11", "I12", "I13", "I14", "I15", "I16", "I17", "I18", "I19", "I20", "I21", "I22", "I23", "I24", "I25", "I26", "I27", "I28", "I29", "I30", "I31", "I32", "I33", "I34", "I35", "I36", "I37"};
    String encabezadosColumnas[] = {"id", "num", "int", "float", "char", ",", ";", "+", "-", "*", "/", "(", ")", "=", "$", "P", "Tipo", "V", "A", "S", "E", "T", "F"};
    String matriz[][] = {
        //    "id" 0,         "num" 1,   "int" 2,    "float" 3,  "char" 4,   "," 5,      ";" 6,      "+" 7,          "-" 8,          "*" 9,          "/" 10,     "(" 11,     ")" 12,     "=" 13,     "$" 14,         "P" 15,     "Tipo" 16,    "V" 17,     "A" 18,      "S" 19,     "E" 20,     "T" 21,     "F" 22
        /*I0*/{"I7", "0", "I4", "I5", "I6", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I1", "I2", "0", "I3", "0", "0", "0", "0"},
        /*I1*/ {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "ACEPTA", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I2*/ {"I8", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I3*/ {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "P2", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I4*/ {"P3", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I5*/ {"P4", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I6*/ {"P5", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I7*/ {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I9", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I8*/ {"0", "0", "0", "0", "0", "I11", "I12", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I10", "0", "0", "0", "0", "0"},
        /*I9*/ {"I20", "I21", "0", "0", "0", "0", "0", "I14", "I15", "0", "0", "I19", "0", "0", "0", "0", "0", "0", "0", "I13", "I16", "I17", "I18"},
        /*I10*/ {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "P1", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I11*/ {"I22", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I12*/ {"I7", "0", "I4", "I5", "I6", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I23", "I2", "0", "I3", "0", "0", "0", "0"},
        /*I13*/ {"0", "0", "0", "0", "0", "0", "I24", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I14*/ {"I20", "I21", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I19", "0", "0", "0", "0", "0", "0", "0", "0", "I25", "I17", "I18"},
        /*I15*/ {"I20", "I21", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I19", "0", "0", "0", "0", "0", "0", "0", "0", "I26", "I17", "I18"},
        /*I16*/ {"0", "0", "0", "0", "0", "0", "P11", "I27", "I28", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I17*/ {"0", "0", "0", "0", "0", "0", "P14", "P14", "P14", "I29", "I30", "0", "P14", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I18*/ {"0", "0", "0", "0", "0", "0", "P17", "P17", "P17", "P17", "P17", "0", "P17", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I19*/ {"I20", "I21", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I19", "0", "0", "0", "0", "0", "0", "0", "0", "I31", "I17", "I18"},
        /*I20*/ {"0", "0", "0", "0", "0", "0", "P19", "P19", "P19", "P19", "P19", "0", "P19", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I21*/ {"0", "0", "0", "0", "0", "0", "P20", "P20", "P20", "P20", "P20", "0", "P20", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I22*/ {"0", "0", "0", "0", "0", "I11", "I12", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I32", "0", "0", "0", "0", "0"},
        /*I23*/ {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "P7", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I24*/ {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "P8", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I25*/ {"0", "0", "0", "0", "0", "0", "P9", "I27", "I28", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I26*/ {"0", "0", "0", "0", "0", "0", "P10", "I27", "I28", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I27*/ {"I20", "I21", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I19", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I33", "I18"},
        /*I28*/ {"I20", "I21", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I19", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I34", "I18"},
        /*I29*/ {"I20", "I21", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I19", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I35"},
        /*I30*/ {"I20", "I21", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I19", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "I36"},
        /*I31*/ {"0", "0", "0", "0", "0", "0", "0", "I27", "I28", "0", "0", "0", "I37", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I32*/ {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "P6", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I33*/ {"0", "0", "0", "0", "0", "0", "P12", "P12", "P12", "I29", "I30", "0", "P12", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I34*/ {"0", "0", "0", "0", "0", "0", "P13", "P13", "P13", "I29", "I30", "0", "P13", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I35*/ {"0", "0", "0", "0", "0", "0", "P15", "P15", "P15", "P15", "P15", "0", "P15", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I36*/ {"0", "0", "0", "0", "0", "0", "P16", "P16", "P16", "P16", "P16", "0", "P16", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        /*I37*/ {"0", "0", "0", "0", "0", "0", "P18", "P18", "P18", "P18", "P18", "0", "P18", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}};

    private void analisisLexico() {
        Lexer lexer = null;
        try {
            File sourceCodeFile = new File("code.encrypter");

            FileOutputStream fileOutputStream = new FileOutputStream(sourceCodeFile);
            byte[] bytesOfText = compilador.getText().getBytes();

            fileOutputStream.write(bytesOfText);

            BufferedReader fileInputReader = new BufferedReader(new InputStreamReader(new FileInputStream(sourceCodeFile), "UTF8"));

            lexer = new Lexer(fileInputReader);

            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }

                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
    }

    private void analisisLexicoEerr() {

        for (int i = 0; i < tokens.size(); i++) {

            if ("ERROR".equals(tokens.get(i).getLexicalComp())) {

                String errorMsg = "Error Lexico linea " + tokens.get(i).getLine() + ": token [ " + tokens.get(i).getLexeme() + " ] ";
                if (tokens.get(i).getLexeme().matches("pAto")) {
                    errorMsg += "se esperaba comilla doble de cierre ";

                } else {
                    errorMsg += "no es valido ";

                }

                errorMsg += "[" + tokens.get(i).getLine() + ", " + tokens.get(i).getColumn() + "]\n";

                mensajes.setText(mensajes.getText() + errorMsg);
            }

        }
    }

    public void AnalisisSintacticoInicioPila() {

        if (banP) {

            pila.push("$");
            pila.push("IO");
            modeloTabla = new DefaultTableModel();
            modeloTabla.addColumn("Entrada");
            modeloTabla.addColumn("Pila");
            modeloTabla.addColumn("Accion");
            jTable1.setModel(modeloTabla);

            System.out.println(pila);

        }

    }
    String Produciones[][] = {
        /*P0*/{"P'", "P"},
        /*P1*/ {"P", "Tipo id V"},
        /*P2*/ {"P", "A"},
        /*P3*/ {"Tipo", "int"},
        /*P4*/ {"Tipo", "float"},
        /*P5*/ {"Tipo", "char"},
        /*P6*/ {"V", ", id V"},
        /*P7*/ {"V", "; P"},
        /*P8*/ {"A", "id = S ;"},
        /*P9*/ {"S", "+ E"},
        /*P10*/ {"S", "- E"},
        /*P11*/ {"S", "E"},
        /*P12*/ {"E", "E + T"},
        /*P13*/ {"E", "E - T"},
        /*P14*/ {"E", "T"},
        /*P15*/ {"T", "T * F"},
        /*P16*/ {"T", "T / F"},
        /*P17*/ {"T", "F"},
        /*P18*/ {"F", "( E )"},
        /*P19*/ {"F", "id"},
        /*P20*/ {"F", "num"},};

    public void AnalisisSintactico(String token, int linea, String caracter) {

        String accion;
        accion = matriz[Renglon()][Columna(token)];
        penultimo = 0;

        if (accion.startsWith("I")) {
            modeloTabla.addRow(new Object[]{token, pila.toString(), " Desplaza " + token + " " + accion});
            pila.push(token);
            pila.push(accion);

         

        } else if (accion.startsWith("P")) {

            int NumeroProduccion = obtenerUltimoDigitoEntero(accion);
          
            String produce = Produciones[NumeroProduccion][1];
          

            modeloTabla.addRow(new Object[]{token, pila.toString(),  accion + "  " + Produciones[NumeroProduccion][0] + " --> " + Produciones[NumeroProduccion][1]});

            while (!pila.isEmpty()) {
                String elemento = pila.pop();
                if (elemento.equals(obtenerParteAntesDelEspacio(Produciones[NumeroProduccion][1]))) {
                    break;
                }
            }

            pila.push(Produciones[NumeroProduccion][0]);

            String elementoPenultimo = pila.get(pila.size() - 2);

            accion = matriz[penultimo()][Columna(pila.peek())];
          
       
            pila.push(accion);
          
            this.AnalisisSintactico(token, linea, caracter);
        } else if (accion == "ACEPTA") {

            mensajes.setText(mensajes.getText() + "Se acepta");
            modeloTabla.addRow(new Object[]{token, pila.toString(), accion});
            mensajes.setText(mensajes.getText() + "\nAnalisis terminado Correctamente...");

        } else if (accion == "0") {

            mensajes.setText(mensajes.getText() + "[ERROR] linea " + linea + ". Se encontro un token inesperado :" + token + "\n");

        }

    }

    public static String obtenerParteAntesDelEspacio(String cadena) {

        String[] palabras = cadena.split(" ");

        if (palabras.length > 0) {
            return palabras[0];
        } else {

            return cadena;
        }
    }

    public static int obtenerUltimoDigitoEntero(String cadena) {
        String digitos = "";

        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (Character.isDigit(caracter)) {
                digitos += caracter;
            }
        }

        if (digitos.isEmpty()) {
            throw new IllegalArgumentException("La cadena no contiene dígitos.");
        }

        return Integer.parseInt(digitos);
    }

    public int Renglon() {
        for (int i = 0; i < encabezadosRenglones.length; i++) {
            if (encabezadosRenglones[i].equals(pila.peek())) {
                renglones = i;
                break;
            }
        }
        return renglones;
    }

    public int penultimo() {
        for (int i = 0; i < encabezadosRenglones.length; i++) {
            if (encabezadosRenglones[i].equals(pila.get(pila.size() - 2))) {
                penultimo = i;
                break;
            }
        }
        return penultimo;
    }

    public int Columna(String token) {
        for (int i = 0; i < encabezadosColumnas.length; i++) {
            if (token.equals(encabezadosColumnas[i])) {
                columnas = i;
                break;
            }
        }
        return columnas;
    }

    private void llenarPila() {
        tokens.forEach(token -> {

            variable = token.getLine();

            if (token.getLexicalComp() == "tipoDa") {

                AnalisisSintactico(token.getLexeme(), token.getLine(), token.getLexeme());
            } else if (token.getLexicalComp() == "ERROR") {

            } else {

                AnalisisSintactico(token.getLexicalComp(), token.getLine(), token.getLexeme());
            }

        });

        AnalisisSintactico("$", 1, "");

    }

    private void llenarLexicoDeRokens() {
        tokens.forEach(token -> {

            variable = token.getLine();

            if (variable != valorAnterior) {
                lexico.setText(lexico.getText() + "\n");
                valorAnterior = token.getLine();
            }

            if (token.getLexicalComp() == "tipoDa") {

                lexico.setText(lexico.getText() + " " + token.getLexeme());
            } else if (token.getLexicalComp() == "ERROR") {
                lexico.setText(lexico.getText() + " ");
            } else {

                lexico.setText(lexico.getText() + " " + token.getLexicalComp());
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        mensajes = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        compilador = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        lexico = new javax.swing.JTextPane();
        btnCompilar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 105, 180));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Analizador de la Gramática LR");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 105, 180));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 224, 255));

        mensajes.setBackground(new java.awt.Color(255, 224, 255));
        jScrollPane4.setViewportView(mensajes);

        jTabbedPane1.addTab("Error", jScrollPane4);

        jScrollPane5.setBackground(new java.awt.Color(255, 224, 255));

        jTable1.setBackground(new java.awt.Color(255, 224, 255));
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
        jScrollPane5.setViewportView(jTable1);

        jTabbedPane1.addTab("Pila", jScrollPane5);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 570, 860, 200));

        compilador.setBackground(new java.awt.Color(255, 224, 255));
        jScrollPane1.setViewportView(compilador);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 860, 190));

        lexico.setBackground(new java.awt.Color(255, 224, 255));
        jScrollPane2.setViewportView(lexico);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 860, 170));

        btnCompilar.setBackground(new java.awt.Color(255, 224, 255));
        btnCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_code_48px.png"))); // NOI18N
        btnCompilar.setText("Compilar");
        btnCompilar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnCompilar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCompilar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_code_48px_p.png"))); // NOI18N
        btnCompilar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_code_48px_on.png"))); // NOI18N
        btnCompilar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCompilar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, 80, 80));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Entrada");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Léxico");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 780));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        pila.clear();
        renglones = 0;
        columnas = 0;
        penultimo = 0;

        if (compilador.getText().isEmpty()) {
            borrarComponentes();
            mensajes.setText("No hay nada que analizar");

        } else {
            borrarComponentes();
            analisisLexico();
            llenarLexicoDeRokens();
            analisisLexicoEerr();
            lexico.setText(lexico.getText());
            AnalisisSintacticoInicioPila();
            llenarPila();
        }
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void borrarComponentes() {
        tokens.clear();
        lexico.setText("");
        mensajes.setText("");
        tokens.clear();
        valorAnterior = 1;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalCom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalCom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalCom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalCom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalCom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompilar;
    private javax.swing.JTextPane compilador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane lexico;
    private javax.swing.JTextPane mensajes;
    // End of variables declaration//GEN-END:variables
}
