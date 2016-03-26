package support.datas;

import java.io.File;
import java.io.IOException;

public class DataProvider {

	/**function get file's path of a file in input folder
	 * 
	 * @param fileName
	 * @return path
	 */
	public String getInputFile(String fileName) {

		String path = System.getProperty("user.dir");
		path = path + File.separator + "src" + File.separator + "test"
				+ File.separator + "data" + File.separator + "input"
				+ File.separator + fileName;
		File file = new File(path);
		if (file.exists())
			return path;
		return null;

	}

	/**function get file's path of a file in reference folder
	 * 
	 * @param fileName
	 * @return path
	 */
	public String getReferencesFile(String fileName){
		
		String path = System.getProperty("user.dir");
		//File dir = new File(path); path = dir.getPath() + File.separator + "src"
		path = path + File.separator + "src" 
				+ File.separator + "test" + File.separator + "references"
				+ File.separator + fileName;
		return path ;
	
	}
	
	
	/**function get file's path of a file in output folder
	 * 
	 * @return path
	 */
	public String getOutputFile(String fileName){
		String path = System.getProperty("user.dir");
		
		//File dir = new File(path);
		path = path + File.separator + "src" 
				+ File.separator + "test" + File.separator + "data" + File.separator + "output"
				+ File.separator + fileName;
		return path ;
	
	}
	
	/**function get file's path of a file in output folder
	 * 
	 * @return path
	 */
	public String getOutputDirectory(){
		String path = System.getProperty("user.dir");
		
		//File dir = new File(path);
		path = path + File.separator + "src" 
				+ File.separator + "test" + File.separator + "data" + File.separator + "output";
		return path ;
	}
	
	public String getPropertiesFile() throws IOException {

		String path = System.getProperty("user.dir")
						+ File.separator + "src"
						+ File.separator + "test"
						+ File.separator + "resources"
						+ File.separator +"properties"
						+ File.separator
						+ "objects.properties";
		return path;
	}

	
}