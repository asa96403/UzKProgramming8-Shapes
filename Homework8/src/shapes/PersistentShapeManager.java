package shapes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersistentShapeManager {
	/**
	 * Saves all shapes to the file, one per line, using their toString() format. If
	 * the file already exists, it appends new shapes instead of overwriting it.
	 * 
	 * @param shapes   the Collection of shapes to write into the File
	 * @param filename the filename of the file to be written into
	 * @author aabert
	 */
	public static void saveShapesToFile(Collection<? extends Shape> shapes, String filename) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
			for (Shape s : shapes) {
				writer.write(s.toString());
				writer.newLine();
			}
		} catch (IOException e) {
			System.err.println("While trying to write Shapes to the file, an error occured:");
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Uses BufferedReader to read lines from the file. Each line represents a
	 * shape. Delegates parsing to ShapeFactory.fromString(). Skips malformed lines,
	 * logs them, and returns only valid Shape objects.
	 * 
	 * @param filename the name of the file to read from
	 * @return a List of the shapes constructed from the lines in the file
	 */
	public static List<Shape> loadShapesFromFile(String filename) {
		List<Shape> result = new ArrayList<Shape>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = reader.readLine()) != null) {
				try {
					result.add(ShapeFactory.fromString(line));
				} catch (IllegalArgumentException e) {
					System.err.println("Line: " + line + "could not be converted to a shape. Skipped.");
					System.err.println(e.getMessage());
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("The file to read the shapes from could not be found!");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error occured on closing of BufferedReader after reading the file.");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Clears the contents of the specified file (i.e., truncates it to zero
	 * length), effectively making it empty without deleting the file. This can be
	 * used before saving if overwriting is explicitly desired.
	 * 
	 * @param filename the name of the file to clear
	 * @author aabert
	 */
	static void clearFile(String filename) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) {
			writer.write("");
		} catch (IOException e) {
			System.err.println("An error occured while clearing the File. Please try again");
			System.err.println(e.getMessage());
		}
	}
}
