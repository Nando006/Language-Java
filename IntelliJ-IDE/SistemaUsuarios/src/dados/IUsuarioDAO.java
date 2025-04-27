package dados;

import negocio.Usuario;
import java.util.List;

public interface IUsuarioDAO {
    void criar(Usuario u);
    Usuario buscarPorEmail(String email);
    void atualizar(Usuario u);
    void remover(Usuario u); // <-- Certifique-se de que esse método existe!
    List<Usuario> listarTodos();
}