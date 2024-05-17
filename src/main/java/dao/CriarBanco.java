package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CriarBanco {

    public static void main_old(String[] args) {
        String nomeArquivoSql = "C:\\Users\\ayrton.antonio\\Documents\\NetBeansProjects\\AgeContactos\\src\\main\\java\\dao\\criar_banco.sql";
        String nomeBanco = "DBcontactos.db";

        try (Connection conexao = DriverManager.getConnection("jdbc:sqlite:" + nomeBanco);
             Statement stmt = conexao.createStatement();
             Scanner scanner = new Scanner(new File(nomeArquivoSql))) {

            // Lê o conteúdo do arquivo SQL
            StringBuilder sql = new StringBuilder();
            while (scanner.hasNextLine()) {
                sql.append(scanner.nextLine());
            }

            // Executa as instruções SQL no arquivo
            stmt.executeUpdate(sql.toString());

            System.out.println("Banco de dados criado com sucesso.");

        } catch (FileNotFoundException e) {
            System.err.println("Arquivo SQL não encontrado: " + nomeArquivoSql);
        } catch (SQLException e) {
            System.err.println("Erro ao criar o banco de dados: " + e.getMessage());
        }
    }
}
