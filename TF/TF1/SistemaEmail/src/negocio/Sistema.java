package negocio;

import dados.*;

import java.util.LinkedList;
import java.util.Objects;

public class Sistema {
    private int numUsuarios;
    private int numEmails;
    private Usuario usuarioLogado;

    private LinkedList<Usuario> listaUsuarios;

    public int getNumUsuarios() {
        return numUsuarios;
    }
    public int getNumEmails() {
        return numEmails;
    }
    public LinkedList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public Sistema() {
        this.numUsuarios = 0;
        this.numEmails = 0;
        this.usuarioLogado = null;
        this.listaUsuarios = new LinkedList<>();
    }

    public boolean cadastrarUsuario(Usuario u){
        if (numUsuarios != 0){
            for (Usuario usuario : this.listaUsuarios) {
                if (Objects.equals(u.getEmail(), usuario.getEmail())){
                    return false;
                }
            }
        }

        try {
            u.setIdUsuario(this.numUsuarios);
            this.listaUsuarios.add(u);
            this.numUsuarios++;
            return true;
        } catch (Exception err){
            return false;
        }
    }

    public boolean logarUsuario(String email, String senha){
        if (numUsuarios == 0) {
            return false;
        }

        for (Usuario u : listaUsuarios) {
            if (Objects.equals(email, u.getEmail())){
                if (u.verificarSenha(senha)) {
                    this.usuarioLogado = u;
                    return true;
                } else {
                    return false;
                }
            }
        }

        return false;
    }
    public boolean deslogarUsuario(){
        try {
            this.usuarioLogado = null;
            return true;
        } catch (Exception err){
            return false;
        }
    }

    public String verEmailsRecebidos() {
        if (this.usuarioLogado == null){
            return "Erro usuario não logado.";
        }

        return usuarioLogado.listarEmailsRecebidos();
    }
    public String verEmailsEnviados() {
        if (this.usuarioLogado == null){
            return "Erro usuario não logado.";
        }

        return usuarioLogado.listarEmailsEnviados();
    }

    public boolean enviarEmail(Email e){
        if (this.usuarioLogado == null || this.numUsuarios < 2){
            return false;
        }

        for (Usuario u : listaUsuarios) {
            if (Objects.equals(e.getDestinatario(), u.getEmail())){
                try {
                    e.setIdEmail(this.numEmails);
                    this.numEmails++;
                    u.emailRecebido(e);
                    this.usuarioLogado.emailEnviado(e);
                    return true;
                } catch (Exception err) {
                    return false;
                }
            }
        }

        return false;
    }

    public boolean excluirEmailRecebido(int id){
        if (numEmails == 0 || this.usuarioLogado == null){
            return false;
        }

        for (Email e : usuarioLogado.getEmailsRecebidos()) {
            if (e.getIdEmail() == id){
                return usuarioLogado.getEmailsRecebidos().remove(e);
            }
        }
        return false;
    }

    public boolean responderEmail(int id, Email resposta){
        if (numEmails == 0 || this.usuarioLogado == null){
            return false;
        }

        for (Email e : usuarioLogado.getEmailsRecebidos()) {
            if (e.getIdEmail() == id){
                try {
                    resposta.setIdEmail(this.numEmails);
                    this.numEmails++;

                    usuarioLogado.emailEnviado(resposta)
                }
            }
        }
//        TO AQUI

        return false;
    }


}
