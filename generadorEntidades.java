import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Scanner;
import java.sql.*;

public class generadorEntidades {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        String nombre = "Profesiones";
        Utilitarios utilitarios = new Utilitarios();
        /* Scanner nombreTabla = new Scanner(System.in);
        String nombre = null;

        Boolean verdadero = true;
        while (verdadero) {
            System.out.println("Ingrese el nombre de la tabla a generar la entidad");
            nombre = nombreTabla.next();

            // System.out.println("asi quedo la palabra " + nombreEntidad);

            if (!nombre.isEmpty()) {
                verdadero = false;

            } else {
                verdadero = true;

            }
        }

        */

        Properties config = new Properties();
        InputStream configInput = null;

        configInput = new FileInputStream("config.properties");
        config.load(configInput);

        String dataSourceUrl = config.getProperty("datasource.url");
        String dataSourceUsername = config.getProperty("datasource.username");
        String dataSourcePassword = config.getProperty("datasource.password");

        System.out.println("CREANDO EL ARCHIVO ENTIDAD... ");

        //
        Connection conexion;
        Statement st;
        String host="localhost", base_de_datos="posold01", usuario="postgres", contraseña="password";
        DatabaseMetaData metadatos;
        ResultSetMetaData rsmetadatos;

        Class.forName("org.postgresql.Driver");

        conexion = DriverManager.getConnection("jdbc:postgresql://"+host+"/"+base_de_datos, usuario, contraseña);

        st = conexion.createStatement();

        System.out.println("Obteniendo Informacion sobre una base de datos...");
        
        System.out.println("\nObteniendo Informacion sobre una consulta con un ResultSet...");
//
        //ResultSet rs = st.executeQuery("select * from cusg."+nombre);

        ResultSet rs = st.executeQuery("select * from cusg.contraparte");
        
        rsmetadatos =  rs.getMetaData();

        int col = rsmetadatos.getColumnCount();

        System.out.println("Columnas: "+col);

        File archivo = new File(nombre);
        utilitarios.deleteFile(archivo);

        if (archivo.mkdir()) {
            System.out.println("   Directorio " + nombre + " creado satisfactoriamente.");

            try (FileWriter fw = new FileWriter(
                    nombre + "/" + archivo + "Entity.java",
                    true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)) {
                out.println("package com.bcv.cusg.profesiones.entity;");
                out.println("");
                out.println("import jakarta.persistence.Column;");
                out.println("import jakarta.persistence.Entity;");
                out.println("import jakarta.persistence.Id;");
                out.println("import jakarta.persistence.ManyToMany;");
                out.println("import jakarta.persistence.OneToMany;");
                out.println("import jakarta.persistence.Table;");
                out.println("import lombok.AllArgsConstructor;");
                out.println("import lombok.Getter;");
                out.println("import lombok.NoArgsConstructor;");
                out.println("import lombok.Setter;");
                out.println("");
                out.println("import java.util.Set;");
                out.println("");
                out.println("import com.fasterxml.jackson.annotation.JsonIgnore;");
                out.println("");
                out.println("@Entity");
                out.println("@Table(schema = \"cusg\", name = \"accion_pregunta\")");
                out.println("@Getter");
                out.println("@Setter");
                out.println("@NoArgsConstructor");
                out.println("@AllArgsConstructor");
                out.println("");
                out.println("public class Profesiones extends Base {");
                out.println("");
                out.println("   private static final long serialVersionUID = 1L;");
                out.println("");
                out.println("   @Id");
                out.println("");
               
                //obteniendo numero de columnas

                String tipo = null;
                for(int i=1;i<=col;i++){
                    //out.println("   @Column(nullable = false, updatable = false, length = 4)");
                    switch(rsmetadatos.getColumnTypeName(i)) {
                        case "varchar":
                          tipo = "String";
                          break;
                        case "date":
                          tipo = "LocalDate";
                          break;
                        case "numeric":
                          tipo = "BigDecimal";
                          break;
                        
                        case "timestamptz":
                          tipo = "OffsetDateTime";
                          break;
                        default:
                         // System.out.println("desconocido");
                      }
                      System.out.println(rsmetadatos.getColumnTypeName(i) + " " +rsmetadatos.getColumnName(i) );
                    out.println("   private "+tipo+" " + rsmetadatos.getColumnName(i) + ";\n");

               
                }
                out.println("");
                out.println("}");

            } catch (IOException e) {
                // exception handling left as an exercise for the reader
            }
        }
        
    }
}
