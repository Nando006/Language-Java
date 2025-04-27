package controladora;

import dados.IUsuarioDAO;
import dados.UsuarioDAO;
import negocio.Usuario;

public class ControladorUsuario {
    private IUsuarioDAO dao;
    private Usuario usuarioLogado;

    public ControladorUsuario() {
        this.dao = new UsuarioDAO();
    }

    public void criarConta(String nome, String email, String senha) {
        Usuario novo = new Usuario(nome, email, senha);
        dao.criar(novo);
    }

    public boolean logar(String email, String senha) {
        Usuario u = dao.buscarPorEmail(email);
        if (u != null && u.getSenha().equals(senha)) {
            usuarioLogado = u;
            return true;
        }
        return false;
    }

    public void alterarDados(String novoNome, String novoEmail, String novaSenha) {
        if (usuarioLogado == null) {
            throw new RuntimeException("Usuário não está logado!");
        }
        // Atualiza os dados no objeto
        usuarioLogado.setNome(novoNome);
        usuarioLogado.setEmail(novoEmail);
        usuarioLogado.setSenha(novaSenha);
        // "Atualiza" o objeto na lista
        dao.atualizar(usuarioLogado);
    }

    public void excluirConta() {
        if (usuarioLogado == null) {
            throw new RuntimeException("Usuário não está logado!");
        }
        dao.remover(usuarioLogado);
        usuarioLogado = null;
    }

    public void listarUsuarios() {
        if (usuarioLogado == null) {
            throw new RuntimeException("Usuário não está logado!");
        }
        for (Usuario u : dao.listarTodos()) {
            System.out.println("Nome: " + u.getNome() +
                    ", E-mail: " + u.getEmail());
        }
    }

    public void logout() {
        usuarioLogado = null;
    }

    public boolean isLogado() {
        return usuarioLogado != null;
    }
}