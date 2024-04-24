import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Criptografia {
    private String senhaCriptografada;
    private byte[] salt;

    public Criptografia() {
    }

    public Criptografia(String senhaCriptografada, byte[] salt) {
        this.senhaCriptografada = senhaCriptografada;
        this.salt = salt;
    }

    // Gera um salt aleatório
    private byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    // Converte um array de bytes para uma string hexadecimal
    private String toHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public String criptografarSenha(String senha) {
        this.salt = generateSalt();
        String hashed = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(this.salt);
            byte[] bytes = md.digest(senha.getBytes());
            hashed = toHexString(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        this.senhaCriptografada = hashed;
        return hashed;
    }

    public Boolean autenticarSenha(String senha) {
        String hashed = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(this.salt);
            byte[] bytes = md.digest(senha.getBytes());
            hashed = toHexString(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return this.senhaCriptografada.equals(hashed);
    }
}
