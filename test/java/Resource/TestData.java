package Resource;

import java.util.ArrayList;
import java.util.List;

import Pojo.GoogleMaps;

public class TestData {
	
	public GoogleMaps testdata(String name, String language, String Address, String website)
	{
		Pojo.GoogleMaps gm = new Pojo.GoogleMaps();
		gm.setAccuracy(50);
		gm.setAddress(Address);
		gm.setLanguage(language);
		Pojo.Location l = new Pojo.Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		gm.setlocation(l);
		gm.setName(name);
		gm.setPhone_number("(+91) 983 893 3937");
		List<String> mylist = new ArrayList<String>();
		mylist.add("Shoe park");
		mylist.add("park");
		gm.setTypes(mylist);
		gm.setWebsite(website);
		return gm;
	}
    
	public static String deleteplaceApi(String place_id)
	{
		return "{\r\n    \"place_id\":\""+place_id+"\"\r\n}\r\n";
	}
}
