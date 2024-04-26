package cacheline;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class CompilePattern {
    List<Supply> supplyList =
            new ArrayList<Supply>();

    List<Supply> find(String regEx) {
        List<Supply> result = new LinkedList<>();
        for(Supply supply : supplyList) {
            if(Pattern.matches(regEx, supply.toString())){
                result.add(supply);
            }
        }
        return result;
    }

    List<Supply> find(String regEx, boolean precompile) {
        List<Supply> result = new LinkedList<>();
        Pattern p = Pattern.compile(regEx);
        for(Supply supply : supplyList) {
            if(p.matcher(supply.toString()).matches()){
                result.add(supply);
            }
        }
        return result;
    }
}
