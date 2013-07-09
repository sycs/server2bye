package com.server2bye.core;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

public class BasicToolUtil {

	public static OutputStream convertStringToStream(String string)
			throws IOException {
		byte[] stringByte = string.getBytes();
		ByteArrayOutputStream bos = new ByteArrayOutputStream(string.length());
		bos.write(stringByte);
		return bos;
	}

	public static byte[] convertImageToByteArray(String directory)
			throws IOException {
		byte[] buffer = null;

		File file = new File(directory);
		@SuppressWarnings("resource")
		FileInputStream fis = new FileInputStream(file);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		for (int readNum; (readNum = fis.read(buf)) != -1;) {
			bos.write(buf, 0, readNum);
		}
		buffer = bos.toByteArray();
		return buffer;
	}

	public static File convertByteArrayToImageFile(byte[] byteAry,
			String directory) throws IOException {
		ByteArrayInputStream bis = new ByteArrayInputStream(byteAry);
		Iterator<ImageReader> readers = ImageIO
				.getImageReadersByFormatName("jpg");
		ImageReader reader = (ImageReader) readers.next();
		ImageInputStream iis = ImageIO.createImageInputStream(bis);
		reader.setInput(iis, true);
		ImageReadParam param = reader.getDefaultReadParam();
		Image image = reader.read(0, param);
		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null),
				image.getHeight(null), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = bufferedImage.createGraphics();
		g2.drawImage(image, null, null);
		File imageFile = new File(directory);
		ImageIO.write(bufferedImage, "jpg", imageFile);
		return imageFile;
	}

	public static FileItem createFileItem(String filePath) {
		FileItemFactory factory = new DiskFileItemFactory(16, null);
		String textFieldName = "textField";
		int num = filePath.lastIndexOf(".");
		String extFile = filePath.substring(num);
		FileItem item = factory.createItem(textFieldName, "text/plain", true,
				"MyFileName" + extFile);
		File newfile = new File(filePath);
		int bytesRead = 0;
		byte[] buffer = new byte[2 * 1024 * 1024];
		try {
			FileInputStream fis = new FileInputStream(newfile);
			OutputStream os = item.getOutputStream();
			while ((bytesRead = fis.read(buffer, 0, 2 * 1024 * 1024)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return item;
	}

	public static Object serializeDeserialize(Object target) {

		// Serialize the test object
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(target);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Deserialize the test object
		Object result = null;
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(
					baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			result = ois.readObject();
			bais.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
}
