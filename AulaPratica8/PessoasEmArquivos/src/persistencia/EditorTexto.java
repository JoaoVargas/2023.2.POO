package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class EditorTexto {
    public void gravaTexto(String caminho, List<String> dados){
        FileWriter arq;

        try {
            arq = new FileWriter(caminho);

            for (int i = 0; i < dados.size(); i++) {
                arq.write(dados.get(i) + "\n");
            }

            arq.close();

        } catch (Exception e) {
            System.err.println("Erro: Abrir/manipular arquivo de gravação.");
            System.exit(0);
        }
    }

    public void gravaTexto(String caminho, String linha){
        FileWriter arq;

        try {
            arq = new FileWriter(caminho, true);

            arq.write(linha);

            arq.close();

        } catch (Exception e) {
            System.err.println("Erro: Abrir/manipular arquivo de gravação.");
            System.exit(0);
        }
    }

    public List<String> lerTexto(String caminho){
        List<String> dados = new LinkedList<String>();

        FileReader arq;
        BufferedReader lerArg;

        try {
            arq = new FileReader(caminho);
            lerArg = new BufferedReader(arq);
            String s = lerArg.readLine();

            while (s != null){
                dados.add(s);
                s = lerArg.readLine();
            }

            arq.close();
        } catch (Exception e) {
            System.err.println("Erro: Abrir/manipular arquivo de leitura.");
            System.exit(0);
        }

        return dados;
    }
}
