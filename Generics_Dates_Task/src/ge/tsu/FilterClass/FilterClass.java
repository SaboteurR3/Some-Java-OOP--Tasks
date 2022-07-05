package ge.tsu.FilterClass;
import ge.tsu.Certificate;
import ge.tsu.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FilterClass {
    public static Map<Status, List<Certificate>> Sorter(List<Certificate> cerList) {
        Map<Status, List<Certificate>> myMap = new TreeMap<>();
        myMap.put(Status.VALID, new ArrayList<>());
        myMap.put(Status.INVALID, new ArrayList<>());
        // Check certificates status
        for(var cer : cerList){
            if(cer.getExpireDate().isAfter(cer.getIssueDate()))
                myMap.get(Status.VALID).add(cer);
            else
                myMap.get(Status.INVALID).add(cer);
        }
        return myMap;
    }
}