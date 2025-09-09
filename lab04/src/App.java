import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
            System.out.println("Consulta de contas!");
            String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.eezzitrfnjebnspdayyl&password=Programaçãodesistemasii";
            Connection con = DriverManager.getConnection(url);

            System.out.println("Conexão ok!");
            Statement smtm = con.createStatement();

            //Consulta
            ResultSet resultado = smtm.executeQuery("SELECT * FROM PROPRIETARIOS");

        
            while (resultado.next()) {
                System.out.println(resultado.getString("ID"));
            }

            //Inserindo
            String sql_insert = "INSERT INTO PROPRIETARIOS (NOME, CPF) VALUES (?,?)";

            PreparedStatement pstmt = con.prepareStatement(sql_insert);

            pstmt.setString(1, "antonio");
            pstmt.setString(2, "658412365-59");

            int qte = pstmt.executeUpdate();
            if(qte >=1){
                System.out.println("Inserido com sucesso!");
            }
            con.close();
        }
    
}