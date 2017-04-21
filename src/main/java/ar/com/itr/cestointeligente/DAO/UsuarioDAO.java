package ar.com.itr.cestointeligente.DAO;

import java.util.List;

import ar.com.itr.cestointeligente.entities.Usuario;
import ar.com.itr.cestointeligente.entities.UsuarioTotem;

public interface UsuarioDAO {
	Usuario getByNombreUsuarioYPassword(String nombreUsuario, String password);

	Usuario getByNombreUsuario(String nombreUsuario);
	
     void create(String nombre, String password, String apellido, String telefono, String nombre_usuario, int grupo_id );
     
     void delete(Integer id);
     
     void update(String nombre, String password, String apellido, String telefono, String nombre_usuario, int grupo_id );
     
     List<Usuario> listaUsuarios();

	void update(int id, String nombre, String password, String apellido, String telefono, String nombre_usuario,
			int grupo_id);

	Usuario getById(int id);
	UsuarioTotem getByCodeqr(String codigoqr);
	
	void create(String nombre, String password, String apellido, String telefono, String nombre_usuario,
			int grupo_id, String codigo_qr, String email);
}