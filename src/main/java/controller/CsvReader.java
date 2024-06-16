package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

//public class CsvReader {
//
//	   public <T> List<T> readCsv(File csvFile, Class<T> clazz) throws IOException {
//		List<CsvBean> csvBeans = new ArrayList<>();
//		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
//			String line;
//			while ((line = br.readLine()) != null) {
//				String[] values = line.split(",");
//				if (values.length == 2) {
//					int id = Integer.parseInt(values[0]);
//					String name = values[1];
//					CsvBean csvBean = new CsvBean();
//					csvBean.setId(id);
//					csvBean.setName(name);
//					csvBeans.add(csvBean);
//				}
//			}
//		}
//		return csvBeans;
//	}
//}

public class CsvReader {
    public <T> List<T> readCsv(File csvFile, Class<T> clazz) throws IOException {
        List<T> csvDataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            String[] headers = null;
            if ((line = br.readLine()) != null) {
                headers = line.split(",");
            }
            if (headers == null) {
                throw new IOException("CSV file is empty or has no headers");
            }

            Constructor<T> constructor = clazz.getConstructor();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                T obj = constructor.newInstance();
                for (int i = 0; i < values.length; i++) {
                    String header = headers[i];
                    String value = values[i];
                    Field field = clazz.getDeclaredField(header);
                    field.setAccessible(true);
                    if (field.getType() == int.class) {
                        field.setInt(obj, Integer.parseInt(value));
                    } else if (field.getType() == String.class) {
                        field.set(obj, value);
                    }
                }
                csvDataList.add(obj);
            }
        } catch (Exception e) {
            throw new IOException("Failed to parse CSV file", e);
        }
        return csvDataList;
    }
}

