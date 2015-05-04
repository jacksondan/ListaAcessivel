package fafica.listaacessivel.uimobile;

public class Login {
	
    private String email;
    private String senha;

    public Login(){}

    public Login(String email, String senha){
        this.email = email;
        this.senha = senha;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
