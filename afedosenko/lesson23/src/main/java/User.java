import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.Base64;

public class User implements Externalizable {
  private String username;
  private String password;

  public User(String username, String password) {
    this.username = username;
    this.password = password;

  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public User() {}

  @Override
  public void writeExternal(ObjectOutput out) throws IOException {
    out.writeObject(username);
    out.writeObject(encrypt(password));
  }

  private String encrypt(String password) {
    return new String(Base64.getEncoder().encode(password.getBytes()));
  }

  @Override
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    username = (String) in.readObject();
    password = decrypt((String) in.readObject());
  }

  private String decrypt(String s) {
    return new String(Base64.getDecoder().decode(s));
  }


}
