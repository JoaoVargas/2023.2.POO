package persistencia;

import dados.Pessoa;

import java.util.LinkedList;
import java.util.List;

public class ArquivoPessoaDAO {
    private final String caminho = "/home/jotausr/Desktop/pessoas.csv";
    private static EditorTexto arquivo = new EditorTexto();

    private String toCSV(Pessoa p){
        return "%s, %s, %s, %s".formatted(p.getNome(), p.getIdade(), p.getAltura(), p.getMassa());
    }

    private Pessoa fromCSV(String linhaCSV){
        String[] atributos = linhaCSV.split(",");

        Pessoa p = new Pessoa();
        p.setNome(atributos[0]);
        p.setIdade(tryParseInt(atributos[1]));
        p.setAltura(tryParseInt(atributos[2]));
        p.setMassa(tryParseInt(atributos[3]));

        return p;
    }

    private List<String> listaPessoaToString(List<Pessoa> pessoas){
        List<String> arquivo = new LinkedList<String>();

        for (Pessoa p : pessoas){
            arquivo.add(toCSV(p));
        }

        return arquivo;
    }

    private List<Pessoa> stringToListaPessoa(List<String> arquivo){
        List<Pessoa> pessoas = new LinkedList<Pessoa>();

        for (String linha : arquivo) {
            pessoas.add(fromCSV(linha));
        }

        return pessoas;
    }

    public List<Pessoa> lePessoasArquivo() {
        return stringToListaPessoa(arquivo.lerTexto(caminho));
    }

    public void salvaPessoasArquivo(List<Pessoa> pessoas){
        arquivo.gravaTexto(caminho, listaPessoaToString(pessoas));
    }

    public void salvaPessoaArquivo(Pessoa pessoa){
        arquivo.gravaTexto(caminho, toCSV(pessoa));
    }

    private static int tryParseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }

}
