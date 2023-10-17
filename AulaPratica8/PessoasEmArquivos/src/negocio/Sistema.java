package negocio;

import dados.Pessoa;
import persistencia.PessoaDAO;

import java.util.List;

public class Sistema {
    private PessoaDAO pessoaDAO = new PessoaDAO();

    public void adicionarPessoa(Pessoa pessoa){
        pessoaDAO.insert(pessoa);
    }

    public void removerPessoa(Pessoa pessoa){
        pessoaDAO.delete(pessoa);
    }

    public List<Pessoa> getLista(){
        return pessoaDAO.getAll();
    }
}
