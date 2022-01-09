package Resources;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name="InputData")
	public Object[][] getDataforEditField(){
	Object[][] data = new Object[][]
			{
		{"test1"}, {"test2"}
			};
			return data;
	}
	
	@DataProvider(name="SwipeTestData")
	public Object[][] swipeTestData(){
		Object[][] data= new Object[2][3];
		data[0][0] = "10";
		data[0][1] = "25";
		data[0][2] = "55";
		
		data[1][0] = "10";
		data[1][1] = "20";
		data[1][2] = "35";
		return data;
	}
}
