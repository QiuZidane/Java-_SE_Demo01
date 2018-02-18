package json;

import java.awt.CardLayout;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class UserBean {

	@SerializedName("NAME")
	private String name;
	@SerializedName("age111") // 指定age属性在json字符串中的key值
	private short age;
	private transient String ignore; // transient声明的属性不会生成到json中
	private String birthDay;
	private List<String> dataList;
	private Map<String,String> dataMap;

	public Map<String, String> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, String> dataMap) {
		this.dataMap = dataMap;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public List<String> getDataList() {
		return dataList;
	}

	public void setDataList(List<String> dataList) {
		this.dataList = dataList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getAge() {
		return age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	public String getIgnore() {
		return ignore;
	}

	public void setIgnore(String ignore) {
		this.ignore = ignore;
	}
	
	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {

		return "name = " + name + "\nage = " + age + "\nignore = " + ignore + "\nbirthDay = "
				+ birthDay;

	}

}
