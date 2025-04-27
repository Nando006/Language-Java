package dados;


import java.util.ArrayList;
import java.util.List;
import negocio.Usuario;

public class UsuarioDAO implements IUsuarioDAO{
    private static List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void criar(Usuario u){
        if(buscarPorEmail(u.getEmail()) == null) {
            usuarios.add(u);
        } else {
            throw new RuntimeException("E-mil já cadastrado");
        }
    }

    @Override
    public Usuario buscarPorEmail(String email){
        for (Usuario u : usuarios){
            if(u.getEmail().equalsIgnoreCase(email)){
                return u;
            }
        }
        return null;
    }

    @Override
    public void atualizar(Usuario u){
    }

    @Override
    public List<Usuario> listarTodos(){
        return usuarios;
    }

    @Override
    public void remover(Usuario u) {
        usuarios.remove(u);
    }

}
