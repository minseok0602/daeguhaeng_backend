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
    private Map<String, Double> spending; // 금액 항목별로 저장

    // Getters and Setters
    public int getCluster() {
        return cluster;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Map<String, Double> getSpending() {
        return spending;
    }

    public void setSpending(Map<String, Double> spending) {
        this.spending = spending;
    }

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