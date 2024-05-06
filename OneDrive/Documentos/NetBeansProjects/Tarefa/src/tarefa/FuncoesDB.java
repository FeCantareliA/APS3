package tarefa;

import java.sql.*;
public class FuncoesDB {
    public Connection conexaoDB(String dbnome, String user, String pass){
     Connection con = null;
     try{
         Class.forName("org.postgresql.Driver");
         con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbnome,user,pass);
         if (con !=null) {
             System.out.println("Conex�o estabelecida");
         } else{
             System.out.println("Falha na conex�o");
         }
     }catch(Exception e){
         System.out.println(e);
     }
        return con;
    }
    public void createTable(Connection con, String tbnome){
        Statement statement;
        try{
                String cria = "CREATE TABLE "+tbnome+"(id SERIAL PRIMARY KEY, nome VARCHAR(255), endere�o VARCHAR (255);";
                statement =con.createStatement();
                statement.executeUpdate(cria);
                System.out.println("Tabela criada");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void insertTB (Connection con, String tbnome, String nome, String endereco){
        Statement statement;
        try{
            String cria= String.format("INSERT INTO %s(nome,endere�o) VALUES ('%s',('%s');",tbnome,nome,endereco);
            statement =con.createStatement();
            statement.executeUpdate(cria);
            System.out.println("Realizado inser��o.");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void read(Connection con, String tbnome){
       Statement statement;
       ResultSet rs=null;
        try{
            String cria= String.format("SELECT * FROM %s ;",tbnome);
            statement =con.createStatement();
            rs=statement.executeQuery(cria);
            while(rs.next()){
                System.out.print(rs.getString("id"+" "));
                System.out.print(rs.getString("Nome"+" "));
                System.out.println(rs.getString("Endere�o"+" "));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void updateNome(Connection con, String tbnome, String nomeVelho,String nomeNovo){
        Statement statement;
        try{
            String cria= String.format("UPDATE %s SET name=%s WEHRE name=%s ;",tbnome,nomeNovo,nomeVelho);
            statement =con.createStatement();
            statement.executeUpdate(cria);
            System.out.println("Realizado atualiza��o.");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    //exemplo delete basta copiar e colar com algumas mudan�as para outras situa��es
    public void deleteNome(Connection con, String tbnome, String nome){
        Statement statement;
        try{
            String cria= String.format("DELETE FROM %s WHERE name=%s ;",tbnome,nome);
            statement =con.createStatement();
            statement.executeUpdate(cria);
            System.out.println("Realizado exclus�o.");
        }catch(Exception e){
            System.out.println(e);
        }
    }
        
        
    }

