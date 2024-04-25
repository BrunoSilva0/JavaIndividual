package sistema.app;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Criptografia {
    private BCryptPasswordEncoder passwordEncoder;

    public Criptografia() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String criptografarSenha(String senha) {
        return passwordEncoder.encode(senha);
    }

    public boolean autenticarSenha(String senha, String senhaCriptografada) {
        return passwordEncoder.matches(senha, senhaCriptografada);
    }
}