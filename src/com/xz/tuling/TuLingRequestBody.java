package com.xz.tuling;

import org.apache.http.conn.ssl.PrivateKeyStrategy;

import static com.xz.tuling.TuLingApiUtil.KEY;
import static com.xz.tuling.TuLingApiUtil.USER_ID;

/**
 * @Package: com.xz.tuling
 * @ClassName: TuLingBody
 * @Author: xz
 * @Date: 2020/2/24 23:39
 * @Version: 1.0
 */
public class TuLingRequestBody {

    private int reqType;
    private Perception perception;
    private UserInfo userInfo;
    public int getReqType() {
        return reqType;
    }

    public void setReqType(int reqType) {
        this.reqType = reqType;
    }

    public Perception getPerception() {
        return perception;
    }

    public void setPerception(Perception perception) {
        this.perception = perception;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public TuLingRequestBody(InputText inputText, InputImage inputImage) {
        this.reqType = 0;
        this.userInfo = new UserInfo(KEY,USER_ID);
        this.perception = new Perception(inputText,inputImage,new SelfInfo(new Location("天津市","天津市","佳宁道")));
    }
}
class Perception{
    private InputText inputText;
    private InputImage inputImage;
    private SelfInfo selfInfo;

    public InputText getInputText() {
        return inputText;
    }

    public void setInputText(InputText inputText) {
        this.inputText = inputText;
    }

    public InputImage getInputImage() {
        return inputImage;
    }

    public void setInputImage(InputImage inputImage) {
        this.inputImage = inputImage;
    }

    public SelfInfo getSelfInfo() {
        return selfInfo;
    }

    public void setSelfInfo(SelfInfo selfInfo) {
        this.selfInfo = selfInfo;
    }

    public Perception(InputText inputText, InputImage inputImage, SelfInfo selfInfo) {
        this.inputText = inputText;
        this.inputImage = inputImage;
        this.selfInfo = selfInfo;
    }
}
class UserInfo{
    private String apiKey;
    private String userId;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserInfo(String apiKey, String userId) {
        this.apiKey = apiKey;
        this.userId = userId;
    }
}
class InputText{
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public InputText(String text) {
        this.text = text;
    }
}
class InputImage{
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public InputImage(String url) {
        this.url = url;
    }
}
class SelfInfo{
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public SelfInfo(Location location) {
        this.location = location;
    }
}
class Location{
    private String city;
    private String province;
    private String street;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Location(String city, String province, String street) {
        this.city = city;
        this.province = province;
        this.street = street;
    }
}