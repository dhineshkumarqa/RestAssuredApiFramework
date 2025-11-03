package Resource;

public enum APIresource 
{
	Addplace("/maps/api/place/add/json"),
	getplace("/maps/api/place/get/json"),
	deleteplace("/maps/api/place/delete/json");
	
	 String resource;
	 
	APIresource(String resource) {

       this.resource = resource;
	}


	public String getresource()
	{
		return resource;
	}

}

