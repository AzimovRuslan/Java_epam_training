package by.gsu.epamlab.interfaces;

import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.WeekDay;

import java.util.Map;

public interface EntryChecker<K, V> {
    boolean check(Map.Entry<K, V> entry);
}
