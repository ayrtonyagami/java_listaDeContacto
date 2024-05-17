package visao;

import dao.ConexaoBaseDados;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import util.Perferencia;
import util.PosicaoFormulario;

public class Principal extends javax.swing.JFrame 
{
    
    PosicaoFormulario openForm;
    ResourceBundle messages = ResourceBundle.getBundle("messages", new Locale(Perferencia.Idioma));
    public Principal() 
    {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        openForm = new PosicaoFormulario();
        
        //Internationalizar();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktop = new javax.swing.JDesktopPane();
        jmbBarraMenu = new javax.swing.JMenuBar();
        jmbArquivo = new javax.swing.JMenu();
        jmCadastros = new javax.swing.JMenu();
        jimMunicipio = new javax.swing.JMenuItem();
        jmiBairro = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmiTipoContactos = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiContactos = new javax.swing.JMenuItem();
        jmbOpcoes = new javax.swing.JMenu();
        jmbIdiomas = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jmbSobre = new javax.swing.JMenu();
        jmbSobreItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda Contactos - Grupo D");
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout jDesktopLayout = new javax.swing.GroupLayout(jDesktop);
        jDesktop.setLayout(jDesktopLayout);
        jDesktopLayout.setHorizontalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jDesktopLayout.setVerticalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );

        jmbArquivo.setIcon(new javax.swing.ImageIcon("C:\\Users\\ayrton.antonio\\Documents\\NetBeansProjects\\AgeContactos\\src\\main\\java\\img\\arquivo.png")); // NOI18N
        jmbArquivo.setMnemonic('A');
        jmbArquivo.setText("Arquivo");

        jmCadastros.setIcon(new javax.swing.ImageIcon("C:\\Users\\ayrton.antonio\\Documents\\NetBeansProjects\\AgeContactos\\src\\main\\java\\img\\novo.png")); // NOI18N
        jmCadastros.setMnemonic('C');
        jmCadastros.setText("Cadastro");

        jimMunicipio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jimMunicipio.setIcon(new javax.swing.ImageIcon("C:\\Users\\ayrton.antonio\\Documents\\NetBeansProjects\\AgeContactos\\src\\main\\java\\img\\cidade.png")); // NOI18N
        jimMunicipio.setText("Municipio");
        jimMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jimMunicipioActionPerformed(evt);
            }
        });
        jmCadastros.add(jimMunicipio);

        jmiBairro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiBairro.setIcon(new javax.swing.ImageIcon("C:\\Users\\ayrton.antonio\\Documents\\NetBeansProjects\\AgeContactos\\src\\main\\java\\img\\bairro.png")); // NOI18N
        jmiBairro.setText("Bairro");
        jmiBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiBairroActionPerformed(evt);
            }
        });
        jmCadastros.add(jmiBairro);
        jmCadastros.add(jSeparator2);

        jmiTipoContactos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiTipoContactos.setIcon(new javax.swing.ImageIcon("C:\\Users\\ayrton.antonio\\Documents\\NetBeansProjects\\AgeContactos\\src\\main\\java\\img\\tipo.png")); // NOI18N
        jmiTipoContactos.setText("Tipo de Contactos");
        jmiTipoContactos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTipoContactosActionPerformed(evt);
            }
        });
        jmCadastros.add(jmiTipoContactos);

        jmbArquivo.add(jmCadastros);
        jmbArquivo.add(jSeparator1);

        jmiContactos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiContactos.setIcon(new javax.swing.ImageIcon("C:\\Users\\ayrton.antonio\\Documents\\NetBeansProjects\\AgeContactos\\src\\main\\java\\img\\contato.png")); // NOI18N
        jmiContactos.setText("Contactos");
        jmiContactos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiContactosActionPerformed(evt);
            }
        });
        jmbArquivo.add(jmiContactos);

        jmbBarraMenu.add(jmbArquivo);

        jmbOpcoes.setIcon(new javax.swing.ImageIcon("C:\\Users\\ayrton.antonio\\Documents\\NetBeansProjects\\AgeContactos\\src\\main\\java\\img\\options.png")); // NOI18N
        jmbOpcoes.setText("Opções");

        jmbIdiomas.setIcon(new javax.swing.ImageIcon("C:\\Users\\ayrton.antonio\\Documents\\NetBeansProjects\\AgeContactos\\src\\main\\java\\img\\language.png")); // NOI18N
        jmbIdiomas.setText("Idiomas");

        jMenuItem2.setText("Portugues");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jmbIdiomas.add(jMenuItem2);

        jMenuItem3.setText("English");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jmbIdiomas.add(jMenuItem3);

        jmbOpcoes.add(jmbIdiomas);

        jmbBarraMenu.add(jmbOpcoes);

        jmbSobre.setIcon(new javax.swing.ImageIcon("C:\\Users\\ayrton.antonio\\Documents\\NetBeansProjects\\AgeContactos\\src\\main\\java\\img\\me.png")); // NOI18N
        jmbSobre.setMnemonic('S');
        jmbSobre.setText("Sobre");
        jmbSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirFormSobre(evt);
            }
        });

        jmbSobreItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jmbSobreItem.setText("Sobre");
        jmbSobreItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmbSobreItemActionPerformed(evt);
            }
        });
        jmbSobre.add(jmbSobreItem);

        jmbBarraMenu.add(jmbSobre);

        setJMenuBar(jmbBarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiContactosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiContactosActionPerformed
        ContactosView tela = new ContactosView();        
        openForm.abrirFormulario(tela, jDesktop);
        
    }//GEN-LAST:event_jmiContactosActionPerformed

    private void jimMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jimMunicipioActionPerformed
        MunicipioView tela = new MunicipioView();
        openForm.abrirFormulario(tela, jDesktop);
    }//GEN-LAST:event_jimMunicipioActionPerformed

    private void jmiBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiBairroActionPerformed
        BairrosView tela = new BairrosView();
        openForm.abrirFormulario(tela, jDesktop);
    }//GEN-LAST:event_jmiBairroActionPerformed

    private void jmiTipoContactosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTipoContactosActionPerformed
        TiposContactosView tela = new TiposContactosView();
        openForm.abrirFormulario(tela, jDesktop);
    }//GEN-LAST:event_jmiTipoContactosActionPerformed

    private void AbrirFormSobre(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirFormSobre
        
    }//GEN-LAST:event_AbrirFormSobre

    private void jmbSobreItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmbSobreItemActionPerformed
        FormSobre tela = new FormSobre();
        openForm.abrirFormulario(tela, jDesktop);
    }//GEN-LAST:event_jmbSobreItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Perferencia.trocarIdioma("pt");
        InternationalizarIdioma();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Perferencia.trocarIdioma("en");
        InternationalizarIdioma();
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    
    private void InternationalizarIdioma(){
        messages = ResourceBundle.getBundle("messages", new Locale(Perferencia.Idioma));
        String arquivo = messages.getString("menu.File");
        jmbArquivo.setText(arquivo);
        jmCadastros.setText(messages.getString("menu.Registrations"));
        jimMunicipio.setText(messages.getString("menu.Counties"));        
        jmiBairro.setText(messages.getString("menu.Neighborhoods"));
        jmiTipoContactos.setText(messages.getString("menu.TypesContacts"));
        jmiContactos.setText(messages.getString("menu.Contacts"));
        
        jmbOpcoes.setText(messages.getString("menu.Options"));
        jmbIdiomas.setText(messages.getString("menu.Languages"));
        
        jmbSobre.setText(messages.getString("menu.About"));        
        jmbSobreItem.setText(messages.getString("menu.About"));

    }

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktop;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem jimMunicipio;
    private javax.swing.JMenu jmCadastros;
    private javax.swing.JMenu jmbArquivo;
    private javax.swing.JMenuBar jmbBarraMenu;
    private javax.swing.JMenu jmbIdiomas;
    private javax.swing.JMenu jmbOpcoes;
    private javax.swing.JMenu jmbSobre;
    private javax.swing.JMenuItem jmbSobreItem;
    private javax.swing.JMenuItem jmiBairro;
    private javax.swing.JMenuItem jmiContactos;
    private javax.swing.JMenuItem jmiTipoContactos;
    // End of variables declaration//GEN-END:variables
}
