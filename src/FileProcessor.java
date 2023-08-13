import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class FileProcessor {

	private String fileName;
	private int stringLength;
	private ArrayList<String> stringList = new ArrayList<String>();
	private Scanner input;

	public FileProcessor(String fileName, int stringLength) {
		setFileName(fileName);
		setStringLength(stringLength);
	}// end empty-argument constructor

	public int getArrayListSize() {
		return stringList.size();
	}// end getArrayListSize

	public void processFile() {
		StringTooLongException tooLongException = new StringTooLongException();
		try {
			input = new Scanner(new File(fileName));
			while (input.hasNext()) {
				String value = input.next();
				if (value.length() > stringLength) {
					throw tooLongException;
				}
				stringList.add(value);
			}
		} catch (FileNotFoundException exc) {
			System.out.println(exc);
		} catch (StringTooLongException exc) {
			System.out.println(exc);
		}
	}// end processFile

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getStringLength() {
		return stringLength;
	}

	public void setStringLength(int stringLength) {
		if (stringLength >= 5) {
			this.stringLength = stringLength;
		} else {
			this.stringLength = 5;
		}
	}

}// end class
