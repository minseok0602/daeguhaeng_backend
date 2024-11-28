package findshop.DaeguHaeng_backend.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ClientDTO {
    private int cluster;
    private int age;
    private String gender;




    @Override
    public String toString() {
        return "ClientInfo{" +
                "cluster=" + cluster +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", spending=" + spending +
                '}';
    }
}