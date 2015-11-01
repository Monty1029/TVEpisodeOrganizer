import java.io.*;
import java.util.*;

public class TVEpisodeOrganizer {
	private File folder;
	
	public TVEpisodeOrganizer(String path) {
		folder = new File(path);
		
	}
	
	public void rename(String path, String name, String ext) {
		File[] listOfFiles = folder.listFiles();
		if (path.charAt(path.length()-1) != '\\') {
			path += "\\";
		}
		if (!ext.contains(".")) {
			ext = "." + ext;
		}
		for (int i = 0; i < listOfFiles.length; i++) {
		      listOfFiles[i].renameTo(new File(path+name+" - "+i+ext));
		}
		
	}

}
