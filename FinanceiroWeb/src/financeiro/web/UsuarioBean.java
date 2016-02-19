package financeiro.web;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import financeiro.usuario.Usuario;
import financeiro.usuario.UsuarioRN;

@ManagedBean(name="usuarioBean")
@RequestScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private String confirmarSenha;
	
	public String novo(){
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "usuario";
	}
	
	public String salvar(){
		FacesContext contex = FacesContext.getCurrentInstance();
		String senha = this.usuario.getSenha();
		if (!senha.equals(this.confirmarSenha)) {
			FacesMessage facemessage = new FacesMessage("A senha n�o foi confirmada corretamente");
			contex.addMessage(null, facemessage);
			return null;
		}
		
		UsuarioRN UsuarioRN = new UsuarioRN();
		UsuarioRN.salvar(this.usuario);
		return "usuarioSucesso";
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getConfirmarSenha() {
		return confirmarSenha;
	}
	public void setConfirmarSenha(String confirmaSenha) {
		this.confirmarSenha = confirmaSenha;
	}
}
