package main.java.lesson15.ReadText;


import java.io.*;

public class Storage implements DataOperation {

    @Override
    public final ListBook readFile(ListBook list) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(CreateFile.getFilePath(), "ListBook.txt"));
            if (fileInputStream.available() > 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                list = (ListBook) objectInputStream.readObject();

                objectInputStream.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Извините, технические неполадки1.");
            System.exit(1);
        }
        return list;
    }


    @Override
    public final ListBook writeFile(ListBook list) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(CreateFile.getFilePath(), "ListBook.txt"));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Извините, технические неполадки.");
        }
        return list;
    }
}


