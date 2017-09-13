package data;

import java.awt.Toolkit;
import java.beans.Statement;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class DataConecta extends javax.swing.JFrame
{
    int idia, imes, iano, fdia, fmes, fano;
    
    ////////////////////////////////CONEXÃO/////////////////////////////////////
    public class Conexao 
    {
        public Statement stm;//RESPONSAVEL POR PREPARAR E REALIZAR PESQUISA NO BANCO DE DADOS
        public ResultSet rs;//RESPONSAVEL POR ARMAZENAR O RESULTADO DE UMA PESQUISA PASSADA PARA O STATEMENT
        private final String driver = "com.mysql.jdbc.Driver";//RESPONSAVEL POR IDENTIFICAR O SERVIÇO DE BANCO DE DADOS

        private static final String caminho = "jdbc:mysql://localhost/data"; // ORACLE: jdbc:oracle:thin:@localhost:1521:xe
        private static final String login = "root";
        private static final String senha = "";

        public Connection conn;//RESPONSAVEL POR REALIZAR A CONEXÃO COM O BANCO DE DADOS

        public void conexao()//MÉTODO RESPONSAVEL POR REALIZAR A CONEXÃO COM O BANCO
        {
            try
            {
                System.setProperty("jdbc.Drivers", driver);//SETA A PROPRIEDADE DO DRIVER DE CONEXÃO
                conn = DriverManager.getConnection(caminho, login, senha);//RESPONSAVEL POR SETAR O LOCAL DO BANCO DE DADOS
                //JOptionPane.showMessageDialog(null, "Conectado com Sucesso!");//IMPRIME UMA CAIXA DE MENSAGEM
            }
            catch(SQLException ex)//EXCESSÃO
            {
                JOptionPane.showMessageDialog(null, "Erro de conexão!\n Erro: " + ex.getMessage());
            }
        }
        
        public void desconecta()//MÉTODO PARA FECHAR A CONEXÃO CM O BANCO DE DADOS
        {
            try
            {
                conn.close();//FECHA A CONEXÃO
            }
            catch(SQLException ex)//EXCESSÃO
            {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão!\n Erro: " + ex.getMessage());//IMPRIME UMA CAIXA DE MENSAGEM
            }
        }
    }
    Conexao conecta = new Conexao();
    ////////////////////////////////////////////////////////////////////////////
    
    public DataConecta()
    {
        initComponents();
        setIcon();
        edite_dia_inicio.setDocument(new SoNumeros());
        edite_mes_inicio.setDocument(new SoNumeros());
        edite_ano_inicio.setDocument(new SoNumeros());
        edite_dia_fim.setDocument(new SoNumeros());
        edite_mes_fim.setDocument(new SoNumeros());
        edite_ano_fim.setDocument(new SoNumeros());
    }
    
    private void setIcon()
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("database.png")));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("dataPU").createEntityManager();
        filtroQuery = java.beans.Beans.isDesignTime() ? null : dataPUEntityManager.createQuery("SELECT f FROM Filtro f");
        filtroList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : filtroQuery.getResultList();
        painel_fundo = new javax.swing.JPanel();
        painel_pesquisa = new javax.swing.JPanel();
        txt_data_inicio = new javax.swing.JLabel();
        edite_dia_inicio = new javax.swing.JTextField();
        txt_data_fim = new javax.swing.JLabel();
        edite_dia_fim = new javax.swing.JTextField();
        btn_pesquisar = new javax.swing.JButton();
        edite_mes_inicio = new javax.swing.JTextField();
        edite_ano_inicio = new javax.swing.JTextField();
        edite_mes_fim = new javax.swing.JTextField();
        edite_ano_fim = new javax.swing.JTextField();
        barra1 = new javax.swing.JLabel();
        barra2 = new javax.swing.JLabel();
        barra3 = new javax.swing.JLabel();
        barra4 = new javax.swing.JLabel();
        txt_titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Filtro por data");
        setResizable(false);

        painel_fundo.setBackground(new java.awt.Color(204, 204, 204));
        painel_fundo.setToolTipText("");

        txt_data_inicio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txt_data_inicio.setText("DATA INICIO");

        edite_dia_inicio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        edite_dia_inicio.setToolTipText("Dia");
        edite_dia_inicio.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        edite_dia_inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edite_dia_inicioMouseClicked(evt);
            }
        });
        edite_dia_inicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edite_dia_inicioKeyReleased(evt);
            }
        });

        txt_data_fim.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txt_data_fim.setText("DATA FINAL");

        edite_dia_fim.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        edite_dia_fim.setToolTipText("Dia (opcional)");
        edite_dia_fim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edite_dia_fimMouseClicked(evt);
            }
        });
        edite_dia_fim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edite_dia_fimKeyReleased(evt);
            }
        });

        btn_pesquisar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn_pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/excel.png"))); // NOI18N
        btn_pesquisar.setToolTipText("Gerar Dados");
        btn_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisarActionPerformed(evt);
            }
        });

        edite_mes_inicio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        edite_mes_inicio.setToolTipText("Mês");
        edite_mes_inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edite_mes_inicioMouseClicked(evt);
            }
        });
        edite_mes_inicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edite_mes_inicioKeyReleased(evt);
            }
        });

        edite_ano_inicio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        edite_ano_inicio.setToolTipText("Ano");
        edite_ano_inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edite_ano_inicioMouseClicked(evt);
            }
        });
        edite_ano_inicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edite_ano_inicioKeyReleased(evt);
            }
        });

        edite_mes_fim.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        edite_mes_fim.setToolTipText("Mês (opcional)");
        edite_mes_fim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edite_mes_fimMouseClicked(evt);
            }
        });
        edite_mes_fim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edite_mes_fimKeyReleased(evt);
            }
        });

        edite_ano_fim.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        edite_ano_fim.setToolTipText("Ano (opcional)");
        edite_ano_fim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edite_ano_fimMouseClicked(evt);
            }
        });
        edite_ano_fim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edite_ano_fimKeyReleased(evt);
            }
        });

        barra1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        barra1.setText("/");

        barra2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        barra2.setText("/");

        barra3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        barra3.setText("/");

        barra4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        barra4.setText("/");

        javax.swing.GroupLayout painel_pesquisaLayout = new javax.swing.GroupLayout(painel_pesquisa);
        painel_pesquisa.setLayout(painel_pesquisaLayout);
        painel_pesquisaLayout.setHorizontalGroup(
            painel_pesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_pesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_pesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_data_fim)
                    .addComponent(txt_data_inicio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_pesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_pesquisaLayout.createSequentialGroup()
                        .addComponent(edite_dia_fim, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(barra2))
                    .addGroup(painel_pesquisaLayout.createSequentialGroup()
                        .addComponent(edite_dia_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(barra1)))
                .addGap(10, 10, 10)
                .addGroup(painel_pesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_pesquisaLayout.createSequentialGroup()
                        .addComponent(edite_mes_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(barra3))
                    .addGroup(painel_pesquisaLayout.createSequentialGroup()
                        .addComponent(edite_mes_fim, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(barra4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_pesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edite_ano_fim, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edite_ano_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painel_pesquisaLayout.setVerticalGroup(
            painel_pesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_pesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_pesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painel_pesquisaLayout.createSequentialGroup()
                        .addGroup(painel_pesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edite_ano_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edite_mes_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edite_dia_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barra1)
                            .addComponent(barra3)
                            .addComponent(txt_data_inicio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painel_pesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edite_ano_fim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edite_mes_fim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edite_dia_fim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barra2)
                            .addComponent(barra4)
                            .addComponent(txt_data_fim))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_titulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txt_titulo.setText("GERADOR DE DADOS");

        javax.swing.GroupLayout painel_fundoLayout = new javax.swing.GroupLayout(painel_fundo);
        painel_fundo.setLayout(painel_fundoLayout);
        painel_fundoLayout.setHorizontalGroup(
            painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_fundoLayout.createSequentialGroup()
                .addGroup(painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_fundoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(painel_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_fundoLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(txt_titulo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painel_fundoLayout.setVerticalGroup(
            painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_titulo)
                .addGap(18, 18, 18)
                .addComponent(painel_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_fundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painel_fundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisarActionPerformed
    conecta.conexao();

    if(edite_dia_fim.getText().equals("") || edite_mes_fim.getText().equals("") || edite_ano_fim.getText().equals(""))
    {
        Calendar data = Calendar.getInstance();
        fdia = data.get(Calendar.DATE);
        fmes = data.get(Calendar.MONTH) + 1;
        fano = data.get(Calendar.YEAR);
    }
    
    System.out.println("INICIO DIA: " +idia);
    System.out.println("INICIO MES: " +imes);
    System.out.println("INICIO ANO: " +iano);
    System.out.println("FIM DIA: " +fdia);
    System.out.println("FIM MES: " +fmes);
    System.out.println("FIM ANO: " +fano);
    
    try 
    {
        String sql = "SELECT id, nome, CONCAT(DAY(data_inicio), '/', MONTH(data_inicio), '/', YEAR(data_inicio)) AS 'data_inicio', CONCAT(DAY(data_fim), '/', MONTH(data_fim), '/', YEAR(data_fim)) AS 'data_fim' FROM filtro WHERE data_inicio >= '"+iano+"-"+imes+"-"+idia+"' AND data_fim <= '"+fano+"-"+fmes+"-"+fdia+"';";                
        PreparedStatement pst = conecta.conn.prepareStatement(sql);
        try (ResultSet resultado = pst.executeQuery())   
        {
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("Relatório");
            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.createCell((short) 0).setCellValue("NOME");
            rowhead.createCell((short) 1).setCellValue("DATA INICIO");
            rowhead.createCell((short) 2).setCellValue("DATA FIM");

            int index = 1;
            while (resultado.next())
            {

                HSSFRow row = sheet.createRow((short) index);
                row.createCell((short) 0).setCellValue(resultado.getString(2));
                row.createCell((short) 1).setCellValue(resultado.getString(3));
                row.createCell((short) 2).setCellValue(resultado.getString(4));

                index++;
            }

            Calendar data = Calendar.getInstance();
            int gdia = data.get(Calendar.DATE);
            int gmes = data.get(Calendar.MONTH) + 1;
            int gano = data.get(Calendar.YEAR);
            String formattedDate;    
            Date date = new Date();
            DateFormat formato = new SimpleDateFormat("HH.mm.ss");
            formattedDate = formato.format(date);
            
            try (FileOutputStream fileOut = new FileOutputStream("C:\\Relatório do dia "+gdia+"."+gmes+"."+gano+" às "+formattedDate+".xls")) 
            {
                wb.write(fileOut);
            }
            System.out.println("Relatório gerado com sucesso!");
            JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!");//IMPRIME UMA CAIXA DE CONFIRMAÇÃO
        }
        conecta.desconecta();
    }  
    catch (SQLException | IOException ex) 
    {
        JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório!");//IMPRIME UMA CAIXA DE ERRO
    } 
    }//GEN-LAST:event_btn_pesquisarActionPerformed

    private void edite_dia_inicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edite_dia_inicioKeyReleased
        String digito = edite_dia_inicio.getText();
        int quantCaracteres = digito.length();
        
        if (quantCaracteres == 2)
        {
            if(Integer.parseInt(digito) > 0 || Integer.parseInt(digito) <= 31)
            {
                idia = Integer.parseInt(edite_dia_inicio.getText());
                edite_mes_inicio.setText(null);
                edite_mes_inicio.requestFocus();
            }
            if(Integer.parseInt(digito) == 0 || Integer.parseInt(digito) > 31)
            {
                edite_dia_inicio.setText(null);
                edite_dia_inicio.requestFocus();
            }
        }
    }//GEN-LAST:event_edite_dia_inicioKeyReleased

    private void edite_dia_inicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edite_dia_inicioMouseClicked
        edite_dia_inicio.setText(null);
    }//GEN-LAST:event_edite_dia_inicioMouseClicked

    private void edite_mes_inicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edite_mes_inicioKeyReleased
        String digito = edite_mes_inicio.getText();
        int quantCaracteres = digito.length();
        
        if (quantCaracteres == 2)
        {
            if(Integer.parseInt(digito) > 0 || Integer.parseInt(digito) <= 12)
            {
                imes = Integer.parseInt(edite_mes_inicio.getText());
                edite_ano_inicio.setText(null);
                edite_ano_inicio.requestFocus();
            }
            if(Integer.parseInt(digito) == 0 || Integer.parseInt(digito) > 12)
            {
                edite_mes_inicio.setText(null);
                edite_mes_inicio.requestFocus();
            }
        }
    }//GEN-LAST:event_edite_mes_inicioKeyReleased

    private void edite_mes_inicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edite_mes_inicioMouseClicked
        edite_mes_inicio.setText(null);
    }//GEN-LAST:event_edite_mes_inicioMouseClicked

    private void edite_ano_inicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edite_ano_inicioKeyReleased
        String digito = edite_ano_inicio.getText();
        int quantCaracteres = digito.length();
        
        if (quantCaracteres == 4)
        {
            Calendar ano = Calendar.getInstance();
            int year = ano.get(Calendar.YEAR);
            
            if(Integer.parseInt(digito) >= 1500 || Integer.parseInt(digito) <= year)
            {
                iano = Integer.parseInt(edite_ano_inicio.getText());
                edite_dia_fim.setText(null);
                edite_dia_fim.requestFocus();
            }
            if(Integer.parseInt(digito) < 1500 || Integer.parseInt(digito) > year)
            {
                edite_ano_inicio.setText(null);
                edite_ano_inicio.requestFocus();
            }
        }
    }//GEN-LAST:event_edite_ano_inicioKeyReleased

    private void edite_ano_inicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edite_ano_inicioMouseClicked
        edite_ano_inicio.setText(null);
    }//GEN-LAST:event_edite_ano_inicioMouseClicked

    private void edite_dia_fimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edite_dia_fimKeyReleased
        String digito = edite_dia_fim.getText();
        int quantCaracteres = digito.length();
        
        if (quantCaracteres == 2)
        {
            if(Integer.parseInt(digito) > 0 || Integer.parseInt(digito) <= 31)
            {
                fdia = Integer.parseInt(edite_dia_fim.getText());
                edite_mes_fim.setText(null);
                edite_mes_fim.requestFocus();
            }
            if(Integer.parseInt(digito) == 0 || Integer.parseInt(digito) > 31)
            {
                edite_dia_fim.setText(null);
                edite_dia_fim.requestFocus();
            }
        }
    }//GEN-LAST:event_edite_dia_fimKeyReleased

    private void edite_dia_fimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edite_dia_fimMouseClicked
        edite_dia_fim.setText(null);
    }//GEN-LAST:event_edite_dia_fimMouseClicked

    private void edite_mes_fimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edite_mes_fimKeyReleased
        String digito = edite_mes_fim.getText();
        int quantCaracteres = digito.length();
        
        if (quantCaracteres == 2)
        {
            if(Integer.parseInt(digito) > 0 || Integer.parseInt(digito) <= 12)
            {
                fmes = Integer.parseInt(edite_mes_fim.getText());
                edite_ano_fim.setText(null);
                edite_ano_fim.requestFocus();
            }
            if(Integer.parseInt(digito) == 0 || Integer.parseInt(digito) > 12)
            {
                edite_mes_fim.setText(null);
                edite_mes_fim.requestFocus();
            }
        }
    }//GEN-LAST:event_edite_mes_fimKeyReleased

    private void edite_mes_fimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edite_mes_fimMouseClicked
        edite_mes_fim.setText(null);
    }//GEN-LAST:event_edite_mes_fimMouseClicked

    private void edite_ano_fimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edite_ano_fimKeyReleased
        String digito = edite_ano_fim.getText();
        int quantCaracteres = digito.length();
        
        if (quantCaracteres == 4)
        {
            Calendar ano = Calendar.getInstance();
            int year = ano.get(Calendar.YEAR);
            
            if(Integer.parseInt(digito) >= 1500 || Integer.parseInt(digito) <= year)
            {
                fano = Integer.parseInt(edite_ano_fim.getText());
                btn_pesquisar.requestFocus();
            }
            if(Integer.parseInt(digito) < 1500 || Integer.parseInt(digito) > year)
            {
                edite_ano_fim.setText(null);
                edite_ano_fim.requestFocus();
            }
        }
    }//GEN-LAST:event_edite_ano_fimKeyReleased

    private void edite_ano_fimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edite_ano_fimMouseClicked
        edite_ano_fim.setText(null);
    }//GEN-LAST:event_edite_ano_fimMouseClicked

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(() -> {
            new DataConecta().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barra1;
    private javax.swing.JLabel barra2;
    private javax.swing.JLabel barra3;
    private javax.swing.JLabel barra4;
    private javax.swing.JButton btn_pesquisar;
    private javax.persistence.EntityManager dataPUEntityManager;
    private javax.swing.JTextField edite_ano_fim;
    private javax.swing.JTextField edite_ano_inicio;
    private javax.swing.JTextField edite_dia_fim;
    private javax.swing.JTextField edite_dia_inicio;
    private javax.swing.JTextField edite_mes_fim;
    private javax.swing.JTextField edite_mes_inicio;
    private java.util.List<data.Filtro> filtroList;
    private javax.persistence.Query filtroQuery;
    private javax.swing.JPanel painel_fundo;
    private javax.swing.JPanel painel_pesquisa;
    private javax.swing.JLabel txt_data_fim;
    private javax.swing.JLabel txt_data_inicio;
    private javax.swing.JLabel txt_titulo;
    // End of variables declaration//GEN-END:variables
}

//create database data;
//
//use data;
//
//-- drop table filtro;
//
//CREATE TABLE filtro (   
//id	int NOT NULL auto_increment, 
//nome varchar (50) not null,	
//data_inicio date NOT NULL, 
//data_fim date, 
//PRIMARY KEY (id) );
//
//INSERT INTO filtro VALUES (null, 'felipe', '2000-01-01', '2014-03-31');
//INSERT INTO filtro VALUES (null, 'luiz', '2001-11-01', NULL);
//INSERT INTO filtro VALUES (null, 'maria', '2002-10-01', '2015-02-11');
//INSERT INTO filtro VALUES (null, 'joao', '2002-08-05', NULL);
//INSERT INTO filtro VALUES (null, 'paulo', '2008-09-09', NULL);
//INSERT INTO filtro VALUES (null, 'lucas', '2009-07-01', '2012-02-20');
//INSERT INTO filtro VALUES (null, 'tiago', '2010-02-11', '2014-10-15');
//INSERT INTO filtro VALUES (null, 'tais', '2013-01-11', NULL);
//INSERT INTO filtro VALUES (null, 'samuel', '2011-09-10', NULL);
//INSERT INTO filtro VALUES (null, 'mateus', '2005-04-25', NULL);
//INSERT INTO filtro VALUES (null, 'rafael', '2014-03-21', '2014-10-11');
//
//select * from filtro;
//
//SELECT nome, concat(DAY(data_inicio),'/',MONTH(data_inicio),'/',YEAR(data_inicio)) as 'data_inicio', concat(DAY(data_fim),'/',MONTH(data_fim),'/',YEAR(data_fim)) as 'data_fim' FROM filtro WHERE data_inicio >= '2000-01-01' AND data_fim <= '2016-01-01';