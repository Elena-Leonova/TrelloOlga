package applications;

import models.Board;
import models.BoardLombok;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
    @DataProvider
    public static Iterator<Object[]> example(){           //example
        List<Object[]> list = new ArrayList<>();

        return list.iterator();

    }
    @DataProvider
    public static Iterator <Object[]>boardData(){           //String
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"test qa19w1"});
        list.add(new Object[]{"test qa19w2"});
        list.add(new Object[]{"qa19"});
        list.add(new Object[]{"qa19 1"});

        return list.iterator();

    }
    @DataProvider
    public static Iterator<Object[]>boardModelLomData(){     //Model Lombok
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{BoardLombok.builder().name("test qa19L1").build()});
        list.add(new Object[]{BoardLombok.builder().name("test qa19L2").build()});
        return list.iterator();
    }
    @DataProvider
    public static Iterator<Object[]> boardMoodelClassicData(){   //Model with set,get
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new Board().withName("test qa19C1")});
        list.add(new Object[]{new Board().withName("test qa19C2")});

        return list.iterator();

    }
}
