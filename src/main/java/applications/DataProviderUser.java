package applications;

import models.User;
import models.UserLombok;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {
    @DataProvider
    public static Iterator<Object[]> UserDataProvider() throws IOException {
        List<Object[]> list = new ArrayList<>();
        //BufferedReader reader = new BufferedReader(new FileReader("C:\\QA38\\Trello\\src\\test\\resources\\data.csv.csv"));
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/test.csv"));
        String line = reader.readLine();
        while (line != null) {
            String[] all = line.split(",");//  [or220719@gmail.com] [12345%QWqw]
            list.add(new Object[]{new User().withEmail(all[0]).withPassword(all[1])});
            line = reader.readLine();
        }
        return list.iterator();

    }
    @DataProvider
    public static Iterator<Object[]> UserDataProviderLombok() throws IOException {
        List<Object[]> list = new ArrayList<>();
        //BufferedReader reader = new BufferedReader(new FileReader("C:\\QA38\\Trello\\src\\test\\resources\\data.csv.csv"));
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/test.csv"));
        String line = reader.readLine();
        while (line != null) {
            String[] all = line.split(",");//  [or220719@gmail.com] [12345%QWqw]
            list.add(new Object[]{UserLombok.builder().email(all[0]).password(all[1]).build()});
            line = reader.readLine();
        }
        return list.iterator();

    }

}
