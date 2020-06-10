package ConectaBD;
import java.sql.*;


public class Conecta_EntreculturasBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			// Creación de conexión
			Connection conexionBD = DriverManager.getConnection("jdb:mysql://localhost:3306/entreculturas", "root", "");
			
			//Creacion de objeto statement
			Statement statementBD = conexionBD.createStatement();
			
			//Ejecución de instrucción SQL
			ResultSet resultSetBD =  statementBD.executeQuery("SELECT*FROM VOLUNTARIO");
			
			//Recorrido del Resultset
			while(resultSetBD.next()) {
				
				System.out.println(resultSetBD.getString("idvoluntario"));
			}
			
		}catch(Exception e) {
			
			System.out.println("Imposible conectar con la base de datos");
			
			//Imprime el motivo del error
			e.printStackTrace();
		}

	}

}
