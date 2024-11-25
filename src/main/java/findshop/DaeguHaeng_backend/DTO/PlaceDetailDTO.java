package findshop.DaeguHaeng_backend.DTO;

public class PlaceDetailDTO {
    String name;//가맹점명
    String attraction;//관광지
    String phoneNum;//전화번호
    String address;//주소
    String url;//imageURL
    public PlaceDetailDTO(String name, String attraction, String phoneNum, String address, String url) {
        this.name = name;
        this.attraction = attraction;
        this.phoneNum = phoneNum;
        this.address = address;
        this.url = url;
    }
}
