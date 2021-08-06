/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1lenguajesformales;

/**
 *
 * @author yefri
 */
public class VentanaFrame extends javax.swing.JFrame {

    /**
     * Creates new form VentanaFrame
     */
    public VentanaFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        EscribirTextojTextArea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        AnalizadorTextojTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador Lexico");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EscribirTextojTextArea.setColumns(20);
        EscribirTextojTextArea.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        EscribirTextojTextArea.setRows(5);
        jScrollPane1.setViewportView(EscribirTextojTextArea);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 370, 360));

        jButton1.setText("Verificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 160, 60));

        AnalizadorTextojTextArea.setColumns(20);
        AnalizadorTextojTextArea.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        AnalizadorTextojTextArea.setLineWrap(true);
        AnalizadorTextojTextArea.setRows(5);
        jScrollPane.setViewportView(AnalizadorTextojTextArea);

        jPanel1.add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 330, 360));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Area para Ingresar Texto: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 32, 300, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Texto Verificado: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo1 .jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private String textoIngresado;
    private static String palabra = "";
    private static String numeroDecimal = "";
    private static String error = "";

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        textoIngresado = EscribirTextojTextArea.getText();
        for (int i = 0; i < textoIngresado.length(); i++) {
            if (!Character.isSpaceChar(textoIngresado.charAt(i))) {
                palabra+=textoIngresado.charAt(i);
            }else {
                //verificarPalabras(palabra);
                verificarPalabras2(palabra);
                palabra="";
                limpiarCampos();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void verificarPalabras(String palabra){
        if(palabra.matches("([a-z]|[A-Z])+.[0-9]*") | palabra.matches("([a-z]|[A-Z])+") ){
            Texto texto=new Texto(palabra,TipoDeTexto.ID);
            AnalizadorTextojTextArea.append("Id: "+texto.getPalabra()+ "\n");
        } else if (palabra.matches("[0-9]+")){
            Texto texto=new Texto(palabra,TipoDeTexto.NUMERO_ENTERO);
            AnalizadorTextojTextArea.append("Entero: "+texto.getPalabra()+"\n");
        } else if (palabra.matches("[0-9]+.[.].[0-9]")){
            Texto texto=new Texto(palabra,TipoDeTexto.NUMERO_DECIMAL);
            AnalizadorTextojTextArea.append("Decimal: "+texto.getPalabra()+"\n");
        } else if (palabra.matches("[:,;'+-@#~½%=/]")){
            Texto texto=new Texto(palabra,TipoDeTexto.CARACTER);
            AnalizadorTextojTextArea.append("Simbolo: "+texto.getPalabra()+"\n");
        } else {
            Texto texto=new Texto(palabra,TipoDeTexto.ERROR);
            AnalizadorTextojTextArea.append("Error: "+texto.getPalabra()+"\n");
        }
    }
    public void verificarPalabras2(String Palabra){
        boolean tieneLetra=false;
        for (int i = 0; i <palabra.length()&& !tieneLetra; i++) {
            if(Character.isLetter(palabra.charAt(i))){
                tieneLetra=true;
            } else {
                tieneLetra=false;
            }
        }
        if (Character.isDigit(palabra.charAt(0)) && tieneLetra==false && palabra.contains(".") && (palabra.contains("1") | palabra.contains("2") | palabra.contains("3") | palabra.contains("4") | palabra.contains("5") | palabra.contains("6") | palabra.contains("7") | palabra.contains("8") | palabra.contains("9") | palabra.contains("0"))) {
            Texto texto=new Texto(palabra,TipoDeTexto.NUMERO_DECIMAL);
            AnalizadorTextojTextArea.append("Decimal: "+texto.getPalabra()+"\n");
        } else if (palabra.contains("(")|palabra.contains(")") |palabra.contains(";") |palabra.contains(",")|palabra.contains("{")|palabra.contains("}") |palabra.contains("[") |palabra.contains("]") |palabra.contains("-")|palabra.contains("+")|palabra.contains("*")|palabra.contains("/")|palabra.contains("'")|palabra.contains("|")){
            Texto texto=new Texto(palabra,TipoDeTexto.CARACTER);
            AnalizadorTextojTextArea.append("Simbolo: "+texto.getPalabra()+"\n");
        } else if (Character.isLetter(palabra.charAt(0))){
            Texto texto=new Texto(palabra,TipoDeTexto.ID);
            AnalizadorTextojTextArea.append("Id: "+texto.getPalabra()+ "\n");
        } else if (Character.isDigit(palabra.charAt(0)) && tieneLetra==false && (palabra.contains("1") | palabra.contains("2") | palabra.contains("3") | palabra.contains("4") | palabra.contains("5") | palabra.contains("6") | palabra.contains("7") | palabra.contains("8") | palabra.contains("9") | palabra.contains("0"))){
            Texto texto=new Texto(palabra,TipoDeTexto.NUMERO_ENTERO);
            AnalizadorTextojTextArea.append("Entero: "+texto.getPalabra()+"\n");
        } else {
            Texto texto=new Texto(palabra,TipoDeTexto.ERROR);
            AnalizadorTextojTextArea.append("Error: "+texto.getPalabra()+"\n");
        }
    }
    
    public void limpiarCampos() {
        EscribirTextojTextArea.setText("");
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
            java.util.logging.Logger.getLogger(VentanaFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AnalizadorTextojTextArea;
    private javax.swing.JTextArea EscribirTextojTextArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
