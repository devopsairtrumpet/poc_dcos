package in.aayush.poc.dcos.model;

import java.io.Serializable;

/**
 * Created by ajai20 on 18/05/17.
 */
public class HelloWorld  implements Serializable{

    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
