package util;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {


    @DataProvider
    public Iterator<Object[]> newContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{ "Victor", "Curt","The school teacher"});
        list.add(new Object[]{ "Leonard", "Bert","My friend"});
        list.add(new Object[]{ "Max", "Root","The customer"});
        return list.listIterator();
    }
    @DataProvider
    public Iterator<Object[]> newContactWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));
        String line = reader.readLine();
        while (line!= null) {
            String[] split = line.split(",");
            list.add(new Object[]{split[0], split[1], split[2]});
            line = reader.readLine();
        }
        return list.listIterator();
    }
}
